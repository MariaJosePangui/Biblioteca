package gui;
import controller.BibliotecasController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class VentanaLibro extends JFrame{
    private JPanel panel;

    public VentanaLibro(){
        setTitle("Registro Libro");
        setBounds(50, 50, 460, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes(){
        generarPanel();
        registrarLibro();
    }

    public void generarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
    }

    public JButton crearBoton(String texto, int x, int y, int ancho, int alto, String estiloTexto){
        JButton boton = new JButton();
        boton.setText(texto);
        boton.setBounds(x,y,ancho,alto);
        boton.setForeground(Color.black);
        boton.setFont(new Font(estiloTexto,1,(alto)));
        return boton;
    }

    public JLabel crearEtiqueta(String texto, int x, int y, int ancho, int alto,String estiloTexto){
        JLabel etiqueta = new JLabel();
        etiqueta.setText(texto);
        etiqueta.setBounds(x,y,ancho,alto);
        etiqueta.setHorizontalAlignment(SwingConstants.LEFT);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setFont(new Font(estiloTexto,1,alto));
        return etiqueta;
    }

    public JTextField crearCajaTexto(int x, int y, int ancho, int alto){
        JTextField cajaTexto = new JTextField();
        cajaTexto.setBounds(x,y,ancho,alto);
        return cajaTexto;
    }

    public void registrarLibro(){
        JLabel etiqueta1 = crearEtiqueta("Registro de Libro",110,20,400,23,"Calibri");
        panel.add(etiqueta1);

        JLabel etiqueta2 = crearEtiqueta("Titulo: ",10,70,200,16,"Calibri");
        panel.add(etiqueta2);

        JLabel etiqueta3 = crearEtiqueta("Autor: ",10,110,200,16,"Calibri");
        panel.add(etiqueta3);

        JLabel etiqueta4 = crearEtiqueta("Fecha de Publicación: ",10,150,200,16,"Calibri");
        panel.add(etiqueta4);

        JLabel etiqueta5 = crearEtiqueta("Género: ",10,190,200,16,"Calibri");
        panel.add(etiqueta5);

        JLabel etiqueta6 = crearEtiqueta("Biblioteca",10,230,200,16,"Calibri");
        panel.add(etiqueta6);

        JLabel etiqueta7 = crearEtiqueta("Estado: ",10,270,200,16,"Calibri");
        panel.add(etiqueta7);

        JTextField cajaTexto1 = crearCajaTexto(200,70,200,20);
        panel.add(cajaTexto1);

        JTextField cajaTexto2 = crearCajaTexto(200,110,200,20);
        panel.add(cajaTexto2);

        JTextField cajaTexto3 = crearCajaTexto(200,150,200,20);
        panel.add(cajaTexto3);

        JTextField cajaTexto4 = crearCajaTexto(200,190,200,20);
        panel.add(cajaTexto4);

        String[] estados = {"En Stock","Prestado"};
        JComboBox listaDesplegable2 = new JComboBox(estados);
        listaDesplegable2.setBounds(200,270,200,20);
        panel.add(listaDesplegable2);

        String[] listaBibliotecas = {};
        JComboBox listaDesplegable1 = new JComboBox(listaBibliotecas);
        listaDesplegable1.setBounds(200,230,200,20);
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bibliotecas","root","");

            PreparedStatement preparedStatement = connection.prepareStatement("select * from biblioteca");
            ResultSet set = preparedStatement.executeQuery();

            while (set.next()){
                listaDesplegable1.addItem(set.getString("NombreBiblioteca"));
            }
        } catch (SQLException e) {

        }
        panel.add(listaDesplegable1);

        JButton boton1 = crearBoton("Registrar Libro",10,310,210,20,"Calibri");
        panel.add(boton1);

        JButton boton2 = crearBoton("Volver",225,310,210,20,"Calibri");
        panel.add(boton2);

        ActionListener eventoClick1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BibliotecasController bibliotecasController = new BibliotecasController();

                String titulo = cajaTexto1.getText().trim();
                String autor = cajaTexto2.getText().trim();
                String fechaPublicacion = cajaTexto3.getText().trim();
                String genero = cajaTexto4.getText().trim();
                String biblioteca = (String) listaDesplegable1.getSelectedItem();
                String estado = (String) listaDesplegable2.getSelectedItem();

                bibliotecasController.agregarLibro(titulo,autor,fechaPublicacion,genero,biblioteca,estado);

                cajaTexto1.setText("");
                cajaTexto2.setText("");
                cajaTexto3.setText("");
                cajaTexto4.setText("");
            }
        };
        boton1.addActionListener(eventoClick1);

        ActionListener eventoClick2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                ventanaPrincipal.setVisible(true);
            }
        };
        boton2.addActionListener(eventoClick2);
    }
}