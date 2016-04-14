package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.ResourceBundle;

class InfoCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.info_en");

    @Override
    public void execute() {

        ConsoleHelper.writeMessage(res.getString("before"));
        if(CurrencyManipulatorFactory.getAllCurrencyManipulators().size()==0){
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }else
        {
            boolean isMoney = false;

            for (CurrencyManipulator hand: CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
                if (hand.hasMoney()){
                    ConsoleHelper.writeMessage(hand.getCurrencyCode() + " - " + hand.getTotalAmount());
                    isMoney = true;
                }
            }

            if (!isMoney)
                ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }
}
