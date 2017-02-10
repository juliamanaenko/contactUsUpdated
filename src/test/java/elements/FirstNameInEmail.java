package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testcase.TestBase5;
import utility.PropertyLoader;
import webmail.EmailDetails;
import webmail.EmailsList;
import webmail.WebmailLogin;

/**
 * Created by Julia on 07.02.2017.
 */
public class FirstNameInEmail extends TestBase5 {

    @Test(dataProvider = "fName")
    public void fCorrectCharinEmail(String fName) throws InterruptedException {
        Thread.sleep(2000);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        contactUs.fillLastName();
        contactUs.fillEmail();
        contactUs.fillZip();
        contactUs.fillPhoneNum();
        driver.findElement(By.name("first_name")).clear();
        driver.findElement(By.name("first_name")).sendKeys(fName);
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        //  dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
       /* emailsList.clickDateColumn();
        Thread.sleep(1000);
        emailsList.clickDateColumn();
        Thread.sleep(1000);*/
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getFirstName(), fName);
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @DataProvider(name = "fName")
    public Object[][] getPhone() {
        return new Object[][]{{PropertyLoader.loadProperty("text1")},
                {PropertyLoader.loadProperty("text20")},
                {PropertyLoader.loadProperty("textAll")}};
    }
}
