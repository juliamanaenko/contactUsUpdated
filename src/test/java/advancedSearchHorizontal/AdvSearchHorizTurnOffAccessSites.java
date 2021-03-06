package advancedSearchHorizontal;

import dms.SiteEditor;
import dwsPages.SearchesPage;
import map2.MAP2;
import map2.map2PageEditor;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import settings.Sites;
import testcase.TestBase;
import utility.PropertyLoader;

/**
 * Created by Julia on 17.03.2017.
 */
public class AdvSearchHorizTurnOffAccessSites extends TestBase {

    private map2PageEditor homeEditor;
    private MAP2 map2;
    private WebDriverWait wait;

    /*Trade In widget should not be present in MAP2*/
    @Test
    public void AdvSearchHorizWidgetDoesntExistInLib() throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait = new WebDriverWait(driver, 20);
        /*login under supervisor*/
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        /*navigate to dms-Sites*/
        Sites sites = dmsHome2.clickOnSitesMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        /*turn off widget from access*/
        SiteEditor editor = sites.openSiteEditor();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Sites sites3 = editor.turnOffAdvSearchHorizWidgetSite();
        waitForJSandJQueryToLoad();
        /*login under manager*/
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome dmsHome1 = PageFactory.initElements(driver, dms.dmsHome.class);
        dmsHome2 = dmsHome1.loginToDmsManager();
        waitForJSandJQueryToLoad();
        /*navigate to MAP2*/
        map2 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        /*open new Home page in MAP2*/
        map2.clickHomePageTab();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right"))));
        wait.until(getConditionForTitle("Index"));
        homeEditor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);

        Assert.assertFalse(homeEditor.isAdvancedSearchWidgetExists());
    }

    /*Advanced Search Horizontal widget should not be present in MAP2 Editor*/
    @Test
    public void AdvSearchHorizWidgetDoesntExistInEditor() throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait = new WebDriverWait(driver, 20);
        /*login under supervisor*/
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        /*navigate to dms-Sites*/
        Sites sites = dmsHome2.clickOnSitesMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        /*turn on Advanced Search Horizontal widget from access*/
        SiteEditor editor = sites.openSiteEditor();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Sites sites3 = editor.turnOnAdvSearchHorizWidgetSite();
        waitForJSandJQueryToLoad();
        /*navigate to MAP2*/
        map2 = sites3.goToMAP2();
        waitForJSandJQueryToLoad();
        /*add Home page and Advanced Search Horizontal widget*/
        map2.clickHomePageTab();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right"))));
        wait.until(getConditionForTitle("Index"));
        Thread.sleep(1000);
        homeEditor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        homeEditor.addAdvancedSearchWidget();
        waitForJSandJQueryToLoad();
        homeEditor.activatePage();
        waitForJSandJQueryToLoad();
        wait.until(isPageActivatedTooltipVisible());
        map2 = homeEditor.backToMap();
        waitForJSandJQueryToLoad();
        /*navigate to dms-Sites*/
        Sites sites1 = map2.clickOnSitesMenu();
        waitForJSandJQueryToLoad();
        /*turn off Trade In widget from access*/
        SiteEditor editor3 = sites1.openSiteEditor();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Sites sites4 = editor3.turnOffAdvSearchHorizWidgetSite();
        waitForJSandJQueryToLoad();
        /*login under manager*/
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome dmsHome1 = PageFactory.initElements(driver, dms.dmsHome.class);
        dmsHome2 = dmsHome1.loginToDmsManager();
        waitForJSandJQueryToLoad();
        /*navigate to MAP2*/
        map2 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        /*open the last created Home page*/
        map2.clickHomePageTab();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right"))));
        wait.until(getConditionForTitle("Index"));
        Thread.sleep(1000);
        homeEditor = map2.editLastPage();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);

        Assert.assertFalse(homeEditor.isAdvancesSearchWidgetExistsInEditor());
    }

    /*Advanced Search Horizontal widget should not be present on dws page*/
    @Test
    public void advSearchHorizDwsWidgetDoesntExist() throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait = new WebDriverWait(driver, 20);
        /*login under supervisor*/
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        /*navigate to dms-Sites*/
        Sites sites = dmsHome2.clickOnSitesMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        /*turn on Advanced Search Horizontal widget from access*/
        SiteEditor editor = sites.openSiteEditor();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Sites sites3 = editor.turnOnAdvSearchHorizWidgetSite();
        waitForJSandJQueryToLoad();
        /*navigate to MAP2*/
        map2 = sites3.goToMAP2();
        waitForJSandJQueryToLoad();
        /*add Home page and Advanced Search Horizontal widget*/
        map2.clickHomePageTab();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right"))));
        wait.until(getConditionForTitle("Index"));
        Thread.sleep(1000);
        homeEditor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        homeEditor.addAdvancedSearchWidget();
        waitForJSandJQueryToLoad();
        homeEditor.activatePage();
        waitForJSandJQueryToLoad();
        wait.until(isPageActivatedTooltipVisible());
        map2 = homeEditor.backToMap();
        waitForJSandJQueryToLoad();
        /*navigate to dms-Sites*/
        Sites sites1 = map2.clickOnSitesMenu();
        waitForJSandJQueryToLoad();
        /*turn off Advanced Search Horizontal widget from access*/
        SiteEditor editor3 = sites1.openSiteEditor();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Sites sites4 = editor3.turnOffAdvSearchHorizWidgetSite();
        waitForJSandJQueryToLoad();
        /*open Home page in dws*/
        driver.get(PropertyLoader.loadProperty("dws.url2") + "index.html");
        waitForJSandJQueryToLoad();
        SearchesPage searchesPage = PageFactory.initElements(driver, SearchesPage.class);

        Assert.assertFalse(searchesPage.isAdvSearchHorizWidgetExists());

        /*delete the last created page in MAP2*/
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        MAP2 map22 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        map22.clickHomePageTab();
        waitForJSandJQueryToLoad();
        wait.until(getConditionForTitle("Index"));
        Thread.sleep(1000);
        map22.deletePage();
        waitForJSandJQueryToLoad();
    }

    protected ExpectedCondition<Boolean> getConditionForTitle(String title) {
        return ExpectedConditions.textToBe(By.xpath("//div[@class='pull-left']/span"), title);
    }
}
