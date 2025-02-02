import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PersonTest {
/*Test the following:
Constructors: Validate that all fields are initialized correctly.
Setters: Ensure valid inputs update the fields as expected.
Methods:
fullName()
formalName()
toCSV()
toJSON()
toXML()
Use IntelliJ to create a test stub and fill in the expected values.
*/

    private Person person;

    /** Sets up a person object before each test is ran.
     * intialize a person with each attribute
     */
    @BeforeEach
    void setUp() {
        // Creating an instance of Person before each test
        person = new Person("John", "Adams", "000001", "Mr.", 1999);
    }

    /** Tests full constructor of the Person Class.
     *
      */
    @Test
    void testConstructor() {
        assertEquals("John", person.getFirstName());
        assertEquals("Adams", person.getLastName());
        assertEquals("000001", person.getID());
        assertEquals("Mr.",person.getTitle());
        assertEquals(1999, person.getYOB());
    }

    /** Test the overloaded constructor that doesnt include a title.
     *
      */
    @Test
    void testOverloadedConstructor() {
        Person anotherPerson = new Person("Mary", "Jane", "000002", 2001);
        assertEquals("Mary", anotherPerson.getFirstName());
        assertEquals("Jane", anotherPerson.getLastName());
        assertEquals("000002", anotherPerson.getID());
        assertEquals("Unknown", anotherPerson.getTitle());
        assertEquals(2001, anotherPerson.getYOB());
    }

    /** Tests the setter for the first name and updates it
     *
     */

    @Test
    void testSetFirstName() {
        person.setFirstName("Mary");
        assertEquals("Mary", person.getFirstName());
    }

    /** Tests the setter for the last name and uodates it.
     *
     */
    @Test
    void testSetLastName() {
        person.setLastName("Jane");
        assertEquals("Jane", person.getLastName());
    }

    /** Tests the full name method.
     * Includes persons first and last name
     */

    @Test
    void testFullName() {
        assertEquals("John Adams", person.fullName());
    }

    /** Tests the formal name method.
     * Includes the title in additional to the first and last name
     */
    @Test
    void testFormalName() {
        assertEquals("Mr. John Adams", person.formalName());
    }

    /** Tests to csv method
     * Ensures that the person attributes are formatted as a csv string.
     *
     */
    @Test
    void testToCSV() {
        assertEquals("John,Adams,000001,Mr.,1999", person.toCSV());
    }

    /** Test JSON method.
     * Ensures the object is formatted in a JSON string
     * @throws Exception if JSOn fails
     */
    @Test
    void testToJSON() throws Exception {
        String expectedJson = "{" +
                "\"firstName\": \"John\", " +
                "\"lastName\": \"Adams\", " +
                "\"ID\": \"000001\", " +
                "\"title\": \"Mr.\", " +
                "\"YOB\": 1999" +
                "}";
        assertEquals(expectedJson, person.toJSON());

    }

    /** tests XML methods
     * Ensures that the objects is formatted in a XML string
     */

    @Test
    void testToXML() {
        String expectedXml = "<Person><firstName>John</firstName><lastName>Adams</lastName><ID>000001</ID><title>Mr.</title><YOB>1999</YOB></Person>";
        assertEquals(expectedXml, person.toXML());
    }

    /** Tests the equal method
     * Ensure that two of the same person objects are equals.
     *
     */
    @Test
    void testEquals() {
        Person anotherPerson = new Person("John", "Adams", "000001", "Mr.", 1999);
        assertEquals(person, anotherPerson);
    }
}



