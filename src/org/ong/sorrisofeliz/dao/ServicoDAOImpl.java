package org.ong.sorrisofeliz.dao;

import org.ong.sorrisofeliz.entidade.Servico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicoDAOImpl implements ServicoDAO{

    private static final String URL = "jdbc:mariadb://localhost:3306/ongdb?allowMultiQueries=true";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    @Override
    public void adicionar(Servico servico) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
            String sql = "INSERT INTO servico " +
                    "(nome, descricao) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, servico.getNome());
            statement.setString(2, servico.getDescricao());
            int i = statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Servico> pesquisarPorServico(String nome) {
        List<Servico> servicoList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
            String sql = "SELECT * FROM servico WHERE nome LIKE ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + nome + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Servico servico = new Servico();
                servico.setId(resultSet.getLong("id"));
                servico.setNome(resultSet.getString("nome"));
                servico.setDescricao(resultSet.getString("descricao"));
                servicoList.add(servico);
            }
        }catch (SQLException e ){
            e.printStackTrace();
        }
        return servicoList;
    }
}
