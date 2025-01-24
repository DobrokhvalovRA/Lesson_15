import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestsMTS {
    private static WebDriver driver;

    @Before
    public void make() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.mts.by/");
        driver.findElement(By.xpath("/html/body/div[6]/main/div/div[2]/div/div[2]/button[3]")).click();
    }

    @Test //проверяем заголовок
    public void checkTitle() {
        String title;

        make(); // что делать с этим ?

        title = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/h2")).getText();
        assertTrue(title.equals("Онлайн пополнение\n" + "без комиссии"));
    }

    @Test // проверяем логотипы
    public void checkLogo() throws NoSuchElementException {

        WebElement visa = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[2]/ul/li[1]/img"));
        WebElement vvisa = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[2]/ul/li[1]/img"));
        WebElement mc = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[2]/ul/li[1]/img"));
        WebElement mcsc = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[2]/ul/li[1]/img"));
        WebElement bc = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[2]/ul/li[1]/img"));


        assertTrue(visa.isDisplayed());
        assertTrue(vvisa.isDisplayed());
        assertTrue(mc.isDisplayed());
        assertTrue(mcsc.isDisplayed());
        assertTrue(bc.isDisplayed());
    }

    @Test //проверяем ссылку
    public void checkLink() {

        driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/a")).getText();

    }


}

