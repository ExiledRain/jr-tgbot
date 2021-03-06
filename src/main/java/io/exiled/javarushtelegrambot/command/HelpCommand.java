package io.exiled.javarushtelegrambot.command;

import io.exiled.javarushtelegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static io.exiled.javarushtelegrambot.command.CommandName.*;

/**
 * Help {@link Command}.
 *
 * @author Vassili Mosaljov
 * @version 1.0
 */
public class HelpCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    public static final String HELP_MESSAGE = String.format("✨<b>Available commands:</b>✨\n\n" +
                    "<b>Start\\Stop with bot</b>\n" +
                    "%s - Start working with me\n" +
                    "%s - Stop working with me\n\n" +
                    "%s - get help working with me\n",
            START.getCommandName(), STOP.getCommandName(), HELP.getCommandName());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
