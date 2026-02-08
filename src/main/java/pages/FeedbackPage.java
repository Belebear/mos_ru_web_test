package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static util.Endpoints.FEEDBACK;

public class FeedbackPage {

    private final SelenideElement feedbackPageTitle = $("h2");
    private final SelenideElement nameInput = $("[name='name']");
    private final SelenideElement surnameInput = $("[name='surname']");
    private final SelenideElement phoneInput = $("[name='phone']");
    private final SelenideElement emailInput = $("[name='email']");
    private final SelenideElement cardNumberInput = $("[name='cardNumber']");
    private final SelenideElement messageInput = $("[name='message']");
    private final SelenideElement captchaInput = $("[name='captcha']");
    private final SelenideElement policyAgree1Input = $$(".css-131uujd-Box").get(0);
    private final SelenideElement policyAgree2Input = $$(".css-131uujd-Box").get(1);
    private final SelenideElement policyAgree3Input = $$(".css-131uujd-Box").get(2);
    private final SelenideElement submitButton = $("[type='submit']").$(byText("Отправить"));
    private final SelenideElement fileInput = $("[aria-label='Файлы по теме обращения']");
    private final SelenideElement deletefileButton = $$("[type='button']").findBy(text("Удалить"));
    private final SelenideElement errorCaptchaCodeMessage = $(".css-10gq7f7-Box-Text");


    @Step("Открытие страницы feedback с проверкой заголовка")
    public FeedbackPage openFeedbackPage(String title) {
        open(FEEDBACK);
        feedbackPageTitle.shouldHave(text(title));

        return this;
    }

    @Step("Загрузка файла")
    public FeedbackPage uploadFile(String filePath) {
        fileInput.scrollIntoCenter();
        fileInput.uploadFromClasspath(filePath);
        deletefileButton.shouldBe(visible);
        return this;
    }

    @Step("Удаление файла")
    public FeedbackPage deleteFile() {
        deletefileButton.click();
        deletefileButton.shouldBe(hidden);
        return this;
    }

    @Step("Заполнение поля 'Имя'")
    public FeedbackPage sendKeysName(String value) {
        nameInput.sendKeys(value);
        return this;
    }

    @Step("Заполнение поля 'Фамилия'")
    public FeedbackPage sendKeysSurname(String value) {
        surnameInput.sendKeys(value);
        return this;
    }

    @Step("Заполнение поля 'Телефон'")
    public FeedbackPage sendKeysPhone(String value) {
        phoneInput.sendKeys(value);
        return this;
    }

    @Step("Заполнение поля 'Почта'")
    public FeedbackPage sendKeysEmail(String value) {
        emailInput.sendKeys(value);
        return this;
    }

    @Step("Заполнение поля 'Номер карты'")
    public FeedbackPage sendKeysCardNumber(String value) {
        cardNumberInput.sendKeys(value);
        return this;
    }

    @Step("Заполнение поля 'Сообщение'")
    public FeedbackPage sendKeysMessage(String value) {
        messageInput.sendKeys(value);
        return this;
    }

    @Step("Заполнение поля 'Каптча'")
    public FeedbackPage sendKeysCaptcha(String value) {
        captchaInput.sendKeys(value);
        return this;
    }

    @Step("Чек бокс 'Ознокомлен с политикой обработки'")
    public FeedbackPage checkBoxPolicyAgree1() {
        policyAgree1Input.click();
        return this;
    }

    @Step("Чек бокс 'Согласие на обработку персональных данных'")
    public FeedbackPage checkBoxPolicyAgree2() {
        policyAgree2Input.click();
        return this;
    }

    @Step("Чек бокс 'Ознакомлен с соглашением'")
    public FeedbackPage checkBoxPolicyAgree3() {
        policyAgree3Input.click();
        return this;
    }

    @Step("Нажатие на кнопки 'Отправить'")
    public FeedbackPage submitButtonClick() {
        submitButton.scrollIntoCenter();
        submitButton.click();
        return this;
    }

    @Step("Проверка появления модального окна об ошибке 'Обращение не удалось отправить'")
    public FeedbackPage checkErrorCaptchaCodeMessage(String value) {
        errorCaptchaCodeMessage.shouldHave(text(value));
        return this;
    }
}
