import components.LeftBarComponent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.KartaMoskvichaPage;

@Tag("leftBar")
public class LeftBarTest extends TestBase {

    LeftBarComponent leftBarComponent = new LeftBarComponent();
    KartaMoskvichaPage kartaMoskvichaPage = new KartaMoskvichaPage();

    @Test
    @DisplayName("Проверка видимости пунктов меню в левой боковой панели")
    void checkVisibilityItemInLeftBar() {

        kartaMoskvichaPage.openKartaMoskvichaPage("О\u00A0карте москвича");
        leftBarComponent.checkLeftBarItemsVisibility("О карте москвича");
        leftBarComponent.checkLeftBarItemsVisibility("Типы держателей");
        leftBarComponent.checkLeftBarItemsVisibility("Возможности");
        leftBarComponent.checkLeftBarItemsVisibility("Сервисы");
        leftBarComponent.checkLeftBarItemsVisibility("Новости");
        leftBarComponent.checkLeftBarItemsVisibility("Контакты");
    }
}
