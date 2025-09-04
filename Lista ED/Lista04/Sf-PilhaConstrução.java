import java.io.*;
import java.util.*;

class Node {
    
    public String  elemento;
    public Node proximo;
    
    
    public Node(String elemento) {
        
        this.elemento = elemento;
        
    }
    //para visualizacao
    public String toString() {

        return "" +elemento;
    }
}
class CustomStack {
    
	private Node topo;
    private int quant;
    
    public void push (String entrada) {
        
        Node novo = new Node(entrada);
        
        if(topo == null) {
            
            topo = novo;
        }
        else {
            
            novo.proximo = topo;
            topo = novo;
        }
        quant++;
    }
    //deixei a escrita do metodo mesmo sem a utilizacao dele
    public Node pop() {
        
        Node aux = null;
        
         if(topo != null) {
             
             aux = topo;
             topo = topo.proximo;
        
             quant--;
         }
         
         return aux;
    }
    
    public Node peek() {
        
        Node r = null;
        
        if(topo != null) {
            
            r = topo;
        }
        
        return r;
    }
    
    public String toString() {
        
        String s = "";
        Node auxiliar = topo;
        
        while(auxiliar != null) {
            
            s = s + auxiliar.elemento + " ";
            auxiliar = auxiliar.proximo;
        }
        
        return s + "\n";
    }
    
    
}
class Result{
    // fiquei meio em duvida em fazer um metodo mais elaborado pra ir criando filas ou se so criar uma
    // quantidade definida seria o suficiente, como em um submit eu vi que de erro de runtime pensei que
    // poderia ser sobre o tamanho.
  	CustomStack pilha1 = new CustomStack();
    CustomStack pilha2 = new CustomStack();
    CustomStack pilha3 = new CustomStack();
    CustomStack pilha4 = new CustomStack();
    CustomStack pilha5 = new CustomStack();
    CustomStack pilha6 = new CustomStack();
    int vezPilha = 1;
    
    //metodo que verifica qual a pilha vai ser utilizada
    public CustomStack pilhaDaVez() {
        
        if(vezPilha == 1) {
            return pilha1;
        }
        else if(vezPilha == 2) {
            return pilha2;
        }
        else {
            return pilha3;
        }
    }
    
    
  	public void empilhar(String tipoDoMaterial){
        
      	switch (tipoDoMaterial) {
        
        case "Tijolo":
            
            if(pilhaDaVez().peek() == null || pilhaDaVez().peek().elemento.equals("Tijolo")) {
                
                pilhaDaVez().push(tipoDoMaterial);
            }
            else {
                if(vezPilha != 3 ) {
                    vezPilha++;
                }
                empilhar(tipoDoMaterial);
            }
            
            break;
            
        case "Areia":
            
            if(pilhaDaVez().peek() == null || (!pilhaDaVez().peek().elemento.equals("Cano") &&
                    !pilhaDaVez().peek().elemento.equals("Valvula"))) {
                
                pilhaDaVez().push(tipoDoMaterial);
            }
            else{
                
                if(vezPilha != 3 ) {
                    vezPilha++;
                }
                empilhar(tipoDoMaterial);
            }
            
            break;
            
        case "Cimento":
            
            if(pilhaDaVez().peek() == null || (!pilhaDaVez().peek().elemento.equals("Cano") &&
                    !pilhaDaVez().peek().elemento.equals("Valvula"))) {
                
                pilhaDaVez().push(tipoDoMaterial);
            }
            else{
                
                if(vezPilha != 3 ) {
                    vezPilha++;
                }
                empilhar(tipoDoMaterial);
            }
            
            break;
            
        case "Cano":
            
            pilhaDaVez().push(tipoDoMaterial);
            
            break;
            
        case "Valvula":
            
            pilhaDaVez().push(tipoDoMaterial);
            
            break;
        }
        
        if(vezPilha > 1){
            
            vezPilha = vezPilha-1 ; //esqueci de colocar o "reset" de qual pilha verificar qual pilha esta add elemnto.
        }
        
     }
  	public String toString(){
        
        String s = "";
        
        s = s + pilha1.toString();
        s = s + pilha2.toString();
        s = s + pilha3.toString();
        
        return s;
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
      
        Scanner scan = new Scanner(System.in);
        Result result = new Result();
      	String nextLine = "";
        while(scan.hasNextLine()) {
          	nextLine = scan.nextLine();
            if(nextLine.isEmpty()) {
                break;
            }else{
            	result.empilhar(nextLine);
            }
        }
        System.out.println(result);
    }
}