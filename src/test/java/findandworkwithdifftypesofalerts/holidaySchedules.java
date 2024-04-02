package findandworkwithdifftypesofalerts;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class holidaySchedules {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		

		WebDriverManager.chromedriver().setup();
		 
		WebDriver driver= new ChromeDriver();

		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.manage().window().maximize();

		
		//1) Navigate to becognizant

		driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");

		Thread.sleep(10000);
		
		
		//2)Capture and display user information

	   driver.findElement(By.xpath("//div[@class='_8ZYZKvxC8bvw1xgQGSkvvA==']")).click();
		
	   String userinfo =driver.findElement(By.xpath("//div[@id='mectrl_currentAccount_primary']")).getText();

		System.out.println(userinfo);


		driver.findElement(By.xpath("//*[@id=\"mectrl_main_trigger\"]/div/div")).click();

		//3) Scroll down and Click on holiday calendars
		
		WebElement holidayschedule=	driver.findElement(By.xpath("//div[@title='Holiday Calendars']"));

		js.executeScript("arguments[0].scrollIntoView();", holidayschedule);

		Actions act=new Actions(driver);

		act.moveToElement(holidayschedule).click().perform();
		
		String holidayscheduleurl1=driver.getCurrentUrl();

		//4) Get all information printed in console 

		String page2infocapture =driver.findElement(By.xpath("//*[@id=\"7d9c4d31-51ad-4f1c-bf62-199efc659c76\"]/div/div")).getText();

		System.out.println(page2infocapture);
		
		//5) Validate if we are going to to Holiday schedule or no
		
		String holidayscheduletext=driver.findElement(By.xpath("(//div[@title='Holiday Schedules'])")).getText();
		
		String Expectedholidayscheduletext="Holiday Schedules";
		
		if(holidayscheduletext.equals(Expectedholidayscheduletext))
		{
			System.out.println("========================================================");
			System.out.println("Test Case 1 Passed");
			System.out.println("========================================================");
		}
		else
		{
			System.out.println("========================================================");
			System.out.println("Test Case 1 Failed");
			System.out.println("========================================================");
		}

	

		//6)Click on People -> Rewars,life,work -> Holiday Schedules

		WebElement ClickonPeople =driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[7]/button[1]/span[1]/span[1]/span[1]"));
		ClickonPeople.click();
		
		Thread.sleep(2000);
		
		
		WebElement Element_Rewars_life_work=driver.findElement(By.xpath("//span[normalize-space()='Rewards, Life and Work']"));		

		act.moveToElement(Element_Rewars_life_work).perform();


		WebElement Element_Holiday_Schedules=driver.findElement(By.xpath("//span[normalize-space()='Holiday Schedules']"));

		act.moveToElement(Element_Holiday_Schedules).click().perform();


		String holidayscheduleurl2 =driver.getCurrentUrl();



		//7)Validate Both URL are navigating to same page or no 

		if(holidayscheduleurl1.equals(holidayscheduleurl2))

		{
			System.out.println("========================================================");
			System.out.println("Test Case 2 Passed");
			System.out.println("========================================================");
		}

		else

		{
			System.out.println("========================================================");
			System.out.println("Test Case 2 Failed");
			System.out.println("========================================================");
		}
		
		Thread.sleep(2000);
		
		//8) Validate Holiday Calendars 2024 is being displayed or no
		
		String Holiday_Calendars_2024_text =driver.findElement(By.xpath("//*[@id='holiday-calendars-2024']/span[1]/strong")).getText();
		
		String Expected_Holiday_Calendars_2024_text="Holiday Calendars - 2024";


		if(Holiday_Calendars_2024_text.equals(Expected_Holiday_Calendars_2024_text))

		{

			System.out.println("========================================================");
			System.out.println("Test case 3 passed");
			System.out.println("========================================================");

		}
		else
		{
			System.out.println("========================================================");
			System.out.println("Test case 3 failed");
			System.out.println("========================================================");
		}
		
		//9) Hover and Clicking on India America UK Calendar
		
		WebElement India_America_UK_Calendar_area = driver.findElement(By.xpath("(//div[@data-automation-id='CanvasSection'])[4]"));
		
		act.moveToElement(India_America_UK_Calendar_area ).perform();

		WebElement India_America_UK_Calendar_Button=driver.findElement(By.xpath("(//a[@data-automation-id='button-web-part'])[1]"));
		
		India_America_UK_Calendar_Button.click();
		
		Thread.sleep(3000);
		
		//10) Click on Select All and Download All Documents
		
		WebElement Select_All_Button= driver.findElement(By.xpath("(//i[@data-icon-name='StatusCircleCheckmark'])[1]"));
		Select_All_Button.click();

		WebElement Download_Button= driver.findElement(By.xpath("(//i[@data-icon-name='download'])"));
		Download_Button.click();
		
		
		//11) Validate if We can download them or no

		
		
		//12)Validate The Selected Count is Displayed or no
		
		String Selected_Count_txt=driver.findElement(By.xpath("(//span[contains(text(),'selected')])")).getText();
		
		System.out.println(Selected_Count_txt);
		
		String expected_Selected_Count_txt="12 selected";
		
		if(Selected_Count_txt.equals(expected_Selected_Count_txt))
		{
			System.out.println("========================================================");
			System.out.println("Test case 4 passed");
			System.out.println("========================================================");
		}
		else
		{
			System.out.println("========================================================");
			System.out.println("Test case 4 failed");
			System.out.println("========================================================");
		}
		
		
		//13) Deselect All the selected Documents
		
		WebElement De_Select=driver.findElement(By.xpath("(//i[@data-icon-name='StatusCircleCheckmark'])[1]"));
		De_Select.click();
		
		
		//14) Hover and Click on India_Holiday_Calendars_2024
		
		WebElement India_Holiday_Calendars_2024_Doc = driver.findElement(By.xpath("(//div[@data-automationid='DetailsRowCell'])[47]"));
		act.moveToElement(India_Holiday_Calendars_2024_Doc).perform();

		India_Holiday_Calendars_2024_Doc.click();
		Thread.sleep(5000);
		
		
		//15) Validate if we are navigating to India_Holiday_Calendars_2024_Document or no
		String verify_Document=driver.findElement(By.xpath("(//span[normalize-space()='India- Holiday Calend....pdf'])[3]")).getText();
 
		String expected_verify_Document="India- Holiday Calend....pdf";
		if(verify_Document.equals(expected_verify_Document)) 
		{
			System.out.println("========================================================");
			System.out.println("Test case 5 passed");
			System.out.println("========================================================");
		}
		else
		{
			System.out.println("========================================================");
			System.out.println("Test case 5 failed");
			System.out.println("========================================================");
		}
		Thread.sleep(4000);
		
		//16)Take screenshot
		
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File trg = new File(System.getProperty("user.dir")+"\\Screenshots\\screenshot.png");
		FileUtils.copyFile(src, trg);

 
		//17)Download the PDF Document
		
		WebElement Download_PDF=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[4]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/button[1]/span[1]/span[1]/span[1]"));
		Download_PDF.click();
 
		
		//18)click on options ... and Validate if Version history is displaying or not
		
		WebElement Options_3Dots_Button=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[4]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/button[1]/span[1]/i[1]"));
		Options_3Dots_Button.click();

		String Version_History_text=driver.findElement(By.xpath("//span[normalize-space()='Version history']")).getText();

 
		String expected_Version_History_text="Version history";
		if(Version_History_text.equals(expected_Version_History_text))
		{
			System.out.println("========================================================");
			System.out.println("Test case 6 passed");
			System.out.println("========================================================");
		}
		else
		{
			System.out.println("========================================================");
			System.out.println("Test case 6 failed");
			System.out.println("========================================================");
		}


		//19) Click on Version History and Print All Details Appearing 
		
		WebElement Version_History_Button=driver.findElement(By.xpath("//span[normalize-space()='Version history']"));
		Version_History_Button.click();
		
		driver.switchTo().frame(0);
 
		String ptr=driver.findElement(By.xpath("//div[@id='DeltaPlaceHolderMain']")).getText();

		System.out.println(ptr);
		driver.switchTo().defaultContent();

		WebElement Close_PDF=driver.findElement(By.xpath("//*[@id=\"appRoot\"]/div[3]/div/div[4]/div/div/div[3]/div/div/div/div/div[7]/div/div/div[2]/div[3]/div/div/button"));
		Close_PDF.click();

		//20) Close/Tear Down
		driver.quit();
	}

}
