import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedHashSet;
import java.util.Vector;
import java.util.*;
import java.util.stream.Collectors;

class Worker extends Thread
{

    private LinkedHashSet<Integer> shashmap = new LinkedHashSet<>(); //main.hashmap; //.stream().map(Integer::new).collect(Collectors.toSet());
    private Vector<Integer> primes = new Vector<>();
    private int n;
    private LinkedHashSet<Integer> org;
    private boolean finished = false;
    private boolean shared = false;

    Worker(LinkedHashSet<Integer> hashmap, Vector<Integer> primes, int n)
    {
        super("my extending thread");
        //TODO THREADSAFE!!!!!!
        //this.hashmap = (LinkedHashSet<Integer>)hashmap.clone();
        //this.primes = (Vector<Integer>) primes.clone();
        synchronized (hashmap){
            for(Iterator iter = hashmap.iterator(); iter.hasNext();){
                int entry = (int) iter.next();
                this.shashmap.add(entry);
            }
            this.org = hashmap;
        }
        synchronized (primes){
            for(Iterator iter2 = primes.iterator(); iter2.hasNext();){
                int entry2 = (int) iter2.next();
                this.primes.add(entry2);
            }
        }
        this.n = n;
        start();
    }
    public void run() {
        try {
            //synchronized (hashmap) {
                PrimeFarm farm = new PrimeFarm(this.shashmap, this.primes);
                long start = System.currentTimeMillis();
                NumberFormat formatter = new DecimalFormat("#0.00000");
                primes = farm.getPrimes(n);
                long end = System.currentTimeMillis();
                System.out.println(n + "th prime:");
                System.out.println((int) primes.lastElement());
                System.out.println("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
                System.out.println(primes.size());
            //}
        }
        catch(Exception e)
            {
                System.out.println("my thread interrupted");
            }
            this.finished = true;
        }

 /*   @Override
    protected void finalize() throws Throwable {
        if(finished) {
            synchronized (this.org) {
                    if (this.org.size() < this.shashmap.size()) {
                        for (int i = this.org.size(); i < n; i++) {
                            this.org.add(this.primes.elementAt(i));
                        }
                    }
                }
            }

        super.finalize();
    }*/
}