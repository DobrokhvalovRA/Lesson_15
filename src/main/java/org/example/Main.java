package org.example;
//import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        String str;
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.mts.by/");
        driver.findElement(By.xpath("/html/body/div[6]/main/div/div[2]/div/div[2]/button[3]")).click();

        str = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/h2")).getText();

        System.out.print(str);
    }


}