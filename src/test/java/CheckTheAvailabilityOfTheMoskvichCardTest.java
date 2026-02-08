import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CheckTheAvailabilityOfTheMoskvichCardPage;

@Tag("checkCard")
public class CheckTheAvailabilityOfTheMoskvichCardTest extends TestBase {

    String value = "Проверка готовности карты москвича";

    CheckTheAvailabilityOfTheMoskvichCardPage checkTheAvailabilityOfTheMoskvichCardPage = new CheckTheAvailabilityOfTheMoskvichCardPage();

    @Test
    @DisplayName("Проверка валидиции при пустых обязательных полях")
    void checkValidationErrorWhenAllInputIsEmptyTest() {
        checkTheAvailabilityOfTheMoskvichCardPage.openPage(value)
                .checkValidationErrorWhenAllInputIsEmpty();
    }

    @Test
    @DisplayName("Проверка ошибки при неправильной капче")
    void checkErrorMessageIncorrectCaptchaCode() {
        checkTheAvailabilityOfTheMoskvichCardPage.openPage(value)
                .sendKeysBlankNoInput("1231311")
                .sendKeysdocNoInput("123123")
                .sendKeysCaptchaInput("123")
                .approve()
                .checkErrorMessage("Введенные вами символы не совпадают с проверочным кодом");
    }

    @Test
    @DisplayName("Проверка открытия модального окна 'Как найти номер заявления'")
    void openModalOverlayTest() {
        checkTheAvailabilityOfTheMoskvichCardPage.openPage(value)
                .openModalOverlay();
    }
}
