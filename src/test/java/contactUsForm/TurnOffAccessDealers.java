package contactUsForm;

import dmsDealers.Dealers;
import dmsDealers.SitePackage;
import map2.MAP2;
import map2.map2PageEditor;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcase.TestBase;

/**
 * Created by Julia on 10.01.2017.
 */
public class TurnOffAccessDealers extends TestBase {
    protected map2PageEditor map2PageEditor;
    protected MAP2 map2;
    WebDriverWait wait;

    /*Contact Us tab should not be present in MAP2*/
    @Test(priority = 1)
    public void pageDoesntExist() throws InterruptedException {
        wait = new WebDriverWait(driver, 20);
        /*navigate to dms-Dealers*/
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
       // wait.until(jsLoad);
        Thread.sleep(1000);
        Dealers dealers = dmsHome2.clickOnDealersMenu();
        waitForJSandJQueryToLoad();
       // wait.until(jsLoad);
        Thread.sleep(1100);
        /*turn off Contact Us page from access*/
        SitePackage editor = dealers.turnOnAccess();
        wait.until(editor.isEditorVisible());
        Dealers dealers2 = editor.turnOffPageDealers();
        /*wait until editor will be closed*/
        wait.until(dealers2.isEditorInvisible());
        dealers2.clickSave();
        waitForJSandJQueryToLoad();
       // wait.until(absenceOfElementLocated(By.id("idBackCont")));
      //  Thread.sleep(15000);
        map2 = dealers2.goToMAP2();
        waitForJSandJQueryToLoad();
        Assert.assertFalse(map2.isContactTabExists());

    }

    /*Contact Us widget should not be present in MAP2*/
    @Test(priority = 2)
    public void widgetDoesntExist() throws InterruptedException {
        wait = new WebDriverWait(driver, 20);
        waitForJSandJQueryToLoad();
       // wait.until(jsLoad);
        /*navigate to dms-Dealers*/
        Dealers dealers = map2.clickOnDealersMenu();
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        Thread.sleep(1000);
        /*turn on Contact Us page from access*/
        SitePackage editor = dealers.turnOnAccess();
        wait.until(editor.isEditorVisible());
        Dealers dealers2 = editor.turnOnPageDealers();
        wait.until(dealers2.isEditorInvisible());
        //Thread.sleep(2000);
        /*turn off Contact Us widget from access*/
        SitePackage editor2 = dealers.clickSitePackBtn();
        wait.until(editor2.isEditorVisible());
        Dealers dealers3 = editor.turnOffWidgetDealers();
        wait.until(dealers3.isEditorInvisible());
        dealers2.clickSave();
        waitForJSandJQueryToLoad();
       // wait.until(absenceOfElementLocated(By.id("idBackCont")));
      //  Thread.sleep(15000);
        map2 = dealers2.goToMAP2();
        waitForJSandJQueryToLoad();
        map2.clickContactTab();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right"))));
        Thread.sleep(1000);
        map2PageEditor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        Assert.assertFalse(map2PageEditor.isContactWidgetExists());
    }

    /*Contact Us widget should not be present on dws page*/
    @Test(priority = 3)
    public void dwsWidgetDoesntExist() throws InterruptedException {
        driver.get("http://www.tacker.ixloo.com/contactus2");
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        Assert.assertFalse(dwsPage.isWidgetExists());
    }

   /* ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
        @Override
        public Boolean apply(WebDriver driver) {
            return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
        }
    };*/

    public static ExpectedCondition<Boolean> absenceOfElementLocated(
            final By locator) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    driver.findElement(locator);
                    return false;
                } catch (NoSuchElementException e) {
                    return true;
                } catch (StaleElementReferenceException e) {
                    return true;
                }
            }

            @Override
            public String toString() {
                return "element to not being present: " + locator;
            }
        };
    }
}
