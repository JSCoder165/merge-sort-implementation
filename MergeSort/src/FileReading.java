import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

abstract class FileReading {

     public static String[] dataToArray(File f) throws FileNotFoundException, IOException{
        int length = 0;
        Scanner file = new Scanner(f);
        while(file.hasNextLine()){
            length++;
            file.nextLine();
        }
        file.close();

        String[] data = new String[length];
        length = 0;
        Scanner file2 = new Scanner(f);
        while(file2.hasNextLine()){
            data[length] = file2.nextLine();
            length++;
        }
        file2.close();
        return data;
    }

    public static ArrayList<String> dataToArrayList(File f) throws FileNotFoundException, IOException{
        Scanner file = new Scanner(f);
        
        ArrayList <String> data = new ArrayList<String>();
        while(file.hasNextLine()){
            String line = file.nextLine();
            data.add(line);
        }
        file.close();



        return data;
    }
}
