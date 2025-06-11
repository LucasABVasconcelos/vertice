package model.persistencia;

public class Cliente extends Usuario {

	private int id_cliente;

	private float score_credito;

        public boolean setId_cliente(int id_cliente) {
            this.id_cliente = id_cliente;
            return true;
        }

        public int getId_cliente() {
            return this.id_cliente;
        }

        public boolean setScore_credito(float score_credito) {
            this.score_credito = score_credito;
            return true;
        }

        public float getScore_credito() {
            return this.score_credito;
        }
        
        public String toString(){
            return "Nome: "+super.getNome()+
                   "\n cpf: "+super.getCpf();
        }

}