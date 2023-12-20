package vacancy.bot;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


@Component
public class BotRegister {
    private final VacanciesBot vacanciesBot;

    public BotRegister(VacanciesBot vacanciesBot){
        this.vacanciesBot = vacanciesBot;
    }

    @PostConstruct
    public void init(){
        TelegramBotsApi telegramBotsApi = null;
        try {
            telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
        try {
            telegramBotsApi.registerBot(vacanciesBot);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

}
