package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	public ArrayList<Produtos> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT P.CODIGO, P.DESCRICAO, P.QUANTIDADE, P.PRECO, F.CODIGO, F.DESCRICAO ");
		sql.append("FROM PRODUTOS P  ");
		sql.append("INNER JOIN FORNECEDORES F  ON F.CODIGO = P.FORNECEDORES_CODIGO");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Produtos> lista = new ArrayList<Produtos>();

		while (resultado.next()) {

			Fornecedores f = new Fornecedores();

			f.setCodigo(resultado.getInt("F.CODIGO"));
			f.setDescricao(resultado.getString("F.DESCRICAO"));

			Produtos p = new Produtos();

			p.setCodigo(resultado.getInt("P.CODIGO"));
			p.setDescricao(resultado.getString("P.DESCRICAO"));
			p.setQuantidade(resultado.getInt("P.QUANTIDADE"));
			p.setPreco(resultado.getDouble("P.PRECO"));
			p.setFornecedores(f);

			lista.add(p);
		}

		return lista;

	}

}
