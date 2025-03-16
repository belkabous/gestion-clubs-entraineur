package com.example.gestion_clubs.dao;

import com.example.gestion_clubs.connection.ConnectionDb;
import com.example.gestion_clubs.model.Membre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MembreDAO {

    private Connection connection;

    public MembreDAO() throws SQLException, ClassNotFoundException {
        connection= ConnectionDb.getconnectiondb();
    }



    public void save(Membre membre) {
        String query = "INSERT INTO membre (nom_membre, sport_pratiquee) VALUES (?, ?)";

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, membre.getNom_membre());
            preparedStatement.setString(2, membre.getSport_pratiquee());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void update(Membre membre) {
        String query = "UPDATE membre SET sport_pratiquee = ?,nom_membre=? WHERE id_membre = ?";

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, membre.getSport_pratiquee());
            preparedStatement.setString(2, membre.getNom_membre());
            preparedStatement.setInt(3,membre.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Membre> findAll() {
        List<Membre> membres = new ArrayList<>();
        String query = "SELECT * FROM membre";

        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id_membre");
                String nom_membre = resultSet.getString("nom_membre");
                String sport_pratiquee = resultSet.getString("sport_pratiquee");

                Membre membre = new Membre(id,nom_membre, sport_pratiquee);
                membres.add(membre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return membres;
    }


    public Membre findById(int id) {
        String query = "SELECT * FROM membre WHERE id_membre = ?";
        Membre membre = null;

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                String sport_pratiquee = resultSet.getString("sport_pratiquee");
                String nom_membre = resultSet.getString("nom_membre");
                membre = new Membre(nom_membre, sport_pratiquee);
                membre.setId(id);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return membre;
    }


    public void delete(int id) {
        String query = "DELETE FROM membre  WHERE id_membre = ?";

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}