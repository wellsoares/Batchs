package testebatch;

import dao.GarrafaDao;
import dao.UsuarioDao;
import gerenciador.GerenciadorConsultas;
import interfaces.Idto;
import java.util.HashMap;
import java.util.Map;
import pojo.ConsultaGerenciada;
import pojo.Garrafa;
import pojo.Usuario;

/**
 *
 * @author well
 */
public class TesteMainGerenciador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Map<Class, String> mapClass = new HashMap<>();
        String casa = "CASA";
        String casa1 = "4444";
        
        GerenciadorConsultas gerenciador = new GerenciadorConsultas();
        gerenciador.adicionarConsulta(new ConsultaGerenciada("USUARIO", 5, new UsuarioDao()));
        gerenciador.adicionarConsulta(new ConsultaGerenciada("GARRAFA", 10, new GarrafaDao()));
        
        mapClass.put(Usuario.class, casa);
        mapClass.put(Garrafa.class, casa1);
        
        Idto dto;
        
        gerenciador.preencherListaDtos();
        while (gerenciador.temProximo()) {
            dto = gerenciador.obterItem();
            String s = mapClass.get(dto.getClass());
            System.out.println("ITEM: " + s);
            teste((Usuario) dto);
        }
    }
    
    public static void teste(Usuario u) {
        System.out.println("Usuario : " + u);
    }
}
