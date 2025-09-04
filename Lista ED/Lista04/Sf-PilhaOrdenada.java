import java.io.*;
import java.util.*;

class Node {
    
    public String elemento;
    public int peso;
    public Node proximo;
    
    public Node(String elemento , int peso) {
        
        this.elemento = elemento;
        this.peso = peso;
    }
    //para visualizacao
    public String toString() {

        return "" +elemento;
    }
    
}
class CustomStack {
	private Node topo;
    private int quant;
    
    
    public void push (Node entrada) {
        
        if(topo == null) {
            
            topo = entrada;
        }
        else {
            
            entrada.proximo = topo;
            topo = entrada;
        }
        
        quant++;
    }
    
    public Node pop() {
        
        Node aux = null;
        
         if(topo != null) {
             
             aux = topo;
             topo = topo.proximo;
             aux.proximo = null;
             quant--;
         }
         
         return aux;
    }
    
    public Node top() {
        
        Node r = null;
        
        if(topo != null) {
            
            r = topo;
        }
        
        return r;
    }
    
    public int size() {
        
        return quant;
    }
}
class Result{
    
  	CustomStack pilha1 = new CustomStack(); //pilha1 = pilha  principal
    CustomStack pilhaAux = new CustomStack();
    
	public void empilhar(String entrada){
    //essa formatacao eu poderia deixar como um metodo externo mas optei por deixar em empilhar msm 
    //ate a linha 94 e so para manipular a entrada
        String [] entradaFormat = entrada.split(" ");
        
        for(int a = 0; a < entradaFormat.length ; a++) {
            String dados = entradaFormat[a];
            
            String [] aux = dados.split(";");
            String info1 = aux[0];
            int info2 = Integer.parseInt(aux[1]);
            
            Node novo = new Node(info1, info2);
            pilhaAux.push(novo);
    
        }
        
        while(pilhaAux.size() > 0) {
            
            Node auxiliar = null;
         
            if(pilha1.size() >= 2 && pilhaAux.top().peso > pilha1.top().peso ) {
                
                auxiliar = pilhaAux.pop();
                
                while(pilha1.size() >0) {
                    
                    pilhaAux.push(pilha1.pop());
                }
                
                    pilha1.push(auxiliar);
                
            }
            else if (pilha1.top() == null || pilhaAux.top().peso < pilha1.top().peso) {
                
                auxiliar = pilhaAux.pop(); //sei que poderia optar por pilha1.push(pilhaAux.pop()) mas por questao 
                pilha1.push(auxiliar);     // de visualizacao propria utilizei dessa forma
                  
            }
            else {
                
                auxiliar = pilha1.pop();
                pilha1.push(pilhaAux.pop());
                pilhaAux.push(auxiliar);
                
            }   
        }   
    }
    
  	public String toString(){
        
      	String s = "";
        Node pFinal = pilha1.top();
          
          while(pFinal != null) {
                  
                  s += pFinal.elemento+ " ";
                  pFinal = pFinal.proximo;
              }
          
          return s;
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        Result result = new Result();
      	String entrada = "";
        while(scan.hasNextLine()) {
          	String nextLine = scan.nextLine();
            if(nextLine.isEmpty()) {
                break;
            }else if(entrada == ""){
            	entrada = nextLine;
            }else{
            	entrada += " " + nextLine;
            }
        }
      	result.empilhar(entrada);
        System.out.println(result);
    }
}