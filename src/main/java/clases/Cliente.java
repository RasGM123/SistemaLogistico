/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.List;

/**
 *
 * @author Rodrigo
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private List<TipoProducto> Preferencias;
    private int id;
    private Persona per;
    public Cliente(Persona cliente) {
        this.Preferencias = new ArrayList<TipoProducto>();
        this.per = cliente;
    }

    public List<TipoProducto> getPreferencias() {
        return Preferencias;
    }

    public void setPreferencias(List<TipoProducto> Preferencias) {
        this.Preferencias = Preferencias;
    }
    
    public Persona getPersona(){
        return per;
    }
    
    public int getID(){
        return id;
    }

    public Pedido ConsultarPedido(int id) {
        Pedido pedido = null;

        try {
            // Establecer la conexión con la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/nombre_de_la_base_de_datos", "usuario", "contraseña");

            // Crear la consulta SQL para obtener un pedido por su ID
            String consulta = "SELECT * FROM Pedido WHERE ID = ?";

            // Preparar la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            // Establecer el valor del parámetro de la consulta
            statement.setInt(1, id);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultado = statement.executeQuery();

            // Si se encontró un pedido con el ID especificado, crear un objeto Pedido con sus datos
            if (resultado.next()) {
                Pedido pe = new Pedido(
                    resultado.getInt("ID"),
                    resultado.getDate("Fecha")
                );
            }

            // Cerrar la conexión con la base de datos
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pedido;
    }

    public Pedido[] ConsultarPedidos() {
        List<Pedido> pedidos = new ArrayList<Pedido>();

        try {
            // Establecer la conexión con la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/nombre_de_la_base_de_datos", "usuario", "contraseña");

            // Crear la consulta SQL para obtener todos los pedidos
            String consulta = "SELECT * FROM Pedido";

            // Preparar la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultado = statement.executeQuery();

            // Crear un objeto Pedido con los datos de cada fila del resultado y agregarlo a la lista de pedidos
            while (resultado.next()) {
                Pedido pedido = new Pedido(
                    resultado.getInt("ID"),
                    resultado.getDate("Fecha")
                );
                pedidos.add(pedido);
            }

            // Cerrar la conexión con la base de datos
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Convertir la lista de pedidos a un array y devolverlo
        return pedidos.toArray(new Pedido[0]);
    }

    public String[] ConsultarPreferencias() {
        List<String> preferencias = new ArrayList<String>();

        // Convertir cada TipoDeProducto en un String y agregarlo a la lista de preferencias
        for (TipoProducto tipo : Preferencias) {
            preferencias.add(tipo.toString());
        }

        // Convertir la lista de preferencias a un array y devolverlo
        return preferencias.toArray(new String[0]);
    }

    public void DeterminarPreferencias() {
        try {
            // Establecer la conexión con la base de datos
            SQLconexion sq = new SQLconexion();
            Connection conexion = DriverManager.getConnection(sq.getUrl(), sq.getUsuario(), sq.getContrasena());
            // Crear la consulta SQL para obtener los productos más comprados por el cliente
            String consulta = "SELECT Producto.Tipo, COUNT(*) AS Cantidad FROM PedidoDetalle JOIN Producto ON PedidoDetalle.ProductoID = Producto.ID WHERE PedidoDetalle.ClienteID = ? GROUP BY Producto.Tipo ORDER BY Cantidad DESC LIMIT 3";

            // Preparar la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            // Establecer el valor del parámetro de la consulta
            statement.setInt(1, this.getID());

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultado = statement.executeQuery();

            // Limpiar la lista de preferencias actual
            Preferencias.clear();

            // Agregar cada TipoDeProducto al cliente como preferencia
            while (resultado.next()) {
                TipoProducto tipo = TipoProducto.valueOf(resultado.getString("Tipo"));
                Preferencias.add(tipo);
            }

            // Cerrar la conexión con la base de datos
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
