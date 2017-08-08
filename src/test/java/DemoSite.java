import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DemoSite {

private WebDriver wd;

    @Before
    public void before() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        wd = new ChromeDriver(options);
    }


    @Test
    public void demsit() {
        wd.navigate().to("http://thedemosite.co.uk/index.php");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wd.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")).click();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wd.findElement(By.cssSelector("form center table tr:nth-child(1) > td:nth-child(2) input")).sendKeys("Pro1");
        wd.findElement(By.cssSelector("form center table tr:nth-child(2) td:nth-child(2) input[type=\"password\"]")).sendKeys("abcdefg");
        wd.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")).click();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wd.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")).click();
        wd.findElement(By.cssSelector("form center table tr:nth-child(1) td:nth-child(2)  input")).sendKeys("Pro1");
        wd.findElement(By.cssSelector("form center table tr:nth-child(2) td:nth-child(2) input[type=\"password\"]")).sendKeys("abcdefg");
        wd.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")).click();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }








    }
    @After
    public void af(){
        wd.quit();
    }

}
