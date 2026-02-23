package example.model;

/**
 * An AbstractBank that puts a fee chose by the user on every withdraw.
 */
public class AbstractBank implements BankAccount {
    protected double balance;
    private final AccountHolder holder;
    private final int withdrawFee;

    public AbstractBank(final AccountHolder holder, final double balance, final int withdrawFee) {
        this.holder = holder;
        this.balance = balance;
        this.withdrawFee = withdrawFee;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(final int userID, final double amount) {
        if (checkUser(userID)) {
            this.balance += amount;
        }
    }

    public void withdraw(final int userID, final double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance -= amount + withdrawFee;
        }
    }
    protected boolean checkUser(final int id) {
        return this.holder.id() == id;
    }

    protected boolean isWithdrawAllowed(final double amount){
        return this.balance >= amount + withdrawFee;
    }
}
