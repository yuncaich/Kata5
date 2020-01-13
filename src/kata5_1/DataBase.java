package kata5_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBase {
    private String url;
    Connection connection = null;

    public DataBase(String url) {
        this.url = url;
    }

    void open() {
        try {
            this.connection = DriverManager.getConnection(this.url);
            System.out.println("Base de Datos abierta...");
        } catch (SQLException ex) {
            System.out.println("ERROR DataBase::open (SQLException) " + ex.getMessage());
        }
    }

    void close() {
        if (this.connection != null) {
            try {
                this.connection.close();
                System.out.println("Base de Datos cerrada...");
            } catch (SQLException ex) {
                System.out.println("ERROR DataBase::close (SQLException) " + ex.getMessage());
            }
        }
    }

    void select_PERSONAS() {
        String SQL = "SELECT * FROM prueba";
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultset = statement.executeQuery(SQL);
            
            System.out.println("ID \t NOMBRE \t APELLIDOS \t DEPARTAMENTO");
            System.out.println("-- \t ------ \t --------- \t ------------");
            while(resultset.next()) {
                System.out.println(resultset.getInt("ID") + " \t" +
                                   resultset.getString("NAME") + " \t" +
                                   resultset.getString("APELLIDOS") + " \t" +
                                   resultset.getString("DEPARTAMENTO") + " \t" );
            }   
            
        } catch (SQLException ex) {
            System.out.println("ERROR DataBase::SELECT_PERSONAS (SQLException) " + ex.getMessage());
        }
    }

    void insert_PERSONAS(People people) {
        String SQL = "INSERT INTO PRUEBA (NAME, APELLIDOS, DEPARTAMENTO) VALUES(?,?,?)";
        
        try {
            PreparedStatement preparedstatement = this.connection.prepareStatement(SQL);
            preparedstatement.setString(1, people.getNombre());
            preparedstatement.setString(2, people.getApellidos());
            preparedstatement.setString(3, people.getDepartamento());
            preparedstatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR DataBase::INSERT_PERSONAS (SQLException) " + ex.getMessage());
        }
        
        
        
    }
    
    
}