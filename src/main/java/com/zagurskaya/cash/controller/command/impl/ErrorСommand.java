package com.zagurskaya.cash.controller.command.impl;

import com.zagurskaya.cash.controller.command.AbstractСommand;
import com.zagurskaya.cash.controller.command.ActionType;
import com.zagurskaya.cash.controller.command.AttributeName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Действие "ERROR".
 */
public class ErrorСommand extends AbstractСommand {
    /**
     * Конструктор
     *
     * @param directoryPath - путь
     */
    public ErrorСommand(String directoryPath) {
        super(directoryPath);
    }

    @Override
    public ActionType execute(HttpServletRequest request, HttpServletResponse response) {
        final HttpSession session = request.getSession(false);

        request.setAttribute(AttributeName.ERROR, session.getAttribute(AttributeName.ERROR));
        session.removeAttribute(AttributeName.ERROR);
        return ActionType.ERROR;
    }
}
