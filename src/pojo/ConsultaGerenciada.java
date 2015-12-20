package pojo;

import interfaces.IDao;

/**
 *
 * @author well
 */
public class ConsultaGerenciada {

    private final String consulta;
    private final long qtdPagina;
    private final IDao dao;
    private final Class tipoRetorno;

    private final static String TEMPLATE_PAGINACAO_INICIO = " Inicio Paginacao ";
    private final static String TEMPLATE_PAGINACAO_FIM = " Fim Paginacao ";

    public ConsultaGerenciada(String consulta, long qtdPagina, IDao dao, Class c) {
        this.consulta = consulta;
        this.qtdPagina = qtdPagina;
        this.dao = dao;
        this.tipoRetorno = c;
    }

    public String getConsulta() {
        return TEMPLATE_PAGINACAO_INICIO + consulta + TEMPLATE_PAGINACAO_FIM;
    }

    public long getQtdPagina() {
        return qtdPagina;
    }

    public IDao getDao() {
        return dao;
    }

    public Class getTipoRetorno() {
        return tipoRetorno;
    }
}
