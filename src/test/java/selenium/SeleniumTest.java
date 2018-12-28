package selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    private WebDriver wd;
    private String url;
    private String titlePage;

    @Before
    public void setup() {
        url = "http://www.example.com";
        titlePage = "Example Domain";
    }

    @Test
    public void examplepage() {
        wd = new ChromeDriver();
        wd.get(url);
        wd.manage().window().maximize();
        Assert.assertEquals(titlePage, wd.getTitle());
        wd.findElement(By.partialLinkText("More information....")).click();

        try {
            Thread.sleep(4000);
            wd.findElement(By.xpath("//a[@href='/domains']")).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test //form
        public void imputs(){
        wd = new ChromeDriver();
        wd.get("https://www.w3schools.com/html/html_forms.asp");
        try {
            Thread.sleep(3000);
            wd.manage().window().maximize();
            Thread.sleep(3000);
            wd.findElement(By.xpath("//input[@name='firstname']")).clear();
            wd.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Lukasz");

            Thread.sleep(3000);
            wd.findElement(By.xpath("//input[@name='lastname']")).clear();
            wd.findElement(By.xpath("//input[@name='lastname']")).sendKeys("AkademiaKodu");

            Thread.sleep(3000);
            wd.findElement(By.xpath("//input[@type='submit']")).click();
            Thread.sleep(3000);

            System.out.println(wd.getCurrentUrl());
            Assert.assertEquals("https://www.w3schools.com/html/html_forms.asp",wd.getCurrentUrl());
            System.out.println(wd.getPageSource());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
}
    @After
    public void teardown() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wd.quit();
    }
}