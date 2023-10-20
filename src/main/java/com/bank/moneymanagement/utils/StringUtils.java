package com.bank.moneymanagement.utils;

import org.springframework.stereotype.Component;

@Component
public class StringUtils {


    public String reformatAmount(Long amount) {
        String money = String.valueOf(amount);
        StringBuilder result = new StringBuilder();
        int length = money.length();
        int count = 0;

        for (int i = length - 1; i >= 0; i--) {
            result.insert(0, money.charAt(i));
            count++;

            if (count % 3 == 0 && i > 0) {
                result.insert(0, ",");
            }
        }
        return String.valueOf(result) + "R";
    }

}

