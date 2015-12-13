package testebatch;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author well
 */
public class ProducerOneList {
    
    private List<Integer> listInteger = new ArrayList();

    private int endRow;
    private int startRow;
    private int position;

    public ProducerOneList() {
        endRow = 10;
        popularLista();
    }

    public boolean hasNext() {
        return !listInteger.isEmpty();
    }

    public Integer next() {

        Integer numero = null;

        if (listInteger != null) {

            if (!listInteger.isEmpty()) {
                numero = listInteger.remove(0);
                if (listInteger.isEmpty()) {
                    popularLista();
                }
            }
        }
        return numero;
    }

    private void popularLista() {
        position = startRow + 2;
        consultarLista(startRow, position);
        startRow += 2;

        if (listInteger != null) {
            if (listInteger.isEmpty() && (startRow < endRow)) {
                popularLista();
            }
        }
    }

    private void consultarLista(int linhaInicial, int linhaFinal) {
        if (startRow < endRow) {
            for (int i = linhaInicial; i < linhaFinal; i++) {
                listInteger.add(i);
            }
        }
    }
}
