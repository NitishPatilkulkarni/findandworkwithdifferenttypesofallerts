package findandworkwithdifftypesofalerts;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class alerts {
	
	public void getScreenShot(WebDriver driver,String imgName) throws IOException {
		
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		File trg = new File(System.getProperty("user.dir")+"\\Screenshots\\"+imgName+"");
		
		FileUtils.copyFile(src, trg);
	}
	
	

	public void getScreenShotWithAlertBox(String imgName) throws IOException, HeadlessException, AWTException {
		
		File trg = new File(System.getProperty("user.dir")+"\\Screenshots\\"+imgName+"");
		
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		
		ImageIO.write(image, "png", trg);
	}
	

	public static void main(String[] args) throws  HeadlessException, IOException, InterruptedException, AWTException {
		// TODO Auto-generated method stub
		WebDriver driver= new EdgeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//1) Open the web application, http://cookbook.seleniumacademy.com/Alerts.html 
		
		driver.get("http://cookbook.seleniumacademy.com/Alerts.html");

//2) Click on Show alert box button. 
		
		driver.findElement(By.xpath("//*[@id=\"simple\"]")).click();
		
//3) Check the message displayed on Alert box is "Hello! I am an alert box!". 
		Alert alert = driver.switchTo().alert();
		
		String FirstalertBoxText = alert.getText();
		
		String FirstexpectedText = "Hello! I am an alert box!";
		
		if(FirstalertBoxText.equals(FirstexpectedText)) 
		{	
			System.out.println("===============================");
			System.out.println("First Test Passed");
			System.out.println(alert.getText());
			System.out.println("===============================");
		}
		else 
		{
			System.out.println("===============================");
			System.out.println("First Test Failed");
			System.out.println("===============================");
		}
		
//4) Take Screenshot (displaying alert box)
		
		alerts obj = new alerts();
		
		obj.getScreenShotWithAlertBox("Firstscreenshot.png");
		
//5) Click on Ok button in the message box. 
		
		driver.switchTo().alert().accept();
		
		
//6) Click on first Try it button. 
	
		driver.findElement(By.xpath("//button[@id='confirm']")).click();
		
		Thread.sleep(500);

//7) Check the message displayed on Alert box is "Press a button!". 
		String secondAlertBoxText = driver.switchTo().alert().getText();
		
		String secondExpectedText = "Press a button!";
		
		if(secondAlertBoxText.equals(secondExpectedText))
		{
			System.out.println("===============================");
			System.out.println("Second Test Passed");
			System.out.println(secondAlertBoxText);
			System.out.println("===============================");
			}
		else
		{
			System.out.println("===============================");
			System.out.println("Second Test Failed");
			System.out.println("===============================");
			}

//8) Take Screenshot (displaying alert box)
		obj.getScreenShotWithAlertBox("Secondscreenshot.png");
		
//9) Click on Cancel button in the message box. 
		driver.switchTo().alert().dismiss();
		
		Thread.sleep(1000);
		
//10) Click on second Try it button. 
		
		driver.findElement(By.xpath("//button[@id='prompt']")).click();
		
		Thread.sleep(1000);
		
//11) Take a screenshot (displaying alert box)
		
		obj.getScreenShotWithAlertBox("Thirdscreenshot.png");
		

//12) Enter your name in the Alert box as "Harry Potter". 
		
		driver.switchTo().alert().sendKeys("Harry Potter");
		
		Thread.sleep(1000);

		
//13) Click on Ok button in the prompt box.
		
		driver.switchTo().alert().accept();
		
		Thread.sleep(1000);
		
		
//14) Take screenshot
		
		obj.getScreenShot(driver,"fourthscreenshot.png");

//15) Close the web application.
		
		driver.quit();
			

	}

}


