package io.exiled.javarushtelegrambot.bot;

import io.exiled.javarushtelegrambot.command.CommandContainer;
import io.exiled.javarushtelegrambot.service.SendBotMessageServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import static io.exiled.javarushtelegrambot.command.CommandName.NO;

/**
 * Telegram boy for JavaRush Community
 *
 * @author Vassili Moskaljov
 * @version 1.0
 */
@Component
public class JavaRushTelegramBot extends TelegramLongPollingBot {
    public static String COMMAND_PREFIX = "/";
    @Value("${bot.token}")
    private String token;
    @Value("${bot.username}")
    private String username;
    private CommandContainer commandContainer;

    public JavaRushTelegramBot() {
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this));
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();

                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
