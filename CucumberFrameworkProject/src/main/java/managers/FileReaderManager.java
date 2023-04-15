package managers;

import dataproviders.ConfigFileReader;

public class FileReaderManager {
       private static FileReaderManager fileReaderManager ;
       private static ConfigFileReader configFileReader;
       
       private FileReaderManager() {
    	   
       }
       
       
       public static FileReaderManager getinstance() {
    	 return fileReaderManager = new FileReaderManager(); 
       }
       
       
       public ConfigFileReader getConfigFileReader() {
    	   return(configFileReader==null)? new ConfigFileReader():configFileReader;
    	   }
       
       
       
       
       
       
       
       
       
       
       
}
