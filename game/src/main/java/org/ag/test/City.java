package org.ag.test;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * @desc  城市信息 解析citylist.xml获取
 */
@XmlRootElement(name="d")  //声明为xml的根元素d
@XmlAccessorType(XmlAccessType.FIELD)  //通过字段来访问
public class City implements Serializable {

    @XmlAttribute(name="d1") //映射的xml属性
    private String cityId;
    @XmlAttribute(name="d2")
    private String cityName;
    @XmlAttribute(name="d3")
    private String cityCode;
    @XmlAttribute(name="d4")
    private String province;
    @XmlValue
    private String test;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId='" + cityId + '\'' +
                ", cityName='" + cityName + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", province='" + province + '\'' +
                ", test='" + test + '\'' +
                '}';
    }
}