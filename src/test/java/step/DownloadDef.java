package step;

import com.codeborne.selenide.Condition;
import config.UserConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.LoginPage;
import pages.ProfilePage;
import com.codeborne.pdftest.PDF;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class DownloadDef {
    @Given("I go to sign in page")
    public void iGoToSignInPage() {
        open("https://passport.yandex.ru/");
    }
    LoginPage loginPage = new LoginPage();
    @When("I login")
    public void iLoginAsWithPassword() {
        loginPage.inputLogin(UserConfig.USER_LOGIN);
        loginPage.inputPassword(UserConfig.USER_PASSWORD);
    }

    @And("I should see {string} on profile page")
    public void iShouldSeeOnProfilePage(String arg0) {
        $(By.xpath("//*[contains(@class, 'personal-info-login__text personal-info-login__text_decorated')]")).shouldHave(Condition.text(arg0));

    }

    ProfilePage profilePage = new ProfilePage();
    @And("I visit {string} page")
    public void iVisitPage(String arg0) {
        profilePage.goToYandexDrive();
    }

    @And("I download file with name {string}")
    public void iDownloadFileWithName(String arg0) {
        $(byText(arg0)).contextClick();
        sleep(100);
        $(By.xpath("//*[contains(@class, 'Menu-Item Menu-Item_type_menuitem resources-actions-popup__action resources-actions-popup__action_type_download')]")).shouldBe(visible).click();
        sleep(10000);
    }

    @Then("I need to make sure that i downloaded the right file")
    public void iNeedToMakeSureThatIDownloadedTheRightFile() throws IOException {
        PDF pdf = new PDF(new File("/Users/salavatamingaliev/Documents/5semestr/TEST/CucumberSelenide/build/downloads/1635519994921_48880_1/Lab6.pdf"));
        assertThat(pdf, PDF.containsText("Напишите консольное приложение C#, в котором"));
        assertThat(pdf, PDF.containsText("Задание 2."));
        assertThat(pdf, PDF.containsText("Средствами Entity Framework,"));
        assertThat(pdf, PDF.containsText("В программе выведите на экран"));
    }

    @And("I logout")
    public void iLogout() {
        profilePage.userLogout();
    }
}
