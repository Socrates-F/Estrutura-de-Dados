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
     * Complete the 'invertString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING input as parameter.
     */

    public static String invertString(String input) {
    // Write your code here
        
        int indiceFinal = input.length()-1;
        
        if(indiceFinal == 0) {
            
            return input.charAt(0)+""; // eu coloquei esse charAt com o "" so "transformar"em uma string. 
        }
        else {
            
            char caracter = input.charAt(indiceFinal);
            input = input.substring(0, indiceFinal); //para ir diminuindo a String seguindo a logica para que o ultimo 
                                                     //se torne o primeiro
            indiceFinal--;
            
            return caracter + invertString(input);
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String input = bufferedReader.readLine();

        String result = Result.invertString(input);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
