package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.factory.ConexaoFactory;

public class FornecedoresDAO {

	public void salvar(Fornecedores f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fornecedores");
		sql.append("(descricao)");
		sql.append("VALUES (?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.executeUpdate();
	}

	public void excluir(Fornecedores f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM FORNECEDORES ");
		sql.append("WHERE CODIGO = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());
		comando.executeUpdate();
	}

	public void editar(Fornecedores f) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("UPDATE FORNECEDORES ");
		sql.append("SET DESCRICAO = ? ");
		sql.append("WHERE CODIGO = ?");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.setLong(2, f.getCodigo());
		comando.executeUpdate();

	}

	public Fornecedores buscaPorCodigo(Fornecedores f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM FORNECEDORES ");
		sql.append("WHERE CODIGO = ?");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());

		ResultSet resultado = comando.executeQuery();
		Fornecedores retorno = null;
		if (resultado.next()) {
			retorno = new Fornecedores();
			retorno.setCodigo(resultado.getInt("CODIGO"));
			retorno.setDescricao(resultado.getString("DESCRICAO"));
		}

		return retorno;
	}

	public ArrayList<Fornecedores> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM FORNECEDORES ");
		sql.append("ORDER BY CODIGO ASC");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Fornecedores> lista = new ArrayList<Fornecedores>();

		while (resultado.next()) {
			Fornecedores f = new Fornecedores();
			f.setCodigo(resultado.getInt("CODIGO"));
			f.setDescricao(resultado.getString("DESCRICAO"));

			lista.add(f);
		}

		return lista;

	}

	public ArrayList<Fornecedores> buscarPorDescricao(Fornecedores f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM FORNECEDORES ");
		sql.append("WHERE DESCRICAO LIKE ? ");
		sql.append("ORDER BY DESCRICAO ASC");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, "%" + f.getDescricao() + "%");
		
		ResultSet resultado = comando.executeQuery();

		ArrayList<Fornecedores> lista = new ArrayList<Fornecedores>();

		while (resultado.next()) {
			Fornecedores fornecedores = new Fornecedores();
			fornecedores.setCodigo(resultado.getInt("CODIGO"));
			fornecedores.setDescricao(resultado.getString("DESCRICAO"));

			lista.add(fornecedores);
		}

		return lista;
	}

	public static void main(String[] args) {

//TESTE SALVAR
		/*
		  Fornecedores f1 = new Fornecedores(); f1.setDescricao("MARIA CLARA MENDON�A");
		  
		  Fornecedores f2 = new Fornecedores(); f2.setDescricao("GUILHERME LUIZ DA SILVA");
		  
		  FornecedoresDAO fdao = new FornecedoresDAO();
		  
		  try { 
		  fdao.salvar(f1); 
		  fdao.salvar(f2); 
		  System.out.println(
		  "Salvo com sucesso"); } catch (SQLException e) { System.out.println(
		  "Erro ao salvar"); e.printStackTrace(); }
		 
*/
//TESTE EXCLUIR
		/*
		 * Fornecedores f1 = new Fornecedores(); f1.setCodigo(3L);
		 * 
		 * FornecedoresDAO fdao = new FornecedoresDAO();
		 * 
		 * try { fdao.excluir(f1); System.out.println("Deletado com sucesso"); } catch
		 * (SQLException e) { System.out.println("Erro ao deletar");
		 * e.printStackTrace(); }
		 */

//TESTE EDITAR
		/*
		 * Fornecedores f1 = new Fornecedores();
		 * f1.setDescricao("RODRIGO EUST�QUIO DUQUE"); f1.setCodigo(1L);
		 * 
		 * FornecedoresDAO fdao = new FornecedoresDAO();
		 * 
		 * try { fdao.editar(f1); System.out.println("Editado com sucesso"); } catch
		 * (SQLException e) { System.out.println("Erro ao editar"); e.printStackTrace();
		 * }
		 */

//TESTE BUSCA POR CODIGO		
		/*
		 * Fornecedores f1 = new Fornecedores(); f1.setCodigo(2L);
		 * 
		 * 
		 * FornecedoresDAO fdao = new FornecedoresDAO();
		 * 
		 * try { fdao.buscaPorCodigo(f1);
		 * System.out.println("Busca Realizada com Sucesso");
		 * 
		 * System.out.println(); } catch (SQLException e) {
		 * System.out.println("Erro ao buscar"); e.printStackTrace(); }
		 */

// TESTE LISTAR
		/*
		 * FornecedoresDAO fdao = new FornecedoresDAO();
		 * 
		 * try {
		 * 
		 * ArrayList<Fornecedores> lista = fdao.listar();
		 * System.out.println("Listando ..."); for (Fornecedores fornecedores : lista) {
		 * System.out.println(fornecedores); System.out.println(); }
		 * 
		 * } catch (SQLException e) { System.out.println("Erro ao listar");
		 * e.printStackTrace(); }
		 */
		
// TESTE BUSCA POR DESCRICAO
/*		
		Fornecedores f1 = new Fornecedores();
		f1.setDescricao("ROD");
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		
		try {

			ArrayList<Fornecedores> lista = fdao.buscarPorDescricao(f1);
			System.out.println("Listando por Descricao...");
			for (Fornecedores fornecedores : lista) {
				System.out.println(fornecedores);
				System.out.println();
			}

		} catch (SQLException e) {
			System.out.println("Erro ao listar");
			e.printStackTrace();
		}
*/
	}
}
