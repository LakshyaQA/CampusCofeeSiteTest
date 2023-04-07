package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testcase.WebTest;
import java.util.List;

//Webelement declaration
public class CustomerLoginPage extends WebTest {
    @FindBy(id = "email")
    WebElement emailTextBox;

    @FindBy(id = "pass")
    WebElement passTextBox;

    @FindBy(xpath = "(//span[contains(text(),'Sign In')])[1]")
    WebElement signInBtn;

    //for multiple web element list

    @FindBy(tagName = "span")
    List<WebElement> allElements;

    //constructor time

    public CustomerLoginPage(){
        PageFactory.initElements(driver,this);
    }
    //input for login //define variable in string

    public void login(String email, String pass){ //signBtn not defined i string??click
        emailTextBox.sendKeys("celmovamla@gufum.com");
        passTextBox.sendKeys("lakshya123@");
        signInBtn.click();
    }
}
