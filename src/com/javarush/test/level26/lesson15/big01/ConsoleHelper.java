package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {

    private static ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.common_en");

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String s = "";
        try {
            s = reader.readLine();
            if (s.toUpperCase().equals("EXIT"))
                throw new InterruptOperationException();

        } catch (IOException e) {

        }
        return s;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage(res.getString("choose.currency.code"));
        String s = readString();
        while (s.length() != 3) {
            writeMessage(res.getString("invalid.data"));
            s = readString();
        }

        s = s.toUpperCase();
        return s;
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"),"USD"));
        while (true){
            String[] temp = ConsoleHelper.readString().trim().split(" ");
            try{
                if (temp.length == 2 && Integer.parseInt(temp[0]) > 0 && Integer.parseInt(temp[1]) > 0) {
                    return temp;
                }
            }
            catch (Exception e){
            }
            writeMessage(res.getString("invalid.data"));
        }

    }

    public static Operation askOperation() throws InterruptOperationException {


        Operation operation = null;
        while(operation == null)
        {
            writeMessage(res.getString("choose.operation"));
            try
            {
                operation = Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
            }
            catch (IllegalArgumentException e)
            {
                operation = null;

            }
        }
        return operation;
    }
}
