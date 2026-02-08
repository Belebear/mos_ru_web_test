import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.NewsPage;

@Tag("newsTest")
public class NewsTest extends TestBase {
    NewsPage newsPage = new NewsPage();

    @Test
    @DisplayName("Подбор новостей")
    void filterNewsTest() {
        newsPage.openNewsPage()
                .sendKeysPeriodFrom("12312022")
                .sendKeysPeriodTo("12312025")
                .selectSphere("Строительство и реконструкция")
                .selectDepartment("Правительство Москвы")
                .selectDistrict("Центральный")
                .clickApply()
                .checkNews("Почта Деда Мороза и самоварная станция: рынок на Трубной площади подготовил праздничную программу");
    }
}
