package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class BasicPage {
    public void clickButton(String text){$(byText(text)).click(); sleep(10000);}
}
