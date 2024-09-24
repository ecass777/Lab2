import java.util.ArrayList;

public class InheritanceDemo {
    public static void main(String[] args) {
        // Create workers and salary workers
        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(new Worker("Elijah", "Cassidy", "W001", "Mr.", 2005, 20.0));  // Worker with hourly rate
        workers.add(new Worker("Austin", "Fraley", "W002", "Mr.", 2004, 25.0));
        workers.add(new Worker("Michael", "Scali", "W003", "Mr.", 2004, 22.0));

        workers.add(new SalaryWorker("Grayson", "Page", "S001", "Dr.", 2004, 0, 75000.0));  // Salary worker
        workers.add(new SalaryWorker("Danny", "Day", "S002", "Mr.", 2005, 0, 90000.0));
        workers.add(new SalaryWorker("Marie", "Burkhart", "S003", "Ms.", 2004, 0, 65000.0));

        double[] hoursWorked = {40, 50, 40};

        for (int week = 1; week <= 3; week++) {
            System.out.println("\nWeek " + week + " Pay Report:");
            for (Worker worker : workers) {
                worker.displayWeeklyPay(hoursWorked[week - 1]);
            }
        }
    }
}
