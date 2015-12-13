package testebatch;

/**
 *
 * @author well
 */
public class TesteBatch {

    public static void main(String[] args) {
        Producer p = new Producer();
        ExecuteProducer ep = new ExecuteProducer(p);
        Thread t = new Thread(ep);
        Thread t1 = new Thread(ep);
        Thread t2 = new Thread(ep);


        t.start();
        t1.start();
        t2.start();


//        test();
    }

    private static void test() {
        int count = 0;
        Producer p = new Producer();

        while (p.hasNext()) {
            count++;

            Object o = p.next();

            if (o instanceof Integer) {
                System.out.println("Qtd: " + count + "  Integer -> " + o);
            }

            if (o instanceof Double) {
                System.out.println("Qtd: " + count + "  Double -> " + o);
            }

            if (o instanceof String) {
                System.out.println("Qtd: " + count + "  String -> " + o);
            }

        }
    }
}
