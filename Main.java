import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Pazuk on 23.01.2018.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        /*int n=5, a=-1, b=4, c=-1, d=6, e=-7;
        PrintWriter inputWriter = new PrintWriter("input.txt");
        inputWriter.println(n);
        inputWriter.print(a+" "+b+" "+c+" "+d+" "+e);
        inputWriter.close();*/

        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);
        int n = scanner.nextInt();
        int[] intArray = new int[5];
        int i=0;
        while(scanner.hasNextInt()) {
            intArray[i] = scanner.nextInt();
            i++;
        }
        scanner.close();

        //System.out.println(n);
        //System.out.println(Arrays.toString(intArray));

        int[] plusArray= new int[5];
        int[] minusArray= new int[5];
        for (i=0; i<intArray.length; i++) {
            if(intArray[i]>=0) {
                plusArray[i]=intArray[i];
            } else {
                minusArray[i]=intArray[i];
            }
        }
        int sumPlus=0;
        for (i=0; i<plusArray.length; i++) {
            sumPlus=sumPlus+plusArray[i];
        }

        int sumMinus=0;
        for (i=0; i<minusArray.length; i++) {
            sumMinus=sumMinus+minusArray[i];
        }

        sumMinus=Math.abs(sumMinus);

        PrintWriter writer = new PrintWriter("output.txt");

        int k=0;
        int position;
        if (sumPlus>=sumMinus) {
            for (i=0; i<intArray.length; i++) {
                if(intArray[i]>=0){
                    k++;
                }
            }
            System.out.println(k);
            writer.println(k);

            for(i=0; i<intArray.length; i++) {
                if(intArray[i]>=0) {
                    position=i+1;
                    //System.out.print(position+" ");
                    writer.print(position+" ");
                }
            }

        }
        else {
            for (i=0; i<intArray.length; i++) {
                if(intArray[i]<=0){
                    k++;
                }
            }
            System.out.println(k);
            writer.println(k);

            for(i=0; i<intArray.length; i++) {
                if(intArray[i]<=0) {
                    position=i+1;
                    //System.out.print(position+" ");
                    writer.print(position+" ");
                }
            }

        }

        writer.close();

    }
}
