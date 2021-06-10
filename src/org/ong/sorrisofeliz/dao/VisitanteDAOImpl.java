package org.ong.sorrisofeliz.dao;

import org.ong.sorrisofeliz.entidade.Visitante;

import java.sql.*;
import java.util.List;

public class VisitanteDAOImpl implements VisitanteDAO{

    private static final String URL = "jdbc:mariadb://localhost:3306/ongdb?allowMultiQueries=true";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    @Override
    public void adicionar(Visitante visitante) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
            String sql = "INSERT INTO visitante " +
                    "(nome, cpf, rg, telefone, data_nascimento, numero, paciente) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, visitante.getNome());
            statement.setString(2, visitante.getCpf());
            statement.setString(3, visitante.getRg());
            statement.setString(4, visitante.getTelefone());
            statement.setDate(5, Date.valueOf(visitante.getDataNascimento()));
            statement.setLong(6,visitante.getNumero());
            statement.setBoolean(7, visitante.isPaciente());
            int i = statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Visitante> pesquisarPorNome(String nome) {
        return null;
    }
}
