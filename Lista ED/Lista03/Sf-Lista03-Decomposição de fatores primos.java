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

class CustomQueue {
    
    private String [] elementos;
    private int inicio,fim;
    private int quant;
    
    public CustomQueue() {
        
        elementos = new String[10];
        fim = -1;
    }
    
    public void enqueue(String value){
        
        if (quant == elementos.length) {
            expandirMemoria();
        }
            
            fim = (fim+1) % elementos.length; 
            elementos[fim] = value;
            quant++;
        
    }
    
    private void expandirMemoria() {
    
        String[] aux =  new String [quant*2];
        
        for(int i = 0; i < quant ; i++) {
            
            aux[i] = elementos [(i+inicio) % elementos.length];        
        }
        
        elementos = aux;
        inicio = 0;
        fim = quant-1;
        
    }
    
    public String dequeue(){
        
        String r = null; 
        
        if(quant > 0) {
            
            r = elementos[inicio];
            elementos[inicio] = null;
            inicio = (inicio+1) % elementos.length; 
            quant--;
        }
        
        return r;
    }
  	public boolean isEmpty(){
        
        if(quant == 0) {
            
            return true;
        }
        return false;
    }
}

class Result {

    /*
     * Complete the 'factorize' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING input as parameter.
     */

    public static CustomQueue factorize(Integer input) {
    
        CustomQueue fila = new CustomQueue();
        
      
        
        //for vai do menor numero primo ate o valor inteiro do raiz do numero passado no parametro
        for(int a = 2; a <= input; a++){
            
            if(input % a == 0 && input > a){ // se a divisao for exata , e inserido na fila o valor n 
                
                if(a < 30){  //considerando que o valor precisa ser menor que 30
                    
                fila.enqueue(String.valueOf(a));
                }
                
                input = input/a;     // ja que ocorreu uma divisao exata , input recebe seu novo valor.
                a--;                 // voltamos uma casa de "a" pois o numero a antes do decrescimo pode 
                                    // ter uma nova divisao exata.
            }
            
            if(a == input ){ //ao final do loop for temos que acrescentar o valor de input apos as demais 
                                 // divisoes pois ele tambem faz parte dos numeros que multiplicados resultam no 
                                 // valor original do "input"
                
                if(input < 30){ //considerando que o valor precisa ser menor que 30
                    
                    fila.enqueue(String.valueOf(input));
                }
                
            }
        }
        
        return fila;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
              
              	String input = bufferedReader.readLine();
              
                CustomQueue queue = Result.factorize(Integer.parseInt(input.trim()));
                
              	String result = "";
              
                while(!queue.isEmpty())
                    result += queue.dequeue() + " ";
              
                bufferedWriter.write(result.trim());
                bufferedWriter.newLine();
            }
        }
    }
}