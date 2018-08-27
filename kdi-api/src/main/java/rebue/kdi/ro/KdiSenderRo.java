package rebue.kdi.ro;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import rebue.kdi.mo.KdiSenderMo;

@JsonInclude(Include.NON_NULL)
public class KdiSenderRo {

    /**
     *	This field was generated by MyBatis Generator.
     *
     * 	返回值	1:成功  -1:失败
     *
     *	@mbg.generated
     */
    private Byte result;

    /**
     *	This field was generated by MyBatis Generator.
     *
     *	返回的结果
     *
     * @mbg.generated
     */
    private String msg;

    /**
     *	This field was generated by MyBatis Generator.
     *
     *	返回的结果值
     *
     * 	@mbg.generated
     */
    private KdiSenderMo record;

    /**
     *	This field was generated by MyBatis Generator.
     *
     *	@mbg.generated
     */
    public Byte getResult() {
        return result;
    }

    /**
     *	This field was generated by MyBatis Generator.
     *
     *	@mbg.generated
     */
    public void setResult(Byte result) {
        this.result = result;
    }

    /**
     *	This field was generated by MyBatis Generator.
     *
     *	@mbg.generated
     */
    public String getMsg() {
        return msg;
    }

    /**
     *	This field was generated by MyBatis Generator.
     *
     *	@mbg.generated
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     *	This field was generated by MyBatis Generator.
     *
     *	@mbg.generated
     */
    public KdiSenderMo getRecord() {
        return record;
    }

    /**
     *	This field was generated by MyBatis Generator.
     *
     *	@mbg.generated
     */
    public void setRecord(KdiSenderMo record) {
        this.record = record;
    }

    /**
     *	This field was generated by MyBatis Generator.
     *
     *	@mbg.generated
     */
    @Override
    public String toString() {
        return "PfmSysTo [result=" + result + ", msg=" + msg + ", record=" + record + "]";
    }
}
