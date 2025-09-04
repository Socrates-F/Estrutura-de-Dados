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

class Queue {
    
    private String [] elementos ;
    private int inicio;
    private int fim;
    private int quant;
    
    public Queue() {
        
        this.elementos = new String[5];
        this.fim = -1;
    }
    //obs tanto em enqueue quanto em dequeue, tem um tratamento para normalizar a posicao "fim" eu deixei assim 
    //por nao saber se influenciaria nos teste .
    public void enqueue(String value){
      
       if (quant == elementos.length) {
                expandir();
            }
            
            fim = (fim+1) % elementos.length; 
            elementos[fim] = value;
            
            quant++;
        
    }
    
    public void expandir() {
        String[] temp =  new String [quant*2];
        
        for(int i = 0; i < quant ; i++) {
            
            temp[i] = elementos [(i+inicio) % elementos.length];        
        }
        
        elementos = temp;
        
    }
    
    public String dequeue(){
        
        String aux = null;
        
        if(quant > 0) {
            
            aux = elementos[inicio];
            elementos[inicio] = null;
            inicio = (inicio+1) % elementos.length;
        
            quant--;
        }
        
        return aux;
    }
    
    public String toString() {
        
        String aux = "";
        
        for(int i = 0; i < quant; i++) {
            
            aux += elementos[i] + " ";
        }
        
        return aux;
    }
    
    public boolean isEmpty() {
        
        if(quant == 0) {
            
            return true;
        }
        return false;
    }
}

class Result {

    public static Queue invertQueue(String input) {
        
         Queue inversa = new Queue();
         String [] numeros = input.split(" ");
         int quant = 0;
         int fim = numeros.length-1;
         
         
         while (quant < numeros.length) {
             //essa fila1 serve como auxiliar para que eu posso recria-la ate que a fila inversa complete os valores
             Queue fila1 = new Queue(); 
             String [] numerosAux = input.split(" ");
             
             for(int a = 0; a < numeros.length; a++) {
                 
                 fila1.enqueue(numeros[a]);
                 
             }
             
            for(int a = 0; a < numeros.length ; a++) {
                    //vou fazendo a fila andar ate o momento que a posicao seja a msm que eu quero para adicionar a 
                    //fila inversa
                if(a == fim) {
                    
                    inversa.enqueue(fila1.dequeue()); 
                    fim--;
                    quant++;
                    System.out.println(inversa);
                    break;
                }
                
                else {
                    fila1.dequeue();
                }
            }
         }
         
         
         return inversa;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
                String input = bufferedReader.readLine();
                Queue queue = Result.invertQueue(input.trim());
                String result = "";
                while(!queue.isEmpty())
                    result += queue.dequeue() + " ";
                bufferedWriter.write(result.trim());
                bufferedWriter.newLine();
            }
        }
    }
}