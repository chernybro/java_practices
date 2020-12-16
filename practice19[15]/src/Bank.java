import java.util.HashMap;
import java.util.Random;

public class Bank {
    private HashMap<String, Account> accounts = new HashMap<>();
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException
    {
        Thread.sleep(1);
        return random.nextBoolean();
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccNumber(), account);
    }

    public Account getAccount(String accountNum) {
        return accounts.get(accountNum);
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами.
     * Если сумма транзакции > 50000, то после совершения транзакции,
     * она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка
     * счетов (как – на ваше усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {

        Account from = accounts.get(fromAccountNum);
        Account to = accounts.get(toAccountNum);
        if (from != to) {
            //from.setCurrentlyInUse(true);
            //to.setCurrentlyInUse(true);
            if (amount > 50000) {
                try {
                    boolean blocked = isFraud(fromAccountNum, toAccountNum, amount);
                    if (blocked) {
                        from.block();
                        to.block();
                    } else {
                        if (from.getMoney() - amount >= 0) {
                            from.transMoney(-amount, to);
                            to.transMoney(amount, from);
                        }
                        //from.setCurrentlyInUse(false);
                        //to.setCurrentlyInUse(false);

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                if (from.getMoney() - amount >= 0) {
                    from.transMoney(-amount, to);
                    to.transMoney(amount, from);
                }
            }
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum)
    {
        Account account = accounts.get(accountNum);
        return account.getMoney();
    }

}
