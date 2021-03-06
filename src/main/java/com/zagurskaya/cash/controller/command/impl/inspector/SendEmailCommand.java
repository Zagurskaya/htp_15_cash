package com.zagurskaya.cash.controller.command.impl.inspector;

import com.zagurskaya.cash.controller.command.ActionType;
import com.zagurskaya.cash.controller.command.AttributeName;
import com.zagurskaya.cash.controller.command.Command;
import com.zagurskaya.cash.util.ControllerDataUtil;
import com.zagurskaya.cash.util.DataValidation;
import com.zagurskaya.cash.email.MailThread;
import com.zagurskaya.cash.util.RegexPattern;
import com.zagurskaya.cash.exception.CommandException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

/**
 * The action is "Send e-mail".
 */
public class SendEmailCommand implements Command {
    private String directoryPath;
    private static final Logger logger = LogManager.getLogger(SendEmailCommand.class);
    private static final String MAIL = "mail";
    private static final String TO = "to";
    private static final String SUBJECT = "subject";
    private static final String BODY = "body";

    /**
     * Constructor
     *
     * @param directoryPath - path
     */
    public SendEmailCommand(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    @Override
    public String getDirectoryPath() {
        return directoryPath;
    }

    @Override
    public ActionType execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        ControllerDataUtil.removeAttributeError(request);
        ControllerDataUtil.removeAttributeMessage(request);
        try {
            if (DataValidation.isCreateUpdateDeleteOperation(request)) {
                Properties properties = new Properties();
                ServletContext context = request.getServletContext();
                String filename = context.getInitParameter(MAIL);
                properties.load(context.getResourceAsStream(filename));
                ControllerDataUtil.getString(request, TO, RegexPattern.EMAIL_VALIDATION_REGEX);
                ControllerDataUtil.getString(request, SUBJECT, RegexPattern.ALPHABET_NUMBER_UNDERSCORE_MINUS_BLANK_VALIDATE_PATTERN);
                ControllerDataUtil.getString(request, BODY, RegexPattern.ALPHABET_NUMBER_UNDERSCORE_MINUS_BLANK_VALIDATE_PATTERN);

                MailThread mailOperator =
                        new MailThread(request.getParameter(TO), request.getParameter(SUBJECT),
                                request.getParameter(BODY), properties);
                mailOperator.start();
                request.setAttribute(AttributeName.MESSAGE, "The e-mail was sent successfully");
            }
            return ActionType.SEND_EMAIL;

        } catch (IOException e) {
            request.getSession(false).setAttribute(AttributeName.ERROR, "100 " + e);
            logger.log(Level.ERROR, e);
            return ActionType.ERROR;
        }
    }
}
