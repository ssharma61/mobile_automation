package testing;

import base.baseClass;
import io.appium.java_client.AppiumBy;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;


public class testingClass extends baseClass {
static WebElement cart;
    @Test(priority = 0)
    public void firstTestHomePage() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement country = driver.findElement(AppiumBy.id("android:id/text1"));
        Assert.assertTrue(country.getText().contains("Afghanistan"));
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]")).click();
        WebElement nameText = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
        nameText.click();
        nameText.sendKeys("Swati Sharma");
        WebElement radioButton = driver.findElement(AppiumBy.className("android.widget.RadioButton"));
        if (radioButton.isDisplayed()){
            driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
        }
        driver.findElement(AppiumBy.className("android.widget.Button")).click();
    }
    @Test(priority = 1)
    public static void secondTestProductsPage(){
        WebElement backButton = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_back"));
        cart = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart"));
        if (backButton.isDisplayed() && cart.isDisplayed()){
        cart.click();
        //image overlapping
}
    }
    @Test(priority = 2)
    public static void thirdTestAddToCart() throws InterruptedException {
        WebElement product = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/productImage"));
        if (product.isDisplayed()) {
            driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/productAddCart")).click();
        }
        String bagCount = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/counterText")).getText();
        Assert.assertEquals(bagCount, "1");
        cart.click();
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        String termsOfCondition = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/termsButton")).getText();
        Assert.assertEquals(termsOfCondition, "Please read our terms of conditions");
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(6000);
    }
    @Test(priority = 3)
    public static void fourthTestGooglePage() throws InterruptedException {
        WebElement signInButton = driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Sign in\"]/android.widget.TextView"));
        Assert.assertTrue(signInButton.isDisplayed());
        WebElement searchBar = driver.findElement(AppiumBy.className("android.widget.EditText"));
        if (searchBar.isDisplayed()) {
            searchBar.click();
            searchBar.sendKeys("Shoes", Keys.ENTER); // enter key is typing some unwanted symbol after shoes
            Thread.sleep(4000);
        }
        WebElement topBar = driver.findElement(AppiumBy.className("android.widget.ListView"));
        String topBarText = topBar.getText();
        Assert.assertTrue(topBarText.contains("Shopping"));
        Thread.sleep(3000);
    }
}
