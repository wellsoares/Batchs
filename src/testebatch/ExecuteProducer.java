package testebatch;

/**
 *
 * @author well
 */
public class ExecuteProducer implements Runnable {

    private Producer p;

    public ExecuteProducer(Producer p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (p.hasNext()) {
            System.out.println("ITEM: " + p.next());
            
            
            
        }
    }

}
