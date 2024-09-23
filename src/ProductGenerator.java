import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerator {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        boolean done = false;

        while (!done) {
            String ID = SafeInput.getNonZeroLenString(in, "Enter the Product ID:");
            String name = SafeInput.getNonZeroLenString(in, "Enter the Product Name:");
            String description = SafeInput.getNonZeroLenString(in, "Enter the Product Description:");
            double cost = SafeInput.getDouble(in, "Enter the Product Cost:");

            products.add(new Product(name, description, ID, cost));

            done = SafeInput.getYNConfirm(in, "Are you done adding products?");
        }

        try {
            Path file = Paths.get("ProductData.csv");
            BufferedWriter writer = Files.newBufferedWriter(file, StandardOpenOption.CREATE);

            for (Product product : products) {
                writer.write(product.toCSV());
                writer.newLine();
            }

            writer.close();
            System.out.println("Product data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
