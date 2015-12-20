package interfaces;

import java.util.List;

/**
 *
 * @author well
 */
public interface IDao<T> extends IDaoPaginador {

    public List<?> executarConsulta(String consulta, long pagina, long qtdPagina);

}
