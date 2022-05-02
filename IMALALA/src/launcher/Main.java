package launcher;
//import Usuario;

import javax.swing.SwingUtilities;

import control.Controller;
import java.awt.*;
import javax.swing.*;

import view.View1;
import view.View2;
import view.View5;

import java.awt.event.*;
import java.security.cert.CertPath;

public class Main {

        public static void main(String[] args) {

                SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                                createAndShowGUI();
                                
                        }
                });

        }

        private static void createAndShowGUI() {

		JFrame frame = new JFrame("Bienvenido");
		JLabel label = new JLabel(new ImageIcon("IMALALA\\Imagen\\titulo.png"));

		frame.setVisible(true);
		frame.setSize(1300, 550);
		frame.setLocation(400, 200);

		frame.add(label, BorderLayout.PAGE_START);
		JPanel panel = new JPanel(new FlowLayout());		
		panel.add( new JLabel(new ImageIcon("IMALALA\\Imagen\\viaje1.png")));
		panel.add( new JLabel(new ImageIcon("IMALALA\\Imagen\\viaje2.png")));
		panel.add( new JLabel(new ImageIcon("IMALALA\\Imagen\\viaje3.png")));
		
		

		frame.add(panel,BorderLayout.CENTER);

		JPanel panel1 = new JPanel(new FlowLayout());
		JButton boton = new JButton();		
		boton.setIcon(loadImage("IMALALA\\Imagen\\boton.png"));	
		boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Controller c = new Controller();
                                c.setSize(475, 410);
                                c.setVisible(true);
                                frame.setVisible(false);
			}

		});
		panel1.add(boton);
		frame.add(panel1,BorderLayout.PAGE_END);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	protected static ImageIcon loadImage(String path) {
        return new ImageIcon(Toolkit.getDefaultToolkit().createImage(path));
    } 

}
