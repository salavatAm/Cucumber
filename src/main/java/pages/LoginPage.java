package pages;

import org.openqa.selenium.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;


public class LoginPage {
    public void inputLogin(String login){$(By.name("login")).setValue(login).pressEnter();
    sleep(1000);}
    public void inputPassword(String password){$(By.name("passwd")).val(password).pressEnter();
    sleep(1000);}
}
