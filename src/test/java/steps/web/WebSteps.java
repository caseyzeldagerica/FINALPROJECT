package steps.web;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.DemoblazeHomePage;
import java.time.Duration;

public class WebSteps {
    WebDriver driver;
    DemoblazeHomePage homePage;

    @Given("Saya membuka halaman utama Demoblaze")
    public void openHomePage() {
        // Jurus headless Linux biar CI/CD GitHub Actions nanti hijau!
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/");

        // Sambungkan dengan file POM yang kita buat tadi
        homePage = new DemoblazeHomePage(driver);
    }

    @When("Saya klik menu Log in")
    public void clickMenuLogin() {
        homePage.clickLoginMenu();
    }

    @And("Saya memasukkan username {string} dan password {string}")
    public void inputCredentials(String username, String password) {
        homePage.login(username, password);
    }

    @And("Saya klik tombol Log in pada pop up")
    public void clickLoginBtn() {
        homePage.clickLoginButton();
    }

    @Then("Saya melihat nama akun {string} di pojok kanan atas")
    public void verifyLogin(String expectedText) {
        String actualText = homePage.getWelcomeText();
        Assert.assertEquals(expectedText, actualText);

        // Jangan lupa tutup browser setelah selesai ngetes
        driver.quit();
    }
}