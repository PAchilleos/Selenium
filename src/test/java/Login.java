import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
    PSE P = new PSE();

    @FindBy(css = "form center table tr:nth-child(1) td:nth-child(2)  input")
    private WebElement usernameInput;

    @FindBy(css="form center table tr:nth-child(2) td:nth-child(2) input[type=\"password\"]")
    private WebElement passwordInput;

    @FindBy(xpath="/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")
    private WebElement clicky;


    public void enterusername(String u){
        usernameInput.sendKeys(u);
        P.t(1);
    }

    public void enterpassword(String p){
        passwordInput.sendKeys(p);
        P.t(1);
    }

    public void click1(){
        clicky.click();
        P.t(2);
    }


}
