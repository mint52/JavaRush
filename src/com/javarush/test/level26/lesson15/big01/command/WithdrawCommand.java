package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.ResourceBundle;

class WithdrawCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.withdraw_en");

    @Override
    public void execute() throws InterruptOperationException {

        String code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);

        while (true) {
            ConsoleHelper.writeMessage(res.getString("before"));
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            try {
                int summ = Integer.parseInt(ConsoleHelper.readString());
                if (summ <= 0)
                    ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                else {
                    if (manipulator.isAmountAvailable(summ)) {
                        Map<Integer, Integer> map = manipulator.withdrawAmount(summ);
                        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                            ConsoleHelper.writeMessage(String.format(res.getString("success.format"),pair.getKey()*pair.getValue(),code));
                        }

                        break;
                    } else ConsoleHelper.writeMessage(res.getString("not.enough.money"));

                }
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            } catch (ConcurrentModificationException ignore) {

            }
        }


    }
}
