package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

public class LoginCommand implements Command {

    private ResourceBundle validCreditCards = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.login_en");


    @Override
    public void execute() throws InterruptOperationException {


        while (true) {
            ConsoleHelper.writeMessage(res.getString("before"));
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String card = ConsoleHelper.readString().trim();

            String pin = ConsoleHelper.readString();
            if ((card.length() != 12)||(pin.length() != 4)) {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"),card));
                continue;
            }

            if ((validCreditCards.containsKey(card)) && validCreditCards.getString(card).equals(pin)) {
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"),card));
                break;
            } else {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }



        }
    }
}
