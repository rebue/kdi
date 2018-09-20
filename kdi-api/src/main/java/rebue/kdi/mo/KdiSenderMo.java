package rebue.kdi.mo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 发件人信息
 *
 * 数据库表: KDI_SENDER
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@JsonInclude(Include.NON_NULL)
public class KdiSenderMo implements Serializable {

    /**
     *    发件人信息ID
     *
     *    数据库字段: KDI_SENDER.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long id;

    /**
     *    发件人名称
     *
     *    数据库字段: KDI_SENDER.SENDER_NAME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String senderName;

    /**
     *    发件人电话
     *
     *    数据库字段: KDI_SENDER.SENDER_TEL
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String senderTel;

    /**
     *    发件人手机
     *
     *    数据库字段: KDI_SENDER.SENDER_MOBILE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String senderMobile;

    /**
     *    发件省
     *
     *    数据库字段: KDI_SENDER.SENDER_PROVINCE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String senderProvince;

    /**
     *    发件市
     *
     *    数据库字段: KDI_SENDER.SENDER_CITY
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String senderCity;

    /**
     *    发件区
     *
     *    数据库字段: KDI_SENDER.SENDER_EXP_AREA
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String senderExpArea;

    /**
     *    发件人详细地址
     *
     *    数据库字段: KDI_SENDER.SENDER_ADDRESS
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String senderAddress;

    /**
     *    发件地邮编
     *
     *    数据库字段: KDI_SENDER.SENDER_POST_CODE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String senderPostCode;

    /**
     *    是否为默认发件人（true：默认  false：不是默认）
     *
     *    数据库字段: KDI_SENDER.IS_DEFAULT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Boolean isDefault;

    /**
     *    录入时间
     *
     *    数据库字段: KDI_SENDER.ENTRY_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date entryTime;

    /**
     *    组织id
     *
     *    数据库字段: KDI_SENDER.ORG_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long orgId;

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
     *    发件人信息ID
     *
     *    数据库字段: KDI_SENDER.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getId() {
        return id;
    }

    /**
     *    发件人信息ID
     *
     *    数据库字段: KDI_SENDER.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *    发件人名称
     *
     *    数据库字段: KDI_SENDER.SENDER_NAME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getSenderName() {
        return senderName;
    }

    /**
     *    发件人名称
     *
     *    数据库字段: KDI_SENDER.SENDER_NAME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    /**
     *    发件人电话
     *
     *    数据库字段: KDI_SENDER.SENDER_TEL
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getSenderTel() {
        return senderTel;
    }

    /**
     *    发件人电话
     *
     *    数据库字段: KDI_SENDER.SENDER_TEL
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSenderTel(String senderTel) {
        this.senderTel = senderTel;
    }

    /**
     *    发件人手机
     *
     *    数据库字段: KDI_SENDER.SENDER_MOBILE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getSenderMobile() {
        return senderMobile;
    }

    /**
     *    发件人手机
     *
     *    数据库字段: KDI_SENDER.SENDER_MOBILE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSenderMobile(String senderMobile) {
        this.senderMobile = senderMobile;
    }

    /**
     *    发件省
     *
     *    数据库字段: KDI_SENDER.SENDER_PROVINCE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getSenderProvince() {
        return senderProvince;
    }

    /**
     *    发件省
     *
     *    数据库字段: KDI_SENDER.SENDER_PROVINCE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSenderProvince(String senderProvince) {
        this.senderProvince = senderProvince;
    }

    /**
     *    发件市
     *
     *    数据库字段: KDI_SENDER.SENDER_CITY
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getSenderCity() {
        return senderCity;
    }

    /**
     *    发件市
     *
     *    数据库字段: KDI_SENDER.SENDER_CITY
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSenderCity(String senderCity) {
        this.senderCity = senderCity;
    }

    /**
     *    发件区
     *
     *    数据库字段: KDI_SENDER.SENDER_EXP_AREA
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getSenderExpArea() {
        return senderExpArea;
    }

    /**
     *    发件区
     *
     *    数据库字段: KDI_SENDER.SENDER_EXP_AREA
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSenderExpArea(String senderExpArea) {
        this.senderExpArea = senderExpArea;
    }

    /**
     *    发件人详细地址
     *
     *    数据库字段: KDI_SENDER.SENDER_ADDRESS
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getSenderAddress() {
        return senderAddress;
    }

    /**
     *    发件人详细地址
     *
     *    数据库字段: KDI_SENDER.SENDER_ADDRESS
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    /**
     *    发件地邮编
     *
     *    数据库字段: KDI_SENDER.SENDER_POST_CODE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getSenderPostCode() {
        return senderPostCode;
    }

    /**
     *    发件地邮编
     *
     *    数据库字段: KDI_SENDER.SENDER_POST_CODE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSenderPostCode(String senderPostCode) {
        this.senderPostCode = senderPostCode;
    }

    /**
     *    是否为默认发件人（true：默认  false：不是默认）
     *
     *    数据库字段: KDI_SENDER.IS_DEFAULT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Boolean getIsDefault() {
        return isDefault;
    }

    /**
     *    是否为默认发件人（true：默认  false：不是默认）
     *
     *    数据库字段: KDI_SENDER.IS_DEFAULT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    /**
     *    录入时间
     *
     *    数据库字段: KDI_SENDER.ENTRY_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Date getEntryTime() {
        return entryTime;
    }

    /**
     *    录入时间
     *
     *    数据库字段: KDI_SENDER.ENTRY_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    /**
     *    组织id
     *
     *    数据库字段: KDI_SENDER.ORG_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     *    组织id
     *
     *    数据库字段: KDI_SENDER.ORG_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
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
        sb.append(", senderName=").append(senderName);
        sb.append(", senderTel=").append(senderTel);
        sb.append(", senderMobile=").append(senderMobile);
        sb.append(", senderProvince=").append(senderProvince);
        sb.append(", senderCity=").append(senderCity);
        sb.append(", senderExpArea=").append(senderExpArea);
        sb.append(", senderAddress=").append(senderAddress);
        sb.append(", senderPostCode=").append(senderPostCode);
        sb.append(", isDefault=").append(isDefault);
        sb.append(", entryTime=").append(entryTime);
        sb.append(", orgId=").append(orgId);
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
        KdiSenderMo other = (KdiSenderMo) that;
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
