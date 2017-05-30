package mx.uerre;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeWebDriver {

    private static final String CHROME_DRIVER_FILE = "src\\main\\resources\\chromedriver.exe";
    private static final String WEB_SCRAPER_CRX = "src\\main\\resources\\Web-Scraper_v0.2.0.11.crx";
    private static final String GOOGLE = "http://www.google.com/";
    private static final String WEB_SCRAPER_EXT_URL = "chrome-extension://jnhgnonknehpejjnehehllkliplmbmhn/";
    private static ChromeDriverService service;
    private WebDriver driver;
    private FilesGenerator filesGenerator = new FilesGenerator();
    private Map<String, String> filesMap = filesGenerator.getFilesMap();

    @BeforeClass
    public static void createAndStartService() throws IOException {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_FILE);
        service = new ChromeDriverService.Builder()
            .usingDriverExecutable(new File(CHROME_DRIVER_FILE))
            .usingAnyFreePort()
            .build();
        service.start();
    }

    @AfterClass
    public static void stopService() {
        service.stop();
    }

    @Before
    public void createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(WEB_SCRAPER_CRX));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new RemoteWebDriver(service.getUrl(), capabilities);
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    @Test
    public void testSiteImport() throws Exception {
        driver.get(WEB_SCRAPER_EXT_URL + "/devtools/views/SitemapImport.html");

        WebElement siteMapJson = driver.findElement(By.name("sitemapJSON"));
        WebElement importSitemap = driver.findElement(By.id("submit-import-sitemap"));

        for(Map.Entry<String, String> entry : filesMap.entrySet()) {
            siteMapJson.sendKeys(entry.getValue());
            importSitemap.click();
        }

        Thread.sleep(3000);
    }

    @Test
    public void testGoogleSearch() throws Exception {
        driver.get(GOOGLE);
        driver.get("http://www.google.com/xhtml");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("ChromeDriver");
        searchBox.submit();
        Thread.sleep(5000);
    }

}
