import example.model.AccountHolder;
import example.model.BankAccountWithFees;
import example.model.SimpleBankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountWithFeesTest extends SimpleBankAccountTest {

    @BeforeEach
    void beforeEach() {
        accountHolder = new AccountHolder(HOLDER_NAME, HOLDER_SURNAME, HOLDER_ID);
        bankAccount = new BankAccountWithFees(accountHolder, INITIAL_BALANCE);
    }

    @Test
    void testWithdraw() {
        depositAndWithdraw(accountHolder.id(), DEPOSIT_QUANTITY, WITHDRAW_QUANTITY);
        assertEquals(BALANCE_DIFFERENCE - BankAccountWithFees.WITHDRAW_FEE, bankAccount.getBalance());
    }

    @Test
    void testWithdrawNotAllowed(){
        depositAndWithdraw(accountHolder.id(), DEPOSIT_QUANTITY, DEPOSIT_QUANTITY);
        assertEquals(DEPOSIT_QUANTITY, bankAccount.getBalance());
    }
}
