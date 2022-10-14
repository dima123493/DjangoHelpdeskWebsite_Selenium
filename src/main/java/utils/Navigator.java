package utils;

import helpDeskConfiguration.ConfigProvider;
import pages.*;

import static org.openqa.selenium.support.PageFactory.initElements;
import static seleniumCofiguration.Selenium.driver;

public class Navigator {
    public static CreateTicketPage openMainPage() {
        driver.navigate().to(ConfigProvider.MAIN_URL);
        return initElements(driver, CreateTicketPage.class);
    }

    public static CreatedTicketDetails openCreatedTicketsPage(String url) {
        driver.navigate().to(url);
        return initElements(driver, CreatedTicketDetails.class);
    }

    public static LoginPage openLoginPage() {
        driver.navigate().to(ConfigProvider.LOGIN_URL);
        return initElements(driver, LoginPage.class);
    }

    public static AllTicketsPage openAllTicketsPage() {
        driver.navigate().to(ConfigProvider.LOGIN_URL);
        return initElements(driver, AllTicketsPage.class);
    }

    public static ChosenTicketPage openChosenTicketPage() {
        driver.navigate().to(ConfigProvider.LOGIN_URL);
        return initElements(driver, ChosenTicketPage.class);
    }
}