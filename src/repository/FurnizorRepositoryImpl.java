package repository;

import model.Furnizor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FurnizorRepositoryImpl implements FurnizorRepository {

    private final String URL = "jdbc:oracle:thin:@localhost:1522:xe";
    private final String USERNAME = "c##pao";
    private final String PASSWORD = "27042003";

    @Override
    public Optional<Furnizor> find(String nume) {
        String sql = "SELECT * FROM furnizori WHERE nume = ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, nume);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Furnizor furnizor = new Furnizor(
                        resultSet.getInt("id"),
                        resultSet.getString("nume"),
                        resultSet.getString("adresa"),
                        resultSet.getString("telefon")
                );

                return Optional.of(furnizor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Furnizor findFurnizorById(int id) {
        String sql = "SELECT * FROM furnizori WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Furnizor(
                        resultSet.getInt("id"),
                        resultSet.getString("nume"),
                        resultSet.getString("adresa"),
                        resultSet.getString("telefon")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Furnizor(0, "", "", "");
    }

    @Override
    public List<Furnizor> findAll() {
        String sql = "SELECT * FROM furnizori";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            List<Furnizor> furnizori = new ArrayList<>();

            while (resultSet.next()) {
                Furnizor furnizor = new Furnizor(
                        resultSet.getInt("id"),
                        resultSet.getString("nume"),
                        resultSet.getString("adresa"),
                        resultSet.getString("telefon")
                );

                furnizori.add(furnizor);
            }

            return furnizori;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public void save(Furnizor furnizor) {
        String sql = "INSERT INTO furnizori VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, furnizor.getId());
            statement.setString(2, furnizor.getNume());
            statement.setString(3, furnizor.getAdresa());
            statement.setString(4, furnizor.getTelefon());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Furnizor furnizor) {
        String sql = "UPDATE furnizori SET nume = ?, adresa = ?, telefon = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, furnizor.getNume());
            statement.setString(2, furnizor.getAdresa());
            statement.setString(3, furnizor.getTelefon());

            statement.setInt(4, furnizor.getId());

            int rowsUpdated = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Furnizor furnizor) {
        String sql = "DELETE FROM furnizori WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, furnizor.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}