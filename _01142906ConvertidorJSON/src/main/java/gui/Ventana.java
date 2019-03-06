package gui;

import Convertidor.Convertidor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import salon.clase;

public class Ventana extends JFrame implements ActionListener {

    private JTextArea entrada, salida;
    private JButton botonparaconvertir;
    private JComboBox selector;
    private JScrollPane barra, barra2;
    private JPanel pc;
    Convertidor convertidor;

    clase cl;

    String[] salon;


    public Ventana(){
        //elementos de la ventana



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(10,20,900,500);
        //this.setSize(new Dimension(900,500));
        this.setLayout(null);


        iniciar();

    }

    public void iniciar(){

        this.setSize(650,600);
        pc= new JPanel();
        //JPanel pc = new JPanel();// instanciamos el panel
        pc.setBounds(0, 0, 600, 600);
        pc.setLayout(null);

        entrada = new JTextArea();
        barra = new JScrollPane(entrada);
        barra.setBounds(20,20,250,400);

        salida = new JTextArea();
        barra2 = new JScrollPane(salida);
        barra2.setBounds(350,20,250,400);

        botonparaconvertir = new JButton("convertir");
        botonparaconvertir.setBounds(150,450,90,20);
        botonparaconvertir.addActionListener(this);

        selector = new JComboBox();
        selector.setBounds(50,450,90,20);
        selector.addItem("XML");
        selector.addItem("JAVA");

        add(pc);
        pc.add(barra);
        pc.add(barra2);

        pc.add(botonparaconvertir);
        pc.add(selector);
    }
    public static void main(String[] args) {
        Ventana v = new Ventana();
        v.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)  {

    Convertidor c = new Convertidor();
    String textoEntrada = entrada.getText();
    String textoconvertido ;
    try {
        if (textoEntrada.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "no hay texto", "texto vacio", JOptionPane.WARNING_MESSAGE);
        }
        else if (selector.getSelectedItem().toString().compareTo("XML") == 0) {

            textoconvertido = c.convertirXml(textoEntrada);
            salida.setText("");
            salida.setText(textoconvertido);

        }

            else if (selector.getSelectedItem().toString().compareTo("JAVA") == 0) {



                convertidor = new Convertidor();
                salon = textoEntrada.split(" ");
                cl = new clase(salon[0],salon[1],salon[2]);
                String resultado = convertidor.Objecttojson(cl);
                salida.setText("");
                salida.setText(resultado);

        }
    }catch (Exception e1) {

    }
    }

    }




