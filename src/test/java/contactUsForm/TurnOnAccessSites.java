package contactUsForm;

import dms.SiteEditor;
import dms.dmsHome2;
import map2.MAP2;
import map2.map2PageEditor;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import settings.Sites;
import testcase.TestBase;

/**
 * Created by Julia on 10.01.2017.
 */
public class TurnOnAccessSites extends TestBase {

    protected map2PageEditor map2PageEditor;
    protected MAP2 map2;
    WebDriverWait wait;

    /*Contact Us tab should not be present in MAP2*/
    @Test(priority = 1)
    public void pageExists() throws InterruptedException {
        wait = new WebDriverWait(driver, 25);
        /*navigate to dms-Sites*/
        dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
       // wait.until(jsLoad);
        Sites sites = dmsHome2.clickOnSitesMenu();
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        Thread.sleep(2000);
        /*turn on Contact Us page from access*/
        SiteEditor editor = sites.openSiteEditor();
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        Thread.sleep(2000);
        Sites sites2 = editor.turnOnPageSite();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@aria-labelledby='ui-dialog-title-site_editor']")));
        //Thread.sleep(15000);
        /*turn on Contact Us widget from access*/
        SiteEditor editor2 = sites2.openSiteEditor();
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        Thread.sleep(1000);
        Sites sites3 = editor2.turnOnWidgetSite();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@aria-labelledby='ui-dialog-title-site_editor']")));
        // Thread.sleep(15000);
        /*navigate to MAP2*/
        map2 = sites3.goToMAP2();
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        Assert.assertTrue(map2.isContactTabExists());
       // Thread.sleep(3000);
    }

    /*Contact Us widget should be present in MAP2*/
    @Test(priority = 2)
    public void widgetExists() throws InterruptedException {
        Thread.sleep(1000);
        map2.clickContactTab();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right"))));
        Thread.sleep(2000);
        map2PageEditor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertTrue(map2PageEditor.isContactWidgetExists());
        //Thread.sleep(3000);
    }

    /*Contact Us widget should be present on dws page*/
    @Test(priority = 3)
    public void dwsWidgetExists() throws InterruptedException {
        driver.get("http://www.tacker.ixloo.com/contactus2");
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        Assert.assertTrue(dwsPage.isWidgetExists());
       // Thread.sleep(3000);
    }
}
