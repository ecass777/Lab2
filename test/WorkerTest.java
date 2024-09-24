import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WorkerTest {
    @Test
    public void testCalculateWeeklyPay_NoOvertime() {
        Worker worker = new Worker("Elijah", "Cassidy", "W001", "Mr.", 2005, 20.0);
        assertEquals(800.0, worker.calculateWeeklyPay(40), 0.01);
    }

    @Test
    public void testCalculateWeeklyPay_WithOvertime() {
        Worker worker = new Worker("Elijah", "Cassidy", "W001", "Mr.", 2005, 20.0);
        assertEquals(1100.0, worker.calculateWeeklyPay(50), 0.01);
    }
}
