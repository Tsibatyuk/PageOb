package tests;

import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SuiteConfiguration {

        private static final String APPLICATION_PROPERTIES = "/application.properties";

        private Properties properties;

        public SuiteConfiguration() throws IOException {
            this(System.getProperty("application.properties", APPLICATION_PROPERTIES));
        }

        private SuiteConfiguration(String fromResource) throws IOException {
            properties = new Properties();
            properties.load(SuiteConfiguration.class.getResourceAsStream(fromResource));
        }

        @SneakyThrows
        public Capabilities getCapabilities() {
            String capabilitiesFile = properties.getProperty("capabilities");

            Properties capsProps = new Properties();
            capsProps.load(SuiteConfiguration.class.getResourceAsStream(capabilitiesFile));

            DesiredCapabilities capabilities = new DesiredCapabilities();
            for (String name : capsProps.stringPropertyNames()) {
                String value = capsProps.getProperty(name);
                if (value.equalsIgnoreCase("true") || value.toLowerCase().equals("false")) {
                    capabilities.setCapability(name, Boolean.valueOf(value));
                } else if (value.startsWith("file:")) {
                    capabilities.setCapability(name, new File(".", value.substring(5)).getCanonicalFile().getAbsolutePath());
                } else {
                    capabilities.setCapability(name, value);
                }
            }

            return capabilities;
        }

        @SneakyThrows
        public List<String> getOptions() {
            String optionsFile = properties.getProperty("options");
            List<String> options = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(optionsFile));
            String line;
            while ((line = reader.readLine()) != null)
                options.add(line);
            return options;
        }

        public boolean hasProperty(String name) {
            return properties.containsKey(name);
        }

        public String getProperty(String name) {
            return properties.getProperty(name);
        }
}
