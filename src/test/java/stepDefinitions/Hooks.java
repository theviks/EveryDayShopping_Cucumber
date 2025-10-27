package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    WebDriver driver;
    Properties p;
    Logger logger = BaseClass.getLogger(); // Initialize logger

    @Before
    public void setup() throws IOException {
        logger.info("===== Test Execution Started =====");
        driver = BaseClass.initilzeBrowser();
        logger.info("Browser initialized successfully.");

        p = BaseClass.getProperties();
        String url = p.getProperty("appURL");
        driver.get(url);
        logger.info("Navigated to URL: " + url);

        driver.manage().window().maximize();
        logger.info("Browser window maximized.");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            logger.error("Scenario FAILED: " + scenario.getName());
        } else {
            logger.info("Scenario PASSED: " + scenario.getName());
        }
        logger.info("Closing browser...");
        driver.quit();
        logger.info("===== Test Execution Finished =====");
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            logger.error("Screenshot captured for failed step in scenario: " + scenario.getName());
        }
    }
}
