package controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class BibliotecasController {

    public void agregarBiblioteca(String nombre,String direccion,String horaAtencion){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bibliotecas","root","");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into biblioteca values(?,?,?)");

            preparedStatement.setString(1,nombre);
            preparedStatement.setString(2,direccion);
            preparedStatement.setString(3,horaAtencion);
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null,"Registro existoso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"No se pudo hacer coneccion");

        }
    }

    public void agregarLibro(String titulo, String autor, String fechaPublicaion, String genero, String biblioteca, String estado){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bibliotecas","root","");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into libros values(?,?,?,?,?,?)");

            preparedStatement.setString(1,titulo);
            preparedStatement.setString(2,autor);
            preparedStatement.setString(3,fechaPublicaion);
            preparedStatement.setString(4,genero);
            preparedStatement.setString(5,biblioteca);
            preparedStatement.setString(6,estado);
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null,"Registro existoso");
        } catch (SQLException ex) {

        }
    }

    public void eliminarLibro(String titulo){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bibliotecas","root","");
            PreparedStatement preparedStatement = connection.prepareStatement("delete from libros where Titulo = ?");

            preparedStatement.setString(1,titulo);
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null,"Libro eliminado exitosamente");
        } catch (SQLException e) {

        }
    }

    public void buscarLibro(String autor){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2,1));
        frame.setSize(600,300);
        frame.setLocationRelativeTo(null);
        JTable tabla = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Titulo");
        model.addColumn("Autor");
        model.addColumn("Fecha Publicación");
        model.addColumn("Género");
        model.addColumn("Biblioteca");
        model.addColumn("Estado");
        tabla.setModel(model);

        String[] datos = new String[6];
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bibliotecas","root","");

            PreparedStatement preparedStatement1 = connection.prepareStatement("select * from libros where Autor = ?");
            preparedStatement1.setString(1,autor);
            ResultSet set1 = preparedStatement1.executeQuery();

            while(set1.next()){
                datos[0] = set1.getString(1);
                datos[1] = set1.getString(2);
                datos[2] = set1.getString(3);
                datos[3] = set1.getString(4);
                datos[4] = set1.getString(5);
                datos[5] = set1.getString(6);
                model.addRow(datos);
            }

        } catch (SQLException ex) {

        }
        JScrollPane scrollPane = new JScrollPane(tabla);
        frame.add(scrollPane,0,0);
        frame.setVisible(true);
    }

    public void prestarLibro(String titulo){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bibliotecas","root","");
            PreparedStatement preparedStatement = connection.prepareStatement("update libros set estado = 'Prestado' where Titulo = '"+titulo+"'");
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"EL libro ha sido prestado con éxito");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void devolverLibro(String titulo){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bibliotecas","root","");
            PreparedStatement preparedStatement = connection.prepareStatement("update libros set estado = 'En Stock' where Titulo = '"+titulo+"'");
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"EL libro ha sido devuelto con éxito");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}