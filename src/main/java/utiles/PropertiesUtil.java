package utiles;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.Properties;

@Getter
public class PropertiesUtil {

    private static final Properties properties = new Properties();

    @SneakyThrows
    public static String getProperty(String prop) {
        if (properties.isEmpty()) {
            Class<PropertiesUtil> utilClass = PropertiesUtil.class;
            properties.load(utilClass.getResourceAsStream("/app.properties"));
        }
        return properties.getProperty(prop);
    }
}
