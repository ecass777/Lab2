import java.util.Objects;

public class Product {
    private String name;
    private String description;
    private String ID;
    private double cost;

    // Constructor
    public Product(String name, String description, String ID, double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getID() {
        return ID;
    }

    public double getCost() {
        return cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    // CSV, JSON, XML methods
    public String toCSV() {
        return ID + "," + name + "," + description + "," + cost;
    }

    public String toJSON() {
        return "{ \"ID\": \"" + ID + "\", \"name\": \"" + name + "\", \"description\": \"" + description + "\", \"cost\": " + cost + " }";
    }

    public String toXML() {
        return "<Product><ID>" + ID + "</ID><name>" + name + "</name><description>" + description + "</description><cost>" + cost + "</cost></Product>";
    }

    @Override
    public String toString() {
        return name + " (" + description + ") - $" + cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.cost, cost) == 0 &&
                name.equals(product.name) &&
                description.equals(product.description) &&
                ID.equals(product.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, ID, cost);
    }
}
