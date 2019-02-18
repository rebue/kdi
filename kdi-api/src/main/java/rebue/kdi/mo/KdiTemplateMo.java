package rebue.kdi.mo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;

/**
 * 电子面单模板
 *
 * 数据库表: KDI_TEMPLATE
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@JsonInclude(Include.NON_NULL)
public class KdiTemplateMo implements Serializable {

    /**
     *    模板ID
     *
     *    数据库字段: KDI_TEMPLATE.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long id;

    /**
     *    快递公司ID
     *
     *    数据库字段: KDI_TEMPLATE.COMPANY_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long companyId;

    /**
     *    模板字典ID
     *
     *    数据库字段: KDI_TEMPLATE.TEMPLATE_DIC_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long templateDicId;

    /**
     *    是否默认
     *
     *    数据库字段: KDI_TEMPLATE.IS_DEFAULT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Boolean isDefault;

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
     *    模板ID
     *
     *    数据库字段: KDI_TEMPLATE.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getId() {
        return id;
    }

    /**
     *    模板ID
     *
     *    数据库字段: KDI_TEMPLATE.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *    快递公司ID
     *
     *    数据库字段: KDI_TEMPLATE.COMPANY_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     *    快递公司ID
     *
     *    数据库字段: KDI_TEMPLATE.COMPANY_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     *    模板字典ID
     *
     *    数据库字段: KDI_TEMPLATE.TEMPLATE_DIC_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getTemplateDicId() {
        return templateDicId;
    }

    /**
     *    模板字典ID
     *
     *    数据库字段: KDI_TEMPLATE.TEMPLATE_DIC_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setTemplateDicId(Long templateDicId) {
        this.templateDicId = templateDicId;
    }

    /**
     *    是否默认
     *
     *    数据库字段: KDI_TEMPLATE.IS_DEFAULT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Boolean getIsDefault() {
        return isDefault;
    }

    /**
     *    是否默认
     *
     *    数据库字段: KDI_TEMPLATE.IS_DEFAULT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", companyId=").append(companyId);
        sb.append(", templateDicId=").append(templateDicId);
        sb.append(", isDefault=").append(isDefault);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
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
        KdiTemplateMo other = (KdiTemplateMo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()));
    }

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }
}
