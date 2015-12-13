package pojo;

import interfaces.IDao;

/**
 *
 * @author well
 */
public class ConsultaGerenciada {

    private String consulta;
    private long qtdPagina;
    private IDao dao;

    public ConsultaGerenciada(String consulta, long qtdPagina, IDao dao) {
        this.consulta = consulta;
        this.qtdPagina = qtdPagina;
        this.dao = dao;
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public long getQtdPagina() {
        return qtdPagina;
    }

    public void setQtdPagina(long qtdPagina) {
        this.qtdPagina = qtdPagina;
    }

    public IDao getDao() {
        return dao;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
