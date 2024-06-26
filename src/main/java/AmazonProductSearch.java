import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonProductSearch {

    public static void main(String[] args) throws InterruptedException {
        // Setup WebDriver using WebDriverManager
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        // Implicit wait for 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            // Navigate to Amazon

            driver.get("https://www.amazon.com");

            // Enter search keyword
            WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
            searchInput.sendKeys("laptop");
            searchInput.sendKeys(Keys.ENTER);

            // Wait for results to load
            Thread.sleep(2000);

            // Print titles of the search results
            List<WebElement> searchResults = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
            System.out.println("Search Results:");
            for (WebElement result : searchResults) {
                System.out.println("- " + result.getText());
            }

            // Get the current URL
            String url = driver.getCurrentUrl();
            System.out.println("Current URL: " + url);
        }
        finally {
            // Close the browser
            Thread.sleep(2000);
            driver.quit();
        }

    }
}
