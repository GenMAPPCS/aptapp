/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anurag Sharma, the user
 */
public class ConfigurationReader {

//    private static final String confFileName = FileLocator.confPropertiesFileLocation;
    private static final String confDirName = FileLocator.confDirLocation;
    private Properties configurationProperties;

    public ConfigurationReader() throws IOException {
        File confDir = new File(confDirName);
        if (!confDir.exists()) {
            confDir.mkdir();
        }

        File confFile = new File(FileLocator.confPropertiesFileLocation);//confDirName + "/" + confFileName);
        if (!confFile.exists()) {
            confFile.createNewFile();
        }
        configurationProperties = new Properties();
        configurationProperties.load(new FileInputStream(confFile));
    }

    public String getValueOf(String key) {
        return configurationProperties.getProperty(key);
    }

    public void setValueOf(String key, String value) {
        configurationProperties.setProperty(key, value);
        try {
            configurationProperties.store(new FileWriter(new File(FileLocator.confPropertiesFileLocation)), "hehehahhaha");
        } catch (IOException ex) {
            Logger.getLogger(ConfigurationReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setCELDirectory(String dir) {
        setValueOf("cel_dir", dir);
    }

    public String getCELDirectory() {
        String dir = getValueOf("cel_dir");
        if (dir == null) {
            return null;
        }
        if (new File(dir).exists()) //return it if it exists
        {
            return dir;
        }
        return ".";     //return the current directory if the directory doesnot exist
    }
}
