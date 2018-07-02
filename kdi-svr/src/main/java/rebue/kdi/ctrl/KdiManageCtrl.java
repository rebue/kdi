package rebue.kdi.ctrl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.MultipartConfigElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import rebue.kdi.mo.KdiCompanyMo;
import rebue.kdi.mo.KdiLogisticMo;
import rebue.kdi.ro.AddkdiCompanyRo;
import rebue.kdi.svc.KdiCompanySvc;
import rebue.kdi.svc.KdiLogisticSvc;
import rebue.kdi.svc.KdiSenderSvc;
import rebue.kdi.to.ListKdiLogisticTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class KdiManageCtrl {

	/**
	 */
	private final static Logger _log = LoggerFactory.getLogger(KdiManageCtrl.class);

	/**
	 */
	@Resource
	private KdiLogisticSvc kdiLogisticSvc;

	@Resource
	private KdiCompanySvc kdiCompanySvc;

	@Resource
	private KdiSenderSvc kdiSenderSvc;

	/**
	 * 根据条件查询订单信息 Title: list Description:
	 * 
	 * @param mo
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @date 2018年3月28日 下午3:06:09
	 */
	@GetMapping("/kid/manage/logistic")
	List<KdiLogisticMo> kdiLogisticList(ListKdiLogisticTo to) {
		_log.info("list KdiLogisticMo:" + to);
		//如果下单结束时间不为空，将其加一天，以防开始和结束时间重合查询不到数据
		if( to.getOrderTimeEnd()!=null & !"".equals(to.getOrderTimeEnd())) {
			String endTime=to.getOrderTimeEnd()+" 23:59:59";
			to.setOrderTimeEnd(endTime);
		}
		List<KdiLogisticMo> result = kdiLogisticSvc.kdiLogisticList(to);
		_log.info("result: " + result);
		return result;
	}

	/**
	 * 添加快递公司
	 * 
	 * @param mo
	 * @return
	 */
	@PostMapping("/kdi/company/add")
	AddkdiCompanyRo addkdiCompany(KdiCompanyMo mo) {
		_log.info("添加快递公司的参数为: {}", mo);
		return kdiCompanySvc.exAdd(mo);
	}

	/**
	 * 读取excel表
	 * 
	 * @param excelFile
	 * @param rowNum
	 * @return
	 * @throws Exception
	 * @throws IOException
	 */
	public List<String[]> readExcel(File excelFile, int rowNum) throws Exception, IOException {
		List<String[]> list = new ArrayList<String[]>();
		Workbook rwb = null;
		Cell cell = null;
		InputStream stream = new FileInputStream(excelFile);
		// 获取Excel文件对象
		rwb = Workbook.getWorkbook(stream);
		// 获取文件的指定工作表 默认的第一个
		Sheet sheet = rwb.getSheet(0);
		// 行数(表头的目录不需要，从1开始)
		for (int i = rowNum - 1; i < sheet.getRows(); i++) {
			String[] str = new String[sheet.getColumns()];
			for (int j = 0; j < sheet.getColumns(); j++) {
				cell = sheet.getCell(j, i);
				str[j] = cell.getContents();
			}
			list.add(str);
		}
		return list;
	}

	/**
	 * 上传excel表
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/kdi/excel")
	Map<String, Object> uploadExcel(@RequestParam(value = "filename") MultipartFile file) throws Exception {
		Map<String, Object> result = new HashMap<>();
		_log.info("上传文件名和格式为:" + file.getOriginalFilename());
		if(!file.getOriginalFilename().endsWith("xls") && !file.getOriginalFilename().endsWith("xlsx")) {
			result.put("msg", "文件格式");			
			return result;
		}
		// 创建临时文件夹
		MultipartConfigFactory factory = new MultipartConfigFactory();
		String location = System.getProperty("user.dir") + "/data/temp";
		File tmpFile = new File(location);
		if (!tmpFile.exists()) {
			tmpFile.mkdirs();
		}
		factory.setLocation(location);
		MultipartConfigElement tempPath = factory.createMultipartConfig();
		_log.info("临时文件夹路径" + tempPath.getLocation());
		if (file.isEmpty()) {
			result.put("msg", "文件为空不能上传");
		}
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(tempPath.getLocation() + "/" + file.getOriginalFilename());
			Files.write(path, bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		result.put("msg", "文件上传成功");
		_log.info("文件上传成功");

		// 读取excel
		String excelFileName = tempPath.getLocation() + "/" + file.getOriginalFilename();
		_log.info("文件全路径" + excelFileName);
		List<String[]> list = null;
		try {
			list = readExcel(new File(excelFileName), 1);
			for (int i = 0; i < list.size(); i++) {
				String[] str = (String[]) list.get(i);
				_log.info("excel表数据list" + Arrays.asList(str));
			}
			_log.info(list.toString());
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 删除临时创建的文件
		File delTempFile = new File(tempPath.getLocation() + "/" + file.getOriginalFilename());
		if (delTempFile.exists() && delTempFile.isFile()) {
			if (delTempFile.delete()) {
				_log.info("临时文件删除成功");
			}
		} else {
			_log.info("临时文件删除失败");
		}
		result.put("list", list);
		return result;
	}

}