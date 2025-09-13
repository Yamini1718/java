


import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class example extends start{

    private WebDriverWait wait;

    // Locators
    private By switchToMenu = By.xpath("//*[@id='header']/nav/div/div[2]/ul/li[4]");
    private By alertSubMenu = By.xpath("//*[@id='header']/nav/div/div[2]/ul/li[4]/ul/li[1]/a");
    private By registerMenu = By.xpath("//*[@id='header']/nav/div/div[2]/ul/li[1]/a");
    private By alertButton_OKTab = By.xpath("//*[@id='OKTab']/button");

    private By firstNameField = By.xpath("//*[@id='basicBootstrapForm']/div[1]/div[1]/input");
    private By lastNameField = By.xpath("//*[@id='basicBootstrapForm']/div[1]/div[2]/input");
    private By addressField = By.xpath("//*[@id='basicBootstrapForm']/div[2]/div/textarea");
    private By emailField = By.xpath("//*[@id='eid']/input");
    private By phoneField = By.xpath("//*[@id='basicBootstrapForm']/div[4]/div/input");

    private By maleRadio = By.xpath("//*[@id='basicBootstrapForm']/div[5]/div/label[1]/input");
    private By femaleRadio = By.xpath("//*[@id='basicBootstrapForm']/div[5]/div/label[2]/input");

    private By cricketCheckbox = By.id("checkbox1");
    private By moviesCheckbox = By.id("checkbox2");
    private By hockeyCheckbox = By.id("checkbox3");

    private By countryOpenSelector = By.cssSelector(".select2-selection");
    private By countryDropdownContainer = By.cssSelector("span#select2-country-container");

    private By yearDropdown = By.id("yearbox");
    private By monthDropdown = By.xpath("//*[@id='basicBootstrapForm']/div[11]/div[2]/select");
    private By dayDropdown = By.id("daybox");

    public FormManagement_L1_Pages(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String validateTitleOfHomePage() {
        driver.get("https://demo.automationtesting.in/Register.html");
        wait.until(ExpectedConditions.titleContains("Register"));
        return driver.getTitle();
    }

    public String clickOnSwitchToAlertandValidateTitleOfPage() {
        wait.until(ExpectedConditions.elementToBeClickable(switchToMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(alertSubMenu)).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.titleContains("Alert"),
                ExpectedConditions.titleContains("Alerts")));
        return driver.getTitle();
    }

    public String handleAlertsPopupAndValidateTheTextInsideAnAlertsPopup() {
        wait.until(ExpectedConditions.elementToBeClickable(alertButton_OKTab)).click();
        Alert a = wait.until(ExpectedConditions.alertIsPresent());
        String text = a.getText();
        a.accept();
        return text;
    }

    public boolean clickOnRegisterLinkandFillTheForms(Map<String, String> data) {
        wait.until(ExpectedConditions.elementToBeClickable(registerMenu)).click();

        driver.findElement(firstNameField).sendKeys(data.getOrDefault("firstname", ""));
        driver.findElement(lastNameField).sendKeys(data.getOrDefault("lastname", ""));
        driver.findElement(addressField).sendKeys(data.getOrDefault("address", ""));
        driver.findElement(emailField).sendKeys(data.getOrDefault("email", ""));
        driver.findElement(phoneField).sendKeys(data.getOrDefault("phone", ""));

        driver.findElement(maleRadio).click();
        driver.findElement(cricketCheckbox).click();
        driver.findElement(moviesCheckbox).click();
        driver.findElement(hockeyCheckbox).click();

        return driver.findElement(maleRadio).isSelected()
                && driver.findElement(cricketCheckbox).isSelected()
                && driver.findElement(moviesCheckbox).isSelected()
                && driver.findElement(hockeyCheckbox).isSelected();
    }

    public boolean clickOnSelectCountryAndSelectEachCountry() {
        driver.navigate().refresh();
        List<String> countries = Arrays.asList("Bangladesh", "Denmark", "Hong Kong", "Australia");

        for (String country : countries) {
            wait.until(ExpectedConditions.elementToBeClickable(countryOpenSelector)).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='" + country + "']"))).click();
            String selected = wait.until(ExpectedConditions.visibilityOfElementLocated(countryDropdownContainer)).getText().trim();
            if (!selected.contains(country)) return false;
        }
        return true;
    }

    public String selectAustraliaInCountryDrpdownAndValidate() {
        driver.navigate().refresh();
        wait.until(ExpectedConditions.elementToBeClickable(countryOpenSelector)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Australia']"))).click();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(countryDropdownContainer)).getText().trim();
    }

    public boolean checkUncheckCheckBoxAndValidateThatCheckBox() {
        WebElement cricket = wait.until(ExpectedConditions.visibilityOfElementLocated(cricketCheckbox));
        WebElement movies = driver.findElement(moviesCheckbox);
        WebElement hockey = driver.findElement(hockeyCheckbox);

        for (WebElement checkbox : Arrays.asList(cricket, movies, hockey)) {
            checkbox.click();
            if (!checkbox.isSelected()) return false;
            checkbox.click();
            if (checkbox.isSelected()) return false;
            checkbox.click();
        }
        return cricket.isSelected() && movies.isSelected() && hockey.isSelected();
    }

    public boolean selectRadioButtonvalidateRadioButtonOptionIsSelectable() {
        WebElement male = wait.until(ExpectedConditions.elementToBeClickable(maleRadio));
        WebElement female = driver.findElement(femaleRadio);

        male.click();
        boolean step1 = male.isSelected() && !female.isSelected();

        female.click();
        boolean step2 = female.isSelected() && !male.isSelected();

        return step1 && step2;
    }

    public boolean selectYearMonthDate() {
        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(yearDropdown))).selectByValue("1996");
        new Select(driver.findElement(monthDropdown)).selectByVisibleText("June");
        new Select(driver.findElement(dayDropdown)).selectByValue("25");
        return driver.findElement(yearDropdown).isDisplayed()
                && driver.findElement(monthDropdown).isDisplayed()
                && driver.findElement(dayDropdown).isDisplayed();
    }
}
