import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class divisaoEConquista{

private static int iteracao = 0;

public static void main(String args[]){
    List<Integer> n = new ArrayList<Integer>();
    int A[] = new int[1048576];
    int B[] = new int[1048576];
    Random gerador = new Random();
    for(int i = 0; i < 1048576; i++){
        n.add(gerador.nextInt(20000));
        A[i] = gerador.nextInt(20000);
        B[i] = gerador.nextInt(20000);
    }
    long tempoInicial = System.currentTimeMillis();
    mergeSort(n);
    System.out.println("Tempo Merge Sort " + (System.currentTimeMillis() - tempoInicial));
    System.out.println(iteracao);
    
    iteracao = 0;

    long tempoInicial2 = System.currentTimeMillis();
    System.out.println(maxVal1(A, 1048576));
    System.out.println("Tempo MaxVal " + (System.currentTimeMillis() - tempoInicial2));
    System.out.println(iteracao);

    iteracao = 0;
    //int A[], int init, int end
    long tempoInicial3 = System.currentTimeMillis();
    System.out.println(maxVal2(B,0,1048575));
    System.out.println("Tempo MaxVal2 " + (System.currentTimeMillis() - tempoInicial3));
    System.out.println(iteracao);
}

public static List<Integer> mergeSort(List<Integer> n) {
    if (n.size()==1){
        iteracao++;
        return n;
    }
    List<Integer> a = mergeSort(n.subList(0, n.size()/2));
    List<Integer> b = mergeSort(n.subList(n.size()/2, n.size()));

    n = merge(a,b);
    iteracao++;
    return n;
}


public static List<Integer> merge(List<Integer> a, List<Integer> b) {
    
    //List<Integer> itens = Arrays.asList(a);

        
        List<Integer> n = new ArrayList<Integer>();
        //System.out.println(a.size());
        //System.out.println(b.size());
        
        int aAtual = 0;
        int bAtual = 0;
        while(aAtual != a.size() || bAtual != b.size()){
            if(aAtual>=a.size()){
                n.add(b.get(bAtual));
                bAtual++;
            }
            else if(bAtual>=b.size()){
                n.add(a.get(aAtual));
                aAtual++;
            }
            else if(a.get(aAtual) >= b.get(bAtual)){
                n.add(b.get(bAtual));
                bAtual++;
            }
            else{
                n.add(a.get(aAtual));
                aAtual++;
            }
        }
        for(int i = 0; i < n.size(); i++){
            //System.out.println(n.get(i));
        }
 //       System.out.println();
        return n;
}


public static int maxVal1(int A[], int n) {  
    int max = A[0];
    for (int i = 1; i < n; i++) {  
        if( A[i] > max ) {
           max = A[i];
        }
        iteracao++;
    }
    
    return max;
}
public static int max(int a,int b) {
    if(a>b){
        return a;
    }else{
        return b;
    }
}  
public static int maxVal2(int A[], int init, int end) {  
    if (end - init <= 1){
        iteracao++;
        return max(A[init], A[end]);  
    }
    else{
          int m = (init + end)/2;
          int v1 = maxVal2(A,init,m);   
          int v2 = maxVal2(A,m+1,end);
          iteracao++;  
          return max(v1,v2);
         }
}
}

