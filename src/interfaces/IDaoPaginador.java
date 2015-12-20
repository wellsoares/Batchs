package interfaces;

import java.util.List;

/**
 *
 * @author well
 */
public interface IDaoPaginador {

    public List paginarConsulta(String sql, long pagina, long quantidadePagina);

}
