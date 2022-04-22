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
import model.Usuario;
import model.Reserva;

public class View7 extends JFrame implements Observer {
	Model model;
	Usuario u;
	JPanel panel;
	JPanel panel1;
	JTable table;
	TableModel tableModel;
	ArrayList<Reserva> listaReservas;
	int reservaMun;
	
	/*JScrollPane jScrollPane1 = new JScrollPane();	
	JLabel jLabel1 = new JLabel();

	ArrayList<JLabel> listajLabel = new ArrayList<JLabel>();
	ArrayList<JButton> listajButton = new ArrayList<JButton>();*/
	
	
	
	public View7(Model model, Usuario u) 	{

		try{
			this.model = model;
			this.u = u;
			listaReservas = model.getListaReservas().getReservasUsuario(u);
			setTitle("Cancelar reserva");
			panel = new JPanel(new BorderLayout());	
			panel1 = new JPanel(new BorderLayout());	
			jbInit();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jbInit() throws Exception 	{

		panel.add(new JLabel( "Usuario "+ this.u.getNombre() + " " + this.u.getApellido()),BorderLayout.PAGE_START);
		addJtable();
		addCombobox();
		addBotton();
		panel.add(panel1,BorderLayout.PAGE_END);
		this.add(panel);
		setLocation(getX()+600, getY()+200);
		setSize(700,300);
		setVisible(true);
		this.setVisible(true);
	}

	
	private void addJtable() {

		table = new JTable();
		tableModel = new TableModel(listaReservas); 
		table.setModel(tableModel);
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(true);
		table.setBorder(BorderFactory.createLineBorder(Color.blue));
		table.setShowGrid(false);		
		
		JScrollPane scb = new JScrollPane(table);
		panel.add(scb,BorderLayout.CENTER);
	}

	private void addCombobox() {

		Vector<String> valores = new Vector<String>();

		for(int i=0;i<listaReservas.size();i++) {

			valores.add(listaReservas.get(i).getId());

		}

		JComboBox<String> reservaList = new JComboBox<String>(valores);
		reservaList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				reservaMun = reservaList.getSelectedIndex();														
				
			}
		});
		JPanel CPanel =new JPanel();
		CPanel.add(new JLabel("  Selecciona la reserva que quieres cancelar "));
		CPanel.add(reservaList);
		panel1.add(CPanel,BorderLayout.PAGE_START);
	}
	private void addBotton() {
		JPanel BPanel=new JPanel();					
		JButton cancelB=new JButton("Cancelar reserva");
		JButton atrasB=new JButton("Atras");		
		cancelB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				JDialog ok=new JDialog();
				ok.setTitle("Reserva cancelado");
				ok.setLocation(getX()+300, getY()+200);
				JPanel okpanel = new JPanel(new BorderLayout());
				okpanel.add(new JLabel("Has cancelado la reserva "+listaReservas.get(reservaMun).getId()),BorderLayout.PAGE_START);

				JButton okButton =new JButton("OK");
				okpanel.add(okButton,BorderLayout.CENTER);
				okButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						
						ok.setVisible(false);
					}


				});
				
				
				ok.add(okpanel);
				
					
				ok.pack();
				ok.setVisible(true);	
				model.getListaReservas().eliminaReserva(listaReservas.get(reservaMun));			
				setVisible(false);

			}
		});
		atrasB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
			}
		});
		BPanel.add(atrasB);
		BPanel.add(cancelB);
		panel1.add(BPanel,BorderLayout.CENTER);


	}

	@Override
	public void dataUpdate(Model model) {
		// TODO Auto-generated method stub
		
	}


	

	
}