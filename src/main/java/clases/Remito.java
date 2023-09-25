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

public class Remito {
    private int id;
    private Date FechaEntrega;

    public Remito(int id, Date FechaEntrega, double aDouble) {
        this.id = id;
        this.FechaEntrega = FechaEntrega;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaEntrega() {
        return FechaEntrega;
    }

    public void setFechaEntrega(Date FechaEntrega) {
        this.FechaEntrega = FechaEntrega;
    }

    public void guardarRemito() {
        try {
            // Establecer la conexión con la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/nombre_de_la_base_de_datos", "usuario", "contraseña");

            // Crear la consulta SQL para insertar un nuevo remito
            String consulta = "INSERT INTO Remito (ID, FechaEntrega) VALUES (?, ?)";

            // Preparar la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            // Establecer los valores de los parámetros de la consulta
            statement.setInt(1, this.id);
            statement.setDate(2, new java.sql.Date(this.FechaEntrega.getTime()));

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la conexión con la base de datos
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
