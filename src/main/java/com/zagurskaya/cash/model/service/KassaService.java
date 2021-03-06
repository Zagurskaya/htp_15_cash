package com.zagurskaya.cash.model.service;

import com.zagurskaya.cash.entity.Duties;
import com.zagurskaya.cash.entity.Kassa;
import com.zagurskaya.cash.entity.User;
import com.zagurskaya.cash.exception.NegativeBalanceException;
import com.zagurskaya.cash.exception.ServiceException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface KassaService extends Service<Kassa> {
    /**
     * Update Kassa for outer Operations
     *
     * @param date           - date
     * @param dutiesId       - number duties
     * @param currencyId     - currency code
     * @param sum            - sum
     * @param sprOperationId - operation code
     * @return true on successful operation
     * @throws ServiceException error during execution of logical blocks and actions
     */
    boolean updateKassaOuterOperation(LocalDate date, Long dutiesId, Long currencyId, BigDecimal sum, Long sprOperationId) throws ServiceException;
    /**
     * Update Kassa for inner Operations
     *
     * @param date           - date
     * @param dutiesId       - number duties
     * @param currencyId     - currency code
     * @param sum            - sum
     * @param sprOperationId - operation code
     * @return true on successful operation
     * @throws ServiceException error during execution of logical blocks and actions
     */
    boolean updateKassaInnerOperation(LocalDate date, Long dutiesId, Long currencyId, BigDecimal sum, Long sprOperationId) throws ServiceException, NegativeBalanceException;

    /**
     * Return balance by user and duties
     *
     * @param user   - user
     * @param duties - user duties
     * @return kassa list
     * @throws ServiceException error during execution of logical blocks and actions
     */
    List<Kassa> getBalance(User user, Duties duties) throws ServiceException;

    /**
     * Return balance by user and duties
     *
     * @param user   - user
     * @param duties - user duties
     * @return true if balance for each currency == 0
     * @throws ServiceException error during execution of logical blocks and actions
     */
    boolean isBalanceValid(User user, Duties duties) throws ServiceException;

}
