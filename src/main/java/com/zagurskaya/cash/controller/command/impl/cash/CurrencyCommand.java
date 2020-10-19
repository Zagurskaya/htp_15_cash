package com.zagurskaya.cash.controller.command.impl.cash;

import com.zagurskaya.cash.controller.command.AbstractСommand;
import com.zagurskaya.cash.controller.command.ActionType;

import javax.servlet.http.HttpServletRequest;

/**
 * Действие "Валюта".
 */
public class CurrencyCommand extends AbstractСommand {
    /**
     * Конструктор
     *
     * @param path - путь
     */
    public CurrencyCommand(String path) {
        super(path);
    }

    @Override
    public ActionType execute(HttpServletRequest request) {
        return ActionType.CURRENCY;
    }
}
