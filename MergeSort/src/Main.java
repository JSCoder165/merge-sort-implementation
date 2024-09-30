import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
public class Main{
    public static void main(String[] args) throws FileNotFoundException, IOException{

        String filePath = "";
        boolean isTiming = false; //set to true if -o, only return if true

        ArrayList <String> data;
        String[] data2;


        for(int i = 0; i < args.length; i++){
            if(args[i].equals("-f")){
                filePath = args[i+1];
                continue;
            }
            if (args[i].equals("-o")) {
                isTiming = true;
            }
        }
        File f = new File(filePath);
        data = FileReading.dataToArrayList(f);
        data2 = FileReading.dataToArray(f);

        System.out.println("Beginning merge sort with ArrayList...");
        double time1 = System.nanoTime();

        data = MergeSort.mergeSortArrayList(data, 0, data.size());
        double time2 = System.nanoTime();
        System.out.println("Merge sort with arraylist completed. ");
        timing(isTiming,"Time taken (in seconds): "+((time2-time1)/1000000000));
        
        
        double time = time2-time1;
        System.out.println("Beginning merge sort with Array...");
        time1 = System.nanoTime();
        data2 = MergeSort.mergeSortArray(data2);
        time2 = System.nanoTime();
        time += time2-time1;


        System.out.println("Merge sort with array completed. ");
        timing(isTiming,"Time taken (in seconds): "+((time2-time1)/1000000000));


        
        
        time /= 1000000000;
        
        timing(isTiming,"runtime for both algorithms:  " + time + " seconds");
        
        System.out.println("arraylist data:");
        for(String s : data){
            System.out.println(s);
        }
        System.out.println("array data:");
        for(String s : data2){
            System.out.println(s);
        }
        
    }
    public static void timing(boolean isTiming, String message) {
        if(isTiming){
            System.out.println(message);
        }
    }
}
