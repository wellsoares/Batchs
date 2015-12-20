package testebatch;

import dao.GarrafaDao;
import dao.UsuarioDao;
import gerenciador.GerenciadorConsultas;
import java.util.Arrays;
import java.util.List;
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

        GerenciadorConsultas gerenciador = new GerenciadorConsultas();
        gerenciador.adicionarConsulta(new ConsultaGerenciada("USUARIO", 5, new UsuarioDao(), Usuario.class))
                .adicionarConsulta(new ConsultaGerenciada("GARRAFA", 10, new GarrafaDao(), Garrafa.class))
                .adicionarConsulta(new ConsultaGerenciada("STRING", 5, new UsuarioDao(), String.class));

        Object dto;

        gerenciador.preencherListaDtos();
        while (gerenciador.temProximo()) {
            dto = gerenciador.obterItem();
            System.out.println("ITEM: " + dto);
        }

        List<Integer> li = Arrays.asList(1, 2, 3);
        List<String> ls = Arrays.asList("one", "two", "three");
        printList(li);
        printList(ls);

    }

    public static void printList(List list) {
        for (Object elem : list) {
            System.out.println(elem + " ");
        }
        System.out.println();
    }

    public static void printList1(List<?> list) {
        for (Object elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

}
