import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

public class ProductReader {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            Path file = Paths.get("ProductData.csv");
            BufferedReader reader = Files.newBufferedReader(file);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    String ID = data[0];
                    String name = data[1];
                    String description = data[2];
                    double cost = Double.parseDouble(data[3]);
                    products.add(new Product(name, description, ID, cost));
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        for (Product p : products) {
            System.out.println(p);
        }
    }
}
