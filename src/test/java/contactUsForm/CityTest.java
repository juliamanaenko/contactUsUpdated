package contactUsForm;

import customers.LeadDetails;
import customers.Leads;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.PropertyLoader;

import java.util.ArrayList;

/**
 * Created by Julia on 20.01.2017.
 */
public class CityTest extends TestBase2 {

    LeadDetails leadDetails;

    /*City Input should have valid css class, if try to send form with empty city*/
    @Test(priority = 1)
    public void cityEmptyValue() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(formsPage.getCityInputClass(), PropertyLoader.loadProperty("inputClassValid2"));
    }

    /*City Input should have gray border color, if try to send form with empty city*/
    @Test(priority = 2)
    public void cityEmptyValueHighlight() throws InterruptedException {
        Assert.assertEquals(formsPage.getCityInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    /*City Input should have valid css class, if try to send form with 1, 20, 50, allChars in city*/
    @Test(priority = 3, dataProvider = "city")
    public void cityCorrectChar(String city) throws InterruptedException {
        driver.findElement(By.name("city")).clear();
        driver.findElement(By.name("city")).sendKeys(city);
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(formsPage.getCityInputClass(), PropertyLoader.loadProperty("inputClassValid"));
    }

    /*City Input should have gray border color, if try to send form with 1, 20, 50, allChars in city*/
    @Test(priority = 4, dataProvider = "city")
    public void cityCorrectCharHighlight(String city) throws InterruptedException {
        driver.findElement(By.name("city")).clear();
        driver.findElement(By.name("city")).sendKeys(city);
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(formsPage.getCityInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(priority = 5, enabled = false)
    public void loginToDms() {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
    }

    /*City should be correctly saved in Leads*/
    @Test(priority = 6, dataProvider = "city")
    public void cityCorrectCharinLead(String city) throws InterruptedException {
        Thread.sleep(2000);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillEmail();
        formsPage.fillZip();
        formsPage.fillPhoneNum();
        driver.findElement(By.name("city")).clear();
        driver.findElement(By.name("city")).sendKeys(city);
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(3000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        //  dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        Leads leads = dmsHome2.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leadDetails = leads.openFirstLead();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getCity(), city);
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @DataProvider(name = "city")
    public Object[][] getPhone() {
        return new Object[][]{{PropertyLoader.loadProperty("text1")},
                {PropertyLoader.loadProperty("text20")},
                {PropertyLoader.loadProperty("text50")},
                {PropertyLoader.loadProperty("textAll")}};
    }
}
