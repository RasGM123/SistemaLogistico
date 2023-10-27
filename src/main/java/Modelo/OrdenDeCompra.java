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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdenDeCompra {
    private int id;
    private Date fechaEmision;
    private List<ReglonOrdenDeCompra> renglones;

    public OrdenDeCompra(int id, Date fechaEmision) {
        this.id = id;
        this.fechaEmision = fechaEmision;
        this.renglones = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public List<ReglonOrdenDeCompra> getRenglones() {
        return renglones;
    }

    public void setRenglones(List<ReglonOrdenDeCompra> renglones) {
        this.renglones = renglones;
    }

    public void agregarReglon(ReglonOrdenDeCompra reglon) {
        renglones.add(reglon);
    }

    public void guardarOrdenDeCompra() {
        try {
            // Establecer la conexión con la base de datos
            SQLconexion sq = new SQLconexion();
            Connection conexion = DriverManager.getConnection(sq.getUrl(), sq.getUsuario(), sq.getContrasena());
            // Crear la consulta SQL para insertar una nueva orden de compra
            String consulta = "INSERT INTO OrdenDeCompra (ID, FechaEmision) VALUES (?, ?)";

            // Preparar la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            // Establecer los valores de los parámetros de la consulta
            statement.setInt(1, this.id);
            statement.setDate(2, new java.sql.Date(this.fechaEmision.getTime()));

            // Ejecutar la consulta
            statement.executeUpdate();

            // Guardar los renglones de la orden de compra en la base de datos
            for (ReglonOrdenDeCompra reglon : renglones) {
                reglon.guardarReglonOrdenDeCompra(this.id, reglon.getId());
            }

            // Cerrar la conexión con la base de datos
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}