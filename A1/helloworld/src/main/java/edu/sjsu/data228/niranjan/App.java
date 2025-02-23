// package edu.sjsu.data228.018176301;
// this is not working, package is not able to take number hence giving error, instead used my name instead of ID and editted the pom file aswell
package edu.sjsu.data228.niranjan;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, Niranjan");

        // Print today's date
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String date = sdf.format(new Date());
        System.out.println("Today's date: " + date);

        // Create a random number, square it, and print out the result
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        int squaredNumber = randomNumber * randomNumber;
        System.out.println("Random number: " + randomNumber);
        System.out.println("Squared result: " + squaredNumber);
    }
}