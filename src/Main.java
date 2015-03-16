import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        File file = new File(args[0]);
        int elementNumber,errorLines = 0;
        double sum = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                String [] arr = temp.split(";");
                try {
                    elementNumber = Integer.valueOf(arr[0]);
                    if (elementNumber> arr.length) {
                        errorLines++;
                        continue;
                    }
                    sum += Double.valueOf(arr[elementNumber]);
                } catch (NumberFormatException e){
                    errorLines++;
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.err.println("Error on the reading file");
            System.exit(1);
        }
        System.out.println("sum: " + sum);
        System.out.println("error-lines: " + errorLines);
    }
}
