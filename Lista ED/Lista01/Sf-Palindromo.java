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
     * Complete the 'isPalindrome' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING input as parameter.
     */

    public static String isPalindrome(String input) {
    // Start
        
        int indiceFinal = input.length()-1;
        
        input = input.toLowerCase();
        input = input.replaceAll(" ", "");
        input = input.replaceAll("\\p{Punct}", "");
        
        //usei da logica de comparar o primeiro termo e o ultimo e ir reduzindo a String para "inicial+1 , final-1"
            
            if(input.length()==1 || input.length()==2) { //para a string reduzida ao final tenha tamanho par ou impar.
                
                 if(input.charAt(0)==input.charAt(indiceFinal)) {
                     
                     return "E um palindromo";
                 }
                 else {
                     
                     return "Nao e um palindromo";
                 }
                
            }
            
            else {
                
                if (input.charAt(0)==input.charAt(indiceFinal)) {
                    
                    input = input.substring(1, indiceFinal); // "inicia+1 , final-1"
                    
                    return isPalindrome(input);
                }
                else {
                    
                    return "Nao e um palindromo";
                }
                     
            }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String phrase = bufferedReader.readLine();

        String result = Result.isPalindrome(phrase);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
