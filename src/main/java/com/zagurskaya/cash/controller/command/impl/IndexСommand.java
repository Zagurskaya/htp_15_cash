package com.zagurskaya.cash.controller.command.impl;

import com.zagurskaya.cash.controller.command.Action;
import com.zagurskaya.cash.controller.command.Сommand;

import javax.servlet.http.HttpServletRequest;

public class IndexСommand implements Сommand {
    @Override
    public Action execute(HttpServletRequest request) {
        return Action.INDEX;
    }
}
