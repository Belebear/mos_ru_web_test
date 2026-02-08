package components;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class LeftBarComponent {

    ElementsCollection leftBarItem = $$(".css-jbqnuf-Stack-Box");

    @Step("Проверка видимости пункта в боковом меню")
    public void checkLeftBarItemsVisibility(String item) {
        leftBarItem.findBy(text(item)).shouldBe(visible);
    }

}
