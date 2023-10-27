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

public class Entrega {
    private Date fecha;
    private int calificacion;
    private String comentario;

    public Entrega(Date fecha, int calificacion, String comentario) {
        this.fecha = fecha;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void guardarEntrega() {
        try {
            // Establecer la conexión con la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/nombre_de_la_base_de_datos", "usuario", "contraseña");

            // Crear la consulta SQL para insertar una nueva entrega
            String consulta = "INSERT INTO Entrega (Fecha, Calificacion, Comentario) VALUES (?, ?, ?)";

            // Preparar la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            // Establecer los valores de los parámetros de la consulta
            statement.setDate(1, new java.sql.Date(this.fecha.getTime()));
            statement.setInt(2, this.calificacion);
            statement.setString(3, this.comentario);

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la conexión con la base de datos
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarEntrega() {
        try {
            // Establecer la conexión con la base de datos
            SQLconexion sq = new SQLconexion();
            Connection conexion = DriverManager.getConnection(sq.getUrl(), sq.getUsuario(), sq.getContrasena());

            // Crear la consulta SQL para actualizar una entrega existente
            String consulta = "UPDATE Entrega SET Calificacion = ?, Comentario = ? WHERE Fecha = ?";

            // Preparar la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            // Establecer los valores de los parámetros de la consulta
            statement.setInt(1, this.calificacion);
            statement.setString(2, this.comentario);
            statement.setDate(3, new java.sql.Date(this.fecha.getTime()));

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la conexión con la base de datos
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
