package view;


import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import control.Model;
import control.Observer;
import model.EstrategiaPrecios;
import model.EstrategiaPreciosBaratos;
import model.EstrategiaPreciosCaros;
import model.Usuario;

public class View9 extends JFrame  {
    Model model;
	Usuario u;

	View6 view6;
	
	JScrollPane jScrollPane1 = new JScrollPane();	
	JLabel jLabel = new JLabel();
	JButton jButton1 = new JButton();
	JButton jButton2 = new JButton();
	
	public View9(Model model, Usuario u) 	{
        try 	{
            this.model = model;
            this.u = u;
            jbInit();
            }
            catch(Exception e) 	{
            e.printStackTrace();
            }
	}
	
	private void jbInit() throws Exception 	{
		setLocation(getX()+600, getY()+200);
		this.getContentPane().setLayout(null);
		jScrollPane1.setBounds(new Rectangle(0, 0, 3, 3));
		
		jButton1.setBounds(new Rectangle(42, 52, 300, 27));
		jButton1.setText("Viajes low-cost");
		jButton1.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton1_actionPerformed(e);
			}
		});
		jButton2.setBounds(new Rectangle(42, 100, 300, 27));
		jButton2.setText("Viajes VIP");
		jButton2.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton2_actionPerformed(e);
			}
		});

		
		jLabel.setText("Bienvenido " + this.u.getNombre() + " " + this.u.getApellido() + ", elije el tipo de viaje que quieres reservar:");
		jLabel.setBounds(new Rectangle(41, 20, 400, 23));
		
		this.getContentPane().add(jLabel, null);
		this.getContentPane().add(jButton1, null);
		this.getContentPane().add(jButton2, null);
	}

	void jButton1_actionPerformed(ActionEvent e) {
		EstrategiaPrecios estrategia = new EstrategiaPreciosBaratos();
        
        this.view6 = new View6(this.model, this.u, estrategia);
		this.view6.setSize(475,410);
        this.setVisible(false);
		this.view6.setVisible(true);
	}
	
	void jButton2_actionPerformed(ActionEvent e) {
        EstrategiaPrecios estrategia = new EstrategiaPreciosCaros();

		this.view6 = new View6(this.model, this.u, estrategia);
		this.view6.setSize(475,410);
        this.setVisible(false);
		this.view6.setVisible(true);
	}
	

}
