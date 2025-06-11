package model.persistencia;

public class Funcionario extends Usuario {

    private int id_funcionario;
    private String codigo_funcionario;  // Alterado para String, pois o código do funcionário pode ser alfanumérico
    private Cargo cargo;
    private Funcionario supervisor;
    private int id_usuario;

    // Getter e Setter para id_funcionario
    public int getId_funcionario() {
        return this.id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    // Getter e Setter para codigo_funcionario
    public String getCodigo_funcionario() {
        return this.codigo_funcionario;
    }

    public void setCodigo_funcionario(String codigo_funcionario) {
        this.codigo_funcionario = codigo_funcionario;
    }

    // Getter e Setter para cargo
    public Cargo getCargo() {
        return this.cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    // Getter e Setter para supervisor
    public Funcionario getSupervisor() {
        return this.supervisor;
    }

    public void setSupervisor(Funcionario supervisor) {
        this.supervisor = supervisor;
    }

    // Getter e Setter para id_usuario
    public int getIdUsuario() {
        return id_usuario;
    }

    public void setIdUsuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    // Método toString() para retornar os detalhes do funcionário
    public String toString() {
        return "Nome: " + super.getNome() +
               "\ncpf: " + super.getCpf() +
               "\nCargo: " + this.cargo.toString() +
               "\nSupervisor: " + (this.supervisor != null ? this.supervisor.getNome() : "Sem Supervisor");
    }
}
