package club.emperor.json.entity;

import java.math.BigDecimal;

/**
 * 普通序列化测试对象
 *
 * @author: EmperorWS
 * @date: 2023/7/5 23:41
 * @description: ObjectJson: 普通序列化测试对象
 */
public class ObjectJson {

    private String numStr = "1000000000000000000";

    private Long num = 1000000000000000000L;

    private String numBigDecimalStr = "100000000000000000000000000000000000000000000000000000000000000000000000";

    private BigDecimal numBigDecimal = new BigDecimal("10E10");

    public String getNumStr() {
        return numStr;
    }

    public void setNumStr(String numStr) {
        this.numStr = numStr;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getNumBigDecimalStr() {
        return numBigDecimalStr;
    }

    public void setNumBigDecimalStr(String numBigDecimalStr) {
        this.numBigDecimalStr = numBigDecimalStr;
    }

    public BigDecimal getNumBigDecimal() {
        return numBigDecimal;
    }

    public void setNumBigDecimal(BigDecimal numBigDecimal) {
        this.numBigDecimal = numBigDecimal;
    }
}
