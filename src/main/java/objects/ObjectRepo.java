package objects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ObjectRepo {
	public Properties config;
	public FileInputStream propertiesFile;
	
	public ObjectRepo(String filePath) throws IOException {
		
		config = new Properties();
		propertiesFile = new FileInputStream("src/test/resources/Properties/"+filePath+"");
		config.load(propertiesFile);//
}

}
