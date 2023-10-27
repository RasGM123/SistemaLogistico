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

public class Existencia {
    private int id;
    private int cantidad;
    private int productoId;

    public Existencia(int id, int cantidad, int productoId) {
        this.id = id;
        this.cantidad = cantidad;
        this.productoId = productoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public void aumentarCantidad(int cantidad) {
        try {
            // Establecer la conexión con la base de datos
            SQLconexion sq = new SQLconexion();
            Connection conexion = DriverManager.getConnection(sq.getUrl(), sq.getUsuario(), sq.getContrasena());
            // Crear la consulta SQL para aumentar la cantidad de existencias
            String consulta = "UPDATE Existencia SET Cantidad = Cantidad + ? WHERE ID = ?";

            // Preparar la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            // Establecer los valores de los parámetros de la consulta
            statement.setInt(1, cantidad);
            statement.setInt(2, this.id);

            // Ejecutar la consulta
            statement.executeUpdate();

            // Actualizar la cantidad de existencias en la instancia actual de la clase Existencia
            this.cantidad += cantidad;

            // Cerrar la conexión con la base de datos
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void reducirCantidad(int cantidad) {
        try {
            // Establecer la conexión con la base de datos
            SQLconexion sq = new SQLconexion();
            Connection conexion = DriverManager.getConnection(sq.getUrl(), sq.getUsuario(), sq.getContrasena());
            // Crear la consulta SQL para reducir la cantidad de existencias
            String consulta = "UPDATE Existencia SET Cantidad = Cantidad - ? WHERE ID = ?";

            // Preparar la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            // Establecer los valores de los parámetros de la consulta
            statement.setInt(1, cantidad);
            statement.setInt(2, this.id);

            // Ejecutar la consulta
            statement.executeUpdate();

            // Actualizar la cantidad de existencias en la instancia actual de la clase Existencia
            this.cantidad -= cantidad;

            // Cerrar la conexión con la base de datos
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

