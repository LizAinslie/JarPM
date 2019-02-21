package org.jarpm.cli.commands;

import static java.lang.System.out;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import picocli.CommandLine.Command;

import org.apache.commons.io.FileUtils;

import org.jarpm.config.structs.Config;
import org.jarpm.config.Writer;
import org.jarpm.utils.file.Path;

@Command(mixinStandardHelpOptions=true, version="1.0.0", name="init")
public class InitCommand implements Runnable {
    private String dir;
    private String pkg;
    private String ver;
    private Scanner scanner = new Scanner(System.in);
    
	public void run() {
	    String currentDirName = System.getProperty("user.dir").split(File.separator)[System.getProperty("user.dir").split(File.separator).length - 1];
	    
		out.println("Initializing new project in " + System.getProperty("user.dir") + "...");
		
		out.print("Dependency Directory [lib]: ");
		dir = scanner.nextLine();
		if (dir == "") dir = "lib";
		
		out.print("Package Name [" + currentDirName + "]: ");
		pkg = scanner.nextLine();
		if (pkg == "") pkg = currentDirName;
		
		out.print("Version [1.0.0]: ");
		ver = scanner.nextLine();
		if (ver == "") ver = "1.0.0";
	    
	    mkCfg();
	    mkLibDir(System.getProperty("user.dir") + File.separator + dir);
    }
    
    private void mkCfg() {
        try {
	        String depsDir = Path.sanitizeDirectoryName(dir);
		    String writePath = System.getProperty("user.dir") + File.separator + "jarpm.xml";
			Config conf = new Config();
			conf.dependencyDir = depsDir;
			conf.dependencies = new String[] {};
			conf.packageName = pkg;
			conf.version = ver;
			Writer.writeNew(writePath, conf);
			out.println("Successfully initialized config at " + writePath + ".");
	    } catch(IOException e) {
	        e.printStackTrace();
	    }
    }

    private void mkLibDir(String dirPath) {
        try {	
			if(dirPath!=null && !"".equals(dirPath.trim())) {
				File dirFileObj = FileUtils.getFile(dirPath);
		        
		        if (!dirFileObj.exists()) {
		           FileUtils.forceMkdir(dirFileObj);
			       out.println("Successfully initialised library directory in " + dirPath + ".");
		        } else return;
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		}
    }
}

