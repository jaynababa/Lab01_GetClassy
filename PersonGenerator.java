import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args) {
        //  use Safe inout to validate and collect input
        // after collecting input, create a person object
        //store person objects in an ArrayList<Person>
        //after input is complete: //use toCSV() method to dave ArrayList to a CSV file
        // Prompt the user for the File name where data will be saved


        // 1. User Input
        Scanner in = new Scanner(System.in);
        ArrayList<Person> personRec = new ArrayList<>();
        boolean done = false;
        do {

            String firstName = SafeInput.getNonZeroLenString(in, "Enter the First Name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter the Last Name");
            String ID = SafeInput.getNonZeroLenString(in, "Enter the ID");
            String title = SafeInput.getNonZeroLenString(in, "Enter the Title");
            int YOB = SafeInput.getRangedInt(in, "Enter the year of Birth", 1940, 2010);

            //2. Persons object and adds it to the arraylist
            Person person = new Person(firstName, lastName, ID, title, YOB);
            personRec.add(person);

            done = SafeInput.getYNConfirm(in, "Are you done?");
        } while (!done);

       // Display the Person records in the console
        System.out.println("\nPerson Records:");
        for (Person person : personRec) {
            System.out.println(person);
        }

        String fileName = SafeInput.getNonZeroLenString(in, "Enter the file name to save data");
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = workingDirectory.toPath().resolve(fileName);

        try (BufferedWriter writer = Files.newBufferedWriter(file, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {
            for (Person person : personRec) {
                writer.write(person.toCSV());
                writer.newLine();
            }
            System.out.println("Data file written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        in.close();

    }


}



