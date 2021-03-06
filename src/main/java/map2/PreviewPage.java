/*MAP2 preview page*/
package map2;

import dwsPages.FormsPage;
import dwsPages.SearchesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import page.Page;

/**
 * Created by Julia on 13.01.2017.
 */
public class PreviewPage extends Page {
    public PreviewPage(WebDriver webDriver) {
        super(webDriver);
    }

    /*declare elements on the page*/
    @FindBy(how = How.XPATH, using = "//a[@href='#preview-open']")
    private WebElement visitWebsiteBtn;

    /*click on Visit Website button, that opens Contact Us dws page*/
    public FormsPage clickOnVisitWebsite() {
        visitWebsiteBtn.click();
        return PageFactory.initElements(driver, FormsPage.class);
    }

    /*click on Visit Website button, that opens Home dws page*/
    public SearchesPage clickOnVisitWebsiteHome() {
        visitWebsiteBtn.click();
        return PageFactory.initElements(driver, SearchesPage.class);
    }
}
