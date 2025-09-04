import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


// Socrates Farias

class Result {
    public static String recursiveSwap(String s) {
        // Adicione sua resolucao aqui
        
       String aux = "pi";
        s = s.toLowerCase();
        boolean contem = s.contains(aux);
        
        if(contem == false){
            //basicamente usei uma logica que ele iria substituir todos os espacos e pontuacoes, como pegaria os "."
            //do "3.14", fiz com que o cod novamente me desse "3.14" com uma nova substituicao .
            s = s.replaceAll(" ", "");
            
            s = s.replaceAll("\\p{Punct}", "");
            
            s = s.replaceAll("314", "3.14");
                    
        return s;
        
    }
        else {
            
            s = s.replace(aux, "3.14");
            
            return recursiveSwap(s); // se eu n fizer essa chamada recursiva, ele nao tira os pontos e espacos .
        }
        
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        String s = bufferedReader.readLine();

        String resultado = Result.recursiveSwap(s);

        bufferedWriter.write(resultado);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}