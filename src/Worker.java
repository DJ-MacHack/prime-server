import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedHashSet;
import java.util.Vector;
import java.util.*;
import java.util.stream.Collectors;

class Worker extends Thread
{

    private LinkedHashSet<Integer> hashmap; //main.hashmap; //.stream().map(Integer::new).collect(Collectors.toSet());
    private Vector<Integer> primes = main.primes;
    Set s;
    private int n;

    Worker(Set shashmap, Vector<Integer> primes, int n)
    {
        super("my extending thread");
        //TODO THREADSAFE!!!!!!
        //this.hashmap = (LinkedHashSet<Integer>)hashmap.clone();
        //this.primes = (Vector<Integer>) primes.clone();
        this.n = n;
            this.s = main.hashmap.stream().map(Integer::new).collect(Collectors.toSet());
            while (s.iterator().hasNext()) {
                this.hashmap.add((int) s.iterator().next());
            }
        start();
    }
    public void run() {
        try {
            synchronized (hashmap) {
                PrimeFarm farm = new PrimeFarm(hashmap, primes);
                long start = System.currentTimeMillis();
                NumberFormat formatter = new DecimalFormat("#0.00000");
                primes = farm.getPrimes(n);
                long end = System.currentTimeMillis();
                System.out.println(n + "th prime:");
                System.out.println((int) primes.lastElement());
                System.out.println("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
                System.out.println(primes.size());
            }
        }
        catch(Exception e)
            {
                System.out.println("my thread interrupted");
            }
        }

   /* @Override
    protected void finalize() throws Throwable {

        super.finalize();
    }*/
}