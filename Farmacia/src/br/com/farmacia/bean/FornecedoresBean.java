package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.util.JSFUtil;

@ManagedBean(name = "MBFornecedores")
@ViewScoped
public class FornecedoresBean {

	private Fornecedores fornecedores;

	public Fornecedores getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}

	private ListDataModel<Fornecedores> itens;

	public ListDataModel<Fornecedores> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Fornecedores> itens) {
		this.itens = itens;
	}

	@PostConstruct
	public void prepararPesquisa() {

		try {
			FornecedoresDAO fdao = new FornecedoresDAO();

			ArrayList<Fornecedores> lista = fdao.listar();

			itens = new ListDataModel<Fornecedores>(lista);

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

			ArrayList<Fornecedores> lista = fdao.listar();

			itens = new ListDataModel<Fornecedores>(lista);
			JSFUtil.adicionarMensagemSucesso("Registro Salvo com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}

	}

	public void prepararExcluir() {
		fornecedores = itens.getRowData();
	}

	public void excluir() {
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();

			fdao.excluir(fornecedores);

			ArrayList<Fornecedores> lista = fdao.listar();
			itens = new ListDataModel<Fornecedores>(lista);

			JSFUtil.adicionarMensagemSucesso("Registro Excluido com Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getLocalizedMessage());
		}
	}
	
	
	
	public void prepararEditar() {
		fornecedores = itens.getRowData();
	}
	
	public void editar() {
		
		
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			ArrayList<Fornecedores> lista = fdao.listar();
			itens = new ListDataModel<Fornecedores>(lista);
			JSFUtil.adicionarMensagemSucesso("Edi��o realizada com sucesso");
			fdao.editar(fornecedores);
			
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getLocalizedMessage());
			e.printStackTrace();
		}
		

		
	}

}
