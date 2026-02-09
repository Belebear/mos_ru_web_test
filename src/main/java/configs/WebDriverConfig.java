package configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "system:properties",
        "classpath:test.properties"
})
public interface WebDriverConfig extends Config {

    @Key("browser")
    String browser();

    @Key("size")
    String size();

    @Key("version")
    String browserVersion();

    @Key("remote")
    String remoteUrl();
}
