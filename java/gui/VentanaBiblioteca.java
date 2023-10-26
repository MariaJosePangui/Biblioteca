package gui;
import controller.BibliotecasController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaBiblioteca extends JFrame {
    private JPanel panel;

    public VentanaBiblioteca(){
        setTitle("Registro Biblioteca");
        setBounds(50, 50, 460, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes(){
        generarPanel();
        registrarBiblioteca();
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

    public void registrarBiblioteca(){
        JLabel etiqueta1 = crearEtiqueta("Registro de Biblioteca",70,20,400,23,"Calibri");
        panel.add(etiqueta1);

        JLabel etiqueta2 = crearEtiqueta("Nombre Biblioteca: ",10,70,200,16,"Calibri");
        panel.add(etiqueta2);

        JLabel etiqueta3 = crearEtiqueta("Dirección: ",10,110,200,16,"Calibri");
        panel.add(etiqueta3);

        JLabel etiqueta4 = crearEtiqueta("Horario de ateción: ",10,150,200,16,"Calibri");
        panel.add(etiqueta4);

        JTextField cajaTexto1 = crearCajaTexto(200,70,200,20);
        panel.add(cajaTexto1);

        JTextField cajaTexto2 = crearCajaTexto(200,110,200,20);
        panel.add(cajaTexto2);

        JTextField cajaTexto3 = crearCajaTexto(200,150,200,20);
        panel.add(cajaTexto3);

        JButton boton1 = crearBoton("Registrar Biblioteca",20,250,200,20,"Calibri");
        panel.add(boton1);

        JButton boton2 = crearBoton("Volver",230,250,200,20,"Calibri");
        panel.add(boton2);

        ActionListener eventoClik1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BibliotecasController bibliotecasController = new BibliotecasController();

                String nombre = cajaTexto1.getText().trim();
                String direccion = cajaTexto2.getText().trim();
                String horaAtencion = cajaTexto3.getText().trim();

                bibliotecasController.agregarBiblioteca(nombre,direccion,horaAtencion);

                cajaTexto1.setText("");
                cajaTexto2.setText("");
                cajaTexto3.setText("");
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