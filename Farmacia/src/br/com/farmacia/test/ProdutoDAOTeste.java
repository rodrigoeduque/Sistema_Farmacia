package br.com.farmacia.test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.farmacia.DAO.ProdutosDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;

public class ProdutoDAOTeste {

	// TESTE SALVAR PRODUTOS

	@Test
	@Ignore
	public void salvar() throws SQLException {

		Produtos p1 = new Produtos();
		p1.setDescricao("OMEPRAZOL");
		p1.setQuantidade(5);
		p1.setPreco(12.0);

		Fornecedores f1 = new Fornecedores();
		f1.setCodigo(1);
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

	// TESTE LISTAR
	@Test
	
	public void listar() throws SQLException {
		ProdutosDAO pdao = new ProdutosDAO();

		try {

			ArrayList<Produtos> lista = pdao.listar();
			System.out.println("Listando ...");
			for (Produtos produtos : lista) {
				System.out.println(produtos);
				System.out.println();
			}

		} catch (SQLException e) {
			System.out.println("Erro ao listar");
			e.printStackTrace();
		}
	}

}
