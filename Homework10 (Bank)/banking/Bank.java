package banking;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank implements IBank{
    private final String name;
    private final String bic;
    private BigDecimal bankComission = new BigDecimal(0);
    private Map<Person, ArrayList<Account>> data = new HashMap<>();
    private AtomicInteger transferCount = new AtomicInteger(0);
    Lock locker = new ReentrantLock();


    public AtomicInteger getTransferCount() {
        return transferCount;
    }

    public Bank(String name, String bic) {
        this.name = name;
        this.bic=bic;
    }

    public void addClient(Person p) throws IllegalArgumentException{
        locker.lock();
        if(!data.containsKey(p)){
            data.put(p, new ArrayList<>());
        } else {
            throw new IllegalArgumentException("Клиент уже имеет счета в банке");
        }
        locker.unlock();
    }

    public Account createAccountForPerson(Person p, BigDecimal startAmount, AccountCurrency val){
        Account account = new Account(UUID. randomUUID().toString(), startAmount, val);
        addAccount(p, account);
        return account;
    }

    private synchronized void addAccount(Person p, Account account) throws IllegalArgumentException{
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

    public void transfer(final String from, final String to, BigDecimal sum) {
                locker.lock();
                Account accfrom = getAccFromId(from);
                Account accto = getAccFromId(to);
                if (checkPerson(accfrom, accto)) {
                    if (accfrom.getBalance().compareTo(sum) != -1) {
                        accfrom.withdraw(sum);
                        accto.deposit(sum);
                        transferCount.incrementAndGet();
                        //System.out.println("Transfer # "+getTransferCount());
                        //System.out.println("From: "+ from + "to: "+to+ "Сумма: " + sum + " "+accfrom.getAccountCurrency());
                    } else {
                        System.err.println("Transfer # "+(getTransferCount().getAndAdd(1))+"Недостаточно средств на счёте");
                    }
                } else {
                    if (accfrom.getBalance().compareTo(sum.add(chargeComission(sum))) != -1) {
                        accfrom.withdraw(sum.add(chargeComission(sum)));
                        accto.deposit(sum);
                        transferCount.incrementAndGet();
                        //System.out.println("Transfer # "+getTransferCount());
                        //System.out.println("From: "+ from + " to: " +to+ "Сумма: " +sum+ " " + accfrom.getAccountCurrency() + "\n with comision: "+chargeComission(sum));
                        bankComission=bankComission.add(chargeComission(sum));
                    }else{
                System.out.println("Недостаточно средств на счёте");
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

    public boolean checkCurency(Account from, Account to){
        boolean flag;
        if (from.getAccountCurrency()==to.getAccountCurrency()){
            flag=true;}
        else {
            flag=false;
        }
        return flag;
    }

    public boolean checkPerson(Account from, Account to) {
        boolean flag=false;
        Person pFrom=null;
        Person pTo = null;
        for (Map.Entry<Person, ArrayList<Account>> element : data.entrySet()) {
            if(element.getValue().contains(from)){
                pFrom = element.getKey();
            }
            if(element.getValue().contains(to)){
                pTo = element.getKey();
            }
        }
        if(pFrom.equals(pTo)){
            flag=true;
        }
        return flag;
    }

    public Account getAccFromId(String id){
        Account account=null;
        for(List<Account> list:data.values()){
            for(Account find:list){
                if(find.getId().equals(id)){
                    account = find;
                }
            }
        }
        return account;
    }


    public BigDecimal getBankComission() {
        return bankComission;
    }

    public BigDecimal chargeComission(BigDecimal sum){
        int minSizeComission = 5;
        BigDecimal comission = sum.multiply(BigDecimal.valueOf(0.01));
        if (BigDecimal.valueOf(minSizeComission).compareTo(comission)==1) {
            comission = new BigDecimal(5);
        }
        return comission;
    }

    public int clientsInBank(){
        int result = 0;
        for (List <Account> accounts:data.values()){
            for(Account account:accounts){
                result++;
            }

        }
        return result;
    }

    public BigDecimal getMoneyInBank(Bank bank){
        BigDecimal money = new BigDecimal(666);//ToDo Доделать подсчёт денег банка
//        for (Map.Entry<Person, ArrayList<Account>> element : data.entrySet()) {
//            if (element.getValue().contains(bank)) {
//                money = money.add()
//            }
//        }
        return money;
    }

    public static Queue<String> banks = new ConcurrentLinkedQueue<String>(){{
        add("Идея Банк");
        add("Банк БелВЭБ");
        add("Банк Решение");
        add("Банк Дабрабыт");
        add("Абсолютбанк");
        add("Альфа-Банк");
        add("БПС-Сбербанк");
        add("БСБ Банк (БелСвиссБанк)");
        add("БТА Банк");
        add("ВТБ Беларусь");
        add("БелГазпромБанк");
        add("БелАгроПромБанк");
        add("БеларусБанк");
        add("БелИнвестБанк");
        add("Белорусский Банк Малого Бизнеса");
        add("Белорусский Народный Банк");
        add("РРБ-Банк");
        add("ИнтерПэйБанк");
        add("Паритетбанк");
        add("Национальный Банк Республики Беларусь");
        add("ПриорБанк");
        add("МТБанк");
        add("Статусбанк (ЕвроТоргИнвестБанк)");
        add("ФрансаБанк");
        add("ТК Банк");
        add("Хоум Кредит Банк");
        add("ТехноБанк");
        add("ЕвроБанк");
        add("Дельта Банк");
        add("Цептер Банк");
    }};

    @Override
    public String toString() {
        return "БАНК: "+ name + ", БИК: " + bic + ", Кол-во счетов: " + data.size() + ", Кол-во клиентов: " + clientsInBank() + "\n";
    }
}
