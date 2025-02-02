import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

   private Product product;
    @BeforeEach
    void setUp() {
        // Creating an instance of Person before each test
        product = new Product("Apple Cider", "fresh cider from granny smiths", "000001", 5);
    }

    @Test
    void testConstructor() {
        assertEquals("Apple Cider", product.getName());
        assertEquals("fresh cider from granny smiths", product.getDescription());
        assertEquals("000001", product.getID());
        assertEquals(5,product.getCost());
    }
    @Test
    void testSetName() {
        product.setName("Orange Juice");
        assertEquals("Orange Juice", product.getName());
    }

    @Test
    void testSetID() {
        product.setID("000303");
        assertEquals("000303", product.getID());
    }
    @Test
    void testToCSV() {
        assertEquals("Apple Cider,Fresh Cider from granny smiths,000001,5", product.toCSV());
    }

    @Test
    void testToJSON() throws Exception {
        String expectedJson = "{" +
                "\"name\": \"Apple Cider\", " +
                "\"description\": \"fresh cider from granny smiths\", " +
                "\"ID\": \"000001\", " +
                "\"cost\": \"5\", " +
                "}";
        assertEquals(expectedJson, product.toJSON());

    }

    @Test
    void testToXML() {
        String expectedXml = "<Product><name>Apple Cider</name><description>fresh cider from granny smiths</description><ID>000001</ID><cost>5</cost></Product>";
        assertEquals(expectedXml, product.toXML());
    }


    @Test
    void testEquals() {
        Product anotherProduct = new Product("Apple Cider", "Fresh cider from granny smiths", "000001", 5);
        assertEquals(product, anotherProduct);
    }
}












