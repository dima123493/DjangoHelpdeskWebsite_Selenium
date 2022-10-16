package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static seleniumCofiguration.Selenium.driver;

public class ChosenTicketPage {
    @FindBy(xpath = "//tbody/tr[2]/td[2]")
    public WebElement submitterEmail;
    @FindBy(xpath = "//*[@id=\"ticket-description\"]/p")
    public WebElement submitterDescription;
    @FindBy(id = "commentBox")
    public WebElement resolutionCommentField;
    @FindBy(css = "#st_resolved")
    public WebElement resolvedStatusRadioButton;
    @FindBy(xpath = "//label[@for='st_resolved']")
    public WebElement makePublicCheckbox;
    @FindBy(xpath = "//button[normalize-space()='Update This Ticket']")
    public WebElement updateTicketButton;
    @FindBy(xpath = "//thead//h3")
    public WebElement problemHeader;


    public String submitterEmail() {
        return submitterEmail.getText();
    }

    public String submitterDescription() {
        return submitterDescription.getText();
    }

    public ChosenTicketPage resolutionCommentField(String comment) {
        resolutionCommentField.click();
        resolutionCommentField.sendKeys(comment);
        return this;
    }

    public ChosenTicketPage resolvedStatusRadioButton() {
        Actions action = new Actions(driver);
        action.moveToElement(resolvedStatusRadioButton).click().perform();
        return this;
    }

    public ChosenTicketPage makePublicCheckbox() {
        makePublicCheckbox.click();
        return this;
    }

    public ChosenTicketPage updateTicketButton() {
        updateTicketButton.click();
        return this;
    }

    public boolean checkProblemHeader(String header) {
        return problemHeader.getText().contains(header);
    }
}
