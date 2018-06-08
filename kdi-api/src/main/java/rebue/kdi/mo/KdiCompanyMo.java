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
 *   快递公司信息
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table KDI_COMPANY
 *
 * @mbg.generated do_not_delete_during_merge 2018-06-08 09:50:07
 */
@ApiModel(value = "KdiCompanyMo", description = "快递公司信息")
@JsonInclude(Include.NON_NULL)
public class KdiCompanyMo implements Serializable {
    /**
     * Database Column Remarks:
     *   快递公司信息ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column KDI_COMPANY.ID
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    @ApiModelProperty(value = "快递公司信息ID")
    private Long id;

    /**
     * Database Column Remarks:
     *   快递公司名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column KDI_COMPANY.COMPANY_NAME
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    @ApiModelProperty(value = "快递公司名称")
    private String companyName;

    /**
     * Database Column Remarks:
     *   快递公司账号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column KDI_COMPANY.COMPANY_ACCOUNT
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    @ApiModelProperty(value = "快递公司账号")
    private String companyAccount;

    /**
     * Database Column Remarks:
     *   快递公司密码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column KDI_COMPANY.COMPANY_PWD
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    @ApiModelProperty(value = "快递公司密码")
    private String companyPwd;

    /**
     * Database Column Remarks:
     *   快递公司编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column KDI_COMPANY.COMPANY_CODE
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    @ApiModelProperty(value = "快递公司编号")
    private String companyCode;

    /**
     * Database Column Remarks:
     *   支付类型
     *               运费支付方式:
     *               1-现付
     *               2-到付
     *               3-月结
     *               4-第三方付
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column KDI_COMPANY.PAY_TYPE
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    @ApiModelProperty(value = "支付类型\n"
             +"            运费支付方式:\n"
             +"            1-现付\n"
             +"            2-到付\n"
             +"            3-月结\n"
             +"            4-第三方付")
    private Byte payType;

    /**
     * Database Column Remarks:
     *   录入时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column KDI_COMPANY.ENTRY_TIME
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    @ApiModelProperty(value = "录入时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date entryTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table KDI_COMPANY
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column KDI_COMPANY.ID
     *
     * @return the value of KDI_COMPANY.ID
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column KDI_COMPANY.ID
     *
     * @param id the value for KDI_COMPANY.ID
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column KDI_COMPANY.COMPANY_NAME
     *
     * @return the value of KDI_COMPANY.COMPANY_NAME
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column KDI_COMPANY.COMPANY_NAME
     *
     * @param companyName the value for KDI_COMPANY.COMPANY_NAME
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column KDI_COMPANY.COMPANY_ACCOUNT
     *
     * @return the value of KDI_COMPANY.COMPANY_ACCOUNT
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    public String getCompanyAccount() {
        return companyAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column KDI_COMPANY.COMPANY_ACCOUNT
     *
     * @param companyAccount the value for KDI_COMPANY.COMPANY_ACCOUNT
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    public void setCompanyAccount(String companyAccount) {
        this.companyAccount = companyAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column KDI_COMPANY.COMPANY_PWD
     *
     * @return the value of KDI_COMPANY.COMPANY_PWD
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    public String getCompanyPwd() {
        return companyPwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column KDI_COMPANY.COMPANY_PWD
     *
     * @param companyPwd the value for KDI_COMPANY.COMPANY_PWD
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    public void setCompanyPwd(String companyPwd) {
        this.companyPwd = companyPwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column KDI_COMPANY.COMPANY_CODE
     *
     * @return the value of KDI_COMPANY.COMPANY_CODE
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    public String getCompanyCode() {
        return companyCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column KDI_COMPANY.COMPANY_CODE
     *
     * @param companyCode the value for KDI_COMPANY.COMPANY_CODE
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column KDI_COMPANY.PAY_TYPE
     *
     * @return the value of KDI_COMPANY.PAY_TYPE
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    public Byte getPayType() {
        return payType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column KDI_COMPANY.PAY_TYPE
     *
     * @param payType the value for KDI_COMPANY.PAY_TYPE
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column KDI_COMPANY.ENTRY_TIME
     *
     * @return the value of KDI_COMPANY.ENTRY_TIME
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    public Date getEntryTime() {
        return entryTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column KDI_COMPANY.ENTRY_TIME
     *
     * @param entryTime the value for KDI_COMPANY.ENTRY_TIME
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_COMPANY
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", companyName=").append(companyName);
        sb.append(", companyAccount=").append(companyAccount);
        sb.append(", companyPwd=").append(companyPwd);
        sb.append(", companyCode=").append(companyCode);
        sb.append(", payType=").append(payType);
        sb.append(", entryTime=").append(entryTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_COMPANY
     *
     * @mbg.generated 2018-06-08 09:50:07
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
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        ;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_COMPANY
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }
}