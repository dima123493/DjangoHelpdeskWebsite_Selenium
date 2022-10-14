package helpDeskConfiguration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.AllTicketsPage;
import pages.CreatedTicketDetails;
import pages.LoginPage;
import seleniumCofiguration.Selenium;
import utils.Navigator;
import utils.TestValues;

import java.io.IOException;

import static utils.StringUniqualizer.createUniqueString;

class HelpDeskTest extends Selenium {
    String summary = createUniqueString(TestValues.SUMMARY);


/*    @BeforeAll
    public static void configurationLoad() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.conf"));
    }*/

    @Test
    void createTicket() {
        String description = "Some test description";
        String email = "test@email.com";
        Navigator.openMainPage().queueField().selectProductIssueOption()
                .problemSummary(summary)
                .problemDescription(description)
                .priority()
                .deadLine()
                .emailSubmit(email)
                .submitButton();

        String strUrl = driver.getCurrentUrl();
        CreatedTicketDetails detailsPage = Navigator.openCreatedTicketsPage(strUrl);
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

    @Disabled("Load configuration file testing")
    @Test
    void readPropertiesFromConfigurationFile() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.conf"));
        String urlFromProperties = System.getProperty("mainUrl");
        //String urlFromConfig = ConfigProvider.mainUrl;
        System.out.println(urlFromProperties);
    }
}