package io.exiled.javarushtelegrambot.service;

import io.exiled.javarushtelegrambot.bot.JavaRushTelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Implementation of {@link SendBotMessageService} interface
 *
 * @author Vassili Moskaljov
 * @version 1.0
 */
public class SendBotMessageServiceImpl implements SendBotMessageService {
    private final JavaRushTelegramBot javaRushBot;

    @Autowired
    public SendBotMessageServiceImpl(JavaRushTelegramBot javaRushBot) {
        this.javaRushBot = javaRushBot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            javaRushBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
