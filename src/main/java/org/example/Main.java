import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new LatinToCyrillicBot("6208268896:AAGbUUnU_G-pp-b9SuWPCfu_mQU5m9W3EWc"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
