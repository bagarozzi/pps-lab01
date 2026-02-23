package example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccount extends AbstractBank {

    public static final int NULL_WITHDRAW_FEE = 0;

    public SimpleBankAccount(final AccountHolder holder, final double balance) {
        super(holder, balance, NULL_WITHDRAW_FEE);
    }

}
