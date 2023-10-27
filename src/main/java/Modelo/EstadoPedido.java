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

public class EstadoPedido {
    private int id;
    private String nombre;

    public EstadoPedido(int id, String nombre) {
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

    public void actualizarEstadoPedido(int pedidoID, int estadoID) {
        try {
            // Establecer la conexión con la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/nombre_de_la_base_de_datos", "usuario", "contraseña");

            // Crear la consulta SQL para actualizar el estado del pedido
            String consulta = "UPDATE Pedido SET EstadoID = ? WHERE ID = ?";

            // Preparar la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            // Establecer los valores de los parámetros de la consulta
            statement.setInt(1, estadoID);
            statement.setInt(2, pedidoID);

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la conexión con la base de datos
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
