package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static util.Endpoints.CHECKKARTAMOSKVICHA;

public class CheckTheAvailabilityOfTheMoskvichCardPage {

    SelenideElement blankNoInput = $("[name='blank_no']");
    SelenideElement docNoInput = $("[name='doc_no']");
    SelenideElement captchaInput = $("[name='captcha']");
    SelenideElement agreementCheckBox = $(".css-1y8ifuq-Box-Box").$(".css-uajqhr-Box");
    SelenideElement checkButton = $("[type='submit']").$(byText("Проверить"));
    SelenideElement errorMessageIncorrectCaptchaCode = $(".css-10gq7f7-Box-Text");
    SelenideElement blankNotip = $(".css-xqznv3-Box").$(byText("Как найти номер заявления"));

    @Step("Открытие страницы 'Проверка готовности карты москвича' и проверка наличия заголовка")
    public CheckTheAvailabilityOfTheMoskvichCardPage openPage(String text) {
        open(CHECKKARTAMOSKVICHA);
        $("h1").shouldHave(text(text));
        return this;
    }

    @Step("Проверка валидации если все поля пустые")
    public CheckTheAvailabilityOfTheMoskvichCardPage checkValidationErrorWhenAllInputIsEmpty() {
        checkButton.click();
        $$(".css-10gq7f7-Box-Text").findBy(text("Введите номер заявления")).shouldBe(visible);
        $$(".css-10gq7f7-Box-Text").findBy(text("Введите номер документа удостоверяющего личность")).shouldBe(visible);
        $$(".css-10gq7f7-Box-Text").findBy(text("Введите проверочный код")).shouldBe(visible);
        $$("#social-card-agreement-error").findBy(text("Подтвердите согласие с условиями использования сервиса")).shouldBe(visible);
        return this;
    }

    @Step("Заполнение blankNoInput")
    public CheckTheAvailabilityOfTheMoskvichCardPage sendKeysBlankNoInput(String value) {
        blankNoInput.sendKeys(value);
        return this;
    }

    @Step("Заполнение docNoInput")
    public CheckTheAvailabilityOfTheMoskvichCardPage sendKeysdocNoInput(String value) {
        docNoInput.sendKeys(value);
        return this;
    }

    @Step("Заполнение captchaInput")
    public CheckTheAvailabilityOfTheMoskvichCardPage sendKeysCaptchaInput(String value) {
        captchaInput.sendKeys(value);
        return this;
    }

    @Step("Подтверждение")
    public CheckTheAvailabilityOfTheMoskvichCardPage approve() {
        agreementCheckBox.click();
        checkButton.click();
        return this;
    }

    @Step("Проверка Error сообщения")
    public CheckTheAvailabilityOfTheMoskvichCardPage checkErrorMessage(String message) {
        errorMessageIncorrectCaptchaCode.shouldHave(text(message));
        return this;
    }

    @Step("Открытие модального окна 'Как найти номер заявления'")
    public CheckTheAvailabilityOfTheMoskvichCardPage openModalOverlay() {
        blankNotip.click();
        $$("h2").findBy(text("Как найти номер заявления")).shouldBe(visible);
        return this;
    }

}
