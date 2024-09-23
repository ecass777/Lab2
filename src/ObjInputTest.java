public class ObjInputTest {
    public static void main(String[] args) {
        SafeInputObj inputObj = new SafeInputObj();

        String nonZeroString = inputObj.getNonZeroLenString("Enter a non-zero length string");
        System.out.println("You entered: " + nonZeroString);

        int rangedInt = inputObj.getRangedInt("Enter an integer between 1 and 100", 1, 100);
        System.out.println("You entered: " + rangedInt);

        int intVal = inputObj.getInt("Enter any integer");
        System.out.println("You entered: " + intVal);

        double rangedDouble = inputObj.getRangedDouble("Enter a double between 10.5 and 99.9", 10, 100);
        System.out.println("You entered: " + rangedDouble);

        double doubleVal = inputObj.getDouble("Enter any double");
        System.out.println("You entered: " + doubleVal);

        boolean confirm = inputObj.getYNConfirm("Do you want to proceed");
        System.out.println("Confirmation: " + (confirm ? "Yes" : "No"));

        String regExString = inputObj.getRegExString("Enter a string that contains only digits", "\\d+");
        System.out.println("You entered: " + regExString);
    }
}
