package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testcase.WebTest;
import utils.TestUtils;

//MyAccountPage //button[@type='button'and@class='action switch']
public class MyAccountPage extends WebTest {

    @FindBy(xpath = "//span[starts-with(@class,'logged-in cf')]")
    WebElement myAccountWelcomeMessageDisplayToUser;

    @FindBy(xpath = "(//button[@type='button'])[1]")
    WebElement myAccountDropDown;

    //(//a[normalize-space()='My Account'])[1]

    @FindBy(xpath = "(//a[normalize-space()='My Account'])[1]")
    WebElement myAccountClick;

    @FindBy(xpath = "//span[@data-ui-id='page-title-wrapper']")
    WebElement myAccountTextOnMyAccountPage;

    public MyAccountPage() {
        PageFactory.initElements(driver, this);
    }

    public String textOfElement() {
        return TestUtils.getTextOfElement(myAccountWelcomeMessageDisplayToUser);
        //return TestUtils.getTextOfElement(myAccountTextOnMyAccountPage);

        //possible error ahead
    }
    public String textOfElement2() {
        return TestUtils.getTextOfElement(myAccountTextOnMyAccountPage);
    }





}



