import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

// Plan:
// Step 1. Perform numbers from input file as array.
// Step 2. Sort all numbers as >0 and <0.
// Step 3. Calculate sum of >0 and <0 numbers separately.
// Step 4. Define sum of what numbers is larger by module.
// Step 5. According with result, get positions of numbers from array

/**
 * Created by Pazuk on 23.01.2018.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);
        int n = scanner.nextInt();
        int[] specifiedArray = new int[n];
        int i=0;
        while(scanner.hasNextInt()) {
            specifiedArray[i] = scanner.nextInt(); // get array from numbers from file
            i++;
        }
        scanner.close();

        int[] plusArray= new int[n];   // array for numbers>0
        int[] minusArray= new int[n];  // array for numbers<0
        for (i=0; i<specifiedArray.length; i++) {
            if(specifiedArray[i]>=0) {
                plusArray[i]=specifiedArray[i];
            } else {
                minusArray[i]=specifiedArray[i];
            }
        }
        int sumPlus=0;
        for (i=0; i<plusArray.length; i++) {
            sumPlus=sumPlus+plusArray[i];     // sum of all numbers>0
        }

        int sumMinus=0;
        for (i=0; i<minusArray.length; i++) {
            sumMinus=sumMinus+minusArray[i];  // sum of all numbers<0
        }

        sumMinus=Math.abs(sumMinus); // get sum by module for numbers<0

        PrintWriter writer = new PrintWriter("output.txt");

        int k=0;
        int position;
        if (sumPlus>=sumMinus) { // if sum of numbers>0 is larger
            for (i=0; i<specifiedArray.length; i++) {
                if(specifiedArray[i]>=0){
                    k++; // get how many numbers>0 in specified array
                }
            }

            writer.println(k);

            for(i=0; i<specifiedArray.length; i++) {
                if(specifiedArray[i]>=0) {
                    position=i+1; // get positions of numbers>0 in specified array
                                  // where i+1 -it's index->position)
                    writer.print(position+" ");
                }
            }

        }
        else {
            for (i=0; i<specifiedArray.length; i++) { // the same for numbers<0 if their sum is larger
                if(specifiedArray[i]<=0){
                    k++;
                }
            }
            writer.println(k);

            for(i=0; i<specifiedArray.length; i++) {
                if(specifiedArray[i]<=0) {
                    position=i+1;
                    writer.print(position+" ");
                }
            }

        }

        writer.close();

    }
}
