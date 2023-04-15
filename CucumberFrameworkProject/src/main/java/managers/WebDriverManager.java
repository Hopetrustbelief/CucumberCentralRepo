package managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import enums.DriverType;
import enums.EnvironmentType;

public class WebDriverManager {
	private  WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
    private static final String CHROME_DRIVER_PROPERTY="webdriver.chrome.property";

 
public WebDriverManager() {
	driverType  = FileReaderManager.getinstance().getConfigFileReader().getBrowser();
	environmentType  = FileReaderManager.getinstance().getConfigFileReader().getEnvironment();
}

public WebDriver createLocalDriver() {
	switch(driverType) {
	case CHROME :
		System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getinstance().getConfigFileReader().getDriverPath());
		driver=new ChromeDriver();
		break;
	
	case FIREFOX :
		driver = new FirefoxDriver();
		break;
	
	case INTERNETEXPLORER:
		driver = new InternetExplorerDriver();	
		break;
	}
	
	if(FileReaderManager.getinstance().getConfigFileReader().getWindowMaximize())driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(FileReaderManager.getinstance().getConfigFileReader().getImplicitlyWait(),TimeUnit.SECONDS);
	return driver;
	
}

public WebDriver createRemoteDriver() {
	throw new RuntimeException("Remote webdriver is not yet implemented");
}

public WebDriver createDriver() {
	switch(environmentType) {
	case LOCAL :driver=createLocalDriver();
	break;
	case REMOTE :driver=createRemoteDriver();
	break;
	}
return driver;	
}

public WebDriver getDriver() {
	if(driver==null)driver=createDriver();
	return driver;
}

public void closeDriver() {
	driver.close();
	driver.quit();
}














}