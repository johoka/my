package org.ag.domain.room;

import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * @author johoka
 */
@Data
@XmlRootElement(name="room")  //声明为xml的根元素d
@XmlAccessorType(XmlAccessType.FIELD)  //通过字段来访问
public class Room {

//    ----不知道字段有啥用----
    private int category = 0;
    private int typeTag = 0;
    private boolean isShowZB = true;
    private int timeout = 0;
    private int maxTime = 0;
    private int lineIndex = -1;
    private int lineFlag = 0;
//    ----不知道字段有啥用----

    /**
     * eg.N015
     */
    @XmlAttribute(name="id")
    private String id;
    /**
     * eg.BAC
     */
    @XmlAttribute(name="type")
    private String type;
    /**
     * eg.N15
     */
    @XmlAttribute(name="name")
    private String name;
    /**
     * eg.0
     */
    @XmlAttribute(name="flag")
    private String flag;
    /**
     * eg.0
     */
    @XmlAttribute(name="greenscreen")
    private String greenscreen;
    /**
     * eg.rec_kkw3
     */
    @XmlAttribute(name="record")
    private String record;

    @XmlElement(name="video")
    private Video video;



}
