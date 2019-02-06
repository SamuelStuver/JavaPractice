// import Scanner for data from file 
import java.util.Scanner;
// import ArrayList to create Arrays
import java.util.ArrayList;
// import File to read data file
import java.io.File;
// import IOException for file I/O error handling
import java.io.IOException;

public class Histo {

    public static void main(String[] args) {
        // declare and instantiate data as Scanner with null value
        // declare count as an Integer ArrayList 
        // declare idx as an Integer
        Scanner data = null;
        ArrayList<Integer> count;
        Integer idx;

        // try to read data into Scanner instance. If I/O error, print message and stack trace, then quit
        try{
            data = new Scanner(new File("test.dat"));
        }
        catch ( IOException e) {
            System.out.println("Unable to open data file.");
            e.printStackTrace();
            System.exit(0);
        }

        // instantiate count as empty ArrayList with 10 values
        count = new ArrayList<Integer>(10);
        // for 0 <= i < 10, set values of count at index to zero
        for (Integer i =0; i<10; i++) {
            count.add(i,0);
        }

        // as long as there is data to read, increment count at the index of the next available data point
        while(data.hasNextInt()) {
            idx = data.nextInt();
            count.set(idx, count.get(idx)+1);
        }

        // for i in count, print value of count for each data value (then increment the data value)
        idx = 0;
        for (Integer i : count){
            System.out.println(idx + " occured " + i + " times.");
            idx++;
        }
    }

}
