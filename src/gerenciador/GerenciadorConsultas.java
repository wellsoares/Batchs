package gerenciador;

import interfaces.Idto;
import java.util.ArrayList;
import java.util.List;
import pojo.ConsultaGerenciada;

/**
 *
 * @author well
 */
public class GerenciadorConsultas {

    private final List<ConsultaGerenciada> consultasGerenciadas;
    private List<Idto> dtosObtidos;
    private static final int ITEM = 0;
    private ConsultaGerenciada consultaGerenciadaAtual;
    //Contadores Consulta e pagina;
    private final int CONSULTA_ATUAL = 0;
    private long PAGINA_ATUAL = 1L;

    public GerenciadorConsultas() {
        consultasGerenciadas = new ArrayList<>();
        dtosObtidos = new ArrayList<>();
    }

    public void preencherListaDtos() {
        if (!consultasGerenciadas.isEmpty()) {
            consultaGerenciadaAtual = consultasGerenciadas.get(CONSULTA_ATUAL);
            dtosObtidos = consultaGerenciadaAtual.getDao().executarConsulta(consultaGerenciadaAtual.getConsulta(), PAGINA_ATUAL, consultaGerenciadaAtual.getQtdPagina());
           // System.out.println("SQL: " + consultaGerenciadaAtual.getConsulta() + " Pagina: " + PAGINA_ATUAL + " QtdPagina: " + consultaGerenciadaAtual.getQtdPagina() + " Qtd Dtos: " + dtosObtidos.size());
            PAGINA_ATUAL++;

            if (ultimaPagina()) {
                consultasGerenciadas.remove(CONSULTA_ATUAL);
                PAGINA_ATUAL = 1;
            }
        }
    }

    private boolean ultimaPagina() {
        return dtosObtidos == null || dtosObtidos.isEmpty() || dtosObtidos.size() < consultaGerenciadaAtual.getQtdPagina();
    }

    public boolean temProximo() {
        return (!consultasGerenciadas.isEmpty() || !dtosObtidos.isEmpty());
    }

    public Idto obterItem() {

        Idto dto = dtosObtidos.remove(ITEM);

        if (dtosObtidos.isEmpty()) {
            preencherListaDtos();
        }

        return dto;
    }

    public void adicionarConsulta(ConsultaGerenciada consulta) {
        consultasGerenciadas.add(consulta);
    }
}
