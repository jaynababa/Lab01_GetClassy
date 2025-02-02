import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerator {
    public static void main(String[] args) {
        //String productRec;
        Scanner in = new Scanner(System.in);
        ArrayList<Product> productRec = new ArrayList<>();

        SafeInputObj input = new SafeInputObj();




        boolean done;

        do {

            String name = input.getNonZeroLenString( "Enter the product name");
            String description= input.getNonZeroLenString( "Enter the product description");
             String ID =input.getNonZeroLenString("Enter the product ID");
             double cost= input.getDouble("Enter the product cost");

            Product product = new Product(name, description, ID, cost);
            productRec.add(product);

            done = input.getYNConfirm( "Are you done[Y/N]");


            // loops repeat until user is not done
        }while(!done);

        //3. Displays all records
        // goes through each string in folks and prints it
        System.out.println("\nProduct Info:");
        for (Product product : productRec) {
            System.out.println(product);
        }
        String fileName = input.getNonZeroLenString("Enter the file name to save data(ex. file.txt)");
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = workingDirectory.toPath().resolve(fileName);

        try (BufferedWriter writer = Files.newBufferedWriter(file, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {
            for (Product product : productRec) {
                writer.write(product.toCSV());
                writer.newLine();
            }
            System.out.println("Data file written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        in.close();


    }



}
