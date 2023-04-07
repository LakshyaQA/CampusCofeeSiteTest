package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testcase.WebTest;

//always use page in end as surfix
public class HomePage extends WebTest {

    @FindBy(xpath ="(//li[@class='authorization-link']//child::a[contains(text(),'Sign')])[1]")
    WebElement homePageSignInBtn;

    //define constructor //imp
    public HomePage(){

        PageFactory.initElements(driver,this);
    }
    public void clickOnSignInBtn(){
        homePageSignInBtn.click();
    }




}
