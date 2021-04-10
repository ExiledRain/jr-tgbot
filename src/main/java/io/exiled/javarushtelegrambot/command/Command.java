package io.exiled.javarushtelegrambot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Command interface for handling telegram-bot commands
 *
 * @author Vassili Moskaljov
 * @version 1.0
 * */
public interface Command {
    /*
    * Main method, which is executing command logic
    * */
    void execute(Update update);
}
