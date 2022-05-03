package view;

import javax.swing.JFrame;
import control.Controller;
import control.Model;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class PanelBienvenida extends JFrame{
    String ruta = Model.getRutaGlobal()+"\\Imagen\\";
    public PanelBienvenida(){
        this.setTitle("Bienvenido");
        createAndShowGUI();
    }


    private void createAndShowGUI() {

        JLabel label = new JLabel(new ImageIcon(ruta+"titulo.png"));

        this.setVisible(true);
        this.setSize(1100, 550);
        //this.setLocation(getX()+300, getY()+200);
        setLocationRelativeTo(null);

        this.add(label, BorderLayout.PAGE_START);
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel(new ImageIcon(ruta+"viaje1.png")));
        panel.add(new JLabel(new ImageIcon(ruta+"viaje2.png")));
        panel.add(new JLabel(new ImageIcon(ruta+"viaje3.png")));

        this.add(panel, BorderLayout.CENTER);

        JPanel panel1 = new JPanel(new FlowLayout());
        JButton boton = new JButton();
        boton.setIcon(loadImage(ruta+"boton.png"));
        boton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                        Controller c = new Controller();
                        c.setSize(475, 410);
                        c.setVisible(true);
                        setVisible(false);
                }

        });
        panel1.add(boton);
        this.add(panel1, BorderLayout.PAGE_END);
        try {
                FondoSwing fondo = new FondoSwing(ImageIO.read(new File(ruta+"fondo.jpg")));
                JPanel panel2 = (JPanel) this.getContentPane();
                panel2.setBorder(fondo);
                panel1.setBorder(fondo);
        } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

protected static ImageIcon loadImage(String path) {
        return new ImageIcon(Toolkit.getDefaultToolkit().createImage(path));
}
}
