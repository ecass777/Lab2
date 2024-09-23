import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonReader {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        try {
            Path file = Paths.get("PersonData.csv");
            BufferedReader reader = Files.newBufferedReader(file);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    String ID = data[0];
                    String firstName = data[1];
                    String lastName = data[2];
                    String title = data[3];
                    int YOB = Integer.parseInt(data[4]);
                    people.add(new Person(firstName, lastName, ID, title, YOB));
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        for (Person p : people) {
            System.out.println(p);
        }
    }
}
