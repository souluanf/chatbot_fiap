package dev.luanfernandes.chatbot;

import dev.luanfernandes.chatbot.service.DialogService;
import dev.luanfernandes.chatbot.service.TelegramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatbotApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ChatbotApplication.class, args);
    }

    @Autowired
    DialogService dialogService;

    @Autowired
    TelegramService telegramService;

    @Override
    public void run(String... args) {
        telegramService.update(dialogService);
    }
}
