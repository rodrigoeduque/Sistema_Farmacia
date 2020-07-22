package br.com.farmacia.domain;

public class Fornecedores {

	private Integer codigo;
	private String descricao;

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

	@Override
	public String toString() {
		return "Codigo = " + codigo + " Descricao=" + descricao;
	}
	
	

}
