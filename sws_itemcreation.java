package SWS_Item_Creation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sws_itemcreation {

	public static void main(String[] args) throws InterruptedException {

		swsconfigur_reader config = new swsconfigur_reader ();

		String url = config.getUrl();
		String username = config.getUsername();
		String password = config.getPassword();
		String usernameTextfield = config.getusernameTextfield();
		String passwordfield = config.getpasswordfield();

		WebDriver driver = new ChromeDriver();

		// Set implicit wait time (e.g., 10 seconds)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.navigate().to(url);// Launch the URL
		//driver.get(url); // Launch the URL
		driver.manage().window().maximize(); // Maximize the window

		driver.findElement(By.xpath("//button[contains(text(),'Advanced')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Proceed to')]")).click();
		Thread.sleep(6000);

		//Enter Username 
		WebElement usernameField = driver.findElement(By.xpath(usernameTextfield));
		usernameField.sendKeys(username);
		System.out.println("Verify whether user name is entered : " +usernameField.isDisplayed());
		Thread.sleep(3000);

		//Enter password
		WebElement passwordField = driver.findElement(By.xpath(passwordfield));
		passwordField.sendKeys(password);
		System.out.println("Verify whether password is entered : " +passwordField.isDisplayed());

		//Click on submit 
		WebElement Loginbtn = driver.findElement(By.xpath("//span[contains(text(),'LOGIN')]/parent::button"));
		Loginbtn.click();
		System.out.println("Verify whether Login button is enabled :" +Loginbtn.isEnabled());
		Thread.sleep(8000);

		//Env selection from Pag 
		driver.findElement(By.xpath("//mat-select[contains(@formcontrolname,'selectedPag')]/parent::div")).click();
		WebElement Env_selection = driver.findElement(By.xpath("//span[contains(text(),'MMDEV(I2)')]")); 
		Env_selection.click();
		System.out.println("Verify whether user can select Env from Pag selection : " +Env_selection.isSelected());
		Thread.sleep(3000);

		//Submit
		driver.findElement(By.xpath("//span[contains(text(),'PROCEED')]")).click();
		Thread.sleep(8000);
		
		//check whether user logged in to Application
		WebElement Userlogged = driver.findElement(By.xpath("//*[@ng-version='11.2.14']"));
		System.out.println("Verify whether User logged in to Application : " +Userlogged.isDisplayed());
		
		//To print Title of the page 
		String Title = driver.getTitle();
		System.out.println("Title of the Page : " +Title);

		//Global search code - MUCIM - Corporate Item Master maintenance 
		WebElement Globalsearch = driver.findElement(By.xpath("//input[contains(@class,'global-search')]"));
		Thread.sleep(6000);
		Globalsearch.sendKeys("MUCIM");
		Globalsearch.sendKeys(Keys.ENTER);
		Thread.sleep(10000);

		
		driver.findElement(By.xpath("//mat-icon[contains(text(),'close')]/ancestor::button")).click();
		Thread.sleep(6000);

		//check whether user displayed with MUCIM - item creation screen
		WebElement MUCIM = driver.findElement(By.xpath("//*[contains(text(),' Corporate Item Selection ')]"));
		System.out.println("Verify whether User navigated to MUCIM page :" +MUCIM.isDisplayed());
		
		//Create Item in MUCIM
		driver.findElement(By.xpath("//*[contains(text(),'add')]/ancestor::button")).click();

		//Company group selection
		driver.findElement(By.xpath("//*[@formcontrolname='cmpgrp']")).click();
		WebElement Companygroup = driver.findElement(By.xpath("//*[@placeholder='Company Group']"));
		Companygroup.sendKeys("*All");
		driver.findElement(By.xpath("//span[@class='dpt-code']")).click();
		Thread.sleep(5000);

		//product group selection
		driver.findElement(By.xpath("//*[@formcontrolname='itmgrp']")).click();
		WebElement Productgroup = driver.findElement(By.xpath("//input[@placeholder='Search Group']"));
		Productgroup.sendKeys("33");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[contains(text(),' / FOOD ')]/ancestor::mat-option")).click();
		Thread.sleep(5000);

		//Product Subgroup selection
		driver.findElement(By.xpath("//*[@formcontrolname='itmsub']/parent::div")).click();
		WebElement Productsubgroup = driver.findElement(By.xpath("//input[@placeholder='Search Subgroup']/parent::div"));
		Productsubgroup.sendKeys("63");
		driver.findElement(By.xpath("//span[contains(text(),' / MEATS ')]/ancestor::mat-option")).click();
		Thread.sleep(5000);

		//Product Class selection
		driver.findElement(By.xpath("//*[@formcontrolname='itmcod']")).click();
		WebElement Productclass = driver.findElement(By.xpath("//*[@data-placeholder='Search Class']"));
		Productclass.sendKeys("93");
		driver.findElement(By.xpath("//span[normalize-space(text())='/ CHICKEN']/ancestor::mat-option")).click();
		Thread.sleep(5000);

		//abbreviated description
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Abb_descrip = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@formcontrolname='itmabr']")));
		Abb_descrip.sendKeys("Test auto 22");

		//Item description
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(12));
		WebElement Item_descrip = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@formcontrolname='itmdsc']")));
		Item_descrip.sendKeys("Test auto 22");
		Thread.sleep(1000);

		//Unit of measure selection
		driver.findElement(By.xpath("//*[contains(text(),' U/M & Ratios ')]/ancestor::div[@class='mat-ripple mat-tab-label mat-focus-indicator ng-star-inserted']")).click();
		driver.findElement(By.xpath("//*[@formcontrolname='itmum1']/parent::div")).click();
		WebElement UOM1 = driver.findElement(By.xpath("//*[@data-placeholder='Search U/M']"));
		UOM1.sendKeys("CASE STANDAR");
		driver.findElement(By.xpath("//*[text()=' CASE STANDAR ']/ancestor::mat-option")).click();

		driver.findElement(By.xpath("//*[contains(text(),'swap_horiz')]/parent::span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(text(),'Close')]/parent::button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(text(),'Save')]/parent::button")).click();
		Thread.sleep(3000);
		
		WebElement Itemnumb = driver.findElement(By.xpath("//div[contains(text(),' Corporate Item Master Maintenance ')]"));
		String NewItem = Itemnumb.getText();
		System.out.println(NewItem);
		
		String[] parts = NewItem.split("[()]");
		String itemNumber = parts[1];
		//String itemNumber = text.substring(text.indexOf("(") + 1, text.indexOf(")"));
		System.out.println("Extracted Item Number: " + itemNumber);

		//WebElement docnumberElement = driver.findElement(By.xpath("//input[contains(@data-placeholder,'Document Number')]"));
		//String documentnumber = docnumberElement.getAttribute("value");
		//System.out.println("PO NUMBER: " + documentnumber);

		//WebElement Itemnumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Corporate Item Master Maintenance')]/following::span")));
		//String Itmno = Itemnumber.getText();
		//System.out.println("Updated Text: " + Itmno);

		driver.findElement(By.xpath("//*[contains(text(),'delete')]")).click();
		Thread.sleep(5000);

		WebElement Itemnumber = driver.findElement(By.xpath("(//*[contains(text(),'3363933163')])[2]"));
		String Itmnum = Itemnumber.getText();
		System.out.println("Item number : " + Itmnum);
		System.out.println("Verify whether Item number is created : " +Itemnumber.isDisplayed());

		driver.findElement(By.xpath("//*[@class='p-md main-popup-override-footer ng-star-inserted']/child::button/span[contains(text(),'Cancel')]")).click();
		driver.findElement(By.xpath("//*[@class='p-sm sticky-footer ng-star-inserted']/child::button/span[contains(text(),'Cancel')]")).click();
		Thread.sleep(8000);

		WebElement Itmnum_search = driver.findElement(By.xpath("//*[@class='mat-header-row cdk-header-row ng-star-inserted mat-table-sticky']/following::mat-header-cell/section/input[1]"));
		Itmnum_search.sendKeys("3363933163");

		driver.findElement(By.xpath("//mat-icon[contains(text(),'search')]/ancestor::button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(text(),'3363933163')]/parent::mat-cell/following::mat-icon[contains(text(),'shopping_basket')]/ancestor::button")).click();

		Thread.sleep(5000);

		driver.close();

	}

}
