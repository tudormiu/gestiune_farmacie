package repository;

import model.Client;
import service.DatabaseService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientRepositoryImpl implements ClientRepository {

    @Override
    public Optional<Client> find(String nume, String prenume) {
        String sql = "SELECT * FROM clienti WHERE nume = ? AND prenume = ?";

        try (Connection connection = DatabaseService.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, nume);
            statement.setString(2, prenume);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Client client = new Client(
                        resultSet.getInt("id"),
                        resultSet.getString("nume"),
                        resultSet.getString("prenume"),
                        resultSet.getString("telefon"),
                        resultSet.getString("adresa")
                );

                return Optional.of(client);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Client> findAll() {
        String sql = "SELECT * FROM clienti";

        try (Connection connection = DatabaseService.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            List<Client> clienti = new ArrayList<>();

            while (resultSet.next()) {
                Client client = new Client(
                        resultSet.getInt("id"),
                        resultSet.getString("nume"),
                        resultSet.getString("prenume"),
                        resultSet.getString("telefon"),
                        resultSet.getString("adresa")
                );

                clienti.add(client);
            }

            return clienti;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public void save(Client client) {
        String sql = "INSERT INTO clienti VALUES (?, ?, ?, ?, ?)"; // Adjust the SQL query as necessary

        try (Connection connection = DatabaseService.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, client.getId());
            statement.setString(2, client.getNume());
            statement.setString(3, client.getPrenume());
            statement.setString(4, client.getTelefon());
            statement.setString(5, client.getAdresa());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Client client) {
        String sql = "UPDATE clienti SET nume = ?, prenume = ?, telefon = ?, adresa = ? WHERE id = ?"; // Adjust the SQL query as necessary

        try (Connection connection = DatabaseService.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, client.getNume());
            statement.setString(2, client.getPrenume());
            statement.setString(3, client.getTelefon());
            statement.setString(4, client.getAdresa());

            statement.setInt(5, client.getId());

            System.out.println(statement);

            int rowsUpdated = statement.executeUpdate();

            System.out.println("Rows updated: " + rowsUpdated);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Client client) {
        String sql = "DELETE FROM clienti WHERE id = ?";

        try (Connection connection = DatabaseService.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, client.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}