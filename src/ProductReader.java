import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";

        try {
            // Set working directory to the current directory of the project
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            // Open file chooser dialog
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                // Open file for reading
                InputStream in = new BufferedInputStream(Files.newInputStream(file));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                System.out.println("        ID#     Name    Description       Cost");
                System.out.println("=====================================================");
                // Read file line by line
                int line = 0;
                while ((rec = reader.readLine()) != null) {
                    line++;
                    // Print the line to console
                    System.out.printf("\n %4d: %-60s", line, rec);
                }
                reader.close(); // Close the file after reading
                System.out.println("\n\nData file read!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error reading file!");
            e.printStackTrace();
        }
    }
}
