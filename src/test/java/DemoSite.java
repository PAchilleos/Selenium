import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

public class DemoSite {

private WebDriver wd;
private Homepage hp;
private CreateUser cu;
private Login l;

    @Before
    public void before() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        PSE P = new PSE();
        wd = new ChromeDriver(options);
        hp = PageFactory.initElements(wd,Homepage.class);
        cu = PageFactory.initElements(wd,CreateUser.class);
        l= PageFactory.initElements(wd,Login.class);

    }


    @Test
    public void demsit() {

        wd.navigate().to("http://thedemosite.co.uk/index.php");
        hp.clickthis();

        cu.enterusername("Pro3");
        cu.enterpassword("abcdefg");
        cu.click1();
        cu.click2();

        l.enterusername("Pro3");
        l.enterpassword("abcdefg");
        l.click1();


    }
    @After
    public void af(){
        wd.quit();
    }


}
