package tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private static final int TEST_PIN = 1234;
    private static final int INITIAL_FAILED_ATTEMPTS = 0;
    private static final int MAX_FAILED_ATTEMPTS = 3;

    private SmartDoorLock smartLock;

    @BeforeEach
    void beforeEach() {
        smartLock = new SmartDoorLockImpl(MAX_FAILED_ATTEMPTS);
    }

    @Test
    void testFailedAttempts() {
        assertEquals(smartLock.getFailedAttempts(), INITIAL_FAILED_ATTEMPTS);
    }

    @Test
    void testMaxAttempts() {
        assertEquals(MAX_FAILED_ATTEMPTS, smartLock.getMaxAttempts());
    }

}
