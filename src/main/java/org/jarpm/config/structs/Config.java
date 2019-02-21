package org.jarpm.config.structs;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name="Package")
@XmlAccessorType(XmlAccessType.FIELD)
public class Config {
    @XmlElement(name="Dir")
    public String dependencyDir;
    
    @XmlElement(name="Name")
    public String packageName;
    
    @XmlElement(name="Version")
    public String version;
    
    @XmlElementWrapper(name="Dependencies")
    @XmlElement(name="Dependency")
    public String[] dependencies;
}
