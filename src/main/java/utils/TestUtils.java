package utils;

import org.openqa.selenium.WebElement;

public class TestUtils {

    public static final long IMPLICIT_WAIT = 20;
    public static final long PAGE_LOAD_WAIT = 20;
    public static String getTextOfElement(WebElement element){//why did static expalnation
        return element.getText();
    }

}
