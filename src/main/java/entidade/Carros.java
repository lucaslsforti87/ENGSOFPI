package entidade;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Carros {
	 	@Id
	    @GeneratedValue 
	    private int id;
	 	private String placa;
	 	private int renavam;
	 	private String modelo;
	 	private String cor;
	 	@Column(name="ano_fabricacao")
	 	private int anoFabricacao; 
	 	@Column(name="ano_modelo")
	 	private int anoModelo;
	 	private int valor;
	 	private String Descricao;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getPlaca() {
			return placa;
		}
		public void setPlaca(String placa) {
			this.placa = placa;
		}
		public int getRenavam() {
			return renavam;
		}
		public void setRenavam(int renavam) {
			this.renavam = renavam;
		}
		public String getModelo() {
			return modelo;
		}
		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		public String getCor() {
			return cor;
		}
		public void setCor(String cor) {
			this.cor = cor;
		}
		public int getAnoFabricacao() {
			return anoFabricacao;
		}
		public void setAnoFabricacao(int anoFabricacao) {
			this.anoFabricacao = anoFabricacao;
		}
		public int getAnoModelo() {
			return anoModelo;
		}
		public void setAnoModelo(int anoModelo) {
			this.anoModelo = anoModelo;
		}
		public int getValor() {
			return valor;
		}
		public void setValor(int valor) {
			this.valor = valor;
		}
		public String getDescricao() {
			return Descricao;
		}
		public void setDescricao(String descricao) {
			Descricao = descricao;
		} 
	 	
	 	
	 	
	 	
	 

}