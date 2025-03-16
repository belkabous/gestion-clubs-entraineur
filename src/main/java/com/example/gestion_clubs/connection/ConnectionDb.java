package com.example.gestion_clubs.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class ConnectionDb {

        public static Connection  getconnectiondb() throws SQLException, ClassNotFoundException {



            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionclub","root","");

            return connection;
        }



}
