package com.darj.demo.util.messages;

import java.util.Locale;

import org.springframework.context.MessageSource;

import com.darj.demo.exceptions.TicketHttpException;

public class MessagesUtil {

	private static final Locale DEFAULT_LOCALE = Locale.getDefault();

    private static MessageSource messageSource;

    private MessagesUtil() {
    }
    
    public static TicketHttpException buildException(MessagesEnum message) {
        return new TicketHttpException(message.getCode(), message.name(),
                buildMessage(message.getMessage()));
    }
    
    public static TicketHttpException buildException(MessagesEnum message, Throwable ex) {
        return new TicketHttpException(message.getCode(), message.name(),
                buildMessage(message.getMessage()), ex);
    }

    public static TicketHttpException buildException(MessagesEnum message, Object[] args) {
        return new TicketHttpException(message.getCode(), message.name(),
                buildMessage(message.getMessage(), args));
    }

    public static TicketHttpException buildException(MessagesEnum message, Object args) {
        return new TicketHttpException(message.getCode(), message.name(),
                buildMessage(message.getMessage(), args));
    }
    
    public static String buildMessage(MessagesEnum messagesEnum) {
        return messageSource.getMessage(messagesEnum.getMessage(), null, DEFAULT_LOCALE);
    }
    
    public static String buildMessage(String message) {
        return messageSource.getMessage(message, null, DEFAULT_LOCALE);
    }

    public static String buildMessage(String message, Object arg) {
        return messageSource.getMessage(message, new Object[]{arg}, DEFAULT_LOCALE);
    }

    public static String buildMessage(String message, Object[] args) {
        return messageSource.getMessage(message, args, DEFAULT_LOCALE);
    }

    public static synchronized void init(MessageSource messageSource) {
        MessagesUtil.messageSource = messageSource;
    }
	
}
