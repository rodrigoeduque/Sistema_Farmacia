package br.com.farmacia.test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import br.com.farmacia.DAO.ProdutosDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;

public class ProdutoDAOTeste {

	// TESTE SALVAR PRODUTOS

	// @Test
	public void salvar() throws SQLException {

		Produtos p1 = new Produtos();
		p1.setDescricao("NEOSALDINA");
		p1.setQuantidade(20);
		p1.setPreco(10.50);

		Fornecedores f1 = new Fornecedores();
		f1.setCodigo(12);
		p1.setFornecedores(f1);

		ProdutosDAO pdao = new ProdutosDAO();

		pdao.salvar(p1);

	}

	// @Test
	public void excluir() throws SQLException {
		Produtos p1 = new Produtos();
		p1.setCodigo(3);

		ProdutosDAO pdao = new ProdutosDAO();
		pdao.excluir(p1);
	}

	// @Test
	public void editar() throws SQLException {
		Produtos p1 = new Produtos();
		p1.setCodigo(6);
		p1.setDescricao("OMEPRAZOL");
		p1.setQuantidade(30);
		p1.setPreco(7.25);

		Fornecedores f1 = new Fornecedores();
		f1.setCodigo(5);
		p1.setFornecedores(f1);

		ProdutosDAO pdao = new ProdutosDAO();

		pdao.editar(p1);
	}

	@Test
	public void buscaPorCodigo() {

		Produtos p1 = new Produtos();
		p1.setCodigo(2);

		ProdutosDAO fdao = new ProdutosDAO();

		try {
			fdao.buscaPorCodigo(p1);
			System.out.println("Busca Realizada com Sucesso");
			System.out.println(p1);

			System.out.println();
		} catch (SQLException e) {
			System.out.println("Erro ao buscar");
			e.printStackTrace();
		}

	}
}
