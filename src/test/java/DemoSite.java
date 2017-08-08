
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import static org.junit.Assert.assertEquals;

public class DemoSite {

private WebDriver wd;
private Homepage hp;
private CreateUser cu;
private Login l;
private Wait<WebDriver> wait;

    @Before
    public void before() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        wd = new ChromeDriver(options);
        hp = PageFactory.initElements(wd,Homepage.class);
        cu = PageFactory.initElements(wd,CreateUser.class);
        l= PageFactory.initElements(wd,Login.class);
    }

    @Test
    public void demsit() {
        FW fl= new FW();
        wait = fl.wt(wd,30,5);

        wd.navigate().to("http://thedemosite.co.uk/index.php");

        fl.xpathcon(wd,"/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]");
        hp.clickthis();

        fl.csscon(wd,"form center table tr:nth-child(1) > td:nth-child(2) input");
        cu.enterusername("Pro4");

        fl.csscon(wd,"form center table tr:nth-child(2) td:nth-child(2) input[type=\"password\"]");
        cu.enterpassword("abcdefg");

        fl.xpathcon(wd,"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input");
        cu.click1();

        fl.xpathcon(wd,"/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]");
        cu.click2();

        fl.csscon(wd,"form center table tr:nth-child(1) td:nth-child(2)  input");
        l.enterusername("Pro4");

        fl.csscon(wd,"form center table tr:nth-child(2) td:nth-child(2) input[type=\"password\"]");
        l.enterpassword("abcdefg");

        fl.xpathcon(wd,"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input");
        l.click1();

        String txt = wd.findElement(By.cssSelector("big b")).getText();
        System.out.println(txt);

        assertEquals("**Successful Login**",txt);


    }
    @After
    public void af(){
        wd.quit();
    }


}
