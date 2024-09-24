import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SalaryWorkerTest {
    @Test
    public void testCalculateWeeklyPay() {
        SalaryWorker worker = new SalaryWorker("Elijah", "Cassidy", "S001", "Dr.", 2005, 0, 75000.0);
        assertEquals(1442.31, worker.calculateWeeklyPay(40), 0.01);
    }
}
