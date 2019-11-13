package banking;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank implements IBank{
    private final String name;
    private final String bic;
    private BigDecimal bankComission;
    private Map<Person, ArrayList<Account>> data = new HashMap<>();
    private AtomicInteger transferCount = new AtomicInteger(0);
    Lock locker = new ReentrantLock();

    public BigDecimal getBankComission() {
        return bankComission;
    }

    public AtomicInteger getTransferCount() {
        return transferCount;
    }

    public Bank(String name, String bic, BigDecimal bankComission) {
        this.name = name;
        this.bic=bic;
        this.bankComission=bankComission;
    }

    public void addClient(Person p) throws IllegalArgumentException{
        if(!data.containsKey(p)){
            data.put(p, new ArrayList<>());
        } else {
            throw new IllegalArgumentException("Клиент уже имеет счета в банке");
        }
    }

    public Account createAccountForPerson(Person p, Account id, BigDecimal startAmount, AccountCurrency val){
        Account account = new Account(UUID.randomUUID().toString(), startAmount, val);
        addAccount(p, account);
        return account;
    }

    private void addAccount(Person p, Account account) throws IllegalArgumentException{
        try {
            this.addClient(p);
        } catch (IllegalArgumentException ignored){
            //У пользователя уже есть учетка
        }
        for (List<Account> s:data.values()){
            for (Account ss:s){
                if(ss.getId().equals(account.getId())){
                    System.out.println("Счёт "+ss.getId()+" уже существует");
                }//Completed проверить что счета с таким номером в банке больше уже нет
            }
        }
        List<Account> accounts = this.data.get(p);
        accounts.add(account);
    }

    public void delClient(Person p) throws IllegalStateException{
        if(!data.containsKey(p)){
            throw new IllegalArgumentException(String.format("Данный человек не имеет счетов в банке %s", this.name));
        } else {
            for (int i=0;i<p.getAccounts().size();i++) {
                if (p.getAccounts().get(i).getBalance().compareTo(BigDecimal.valueOf(0)) == 0) {
                    System.out.println("Средств на счёте нет. Счёт клиента "+this.name+" закрыт");
                    data.remove(p);
                } else System.out.println("Клиент "+this.name+"  имеет средства на счете");
            }
        }
    }

    public BigDecimal chargeComission(BigDecimal sum){
        int minSizeComission = 5;
        BigDecimal comission = sum.multiply(BigDecimal.valueOf(0.01));
        if (BigDecimal.valueOf(minSizeComission).compareTo(comission)==1) {
            comission = new BigDecimal(5);
        }
        return comission;
    }

    public void transfer(final Account from, final Account to, BigDecimal sum){
        locker.lock();//ToDo Починить Трансфер
        if (from.equals(to)) {
            if (from.getBalance().compareTo(sum)!=-1) {
                from.withdraw(sum);
                to.deposit(sum);
                transferCount.incrementAndGet();
            } else {
                System.err.println("Недостаточно средств на счёте");
            }
        } else {
            if (from.getBalance().compareTo(sum.add(chargeComission(sum))) != -1) {
                from.withdraw(sum.add(chargeComission(sum)));
                to.deposit(sum);
                bankComission = bankComission.add(chargeComission(sum));
                transferCount.incrementAndGet();

//            } else {
//                System.out.println("Недостаточно средств на счёте"); //ToDo Раскоментировать после ремонта Трансфера
            }
        }
        locker.unlock();
    }

    public String getBic() {
        return bic;
    }

    public Map<Person, ArrayList<Account>> getData() {
        return data;
    }

    public String getName() {
        return name;

    }

    @Override
    public String toString() {
        return "БАНК :" + name + '\'' +
                ", БИК:'" + bic + '\'' +
                ", data=" + data.size() +
                '}'+"\n";
    }
}
