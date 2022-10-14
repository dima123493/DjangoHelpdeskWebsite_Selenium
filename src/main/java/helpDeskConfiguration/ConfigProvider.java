package helpDeskConfiguration;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    static Config readConfig() {
        return ConfigFactory.load("application.conf");
    }

    String MAIN_URL = readConfig().getString("mainUrl");
    String LOGIN_URL = readConfig().getString("loginUrl");
    String ALL_TICKETS_URL = readConfig().getString("allTicketsUrl");

    String USER_LOGIN = readConfig().getString("usersParams.user.login");
    String USER_PASSWORD = readConfig().getString("usersParams.user.password");
}
