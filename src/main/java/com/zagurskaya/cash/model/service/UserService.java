package com.zagurskaya.cash.model.service;

import com.zagurskaya.cash.entity.User;
import com.zagurskaya.cash.exception.ServiceException;

import java.util.List;

public interface UserService extends Service<User> {
    /**
     * Поиск пользователя по логину  и валидному паролю
     *
     * @param login    - логин
     * @param password - пароль
     * @return пользователь
     * @throws ServiceException ошибке во время выполнения логическтх блоков и действий.
     */
    User findUserByLoginAndValidPassword(String login, String password) throws ServiceException;

    /**
     * Получение списка пользователей
     *
     * @return список пользователей
     */
    List<User> findAll() throws ServiceException;
}
