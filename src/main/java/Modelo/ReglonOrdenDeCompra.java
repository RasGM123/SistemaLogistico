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

public class ReglonOrdenDeCompra {
    private int id;
    private int cantidad;
    private double precioUnitario;

    public ReglonOrdenDeCompra(int id, int cantidad, double precioUnitario) {
        this.id = id;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
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

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void guardarReglonOrdenDeCompra(int ordenDeCompraId, int productoId) {
        try {
            // Establecer la conexión con la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/nombre_de_la_base_de_datos", "usuario", "contraseña");

            // Crear la consulta SQL para insertar un nuevo renglón de orden de compra
            String consulta = "INSERT INTO ReglonOrdenDeCompra (ID, Cantidad, PrecioUnitario, OrdenDeCompraID, ProductoID) VALUES (?, ?, ?, ?, ?)";

            // Preparar la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            // Establecer los valores de los parámetros de la consulta
            statement.setInt(1, this.id);
            statement.setInt(2, this.cantidad);
            statement.setDouble(3, this.precioUnitario);
            statement.setInt(4, ordenDeCompraId);
            statement.setInt(5, productoId);

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la conexión con la base de datos
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
