import java.util.ArrayList;
import java.util.Random;

public class Loader {
    public static void main(String[] args) {
        Bank bank = new Bank();
        ArrayList<Thread> threads = new ArrayList<>();

            // создание аккаунтов и изначальной суммы в них
        for (int i = 0; i < 8; i++) {
            for (int j = 0;j < 1000; j++) {
                Account acc = new Account(new Random().nextInt(100000), String.valueOf(j));
                bank.addAccount(acc);
            }
        }

            // подсчет суммы до транзакций
        long sumBefore = 0;
        for (int i = 0; i < 1000; i++) {
            sumBefore+=bank.getBalance(String.valueOf(i));
        }
        System.out.println(sumBefore);

            // многопоточный запуск транзакций
            for (int i = 0; i < 8; i++) {
                threads.add(new Thread(() -> {
                    for (int j = 0; j < 500; j++) {
                        Account from = bank.getAccount(String.valueOf(new Random().nextInt(999)));
                        Account to = bank.getAccount(String.valueOf(new Random().nextInt(999)));
                        try {
                            //System.out.println("Acc " + from.getAccNumber() + " trying transfer money to " + to.getAccNumber());
                            bank.transfer(from.getAccNumber(), to.getAccNumber(), new Random().nextInt(65000));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //System.out.println(Thread.activeCount()); 499999162, 499999162,
                        //                                          502753072, 502753072
                        //                                          485920033, 485580539
                    }
                }));
                threads.get(i).start();
            }


            //ждем пока все потоки завершаться
        for (Thread thread: threads) {
            try {
                if (thread != null) {
                    thread.join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

            //снова считаем сумму всех денег в банке
        long sumAfter = 0;
        for (int i = 0; i < 1000; i++) {
            sumAfter += bank.getBalance(String.valueOf(i));
        }
        System.out.println(sumAfter);
    }
}
