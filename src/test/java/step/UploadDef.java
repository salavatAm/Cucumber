package step;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class UploadDef {
    @And("I upload file with name {string}")
    public void iUploadFileWithName(String arg0) {
        File file = $(byClassName("upload-button__attach")).uploadFile(new File("/Users/salavatamingaliev/Documents/5semestr/TEST/CucumberSelenide/"+arg0+""));
        sleep(1000);
        $(By.xpath("//*[contains(@class, 'Button2 Button2_theme_raised Button2_view_action Button2_size_m confirmation-dialog__button confirmation-dialog__button_submit ')]")).click();
        sleep(10000);
        $(By.xpath("//*[contains(@class, 'Button2 Button2_view_clear-inverse Button2_size_m uploader-progress__close-button')]")).click();
    }

    @Then("I should see file with name {string} on page")
    public void iShouldSeeFileWithNameOnPage(String arg0) {
        $(By.xpath("//*[contains(@class, 'clamped-text')]")).shouldHave(Condition.text(arg0));
    }
}
