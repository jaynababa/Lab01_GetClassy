import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductReader {
        public static void main(String[] args){

            JFileChooser chooser = new JFileChooser();
            Scanner inFile;
            String line;


            Path target = new File(System.getProperty("user.dir")).toPath();
            target = target.resolve("src");
            // set the chooser to the project src directory
            chooser.setCurrentDirectory(target.toFile());

            // Use SafeInput to get the filename from the user
           /* Scanner userInput = new Scanner(System.in);
            String prompt = "Please choose a file";
            String fileName = SafeInput.getNonZeroLenString(userInput, prompt);
*/
            // Ask the user to select a file
            System.out.println("Please choose a file");
            try {
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    target = chooser.getSelectedFile().toPath();  // this is a File object not a String filename
                    System.out.println("Selected File:" + target.toAbsolutePath());


                    inFile = new Scanner(target);
                    ArrayList<Product> productRec = new ArrayList<>();

                    // Display header

                    System.out.println("ID#       Name      Description     Cost");
                    System.out.println("============================================");

                    while (inFile.hasNextLine()) {
                        line = inFile.nextLine();
                        String[] parts = line.split(","); // Assuming CSV format (comma-separated)

                        if (parts.length == 4) { // Ensure valid record with 4 parts
                            String ID = parts[0].trim();
                            String name = parts[1].trim();
                            String description = parts[2].trim();
                            double cost = Double.parseDouble(parts[3].trim());

                            // Create the Person object and add it to the list
                            Product product = new Product(ID, name, description, cost);
                            productRec.add(product);

                        }
                        else{
                            System.out.println("Invalid record: " + line);  // Handle invalid record format
                        }
                    }

                    // Display formatted records
                    for (Product product : productRec) {
                        System.out.println(product);
                    }
                    // Convert the list to JSON
                    String json = toJSON(productRec);
                    System.out.println("\nJSON format:\n" + json);


                    // Convert the list to XML
                    String xml = toXML(productRec);
                    System.out.println("\nXML format:\n" + xml);


                    inFile.close();
                } else {
                    System.out.println("Sorry, you must select a file! Terminating!");
                    return;
                }

            }

            catch (FileNotFoundException e)
            {
                System.out.println("File Not Found Error");
                e.printStackTrace();
            }
            catch (IOException e) // code to handle this exception
            {
                System.out.println("IOException Error");
                e.printStackTrace();
            }
        }

    // Method to convert List<Person> to JSON manually
    public static String toJSON(List<Product> productRec) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[\n");

        for (Product product : productRec) {
            jsonBuilder.append("  {\n")
                    .append("    \"id\": \"").append(product.getID()).append("\",\n")
                    .append("    \"name\": \"").append(product.getName()).append("\",\n")
                    .append("    \"description\": \"").append(product.getDescription()).append("\",\n")
                    .append("    \"cost\": \"").append(product.getCost()).append("\",\n")
                    .append("  },\n");
        }

        // Remove last comma and add closing bracket
        if (!productRec.isEmpty()) {
            jsonBuilder.setLength(jsonBuilder.length() - 2);
        }
        jsonBuilder.append("\n]");

        return jsonBuilder.toString();
    }

    // Method to convert List<Person> to XML manually
    public static String toXML(List<Product> productRec) {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xmlBuilder.append("<productRec>\n");

        for (Product product : productRec) {
            xmlBuilder.append("  {\n")
                    .append("    <id>").append(product.getID()).append("</id>\n")
                    .append("    <name>").append(product.getName()).append("</name>\n")
                    .append("    <description>").append(product.getDescription()).append("</description>\n")
                    .append("    <cost>").append(product.getCost()).append("</cost>\n")
                    .append("  },\n");
        }


        xmlBuilder.append("</productRec>");

        return xmlBuilder.toString();
    }







}

