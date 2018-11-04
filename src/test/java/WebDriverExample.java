import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverExample {
    public static void main(String[] args) {
        WebDriver driver = getDriver();
        /*driver.manage().window().maximize();
        driver.get("https://www.bing.com/");

        WebElement searchInput = driver.findElement(By.id("sb_form_q"));
        searchInput.sendKeys("Selenium");
        searchInput.submit();
        driver.quit();*/

//        WebElement searchButton = driver.findElement(By.name("go"));
//        searchButton.click();

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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignore) {
            /* NOP */
        }
        // Clicking the "Dashboard"-button on the main menu:
        WebElement dashboard = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("title")));
        //WebElement dashboard = driver.findElement(By.className("title"));
        dashboard.click();
        String dbTitle = driver.getTitle();
        System.out.println("Dashboard title is: " + dbTitle);
        driver.navigate().refresh();
        String dbTitleRefreshed = driver.getTitle();
        System.out.println("Dashboard refreshed title is: " + dbTitleRefreshed);
        // Comparing dashboard-page and refreshed dashboard-page:
        System.out.println(dbTitle.equals(dbTitleRefreshed) ? "Dashboard refresh OK" : "Dashboard refresh ERROR!");
        // Clicking the "Заказы"-button on the main menu:
        WebElement orders = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Заказы")));
        //WebElement orders = driver.findElement(By.linkText("Заказы"));
        orders.click();
        String ordersTitle = driver.getTitle();
        System.out.println("Заказы title is: " + ordersTitle);
        driver.navigate().refresh();
        String ordersTitleRefreshed = driver.getTitle();
        System.out.println("Заказы refreshed title is: " + ordersTitleRefreshed);
        // Comparing Заказы-page and refreshed Заказы-page:
        System.out.println(ordersTitle.equals(ordersTitleRefreshed) ? "Заказы refresh OK" : "Заказы refresh ERROR!");
        // Clicking the "Каталог"-button on the main menu:
        WebElement catalog = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Каталог")));
        //WebElement orders = driver.findElement(By.linkText("Заказы"));
        catalog.click();
        String catalogTitle = driver.getTitle();
        System.out.println("Каталог title is: " + catalogTitle);
        driver.navigate().refresh();
        String catalogTitleRefreshed = driver.getTitle();
        System.out.println("Каталог refreshed title is: " + catalogTitleRefreshed);
        // Comparing Каталог-page and refreshed Каталог-page:
        System.out.println(catalogTitle.equals(catalogTitleRefreshed) ? "Каталог refresh OK" : "Каталог refresh ERROR!");
        // Clicking the Клиенты-button on the main menu:
        WebElement clients = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Клиенты")));
        //WebElement orders = driver.findElement(By.linkText("Заказы"));
        clients.click();

        String clientsTitle = driver.getTitle();
        System.out.println("Клиенты title is: " + clientsTitle);
        driver.navigate().refresh();

        String clientsTitleRefreshed = driver.getTitle();
        System.out.println("Клиенты refreshed title is: " + clientsTitleRefreshed);
        // Comparing Клиенты-page and refreshed Клиенты-page:
        System.out.println(clientsTitle.equals(clientsTitleRefreshed) ? "Клиенты refresh OK" : "Клиенты refresh ERROR!");
        // Clicking the "Служба поддержки"-button on the main menu:
        WebElement maintain = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Служба поддержки")));
        //WebElement orders = driver.findElement(By.linkText("Заказы"));
        maintain.click();

        String maintainTitle = driver.getTitle();
        System.out.println("Служба поддержки title is: " + maintainTitle);
        driver.navigate().refresh();

        String maintainTitleRefreshed = driver.getTitle();
        System.out.println("Служба поддержки refreshed title is: " + maintainTitleRefreshed);
        // Comparing Служба поддержки-page and refreshed Служба поддержки-page:
        System.out.println(maintainTitle.equals(maintainTitleRefreshed) ? "Служба поддержки refresh OK" : "Служба поддержки refresh ERROR!");
        // Clicking the "Статистика"-button on the main menu:
        WebElement statistic = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Статистика")));
        //WebElement orders = driver.findElement(By.linkText("Заказы"));
        statistic.click();

        String statisticTitle = driver.getTitle();
        System.out.println("Статистика title is: " + statisticTitle);
        driver.navigate().refresh();

        String statisticTitleRefreshed = driver.getTitle();
        System.out.println("Статистика refreshed title is: " + statisticTitleRefreshed);
        // Comparing Статистика-page and refreshed Статистика-page:
        System.out.println(statisticTitle.equals(statisticTitleRefreshed) ? "Статистика refresh OK" : "Статистика refresh ERROR!");
        // Clicking the "Modules"-button on the main menu:
        WebElement modules = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Modules")));
        //WebElement orders = driver.findElement(By.linkText("Заказы"));
        modules.click();

        String modulesTitle = driver.getTitle();
        System.out.println("Modules title is: " + modulesTitle);
        driver.navigate().refresh();

        String modulesTitleRefreshed = driver.getTitle();
        System.out.println("Modules refreshed title is: " + modulesTitleRefreshed);
        // Comparing Modules-page and refreshed Modules-page:
        System.out.println(modulesTitle.equals(modulesTitleRefreshed) ? "Modules refresh OK" : "Modules refresh ERROR!");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ignore) {
            /* NOP */
        }
        // Clicking the "Design"-button on the main menu:
        WebElement design = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Design")));
        //WebElement orders = driver.findElement(By.linkText("Заказы"));
        design.click();
        // System.out.println("Design was clicked");

        String designTitle = driver.getTitle();
        System.out.println("Design title is: " + designTitle);
        driver.navigate().refresh();

        String designTitleRefreshed = driver.getTitle();
        System.out.println("Design refreshed title is: " + designTitleRefreshed);
        // Comparing Design-page and refreshed Design-page:
        System.out.println(designTitle.equals(designTitleRefreshed) ? "Design refresh OK" : "Design refresh ERROR!");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ignore) {
            /* NOP */
        }
        // Clicking the "Доставка"-button on the main menu:
        WebElement shipping = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Доставка")));
        //WebElement orders = driver.findElement(By.linkText("Заказы"));
        shipping.click();
        // System.out.println("Design was clicked");

        String shippingTitle = driver.getTitle();
        System.out.println("Доставка title is: " + shippingTitle);
        driver.navigate().refresh();

        String shippingTitleRefreshed = driver.getTitle();
        System.out.println("Доставка refreshed title is: " + shippingTitleRefreshed);
        // Comparing Доставка-page and refreshed Доставка-page:
        System.out.println(shippingTitle.equals(shippingTitleRefreshed) ? "Доставка refresh OK" : "Доставка refresh ERROR!");
        // Clicking the "Способ оплаты"-button on the main menu:
        WebElement payment = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Способ оплаты")));
        //WebElement orders = driver.findElement(By.linkText("Заказы"));
        payment.click();
        // System.out.println("Design was clicked");

        String paymentTitle = driver.getTitle();
        System.out.println("Способ оплаты title is: " + paymentTitle);
        driver.navigate().refresh();

        String paymentTitleRefreshed = driver.getTitle();
        System.out.println("Способ оплаты refreshed title is: " + paymentTitleRefreshed);
        // Comparing Способ оплаты-page and refreshed Способ оплаты-page:
        System.out.println(paymentTitle.equals(paymentTitleRefreshed) ? "Способ оплаты refresh OK" : "Способ оплаты refresh ERROR!");
        // Clicking the "International"-button on the main menu:
        WebElement international = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("International")));
        //WebElement orders = driver.findElement(By.linkText("Заказы"));
        international.click();
        // System.out.println("Design was clicked");

        String internationalTitle = driver.getTitle();
        System.out.println("International title is: " + internationalTitle);
        driver.navigate().refresh();

        String internationalTitleRefreshed = driver.getTitle();
        System.out.println("International refreshed title is: " + internationalTitleRefreshed);
        // Comparing International-page and refreshed International-page:
        System.out.println(internationalTitle.equals(internationalTitleRefreshed) ? "International refresh OK" : "International refresh ERROR!");

        driver.quit();
    }

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "d:/Soft/chromedriver_win32/chromedriver.exe");
        return new ChromeDriver();
    }

}
