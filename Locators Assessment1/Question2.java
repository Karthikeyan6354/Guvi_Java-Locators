package assessments_JavaLocators;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Question2 {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();  //Launching the chrome Browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait for 10 seconds
		driver.get("https://jqueryui.com/droppable/");  //navigating to this site
		driver.manage().window().maximize(); //Maximizing the window
		
		WebElement frame1=driver.findElement(By.xpath("//iframe[@src='/resources/demos/droppable/default.html']"));
		driver.switchTo().frame(frame1);  //Switch into the above frame
		//Creating the webelements for the below locators
		WebElement SourceElement=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement TargetElement=driver.findElement(By.xpath("//div[@id='droppable']"));
		
		Actions objAct=new Actions(driver);  //creating the action class
		objAct.dragAndDrop(SourceElement, TargetElement).perform(); //Perform drag from source and drop to target
		
		String actual_color=TargetElement.getCssValue("color"); //getting the color of target element
        String expected_color="rgba(119, 118, 32, 1)";
               
        if (actual_color.equals(expected_color))  //verifying the color, whether we reached the target or not
        	System.out.println("Matching with the expected color, Test Passed");
        else
        	System.out.println("Unmatched with the expected color, Test Failed");
        
        String message=driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
		Assert.assertEquals("Dropped!", message);  //asserting the message from the target to verify with the message
		System.out.println(message+ " Message verfied and Test successful");
	}

	
	}


