package banking;

import java.math.BigDecimal;

public class Account {
    private final String id;
    private String bankAccount;
    private BigDecimal balance;
    private AccountCurrency accountCurrency;

    public Account(String id) {
        this.id = id;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public AccountCurrency getAccountCurrency() {
        return accountCurrency;
    }

    public Account(String id, String bankAccount, BigDecimal balance, AccountCurrency accountCurrency) {
        this.id = id;
        this.bankAccount=bankAccount;
        this.balance = balance;
        this.accountCurrency=accountCurrency;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void deposit(BigDecimal sum){
        this.balance = balance.add(sum);
    }

    public void withdraw(BigDecimal sum){
        this.balance = balance.subtract(sum);
    }

    @Override
    public String toString() {
        return "Account{" +
                "bankAccount='" + bankAccount + '\'' +
                ", balance=" + balance +
                ", accountCurrency=" + accountCurrency +
                '}';
    }
}


