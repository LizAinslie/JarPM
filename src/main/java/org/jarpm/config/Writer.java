package org.jarpm.config;

import org.jarpm.utils.data.XML;
import org.jarpm.config.structs.Config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBException;

/**
 * @author Landon Gravat
 */
public class Writer {
    /**
     * Writes configuration data to a config file. If the file is nonexistent, it creates the file. <code>path</code> must not point nonexistent directories, as it will throw an <code>IOException</code>.
     * @param path The path to create the configuration file at
     * @param configData The configuration data to write
     * @throws IOException A Java IO exception
     */
    public static void write(String path, Config configData) throws IOException {
        try {
		    String xml = XML.objectToXML(configData);

    		File file = new File(path);
    
    		// creates the file if it doesn't exist
    		if (!file.exists()) file.createNewFile();
    
    		// creates a FileWriter Object
    		FileWriter writer = new FileWriter(file);
    
    		writer.write(xml);
    		writer.flush();
    		writer.close();
	    } catch (JAXBException e) {
	        e.printStackTrace();
	    }
	}
}
