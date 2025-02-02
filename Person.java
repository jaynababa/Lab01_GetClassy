import java.util.Calendar;

public class Person{
//fields
String firstName;
String lastName;
String ID;
String title;
int YOB;

//constructor
    /**
     * Constructor for Person class to initialize all fields.
     *
     * @param firstName The first name of the person.
     * @param lastName The last name of the person.
     * @param ID The unique identifier of the person (should never change).
     * @param title The title or prefix for the person (e.g., Mr., Mrs., etc.).
     * @param YOB The year of birth
     */
    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }
    /*overloaded constructor
     @param firstName The first name of the person.
     @param lastName The last name of the person.
     @param ID The unique identifier of the person.
     @param YOB The year of birth.
 */

    public Person(String firstName, String lastName, String ID, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = "Unknown"; // default value
        this.YOB = YOB;
    }

    // setters and getter methods
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
        public void setLastName(String lastName) {this.lastName = lastName;}

    public String getID() {
        return ID;
    }
    public String getTitle(){
        return title;
    }
    public int getYOB() {
        return YOB;
    }
//override methods
@Override
public String toString() {
    return "Person [firstName=" + firstName + ", lastName=" + lastName + ", ID=" + ID +
            ", title=" + title + ", YOB=" + YOB + "]";
}
@Override
    public boolean equals(Object obj) {
    boolean result;
    if (this == obj) {
        result = true;
    } else if (obj == null || getClass() != obj.getClass()) {
        result = false;
    } else {
        Person person = (Person) obj;
        result = ID.equals(person.ID);// Compare based on ID field
    }
    return result;
}

//Additional methods
    public String fullName(){
        return firstName + " " + lastName;
    }
    public String formalName(){
        return title + " "+ fullName();
    }
    public String getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return String.valueOf(currentYear-YOB);
    }

        public String getAge ( int year){
            return String.valueOf(year - YOB);
        }
    public String toCSV() {
        return firstName + "," + lastName + "," + ID + "," + title + "," + YOB;
    }
    public String toJSON() {
        return "{" +
                "\"firstName\": \"" + firstName + "\", " +
                "\"lastName\": \"" + lastName + "\", " +
                "\"ID\": \"" + ID + "\", " +
                "\"title\": \"" + title + "\", " +
                "\"YOB\": " + YOB +
                "}";
    }
    public String toXML() {
        return "<Person>" +
                "<firstName>" + firstName + "</firstName>" +
                "<lastName>" + lastName + "</lastName>" +
                "<ID>" + ID + "</ID>" +
                "<title>" + title + "</title>" +
                "<YOB>" + YOB + "</YOB>" +
                "</Person>";
    }



    }