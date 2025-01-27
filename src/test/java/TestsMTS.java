import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestsMTS {
    private static WebDriver driver = null;

    @BeforeClass
    public static void make() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.mts.by/");
        driver.findElement(By.id("cookie-agree")).click();
    }

    @Test
    public void checkTitle() {
        String title;

        // что делать с этим ? На сколько я понял он же должен запустится сам перед тестами,
        //если будет не сложно поясните
        make();
        title = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/h2")).getText();
        assertTrue(title.equals("Онлайн пополнение\n" + "без комиссии"));

    }

    @Test
    public void checkLogo() throws NoSuchElementException {
        /*WebElement visa = driver.findElement(By.);
        WebElement vvisa = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[2]/ul/li[2]/img"));
        WebElement mc = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[2]/ul/li[3]/img"));
        WebElement mcsc = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[2]/ul/li[4]/img"));
        WebElement bc = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[2]/ul/li[5]/img"));*/

        WebElement visa = driver.findElement(By.cssSelector("img[alt = 'Visa']"));
        WebElement vvisa = driver.findElement(By.cssSelector("img[alt = 'Verified By Visa']"));
        WebElement mc = driver.findElement(By.cssSelector("img[alt = 'MasterCard']"));
        WebElement mcsc = driver.findElement(By.cssSelector("img[alt = 'MasterCard Secure Code']"));
        WebElement bc = driver.findElement(By.cssSelector("img[alt = 'Белкарт']"));

        assertTrue(visa.isDisplayed());
        assertTrue(vvisa.isDisplayed());
        assertTrue(mc.isDisplayed());
        assertTrue(mcsc.isDisplayed());
        assertTrue(bc.isDisplayed());
    }

    @Test
    public void checkLink() {
        //WebElement link = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/a"));
        WebElement link = driver.findElement(By.linkText("Подробнее о сервисе"));
        assertTrue(link.isEnabled());
        assertTrue(link.getAttribute("href") != null);
        link.click();
        driver.navigate().back();

    }

    @Test
    public void checkButton() {
        WebElement selector = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"));
        //WebElement selector = driver.findElement(By.className("select_header"));
        //WebElement number = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        WebElement number = driver.findElement(By.id("connection-phone"));
        //WebElement sum = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        WebElement sum = driver.findElement(By.id("connection-sum"));
        //WebElement email = driver.findElement(By.xpath("//*[@id=\"connection-email\"]"));
        WebElement email = driver.findElement(By.id("connection-email"));
        WebElement continueBut = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        //WebElement continueBut = driver.findElement(By.className("button button_default"));

        //assertTrue(number.isEnabled());
        number.click();
        number.sendKeys("297777777");

        //assertTrue(sum.isEnabled());
        sum.click();
        sum.sendKeys("100");

        //assertTrue(email.isEnabled());
        email.click();
        email.sendKeys("test@test.ru");

        //assertTrue(continueBut.isEnabled());
        continueBut.click();

    }


}

