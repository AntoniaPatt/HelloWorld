import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    static Calculator calculator;
    private static HashMap<Double, Integer> physicalChange;


    @BeforeAll
    static void setUp() {
        physicalChange = new HashMap<>();
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        physicalChange.clear();
    }

    @Test
    public void testChangeGiven() {
        double change = 10.0;
        createPhysicalChangeHashMap(10.0, 1);

        assertEquals(physicalChange, calculator.getChange(change));
    }

    @Test
    public void testThatOptimalChangeIsGivenWithCashOnly() {
        double change = 225.0;
        createPhysicalChangeHashMap(100.0, 2);
        createPhysicalChangeHashMap(20.0, 1);
        createPhysicalChangeHashMap(5.0, 1);

        assertEquals(physicalChange, calculator.getChange(change));
    }

    @Test
    public void testThatOptimalChangeIsGivenWithCoinsOnly() {
        double change = 0.02;
        createPhysicalChangeHashMap(0.02, 1);

        assertEquals(physicalChange, calculator.getChange(change));
    }


    @Test
    public void testThatOptimalChangeIsGivenWithCashAndCoins() {
        double change = 1.15;
        createPhysicalChangeHashMap(1.00, 1);
        createPhysicalChangeHashMap(0.10, 1);
        createPhysicalChangeHashMap(0.05, 1);

        assertEquals(physicalChange, calculator.getChange(change));
    }

    public void createPhysicalChangeHashMap(double cash, int quantity) {
        physicalChange.put(cash, quantity);
    }

}