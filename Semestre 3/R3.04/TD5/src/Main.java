import java.io.IOException;

public class Main {
    
    public static void main(String[] args) {
        ConfigurationManager config = ConfigurationManager.getInstance();

        try {
            config.loadConfiguration(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
