package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.StringUniqualizer.futureTime;

public class CreateTicketPage {
    @FindBy(id = "id_queue")
    public WebElement queueField;
    @FindBy(xpath = "//*[@id=\"id_queue\"]/option[2]")
    public WebElement billingQueries;
    @FindBy(xpath = "//*[@id=\"id_queue\"]/option[3]")
    public WebElement productIssueOption;
    @FindBy(id = "id_title")
    public WebElement problemSummary;
    @FindBy(id = "id_body")
    public WebElement problemDescription;
    @FindBy(xpath = "//*[@id=\"id_priority\"]/option[2]") //option[1-5] = priority
    public WebElement priority;
    @FindBy(xpath = "//input[@id='id_due_date']")
    public WebElement deadLine;
    @FindBy(id = "id_submitter_email")
    public WebElement emailSubmit;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;
    @FindBy(xpath = "//input[@name='ticket']")
    public WebElement ticketField;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailToCheck;
    @FindBy(xpath = "//input[@value='View Ticket']")
    public WebElement viewTicketButton;

    public CreateTicketPage queueField() {
        queueField.click();
        return this;
    }

    public CreateTicketPage selectBillingQueries() {
        billingQueries.click();
        return this;
    }

    public CreateTicketPage selectProductIssueOption() {
        productIssueOption.click();
        return this;
    }

    public CreateTicketPage problemSummary(String summaryText) {
        problemSummary.click();
        problemSummary.sendKeys(summaryText);
        return this;
    }

    public CreateTicketPage problemDescription(String problemText) {
        problemDescription.click();
        problemDescription.sendKeys(problemText);
        return this;
    }

    public CreateTicketPage priority() {
        priority.click();
        return this;
    }

    public CreateTicketPage deadLine() {
        deadLine.click();
        deadLine.sendKeys(futureTime());
        return this;
    }

    public CreateTicketPage emailSubmit(String email) {
        emailSubmit.click();
        emailSubmit.sendKeys(email);
        return this;
    }

    public CreatedTicketDetails submitButton() {
        submitButton.click();
        return new CreatedTicketDetails();
    }

    public CreateTicketPage ticketField(String ticketTitle) {
        ticketField.click();
        ticketField.sendKeys(ticketTitle);
        return this;
    }

    public CreateTicketPage emailToCheck(String email) {
        emailToCheck.click();
        emailToCheck.sendKeys(email);
        return this;
    }

    public CreateTicketPage viewTicketButton() {
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