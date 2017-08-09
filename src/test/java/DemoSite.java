
import com.aventstack.extentreports.Status;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class DemoSite {

private WebDriver wd;
private Homepage hp;
private CreateUser cu;
private Login l;
private Wait<WebDriver> wait;
private TestReport TR;
private ScreenShot S = new ScreenShot();
private int counter =0;
private static SpreadSheetReader sheetread;
private static ArrayList<List<String>> rows;



//@BeforeClass
public static void crd(){
    sheetread = new SpreadSheetReader("C:\\Users\\Administrator\\Desktop\\psswds.xlsx");
    rows = new  ArrayList<List<String>>();
    for(int i =1; i<5;i++){
        List<String> row = sheetread.readRow(i, "Sheet1");
        rows.add(row);

    }
}

    @Before
    public void before() {
        TR= new TestReport();
        TR.setUp(rows.get(counter).get(0));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        wd = new ChromeDriver(options);
        hp = PageFactory.initElements(wd,Homepage.class);
        cu = PageFactory.initElements(wd,CreateUser.class);
        l= PageFactory.initElements(wd,Login.class);
    }

    @Parameters
    public static Collection<Object[]> data(){
    crd();


        return Arrays.asList(new Object[][] {  //GETTING NULL POINTER EXCEPTION
                { rows.get(0).get(2), rows.get(0).get(3) },
                { rows.get(1).get(2), rows.get(1).get(3) },
                { rows.get(2).get(2), rows.get(2).get(3) },
                { rows.get(3).get(2), rows.get(3).get(3) }
        });
    }
    @Parameter
    public String usr;
    @Parameter(1)
    public String pass;



//        public vals(String User, String Password) {
//            usr= User;
//            pass= Password;
//        }




        @Test
        public void demsit () {
       //String usr = rows.get(counter).get(2);
       //String pass = rows.get(counter).get(3);

        FW fl = new FW();


        wait = fl.wt(wd, 30, 5);

        wd.navigate().to("http://thedemosite.co.uk/index.php");
        TR.getExtentTest().log(Status.INFO, "Navigated to homepage");

        fl.xpathcon(wd, "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]");
        hp.clickthis(wd);
        TR.getExtentTest().log(Status.INFO, "Navigated to the page to enter a user");

        fl.csscon(wd, "form center table tr:nth-child(1) > td:nth-child(2) input");
        cu.enterusername(usr);

        fl.csscon(wd, "form center table tr:nth-child(2) td:nth-child(2) input[type=\"password\"]");
        cu.enterpassword(pass);
        TR.getExtentTest().log(Status.INFO, "Entered Username and Password");
        try {
            S.take(wd, "ScreenShot");
        } catch (IOException e) {
            e.printStackTrace();
        }


        fl.xpathcon(wd, "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input");
        cu.click1();
        TR.getExtentTest().log(Status.INFO, "Confirmed User details");


        fl.xpathcon(wd, "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]");
        cu.click2();
        TR.getExtentTest().log(Status.INFO, "Navigated to the login page");

        fl.csscon(wd, "form center table tr:nth-child(1) td:nth-child(2)  input");
        l.enterusername(usr);

        fl.csscon(wd, "form center table tr:nth-child(2) td:nth-child(2) input[type=\"password\"]");
        l.enterpassword(pass);
        TR.getExtentTest().log(Status.INFO, "Entered Identical user details");

        fl.xpathcon(wd, "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input");
        l.click1();
        TR.getExtentTest().log(Status.INFO, "Confirmed User details");

        String txt = wd.findElement(By.cssSelector("big b")).getText();
        System.out.println(txt);

        assertEquals("**Successful Login**", txt);
        TR.getExtentTest().log(Status.INFO, "Tested whether the login was successful");

    }



    @After

    public void af(){
        TR.getReport().flush();
        wd.quit();
        counter++;
    }




}
