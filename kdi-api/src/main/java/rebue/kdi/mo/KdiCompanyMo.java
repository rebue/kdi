package rebue.kdi.mo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 快递公司信息
 *
 * 数据库表: KDI_COMPANY
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@JsonInclude(Include.NON_NULL)
public class KdiCompanyMo implements Serializable {

    /**
     *    快递公司ID
     *
     *    数据库字段: KDI_COMPANY.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long id;

    /**
     *    快递公司字典ID
     *
     *    数据库字段: KDI_COMPANY.COMPANY_DIC_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long companyDicId;

    /**
     *    快递公司别名，用于区分一个买家的两个店铺使用同一个快递公司
     *
     *    数据库字段: KDI_COMPANY.ANOTHER_NAME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String anotherName;

    /**
     *    快递公司账号
     *
     *    数据库字段: KDI_COMPANY.COMPANY_ACCOUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String companyAccount;

    /**
     *    快递公司密码
     *
     *    数据库字段: KDI_COMPANY.COMPANY_PWD
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String companyPwd;

    /**
     *    支付类型
     *                运费支付方式:
     *                1-现付
     *                2-到付
     *                3-月结
     *                4-第三方付
     *
     *    数据库字段: KDI_COMPANY.PAY_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Byte payType;

    /**
     *    录入时间
     *
     *    数据库字段: KDI_COMPANY.ENTRY_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date entryTime;

    /**
     *    组织ID
     *
     *    数据库字段: KDI_COMPANY.ORG_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long orgId;

    /**
     *    是否为默认公司（true：默认  false：不是默认）
     *
     *    数据库字段: KDI_COMPANY.IS_DEFAULT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Boolean isDefault;

    /**
     *    月结账号
     *
     *    数据库字段: KDI_COMPANY.MONTH_CODE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String monthCode;

    /**
     *    网点
     *
     *    数据库字段: KDI_COMPANY.SEND_SITE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String sendSite;

    /**
     *    店铺ID，用来表示这个快递公司是那个店铺的默认快递公司
     *
     *    数据库字段: KDI_COMPANY.SHOP_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long shopId;

    /**
     *    默认使用该快递公司的店铺
     *
     *    数据库字段: KDI_COMPANY.SHOP_NAME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String shopName;

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
     *    快递公司ID
     *
     *    数据库字段: KDI_COMPANY.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getId() {
        return id;
    }

    /**
     *    快递公司ID
     *
     *    数据库字段: KDI_COMPANY.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *    快递公司字典ID
     *
     *    数据库字段: KDI_COMPANY.COMPANY_DIC_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getCompanyDicId() {
        return companyDicId;
    }

    /**
     *    快递公司字典ID
     *
     *    数据库字段: KDI_COMPANY.COMPANY_DIC_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setCompanyDicId(Long companyDicId) {
        this.companyDicId = companyDicId;
    }

    /**
     *    快递公司别名，用于区分一个买家的两个店铺使用同一个快递公司
     *
     *    数据库字段: KDI_COMPANY.ANOTHER_NAME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getAnotherName() {
        return anotherName;
    }

    /**
     *    快递公司别名，用于区分一个买家的两个店铺使用同一个快递公司
     *
     *    数据库字段: KDI_COMPANY.ANOTHER_NAME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setAnotherName(String anotherName) {
        this.anotherName = anotherName;
    }

    /**
     *    快递公司账号
     *
     *    数据库字段: KDI_COMPANY.COMPANY_ACCOUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getCompanyAccount() {
        return companyAccount;
    }

    /**
     *    快递公司账号
     *
     *    数据库字段: KDI_COMPANY.COMPANY_ACCOUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setCompanyAccount(String companyAccount) {
        this.companyAccount = companyAccount;
    }

    /**
     *    快递公司密码
     *
     *    数据库字段: KDI_COMPANY.COMPANY_PWD
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getCompanyPwd() {
        return companyPwd;
    }

    /**
     *    快递公司密码
     *
     *    数据库字段: KDI_COMPANY.COMPANY_PWD
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setCompanyPwd(String companyPwd) {
        this.companyPwd = companyPwd;
    }

    /**
     *    支付类型
     *                运费支付方式:
     *                1-现付
     *                2-到付
     *                3-月结
     *                4-第三方付
     *
     *    数据库字段: KDI_COMPANY.PAY_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Byte getPayType() {
        return payType;
    }

    /**
     *    支付类型
     *                运费支付方式:
     *                1-现付
     *                2-到付
     *                3-月结
     *                4-第三方付
     *
     *    数据库字段: KDI_COMPANY.PAY_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    /**
     *    录入时间
     *
     *    数据库字段: KDI_COMPANY.ENTRY_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Date getEntryTime() {
        return entryTime;
    }

    /**
     *    录入时间
     *
     *    数据库字段: KDI_COMPANY.ENTRY_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    /**
     *    组织ID
     *
     *    数据库字段: KDI_COMPANY.ORG_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     *    组织ID
     *
     *    数据库字段: KDI_COMPANY.ORG_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     *    是否为默认公司（true：默认  false：不是默认）
     *
     *    数据库字段: KDI_COMPANY.IS_DEFAULT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Boolean getIsDefault() {
        return isDefault;
    }

    /**
     *    是否为默认公司（true：默认  false：不是默认）
     *
     *    数据库字段: KDI_COMPANY.IS_DEFAULT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    /**
     *    月结账号
     *
     *    数据库字段: KDI_COMPANY.MONTH_CODE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getMonthCode() {
        return monthCode;
    }

    /**
     *    月结账号
     *
     *    数据库字段: KDI_COMPANY.MONTH_CODE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setMonthCode(String monthCode) {
        this.monthCode = monthCode;
    }

    /**
     *    网点
     *
     *    数据库字段: KDI_COMPANY.SEND_SITE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getSendSite() {
        return sendSite;
    }

    /**
     *    网点
     *
     *    数据库字段: KDI_COMPANY.SEND_SITE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSendSite(String sendSite) {
        this.sendSite = sendSite;
    }

    /**
     *    店铺ID，用来表示这个快递公司是那个店铺的默认快递公司
     *
     *    数据库字段: KDI_COMPANY.SHOP_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     *    店铺ID，用来表示这个快递公司是那个店铺的默认快递公司
     *
     *    数据库字段: KDI_COMPANY.SHOP_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     *    默认使用该快递公司的店铺
     *
     *    数据库字段: KDI_COMPANY.SHOP_NAME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getShopName() {
        return shopName;
    }

    /**
     *    默认使用该快递公司的店铺
     *
     *    数据库字段: KDI_COMPANY.SHOP_NAME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setShopName(String shopName) {
        this.shopName = shopName;
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
        sb.append(", companyDicId=").append(companyDicId);
        sb.append(", anotherName=").append(anotherName);
        sb.append(", companyAccount=").append(companyAccount);
        sb.append(", companyPwd=").append(companyPwd);
        sb.append(", payType=").append(payType);
        sb.append(", entryTime=").append(entryTime);
        sb.append(", orgId=").append(orgId);
        sb.append(", isDefault=").append(isDefault);
        sb.append(", monthCode=").append(monthCode);
        sb.append(", sendSite=").append(sendSite);
        sb.append(", shopId=").append(shopId);
        sb.append(", shopName=").append(shopName);
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
        KdiCompanyMo other = (KdiCompanyMo) that;
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
