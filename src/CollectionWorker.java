import java.util.Collection;
import java.util.Iterator;

public class CollectionWorker extends Thread {
    public CollectionWorker() {
        super("Garbage");
        start();
    }

    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*while (true) {
            try {
                synchronized (main.primes){
                    Collection e = main.hashmaps.values();
                    Iterator iter = main.primes.iterator();
                    Iterator iter2 = e.iterator();
                    while (iter.hasNext()){
                        iter2.hasNext();
                    }
                    while (iter2.hasNext()){
                        main.primes.add(iter2.next());
                    }
                }

            } catch (Exception e) {
                System.out.println("my thread interrupted #worker?");
            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }
}

