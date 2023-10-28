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
import java.util.Date;

public class Pedido {
    private int id;
    private Date fechaEntrega;

    public Pedido(int id, Date fechaEntrega) {
        this.id = id;
        this.fechaEntrega = fechaEntrega;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public void GenerarRemito() {
        try {
            // Establecer la conexión con la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/nombre_de_la_base_de_datos", "usuario", "contraseña");

            // Crear la consulta SQL para obtener los datos del pedido
            String consulta = "SELECT * FROM Pedido WHERE ID = ?";

            // Preparar la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            // Establecer el valor del parámetro de la consulta
            statement.setInt(1, this.id);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultado = statement.executeQuery();

            // Si se encontró un pedido con el ID especificado, crear un objeto Remito con sus datos y guardarlo en la base de datos
            if (resultado.next()) {
                Remito remito = new Remito(
                    resultado.getInt("ID"),
                    resultado.getDate("FechaEntrega"),
                    resultado.getDouble("Total")
                );
                remito.guardarRemito();
            }

            // Cerrar la conexión con la base de datos
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}