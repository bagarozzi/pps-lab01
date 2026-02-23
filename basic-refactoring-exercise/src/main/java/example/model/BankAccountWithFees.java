package example.model;

/**
 * A bank account that puts a one (1) dollar fee on every withdraw.
 */
public class BankAccountWithFees extends AbstractBank {

    public static final int WITHDRAW_FEE = 1;

    public BankAccountWithFees(AccountHolder holder, double balance) {
        super(holder, balance, WITHDRAW_FEE);
    }
}
