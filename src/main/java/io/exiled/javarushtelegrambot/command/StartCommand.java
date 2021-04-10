package io.exiled.javarushtelegrambot.command;

import io.exiled.javarushtelegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Start {@link Command}.
 *
 * @author Vassili Moskaljov
 * @version 1.0
 */
public class StartCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    public final static String START_MESSAGE = "Hello, I am Telegram Bot. I will help you " +
            "to keep track of articles those author, who you like. I am small, but i am learning.";

    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
