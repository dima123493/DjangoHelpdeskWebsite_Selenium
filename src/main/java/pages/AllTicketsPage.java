package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllTicketsPage {
    @FindBy(css = "form[id='ticket_mass_update'] button[type='submit']")
    public WebElement goButton;

    public String goButton() {
        return goButton.getText();
    }
}
