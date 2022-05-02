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

public class GestionTransportes extends JFrame implements Observer {
	Model model;
	Gestor g;

	VistaAnadirTransporte vistaAnadirTransporte;
	VistaModificarTransporte vistaModificarTransporte;
	VistaEliminarTransporte vistaEliminarTransporte;
	
	JScrollPane jScrollPane1 = new JScrollPane();	
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JButton jButton1 = new JButton();
	JButton jButton2 = new JButton();
	JButton jButton3 = new JButton();
    JButton jButton4 = new JButton();
    
	
	public GestionTransportes() 	{
	}
	
	public GestionTransportes(Model model, Gestor g) 	{
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
		setTitle("Gestion de Transporte");
		setLocation(getX()+600, getY()+200);
		this.getContentPane().setLayout(null);
		jScrollPane1.setBounds(new Rectangle(0, 0, 3, 3));
		
		jButton1.setBounds(new Rectangle(42, 52, 300, 27));
		jButton1.setText("Añadir transporte");
		jButton1.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton1_actionPerformed(e);
			}
		});
		jButton2.setBounds(new Rectangle(42, 104, 300, 27));
		jButton2.setText("Modificar transporte");
		jButton2.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton2_actionPerformed(e);
			}
		});
		jButton3.setBounds(new Rectangle(42, 156, 300, 27));
		jButton3.setText("Dar de baja transporte");
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
		jLabel2.setText("Transportes actuales: " + model.getListaTransportes().getListaTransportes().size());        
		jLabel2.setBounds(new Rectangle(300, 5, 400, 23));

		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(jButton1, null);
		this.getContentPane().add(jButton2, null);
		this.getContentPane().add(jButton3, null);
        this.getContentPane().add(jButton4, null);
		
	}

    void jButton1_actionPerformed(ActionEvent e) {
		this.vistaAnadirTransporte = new VistaAnadirTransporte(this.model);
		this.vistaAnadirTransporte.setSize(475,410);
		this.vistaAnadirTransporte.setVisible(true);
	}
	
	void jButton2_actionPerformed(ActionEvent e) {
		this.vistaModificarTransporte = new VistaModificarTransporte(this.model);
		this.vistaModificarTransporte.setSize(475,410);
		this.vistaModificarTransporte.setVisible(true);
	}
	
	void jButton3_actionPerformed(ActionEvent e) {
		this.vistaEliminarTransporte = new VistaEliminarTransporte(this.model);
		this.vistaEliminarTransporte.setSize(475,410);
		this.vistaEliminarTransporte.setVisible(true);
	}

    void jButton4_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}
	@Override
    public void dataUpdate(Model model) {
		jLabel2.setText("Transportes actuales: " + model.getSizeListaTransportes());        
    }

}
