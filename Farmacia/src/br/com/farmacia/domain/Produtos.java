package br.com.farmacia.domain;

public class Produtos {

	private Integer codigo;
	private String descricao;
	private Integer quantidade;
	private Double preco;
	private Fornecedores fornecedores;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Fornecedores getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}

	@Override
	public String toString() {
		return "Cód = " + codigo + ", Descrição =" + descricao + ", Quantidade =" + quantidade + ", Preço ="
				+ preco + ", Fornecedor =" ;
	}
	
	

}
