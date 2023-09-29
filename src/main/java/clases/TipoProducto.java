/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Rodrigo
 */
import java.sql.*;

public class TipoProducto {

    static TipoProducto valueOf(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private int id;
    private String nombre;

    public TipoProducto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void guardarTipoProducto() {
        try {
            SQLconexion sq = new SQLconexion();
            // Establecer la conexión con la base de datos
            Connection conexion = DriverManager.getConnection(sq.getUrl(), sq.getUsuario(), sq.getContrasena());

            // Crear la consulta SQL para insertar un nuevo tipo de producto
            String consulta = "INSERT INTO TipoProducto (ID, Nombre) VALUES (?, ?)";

            // Preparar la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            // Establecer los valores de los parámetros de la consulta
            statement.setInt(1, this.id);
            statement.setString(2, this.nombre);

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la conexión con la base de datos
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarTipoProducto() {
        try {
            // Establecer la conexión con la base de datos
            SQLconexion sq = new SQLconexion();
            Connection conexion = DriverManager.getConnection(sq.getUrl(), sq.getUsuario(), sq.getContrasena());
            // Crear la consulta SQL para actualizar un tipo de producto existente
            String consulta = "UPDATE TipoProducto SET Nombre = ? WHERE ID = ?";

            // Preparar la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            // Establecer los valores de los parámetros de la consulta
            statement.setString(1, this.nombre);
            statement.setInt(2, this.id);

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la conexión con la base de datos
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

