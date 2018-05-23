import java.util.LinkedHashSet;
import java.util.Vector;

public class main {
    public static LinkedHashSet<Integer> hashmap = new LinkedHashSet<>();
    public static Vector<Integer> primes = new Vector<Integer>();
    public static void main(String[] args){
        int n = 1000000;
        Worker zero = new Worker(hashmap, primes, n);
/*        LinkedHashSet<Integer> hashmap = new LinkedHashSet<>();
        Vector<Integer> primes = new Vector<Integer>();*/
        Worker one = new Worker(hashmap, primes, 100);
        Worker two = new Worker(hashmap, primes,500000);
        /*Worker three = new Worker(hashmap, primes,1000000);
        Worker four = new Worker(hashmap, primes,2000000);
        try {
            Thread.sleep(1250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Worker five = new Worker(hashmap, primes,200000);*/
        try {
            Thread.sleep(2550);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(primes.size());
        System.out.println(hashmap.size());
    }
}
