import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverExample {
    public static void main(String[] args) {
        WebDriver driver = getDriver();

        //==================================SCRIPT "B"=================================================================
        // Entering the site:
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        // Filling email-feld:
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("webinar.test@gmail.com");
        // Filling password-field:
        WebElement passwordInput = driver.findElement(By.id("passwd"));
        passwordInput.sendKeys("Xcg7299bnSmMuRLp9ITw");
        // Submit form:
        WebElement submitButton = driver.findElement(By.name("submitLogin"));
        submitButton.click();
        sleeping(1000);

        //================================== FOR SCRIPT "A"============================================================
//        WebElement userIcon = driver.findElement(By.cssSelector("img.imgm.img-thumbnail"));
//        userIcon.click();
//        WebElement escape = driver.findElement(By.id("header_logout"));
//       /* WebElement escape = (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("header_logout")));*/
//        escape.click();
//        driver.quit();
        //=============================================================================================================
        String[] mainMenuButtons = new String[13];
        mainMenuButtons[0] = "Dashboard";
        mainMenuButtons[1] = "Заказы";
        mainMenuButtons[2] = "Каталог";
        mainMenuButtons[3] = "Клиенты";
        mainMenuButtons[4] = "Служба поддержки";
        mainMenuButtons[5] = "Статистика";
        mainMenuButtons[6] = "Modules";
        mainMenuButtons[7] = "Design";
        mainMenuButtons[8] = "Доставка";
        mainMenuButtons[9] = "Способ оплаты";
        mainMenuButtons[10] = "International";
        mainMenuButtons[11] = "Shop Parameters";
        mainMenuButtons[12] = "Конфигурация";

        for (String linkText : mainMenuButtons)
        {
            // Clicking the button on the main menu:
            WebElement webElement = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.linkText(linkText)));
            webElement.click();
            // Getting the title:
            String title = driver.findElement(By.tagName("h2")).getText();
            System.out.println(linkText + " title is: " + title);
            // Refresh:
            driver.navigate().refresh();
            String refreshedTitle = driver.findElement(By.tagName("h2")).getText();
            System.out.println(linkText + " refreshed title is: " + refreshedTitle);
            // Comparing page and refreshed page:
            System.out.println(title.equals(refreshedTitle) ? linkText + " refresh OK" : linkText + " refresh ERROR!");
        }
        //=============================================================================================================

        driver.quit();
    }

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src/main/resources/chromedriver.exe");
        return new ChromeDriver();
    }

    public static void sleeping(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignore) {
            /* NOP */
        }
    }

}
