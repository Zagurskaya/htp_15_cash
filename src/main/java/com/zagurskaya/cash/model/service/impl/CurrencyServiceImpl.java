package com.zagurskaya.cash.model.service.impl;

import com.zagurskaya.cash.constant.AttributeConstant;
import com.zagurskaya.cash.entity.Currency;
import com.zagurskaya.cash.exception.DAOException;
import com.zagurskaya.cash.exception.RepositoryConstraintViolationException;
import com.zagurskaya.cash.exception.ServiceConstraintViolationException;
import com.zagurskaya.cash.exception.ServiceException;
import com.zagurskaya.cash.model.dao.CurrencyDao;
import com.zagurskaya.cash.model.dao.impl.CurrencyDaoImpl;
import com.zagurskaya.cash.model.service.EntityTransaction;
import com.zagurskaya.cash.model.service.CurrencyService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class CurrencyServiceImpl implements CurrencyService {

    private static final Logger logger = LogManager.getLogger(CurrencyServiceImpl.class);

    /**
     * Поиск валюты по ID
     *
     * @param id - ID
     * @return валюта
     */
    @Override
    public Currency findById(Long id) throws ServiceException {
        CurrencyDao currencyDao = new CurrencyDaoImpl();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initSingleRequest(currencyDao);
        try {
            return currencyDao.findById(id);
        } catch (DAOException e) {
            logger.log(Level.ERROR, "Database exception during fiend currency by id", e);
            throw new ServiceException("Database exception during fiend currency by id", e);
        } finally {
            transaction.endSingleRequest();
        }
    }

    /**
     * Создание валюты
     *
     * @param currency - валюта
     * @return true при успешном создании
     */
    @Override
    public boolean create(Currency currency) throws ServiceException, ServiceConstraintViolationException {
        CurrencyDao currencyDao = new CurrencyDaoImpl();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initSingleRequest(currencyDao);
        try {
            return currencyDao.create(currency);
        } catch (RepositoryConstraintViolationException e) {
            logger.log(Level.ERROR, "Duplicate data currency ", e);
            throw new ServiceConstraintViolationException("Duplicate data currency ", e);
        } catch (DAOException e) {
            logger.log(Level.ERROR, "Database exception during create currency ", e);
            throw new ServiceException("Database exception during create currency ", e);
        } finally {
            transaction.endSingleRequest();
        }
    }

    /**
     * Изменение валюты
     *
     * @param currency - валюта
     * @return true при успешном изменении
     */
    @Override
    public boolean update(Currency currency) throws ServiceException, ServiceConstraintViolationException {
        CurrencyDao currencyDao = new CurrencyDaoImpl();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initSingleRequest(currencyDao);
        try {
            return currencyDao.update(currency);
        } catch (RepositoryConstraintViolationException e) {
            logger.log(Level.ERROR, "Duplicate data currency ", e);
            throw new ServiceConstraintViolationException("Duplicate data currency ", e);
        } catch (DAOException e) {
            logger.log(Level.ERROR, "Database exception during update currency ", e);
            throw new ServiceException("Database exception during update currency ", e);
        } finally {
            transaction.endSingleRequest();
        }
    }

    /**
     * Удаление валюты
     *
     * @param currency - валюта
     * @return true при успешном удаление
     */
    @Override
    public boolean delete(Currency currency) throws ServiceException {
        CurrencyDao currencyDao = new CurrencyDaoImpl();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initSingleRequest(currencyDao);
        try {
            return currencyDao.delete(currency);
        } catch (DAOException e) {
            logger.log(Level.ERROR, "Database exception during delete currency ", e);
            throw new ServiceException("Database exception during delete currency ", e);
        } finally {
            transaction.endSingleRequest();
        }
    }

    /**
     * Количество строк в таблите валют
     *
     * @return количество строк
     * @throws ServiceException ошибке во время выполнения логическтх блоков и действий.
     */
    @Override
    public Long countRows() throws ServiceException {
        CurrencyDao currencyDao = new CurrencyDaoImpl();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initSingleRequest(currencyDao);
        try {
            return currencyDao.countRows();
        } catch (DAOException e) {
            logger.log(Level.ERROR, "Database exception during fiend count currencys row", e);
            throw new ServiceException("Database exception during fiend count currencys row", e);
        } finally {
            transaction.endSingleRequest();
        }
    }

    /**
     * Получение списка валют на определенной странице
     *
     * @param page - номер страницы
     * @return список пользователей
     */
    @Override
    public List<Currency> onePartOfListOnPage(int page) throws ServiceException {
        List currencies = new ArrayList();
        CurrencyDao currencyDao = new CurrencyDaoImpl();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initSingleRequest(currencyDao);
        try {
            int recordsPerPage = AttributeConstant.RECORDS_PER_PAGE;
            int startRecord = (int) Math.ceil((page - 1) * recordsPerPage);
            currencies.addAll(currencyDao.findAll(recordsPerPage, startRecord));
            return currencies;
        } catch (DAOException e) {
            logger.log(Level.ERROR, "Database exception during fiend all currency", e);
            throw new ServiceException("Database exception during fiend all currency", e);
        } finally {
            transaction.endSingleRequest();
        }
    }

    /**
     * Получение списка валют
     *
     * @return список пользователей
     */
    @Override
    public List<Currency> findAll() throws ServiceException {
        CurrencyDao currencyDao = new CurrencyDaoImpl();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initSingleRequest(currencyDao);
        try {
            return currencyDao.findAll();
        } catch (DAOException e) {
            logger.log(Level.ERROR, "Database exception during fiend all currency", e);
            throw new ServiceException("Database exception during fiend all currency", e);
        } finally {
            transaction.endSingleRequest();
        }
    }
}