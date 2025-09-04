import java.io.*;
import java.util.*;

class Node {
    
    public int elemento;
    public Node proximo;
    
    
    public Node(int elemento) {
        
        this.elemento = elemento;
    }
    
    
    public String toString() {

        return "" +elemento;
    }
}

class CustomStack {

	private Node topo;
    private int quant;
    
    public void add (int num) {  //add = push
        
        Node novo = new Node(num);
        
        if(topo == null) {
            
            topo = novo;
        }
        else {
            
            novo.proximo = topo;
            topo = novo;
        }
        
        quant++;
    }
    
    public void remove() { //remove = pop
        
         int aux = -1;
        
         if(topo != null) {
             
             aux = (int) topo.elemento;
             topo = topo.proximo;
             quant--;
         }
    }

    public String display() {
        
	    String s = "";
        Node aux = topo;
        
        while (aux != null) {
            s += aux + " ";
            aux = aux.proximo;
        }
         
        if(s == "") {
            
            return "Empty"; // se todos os elementos foram removidos entao s "volta a ser" "" logo , "vazio".
        }
        else {
            
            String [] display = s.split(" ");
            String txt = "";
            
            //como a questao pede para o display tenha o topo na direita, fiz uma manipulacao do meu "print" com os                 //valores abaixo do topo impressos a sua esquerda.
          
            for(int i = display.length-1 ; i >= 0; i--) {
                
                txt += display[i] + " ";
            }
            
            return txt;
        }
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        CustomStack stack = new CustomStack();

        while(scan.hasNextLine()) {
            String nextLine = scan.nextLine();

            if(nextLine.isEmpty()) {
                break;
            }
         
            Integer n = Integer.parseInt(nextLine);
            
            if (n < 0) {
                stack.remove();
                System.out.println("Remove: " + stack.display());

            } else {
                stack.add(n);
                System.out.println("Insert: " + stack.display());
            }
        }
    }
}