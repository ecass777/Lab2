import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product("Laptop", "High-performance laptop", "P123", 1200.00);
    }

    @Test
    public void testGetName() {
        assertEquals("Laptop", product.getName());
    }

    @Test
    public void testSetName() {
        product.setName("Desktop");
        assertEquals("Desktop", product.getName());
    }

    @Test
    public void testToCSV() {
        assertEquals("P123,Laptop,High-performance laptop,1200.0", product.toCSV());
    }

    @Test
    public void testToJSON() {
        String expectedJson = "{ \"ID\": \"P123\", \"name\": \"Laptop\", \"description\": \"High-performance laptop\", \"cost\": 1200.0 }";
        assertEquals(expectedJson, product.toJSON());
    }

    @Test
    public void testToXML() {
        String expectedXml = "<Product><ID>P123</ID><name>Laptop</name><description>High-performance laptop</description><cost>1200.0</cost></Product>";
        assertEquals(expectedXml, product.toXML());
    }

    @Test
    public void testEquals() {
        Product anotherProduct = new Product("Laptop", "High-performance laptop", "P123", 1200.00);
        assertEquals(product, anotherProduct);
    }
}
