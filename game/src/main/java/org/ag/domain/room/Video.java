package org.ag.domain.room;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author johoka
 */
@Data
@XmlRootElement(name="video")  //声明为xml的根元素d
@XmlAccessorType(XmlAccessType.FIELD)  //通过字段来访问
public class Video {
    /**
     * N015
     */
    @XmlAttribute(name="id")
    private String id;
    /**
     * 3013
     */
    @XmlAttribute(name="gms")
    private String gms;
    /**
     * 0
     */
    @XmlAttribute(name="quickmode")
    private String quickmode;
    /**
     * A,C,D,E,V
     */
    @XmlAttribute(name="oddlist")
    private String oddlist;
    /**
     * 1;2
     */
    @XmlAttribute(name="quality")
    private String quality;
    /**
     * 0
     */
    @XmlAttribute(name="useaga")
    private String useaga;

    @XmlElement(name="addr")
    private List<Addr> addrList;

    @XmlElement(name="maddr")
    private List<Maddr> maddrList;
}
