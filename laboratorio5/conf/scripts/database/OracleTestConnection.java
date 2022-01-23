import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class OracleTestConnection {
    
    private static final String DB_PROPERTIES = "db.properties";
    private static final String CONNECTION_STRING = "jdbc:oracle:thin:@//%s:%d/%s";
    
    private static final String KEY_DB_PORT     = "DB_PORT";    
    private static final String KEY_DB_HOST     = "DB_HOST";
    private static final String KEY_DB_SERVICE  = "DB_SERVICE_NAME";
    private static final String KEY_DB_USERNAME = "DB_USERNAME";
    private static final String KEY_DB_PASSWORD = "DB_PASSWORD";
    
    private static Properties loadDatabaseConfiguration() {
        Properties properties = new Properties();
        try (InputStream is = OracleTestConnection.class.getResourceAsStream(DB_PROPERTIES)) {
            properties.load(is);
            
            return properties;
        } catch (IOException ioe) {
            System.err.println(ioe.toString());
        }
        return null;
    }
    
    private static boolean isDatabaseRunning(Properties properties) {
        int port        = Integer.parseInt(properties.getProperty(KEY_DB_PORT));
        String host     = properties.getProperty(KEY_DB_HOST);
        String sName    = properties.getProperty(KEY_DB_SERVICE);
        String username = properties.getProperty(KEY_DB_USERNAME);
        String password = properties.getProperty(KEY_DB_PASSWORD);
        
	    try (Connection connection = DriverManager.getConnection(String.format(CONNECTION_STRING, 
                                                                               host, 
                                                                               port, 
                                                                               sName), 
                                                                 username, 
                                                                 password)) {
            if (connection != null) {
                return Boolean.TRUE;
            }
        } catch(SQLException sqle) {
            return Boolean.FALSE;
        }
        return Boolean.FALSE;
    }
    
    public static void main(String[] args) {
        Properties properties = loadDatabaseConfiguration();
        if (isDatabaseRunning(properties)) {
            System.out.println("RUNNING");
        } else {
            System.out.println("SHUTDOWN");
        }
    }
    
}
