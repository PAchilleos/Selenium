import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import javafx.stage.Screen;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;


import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class DemoSite {

private WebDriver wd;
private Homepage hp;
private CreateUser cu;
private Login l;
private Wait<WebDriver> wait;
private TestReport TR;
private ScreenShot S = new ScreenShot();




//@BeforeClass




    @Before
    public void before() {
        TR= new TestReport();
        TR.setUp();
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
        TR.getExtentTest().log(Status.INFO,"Navigated to homepage");

        fl.xpathcon(wd,"/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]");
        hp.clickthis(wd);
        TR.getExtentTest().log(Status.INFO,"Navigated to the page to enter a user");

        fl.csscon(wd,"form center table tr:nth-child(1) > td:nth-child(2) input");
        cu.enterusername("Pro5");

        fl.csscon(wd,"form center table tr:nth-child(2) td:nth-child(2) input[type=\"password\"]");
        cu.enterpassword("abcdefg");
        TR.getExtentTest().log(Status.INFO,"Entered Username and Password");
        try {
            S.take(wd,"ScreenShot");
        } catch (IOException e) {
            e.printStackTrace();
        }


        fl.xpathcon(wd,"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input");
        cu.click1();
        TR.getExtentTest().log(Status.INFO,"Confirmed User details");


        fl.xpathcon(wd,"/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]");
        cu.click2();
        TR.getExtentTest().log(Status.INFO,"Navigated to the login page");

        fl.csscon(wd,"form center table tr:nth-child(1) td:nth-child(2)  input");
        l.enterusername("Pro5");

        fl.csscon(wd,"form center table tr:nth-child(2) td:nth-child(2) input[type=\"password\"]");
        l.enterpassword("abcdefg");
        TR.getExtentTest().log(Status.INFO,"Entered Identical user details");

        fl.xpathcon(wd,"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input");
        l.click1();
        TR.getExtentTest().log(Status.INFO,"Confirmed User details");

        String txt = wd.findElement(By.cssSelector("big b")).getText();
        System.out.println(txt);

        assertEquals("**Successful Login**",txt);
        TR.getExtentTest().log(Status.INFO,"Tested whether the login was successful");

    }
    @Test
    public void chk() {
        TR.getExtentTest2().log(Status.INFO, "see if works");
        TR.getExtentTest2().fail("NOO");
        assertEquals(1,2);
        TR.getExtentTest2().pass("WOO");
    }

    @After

    public void af(){
        TR.getReport().flush();
        wd.quit();
    }




}
