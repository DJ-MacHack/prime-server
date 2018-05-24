import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class main {
    //public static LinkedHashSet<Integer> hashmap = new LinkedHashSet<>();
    public static ConcurrentHashMap hashmaps = new ConcurrentHashMap();
    //public static Vector<Integer> primes = new Vector<Integer>();
    //public static Vector<Worker> workers = new Vector<Worker>();
    //public static Collection primes = Collections.synchronizedCollection(new Vector<>());
    public static boolean free = true;
    public static void main(String[] args){
        int n = 10000;
        //CollectionWorker garbage = new CollectionWorker();
        Set hashmap = java.util.Collections.newSetFromMap(hashmaps);
        Worker zero = new Worker(hashmap, n);

/*        LinkedHashSet<Integer> hashmap = new LinkedHashSet<>();
        Vector<Integer> primes = new Vector<Integer>();*/
        Worker one = new Worker(hashmap, 100);
        Worker two = new Worker(hashmap,500000);
        /*workers.add(zero);
        workers.add(one);
        workers.add(two);
        Worker three = new Worker(hashmap, primes,1000000);
        Worker four = new Worker(hashmap, primes,2000000);
        try {
            Thread.sleep(1250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Worker five = new Worker(hashmap, primes,200000);*/
        System.out.println("Main hash: " + hashmap.size());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main hash: " + hashmap.size());
        Worker five = new Worker(hashmap,1000000);
    }
}
