package model;

public class Account {
    private final int accountId;
    private final String holder;
    private double balance;

    public Account(int accountId, String holder, double initialBalance) {
        this.accountId = accountId;
        this.holder = holder;
        this.balance = initialBalance;
    }

    public int getAccountId() { return accountId; }
    public String getHolder() { return holder; }
    public double getBalance() { return balance; }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(holder + " deposited " + amount);
    }

    public synchronized void withdraw(double amount) throws Exception {
        if (amount > balance) {
            throw new Exception("Insufficient balance in account " + accountId);
        }
        balance -= amount;
        System.out.println(holder + " withdrew " + amount);
    }

    @Override
    public String toString() {
        return "Account ID: " + accountId + ", Holder: " + holder + ", Balance: " + balance;
    }
}