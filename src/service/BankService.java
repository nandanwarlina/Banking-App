package service;

import model.Account;
import exception.*;
import java.util.*;

public class BankService {
    private final Map<Integer, Account> accounts = new HashMap<>();

    public BankService() {
        // Preload some accounts
        accounts.put(1001, new Account(1001, "Alice", 1000));
        accounts.put(1002, new Account(1002, "Bob", 1500));
    }

    public void deposit(int accountId, double amount) throws InvalidAccountException {
        Account acc = accounts.get(accountId);
        if (acc == null) throw new InvalidAccountException("Account not found.");
        acc.deposit(amount);
    }

    public void withdraw(int accountId, double amount) throws Exception {
        Account acc = accounts.get(accountId);
        if (acc == null) throw new InvalidAccountException("Account not found.");
        acc.withdraw(amount);
    }

    public Account getAccount(int accountId) {
        return accounts.get(accountId);
    }
}

