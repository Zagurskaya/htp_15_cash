package com.zagurskaya.cash.controller.command.impl.cash;

import com.zagurskaya.cash.controller.command.AbstractСommand;
import com.zagurskaya.cash.controller.command.Action;

import javax.servlet.http.HttpServletRequest;

public class CurrencyCommand extends AbstractСommand {
    public CurrencyCommand(String path) {
        super(path);
    }

    @Override
    public Action execute(HttpServletRequest request) {
        return Action.CURRENCY;
    }
}
