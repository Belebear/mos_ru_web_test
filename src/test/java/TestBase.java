import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import configs.WebDriverConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import util.Attach;

import java.util.Map;


public class TestBase {

    @BeforeAll
    static void setup() {
        WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class);
        Configuration.baseUrl = "https://www.mos.ru";
        Configuration.pageLoadStrategy = "eager";

        Configuration.browser = config.browser();
        Configuration.browserSize = config.size();
        Configuration.browserVersion = config.browserVersion();
        Configuration.remote = config.remoteUrl();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    public void addAllureListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void closeWebDriver() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Attach.getVideoUrl();
        Selenide.closeWebDriver();
    }
}
