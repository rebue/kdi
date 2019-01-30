package rebue.kdi.mo;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

/**
模板字典

数据库表: KDI_TEMPLATE_DIC

@mbg.generated 自动生成的注释，如需修改本注释，请删除本行
*/
@JsonInclude(Include.NON_NULL)
public class KdiTemplateDicMo implements Serializable {
    /**
    模板字典ID
    
    数据库字段: KDI_TEMPLATE_DIC.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long id;

    /**
    快递公司字典ID
    
    数据库字段: KDI_TEMPLATE_DIC.COMPANY_DIC_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long companyDicId;

    /**
    模板名称
    
    数据库字段: KDI_TEMPLATE_DIC.NAME
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private String name;

    /**
    模板图片路径
    
    数据库字段: KDI_TEMPLATE_DIC.IMG_PATH
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private String imgPath;

    /**
    模板路径
    
    数据库字段: KDI_TEMPLATE_DIC.PATH
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private String path;

    /**
    
    数据库字段: KDI_TEMPLATE_DIC.REMARK
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private String remark;

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
    模板字典ID
    
    数据库字段: KDI_TEMPLATE_DIC.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getId() {
        return id;
    }

    /**
    模板字典ID
    
    数据库字段: KDI_TEMPLATE_DIC.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setId(Long id) {
        this.id = id;
    }

    /**
    快递公司字典ID
    
    数据库字段: KDI_TEMPLATE_DIC.COMPANY_DIC_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getCompanyDicId() {
        return companyDicId;
    }

    /**
    快递公司字典ID
    
    数据库字段: KDI_TEMPLATE_DIC.COMPANY_DIC_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setCompanyDicId(Long companyDicId) {
        this.companyDicId = companyDicId;
    }

    /**
    模板名称
    
    数据库字段: KDI_TEMPLATE_DIC.NAME
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public String getName() {
        return name;
    }

    /**
    模板名称
    
    数据库字段: KDI_TEMPLATE_DIC.NAME
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    模板图片路径
    
    数据库字段: KDI_TEMPLATE_DIC.IMG_PATH
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public String getImgPath() {
        return imgPath;
    }

    /**
    模板图片路径
    
    数据库字段: KDI_TEMPLATE_DIC.IMG_PATH
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    /**
    模板路径
    
    数据库字段: KDI_TEMPLATE_DIC.PATH
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public String getPath() {
        return path;
    }

    /**
    模板路径
    
    数据库字段: KDI_TEMPLATE_DIC.PATH
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setPath(String path) {
        this.path = path;
    }

    /**
    
    数据库字段: KDI_TEMPLATE_DIC.REMARK
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public String getRemark() {
        return remark;
    }

    /**
    
    数据库字段: KDI_TEMPLATE_DIC.REMARK
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", companyDicId=").append(companyDicId);
        sb.append(", name=").append(name);
        sb.append(", imgPath=").append(imgPath);
        sb.append(", path=").append(path);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        KdiTemplateDicMo other = (KdiTemplateDicMo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        ;
    }

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }
}