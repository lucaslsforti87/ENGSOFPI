package entidade;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


//isso aqui 
@Entity
public class Carros implements Serializable {
	private static final long serialVersionUID = 1L; 

	 	@Id
	    @GeneratedValue 
	    @Column(name="id", nullable=false, unique=true)
	    private int id;
	 	
	 	@Column(name="Placa_Carro")
	 	private String placa;
	 	
	 	@Column(name ="Renavam_Carro")
		private int renavam;
	 	
		@Column(name="Modelo_Carro")
	 	private String modelo;
	 	@Column(name="Cor_Carro")
	 	private String cor;
	 	@Column(name="Ano_fabricacao")
	 	private int anoFabricacao; 
	 	@Column(name="Ano_modelo")
	 	private int anoModelo;
	 	@Column(name="Valor_Carro")
	 	private Double valorCarro;
	 	@Column(name="Data_Cadastro")
	 	private Date DataCadastro;
	 	@Column(name="Descricao_Carro")
	 	private String Descricao;
	 	@Column(name="Marca_Carro")
	 	private String Marca;
	 	
	 	 	
	 	
	 		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		public String getplaca() {
		return placa;
		}
		public void setplaca(String placa) {
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
		
		public Double getValorCarro() {
			return valorCarro;
		}
		public void setValorCarro(Double valorDiaria) {
			this.valorCarro = valorDiaria;
		}
		@Temporal(TemporalType.DATE)
		@Column(name="data_cadastro", nullable=false)
		public Date getDataCadastro() {
			return DataCadastro;
		}
		public void setDataCadastro(Date dataCadastro) {
			DataCadastro = dataCadastro;
		}
	 	
		public String getDescricao_Carro() {
			return Descricao;
		}
		public void setDescricao_Carro(String descricao_Carro) {
			Descricao = descricao_Carro;
		}
	 	
		public String getMarca() {
			return Marca;
		}
		public void setMarca(String marca) {
			this.Marca = marca;
		}
		public String getPlaca() {
			return placa;
		}
		public void setPlaca(String placa) {
			this.placa = placa;
		}
		public String getDescricao() {
			return Descricao;
		}
		public void setDescricao(String descricao) {
			Descricao = descricao;
		}

}