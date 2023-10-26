package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private JPanel panel;

    public VentanaPrincipal(){
        setTitle("Bienvenida Intranet");
        setBounds(50, 50, 300, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes(){
        generarPanel();
        bienvenida();
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

    public void bienvenida(){
        JButton boton1 = crearBoton("Registro Biblioteca",30,30,230,22,"Calibri");
        panel.add(boton1);

        JButton boton2 = crearBoton("Registro Libro",30,80,230,22,"Calibri");
        panel.add(boton2);

        JButton boton3 = crearBoton("Eliminar Libro",30,130,230,22,"Calibri");
        panel.add(boton3);

        JButton boton4 = crearBoton("Buscar Libro",30,180,230,22,"Calibri");
        panel.add(boton4);

        JButton boton5 = crearBoton("Prestar Libro",30,230,230,22,"Calibri");
        panel.add(boton5);

        JButton boton6 = crearBoton("Devolver Libro",30,280,230,22,"Calibri");
        panel.add(boton6);

        JButton boton7 = crearBoton("Salir",30,330,230,22,"Calibri");
        panel.add(boton7);

        ActionListener eventoClick1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaBiblioteca ventanaBiblioteca = new VentanaBiblioteca();
                ventanaBiblioteca.setVisible(true);
            }
        };
        boton1.addActionListener(eventoClick1);

        ActionListener eventoClick2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaLibro ventanaLibro = new VentanaLibro();
                ventanaLibro.setVisible(true);
            }
        };
        boton2.addActionListener(eventoClick2);

        ActionListener eventoClick3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaEliminarLibro ventanaEliminarLibro = new VentanaEliminarLibro();
                ventanaEliminarLibro.setVisible(true);
            }
        };
        boton3.addActionListener(eventoClick3);

        ActionListener eventoClick4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaBuscarLibro ventanaBuscarLibro = new VentanaBuscarLibro();
                ventanaBuscarLibro.setVisible(true);
            }
        };
        boton4.addActionListener(eventoClick4);

        ActionListener eventoClick5 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaPrestarLibro ventanaPrestarLibro = new VentanaPrestarLibro();
                ventanaPrestarLibro.setVisible(true);
            }
        };
        boton5.addActionListener(eventoClick5);

        ActionListener eventoClick6 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaDevolverLibro ventanaDevolverLibro = new VentanaDevolverLibro();
                ventanaDevolverLibro.setVisible(true);
            }
        };
        boton6.addActionListener(eventoClick6);

        ActionListener eventoClick7 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        };
        boton7.addActionListener(eventoClick7);
    }
}