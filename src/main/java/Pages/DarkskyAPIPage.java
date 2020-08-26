package Pages;

import org.openqa.selenium.By;

public class DarkskyAPIPage extends DarkskyHomePage {

    By lnkLogin = By.xpath("//a[contains(text(),'Log In')]");

    public void clickLnkLogin()
    {
        clickOn(lnkLogin);
    }
}
