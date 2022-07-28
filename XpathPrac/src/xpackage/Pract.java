package xpackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Pract {
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Desktop\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://testingmasters.weebly.com/webtables.html");
		
		driver.findElement(By.xpath("(//li/a)[3] ")).click();
		Thread.sleep(3000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);
		System.out.println("Question No: 1)      Print the employee ID's of the candiates whose designation is Analyst.");
		List<WebElement> ids=driver.findElements(By.xpath("(//td[5])[.='Analyst']/preceding-sibling::td[3]"));
		for(WebElement i:ids)
		{
			String empid=i.getText();
			System.out.println(empid);
		}
		
		System.out.println("Question No: 2) Print the Mail Id's of the candidates who have applied for less than or equal to 5 days ");
		List<WebElement> emails=driver.findElements(By.xpath("(//td[7])[.<='5']/preceding-sibling :: td[3]"));
		for(WebElement j:emails)
		{
			String emailid=j.getText();
			System.out.println(emailid);
		}
		
		System.out.println("Question No:  3) Click on the checkboxes of the records whose Designation is Manager. ");
		List<WebElement> e=driver.findElements(By.xpath("(//td[5][.='Manager'])/preceding-sibling :: td[4]"));
		for(WebElement e1:e)
		{
			e1.click();
		}
		System.out.println("Question No: 4) Click on the checkboxes of the records whose applied days are more than 8 days");
		List<WebElement> check=driver.findElements(By.xpath("(//td[7])[.>'8']/preceding-sibling::td[6]"));
		for(WebElement k:check)
		{
			k.click();
		}
		
		
		
	
		Actions act=new Actions(driver);
		System.out.println("Question No: 5) Reject the leaves applied by Analyst.");
		List<WebElement> reject=driver.findElements(By.xpath("//td[5][.='Analyst']/following-sibling::td[3]"));
		for(WebElement r:reject)
		{
		act.moveToElement(r).click().build().perform();
		act.sendKeys("Reject").build().perform();
		}
		
		System.out.println("Question No: 6) Print the employee Id's of the approved candidates.");
		List<WebElement> Accepted=driver.findElements(By.xpath("//select/option[@selected='selected' and .='Accepted']"));
		for(WebElement a:Accepted)
		{
		String accepted=a.getText();
		System.out.println(accepted);
		}
		
		System.out.println("Question No: 7) Click on the checkboxes of the records whose username is Vinod and Designation is analyst.");
		List<WebElement> vinod=driver.findElements(By.xpath("//td[5][.='Analyst']/preceding-sibling::td[2][.='Vinod']/preceding-sibling::td[2]"));
		for(WebElement v:vinod)
		{
			v.click();
		}
		
		
		System.out.println("Question No: 8) Click on checkboxes of first five records.");
		List<WebElement> first5=driver.findElements(By.xpath("(//td[1])[position()<6]"));
		for(WebElement f5:first5)
		{
			f5.click();
		}
		
		System.out.println("Question No: 9) Clik on checkboxes of last 4 records.");
		List<WebElement> last4=driver.findElements(By.xpath("(//td[1])[position()>9]"));
		for(WebElement l:last4)
		{
			l.click();
		}
		
		System.out.println("Question No: 10)  Click on checkboxes whose email id starts with 'demo'.");
		List<WebElement> demo=driver.findElements(By.xpath("//td[4][contains(text(),'demo')]/preceding-sibling::td[3]"));
		for(WebElement d:demo)
		{
			d.click();
		}
	}

}
