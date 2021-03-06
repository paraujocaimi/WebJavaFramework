package page;

import elementPage.GoogleElementPage;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import utils.environment.SetUpEnvironment;
import utils.report.TakeScreenshot;

public class GooglePage extends GoogleElementPage {

    WebDriver driver;
    SetUpEnvironment setUpEnvironment = new SetUpEnvironment();
    TakeScreenshot screenshot = new TakeScreenshot();

    public void initTest(String url) {
        setUpEnvironment.upApplication(url);
        PageFactory.initElements(setUpEnvironment.getDriver(), this);
        driver = setUpEnvironment.getDriver();
    }

    public boolean search(String search) {
        Actions actions = new Actions(driver);
        boolean isSearch = false;
        screenshot.takeSnapShot();

        try {
            inputPesquisar.sendKeys(search);
            actions.sendKeys(Keys.TAB).perform();
            isSearch = true;
        }catch (ElementClickInterceptedException e) {
                e.printStackTrace();
                System.out.println("Não foi possível clicar");
        }catch (ElementNotInteractableException e) {
            e.printStackTrace();
            System.out.println("Elemento não visivel na tela");
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Exception");
        }

        screenshot.blurTheElement(inputPesquisar);
        screenshot.highlightTheElement(inputPesquisar);
        screenshot.highlightWithText(inputPesquisar, "Using text on screenshot");
        screenshot.imageWithTitle(inputPesquisar, "Using Title on screenshot");

        return isSearch;
    }

    public boolean clickToSearch(){
        Actions actions = new Actions(driver);
        boolean isClicked = false;

        try {
            actions.moveToElement(btnPesquisar);
            actions.perform();
            screenshot.highlightTheElement(btnPesquisar);
            btnPesquisar.click();
            isClicked = true;
        }catch (ElementClickInterceptedException e) {
            e.printStackTrace();
            System.out.println("Não foi possível clicar");
        }catch (ElementNotInteractableException e) {
            e.printStackTrace();
            System.out.println("Elemento não visivel na tela");
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Exception");
        }

        return isClicked;
    }

    public boolean clickFirstSearch(){
        boolean isGoogleNews = false;
        try {
            firstSearch.click();
            isGoogleNews = true;
        }catch (ElementClickInterceptedException e) {
            e.printStackTrace();
            System.out.println("Não foi possível clicar");
        }catch (ElementNotInteractableException e) {
            e.printStackTrace();
            System.out.println("Elemento não visivel na tela");
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Exception");
        }

        return isGoogleNews;
    }

}
