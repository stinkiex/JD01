import banking.Account;
import banking.Bank;
import banking.Person;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static banking.AccountCurrency.BYN;

public class BankingApp {

    public static void main(String[] args) {
        Bank bank = new Bank("BankOfAmerica", "BOFAUS3N");
        Bank bank2 = new Bank ("Банк ВТБ (Беларусь)", "SLANBY22");

        Person person1 = new Person("MP255_____1", "Илья");
        Person person2 = new Person("MP255_____2", "Игорь");
        Person person3 = new Person("MP255_____3", "Света");
        Person person4 = new Person("MP2554____4", person1.nameGenerate());

        List<Account> accounts = person1.getAccounts();

        accounts.add(bank.createAccountForPerson(person1, new BigDecimal(100000), BYN));
        accounts.add(bank.createAccountForPerson(person1, new BigDecimal(100000), BYN));
        accounts.add(bank2.createAccountForPerson(person2, new BigDecimal("100000"), BYN));
        accounts.add(bank2.createAccountForPerson(person3, new BigDecimal("100000"), BYN));

        Account account1 = accounts.get(0);
        Account account2 = accounts.get(1);
        Account account3 = accounts.get(2);
        Account account4 = accounts.get(3);

        ExecutorService executor = Executors.newFixedThreadPool(3); //ToDo Запилить Executor
        Lock locker = new ReentrantLock();

        Thread t1 = new Thread(new TransferTread(account1, account2, bank));
        Thread t2 = new Thread(new TransferTread(account1, account2, bank));
        Thread t3 = new Thread(new TransferTread(account1, account2, bank));
        Thread t4 = new Thread(new TransferTread(account1, account2, bank));
        Thread t5 = new Thread(new TransferTread(account1, account2, bank));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

//        executor.execute(new TransferTread(account1, account2, bank));
//        executor.execute(new TransferTread(account1, account2, bank));
//        executor.execute(new TransferTread(account1, account2, bank));
//        executor.execute(new TransferTread(account1, account2, bank));

        while (true){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            //BigDecimal avg = (account1.getBalance().add(account2.getBalance()).divide(new BigDecimal("2")));
            System.out.println("Transfer No.: "+bank.getTransferCount());
            System.out.println("Acc1 " + account1.getBalance());
            System.out.println("Acc2 " + account2.getBalance());
            System.out.println("Money in Bank: \""+ bank.getName() +"\" :"+ bank.getMoneyInBank(bank));
            //System.out.println("AVG " + avg);
            System.err.println(bank+""+bank2);
        }
    }

    private static class TransferTread implements Runnable{
        private final Account account1;
        private final Account account2;
        private final Bank bank;
        private Random rnd = new Random();

        private TransferTread(Account account1, Account account2, Bank bank) {
            this.account1 = account1;
            this.account2 = account2;
            this.bank = bank;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()){
                Account acc1 = rnd.nextBoolean() ? account1 : account2;
                Account acc2 = acc1.equals(account1) ? account2 : account1;

                bank.transfer(acc1.getId(), acc2.getId(), BigDecimal.valueOf(rnd.nextDouble()).round(new MathContext(2)));
            }
        }
    }
}
