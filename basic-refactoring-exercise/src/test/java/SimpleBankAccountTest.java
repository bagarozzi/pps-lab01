import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    private static final String HOLDER_NAME = "Mario";
    private static final String HOLDER_SURNAME = "Rossi";
    private static final int HOLDER_ID = 1;
    private static final int INITIAL_BALANCE = 0;

    private static final int WRONG_HOLDER_ID = 2;

    private static final int DEPOSIT_QUANTITY = 100;
    private static final int WITHDRAW_QUANTITY = 70;
    private static final int BALANCE_DIFFERENCE = 30;

    private static final int WITHDRAWAL_FEE = 1;


    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder(HOLDER_NAME, HOLDER_SURNAME, HOLDER_ID);
        bankAccount = new SimpleBankAccount(accountHolder, INITIAL_BALANCE);
    }

    @Test
    void testInitialBalance() {
        assertEquals(INITIAL_BALANCE, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.id(), DEPOSIT_QUANTITY);
        assertEquals(DEPOSIT_QUANTITY, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.id(), DEPOSIT_QUANTITY);
        bankAccount.deposit(WRONG_HOLDER_ID, WITHDRAW_QUANTITY);
        assertEquals(DEPOSIT_QUANTITY, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        depositAndWithdraw(accountHolder.id(), DEPOSIT_QUANTITY, WITHDRAW_QUANTITY);
        assertEquals(BALANCE_DIFFERENCE - WITHDRAWAL_FEE, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        depositAndWithdraw(WRONG_HOLDER_ID, DEPOSIT_QUANTITY, WITHDRAW_QUANTITY);
        assertEquals(DEPOSIT_QUANTITY, bankAccount.getBalance());
    }

    @Test
    void testWithdrawNotAllowed(){
        depositAndWithdraw(accountHolder.id(), DEPOSIT_QUANTITY, DEPOSIT_QUANTITY);
        assertEquals(DEPOSIT_QUANTITY, bankAccount.getBalance());
    }

    /**
     * Deposits depositQuantity into the test account, then withdraws withdrawQuantity
     * from the account indicated in accountId
     * @param accountId the account to withdraw from
     * @param depositQuantity the quantity to deposit
     * @param withdrawQuantity the quantity to withdraw
     */
    void depositAndWithdraw(final int accountId, final int depositQuantity, final int withdrawQuantity) {
        bankAccount.deposit(accountHolder.id(), depositQuantity);
        bankAccount.withdraw(accountId, withdrawQuantity);
    }
}
