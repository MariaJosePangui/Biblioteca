package gui;


import controller.BibliotecasController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEliminarLibro extends JFrame{
    private JPanel panel;

    public VentanaEliminarLibro(){
        setTitle("Eliminar Libro");
        setBounds(50, 50, 460, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes(){
        generarPanel();
        eliminarLibro();
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

    public void eliminarLibro(){
        JLabel etiqueta1 = crearEtiqueta("Eliminar Libro",70,20,400,23,"Calibri");
        panel.add(etiqueta1);

        JLabel etiqueta2 = crearEtiqueta("Titulo: ",10,70,200,16,"Calibri");
        panel.add(etiqueta2);

        JTextField cajaTexto = crearCajaTexto(200,70,200,20);
        panel.add(cajaTexto);

        JButton boton1 = crearBoton("Eliminar Libro",20,130,200,20,"Calibri");
        panel.add(boton1);

        JButton boton2 = crearBoton("Volver",230,130,200,20,"Calibri");
        panel.add(boton2);

        ActionListener eventoClik1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BibliotecasController bibliotecasController = new BibliotecasController();

                String titulo = cajaTexto.getText().trim();

                bibliotecasController.eliminarLibro(titulo);

                cajaTexto.setText("");
            }
        };
        boton1.addActionListener(eventoClik1);

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