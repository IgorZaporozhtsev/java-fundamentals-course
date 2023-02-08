package com.bobocode.fp;

import com.bobocode.data.Accounts;
import com.bobocode.fp.function.AccountProvider;
import com.bobocode.model.Account;

import java.math.BigDecimal;
import java.util.Optional;

public class MainOptional {
    public static void main(String[] args) {
        Optional<String> optionalWithNull = CrazyOptionals.optionalOfString(null);
        Optional<String> optionalWithoutNull = CrazyOptionals.optionalOfString("some text");
        System.out.println(optionalWithNull+"\n"+optionalWithoutNull);

        Account account = Accounts.generateAccount();

        CrazyOptionals.deposit(() -> Optional.of(account), null);
        CrazyOptionals.deposit(() -> Optional.of(account), BigDecimal.valueOf(10));
    }
}
