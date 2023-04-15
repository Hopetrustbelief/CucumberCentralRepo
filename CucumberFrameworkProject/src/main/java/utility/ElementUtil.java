package utility;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	public boolean findElement(WebDriver driver,WebElement element) {
		boolean flag=false;
		try {
			element.isDisplayed();
			flag=true;
		}
		catch(Exception e) {
			flag=false;
		}
		finally {
			if(flag) {
			System.out.println("successfully found element");
		}
		
			else {
				System.out.println("Element not found");		 
				}
		
		}	
		return flag;
	}
	
	
	public boolean isDisplayed(WebDriver driver, WebElement element) {
		boolean flag = false;
		flag= findElement(driver, element);
		if(flag) {
			System.out.println("The element is displayed");
		}
		else {
			System.out.println("The element is not displayed");
		}
		return flag;
	}
	public boolean isEnabled(WebDriver driver, WebElement element) {
		boolean flag =false;
		flag=findElement(driver,element);
		if(flag) {
			System.out.println("The element is  enabled");		
		}
		else {
			System.out.println("The element is not enabled");
		}
		return flag;
	}
	public boolean isSelected(WebDriver driver, WebElement element) {
		boolean flag=false;
		flag=findElement(driver, element);
		if(flag) {
			System.out.println("The element is not selected");
		}
		else {
			System.out.println("The element is not selected");
		}
		return flag;
	}
	
	public boolean enteringText(WebElement element,String text) {
		boolean flag=false;
		try {
		flag=element.isDisplayed();
		element.clear();
		element.sendKeys(text);
		flag=true;
	}
	catch(Exception e) {
		System.out.println("Locator is not found");
		flag=false;
	}
	
	finally {
		
		if(flag) {
			System.out.println("successfully entered text");
		}
		if(!flag) {
			System.out.println("unable to enter the text");
		}
	}
	
	return flag;
			
	}
	
	public boolean dropdownSelectBySendkeys(WebElement element, String value) {
		boolean flag = false;
		try {
		element.sendKeys(value);
		flag=true;
	
		}
		catch(Exception e) {
			
		}
		finally {
			if(flag) {
				System.out.println(" Given value is selected from DropDowm");
			}
			else {
				System.out.println("Given value is selected from DropDowm");
			}
		}
		return flag;
	}
	
	public boolean dropdownSelectByIndex(WebElement element,int indexNo) {
		boolean flag=false;
		try {
			Select select=new Select(element);
			select.selectByIndex(indexNo);
			flag=true;
		}catch(Exception e) {
			flag=false;
		}
		finally {
			if(flag) {
				System.out.println(" Dropdown options selected by IndexNo");
			}
			else {
				System.out.println(" Dropdown options selected by IndexNo");
			}
		}
		return flag;
	}
	
	
	public boolean dropdownSelectByValue(WebElement element,String value) {
		boolean flag= false;
		try {
			Select select=new Select(element);
			select.selectByValue(value);
			flag=true;
		}
		catch(Exception e) {
			flag=false;
		}
		finally {
			if(flag) {
				System.out.println(" Dropdown options selected by value");
			}
			else {
				System.out.println(" Dropdown options not selected by value");
			}
		}
		return flag;
		
	}
	
	
	public boolean dropdownSelectByVisibleText(WebElement element, String text) {
		boolean flag =false;
		try {
			Select select=new Select(element);
			select.selectByVisibleText(text);
			flag=true;
		}
		catch(Exception e) {
			flag=false;
		}
		finally {
			if(flag) {
				System.out.println(" Dropdown options selected by visibletext");
			}
			else {
				System.out.println(" Dropdown options not selected by visibletext");
			}
		}
		return flag;
		
	}
	
	
	
	public boolean  normalClick(WebElement locator, String locatorName) {
		boolean flag=false;
		try {
			locator.click();
			flag=true;
		}
		catch(Exception e) {
			flag=false;
		}
		finally {
			if(flag) {
				System.out.println("Able to click on\"  "+locatorName+" \" ");
			}
			else {
				System.out.println("UaAble to click on\"  "+locatorName+" \" ");
			}
		}
		return flag;
		
	}
	
	public void mouseClick(WebDriver driver, WebElement element) {
		Actions Clicker =new Actions(driver);
		Clicker.moveToElement(element).build().perform();
	}
	
	public boolean mouseRightClick(WebDriver driver,WebElement element) {
		boolean flag= false;
		try {
			Actions rightClicker = new Actions(driver);
			rightClicker.contextClick(element).perform();
			flag=true;
		}
		catch(Exception e) {
			flag=false;
		}
		finally {
			if(flag) {
				System.out.println(" Rightclick action is performed ");
			}
			else {
				System.out.println(" Rightclick action is not performed ");
			}
		}
		return flag;

	}
	
	public boolean mouseOverElement(WebDriver driver, WebElement element) {
		boolean flag=false;
		try {
			Actions mouseover=new Actions(driver);
			mouseover.moveToElement(element).build().perform();
			flag=true;
		}
		catch(Exception e) {
			flag=false;
		}
		
		finally {
			if(flag) {
				System.out.println(" Mouseover action is performed ");
			}
			else {
				System.out.println(" Mouseover action is not performed ");
			}
		}
		
		return flag;
		
	}
	
	public boolean Slider(WebDriver driver,WebElement element,int x, int y) {
		boolean flag=false;
		try {
			Actions slider =new Actions(driver);
			slider.dragAndDropBy(element, x,y).build().perform();
			Thread.sleep(5000);
			flag=true;
		}
		catch(Exception e) {
			flag=false;
		}
		finally {
			if(flag) {
				System.out.println(" Slider action is performed ");
			}
			else {
				System.out.println(" Slider action is not performed ");
			}
		}
		return flag;
	}
	
	public boolean Draggable(WebDriver driver,WebElement source,int x,int y) {
		boolean flag=false;
		try {
			Actions draggable = new Actions(driver);
			draggable.dragAndDropBy(source, x, y);
			flag=true;
		}
		catch(Exception e) {
			flag =false;
		}
		finally {
			if(flag) {
				System.out.println(" Draggable action is  performed ");
			}
			else {
				System.out.println(" Draggable action is not performed ");
			}
		}
		return flag;
	}
	
	public boolean dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		boolean flag=false;
		try {
			Actions dragAndDropObj =new Actions(driver);
			dragAndDropObj.dragAndDrop(source, target);
			flag=true;
		}
		catch(Exception e) {
			flag=false;
		}
		finally {
			if(flag) {
				System.out.println(" DragandDrop action is  performed ");

			}
			else {
				System.out.println(" DragandDrop action is not  performed ");

			}
		}
		return flag;	
	}
	
	

	
	public boolean clickByJavascriptExecutor(WebDriver driver,WebElement element) {
		boolean flag=false;
		try {
			JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
			jsExecutor.executeScript("arguments[0].click();", element);
			flag=true;
		}
		catch(Exception e) {
			flag=false;
		}
		finally {
			if(flag) {
				System.out.println(" JSclick is performed ");	
			}
			else {
				System.out.println(" JSclick is not performed ");	
			}
		}
		
		return flag;
	}
	
	public boolean mouseoverByJavascriptExecutor(WebElement element, WebDriver driver) {
		boolean flag=false;
		try {
			WebElement eelement=element;
			String javaScript ="var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true,false,window,0,0,0,0,0,false,false,false,false,0,null);"
					+"arguments[0].dispatchEvent(evObj);";
			JavascriptExecutor mouseoverjsExecutor=(JavascriptExecutor)driver;
			mouseoverjsExecutor.executeScript(javaScript, eelement);
			flag=true;
		}
		catch(Exception e) {
			flag=true;
		}
		finally {
			if(flag) {
				System.out.println(" MouseoverByJavascriptExecutor is performed ");	
			}
			
			else {
				System.out.println("  MouseoverByJavascriptExecutor is not performed ");	
			}
			
		}
		return flag;
	}
	
	public boolean moveToElementByJavascriptExecutor(WebElement element, WebDriver driver) {
		boolean flag=false;
		try {
			JavascriptExecutor moveTOElementjsExecutor=(JavascriptExecutor)driver;
			moveTOElementjsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
			flag=true;
		}
		catch(Exception e) {
			flag=false;
		}
		finally {
			if(flag) {
				System.out.println(" MoveToElementByJavascriptExecutor is performed ");	
			}
			else {
				System.out.println(" MoveToElementByJavascriptExecutor is not performed ");	
			}
		}
		return flag;
	}
	
	public boolean simpleAlertPresent(WebDriver driver) {
		boolean flag=false;
		Alert simpleAlert=null;
		try {
			 simpleAlert = driver.switchTo().alert();
			 simpleAlert.accept();
			 driver.switchTo().defaultContent();
			 driver.switchTo().alert().sendKeys(null);
			flag=true;
		
		}
		catch(NoAlertPresentException e) {
			flag=false;
		}
		finally {
			if(!flag) {
				System.out.println(" SimpleAlert is handled ");		
			}
			else {
				System.out.println(" SimpleAlert is not handled ");	
			}
		}
		return flag;
	}
	
	public boolean confirmAlertPresent(WebDriver driver,String condition) {
		boolean flag=false;
		Alert confirmAlert =null;
		try {
			confirmAlert = driver.switchTo().alert();
			if(condition.equalsIgnoreCase("accept")) {
				confirmAlert.accept();
				driver.switchTo().defaultContent();
			}
			else if(condition.equalsIgnoreCase("dismiss")) {
				confirmAlert.dismiss();
				driver.switchTo().defaultContent();
			}
			flag=true;
		}
		catch(NoAlertPresentException e) {
			flag=true;
		}
		finally {
			if(!flag) {
				System.out.println(" ConfirmAlert is handled ");		
			}
			else {
				System.out.println(" ConfirmAlert is not handled ");	
			}
		}
		return flag;	
		
	}
	
	public boolean switchToFrameByName(WebDriver driver,String nameValue) {
		boolean flag=false;
		try {
			driver.switchTo().frame(nameValue);
			flag=true;
		}
		catch(Exception e) {
			flag=false;
		}
		finally {
			if(flag) {
				System.out.println(" Frame with Name \" "+  nameValue  +  "\" is selected" );		
			}
			else if(!flag) {
				
			}System.out.println(" Frame with Name \" "+  nameValue  +  "\" is selected" );		
		}
		return flag;
	}
	
	public boolean switchToFrameById(WebDriver driver,String idValue) {
		boolean flag=false;
		try {
			driver.switchTo().frame(idValue);
			flag=true;
		}
		catch(Exception e) {
			flag=false;
		}
		finally {
			if(flag) {
				System.out.println(" Frame with Name \" "+  idValue  +  "\" is selected" );		
			}
			else if(!flag) {
				
			}System.out.println(" Frame with Name \" "+  idValue  +  "\" is selected" );		
		}
		return flag;	
	}
	
	public boolean switchToFrameByIndex(WebDriver driver, int indexNo ) {
		boolean flag=false;
		try {
			driver.switchTo().frame(indexNo);
			flag=true;
		}
		catch(Exception e) {
			flag=false;
		}
		finally {
			if(flag) {
				System.out.println(" Frame with Name \" "+  indexNo  +  "\" is selected" );		
			}
			else if(!flag) {
				
			}System.out.println(" Frame with Name \" "+  indexNo  +  "\" is selected" );		
		}
		return flag;	
		
	}
	
	public boolean switchWindowByTitle(WebDriver driver,String windowTitle,int count) {
		boolean flag=false;
		try {
			Set<String> windowList = driver.getWindowHandles();
			String[] array = windowList.toArray(new String[0]);
			driver.switchTo().window(array[count-1]);
			if(driver.getTitle().contains(windowTitle)) {
				flag=true;
			}
			else {
				flag=false;
			}
			
		}
		catch(Exception e) {
			flag=false;
		}
		finally {
			if(flag) {
				System.out.println("Navigated to the window with title " );			
			}
			else {
				System.out.println("Navigated to the window with title is not selected " );			
			}
		}
		return flag;
	}
	
	public boolean SwitchToNewWindow(WebDriver driver) {
		boolean flag = false;
		try {
		Set<String> s = driver.getWindowHandles();
		Object[] popup = s.toArray();
		driver.switchTo().window(popup[0].toString());
		flag =true;
		}
		catch(Exception e) {
			flag = false;
		}
		finally {
			if(flag) {
				System.out.println("Navigated to the window with title is  selected " );			
			}
			else {
				System.out.println("Navigated to the window with title is not selected " );			
			}
		}
		return flag;
	}
	
	public boolean SwitchToOldWindow(WebDriver driver) {
		boolean flag = false;
		try {
		Set<String> s = driver.getWindowHandles();
		Object[] popup = s.toArray();
		driver.switchTo().window(popup[0].toString());
		flag =true;
		}
		catch(Exception e) {
			flag = false;
		}
		finally {
			if(flag) {
				System.out.println("Navigated to the window with title is  selected " );			
			}
			else {
				System.out.println("Navigated to the window with title is not selected " );			
			}
		}
		return flag;
	}
	
	public void explicitWait(WebDriver driver,WebElement element,int timeOut) {
	      WebDriverWait wait= new WebDriverWait(driver,timeOut);
	      wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void fluentWait(WebDriver driver,WebElement element,int timeOut) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>((WebDriver)driver)
			.withTimeout(Duration.ofSeconds(20))
			.pollingEvery(Duration.ofSeconds(2))
			.ignoring(Exception.class);
		}
		catch(Exception e) {
			
		}
	}
public void pageLoadTimeOut(WebDriver driver,int timeOut) {
	driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
}
	
public String getTitle(WebDriver driver) {
	boolean flag=false;
	String text = driver.getTitle();
	if(flag) {
		System.out.println("Title of the page is:\""+text+"\" " );			
	}
	return text;
}
public String getCurrentURL(WebDriver driver) {
	boolean flag=false;
	String text = driver.getCurrentUrl();
	if(flag) {
		System.out.println("CurrentURL is:\"\""+text+"\" " );			
	}
	return text;
}

public int getRowCount(WebElement table) {
	List<WebElement> rows = table.findElements(By.tagName("tr"));
	int a=rows.size()-1;
	return a;
}


public int getColumnCount(WebElement row) {
	List<WebElement> columns = row.findElements(By.tagName("tr"));
	int a = columns.size();
	System.out.println(columns.size());
	for(WebElement column:columns) {
		System.out.print(column.getText());
		System.out.print("|");
	}
	return a;
}

public String getCurrentTime() {
	String currentDate=new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
	return currentDate;
}


}
