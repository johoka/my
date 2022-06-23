package org.ag.test;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * @desc 城市列表
 */
@XmlRootElement(name="c")  //声明为xml的根元素c
@XmlAccessorType(XmlAccessType.FIELD)  //通过字段来访问
public class CityList implements Serializable {

    @XmlAttribute(name="c1")
    private String c1;
    @XmlElement(name="d") //映射的xml元素
    private List<City> cityList;

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    @Override
    public String toString() {
        return "CityList{" +
                "c1='" + c1 + '\'' +
                ", cityList=" + cityList +
                '}';
    }
}

