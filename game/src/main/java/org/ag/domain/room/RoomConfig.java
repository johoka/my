package org.ag.domain.room;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author johoka
 */
@Data
@XmlRootElement(name="RoomConfig")  //声明为xml的根元素d
@XmlAccessorType(XmlAccessType.FIELD)  //通过字段来访问
public class RoomConfig {
    @XmlElement(name="platform")
    private List<Platform> platformList;
}
