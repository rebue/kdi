package rebue.kdi.mo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Database Table Remarks:
 *   发件人信息
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table KDI_SENDER
 *
 * @mbg.generated do_not_delete_during_merge 2018-06-15 17:03:19
 */
@ApiModel(value = "KdiSenderMo", description = "发件人信息")
@JsonInclude(Include.NON_NULL)
public class KdiSenderMo implements Serializable {
    /**
     * Database Column Remarks:
     *   发件人信息ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column KDI_SENDER.ID
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    @ApiModelProperty(value = "发件人信息ID")
    private Long id;

    /**
     * Database Column Remarks:
     *   发件人名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column KDI_SENDER.SENDER_NAME
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    @ApiModelProperty(value = "发件人名称")
    private String senderName;

    /**
     * Database Column Remarks:
     *   发件人电话
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column KDI_SENDER.SENDER_TEL
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    @ApiModelProperty(value = "发件人电话")
    private String senderTel;

    /**
     * Database Column Remarks:
     *   发件人手机
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column KDI_SENDER.SENDER_MOBILE
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    @ApiModelProperty(value = "发件人手机")
    private String senderMobile;

    /**
     * Database Column Remarks:
     *   发件省
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column KDI_SENDER.SENDER_PROVINCE
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    @ApiModelProperty(value = "发件省")
    private String senderProvince;

    /**
     * Database Column Remarks:
     *   发件市
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column KDI_SENDER.SENDER_CITY
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    @ApiModelProperty(value = "发件市")
    private String senderCity;

    /**
     * Database Column Remarks:
     *   发件区
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column KDI_SENDER.SENDER_EXP_AREA
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    @ApiModelProperty(value = "发件区")
    private String senderExpArea;

    /**
     * Database Column Remarks:
     *   发件人详细地址
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column KDI_SENDER.SENDER_ADDRESS
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    @ApiModelProperty(value = "发件人详细地址")
    private String senderAddress;

    /**
     * Database Column Remarks:
     *   发件地邮编
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column KDI_SENDER.SENDER_POST_CODE
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    @ApiModelProperty(value = "发件地邮编")
    private String senderPostCode;

    /**
     * Database Column Remarks:
     *   是否为默认发件人（true：默认  false：不是默认）
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column KDI_SENDER.IS_DEFAULT
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    @ApiModelProperty(value = "是否为默认发件人（true：默认  false：不是默认）")
    private Boolean isDefault;

    /**
     * Database Column Remarks:
     *   录入时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column KDI_SENDER.ENTRY_TIME
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    @ApiModelProperty(value = "录入时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date entryTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table KDI_SENDER
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column KDI_SENDER.ID
     *
     * @return the value of KDI_SENDER.ID
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column KDI_SENDER.ID
     *
     * @param id the value for KDI_SENDER.ID
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column KDI_SENDER.SENDER_NAME
     *
     * @return the value of KDI_SENDER.SENDER_NAME
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    public String getSenderName() {
        return senderName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column KDI_SENDER.SENDER_NAME
     *
     * @param senderName the value for KDI_SENDER.SENDER_NAME
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column KDI_SENDER.SENDER_TEL
     *
     * @return the value of KDI_SENDER.SENDER_TEL
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    public String getSenderTel() {
        return senderTel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column KDI_SENDER.SENDER_TEL
     *
     * @param senderTel the value for KDI_SENDER.SENDER_TEL
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    public void setSenderTel(String senderTel) {
        this.senderTel = senderTel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column KDI_SENDER.SENDER_MOBILE
     *
     * @return the value of KDI_SENDER.SENDER_MOBILE
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    public String getSenderMobile() {
        return senderMobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column KDI_SENDER.SENDER_MOBILE
     *
     * @param senderMobile the value for KDI_SENDER.SENDER_MOBILE
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    public void setSenderMobile(String senderMobile) {
        this.senderMobile = senderMobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column KDI_SENDER.SENDER_PROVINCE
     *
     * @return the value of KDI_SENDER.SENDER_PROVINCE
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    public String getSenderProvince() {
        return senderProvince;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column KDI_SENDER.SENDER_PROVINCE
     *
     * @param senderProvince the value for KDI_SENDER.SENDER_PROVINCE
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    public void setSenderProvince(String senderProvince) {
        this.senderProvince = senderProvince;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column KDI_SENDER.SENDER_CITY
     *
     * @return the value of KDI_SENDER.SENDER_CITY
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    public String getSenderCity() {
        return senderCity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column KDI_SENDER.SENDER_CITY
     *
     * @param senderCity the value for KDI_SENDER.SENDER_CITY
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    public void setSenderCity(String senderCity) {
        this.senderCity = senderCity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column KDI_SENDER.SENDER_EXP_AREA
     *
     * @return the value of KDI_SENDER.SENDER_EXP_AREA
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    public String getSenderExpArea() {
        return senderExpArea;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column KDI_SENDER.SENDER_EXP_AREA
     *
     * @param senderExpArea the value for KDI_SENDER.SENDER_EXP_AREA
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    public void setSenderExpArea(String senderExpArea) {
        this.senderExpArea = senderExpArea;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column KDI_SENDER.SENDER_ADDRESS
     *
     * @return the value of KDI_SENDER.SENDER_ADDRESS
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    public String getSenderAddress() {
        return senderAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column KDI_SENDER.SENDER_ADDRESS
     *
     * @param senderAddress the value for KDI_SENDER.SENDER_ADDRESS
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column KDI_SENDER.SENDER_POST_CODE
     *
     * @return the value of KDI_SENDER.SENDER_POST_CODE
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    public String getSenderPostCode() {
        return senderPostCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column KDI_SENDER.SENDER_POST_CODE
     *
     * @param senderPostCode the value for KDI_SENDER.SENDER_POST_CODE
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    public void setSenderPostCode(String senderPostCode) {
        this.senderPostCode = senderPostCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column KDI_SENDER.IS_DEFAULT
     *
     * @return the value of KDI_SENDER.IS_DEFAULT
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    public Boolean getIsDefault() {
        return isDefault;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column KDI_SENDER.IS_DEFAULT
     *
     * @param isDefault the value for KDI_SENDER.IS_DEFAULT
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column KDI_SENDER.ENTRY_TIME
     *
     * @return the value of KDI_SENDER.ENTRY_TIME
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    public Date getEntryTime() {
        return entryTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column KDI_SENDER.ENTRY_TIME
     *
     * @param entryTime the value for KDI_SENDER.ENTRY_TIME
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_SENDER
     *
     * @mbg.generated 2018-06-15 17:03:19
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
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_SENDER
     *
     * @mbg.generated 2018-06-15 17:03:19
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
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        ;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_SENDER
     *
     * @mbg.generated 2018-06-15 17:03:19
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }
}