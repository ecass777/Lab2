import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        boolean done = false;

        while (!done) {
            String ID = SafeInput.getNonZeroLenString(in, "Enter the ID:");
            String firstName = SafeInput.getNonZeroLenString(in, "Enter the First Name:");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter the Last Name:");
            String title = SafeInput.getNonZeroLenString(in, "Enter the Title:");
            int YOB = SafeInput.getRangedInt(in, "Enter the Year of Birth:", 1940, 2010);

            people.add(new Person(firstName, lastName, ID, title, YOB));

            done = SafeInput.getYNConfirm(in, "Are you done?");
        }

        try {
            Path file = Paths.get("PersonData.csv");
            BufferedWriter writer = Files.newBufferedWriter(file, StandardOpenOption.CREATE);
            for (Person p : people) {
                writer.write(p.toCSV());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
