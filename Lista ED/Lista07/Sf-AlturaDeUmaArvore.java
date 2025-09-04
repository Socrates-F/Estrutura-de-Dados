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


class Node<T>{
    
     T elemento;
     Node<T> left, right;
    
    public Node(T e) {
        
        this.elemento = e;
    }

    public String toString() {
        return "" + elemento;
    }
}

class BinaryTree<T>{
    
    private Node<T> raiz;
    
    public int alturaArvore(Node<T> p) {
       
        if (p != null) {
    //levando em consideracao que a altura se existir somente a raiz e (alt = 0),temos:
            int altEsq = -1;
            int altDir = -1;
           
            if(p.left != null) {
                altEsq = alturaArvore(p.left);
                
            }
            if(p.right != null) {
                altDir = alturaArvore(p.right);
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
    
    // os cods abaixo sao os msm do cod que usei para add elementos a arvore que utilizei em outras questoes
    // segue a msm linha de raciocinio
    
    //metodo que cria(gera) a arvore binaria
    public Node<T> gerarArvore(String input) {
        
        Node<T> r = null;
        String [] elementos = input.split(" ");
        
        for(int i = 0; i < elementos.length; i++) {
            
             inserir((T) elementos[i]);
            
        }
        r = raiz;
        return r;
    }
    
    //metodo responsavel pela insercao dos elementos
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
                
                if(cpr == 0) {
                    break;
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
    //metodo auxiliar para logica de insercao.
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
    public static int treeHeight(String inputValues) {
        
        BinaryTree<Integer> three = new BinaryTree<Integer>();
        
        Node<Integer> teste = three.gerarArvore(inputValues);
        
		return three.alturaArvore(teste);
    }
}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));


        String inputValues = bufferedReader.readLine();
        int result = Result.treeHeight(inputValues);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}