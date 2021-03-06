/*MAP2 page (pages tree)*/
package map2;

import dmsDealers.Dealers;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import page.Page;
import settings.Sites;
import settings.Website;

/**
 * Created by Julia on 04.01.2017.
 */
public class MAP2 extends Page {
    public MAP2(WebDriver webDriver) {
        super(webDriver);
    }

    /*declare elements on the page*/
    @FindBy(how = How.CSS, using = "div[data-page='contact_us']")
    private WebElement contactUsTab;

    @FindBy(how = How.CSS, using = "div[data-page='trade_in']")
    private WebElement tradeInTab;

    @FindBy(how = How.CSS, using = "div[data-page='vehicle']")
    private WebElement vehicleDetailsTab;

    @FindBy(how = How.CSS, using = "div[data-page='custom']")
    private WebElement customTab;

    @FindBy(how = How.CSS, using = "div[data-page='index']")
    private WebElement homePageTab;

    @FindBy(how = How.CSS, using = "div[data-page='inventory']")
    private WebElement inventoryPageTab;

    @FindBy(how = How.CSS, using = "div.map-link.pull-right")
    private WebElement addPageBtn;

    @FindBy(how = How.XPATH, using = "(//span[@class='ui-button ui-state-default'])[last()]")
    private WebElement deleteLastPageBtn;

    @FindBy(how = How.XPATH, using = "(//span[@class='mapx-button-ico edit'])[last()]/..")
    private WebElement editLastPageBtn;

    @FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Admin')])[1]")
    private WebElement adminMenuItem;

    @FindBy(how = How.CSS, using = "a[href='/dms/admin/dealers']")
    private WebElement dealersMenuItem;

    @FindBy(how = How.CSS, using = "a[href='/dms/settings']")
    private WebElement settingsMenuItem;

    @FindBy(how = How.CSS, using = "a[href='/dms/settings/sites']")
    private WebElement sitesMenuItem;

    @FindBy(how = How.CSS, using = "a[href='/dms/settings/website']")
    private WebElement websiteMenuItem;



    /*click on a particular tab in pages tree*/
    public void clickContactTab() {
        contactUsTab.click();
    }
    public void clickTradeInTab() { tradeInTab.click(); }
    public void clickVDTab() {
        vehicleDetailsTab.click();
    }

    public void clickCustomTab() {
        customTab.click();
    }

    public void clickHomePageTab() {
        homePageTab.click();
    }

    public void clickInventoryPageTab() {
        inventoryPageTab.click();
    }

    /*click on Add Page button, that opens Contact Us editor*/
    public map2PageEditor clickAddPage() {
        addPageBtn.click();
        return PageFactory.initElements(driver, map2PageEditor.class);
    }

    /*click on Delete Page icon*/
    public void deletePage() {
            deleteLastPageBtn.click();
            driver.switchTo().alert().accept(); //click OK in alert

    }

    /*click on Edit last page icon*/
    public map2PageEditor editLastPage() {
        editLastPageBtn.click();
        return PageFactory.initElements(driver, map2PageEditor.class);
    }

    /*check if a particular tab exists in pages tree*/
    public boolean isContactTabExists() {
        try {
            contactUsTab.isDisplayed();
            return true;// return true, if element exists
        } catch (NoSuchElementException ex) {
            return false;//return false, if element doesn't exist
        }
    }

    public boolean isTradeInTabExists() {
        try {
            tradeInTab.isDisplayed();
            return true;// return true, if element exists
        } catch (NoSuchElementException ex) {
            return false;//return false, if element doesn't exist
        }
    }

    /*go to dms Dealers module*/
    public Dealers clickOnDealersMenu() {
        Actions action = new Actions(driver);
        Action moveToElem = action.moveToElement(adminMenuItem).build();
        moveToElem.perform();
        dealersMenuItem.click();
        return PageFactory.initElements(driver, Dealers.class);
    }

    /*go to dms Sites module*/
    public Sites clickOnSitesMenu() {
        Actions action = new Actions(driver);
        Action moveToElem = action.moveToElement(settingsMenuItem).build();
        moveToElem.perform();
        sitesMenuItem.click();
        return PageFactory.initElements(driver, Sites.class);
    }

    /*go to dms Website General page*/
    public Website clickOnWebsiteMenu() {
        Actions action = new Actions(driver);
        Action moveToElem = action.moveToElement(settingsMenuItem).build();
        moveToElem.perform();
        websiteMenuItem.click();
        return PageFactory.initElements(driver, Website.class);
    }
}
