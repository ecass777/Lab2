public class Worker extends Person {
    private double hourlyPayRate;

    public Worker(String firstName, String lastName, String ID, String title, int YOB, double hourlyPayRate) {
        super(firstName, lastName, ID, title, YOB);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double calculateWeeklyPay(double hoursWorked) {
        if (hoursWorked <= 40) {
            return hoursWorked * hourlyPayRate;
        } else {
            double overtimeHours = hoursWorked - 40;
            return (40 * hourlyPayRate) + (overtimeHours * hourlyPayRate * 1.5);
        }
    }

    public void displayWeeklyPay(double hoursWorked) {
        double totalPay = calculateWeeklyPay(hoursWorked);
        if (hoursWorked <= 40) {
            System.out.printf("%s worked %.2f hours: Pay = $%.2f\n", this, hoursWorked, totalPay);
        } else {
            double overtimeHours = hoursWorked - 40;
            double regularPay = 40 * hourlyPayRate;
            double overtimePay = overtimeHours * hourlyPayRate * 1.5;
            System.out.printf("%s worked %.2f hours (%.2f regular, %.2f overtime): Pay = $%.2f (Regular: $%.2f, Overtime: $%.2f)\n",
                    this, hoursWorked, 40.0, overtimeHours, totalPay, regularPay, overtimePay);
        }
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + hourlyPayRate;
    }

    @Override
    public String toJSON() {
        return super.toJSON().replace("}", ", \"hourlyPayRate\": " + hourlyPayRate + " }");
    }

    @Override
    public String toXML() {
        return super.toXML().replace("</Person>", "<hourlyPayRate>" + hourlyPayRate + "</hourlyPayRate></Person>");
    }
}
