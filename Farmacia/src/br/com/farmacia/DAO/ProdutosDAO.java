package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;
import br.com.farmacia.factory.ConexaoFactory;

public class ProdutosDAO {

	public void salvar(Produtos p) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO PRODUTOS");
		sql.append("(DESCRICAO, QUANTIDADE, PRECO, FORNECEDORES_CODIGO)");
		sql.append("VALUES (?,?,?,?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, p.getDescricao());
		comando.setInt(2, p.getQuantidade());
		comando.setDouble(3, p.getPreco());
		comando.setInt(4, p.getFornecedores().getCodigo());

		comando.executeUpdate();
	}

	public void excluir(Produtos p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM PRODUTOS ");
		sql.append("WHERE CODIGO = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, p.getCodigo());

		comando.executeUpdate();
	}

	public void editar(Produtos p) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("UPDATE PRODUTOS ");
		sql.append("SET DESCRICAO = ? , QUANTIDADE = ?, PRECO = ?, FORNECEDORES_CODIGO = ? ");
		sql.append("WHERE CODIGO = ?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, p.getDescricao());
		comando.setInt(2, p.getQuantidade());
		comando.setDouble(3, p.getPreco());
		comando.setInt(4, p.getFornecedores().getCodigo());
		comando.setInt(5, p.getCodigo());

		comando.executeUpdate();

	}

	public Produtos buscaPorCodigo(Produtos p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM PRODUTOS ");
		sql.append("WHERE CODIGO = ?");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, p.getCodigo());

		ResultSet resultado = comando.executeQuery();

		Produtos retorno = null;

		if (resultado.next()) {
			retorno = new Produtos();

			retorno.setCodigo(resultado.getInt("CODIGO"));
			retorno.setDescricao(resultado.getString("DESCRICAO"));
			retorno.setQuantidade(resultado.getInt("QUANTIDADE"));
			retorno.setPreco(resultado.getDouble("PRECO"));
			retorno.setFornecedores(new Fornecedores()); /* verificar */

		}

		return retorno;
	}

}
