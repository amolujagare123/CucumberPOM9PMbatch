package Pages;

import org.openqa.selenium.By;

public class LoginPage extends  DarkskyAPIPage{

    By btnlogin = By.xpath("//button");

    public void clickbtnLogin()
    {
        clickOn(btnlogin);
    }


}
