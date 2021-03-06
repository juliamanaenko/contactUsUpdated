package advancedSearchHorizontal;

import dmsInventory.Inventory;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.LogFactory;
import utility.PropertyLoader;

import java.util.List;

/**
 * Created by Julia on 23.03.2017.
 */
public class AdvSearchHorizModelSelect extends AdvSearchTestBase2 {

    private static final Logger LOG = LogFactory.getLogger(AdvSearchHorizModelSelect.class);

    @Test
    public void isModelSelectDisabledOnHomePage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
        waitForJSandJQueryToLoad();
        Assert.assertFalse(searchesPage.isModelSelectEnabled());
    }

    @Test
    public void modelsAreTheSameWithInventory() {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Inventory inventory = dmsHome2.clickOnInventoryMenu();
        waitForJSandJQueryToLoad();
        List<String> optionModel = inventory.getModelSelectOptionsText();
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
        waitForJSandJQueryToLoad();
        int k = 0;
        for (int i = 1; i < searchesPage.getMakeSelectOptions().size(); i++) { //loop starts from 1, because there are differences in search and dma inventory ('Make' and 'Any Make')
            searchesPage.selectMakeByIndex(i);
            waitForJSandJQueryToLoad();
            for (int j = 1; j < searchesPage.getModelSelectOptions().size(); j++) {

                LOG.info("InvOption is " + optionModel.get(k));
                LOG.info("SearchOption is " + searchesPage.getModelSelectOptions().get(j).getText().trim());
                Assert.assertEquals(searchesPage.getModelSelectOptions().get(j).getText().trim(), optionModel.get(k));
                k = k + 1;
            }
        }
    }

    @Test
    public void modelValueIsInSearchResult() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
        waitForJSandJQueryToLoad();
        for (int i = 1; i < searchesPage.getMakeSelectOptions().size(); i++) {
            searchesPage.selectMakeByIndex(i);
            waitForJSandJQueryToLoad();
            searchesPage.selectModelByIndex(1);
            waitForJSandJQueryToLoad();
            String optionValue = searchesPage.getModelSelectValue();
            searchesPage.clickSearchBtn();
            waitForJSandJQueryToLoad();
            LOG.info("optionValue is " + optionValue);
            Assert.assertTrue(driver.getCurrentUrl().contains("_model_" + optionValue));
            driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
            waitForJSandJQueryToLoad();
        }
    }

    @Test
    public void modelSelected() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
        waitForJSandJQueryToLoad();
        for (int i = 1; i < searchesPage.getMakeSelectOptions().size(); i++) {
            searchesPage.selectMakeByIndex(i);
            waitForJSandJQueryToLoad();
            searchesPage.selectModelByIndex(1);
            waitForJSandJQueryToLoad();
            Assert.assertEquals(searchesPage.getModelSelectText().trim(), searchesPage.getModelSelectOptions().get(1).getText().trim());
        }
    }

    @Test
    public void selectModelByDefault() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
        waitForJSandJQueryToLoad();
        searchesPage.selectMakeByIndex(1);
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getModelSelectText(), "Any Model");
    }

    @Test
    public void noModelInSearchResult() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
        waitForJSandJQueryToLoad();
        searchesPage.selectMakeByIndex(1);
        waitForJSandJQueryToLoad();
        searchesPage.clickSearchBtn();
        waitForJSandJQueryToLoad();
        Assert.assertFalse(driver.getCurrentUrl().contains("_model_"));
    }

    @Test
    public void clickedModelSelectBackground() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
        waitForJSandJQueryToLoad();
        searchesPage.selectMakeByIndex(1);
        waitForJSandJQueryToLoad();
        searchesPage.selectModelByIndex(1);
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getModelSelectBorderColor(), PropertyLoader.loadProperty("border_color_gray2"));
    }

    @Test
    public void modelIsEnabledIfSelectMake() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
        waitForJSandJQueryToLoad();
        searchesPage.selectMakeByIndex(1);
        waitForJSandJQueryToLoad();
        Assert.assertTrue(searchesPage.isModelSelectEnabled());
    }
}
