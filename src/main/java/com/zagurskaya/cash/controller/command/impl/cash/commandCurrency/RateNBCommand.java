package com.zagurskaya.cash.controller.command.impl.cash.commandCurrency;

import com.zagurskaya.cash.constant.AttributeConstant;
import com.zagurskaya.cash.controller.command.AbstractСommand;
import com.zagurskaya.cash.controller.command.Action;
import com.zagurskaya.cash.entity.Currency;
import com.zagurskaya.cash.entity.RateNB;
import com.zagurskaya.cash.exception.ServiceException;
import com.zagurskaya.cash.model.service.CurrencyService;
import com.zagurskaya.cash.model.service.RateNBService;
import com.zagurskaya.cash.model.service.impl.CurrencyServiceImpl;
import com.zagurskaya.cash.model.service.impl.RateNBServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Действие "Курсы НБ".
 */
public class RateNBCommand extends AbstractСommand {
    private static final Logger logger = LogManager.getLogger(RateNBCommand.class);
    private final RateNBService rateNBService = new RateNBServiceImpl();
    private final CurrencyService currencyService = new CurrencyServiceImpl();

    /**
     * Конструктор
     *
     * @param path - путь
     */
    public RateNBCommand(String path) {
        super(path);
    }

    @Override
    public Action execute(HttpServletRequest request) {

        final HttpSession session = request.getSession(false);
        session.removeAttribute("error");

        try {
            Action action = actionAfterValidationUserAndPermission(request, Action.RATENB);
            if (action == Action.RATENB) {

                int page = 1;
                if (request.getParameter(AttributeConstant.PAGE) != null)
                    page = Integer.parseInt(request.getParameter(AttributeConstant.PAGE));

                int numberOfPages = (int) Math.ceil(rateNBService.countRows() * 1.0 / AttributeConstant.RECORDS_PER_PAGE);
                List<RateNB> ratesNB = rateNBService.onePartOfListOnPage(page);

                List<Currency> currencyList = currencyService.findAll();

                request.setAttribute(AttributeConstant.NUMBER_OF_PAGE, numberOfPages);
                request.setAttribute(AttributeConstant.CURRENT_PAGE, page);
                request.setAttribute(AttributeConstant.RATE_NB, ratesNB);
                request.setAttribute(AttributeConstant.CURRENCIES, currencyList);

                return Action.RATENB;
            } else {
                return action;
            }
        } catch (ServiceException e) {
            session.setAttribute(AttributeConstant.ERROR, e);
            logger.log(Level.ERROR, e);
            return Action.ERROR;
        }
    }
}