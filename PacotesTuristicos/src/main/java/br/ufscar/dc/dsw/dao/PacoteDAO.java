package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import br.ufscar.dc.dsw.domain.Pacote;
import br.ufscar.dc.dsw.domain.Usuario;

public class PacoteDAO extends GenericDAO {
	/* Metodos CRUD para os pacotes turisticos */

	/* 
		C -> create 
	   	Insere novos pacotes turisticos no banco de dados
	*/
	public void insert(Pacote pacote) {

        String sql = "INSERT INTO Pacote (nome, cnpj, cidade, estado, pais, partida, duracao, valor) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setString(1, pacote.getNome());
            statement.setString(2, pacote.getAgencia().getCnpj());
            statement.setString(3, pacote.getCidade());
            statement.setString(4, pacote.getEstado());
            statement.setString(5, pacote.getPais());
            statement.setDate(6, pacote.getPartida());
            statement.setInt(7, pacote.getDuracao());
            statement.setFloat(8, pacote.getValor());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /* 
    	R -> read 
	  	Lista todos os pacotes turisticos do banco de dados
	*/
    public List<Pacote> getAllPacotes() {

        List<Pacote> lista = new ArrayList<>();

        String sql = "SELECT * from Pacote p, Usuario u WHERE p.cnpj = u.cnpj";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                String cnpj = resultSet.getString("cnpj");
                String cidade = resultSet.getString("cidade");
                String estado = resultSet.getString("estado");
                String pais = resultSet.getString("pais");
                Date partida = resultSet.getDate("partida");
                Integer duracao = resultSet.getInt("duracao");
                Float valor = resultSet.getFloat("valor");
                long agencia_id = resultSet.getLong(10);
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String agencia_nome = resultSet.getString(13);
                String papel = resultSet.getString("papel");
                String descricao = resultSet.getString("descricao");
                Usuario agencia = new Usuario(agencia_id, email, senha, agencia_nome, papel, cnpj, descricao);
                Pacote pacote = new Pacote(id, nome, agencia, cidade, estado, pais, partida, duracao, valor);
                lista.add(pacote);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public List<Pacote> getAllPacotesAgencia(Usuario usuario) {

        List<Pacote> lista = new ArrayList<>();

        String sql = "SELECT * from Pacote p, Usuario u WHERE u.id = ? AND p.cnpj = u.cnpj";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            Long id = usuario.getId();

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String cnpj = resultSet.getString("cnpj");
                String cidade = resultSet.getString("cidade");
                String estado = resultSet.getString("estado");
                String pais = resultSet.getString("pais");
                Date partida = resultSet.getDate("partida");
                Integer duracao = resultSet.getInt("duracao");
                Float valor = resultSet.getFloat("valor");
                long agencia_id = resultSet.getLong(10);
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String agencia_nome = resultSet.getString(13);
                String papel = resultSet.getString("papel");
                String descricao = resultSet.getString("descricao");
                Usuario agencia = new Usuario(agencia_id, email, senha, agencia_nome, papel, cnpj, descricao);
                Pacote pacote = new Pacote(id, nome, agencia, cidade, estado, pais, partida, duracao, valor);
                lista.add(pacote);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public List<Pacote> getAllPacotesCliente(Usuario usuario) {
        List<Pacote> lista = null;

        return lista;
    }

    /* 
		U -> update
	   	Atualiza pacotes turisticos no banco de dados
	*/
    public void update(Pacote pacote) {
        String sql = "UPDATE Pacote SET nome = ?, cnpj = ?, cidade = ?, estado = ?, pais = ?, partida = ?, duracao = ?, valor = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, pacote.getNome());
            statement.setString(2, pacote.getAgencia().getCnpj());
            statement.setString(3, pacote.getCidade());
            statement.setString(4, pacote.getEstado());
            statement.setString(5, pacote.getPais());
            statement.setDate(6, pacote.getPartida());
            statement.setInt(7, pacote.getDuracao());
            statement.setLong(8, pacote.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /* 
		D -> delete
	   	Remove pacotes turisticos do banco de dados
	*/
    public void delete(Pacote pacote) {
        String sql = "DELETE FROM Pacote where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, pacote.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
        }
    }

    /* Procura pacotes turisticos pelo id */
    public Pacote get(Long id) {
        Pacote pacote = null;

        String sql = "SELECT * from Pacote WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String cnpj = resultSet.getString("cnpj");
                String cidade = resultSet.getString("cidade");
                String estado = resultSet.getString("estado");
                String pais = resultSet.getString("pais");
                Date partida = resultSet.getDate("partida");
                Integer duracao = resultSet.getInt("duracao");
                Float valor = resultSet.getFloat("valor");
                long agencia_id = resultSet.getLong(10);
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String agencia_nome = resultSet.getString(13);
                String papel = resultSet.getString("papel");
                String descricao = resultSet.getString("descricao");
                Usuario agencia = new Usuario(agencia_id, email, senha, agencia_nome, papel, cnpj, descricao);
                pacote = new Pacote(id, nome, agencia, cidade, estado, pais, partida, duracao, valor);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pacote;
    }
}
