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

public class Persona {
    private int ID;
    private String Nombre;
    private String Apellido;
    private int Direccion;
    private int Telefono;
    private String email;

    public Persona(int ID, String Nombre, String Apellido, int Direccion, int Telefono, String email) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.email = email;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getDireccion() {
        return Direccion;
    }

    public void setDireccion(int Direccion) {
        this.Direccion = Direccion;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void guardarPersona() {
        try {
            // Establecer la conexión con la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/nombre_de_la_base_de_datos", "usuario", "contraseña");

            // Crear la consulta SQL para insertar una nueva persona
            String consulta = "INSERT INTO Persona (ID, Nombre, Apellido, Direccion, Telefono, email) VALUES (?, ?, ?, ?, ?, ?)";

            // Preparar la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            // Establecer los valores de los parámetros de la consulta
            statement.setInt(1, this.ID);
            statement.setString(2, this.Nombre);
            statement.setString(3, this.Apellido);
            statement.setInt(4, this.Direccion);
            statement.setInt(5, this.Telefono);
            statement.setString(6, this.email);

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la conexión con la base de datos
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Persona obtenerPersona(int ID) {
        Persona persona = null;

        try {
            // Establecer la conexión con la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/nombre_de_la_base_de_datos", "usuario", "contraseña");

            // Crear la consulta SQL para obtener una persona por su ID
            String consulta = "SELECT * FROM Persona WHERE ID = ?";

            // Preparar la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            // Establecer el valor del parámetro de la consulta
            statement.setInt(1, ID);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultado = statement.executeQuery();

            // Si se encontró una persona con el ID especificado, crear un objeto Persona con sus datos
            if (resultado.next()) {
                persona = new Persona(
                    resultado.getInt("ID"),
                    resultado.getString("Nombre"),
                    resultado.getString("Apellido"),
                    resultado.getInt("Direccion"),
                    resultado.getInt("Telefono"),
                    resultado.getString("email")
                );
            }

            // Cerrar la conexión con la base de datos
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return persona;
    }

    public void actualizarPersona() {
        try {
            // Establecer la conexión con la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/nombre_de_la_base_de_datos", "usuario", "contraseña");

            // Crear la consulta SQL para actualizar los datos de una persona
            String consulta = "UPDATE Persona SET Nombre = ?, Apellido = ?, Direccion = ?, Telefono = ?, email = ? WHERE ID = ?";

            // Preparar la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            // Establecer los valores de los parámetros de la consulta
            statement.setString(1, this.Nombre);
            statement.setString(2, this.Apellido);
            statement.setInt(3, this.Direccion);
            statement.setInt(4, this.Telefono);
            statement.setString(5, this.email);
            statement.setInt(6, this.ID);

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la conexión con la base de datos
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarPersona() {
        try {
            // Establecer la conexión con la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/nombre_de_la_base_de_datos", "usuario", "contraseña");

            // Crear la consulta SQL para eliminar una persona por su ID
            String consulta = "DELETE FROM Persona WHERE ID = ?";

            // Preparar la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            // Establecer el valor del parámetro de la consulta
            statement.setInt(1, this.ID);

            // Ejecutar la consulta
            statement.executeUpdate();

            // Cerrar la conexión con la base de datos
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}