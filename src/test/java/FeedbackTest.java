import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FeedbackPage;
import util.TestData;

@Tag("feedbackTests")
public class FeedbackTest extends TestBase {

    String title = "Возникли вопросы или проблемы? Обращайтесь";
    String filePath = "testfile.txt";
    FeedbackPage feedbackPage = new FeedbackPage();

    @Test
    @DisplayName("Загрузка и удаление файла")
    void uploadFileTest() {
        feedbackPage.openFeedbackPage(title)
                .uploadFile(filePath)
                .deleteFile();
    }

    @Test
    @DisplayName("Заполнение всех форм и отображение ошибки 'Введенные вами символы не совпадают с проверочным кодом'")
    void fillAllInputsAndCheckErrorMessage() {
        feedbackPage.openFeedbackPage(title)
                .sendKeysName(TestData.getName())
                .sendKeysSurname(TestData.getSurName())
                .sendKeysPhone(TestData.getPhoneNumber())
                .sendKeysEmail(TestData.getEmail())
                .sendKeysCardNumber(TestData.getNumberCard())
                .sendKeysMessage(TestData.getMessage())
                .sendKeysCaptcha("123")
                .checkBoxPolicyAgree1()
                .checkBoxPolicyAgree2()
                .checkBoxPolicyAgree3()
                .submitButtonClick()
                .checkErrorCaptchaCodeMessage("Введенные вами символы не совпадают с проверочным кодом");
    }
}
