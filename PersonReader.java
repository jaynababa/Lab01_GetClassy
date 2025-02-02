import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PersonReader {
    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line;

        // Set the directory to look for files in the 'data' folder
        Path target = Paths.get(System.getProperty("user.dir")).resolve("src");
        chooser.setCurrentDirectory(target.toFile());

        // Ask the user to select a file
        System.out.println("Please choose a file");

        try {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                target = chooser.getSelectedFile().toPath();// Get the selected file path
                System.out.println("Selected File:" + target.toAbsolutePath());

                inFile = new Scanner(target.toFile());
                ArrayList<Person> personRec = new ArrayList<>();

                // Display header
                System.out.printf("%-12s %-12s %-12s %-8s %-4s%n", "ID#", "Firstname", "Lastname", "Title", "YOB");
                System.out.println("======================================================");

                // Read lines from file
                while (inFile.hasNextLine()) {
                    line = inFile.nextLine();
                    String[] parts = line.split(",");  // Split by comma (CSV format)

                    if (parts.length == 5) { // Ensure valid record with 5 parts
                        // Correctly assign the CSV parts to the Person object fields
                        String id = parts[0].trim();
                        String firstName = parts[1].trim();
                        String lastName = parts[2].trim();
                        String title = parts[3].trim();
                        int yob = Integer.parseInt(parts[4].trim());

                        // Create the Person object and add it to the list
                        Person person = new Person(id, firstName, lastName, title, yob);
                        personRec.add(person);
                    } else {
                        System.out.println("Invalid record: " + line);  // Handle invalid record format

                    }
                }

                // Display formatted records
                 for (Person person : personRec) {
                    System.out.println(person);


                }

                // Convert the list to JSON
                String json = toJSON(personRec);
                System.out.println("\nJSON format:\n" + json);


                // Convert the list to XML
                String xml = toXML(personRec);
                System.out.println("\nXML format:\n" + xml);


                inFile.close();
            } else {
                System.out.println("Sorry, you must select a file! Terminating!");
                System.exit(0);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found Error");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException Error");
            e.printStackTrace();
        }
    }

    // Method to convert List<Person> to JSON manually
    public static String toJSON(List<Person> personList) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[\n");

        for (Person person : personList) {
            jsonBuilder.append("  {\n")
                    .append("    \"id\": \"").append(person.getID()).append("\",\n")
                    .append("    \"firstName\": \"").append(person.getFirstName()).append("\",\n")
                    .append("    \"lastName\": \"").append(person.getLastName()).append("\",\n")
                    .append("    \"title\": \"").append(person.getTitle()).append("\",\n")
                    .append("    \"YOB\": ").append(person.getYOB()).append("\n")
                    .append("  },\n");
        }

        // Remove last comma and add closing bracket
        if (!personList.isEmpty()) {
            jsonBuilder.setLength(jsonBuilder.length() - 2);
        }
        jsonBuilder.append("\n]");

        return jsonBuilder.toString();
    }

    // Method to convert List<Person> to XML manually
    public static String toXML(List<Person> personList) {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xmlBuilder.append("<personRec>\n");

        for (Person person : personList) {
            xmlBuilder.append("  <person>\n")
                    .append("    <id>").append(person.getID()).append("</id>\n")
                    .append("    <firstName>").append(person.getFirstName()).append("</firstName>\n")
                    .append("    <lastName>").append(person.getLastName()).append("</lastName>\n")
                    .append("    <title>").append(person.getTitle()).append("</title>\n")
                    .append("    <yob>").append(person.getYOB()).append("</yob>\n")
                    .append("  </person>\n");
        }


        xmlBuilder.append("</personRec>");

        return xmlBuilder.toString();
    }



}
