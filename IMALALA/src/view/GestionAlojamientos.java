package view;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import control.Model;
import control.Observer;
import model.Gestor;

public class GestionAlojamientos extends JFrame implements Observer {
	Model model;
	Gestor g;
	
	View3 view3;
	View4 view4;
	View6 view6;
	View7 view7;
	
	JScrollPane jScrollPane1 = new JScrollPane();	
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JButton jButton1 = new JButton();
	JButton jButton2 = new JButton();
	JButton jButton3 = new JButton();
    JButton jButton4 = new JButton();
    VistaAnadirAlojamiento vista1;
	VistaModificarAlojamiento vista2;
	VistaEliminarAlojamiento vista3;
    //View10 view9 = new View9();
    //View11 view9 = new View9();
	
	public GestionAlojamientos() 	{
	}
	
	public GestionAlojamientos(Model model, Gestor g) 	{
	try 	{
		this.model = model;
		this.g = g;
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
		jButton1.setText("Añadir alojamiento");
		jButton1.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton1_actionPerformed(e);
			}
		});
		jButton2.setBounds(new Rectangle(42, 104, 300, 27));
		jButton2.setText("Modificar alojamiento");
		jButton2.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton2_actionPerformed(e);
			}
		});
		jButton3.setBounds(new Rectangle(42, 156, 300, 27));
		jButton3.setText("Dar de baja alojamiento");
		jButton3.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton3_actionPerformed(e);
			}
		});
		jButton4.setBounds(new Rectangle(42, 208, 300, 27));
		jButton4.setText("Volver");
		jButton4.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton4_actionPerformed(e);
			}
		});
		
		jLabel1.setText("Elija la acción que desea realizar:");
		jLabel1.setBounds(new Rectangle(41, 15, 400, 23));
		jLabel2.setText("Alojamientos actuales: " + model.getListaAlojamientos().getListaAlojamiento().size());
		jLabel2.setBounds(new Rectangle(300, 5, 400, 23));
		
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(jButton1, null);
		this.getContentPane().add(jButton2, null);
		this.getContentPane().add(jButton3, null);
		this.getContentPane().add(jButton4, null);
	}

	void jButton1_actionPerformed(ActionEvent e) {
		this.vista1 = new VistaAnadirAlojamiento(this.model);
		this.vista1.setSize(475,410);
		this.vista1.setVisible(true);
	}
	
	void jButton2_actionPerformed(ActionEvent e) {
		this.vista2 = new VistaModificarAlojamiento(this.model);
		this.vista2.setSize(475,410);
		this.vista2.setVisible(true);
		
	}
	
	void jButton3_actionPerformed(ActionEvent e) {
		this.vista3 = new VistaEliminarAlojamiento(this.model);
		this.vista3.setSize(475,410);
		this.vista3.setVisible(true);
	}

    void jButton4_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}
    @Override
	public void dataUpdate(Model model) {
		jLabel2.setText("Alojamientos actuales: " + model.getListaAlojamientos().getListaAlojamiento().size());
	}

}
