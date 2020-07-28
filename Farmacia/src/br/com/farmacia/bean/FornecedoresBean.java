package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.util.JSFUtil;

@ManagedBean(name = "MBFornecedores")
@ViewScoped
public class FornecedoresBean {

	private Fornecedores fornecedores;

	private ArrayList<Fornecedores> itens;
	private ArrayList<Fornecedores> itensFiltrados;
	
	private ArrayList<Fornecedores> lista;

	public Fornecedores getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}

	public ArrayList<Fornecedores> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Fornecedores> itens) {
		this.itens = itens;
	}

	public ArrayList<Fornecedores> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Fornecedores> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {

		try {
			FornecedoresDAO fdao = new FornecedoresDAO();

			itens = fdao.listar();

		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();

		}
	}

	public void prepararNovo() {
		fornecedores = new Fornecedores();
	}

	public void novo() {

		try {
			FornecedoresDAO fdao = new FornecedoresDAO();

			fdao.salvar(fornecedores);

			itens = fdao.listar();

			JSFUtil.adicionarMensagemSucesso("Registro Salvo com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}

	}

	public void excluir() {
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();

			fdao.excluir(fornecedores);

			lista = fdao.listar();

			JSFUtil.adicionarMensagemSucesso("Registro Excluido com Sucesso");
			System.out.println("Excluido: " + fornecedores.getDescricao());
			System.out.println(fdao.listar());
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getLocalizedMessage());
		}
	}

	public void editar() {

		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.editar(fornecedores);

			itens = fdao.listar();
			JSFUtil.adicionarMensagemSucesso("Edi��o realizada com sucesso");

		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("Erro" + e.getLocalizedMessage());
			e.printStackTrace();
		}

	}

}
