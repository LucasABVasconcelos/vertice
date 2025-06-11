package model.persistencia;

import java.util.Date;
import model.persistencia.util.TipoUsuario;

public class Usuario {

    private int id_usuario;
    private String nome;
    private String cpf;
    private Date data_nascimento;
    private String telefone;
    private TipoUsuario tipo_usuario;  // Aqui usamos o enum TipoUsuario
    private String senha_hash;
    private String otp_ativo;
    private Date otp_expiracao;
    private Endereco endereco;

    // Métodos getters e setters para os atributos

    public boolean setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
        return true;
    }

    public int getId_usuario() {
        return this.id_usuario;
    }

    public boolean setNome(String nome) {
        this.nome = nome;
        return true;
    }

    public String getNome() {
        return this.nome;
    }

    public boolean setCpf(String cpf) {
        this.cpf = cpf;
        return true;
    }

    public String getCpf() {
        return this.cpf;
    }

    public boolean setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
        return true;
    }

    public Date getData_nascimento() {
        return this.data_nascimento;
    }

    public boolean setTelefone(String telefone) {
        this.telefone = telefone;
        return true;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public boolean setTipo_usuario(TipoUsuario tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
        return true;
    }

    public TipoUsuario getTipo_usuario() {
        return this.tipo_usuario;
    }

    public boolean setSenha_hash(String senha_hash) {
        this.senha_hash = senha_hash;
        return true;
    }

    public String getSenha_hash() {
        return this.senha_hash;
    }

    public boolean setOtp_ativo(String otp_ativo) {
        this.otp_ativo = otp_ativo;
        return true;
    }

    public String getOtp_ativo() {
        return this.otp_ativo;
    }

    public boolean setOtp_expiracao(Date otp_expiracao) {
        this.otp_expiracao = otp_expiracao;
        return true;
    }

    public Date getOtp_expiracao() {
        return this.otp_expiracao;
    }

    public boolean setEndereco(Endereco endereco) {
        this.endereco = endereco;
        return true;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }
}
