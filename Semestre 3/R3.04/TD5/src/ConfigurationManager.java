import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public final class ConfigurationManager {
    
    private static ConfigurationManager instance = null;
    private Map<String, String> fileParameters = null;

    private ConfigurationManager() {

    }


    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public void loadConfiguration(String filename) throws IOException {
        if(filename == null) {
            throw new RuntimeException("Le fichier est inexistant");
        }

        fileParameters.clear();

        try(FileInputStream file = new FileInputStream(filename)) {
            Properties properties = new Properties();
            properties.load(file);
            for(String name : properties.stringPropertyNames()) {
                fileParameters.put(name, properties.getProperty(filename));
            }
        }
    }  

    public String getParameter(String key) {
        return this.fileParameters.get(key);
    }

    public void setParameter(String key, String value) {
        this.fileParameters.put(key, value);
    }

    
}
