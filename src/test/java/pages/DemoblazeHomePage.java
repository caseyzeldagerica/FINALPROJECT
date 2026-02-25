package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DemoblazeHomePage {
    WebDriver driver;
    WebDriverWait wait;

    // 1. Kumpulan Locator (Mencari elemen web)
    By loginMenu = By.id("login2");
    By usernameField = By.id("loginusername");
    By passwordField = By.id("loginpassword");
    By loginBtn = By.xpath("//button[text()='Log in']");
    By nameOfUser = By.id("nameofuser");

    // 2. Constructor
    public DemoblazeHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Sabar nunggu pop-up loading
    }

    // 3. Kumpulan Aksi yang bisa dilakukan di halaman ini
    public void clickLoginMenu() {
        driver.findElement(loginMenu).click();
    }

    public void login(String username, String password) {
        // Karena Demoblaze pakai pop-up animasi, kita suruh robot nunggu sampai kolomnya benar-benar muncul
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginBtn).click();
    }

    public String getWelcomeText() {
        // Tunggu sampai tulisan "Welcome ..." muncul di pojok kanan atas
        return wait.until(ExpectedConditions.visibilityOfElementLocated(nameOfUser)).getText();
    }
}