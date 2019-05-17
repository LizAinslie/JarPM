package org.jarpm.config.structs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author RailRunner166
 */
@XmlRootElement(name="Package")
@XmlAccessorType(XmlAccessType.FIELD)
public class Config {
    @XmlElement(name="Version")
    public String version;

    @XmlElement(name="Name")
    public String packageName;

    @XmlElement(name="Dir")
    public String dependencyDir;
    
    @XmlElementWrapper(name="Dependencies")
    @XmlElement(name="Dependency")
    public String[] dependencies;
}
