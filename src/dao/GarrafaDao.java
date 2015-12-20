package dao;

import interfaces.IDao;
import java.util.ArrayList;
import java.util.List;
import pojo.Garrafa;

/**
 *
 * @author well
 */
public class GarrafaDao implements IDao {

    public List<Garrafa> buscarGarrafas(String sql, long qtdPagina, long pagina) {

        List<Garrafa> listUsuarios = new ArrayList<>();
        Garrafa u;

        if (pagina <= 1) {
            for (long i = 0; i < qtdPagina; i++) {

                u = new Garrafa();
                u.setId(i + 1);
                u.setPeso(15);
                u.setNome(sql + " - Pagina: " + pagina);
                listUsuarios.add(u);
            }
        } else {
            for (long i = 0; i < qtdPagina - 1; i++) {
                u = new Garrafa();
                u.setId(i + 1);
                u.setPeso(15);
                u.setNome(sql + " - Pagina: " + pagina);

                listUsuarios.add(u);
            }
        }
        return listUsuarios;
    }

    @Override
    public List<?> paginarConsulta(String sql, long pagina, long quantidadePagina) {
        return buscarGarrafas(sql, pagina, quantidadePagina);
    }

    @Override
    public List executarConsulta(String consulta, long pagina, long qtdPagina) {
       return buscarGarrafas(consulta, qtdPagina, pagina);
    }

}
