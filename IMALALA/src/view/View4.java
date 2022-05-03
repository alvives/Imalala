package view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import control.Model;
import control.Observer;
import model.Viaje;
import model.Gestor;
import model.Reserva;
import model.Usuario;




//Consultar Reservas
public class View4 extends JFrame {
	Model model;
	Usuario u;
	JPanel panel;
	JPanel panel1;
	JTable table;
	TModelReservas tableModel;
	ArrayList<Reserva> listaReservas;
	int viajeMun;
	
	/*JScrollPane jScrollPane1 = new JScrollPane();	
	JLabel jLabel1 = new JLabel();

	ArrayList<JLabel> listajLabel = new ArrayList<JLabel>();
	ArrayList<JButton> listajButton = new ArrayList<JButton>();*/
	
	
	public View4 (Model model, Usuario u) { 

		try{
			this.model = model;
			this.u = u;
			listaReservas = model.getListaReservas().getReservasUsuario(u);//.getReservasUsuario(u);
			setTitle("Consultar reservas");
			panel = new JPanel(new BorderLayout());	
			panel1 = new JPanel(new BorderLayout());	
			jbInit();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jbInit() throws Exception 	{

		panel.add(new JLabel( "Usuario: "+ this.u.getNombre()),BorderLayout.PAGE_START);
		addJtable();
		addBotton();
		panel.add(panel1,BorderLayout.PAGE_END);
		this.add(panel);
		setLocation(getX()+400, getY()+200);
		setSize(700,300);
		setVisible(true);
		this.setVisible(true);
	}

	
	private void addJtable() {

		table = new JTable();
		tableModel = new TModelReservas(listaReservas, model); 
		table.setModel(tableModel);
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(true);
		table.setBorder(BorderFactory.createLineBorder(Color.blue));
		table.setShowGrid(false);		
		
		JScrollPane scb = new JScrollPane(table);
		panel.add(scb,BorderLayout.CENTER);
	}

	private void addBotton() {
		// TODO Auto-generated method stub
		JPanel BPanel=new JPanel();					
		JButton atrasB=new JButton("Atras");		

		atrasB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
			}
		});
		BPanel.add(atrasB);
		panel1.add(BPanel,BorderLayout.CENTER);

	}
	
}