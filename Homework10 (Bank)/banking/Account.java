package banking;

import java.math.BigDecimal;

public class Account {
    private final String id;
    private BigDecimal balance;
    private AccountCurrency accountCurrency;

    public Account(String id) {
        this.id = id;
    }

    public AccountCurrency getAccountCurrency() {
        return accountCurrency;
    }

    public Account(String id, BigDecimal balance, AccountCurrency accountCurrency) {
        this.id = id;
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
                "id='" + id + '\'' +
                ", balance=" + balance +
                ", accountCurrency=" + accountCurrency +
                '}';
    }
}


