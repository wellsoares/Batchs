package pojo;

import interfaces.Idto;

/**
 *
 * @author well
 */
public class Garrafa implements Idto, Comparable<Garrafa> {

    private long id;
    private String nome;
    private int peso;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Garrafa{" + "id=" + id + ", nome=" + nome + ", peso=" + peso + '}';
    }

    @Override
    public int compareTo(Garrafa o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
