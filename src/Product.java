import java.util.Calendar;

public class Product {

String name;
String description;
String ID;
double cost;

// constructor
public Product(String name, String description, String ID, double cost) {
    this.name = name;
    this.description = description;
    this.ID = ID;
    this.cost = cost;
}

//setters and getters
    public void setName( String name ){this.name =name; }
    public String getName(){return name;}

    public String getID(){return ID;}
    public void setID(String ID){this.ID = ID;}

    public String getDescription(){
    return description;
    }
    public double getCost(){
    return cost;
    }
    @Override
    public String toString() {
        return "Product [name=" + name + ", description=" + description + ", ID=" + ID +
                ", cost" + cost +"]";
    }
    @Override
    public boolean equals(Object obj) {
        boolean result;
        if (this == obj) {
            result = true;
        } else if (obj == null || getClass() != obj.getClass()) {
            result = false;
        } else {
            Product product = (Product) obj;
            result = ID.equals(product.ID);// Compare based on ID field
        }
        return result;
    }

    //Additional methods
        public String toCSV() {
        return name + "," + description + "," + ID + "," + cost;
    }
    public String toJSON() {
        return "{" +
                "\"name\": \"" + name + "\", " +
                "\"description\": \"" + description + "\", " +
                "\"ID\": \"" + ID + "\", " +
                "\"cost\": \"" + cost + "\", " +
                "}";
    }
    public String toXML() {
        return "<Product>" +
                "<name>" + name + "</name>" +
                "<description>" + description + "</description>" +
                "<ID>" + ID + "</ID>" +
                "<cost>" + cost + "</cost>" +
                "</Product>";
    }








}
