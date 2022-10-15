package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.StringUniqualizer.futureTime;

public class NewTicketPage {
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

    public NewTicketPage queueField() {
        queueField.click();
        return this;
    }

    public NewTicketPage selectBillingQueries() {
        billingQueries.click();
        return this;
    }

    public NewTicketPage selectProductIssueOption() {
        productIssueOption.click();
        return this;
    }

    public NewTicketPage problemSummary(String summaryText) {
        problemSummary.click();
        problemSummary.sendKeys(summaryText);
        return this;
    }

    public NewTicketPage problemDescription(String problemText) {
        problemDescription.click();
        problemDescription.sendKeys(problemText);
        return this;
    }

    public NewTicketPage priority() {
        priority.click();
        return this;
    }

    public NewTicketPage deadLine() {
        deadLine.click();
        deadLine.sendKeys(futureTime());
        return this;
    }

    public NewTicketPage emailSubmit(String email) {
        emailSubmit.click();
        emailSubmit.sendKeys(email);
        return this;
    }

    public CreatedTicketDetails submitButton() {
        submitButton.click();
        return new CreatedTicketDetails();
    }

}
