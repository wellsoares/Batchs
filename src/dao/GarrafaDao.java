package dao;

import interfaces.IDao;
import java.util.ArrayList;
import java.util.List;
import pojo.Garrafa;
import pojo.Usuario;

/**
 *
 * @author well
 */
public class GarrafaDao implements IDao<Garrafa> {

    public List<Garrafa> buscarGarrafas(String sql, long pagina, long qtdPagina) {

        List<Garrafa> listUsuarios = new ArrayList<>();
        Garrafa u;

        if (pagina < 5) {
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
    public List<Garrafa> executarConsulta(String consulta, long pagina, long qtdPagina) {
        return buscarGarrafas(consulta, pagina, qtdPagina);
    }

}
