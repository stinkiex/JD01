package com.company;

/*
    Рассмотрим один из ярких примеров где нужна синхронизация.
    Предыстория: Компания занимается облачным хостингом. Облачных хостинг работает по принципу: есть аккаунт пользователя
    у которого есть денежный счёт (баланс). При использовании хостинга (использование приложения) счёт уменьшается. Чем больше нагрузка
    на хостинг тем больше списывается со счёта пользователя. Когда у пользователя становится нулевой баланс хостинг останавливается
    и просит пополнить счёт.
 */
public class Test6 {

    public static void main(String[] args) {
        //Есть аккаунт с деньгами
//        HostingAccount account = new HostingAccountSafe1(99_999.10);
//        HostingAccount account = new HostingAccountSafe2(99_999.10);
        HostingAccount account = new HostingAccountUnSafe(99_999.10); //Можем получить отрицательный балланс (запускать много раз)

        //Есть три приложения которые будут размещены на хостинге
        account.addApp("app1",new AppForHosting());
        account.addApp("app2",new AppForHosting());
        account.addApp("app3",new AppForHosting());

        Thread t1 = new Thread(new UseApp("app1", account));
        Thread t2 = new Thread(new UseApp("app2", account));
        Thread t3 = new Thread(new UseApp("app3", account));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account.getBalance());
    }

    private static class UseApp implements Runnable{

        private final String appName;
        private final HostingAccount account;

        public UseApp(String appName, HostingAccount account) {
            this.appName = appName;
            this.account = account;
        }

        @Override
        public void run() {
            try {
                while (1==1){
                    account.use(appName);
                }
            } catch (IllegalStateException i){
                System.err.println(i.getMessage());
                throw i;
            }
        }
    }

}
