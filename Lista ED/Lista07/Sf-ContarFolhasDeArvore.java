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


class BinaryNode<T>{
    
     T elemento;
     BinaryNode<T> left, right;
    
    public BinaryNode(T e) {
        
        this.elemento = e;
    }

    public String toString() {
        return "" + elemento;
    }
}

class BinaryThree<T>{
    
    private BinaryNode<T> raiz;
    
    //fiz esse metodo para deixa mais limpo a visualizacao do cod em "funcoes".
     public BinaryNode<T> gerarArvore(String input) {
        
        BinaryNode<T> r = null;
        String [] elementos = input.split(" ");
        
        for(int i = 0; i < elementos.length; i++) {
            
             inserir((T) elementos[i]);
            
        }
        r = raiz;
        return r;
    }
    
    public int contarFolhas(BinaryNode<T> p ) {
        //esse metodo aqui vai me retornar a quantidade de folhas presente na minha arvore.
        if(p!=null) {
            
            if(p.left == null && p.right == null) {
                return 1;
            }
            else{
                
                return contarFolhas(p.left) + contarFolhas(p.right);
            }
        }
        return 0;
    }
    
    public void inserir (T novo) {
        
        BinaryNode<T>  novoNo = new BinaryNode<T>(novo);
    
        if(raiz == null) {
            raiz = novoNo;
        }
        else {
            
            BinaryNode<T> aux = raiz;
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
    //metodo que vai auxiliar na incremento dos nos.
    private int comparar(T t1, T t2) {
        int r = -1;
        //Como sei que estou usando inteiros utilizei essa ideia abaixo
        //Obs: compareTo compara lexicograficamente entao para facilitar tratar inteiros achei melhor dessa forma.
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
    public static int numberOfLeafs(String inputValues) {
        
        BinaryThree<Integer> three = new BinaryThree<Integer>();
        
        BinaryNode<Integer> teste = three.gerarArvore(inputValues); //essa variavel teste vai conter todos os elementos
                                                                    //da minha arvore devido o retorno da geracao da                                                                         //arvore e assim posso usar ela para o meu metodo
         	return three.contarFolhas(teste);                       //responsavel por contar a quant de folhas.
    }
}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));


        String a = bufferedReader.readLine();
        int result = Result.numberOfLeafs(a);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}