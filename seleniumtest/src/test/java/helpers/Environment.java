package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by rtomos on 12/12/2017.
 */
public class Environment {
    protected WebDriver webDriver;

    private static Environment instance;

//    public Environment(WebDriver webDriver) {
//        this.webDriver = webDriver;
//    }

    public static synchronized Environment getInstance(){
        if (instance==null)
            instance = new Environment();
        return instance;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebDriver startDriver(String browser, String url) {
        if (browser.equals("firefox")) {
            webDriver = new FirefoxDriver();
        } else if (browser.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("-incognito");
            options.addArguments("--disable-popup-blocking");
            webDriver = new ChromeDriver(options);
        }

        webDriver.manage().window().maximize();
        return webDriver;
    }
}
