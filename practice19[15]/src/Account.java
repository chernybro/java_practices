import java.util.concurrent.atomic.AtomicInteger;

public class Account
{
    private volatile long money;
    private String accNumber;
    private volatile boolean blocked;
    private volatile boolean currentlyInUse;

    public Account(long money, String accNumber) {
        this.money = money;
        this.accNumber = accNumber;
        this.blocked = false;
    }

    public void setCurrentlyInUse(boolean currentlyInUse) {
        this.currentlyInUse = currentlyInUse;
    }

    public boolean getCurrentlyInUse() {
        return currentlyInUse;
    }

    public synchronized long  getMoney() { return money; }

    public synchronized void transMoney(long amount, Account other) {
        if (other.isBlocked() || this.blocked) {

        } else {
            money = money + amount;
        }
    }

    public synchronized void block() { this.blocked = true; }

    public boolean isBlocked() {
        return blocked;
    }

    public String getAccNumber() {
        return accNumber;
    }
}
