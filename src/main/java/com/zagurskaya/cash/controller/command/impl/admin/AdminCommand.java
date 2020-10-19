package com.zagurskaya.cash.controller.command.impl.admin;

import com.zagurskaya.cash.controller.command.AbstractСommand;
import com.zagurskaya.cash.controller.command.ActionType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Действие "Главная страница администратора".
 */
public class AdminCommand extends AbstractСommand {
    /**
     * Конструктор
     *
     * @param path - путь
     */
    public AdminCommand(String path) {
        super(path);
    }

    @Override
    public ActionType execute(HttpServletRequest request) {
        final HttpSession session = request.getSession(false);
        session.removeAttribute("message");
        session.removeAttribute("error");

        ActionType actionType = actionAfterValidationUserAndPermission(request, ActionType.ADMIN);
        return actionType;
    }
}
