package repository;

import model.Angajat;
import service.DatabaseService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AngajatRepositoryImpl implements AngajatRepository {


    private List<Angajat> angajati = new ArrayList<>();

    @Override
    public Optional<Angajat> find(String nume, String prenume) {
        String sql = "SELECT * FROM angajati WHERE nume = ? AND prenume = ?";

        try (Connection connection = DatabaseService.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, nume);
            statement.setString(2, prenume);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Angajat angajat = new Angajat(
                        resultSet.getInt("id"),
                        resultSet.getString("nume"),
                        resultSet.getString("prenume"),
                        resultSet.getString("email"),
                        resultSet.getString("adresa")
                );

                return Optional.of(angajat);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Angajat> findAll() {
        String sql = "SELECT * FROM angajati";

        try (Connection connection = DatabaseService.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            List<Angajat> angajati = new ArrayList<>();

            while (resultSet.next()) {
                Angajat angajat = new Angajat(
                        resultSet.getInt("id"),
                        resultSet.getString("nume"),
                        resultSet.getString("prenume"),
                        resultSet.getString("email"),
                        resultSet.getString("adresa")
                );

                angajati.add(angajat);
            }

            return angajati;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public void save(Angajat angajat) {
        String sql = "INSERT INTO angajati VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseService.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, angajat.getId());
            statement.setString(2, angajat.getNume());
            statement.setString(3, angajat.getPrenume());
            statement.setString(4, angajat.getEmail());
            statement.setString(5, angajat.getAdresa());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Angajat angajat) {
        String sql = "UPDATE angajati SET nume = ?, prenume = ?, email = ?, adresa = ? WHERE id = ?";

        try (Connection connection = DatabaseService.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, angajat.getNume());
            statement.setString(2, angajat.getPrenume());
            statement.setString(3, angajat.getEmail());
            statement.setString(4, angajat.getAdresa());
            statement.setInt(5, angajat.getId());

            System.out.println("Updating angajat: " + angajat); // print the updated Angajat object
            System.out.println("SQL query: " + sql); // print the SQL query

            int rowsUpdated = statement.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated); // print the number of rows updated

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(Angajat angajat) {
        String sql = "DELETE FROM angajati WHERE id = ?";

        try (Connection connection = DatabaseService.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, angajat.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}