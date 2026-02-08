import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.KartaMoskvichaPage;

@Tag("kartaMoskvicha")
public class KartaMoskvichaTest extends TestBase {

    KartaMoskvichaPage kartaMoskvichaPage = new KartaMoskvichaPage();

    @Test
    @DisplayName("Проверка кнопки 'Оформить карту'")
    void clickApplyCardButtonTest() {
        kartaMoskvichaPage.openKartaMoskvichaPage("О\u00A0карте москвича")
                .clickApplyCardButton();
    }
}
