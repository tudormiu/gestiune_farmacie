package repository;

import model.Furnizor;
import model.Medicament;
import model.Comprimate;
import model.Fiole;
import model.Sirop;
import service.DatabaseService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MedicamentRepositoryImpl implements MedicamentRepository {

    @Override
    public Optional<Medicament> find(String denumire) {
        // TODO
        return Optional.empty();
    }

    @Override
    public List<Medicament> findAll() {
        //return all id from Medicament
        List<Medicament> medicamente = new ArrayList<>();
        String sql = "SELECT * FROM Medicament";

try (Connection connection = DatabaseService.getInstance().getConnection();
     PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String denumire = resultSet.getString("denumire");
                int furnizorId = resultSet.getInt("furnizor");
                double pret = resultSet.getDouble("pret");
                int stoc = resultSet.getInt("stoc");
                String tip = resultSet.getString("tip");

                if(tip.equals("model.Fiole")) {
                    sql = "SELECT * FROM Fiole WHERE id = ?";
                    try (PreparedStatement statementFiole = connection.prepareStatement(sql)) {
                        statementFiole.setInt(1, id);
                        ResultSet resultSetFiole = statementFiole.executeQuery();
                        if (resultSetFiole.next()) {
                            float volum = resultSetFiole.getFloat("volum");
                            int numarFiole = resultSetFiole.getInt("numar_fiole");
                            medicamente.add(new Fiole(id, denumire, new FurnizorRepositoryImpl().findFurnizorById(furnizorId), pret, stoc, volum, numarFiole));
                        }
                    }
                } else if(tip.equals("model.Comprimate")) {
                    sql = "SELECT * FROM Comprimate WHERE id = ?";
                    try (PreparedStatement statementComprimate = connection.prepareStatement(sql)) {
                        statementComprimate.setInt(1, id);
                        ResultSet resultSetComprimate = statementComprimate.executeQuery();
                        if (resultSetComprimate.next()) {
                            int numarComprimate = resultSetComprimate.getInt("numar_comprimate");
                            int miligrame = resultSetComprimate.getInt("miligrame");
                            medicamente.add(new Comprimate(id, denumire, new FurnizorRepositoryImpl().findFurnizorById(furnizorId), pret, stoc, numarComprimate, miligrame));
                        }
                    }
                } else if(tip.equals("model.Sirop")) {
                    sql = "SELECT * FROM Sirop WHERE id = ?";
                    try (PreparedStatement statementSirop = connection.prepareStatement(sql)) {
                        statementSirop.setInt(1, id);
                        ResultSet resultSetSirop = statementSirop.executeQuery();
                        if (resultSetSirop.next()) {
                            int mililitri = resultSetSirop.getInt("mililitri");
                            medicamente.add(new Sirop(id, denumire, new FurnizorRepositoryImpl().findFurnizorById(furnizorId), pret, stoc, mililitri));
                        }
                    }
                } else {
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicamente;
    }

    @Override
    public void save(Medicament medicament) {
        String sql = "INSERT INTO Medicament VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseService.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, medicament.getId());
            statement.setString(2, medicament.getDenumire());
            statement.setInt(3, medicament.getFurnizor().getId());
            statement.setDouble(4, medicament.getPret());
            statement.setInt(5, medicament.getStoc());
            statement.setString(6, medicament.getTip());

            statement.executeUpdate();

            if (medicament instanceof Fiole) {
                Fiole fiole = (Fiole) medicament;

                sql = "INSERT INTO Fiole VALUES (?, ?, ?)";

                try (PreparedStatement statementFiole = connection.prepareStatement(sql)) {
                    statementFiole.setInt(1, medicament.getId());
                    statementFiole.setFloat(2, fiole.getVolum());
                    statementFiole.setInt(3, fiole.getNumarFiole());

                    statementFiole.executeUpdate();
                }
            } else if (medicament instanceof Comprimate) {
                Comprimate comprimate = (Comprimate) medicament;

                sql = "INSERT INTO Comprimate VALUES (?, ?, ?)";

                try (PreparedStatement statementComprimate = connection.prepareStatement(sql)) {
                    statementComprimate.setInt(1, comprimate.getId());
                    statementComprimate.setInt(2, comprimate.getNumarComprimate());
                    statementComprimate.setInt(3, comprimate.getMiligrame());

                    statementComprimate.executeUpdate();
                }
            } else if (medicament instanceof Sirop) {
                Sirop sirop = (Sirop) medicament;

                sql = "INSERT INTO Sirop VALUES (?, ?)";

                try (PreparedStatement statementSirop = connection.prepareStatement(sql)) {
                    statementSirop.setInt(1, sirop.getId());
                    statementSirop.setInt(2, sirop.getMililitri());

                    statementSirop.executeUpdate();
                }
            } else {
                throw new IllegalArgumentException("Invalid type");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Medicament medicament) {
        String sql = "UPDATE Medicament SET denumire = ?, furnizor = ?, pret = ?, stoc = ?, tip = ? WHERE id = ?";

        try (Connection connection = DatabaseService.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, medicament.getDenumire());
            statement.setInt(2, medicament.getFurnizor().getId());
            statement.setDouble(3, medicament.getPret());
            statement.setInt(4, medicament.getStoc());
            statement.setString(5, medicament.getTip());
            statement.setInt(6, medicament.getId());

            statement.executeUpdate();

            if (medicament instanceof Fiole) {
                Fiole fiole = (Fiole) medicament;

                sql = "UPDATE Fiole SET volum = ?, numar_fiole = ? WHERE id = ?";

                try (PreparedStatement statementFiole = connection.prepareStatement(sql)) {
                    statementFiole.setFloat(1, fiole.getVolum());
                    statementFiole.setInt(2, fiole.getNumarFiole());
                    statementFiole.setInt(3, fiole.getId());

                    statementFiole.executeUpdate();
                }
            } else if (medicament instanceof Comprimate) {
                Comprimate comprimate = (Comprimate) medicament;

                sql = "UPDATE Comprimate SET numar_comprimate = ?, miligrame = ? WHERE id = ?";

                try (PreparedStatement statementComprimate = connection.prepareStatement(sql)) {
                    statementComprimate.setInt(1, comprimate.getNumarComprimate());
                    statementComprimate.setInt(2, comprimate.getMiligrame());
                    statementComprimate.setInt(3, comprimate.getId());

                    statementComprimate.executeUpdate();
                }
            } else if (medicament instanceof Sirop) {
                Sirop sirop = (Sirop) medicament;

                sql = "UPDATE Sirop SET mililitri = ? WHERE id = ?";

                try (PreparedStatement statementSirop = connection.prepareStatement(sql)) {
                    statementSirop.setInt(1, sirop.getMililitri());
                    statementSirop.setInt(2, sirop.getId());

                    statementSirop.executeUpdate();
                }
            } else {
                throw new IllegalArgumentException("Invalid type");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Medicament medicament) {
        String sql = "DELETE FROM Medicament WHERE id = ?";

        try (Connection connection = DatabaseService.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, medicament.getId());

            String tip = medicament.getTip();

            if (tip.equals("model.Fiole")) {
                sql = "DELETE FROM Fiole WHERE id = ?";
                try (PreparedStatement statementFiole = connection.prepareStatement(sql)) {
                    statementFiole.setInt(1, medicament.getId());
                    statementFiole.executeUpdate();
                }
            } else if (tip.equals("model.Comprimate")) {
                sql = "DELETE FROM Comprimate WHERE id = ?";
                try (PreparedStatement statementComprimate = connection.prepareStatement(sql)) {
                    statementComprimate.setInt(1, medicament.getId());
                    statementComprimate.executeUpdate();
                }
            } else if (tip.equals("model.Sirop")) {
                sql = "DELETE FROM Sirop WHERE id = ?";
                try (PreparedStatement statementSirop = connection.prepareStatement(sql)) {
                    statementSirop.setInt(1, medicament.getId());
                    statementSirop.executeUpdate();
                }
            } else {
                throw new IllegalArgumentException("Invalid type");
            }

            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
