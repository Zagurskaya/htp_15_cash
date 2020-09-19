package com.zagurskaya.cash.model.service.impl;

import com.zagurskaya.cash.entity.User;
import com.zagurskaya.cash.model.dao.UserDao;
import com.zagurskaya.cash.model.dao.impl.UserDaoImpl;
import com.zagurskaya.cash.exception.DAOException;
import com.zagurskaya.cash.exception.ServiceException;
import com.zagurskaya.cash.model.pool.EntityTransaction;
import com.zagurskaya.cash.model.service.UserService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class UserServiceImpl implements UserService {

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
    private UserDao userDao = new UserDaoImpl();
    private EntityTransaction transaction = new EntityTransaction();

    @Override
    public User getUserByLoginAndPassword(String login, String password) throws ServiceException {
        transaction.init(userDao);
        try {
            User user = userDao.getUserByLoginAndPassword(login, password);
            transaction.commit();
            return user;
        } catch (DAOException e) {
            transaction.rollback();
            logger.log(Level.ERROR, "Database exception during fiend user by login and password", e);
            throw new ServiceException("Database exception during fiend user by login and password", e);
        } finally {
            transaction.end();
        }
    }

    @Override
    public List<User> getAll() throws ServiceException {
        transaction.init(userDao);
        try {
            List<User> users = userDao.getAll();
            transaction.commit();
            return users;
        } catch (DAOException e) {
            transaction.rollback();
            logger.log(Level.ERROR, "Database exception during fiend all user", e);
            throw new ServiceException("Database exception during fiend all user", e);
        } finally {
            transaction.end();
        }
    }

    @Override
    public User getById(Long id) throws ServiceException {
        transaction.init(userDao);
        try {
            User user = userDao.getById(id);
            transaction.commit();
            return user;
        } catch (DAOException e) {
            transaction.rollback();
            logger.log(Level.ERROR, "Database exception during fiend user by id", e);
            throw new ServiceException("Database exception during fiend user by id", e);
        } finally {
            transaction.end();
        }
    }

    @Override
    public boolean create(User user) throws ServiceException {
        return false;
    }

    @Override
    public User read(long id) throws ServiceException {
        return null;
    }

    @Override
    public boolean update(User user) throws ServiceException {
        return false;
    }

    @Override
    public boolean delete(User user) throws ServiceException {
        return false;
    }

    @Override
    public List<User> getAll(String where) throws ServiceException {
        return null;
    }
}