package com.zagurskaya.cash.controller.command.impl;

import com.zagurskaya.cash.controller.command.AbstractСommand;
import com.zagurskaya.cash.controller.command.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ErrorСommand extends AbstractСommand {

    public ErrorСommand(String path) {
        super(path);
    }

    @Override
    public Action execute(HttpServletRequest request) {
        final HttpSession session = request.getSession(false);

        request.setAttribute("error", session.getAttribute("error"));
        session.removeAttribute("error");
        return Action.ERROR;
    }
}
