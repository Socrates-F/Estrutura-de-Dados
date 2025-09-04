import java.io.*;
import java.util.*;

class Node {
    
    //Obs: eu nao sei se pela presenca da classe No precisa ser feito necessariamente com uma lista dinamica
    //mas nesse caso eu utilizei por acabar sendo mais "facil" na minha concepcao.
    
    public Integer elemento;
    public Node proximo;
    
    
    public Node(Integer elemento) {
        
        this.elemento = elemento;
    }
    
    
    public String toString() {

        return "" +elemento;
    }
}

class CustomQueue {

	private Node inicio,fim;
    
    public void enqueue(Integer value) {
        
        Node novoNo = new Node(value);
        
        if(inicio == null) {
            
            inicio = novoNo;
            fim = novoNo;
        }
        else {
            fim.proximo = novoNo;  //uma vez que a fila nao esta mais vazia, o proximo a entrar nela precisa estar no
            fim = novoNo;          // final da fila.
        }
    }

    public Integer dequeue() {
        
        Integer aux = -1; 
        
        if(inicio != null) {
            
            aux =  inicio.elemento;  
            inicio = inicio.proximo; //como o primeiro elemento da fila e oq o proximo elemento se torna o primeiro
                                     //da fila.
            
            if(inicio == null) {
                
                fim = null; // se nao temos ninguem no comeco da fila,sabemos que nao temos ninguem ao final dela.
            }
        }
        return  aux; 
    }

    public String toString() {
        
	    String s = "";
        Node aux = inicio; 

        if(aux == null) {
            
            return "Empty";
        }
        
        while (aux != null) {
            s += aux + " ";
            aux = aux.proximo;
        }
        
        return s;
        
     }
    }



public class Solution {

    public static void main(String[] args) throws IOException {

        try(Scanner scan = new Scanner(System.in)){
          CustomQueue queue = new CustomQueue();

          while(scan.hasNextLine()) {
              String nextLine = scan.nextLine();

              if(nextLine.isEmpty()) {
                  break;
              }

              Integer n = Integer.parseInt(nextLine);

              if (n < 0) {
                  queue.dequeue();
                  System.out.println("Remove: " + queue);

              } else {
                  queue.enqueue(n);
                  System.out.println("Insert: " + queue);
              }
          }
        }
    }
}