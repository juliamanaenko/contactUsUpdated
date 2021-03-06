package contactUsForm;

import customers.LeadDetails;
import customers.Leads;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.PropertyLoader;

import java.util.ArrayList;

/**
 * Created by Julia on 20.01.2017.
 */
public class StateProvinceTest extends TestBase2 {

    LeadDetails leadDetails;

    @Test(priority = 1)
    public void sEmptyValueClass() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(formsPage.getStateInputClass(), PropertyLoader.loadProperty("inputClassValid"));
    }

    @Test(priority = 2)
    public void sEmptyValueHighlight() throws InterruptedException {
        Assert.assertEquals(formsPage.getStateInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(priority = 3)
    public void sOneCharClass() throws InterruptedException {
        driver.findElement(By.name("state")).clear();
        driver.findElement(By.name("state")).sendKeys(PropertyLoader.loadProperty("state1"));
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(formsPage.getStateInputClass(), PropertyLoader.loadProperty("inputClassValid"));
    }

    @Test(priority = 4)
    public void sOneCharHighlight() throws InterruptedException {
        Assert.assertEquals(formsPage.getStateInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(priority = 5)
    public void sTenCharsClass() throws InterruptedException {
        driver.findElement(By.name("state")).clear();
        driver.findElement(By.name("state")).sendKeys(PropertyLoader.loadProperty("state10"));
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(formsPage.getStateInputClass(), PropertyLoader.loadProperty("inputClassValid"));
    }

    @Test(priority = 6)
    public void sTenCharsHighlight() {
        Assert.assertEquals(formsPage.getStateInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(priority = 7)
    public void sTwentyCharsClass() throws InterruptedException {
        driver.findElement(By.name("state")).clear();
        driver.findElement(By.name("state")).sendKeys(PropertyLoader.loadProperty("state20"));
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(formsPage.getStateInputClass(), PropertyLoader.loadProperty("inputClassValid"));
    }

    @Test(priority = 8)
    public void sTwentyCharsHighlight() {
        Assert.assertEquals(formsPage.getStateInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(priority = 9)
    public void sTwentyoneCharsClass() throws InterruptedException {
        driver.findElement(By.name("state")).clear();
        driver.findElement(By.name("state")).sendKeys(PropertyLoader.loadProperty("state21"));
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(formsPage.getStateInputClass(), PropertyLoader.loadProperty("inputClassValid"));
    }

    @Test(priority = 10)
    public void sTwentyoneCharsHighlight() {
        Assert.assertEquals(formsPage.getStateInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(priority = 11)
    public void sTwentyoneCharsCut() {
        Assert.assertEquals(formsPage.stateGetValue(), PropertyLoader.loadProperty("state20"));
    }

    @Test(priority = 12)
    public void sEmptyValueinLead() throws InterruptedException {
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillEmail();
        formsPage.fillZip();
        formsPage.fillPhoneNum();
        driver.findElement(By.name("state")).clear();
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(3000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        // dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        Leads leads = dmsHome2.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leadDetails = leads.openFirstLead();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getState(), "");
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @Test(priority = 13)
    public void sOneCharinLead() throws InterruptedException {
        Thread.sleep(2000);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillEmail();
        formsPage.fillZip();
        formsPage.fillPhoneNum();
        driver.findElement(By.name("state")).clear();
        driver.findElement(By.name("state")).sendKeys(PropertyLoader.loadProperty("state1"));
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(3000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        Leads leads = dmsHome2.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leadDetails = leads.openFirstLead();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getState(), PropertyLoader.loadProperty("state1"));
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @Test(priority = 14)
    public void sTenCharsinLead() throws InterruptedException {
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillEmail();
        formsPage.fillZip();
        formsPage.fillPhoneNum();
        driver.findElement(By.name("state")).clear();
        driver.findElement(By.name("state")).sendKeys(PropertyLoader.loadProperty("state10"));
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
        Assert.assertEquals(leadDetails.getState(), PropertyLoader.loadProperty("state10"));
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @Test(priority = 15)
    public void sTwentyCharsinLead() throws InterruptedException {
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillEmail();
        formsPage.fillZip();
        formsPage.fillPhoneNum();
        driver.findElement(By.name("state")).clear();
        driver.findElement(By.name("state")).sendKeys(PropertyLoader.loadProperty("state20"));
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(3000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        // dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        Leads leads = dmsHome2.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leadDetails = leads.openFirstLead();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getState(), PropertyLoader.loadProperty("state20"));
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @Test(priority = 15)
    public void sTwentyoneCharsinLead() throws InterruptedException {
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillEmail();
        formsPage.fillZip();
        formsPage.fillPhoneNum();
        driver.findElement(By.name("state")).clear();
        driver.findElement(By.name("state")).sendKeys(PropertyLoader.loadProperty("state21"));
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(3000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        // dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        Leads leads = dmsHome2.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leadDetails = leads.openFirstLead();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getState(), PropertyLoader.loadProperty("state20"));
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }
}
