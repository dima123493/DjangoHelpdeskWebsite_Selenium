package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

public class AllTicketsPage {
    @FindBy(id = "datatabletabcontents-tab")
    public WebElement tableTab;
    @FindBy(xpath = "//*[@id=\"ticketTable_length\"]/label/select/option[1]")
    public WebElement entries10;
    @FindBy(xpath = "//*[@id=\"ticketTable_length\"]/label/select/option[2]")
    public WebElement entries25;
    @FindBy(xpath = "//*[@id=\"ticketTable_length\"]/label/select/option[3]")
    public WebElement entries50;
    @FindBy(xpath = "//*[@id=\"ticketTable_length\"]/label/select/option[4]")
    public WebElement entries100;
    @FindBy(xpath = "//*[@id=\"ticketTable\"]/tbody//a")
    public WebElement tbody;
    @FindBy(id = "search_query")
    public WebElement searchField;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement searchGoButton;
    @FindBy(css = "form[id='ticket_mass_update'] button[type='submit']")
    public WebElement selectedTicketGoButton;
    @FindBy(id = "userDropdown")
    public WebElement userFieldDropdown;
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    public WebElement logoutButton;
    @FindBy(id = "ticketTable_next")
    public WebElement ticketTableNextButton;
    @FindBy(id = "ticketTable_previous")
    public WebElement ticketTablePrevButton;


    public AllTicketsPage select10Entries() {
        tableTab.click();
        entries10.click();
        return this;
    }

    public AllTicketsPage select25Entries() {
        tableTab.click();
        entries25.click();
        return this;
    }

    public AllTicketsPage select50Entries() {
        tableTab.click();
        entries50.click();
        return this;
    }

    public AllTicketsPage select100Entries() {
        tableTab.click();
        entries100.click();
        return this;
    }

    public int amountOfElements() {
        return tbody.findElements(By.xpath("//*[@id=\"ticketTable\"]/tbody//a")).size();
    }

    public Optional<String> linkOfNewlyCreatedTicket(String summary) {
        List<WebElement> elements = tbody.findElements(By.xpath("//*[@id=\"ticketTable\"]/tbody//a"));
        for (WebElement element : elements) {
            String link;
            if(element.getText().contains(summary)) {
                link = element.getAttribute("href");
                return Optional.of(link);
            }
        }
        return Optional.empty();
    }

    public AllTicketsPage searchField(String searchQuery) {
        searchField.click();
        searchField.sendKeys(searchQuery);
        return this;
    }

    public AllTicketsPage searchGoButton() {
        searchGoButton.click();
        return this;
    }

    public String goButton() {
        return selectedTicketGoButton.getText();
    }

    public AllTicketsPage userFieldDropdown() {
        userFieldDropdown.click();
        return this;
    }
    public HomePage logoutButton() {
        logoutButton.click();
        return new HomePage();
    }

    public AllTicketsPage ticketTableNextButton() {
        ticketTableNextButton.click();
        return this;
    }

    public AllTicketsPage ticketTablePrevButton() {
        ticketTablePrevButton.click();
        return this;
    }

}