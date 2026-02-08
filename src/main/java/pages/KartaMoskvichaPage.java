package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static util.Endpoints.KARTAMOSKVICHA;

public class KartaMoskvichaPage {

    SelenideElement applyCardButton = $(".css-1k2j8kz-Button-Text-Box").$(byText("Оформить карту"));

    @Step("Открытие страницы 'Карта москвича'")
    public KartaMoskvichaPage openKartaMoskvichaPage(String value) {
        open(KARTAMOSKVICHA);
        $("h1").shouldHave(text(value));
        return this;
    }

    @Step("Нажатие на кнопку 'Оформить карту'")
    public KartaMoskvichaPage clickApplyCardButton() {
        applyCardButton.click();
        Selenide.switchTo().window(1);
        $$("h1").findBy(text("Оформление карты москвича")).shouldBe(visible);
        return this;
    }
}