package assessmentJavaLocators1;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question2 {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		driver.manage().window().maximize();
		
		WebElement topframe=driver.findElement(By.xpath("//frame[@name='frame-top']"));
		//driver.switchTo().defaultContent();
		List <WebElement> frames=driver.findElements(By.tagName("frame"));
		int framesize=frames.size();
		if(framesize==3)
			System.out.println("Test Pass: Total number of frames are matching and its 3");
		else
			System.out.println("Test Fail: Total number of frames are not matching and its: "+framesize);
		driver.switchTo().frame(topframe);
		
		WebElement leftframe=driver.findElement(By.xpath("//frame[@name='frame-left']"));
		driver.switchTo().frame(leftframe);
		System.out.println();
		String message1=driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText();
		Assert.assertEquals("LEFT", message1);
		System.out.println("Verified, We are in Frame: " +message1);
		driver.switchTo().parentFrame();
		
		WebElement middleframe=driver.findElement(By.xpath("//frame[@name='frame-middle']"));
		driver.switchTo().frame(middleframe);
		System.out.println();
		String message2=driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]")).getText();
		Assert.assertEquals("MIDDLE", message2);
		System.out.println("Verified, We are in Frame: " +message2);
		driver.switchTo().parentFrame();
				
		WebElement rightframe=driver.findElement(By.xpath("//frame[@name='frame-right']"));
		driver.switchTo().frame(rightframe);
		System.out.println();
		String message3=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]")).getText();
		Assert.assertEquals("RIGHT", message3);
		System.out.println("Verified, We are in Frame: " +message3);
		driver.switchTo().defaultContent();
		
		WebElement bottomframe=driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
		driver.switchTo().frame(bottomframe);
		System.out.println();
		String message4=driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]")).getText();
		Assert.assertEquals("BOTTOM", message4);
		System.out.println("Verified, We are in Frame: " +message4);
		driver.switchTo().defaultContent();
				
		String title=driver.getTitle();
		System.out.println();
		if (title=="Frames")
			System.out.println("Title of page is mathcing with Frames");
		else
			System.out.println("Title of page is unmathcing: "+title);
	}

}
