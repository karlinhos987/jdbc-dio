package one.digitalinnovation.jdbc.dao;

import one.digitalinnovation.jdbc.entity.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private final Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Cliente> buscarTodosOsClientes() throws SQLException {
        String SQL = "SELECT * FROM cliente";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Cliente> clientes = new ArrayList<>();
        while (resultSet.next()){
            Cliente cliente = new Cliente();
            cliente.setId(resultSet.getInt("id"));
            cliente.setNome(resultSet.getString("nome"));
            clientes.add(cliente);
        }
        return clientes;
    }

    public void inserirNovoCliente(int id, String nome) throws SQLException {
        String SQL = "INSERT INTO cliente(id, nome) values (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,1);
        preparedStatement.setString(2, nome);
        preparedStatement.executeUpdate();
    }
}
