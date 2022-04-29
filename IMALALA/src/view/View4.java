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
import list.ListaReservas;
import list.ListaViajes;




//Consultar Reservas
public class View4 extends JFrame implements Observer {
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
			listaReservas = model.getListaReservas().getListaReservas();//.getReservasUsuario(u);
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

	@Override
	public void dataUpdate(Model model) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*Model model;
	Usuario u;
	
	
	JScrollPane jScrollPane1 = new JScrollPane();	
	JLabel jLabel1 = new JLabel();
	ArrayList<JLabel> listajLabel = new ArrayList<JLabel>();
	
	public View4() 	{
	}
	
	public View4(Model model, Usuario u) 	{
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
		
		ArrayList<Reserva> listaReservas = model.getListaReservas().getReservasUsuario(u);
		
				
		jLabel1.setText("Aqui tienes un listado con tus reservas " + this.u.getNombre() + " " + this.u.getApellido() + ":");
		jLabel1.setBounds(new Rectangle(41, 15, 400, 23));
		
		int y=0;
		for (int z=0;z<listaReservas.size();z++) {
			listajLabel.add(new JLabel());
			listajLabel.get(z).setText("Reserva: "+ listaReservas.get(z).getId() + " (" + listaReservas.get(z).getViaje().getAlojamiento().getCiudad() + ")");
			listajLabel.get(z).setBounds(new Rectangle(41, 65+y, 400, 23));
			y+=50;
			this.getContentPane().add(listajLabel.get(z), null);
		}
		
		
		
		this.getContentPane().add(jLabel1, null);
	}

	
	@Override
	public void dataUpdate(Model model) {
		// TODO Auto-generated method stub
		
	}*/
	

	
}