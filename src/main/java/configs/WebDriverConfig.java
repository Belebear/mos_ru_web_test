package configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "system:properties",
        "classpath:test.properties",
        "file:src/test/resources/test.properties"
})
public interface WebDriverConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("size")
    @DefaultValue("2560x1440")
    String size();

    @Key("version")
    @DefaultValue("128")
    String browserVersion();

    @Key("remote")
    String remoteUrl();
}
