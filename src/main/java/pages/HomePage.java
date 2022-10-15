package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends NewTicketPage {
    @FindBy(xpath = "//input[@name='ticket']")
    public WebElement ticketField;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailToCheck;
    @FindBy(xpath = "//input[@value='View Ticket']")
    public WebElement viewTicketButton;

    public HomePage ticketField(String ticketTitle) {
        ticketField.click();
        ticketField.sendKeys(ticketTitle);
        return this;
    }

    public HomePage emailToCheck(String email) {
        emailToCheck.click();
        emailToCheck.sendKeys(email);
        return this;
    }

    public HomePage viewTicketButton() {
        viewTicketButton.click();
        return this;
    }

    /*    public CreateTicketPage createTicket() {
            return createTicket("Default summary", "Default description");
        }*/

/*    public CreateTicketPage createTicket(String summary, String description) {
        queueField.click();
        productIssueOption.click();
        problemSummary.sendKeys(summary);
        problemDescription.sendKeys(description);
        return this;
    }*/
}