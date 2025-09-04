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

//Ja que era pra usar arvores eu implementei as classes padroes parar criar(gerar) a arvore a class Node
//e a class BinaryThree seguem o padrao de outros cods que fiz, a diferenca esta na presenca do metodo
//calcularDiferencaAltura"
class Node<T> {

     T elemento;
     Node<T> left, right;
    
    public Node(T e) {
        
        this.elemento = e;
    }

    public String toString() {
        return "" + elemento;
    }
}

class BinaryThree<T> {
    
    private Node<T> raiz;
    //metodo que retorna a diferenca de altura de 2 nodes irmaos, utilizei como referencia de nodes irmaos ,
    //os filhos da raiz e fiz com que comparasse a maior altura entre o lado esquerdo e o lado direito para atender
    //o requisito de estarem ou nao balanceadas.
    public int calcularDiferencaAltura(Node<T> p) {
        
        if(p == null){
            return -1;
        }
        if(p.left != null && p.right !=null) {
            
            int x = alturaArvore(p.left);
            int y = alturaArvore(p.right);
            
            if(x > y) {
                return x - y;
            }
            else {
                
                return y-x;
            }
        }
        else if (p.left == null && (p.right != null && alturaArvore(p.right) == 0) 
                 || p.right == null && (p.left != null && alturaArvore(p.left) == 0)) {
            return 1;
        }
        else if(p.left == null && p.right ==null){
            return 0;
        }
        else{
            return -1;
        }
    }
    
     public Node<T> gerarArvore(String input) {
        
        Node<T> r = null;
        String [] elementos = input.split(" ");
        
        for(int i = 0; i < elementos.length; i++) {
            
             inserir((T) elementos[i]);
            
        }
        r = raiz;
        return r;
    }
    //Obs: daqui pra baixo os metodos seguem o padrao ja escrito em outras questoes.
    //Obs: so ha uma alteracao no metodo inserir que vai tratar os valores se forem iguais e inseri-los.
    
    //metodo que eu vou usar para saber a maior altura de um caminho para poder utilizar acima no cod que calcula 
    //a diferenca entre tamanhos de nodes irmaos.
    public int alturaArvore(Node<T> p) {
        
        if (p != null) {
    //levando em consideracao que a altura se existir somente a raiz e (alt = 0),temos:
            int altEsq = -1;
            int altDir = -1;
            
            if(p.left != null) {
                altEsq = alturaArvore(p.left);
                
            }
            if(p.right != null) {
                altDir =alturaArvore(p.right);
            }
            
            if(altDir > altEsq) {
                return altDir+1;
            }
            else {
                return altEsq+1;
            }
        }
            
        return -1;
    }
    
    public void inserir (T novo) {
        
        Node<T>  novoNo = new Node<T>(novo);
    
        if(raiz == null) {
            raiz = novoNo;
        }
        else {
            
            Node<T> aux = raiz;
            while(aux != null) {
                //cpr = comparar
                int cpr = comparar(novo, aux.elemento);
                //insere os elementos repetidos dando preferencia a sua insercao nos nodes da direita
                if(cpr == 0) {
                    if(aux.left == null && aux.right == null){
                        aux.right = novoNo;
                        break;
                        
                    }else if(aux.right != null){
                        aux = aux.right;  
                    }
                }
                else if (cpr < 0) {
                    
                    if(aux.left != null) {
                        aux = aux.left;
                    }
                    else {
                        aux.left = novoNo;
                        break;
                    }
                }
                else {
                    if(aux.right != null) {
                        aux = aux.right;
                    }
                    else {
                        aux.right = novoNo;
                        break;
                    }
                }
         }
      }
    }

    private int comparar(T t1, T t2) {
        int r = -1;
        
        int x = Integer.parseInt(t1.toString());
        int y = Integer.parseInt(t2.toString());
        
        if(x == y) {
            r = 0;
        }
        else if(x < y){
            r = -1;
        }
        else {
            r = 1;
        }
        return r;
    }
    
}
class Result {

    public static String NodeInformation(String values) {
    
        BinaryThree<Integer> three = new BinaryThree<Integer>();
        
        Node<Integer> teste = three.gerarArvore(values);
        
        if(three.calcularDiferencaAltura(teste) == 0 
          || three.calcularDiferencaAltura(teste) == 1){
            
            return "E balanceada";
        }
        else {
            return "Nao e balanceada";
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String treeNodes = bufferedReader.readLine();

        String result = Result.NodeInformation(treeNodes);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
