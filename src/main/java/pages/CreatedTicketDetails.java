package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatedTicketDetails {
    @FindBy(xpath = "//*[@id=\"content-wrapper\"]//tr[3]/td")
    public WebElement emailDetails;
    @FindBy(xpath = "//*[@id=\"content-wrapper\"]//tr[6]/td")
    public WebElement descriptionDetails;

    public String emailDetails() {
        return emailDetails.getText();
    }

    public String descriptionDetails() {
        return descriptionDetails.getText();
    }
}
