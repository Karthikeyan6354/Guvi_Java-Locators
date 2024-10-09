package assessments_JavaLocators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question1 {

	public static void main(String[] args) {
        
		WebDriver driver=new ChromeDriver();  //Launching the Chrome browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //Implicit wait for 10 seconds
		driver.manage().window().maximize();         //maximizing the browser window
		driver.get("https://jqueryui.com/datepicker/");  //Navigating to this site
		//creating the locator for the iframe
		WebElement frame1=driver.findElement(By.xpath("//iframe[@src='/resources/demos/datepicker/default.html']"));
		driver.switchTo().frame(frame1);  //swithc into the above iframe 
		WebElement datepick=driver.findElement(By.xpath("//input[@id='datepicker']")); //creating locator for the datepicker
		datepick.click();   //clicking the datepicker element
		
		driver.findElement(By.xpath("//a[@title='Next']")).click();  //clicking the next button to select the next month
		driver.findElement(By.xpath("//a[text()='22']")).click();  //selecting the 22nd date 
				
		String selectedDate=datepick.getAttribute("value");   //storing the selected date using get attribute method
		System.out.println("Selected Date from the Date Picker:" + selectedDate); //printing the selected date
		
		driver.close();  //closing the browser instance
		driver.quit();   //quit the webdriver instance
		
				

	}

}
