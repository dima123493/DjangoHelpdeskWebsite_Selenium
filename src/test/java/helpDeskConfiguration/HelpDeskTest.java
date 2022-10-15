package helpDeskConfiguration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.AllTicketsPage;
import pages.CreatedTicketDetails;
import pages.HomePage;
import pages.LoginPage;
import seleniumCofiguration.Selenium;
import utils.Navigator;
import utils.TestValues;

import java.io.IOException;

import static utils.StringUniqualizer.createUniqueString;

class HelpDeskTest extends Selenium {
    String summary = createUniqueString(TestValues.SUMMARY);
    String linkOfNewlyCreatedTicket;

/*    @BeforeAll
    public static void configurationLoad() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.conf"));
    }*/

    @Test
    void createTicketOnTheMainPage() {
        String description = "Some test description for the Main Page";
        String email = "test@email.com";
        Navigator.openMainPage().queueField().selectProductIssueOption()
                .problemSummary(summary)
                .problemDescription(description)
                .priority()
                .deadLine()
                .emailSubmit(email)
                .submitButton();

        linkOfNewlyCreatedTicket = driver.getCurrentUrl();
        CreatedTicketDetails detailsPage = Navigator.openCreatedTicketsPage(linkOfNewlyCreatedTicket);
        String emailDetails = detailsPage.emailDetails();
        String descriptionDetails = detailsPage.descriptionDetails();

        Assertions.assertEquals(email, emailDetails);
        Assertions.assertEquals(description, descriptionDetails);
    }

    @Test
    void createTicketOnTheNewTicketPage() {
        String description = "Some test description for the Ticket Page";
        String email = "test@email.com";
        Navigator.createTicketPage().queueField().selectProductIssueOption()
                .problemSummary(summary)
                .problemDescription(description)
                .priority()
                .deadLine()
                .emailSubmit(email)
                .submitButton();

        linkOfNewlyCreatedTicket = driver.getCurrentUrl();
        CreatedTicketDetails detailsPage = Navigator.openCreatedTicketsPage(linkOfNewlyCreatedTicket);
        String emailDetails = detailsPage.emailDetails();
        String descriptionDetails = detailsPage.descriptionDetails();

        Assertions.assertEquals(email, emailDetails);
        Assertions.assertEquals(description, descriptionDetails);
    }

    @Test
    void checkBoxIsSelected() {
        LoginPage page = Navigator.openLoginPage();
        Assertions.assertTrue(page.rememberPasswordCheckbox().rememberPasswordCheckbox.isSelected());
    }

    @Test
    void loginProcess() {
        Navigator.openLoginPage().usernameField(ConfigProvider.USER_LOGIN)
                .passwordField(ConfigProvider.USER_PASSWORD)
                .rememberPasswordCheckbox()
                .loginButton();

        AllTicketsPage page = Navigator.openAllTicketsPage();
        String buttonName = page.goButton();
        Assertions.assertEquals("Go", buttonName.trim());
    }

    @Test
    void unableToLoginWithNoCredentialsEntered() {
        LoginPage page = Navigator.openLoginPage().usernameField("")
                .passwordField("")
                .rememberPasswordCheckbox()
                .loginButtonFailedTest();

        Assertions.assertTrue(page.loginButton.isDisplayed());
    }

    @Test
    void logoutProcess() {
        Navigator.openLoginPage().usernameField(ConfigProvider.USER_LOGIN)
                .passwordField(ConfigProvider.USER_PASSWORD)
                .rememberPasswordCheckbox()
                .loginButton();

        AllTicketsPage page = Navigator.openAllTicketsPage();
        String buttonName = page.goButton();
        Assertions.assertEquals("Go", buttonName.trim());

        page.userFieldDropdown().logoutButton();
        HomePage homePage = Navigator.openMainPage();
        Assertions.assertTrue(homePage.emailToCheck.isDisplayed());
    }

    @Test
    void changeAmountOfEntriesTo10() {
        LoginPage loginPage = Navigator.openLoginPage();
        loginPage.usernameField(ConfigProvider.USER_LOGIN)
                .passwordField(ConfigProvider.USER_PASSWORD)
                .rememberPasswordCheckbox()
                .loginButton();

        AllTicketsPage page = Navigator.openAllTicketsPage();
        page.select10Entries();
        String amount = String.valueOf(page.amountOfElements());
        Assertions.assertEquals(page.entries10.getText(), amount);
    }

    @Test
    void findLinkOfTicketFromUser() {
        String description = "Some test description for the Ticket Page";
        String email = "test@email.com";
        Navigator.createTicketPage().queueField().selectProductIssueOption()
                .problemSummary(summary)
                .problemDescription(description)
                .priority()
                .deadLine()
                .emailSubmit(email)
                .submitButton();

        LoginPage loginPage = Navigator.openLoginPage();
        loginPage.usernameField(ConfigProvider.USER_LOGIN)
                .passwordField(ConfigProvider.USER_PASSWORD)
                .rememberPasswordCheckbox()
                .loginButton();

        AllTicketsPage page = Navigator.openAllTicketsPage();
        page.searchField(summary).searchGoButton();
        linkOfNewlyCreatedTicket = String.valueOf(page.linkOfNewlyCreatedTicket(summary));
        Assertions.assertNotNull(linkOfNewlyCreatedTicket);
    }

    @Test
    void travelBetweenTicketTableOnThePage() {
        LoginPage loginPage = Navigator.openLoginPage();
        loginPage.usernameField(ConfigProvider.USER_LOGIN)
                .passwordField(ConfigProvider.USER_PASSWORD)
                .rememberPasswordCheckbox()
                .loginButton();
        AllTicketsPage allTickets = Navigator.openAllTicketsPage();

        allTickets.ticketTableNextButton();

        allTickets.ticketTablePrevButton();
    }

    @Disabled("Load configuration file testing")
    @Test
    void readPropertiesFromConfigurationFile() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.conf"));
        String urlFromProperties = System.getProperty("mainUrl");
        //String urlFromConfig = ConfigProvider.mainUrl;
        System.out.println(urlFromProperties);
    }
}