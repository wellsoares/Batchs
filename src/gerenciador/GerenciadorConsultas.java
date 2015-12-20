package gerenciador;

import java.util.ArrayList;
import java.util.List;
import pojo.ConsultaGerenciada;

/**
 *
 * @author well
 */
public class GerenciadorConsultas {

    private static final int ITEM = 0;
    private long PAGINA_ATUAL = 1L;
    private final int CONSULTA_ATUAL = 0;

    private final List<ConsultaGerenciada> consultasGerenciadas;
    private final List dtosObtidos;

    private ConsultaGerenciada consultaGerenciadaAtual;

    public GerenciadorConsultas() {
        consultasGerenciadas = new ArrayList<>();
        dtosObtidos = new ArrayList<>();
    }

    public void preencherListaDtos() {

        try {
            if (!consultasGerenciadas.isEmpty()) {
                consultaGerenciadaAtual = consultasGerenciadas.get(CONSULTA_ATUAL);

                dtosObtidos.addAll(consultaGerenciadaAtual.getDao().paginarConsulta(consultaGerenciadaAtual.getConsulta(), consultaGerenciadaAtual.getQtdPagina(), PAGINA_ATUAL));

                PAGINA_ATUAL++;

                if (ultimaPagina()) {
                    consultasGerenciadas.remove(CONSULTA_ATUAL);
                    PAGINA_ATUAL = 1L;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean ultimaPagina() {
        return dtosObtidos == null || dtosObtidos.isEmpty() || dtosObtidos.size() < consultaGerenciadaAtual.getQtdPagina();
    }

    public boolean temProximo() {
        return (!consultasGerenciadas.isEmpty() || !dtosObtidos.isEmpty());
    }

    public Object obterItem() {
        Object dto = dtosObtidos.remove(ITEM);
        if (dtosObtidos.isEmpty()) {
            preencherListaDtos();
        }
        return dto;
    }

    public GerenciadorConsultas adicionarConsulta(ConsultaGerenciada consulta) {
        consultasGerenciadas.add(consulta);
        return this;
    }

}
