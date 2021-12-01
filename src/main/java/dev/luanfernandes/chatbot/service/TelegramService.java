package dev.luanfernandes.chatbot.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import dev.luanfernandes.chatbot.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TelegramService {

    @Autowired
    AppConfig appConfig;

    @Autowired
    WeatherService weatherService;

    boolean previsao = false;

    public void update(DialogService dialogService) {
        TelegramBot bot = new TelegramBot(appConfig.getTelegramToken());
        bot.setUpdatesListener(updates -> {
            for (Update update : updates) {
                Message message = update.message();
                if (update.message() != null) {
                	if (message.messageId() == 1 || message.text().equals("/start")) {
                		start(bot, message);
                	} else if (message.text().equals("/previsao") || previsao) {
                		weather(bot, message);
                	} else {
                		dialogFlow(dialogService, bot, message);
                	}
				}
            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }

    private void dialogFlow(DialogService dialogService, TelegramBot bot, Message message) {
        bot.execute(new SendChatAction(message.chat().id(), ChatAction.typing));
        String response = dialogService.detectIntents(message.text());
        bot.execute(new SendMessage(message.chat().id(), response));
    }

    private void weather(TelegramBot bot, Message message) {
        if (previsao) {
            try {
                var weather = weatherService.getWeather(message.text());
                var response = String.format("Previsão do tempo em %s é de %sºC.", message.text(), Math.round(weather.getMain().getTemp()));
                bot.execute(new SendMessage(message.chat().id(), response));
            } catch (Exception e) {
                log.info(e.getMessage());
            }
            previsao = false;
        } else {
            previsao = true;
            bot.execute(new SendChatAction(message.chat().id(), ChatAction.typing));
            bot.execute(new SendMessage(message.chat().id(), "De qual cidade você fala?"));
        }
    }

    private void start(TelegramBot bot, Message message) {
        bot.execute(new SendChatAction(message.chat().id(), ChatAction.typing));
        bot.execute(new SendMessage(message.chat().id(), String.format("Olá %s, eu sou o chatbot da fiap!",message.chat().firstName())));
        weather(bot, message);
    }

}