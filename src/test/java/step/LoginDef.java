package step;

import com.codeborne.selenide.Condition;
import config.UserConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import pages.LoginPage;
import pages.ProfilePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginDef {

    ProfilePage profilePage = new ProfilePage();
    @Then("logout")
    public void logout() {
        profilePage.userLogout();
    }

    @Given("I am on sign in page")
    public void iAmOnSignInPage() {
        open("https://passport.yandex.ru/");

    }

    LoginPage loginPage = new LoginPage();
    @Then("I input login and password")
    public void iInputLoginAndPassword() {
        loginPage.inputLogin(UserConfig.USER_LOGIN);
        loginPage.inputPassword(UserConfig.USER_PASSWORD);
    }

    @And("I need to see {string} on profile page")
    public void iNeedToSeeOnProfilePage(String arg0) {
        $(By.xpath("//*[contains(@class, 'personal-info-login__text personal-info-login__text_decorated')]")).shouldHave(Condition.text(arg0));
    }

    @And("I go to services page")
    public void iClickButton() {
        profilePage.goToMyServices();
    }
}
