package rebue.kdi.mo;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

/**
快递公司字典

数据库表: KDI_COMPANY_DIC

@mbg.generated 自动生成的注释，如需修改本注释，请删除本行
*/
@JsonInclude(Include.NON_NULL)
public class KdiCompanyDicMo implements Serializable {
    /**
    快递公司信息ID
    
    数据库字段: KDI_COMPANY_DIC.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long id;

    /**
    快递公司名称
    
    数据库字段: KDI_COMPANY_DIC.COMPANY_NAME
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private String companyName;

    /**
    快递公司编号
    
    数据库字段: KDI_COMPANY_DIC.COMPANY_CODE
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private String companyCode;

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
    快递公司信息ID
    
    数据库字段: KDI_COMPANY_DIC.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getId() {
        return id;
    }

    /**
    快递公司信息ID
    
    数据库字段: KDI_COMPANY_DIC.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setId(Long id) {
        this.id = id;
    }

    /**
    快递公司名称
    
    数据库字段: KDI_COMPANY_DIC.COMPANY_NAME
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public String getCompanyName() {
        return companyName;
    }

    /**
    快递公司名称
    
    数据库字段: KDI_COMPANY_DIC.COMPANY_NAME
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
    快递公司编号
    
    数据库字段: KDI_COMPANY_DIC.COMPANY_CODE
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public String getCompanyCode() {
        return companyCode;
    }

    /**
    快递公司编号
    
    数据库字段: KDI_COMPANY_DIC.COMPANY_CODE
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
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
        sb.append(", companyName=").append(companyName);
        sb.append(", companyCode=").append(companyCode);
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
        KdiCompanyDicMo other = (KdiCompanyDicMo) that;
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