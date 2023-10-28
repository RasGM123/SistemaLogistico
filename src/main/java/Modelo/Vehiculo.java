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

public class Vehiculo {
    private int id;
    private String marca;
    private String dominio;
    private String modelo;
    private int capacidadDeCarga;

    public Vehiculo(int id, String marca, String dominio, String modelo, int capacidadDeCarga) {
        this.id = id;
        this.marca = marca;
        this.dominio = dominio;
        this.modelo = modelo;
        this.capacidadDeCarga = capacidadDeCarga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidadDeCarga() {
        return capacidadDeCarga;
    }

    public void setCapacidadDeCarga(int capacidadDeCarga) {
        this.capacidadDeCarga = capacidadDeCarga;
    }

    public void guardarVehiculo() {
        try {
            // Establecer la conexión con la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/nombre_de_la_base_de_datos", "usuario", "contraseña");

            // Crear la consulta SQL para insertar un nuevo vehículo
            String consulta = "INSERT INTO Vehiculo (ID, Marca, Dominio, Modelo, CapacidadDeCarga) VALUES (?, ?, ?, ?, ?)";

            // Preparar la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            // Establecer los valores de los parámetros de la consulta
            statement.setInt(1, this.id);
            statement.setString(2, this.marca);
            statement.setString(3, this.dominio);
            statement.setString(4, this.modelo);
            statement.setInt(5, this.capacidadDeCarga);

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la conexión con la base de datos
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarVehiculo() {
        try {
            // Establecer la conexión con la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/nombre_de_la_base_de_datos", "usuario", "contraseña");

            // Crear la consulta SQL para actualizar un vehículo existente
            String consulta = "UPDATE Vehiculo SET Marca = ?, Dominio = ?, Modelo = ?, CapacidadDeCarga = ? WHERE ID = ?";

            // Preparar la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            // Establecer los valores de los parámetros de la consulta
            statement.setString(1, this.marca);
            statement.setString(2, this.dominio);
            statement.setString(3, this.modelo);
            statement.setInt(4, this.capacidadDeCarga);
            statement.setInt(5, this.id);

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la conexión con la base de datos
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarVehiculo() {
        try {
            // Establecer la conexión con la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/nombre_de_la_base_de_datos", "usuario", "contraseña");

            // Crear la consulta SQL para eliminar un vehículo existente
            String consulta = "DELETE FROM Vehiculo WHERE ID = ?";

            // Preparar la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            // Establecer el valor del parámetro de la consulta
            statement.setInt(1, this.id);

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la conexión con la base de datos
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}