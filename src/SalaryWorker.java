public class SalaryWorker extends Worker {
    private double annualSalary;

    public SalaryWorker(String firstName, String lastName, String ID, String title, int YOB, double hourlyPayRate, double annualSalary) {
        super(firstName, lastName, ID, title, YOB, hourlyPayRate);
        this.annualSalary = annualSalary;
    }

    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return annualSalary / 52;  // Weekly salary
    }

    @Override
    public void displayWeeklyPay(double hoursWorked) {
        double weeklyPay = calculateWeeklyPay(hoursWorked);
        System.out.printf("%s (Salary Worker) worked %.2f hours: Weekly Pay = $%.2f\n", this, hoursWorked, weeklyPay);
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + annualSalary;
    }

    @Override
    public String toJSON() {
        return super.toJSON().replace("}", ", \"annualSalary\": " + annualSalary + " }");
    }

    @Override
    public String toXML() {
        return super.toXML().replace("</Person>", "<annualSalary>" + annualSalary + "</annualSalary></Person>");
    }
}
