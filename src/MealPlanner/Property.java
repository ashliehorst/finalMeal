package MealPlanner;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * PROPERTIES CLASS
 * Gets the files that are stored in the properties file
 * @author Ashlie
 */
public class Property {
    
    // String that gets the path to the properties file
    String propertiesFile = "/resources/prop.properties";
    
    public String getFile() {
	Properties prop = new Properties();
        
        try {
            prop.load(getClass().getResourceAsStream(propertiesFile));
        } catch (IOException ex) {
            Logger.getLogger(Property.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String topicFile = prop.getProperty("recipeFile");
        return topicFile;
    }
    
}
