package pages;

import org.openqa.selenium.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {
    public void goToYandexDrive(){
        $(By.xpath("//*[contains(@class, 'user-pic__image')]")).click();
        $(byText("Мой диск")).click();
    }
    public void userLogout(){
        $(By.xpath("//*[contains(@class, 'user-pic__image')]")).click();
        $(byText("Выйти")).click();
    }
    public void goToMyServices(){
        $(byText("Мои сервисы")).click();

    }
}
