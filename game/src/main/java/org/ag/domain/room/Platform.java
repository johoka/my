package org.ag.domain.room;

import lombok.Data;
import lombok.Getter;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author johoka
 */
@Data
@XmlRootElement(name="platform")  //声明为xml的根元素d
@XmlAccessorType(XmlAccessType.FIELD)  //通过字段来访问
public class Platform {
    @XmlAttribute(name="id")
    private String id;
    @XmlAttribute(name="name")
    private String name;
    @XmlAttribute(name="flag")
    private String flag;
    @XmlElement(name="room")
    private List<Room> roomList;

}
