package entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Carros {
	 	@Id
	    @GeneratedValue
	    private int id;
	 	private String placa;
	 	private int renavam;
	
		@Column(name="Modelo_Carro")
	 	private String modelo;
	 	@Column(name="Cor_Carro")
	 	private String cor;
	 	@Column(name="Ano_fabricacao")
	 	private int anoFabricacao; 
	 	@Column(name="Ano_modelo")
	 	private int anoModelo;
	 	@Column(name="Valor_Diaria")
	 	private Double valorDiaria;
	 	@Column(name="Data_Cadastro")
	 	private Date DataCadastro;
	 	@Column(name="Descricao_Carro")
	 	private String Descricao_Carro;
	 	@Column(name="Marca_Carro")
	 	private String marca;
	 	
	 	 	
	 	
	 		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		@Column(unique=true, nullable=false, length=8)
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
		
		public Double getValorDiaria() {
			return valorDiaria;
		}
		public void setValorDiaria(Double valorDiaria) {
			this.valorDiaria = valorDiaria;
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
			return Descricao_Carro;
		}
		public void setDescricao_Carro(String descricao_Carro) {
			Descricao_Carro = descricao_Carro;
		}
	 	
		public String getMarca() {
			return marca;
		}
		public void setMarca(String marca) {
			this.marca = marca;
		}

}