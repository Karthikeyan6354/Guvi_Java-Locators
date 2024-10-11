package assessmentJavaLocators1;

import java.time.Duration;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question2 {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();   //Launching the chrome browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://the-internet.herokuapp.com/nested_frames");  //Navigating to the link
		driver.manage().window().maximize();   //Maximizing the window
		
		WebElement topframe=driver.findElement(By.xpath("//frame[@name='frame-top']")); //switch into top frame
		driver.switchTo().frame(topframe);
		List <WebElement> frames=driver.findElements(By.tagName("frame"));
		int framesize=frames.size();   //Calculating the number of frames
		if(framesize==3)   //verifying the number of frames are 3 or not
			System.out.println("Test Pass: Total number of frames are matching and its 3");
		else
			System.out.println("Test Fail: Total number of frames are not matching and its: "+framesize);
		
		//Swiching into left frame and reading the message from that frame
		WebElement leftframe=driver.findElement(By.xpath("//frame[@name='frame-left']"));
		driver.switchTo().frame(leftframe);
		System.out.println();
		String message1=driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText();
		Assert.assertEquals("LEFT", message1);
		System.out.println("Verified, We are in Frame: " +message1);
		driver.switchTo().parentFrame(); //Switching into Top frame
		
		//Switching into Middle frame and reading the message from that frame
		WebElement middleframe=driver.findElement(By.xpath("//frame[@name='frame-middle']"));
		driver.switchTo().frame(middleframe);
		System.out.println();
		String message2=driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]")).getText();
		Assert.assertEquals("MIDDLE", message2);
		System.out.println("Verified, We are in Frame: " +message2);
		driver.switchTo().parentFrame();  //Switching into Top frame
		
		//Switching into right frame and reading the message from that frame
		WebElement rightframe=driver.findElement(By.xpath("//frame[@name='frame-right']"));
		driver.switchTo().frame(rightframe);
		System.out.println();
		String message3=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]")).getText();
		Assert.assertEquals("RIGHT", message3);
		System.out.println("Verified, We are in Frame: " +message3);
		driver.switchTo().defaultContent(); //Switching into web page
		
		//Switching into bottom frame and reading the message from that frame
		WebElement bottomframe=driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
		driver.switchTo().frame(bottomframe);
		System.out.println();
		String message4=driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]")).getText();
		Assert.assertEquals("BOTTOM", message4);
		System.out.println("Verified, We are in Frame: " +message4);
		driver.switchTo().defaultContent();   //Switching into web page
		driver.switchTo().frame(topframe);    //Switching into top frame
				
		String title=driver.getTitle();     //Verifying the title of page
		System.out.println();
		if (title=="Frames")
			System.out.println("Title of page is mathcing with Frames");
		else
			System.out.println("Title of page is unmathcing: "+title);
	}

}
