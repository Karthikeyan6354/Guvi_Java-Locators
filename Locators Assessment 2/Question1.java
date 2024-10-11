package assessmentJavaLocators1;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();  //Launching the Chrome browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));   //implicit wait
		driver.manage().window().maximize();  //Maximizing the browser window
		driver.get("https://the-internet.herokuapp.com/windows");  //Navigating to this website
		driver.findElement(By.linkText("Click Here")).click(); //locating the 'click here' link by using link text to click
		String ParentWindow=driver.getWindowHandle();   //Getting the id for Parent window
		 
		Set <String> windowsID=driver.getWindowHandles(); //Storing all window's id to SET by using this method
		String ChildWindow = null;
		for (String WinIds:windowsID)  //To verify the new window's id
		{
			String winnew=WinIds;
			if(!(ParentWindow==winnew))
				ChildWindow=winnew;
		}
		driver.switchTo().window(ChildWindow);   //Switch into new window
		String msg=driver.findElement(By.xpath("//h3[text()='New Window']")).getText(); //getting the text from new window
		System.out.println("Message from new Window: " +msg);
		Thread.sleep(5000);
		driver.close();         //closing the new window
				
		driver.switchTo().window(ParentWindow);  //Switching into parent window
		String currentWindow=driver.getWindowHandle();
		if(driver.getWindowHandle().equals(currentWindow))   //verify the original window is active or not
			System.out.println("Original window is active");
		else
			System.out.println("Its not the original window");
	}

}
