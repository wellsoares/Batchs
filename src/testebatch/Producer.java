package testebatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author well
 */
public class Producer {
    
    private List<Object> listObjects = Collections.synchronizedList(new ArrayList());
    
    private int endRow;
    private int startRow;
    private int position;
    private int cont = 1;
    
    public Producer() {
        endRow = 2500000;
        popularLista();
        
    }
    
    public boolean hasNext() {
        return !listObjects.isEmpty();
    }
    
    public Object next() {
        
        Object numero = null;
        
        if (listObjects != null) {
            
            if (!listObjects.isEmpty()) {
                
                numero = listObjects.remove(0);
                
                if (listObjects.isEmpty()) {
                    synchronized (this) {
                        popularLista();
                    }
                }
            }
        }
        return numero;
    }
    
    private void popularLista() {
        position = startRow + 1000;
        switch (cont) {
            case 1:
                consultarListaInteger(startRow, position);
                break;
            case 2:
                consultarListaString(startRow, position);
                break;
            case 3:
                consultarListaDouble(startRow, position);
                break;
            default:
                System.out.println("Este não é um dia válido!");
        }
        startRow += 1000;
        
        if (listObjects != null) {
            if (listObjects.isEmpty() && (startRow < endRow)) {
                popularLista();
            }
            
            if (listObjects.isEmpty() && (startRow > endRow)) {
                cont++;
                startRow = 0;
                position = startRow + 2;
                switch (cont) {
                    case 2:
                        endRow = 250000;
                        popularLista();
                        break;
                    case 3:
                        endRow = 250000;
                        popularLista();
                        break;
                    default:
                        System.out.println("Este não é um dia válido!");
                }
            }
        }
    }
    
    private void consultarListaInteger(int linhaInicial, int linhaFinal) {
        if (startRow < endRow) {
            for (int i = linhaInicial; i < linhaFinal; i++) {
                listObjects.add(i);
            }
        }
    }
    
    private void consultarListaString(int linhaInicial, int linhaFinal) {
        String s = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";
        String[] charArray = s.split(",");
        if (startRow < endRow) {
            for (int i = linhaInicial; i < linhaFinal; i++) {
                listObjects.add("A");
            }
        }
    }
    
    private void consultarListaDouble(int linhaInicial, int linhaFinal) {
        Random r = new Random();
        if (startRow < endRow) {
            for (int i = linhaInicial; i < linhaFinal; i++) {
                listObjects.add(r.nextDouble());
            }
        }
    }
}
