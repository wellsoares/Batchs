package pojo;

import interfaces.Idto;

/**
 *
 * @author well
 */
public class Usuario implements Idto, Comparable<Usuario> {

    private long id;
    private String nome;
    private int idade;

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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", idade=" + idade + '}';
    }

    @Override
    public int compareTo(Usuario o) {
        return this.getNome().compareTo(o.getNome());
    }

}
