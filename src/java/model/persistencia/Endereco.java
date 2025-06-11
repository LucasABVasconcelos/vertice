package model.persistencia;

public class Endereco {

    private int id_endereco;
    private String cep;
    private String local;
    private int numero_casa;
    private String bairro;
    private String cidade;
    private String estado;
    private String complemento;
    private Usuario usuario;  // Adicionando o atributo Usuario

    // Getters e Setters para o Endereco
    public boolean setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
        return true;
    }

    public int getId_endereco() {
        return this.id_endereco;
    }

    public boolean setCep(String cep) {
        this.cep = cep;
        return true;
    }

    public String getCep() {
        return this.cep;
    }

    public boolean setLocal(String local) {
        this.local = local;
        return true;
    }

    public String getLocal() {
        return this.local;
    }

    public boolean setNumero_casa(int numero_casa) {
        this.numero_casa = numero_casa;
        return true;
    }

    public int getNumero_casa() {
        return this.numero_casa;
    }

    public boolean setBairro(String bairro) {
        this.bairro = bairro;
        return true;
    }

    public String getBairro() {
        return this.bairro;
    }

    public boolean setCidade(String cidade) {
        this.cidade = cidade;
        return true;
    }

    public String getCidade() {
        return this.cidade;
    }

    public boolean setEstado(String estado) {
        this.estado = estado;
        return true;
    }

    public String getEstado() {
        return this.estado;
    }

    public boolean setComplemento(String complemento) {
        this.complemento = complemento;
        return true;
    }

    public String getComplemento() {
        return this.complemento;
    }

    // Adicionando o método para associar o Usuario ao Endereco
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }
}
