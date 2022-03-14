import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class divisaoEConquista{

public static void main(String args[]){
    List<Integer> n = new ArrayList<Integer>();
    Random gerador = new Random();
    for(int i = 0; i < 32; i++){
        n.add(gerador.nextInt(100));
    }
    mergeSort(n);
    for(int i = 0; i < n.size(); i++){
        //System.out.println(n.get(i));
    }

}

public static List<Integer> mergeSort(List<Integer> n) {
    if (n.size()==1){
        return n;
    }
    List<Integer> a = mergeSort(n.subList(0, n.size()/2));
    List<Integer> b = mergeSort(n.subList(n.size()/2, n.size()));

    //n = merge(a,b);
    return n;
}


public static List<Integer> merge(List<Integer> a, List<Integer> b) {
    
    //List<Integer> itens = Arrays.asList(a);

        
        List<Integer> n = new ArrayList<Integer>();
        int aAtual = 0;
        int bAtual = 0;
        while(aAtual != a.size() && bAtual != b.size()){
            if(a.get(aAtual) >= b.get(bAtual)){
                n.add(b.get(bAtual));
                bAtual++;
            }
            else{
                n.add(a.get(aAtual));
                aAtual++;
            }
        }
        for(int i = 0; i < n.size(); i++){
            System.out.println(n.get(i));
        }
        System.out.println();
        return n;
}

}

