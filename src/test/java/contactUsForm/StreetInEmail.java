package contactUsForm;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.PropertyLoader;
import webmail.EmailDetails;
import webmail.EmailsList;

/**
 * Created by Julia on 07.02.2017.
 */
public class StreetInEmail extends TestBase5 {
    @Test(dataProvider = "street")
    public void strCorrectCharinEmail(String street) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillEmail();
        formsPage.fillZip();
        formsPage.fillPhoneNum();
        driver.findElement(By.name("street")).clear();
        driver.findElement(By.name("street")).sendKeys(street);
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getStreet(), street);
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @DataProvider(name = "street")
    public Object[][] getPhone() {
        return new Object[][]{{PropertyLoader.loadProperty("text0")},
                {PropertyLoader.loadProperty("text1")},
                {PropertyLoader.loadProperty("text20")},
                {PropertyLoader.loadProperty("text50")},
                {PropertyLoader.loadProperty("textAll")}};
    }
}
