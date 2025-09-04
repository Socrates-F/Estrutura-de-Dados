import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

//Socrates Farias

class Result {

    /*
     * Complete the 'fibonacci' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER position as parameter.
     */

    public static int fibonacci(int position) {
    // Write your code here
        
        if(position == 1 || position == 2) {
            
            return 1;
        }
        else {
        
            return fibonacci(position-1)+fibonacci(position-2);    
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int inputPosition = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.fibonacci(inputPosition);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
