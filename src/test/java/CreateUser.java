import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUser {
    PSE P = new PSE();

    @FindBy(css = "form center table tr:nth-child(1) > td:nth-child(2) input")
    private WebElement usernameInput;

    @FindBy(css="form center table tr:nth-child(2) td:nth-child(2) input[type=\"password\"]")
    private WebElement passwordInput;

    @FindBy(xpath="/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")
    private WebElement clicky;

    @FindBy(xpath="/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
    private WebElement clicky2;

    public void enterusername(String u){
        usernameInput.sendKeys(u);
        //P.t(1);
    }

    public void enterpassword(String p){
        passwordInput.sendKeys(p);
        //P.t(1);
    }

    public void click1(){
        clicky.click();
        //P.t(1);
    }

    public void click2(){
        clicky2.click();
       //P.t(1);
    }


}
