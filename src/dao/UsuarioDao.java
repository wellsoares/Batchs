package dao;

import interfaces.IDao;
import java.util.ArrayList;
import java.util.List;
import pojo.Usuario;

/**
 *
 * @author well
 */
public class UsuarioDao implements IDao<Usuario> {

    public List<Usuario> buscarUsuarios(String sql, long pagina, long qtdPagina) {

        List<Usuario> listUsuarios = new ArrayList<>();
        Usuario u;

        if (pagina < 5) {
            for (long i = 0; i < qtdPagina; i++) {

                u = new Usuario();
                u.setId(i + 1);
                u.setIdade(15);
                u.setNome(sql + " - Pagina: " + pagina);
                listUsuarios.add(u);
            }
        } else {
            for (long i = 0; i < qtdPagina - 1; i++) {
                u = new Usuario();
                u.setId(i + 1);
                u.setIdade(15);
                u.setNome(sql + " - Pagina: " + pagina);

                listUsuarios.add(u);
            }
        }
        return listUsuarios;
    }

    public List<String> buscarNomesUsuarios(String sql, long pagina, long qtdPagina) {

        List<String> listNomesUsuarios = new ArrayList<>();
        String u;

        if (pagina < 5) {
            for (long i = 0; i < qtdPagina; i++) {
                u = new String();
                u = (i + 1 + " " + sql + " - Pagina: " + pagina);
                listNomesUsuarios.add(u);
            }
        } else {
            for (long i = 0; i < qtdPagina - 1; i++) {
                u = (i + 1 + " " + sql + " - Pagina: " + pagina);
                listNomesUsuarios.add(u);
            }
        }
        return listNomesUsuarios;
    }

    @Override
    public List<Usuario> executarConsulta(String consulta, long pagina, long qtdPagina) {
        return buscarUsuarios(consulta, pagina, qtdPagina);
    }

    @Override
    public List<?> paginarConsulta(String sql, long quantidadePagina, long pagina) {

        if (sql.contains("USUARIO")) {
            return buscarUsuarios(sql, pagina, quantidadePagina);
        } else {
            return buscarNomesUsuarios(sql, pagina, quantidadePagina);
        }
    }
}
