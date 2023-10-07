package club.emperorws.json.entity;

import club.emperorws.json.jacksonserializer.CustomNullSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * 序列化测试对象
 *
 * @author: EmperorWS
 * @date: 2023/5/27 23:54
 * @description: ObjectJson: 序列化测试对象
 */
public class ObjectJsonAll {

    @JsonSerialize(using = ToStringSerializer.class, nullsUsing = CustomNullSerializer.class)
    private Boolean booleanParamValue = false;

    @JsonSerialize(using = ToStringSerializer.class, nullsUsing = CustomNullSerializer.class)
    private Boolean booleanParamNull;

    @JsonSerialize(using = ToStringSerializer.class, nullsUsing = CustomNullSerializer.class)
    private Character characterParamValue = 'a';

    @JsonSerialize(using = ToStringSerializer.class, nullsUsing = CustomNullSerializer.class)
    private Character characterParamNull;

    @JsonSerialize(using = ToStringSerializer.class, nullsUsing = CustomNullSerializer.class)
    private Byte byteParamValue = 'b';

    @JsonSerialize(using = ToStringSerializer.class, nullsUsing = CustomNullSerializer.class)
    private Byte byteParamNull;

    @JsonSerialize(using = ToStringSerializer.class, nullsUsing = CustomNullSerializer.class)
    private Short shortParamValue = '1';

    @JsonSerialize(using = ToStringSerializer.class, nullsUsing = CustomNullSerializer.class)
    private Short shortParamNull;

    @JsonSerialize(using = ToStringSerializer.class, nullsUsing = CustomNullSerializer.class)
    private Integer integerParamValue = 1;

    @JsonSerialize(using = ToStringSerializer.class, nullsUsing = CustomNullSerializer.class)
    private Integer integerParamNull;

    @JsonSerialize(using = ToStringSerializer.class, nullsUsing = CustomNullSerializer.class)
    private Long longParamValue = 1000L;

    @JsonSerialize(using = ToStringSerializer.class, nullsUsing = CustomNullSerializer.class)
    private Long longParamNull;

    @JsonSerialize(using = ToStringSerializer.class, nullsUsing = CustomNullSerializer.class)
    private Float floatParamValue = 1.0f;

    @JsonSerialize(using = ToStringSerializer.class, nullsUsing = CustomNullSerializer.class)
    private Float floatParamNull;

    @JsonSerialize(using = ToStringSerializer.class, nullsUsing = CustomNullSerializer.class)
    private Double doubleParamValue = 10.99;

    @JsonSerialize(using = ToStringSerializer.class, nullsUsing = CustomNullSerializer.class)
    private Double doubleParamNull;

    @JsonSerialize(using = ToStringSerializer.class, nullsUsing = CustomNullSerializer.class)
    private String stringParamValue = "啦啦啦啦啦";

    @JsonSerialize(using = ToStringSerializer.class, nullsUsing = CustomNullSerializer.class)
    private String stringParamNull;

    @JsonSerialize(using = ToStringSerializer.class, nullsUsing = CustomNullSerializer.class)
    private BigDecimal bigDecimalParamValue = new BigDecimal("1.0");

    @JsonSerialize(using = ToStringSerializer.class, nullsUsing = CustomNullSerializer.class)
    private BigDecimal bigDecimalNull;

    @JsonSerialize(using = ToStringSerializer.class, nullsUsing = CustomNullSerializer.class)
    private BigInteger bigIntegerParamValue = new BigInteger("123456789");

    @JsonSerialize(using = ToStringSerializer.class, nullsUsing = CustomNullSerializer.class)
    private BigInteger bigIntegerNull;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonSerialize(nullsUsing = CustomNullSerializer.class)
    private Date dateParamValue = new Date();

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonSerialize(nullsUsing = CustomNullSerializer.class)
    private Date dateParamNull;

    public Boolean getBooleanParamValue() {
        return booleanParamValue;
    }

    public void setBooleanParamValue(Boolean booleanParamValue) {
        this.booleanParamValue = booleanParamValue;
    }

    public Boolean getBooleanParamNull() {
        return booleanParamNull;
    }

    public void setBooleanParamNull(Boolean booleanParamNull) {
        this.booleanParamNull = booleanParamNull;
    }

    public Character getCharacterParamValue() {
        return characterParamValue;
    }

    public void setCharacterParamValue(Character characterParamValue) {
        this.characterParamValue = characterParamValue;
    }

    public Character getCharacterParamNull() {
        return characterParamNull;
    }

    public void setCharacterParamNull(Character characterParamNull) {
        this.characterParamNull = characterParamNull;
    }

    public Byte getByteParamValue() {
        return byteParamValue;
    }

    public void setByteParamValue(Byte byteParamValue) {
        this.byteParamValue = byteParamValue;
    }

    public Byte getByteParamNull() {
        return byteParamNull;
    }

    public void setByteParamNull(Byte byteParamNull) {
        this.byteParamNull = byteParamNull;
    }

    public Short getShortParamValue() {
        return shortParamValue;
    }

    public void setShortParamValue(Short shortParamValue) {
        this.shortParamValue = shortParamValue;
    }

    public Short getShortParamNull() {
        return shortParamNull;
    }

    public void setShortParamNull(Short shortParamNull) {
        this.shortParamNull = shortParamNull;
    }

    public Integer getIntegerParamValue() {
        return integerParamValue;
    }

    public void setIntegerParamValue(Integer integerParamValue) {
        this.integerParamValue = integerParamValue;
    }

    public Integer getIntegerParamNull() {
        return integerParamNull;
    }

    public void setIntegerParamNull(Integer integerParamNull) {
        this.integerParamNull = integerParamNull;
    }

    public Long getLongParamValue() {
        return longParamValue;
    }

    public void setLongParamValue(Long longParamValue) {
        this.longParamValue = longParamValue;
    }

    public Long getLongParamNull() {
        return longParamNull;
    }

    public void setLongParamNull(Long longParamNull) {
        this.longParamNull = longParamNull;
    }

    public Float getFloatParamValue() {
        return floatParamValue;
    }

    public void setFloatParamValue(Float floatParamValue) {
        this.floatParamValue = floatParamValue;
    }

    public Float getFloatParamNull() {
        return floatParamNull;
    }

    public void setFloatParamNull(Float floatParamNull) {
        this.floatParamNull = floatParamNull;
    }

    public Double getDoubleParamValue() {
        return doubleParamValue;
    }

    public void setDoubleParamValue(Double doubleParamValue) {
        this.doubleParamValue = doubleParamValue;
    }

    public Double getDoubleParamNull() {
        return doubleParamNull;
    }

    public void setDoubleParamNull(Double doubleParamNull) {
        this.doubleParamNull = doubleParamNull;
    }

    public String getStringParamValue() {
        return stringParamValue;
    }

    public void setStringParamValue(String stringParamValue) {
        this.stringParamValue = stringParamValue;
    }

    public String getStringParamNull() {
        return stringParamNull;
    }

    public void setStringParamNull(String stringParamNull) {
        this.stringParamNull = stringParamNull;
    }

    public BigDecimal getBigDecimalParamValue() {
        return bigDecimalParamValue;
    }

    public void setBigDecimalParamValue(BigDecimal bigDecimalParamValue) {
        this.bigDecimalParamValue = bigDecimalParamValue;
    }

    public BigDecimal getBigDecimalNull() {
        return bigDecimalNull;
    }

    public void setBigDecimalNull(BigDecimal bigDecimalNull) {
        this.bigDecimalNull = bigDecimalNull;
    }

    public BigInteger getBigIntegerParamValue() {
        return bigIntegerParamValue;
    }

    public void setBigIntegerParamValue(BigInteger bigIntegerParamValue) {
        this.bigIntegerParamValue = bigIntegerParamValue;
    }

    public BigInteger getBigIntegerNull() {
        return bigIntegerNull;
    }

    public void setBigIntegerNull(BigInteger bigIntegerNull) {
        this.bigIntegerNull = bigIntegerNull;
    }

    public Date getDateParamValue() {
        return dateParamValue;
    }

    public void setDateParamValue(Date dateParamValue) {
        this.dateParamValue = dateParamValue;
    }

    public Date getDateParamNull() {
        return dateParamNull;
    }

    public void setDateParamNull(Date dateParamNull) {
        this.dateParamNull = dateParamNull;
    }
}
