package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static util.Endpoints.NEWS;

public class NewsPage {

    final SelenideElement periodFrom = $("[placeholder='Период с']");
    final SelenideElement periodTo = $("[placeholder='по']");
    final SelenideElement sphereDropdown = $("[data-label='Сфера']");
    final ElementsCollection selectCheckBox = $$(".mos-select__option");
    final SelenideElement departmentDropdown = $("[data-label='Департамент']");
    final SelenideElement districtDropdown = $("[data-label='Округ']");
    final SelenideElement areaDropdown = $("[data-label='Район']");
    final SelenideElement applyButton = $(".events-filter__btn-select");
    final SelenideElement clickAllNewsTitle = $(".events-block__title-text");

    @Step("Открытие страницы 'Новости'")
    public NewsPage openNewsPage() {
        open(NEWS);
        return this;
    }

    @Step("Заполнение поля 'Периос с'")
    public NewsPage sendKeysPeriodFrom(String value) {
        periodFrom.sendKeys(value);
        clickAllNewsTitle.click();
        return this;
    }

    @Step("Заполнение поля 'по'")
    public NewsPage sendKeysPeriodTo(String value) {
        periodTo.sendKeys(value);
        clickAllNewsTitle.click();
        return this;
    }

    @Step("Выбор сферы")
    public NewsPage selectSphere(String value) {
        sphereDropdown.click();
        selectCheckBox.findBy(text(value)).click();
        clickAllNewsTitle.click();
        return this;
    }

    @Step("Выбор департамента")
    public NewsPage selectDepartment(String value) {
        departmentDropdown.click();
        selectCheckBox.findBy(text(value)).click();
        clickAllNewsTitle.click();
        return this;
    }

    @Step("Выбор округа")
    public NewsPage selectDistrict(String value) {
        districtDropdown.click();
        selectCheckBox.findBy(text(value)).click();
        clickAllNewsTitle.click();
        return this;
    }

    @Step("Клик на кнопку 'Подобрать'")
    public NewsPage clickApply() {
        applyButton.click();
        return this;
    }

    @Step("Проверка отображения новости'")
    public NewsPage checkNews(String value) {
        $("[alt='" + value + "']").shouldBe(visible);
        return this;
    }
}
