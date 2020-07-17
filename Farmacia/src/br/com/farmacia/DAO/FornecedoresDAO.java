package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

	public static void main(String[] args) {
//		Fornecedores f1 = new Fornecedores();
//		f1.setDescricao("DESCRICAO 1");
//		
//		Fornecedores f2 = new Fornecedores();
//		f2.setDescricao("DESCRICAO 2");
//		
//		FornecedoresDAO fdao = new FornecedoresDAO();
//		
//		try {
////			fdao.salvar(f1);
////			fdao.salvar(f2);
//			fdao.excluir(4);
//			System.out.println( "Salvo com sucesso");
//		} catch (SQLException e) {
//			System.out.println( "Erro ao salvar");
//			e.printStackTrace();
//		}

		Fornecedores f1 = new Fornecedores();
		f1.setCodigo((long) 4);

		FornecedoresDAO fdao = new FornecedoresDAO();

		try {
			fdao.excluir(f1);
			System.out.println("Deletado com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro ao deletar");
			e.printStackTrace();
		}

	}
}