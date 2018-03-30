package rebue.kdi.ro;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 快递公司
 */
@JsonInclude(Include.NON_NULL)
public class ShipperRo {

    /**
     * 快递公司编码
     */
    private String shipperCode;

    /**
     * 快递公司名称
     */
    private String shipperName;

    public String getShipperCode() {
        return shipperCode;
    }

    public void setShipperCode(String shipperCode) {
        this.shipperCode = shipperCode;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    @Override
    public String toString() {
        return "ShipperRo [shipperCode=" + shipperCode + ", shipperName=" + shipperName + "]";
    }

}
