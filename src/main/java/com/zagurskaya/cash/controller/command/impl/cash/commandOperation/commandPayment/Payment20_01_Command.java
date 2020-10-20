package com.zagurskaya.cash.controller.command.impl.cash.commandOperation.commandPayment;

import com.zagurskaya.cash.controller.command.AbstractСommand;
import com.zagurskaya.cash.controller.command.ActionType;

import javax.servlet.http.HttpServletRequest;

public class Payment20_01_Command extends AbstractСommand {
    /**
     * Конструктор
     *
     * @param directoryPath - путь
     */
    public Payment20_01_Command(String directoryPath) {
        super(directoryPath);
    }

    @Override
    public ActionType execute(HttpServletRequest req) {
//        LocalDate date = LocalDate.now();
//        Timestamp now = new Timestamp(System.currentTimeMillis());
//
//        CurrencyDao currencyDao = new CurrencyDao();
//        List<Currency> currencies = currencyDao.getAll();
//        req.setAttribute("currencies", currencies);
//
//        if (Form.isPost(req)) {
//
//            long currencyId = Form.getLong(req, "id");
//            long currencySum = Form.getLong(req, "sum");
//            String specification = Form.getString(req, "specification");
//
//            RateCBDao rateСBDao = new RateCBDao();
//            double rateCBPayment = rateСBDao.rateCBToday(now, 933, currencyId);
//            double sumRateCurrencyId = rateCBPayment * currencySum;
//            HttpSession session = req.getSession(false);
//            session.setAttribute("currencyId", currencyId);
//            session.setAttribute("currencySum", currencySum);
//            session.setAttribute("rateCBPayment", rateCBPayment);
//            session.setAttribute("sumRateCurrencyId", sumRateCurrencyId);
//            session.setAttribute("specification", specification);
//
//            Action.PAYMENT20_02.setPATH("/cash/operation/payment/");
//            return Action.PAYMENT20_02;
//        }
//        Action.PAYMENT20_01.setPATH("/cash/operation/payment/");
        return ActionType.PAYMENT20_01;
    }
}