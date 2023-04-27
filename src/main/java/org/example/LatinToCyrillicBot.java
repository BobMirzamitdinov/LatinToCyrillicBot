package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;
import java.util.Map;

public class LatinToCyrillicBot extends TelegramLongPollingBot {
    private String botToken;

    public LatinToCyrillicBot(String botToken) {
        this.botToken = botToken;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            String text = message.getText();
            String convertedText = latinToCyrillic(text);

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(convertedText);

            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private String latinToCyrillic(String text) {
        Map<Character, Character> conversionMap = new HashMap<>();
        // Add Latin-Cyrillic character mappings
        conversionMap.put('a', 'а');
        conversionMap.put('b', 'б');
        // ... Add other characters here

        StringBuilder convertedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            Character cyrillicChar = conversionMap.get(Character.toLowerCase(c));
            if (cyrillicChar != null) {
                if (Character.isUpperCase(c)) {
                    convertedText.append(Character.toUpperCase(cyrillicChar));
                } else {
                    convertedText.append(cyrillicChar);
                }
            } else {
                convertedText.append(c);
            }
        }

        return convertedText.toString();
    }
}
