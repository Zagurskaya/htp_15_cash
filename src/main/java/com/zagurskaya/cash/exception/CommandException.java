package com.zagurskaya.cash.exception;

public class CommandException extends Exception {
    /**
     * Конструктор
     */
    public CommandException() {
        super();
    }

    /**
     * Конструктор
     *
     * @param message - сообщение
     */
    public CommandException(String message) {
        super(message);
    }

    /**
     * Конструктор
     *
     * @param message - сообщение
     * @param cause   - причина
     */
    public CommandException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Конструктор
     *
     * @param cause - причина
     */
    public CommandException(Throwable cause) {
        super(cause);
    }

    /**
     * Конструктор
     *
     * @param message            - сообщение
     * @param cause              - причина
     * @param enableSuppression  - включено подавление или нет
     * @param writableStackTrace - должна ли трассировка стека быть доступной для записи
     */
    protected CommandException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}