package assessments_JavaLocators;

import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question3 {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();  //Launching the chrome Driver
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait for 10 seconds
		driver.get("https://www.guvi.in/"); //navigating the guvi site
		driver.manage().window().maximize(); //Maximizing the window
		
		driver.findElement(By.linkText("Sign up")).click();  //clicking the sign-up button
		
		String title1=driver.getTitle();  //Storing the title of page 
		if (title1.equals("GUVI | Sign Up"))  //Verifying the page, whether its sign up or not
			System.out.println("You are in the registration page and proceed");
		else
			System.out.println("Incorrect Page");
		//Passing the values to the below locators by using sendkeys method
		driver.findElement(By.id("name")).sendKeys("Sherman Dausses");
		driver.findElement(By.id("email")).sendKeys("Shermand@domain.com");
		driver.findElement(By.id("password")).sendKeys("Karthi123");
		driver.findElement(By.id("mobileNumber")).sendKeys("1234567890");
		
		driver.findElement(By.cssSelector("#signup-btn")).click(); //clicking the submit button
		driver.findElement(By.xpath("//a[@id='laterBtn']")).click();  //clicking the later button
		
		driver.navigate().refresh(); //refreshing the site
		
		driver.findElement(By.xpath("//a[@class='login']")).click(); //clicking the login page
		String title2=driver.getTitle();
		Assert.assertEquals(title2, "GUVI | Login");   //Asserting the title of page, whether its login or not
		System.out.println("Navigated to login page");
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Shermand@domain.com"); //passing the email to login
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Karthi123"); //Passing the password to login
		driver.findElement(By.xpath("//a[@id='login-btn']")).click(); //clicking the login button
		
		
		
	
		
		
		

	}

}
