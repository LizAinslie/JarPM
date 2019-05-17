package org.jarpm.utils.data;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * @author RailRunner166
 */
public class XML {
    /**
     * Convert an object to a formatted XML string
     * @param data The object to convert
     * @return The formatted XML string
     * @throws JAXBException An exception thrown while converting an object to XML
     */
    public static String objectToXML(Object data) throws JAXBException {
		String xmlString = "";
		JAXBContext context = JAXBContext.newInstance(data.getClass());
		Marshaller m = context.createMarshaller();

		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

		StringWriter sw = new StringWriter();
		m.marshal(data, sw);
		xmlString = sw.toString();

		return xmlString;
	}
}
