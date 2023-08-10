package com.dao.imp;

import com.dao.IDao;
import com.model.Odontologo;

import java.sql.*;
import java.util.ArrayList;

public class OdontoDaoImpH2 implements IDao<Odontologo> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    //con la instruccion INIT=RUNSCRIPT cuando se conecta a la base ejecuta el script de sql que esta en dicho archivo
    private final static String DB_URL = "jdbc:h2:~/db_odontologo;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER ="eliCaro";
    private final static String DB_PASSWORD = "123";


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("INSERT INTO ODONTOLOGO (MATRICULA, NOMBRE, APELLIDO) VALUES (?,?,?)");
            preparedStatement.setInt(1, odontologo.getMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.executeUpdate();

            ResultSet Key = preparedStatement.getGeneratedKeys();
            if(Key.next()){
                int keyGenerated = Key.getInt(1);
                odontologo.setId(keyGenerated);
            }
            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return odontologo;

    }

    @Override
    public ArrayList<Odontologo> listar() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Odontologo> Odontologos = new ArrayList<>();

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGO;");

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                int matricula = rs.getInt("matricula");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                Odontologo od = new Odontologo(id, matricula, nombre, apellido);
                Odontologos.add(od);
            }
            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return Odontologos;
    }
}
