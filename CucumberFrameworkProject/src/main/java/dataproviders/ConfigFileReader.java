package dataproviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = "C:\\Users\\ELCOT\\eclipse-workspace\\CucumberFrameworkProject\\configs\\Configuration.properties";

	public ConfigFileReader() {

		BufferedReader reader;

		try {

			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();

			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("configuration.properties not found at " + propertyFilePath);
		}

	}

	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException(
					"Driverpath not specified in the configuration.properties file for the key: driverPath");
	}

	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty(" implicitWait");
		if (implicitlyWait != null) {
			try {
				return Long.parseLong(implicitlyWait);
			} catch (NumberFormatException e) {
				throw new RuntimeException(
						"ImplicitlyWait not specified in the configuration.properties file for the key: implicitlyWait");
			}
		}

		return 30;

	}

	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException(
					"Application Url not specified in the configuration.properties file for the key: url");

	}

	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if (browserName == null || browserName.equalsIgnoreCase("chrome"))
			return DriverType.CHROME;
		else if (browserName.equalsIgnoreCase("firefox"))
			return DriverType.FIREFOX;
		else if (browserName.equalsIgnoreCase("iexplorer"))
			return DriverType.INTERNETEXPLORER;
		else
			throw new RuntimeException(
					"Browsername not matched in the configuration.properties file for the key: browser");
	}

	public EnvironmentType getEnvironment() {
		String environmentName = properties.getProperty("environment");
		if (environmentName == null || environmentName.equalsIgnoreCase("local"))
			return EnvironmentType.LOCAL;
		else if (environmentName.equalsIgnoreCase("remote"))
			return EnvironmentType.REMOTE;
		else
			throw new RuntimeException(
					"Environmentname not matched in the configuration.properties file for the key: browser");

	}

	public Boolean getWindowMaximize() {
		String windowSize = properties.getProperty("windowMaximize");
		if (windowSize != null)
			return Boolean.valueOf(windowSize);
		return true;
	}

}
