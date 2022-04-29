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
import model.Alojamiento;
import model.Reserva;
import model.Transporte;

public class VistaEliminarTransporte extends JFrame {
	Model model;
	JPanel panel;
	JPanel panel1;
	JTable table;
	TModelTransportes tableModel;
	ArrayList<Transporte> listaTransportes;
	int alojamientoNum;
	
	/*JScrollPane jScrollPane1 = new JScrollPane();	
	JLabel jLabel1 = new JLabel();

	ArrayList<JLabel> listajLabel = new ArrayList<JLabel>();
	ArrayList<JButton> listajButton = new ArrayList<JButton>();*/
	
	
	
	public VistaEliminarTransporte (Model model) 	{

		try{
			this.model = model;
			listaAlojamientos = model.getListaAlojamientos().getListaAlojamiento();
			setTitle("Eliminar alojamiento");
			panel = new JPanel(new BorderLayout());	
			panel1 = new JPanel(new BorderLayout());	
			jbInit();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jbInit() throws Exception 	{

		panel.add(new JLabel( "Seleccione el alojamiento que desea eliminar y pulse 'eliminar' "),BorderLayout.PAGE_START);
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
		tableModel = new TModelAlojamientos(listaAlojamientos, model); 
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

		for(int i=0;i<listaAlojamientos.size();i++) {

			valores.add(listaAlojamientos.get(i).getId());

		}

		JComboBox<String> reservaList = new JComboBox<String>(valores);
		reservaList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				alojamientoNum = reservaList.getSelectedIndex();														
				
			}
		});
		JPanel CPanel =new JPanel();
		CPanel.add(new JLabel("Selecciona el alojamiento que quieres eliminar"));
		CPanel.add(reservaList);
		panel1.add(CPanel,BorderLayout.PAGE_START);
	}
	private void addBotton() {
		JPanel BPanel=new JPanel();					
		JButton cancelB=new JButton("Eliminar");
		JButton atrasB=new JButton("Atras");

		cancelB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!model.getListaViajes().contieneAlojamiento(model.getListaAlojamientos().getListaAlojamiento().get(alojamientoNum))){
                    JDialog ok=new JDialog();
                    ok.setTitle("Alojamiento eliminado");
                    ok.setLocation(getX()+300, getY()+200);
                    JPanel okpanel = new JPanel(new BorderLayout());
                    okpanel.add(new JLabel("Has eliminado el alojamiento "+listaAlojamientos.get(alojamientoNum).getId()),BorderLayout.PAGE_START);

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

                    model.getListaAlojamientos().eliminarAlojamiento(listaAlojamientos.get(alojamientoNum));

                    setVisible(false);
                }
                else{
                    JDialog ok=new JDialog();
                    ok.setTitle("Error: No se puede eliminar el alojamiento");
                    ok.setLocation(getX()+300, getY()+200);
                    JPanel okpanel = new JPanel(new BorderLayout());
                    okpanel.add(new JLabel("No se puede eliminar el alojamiento " + model.getListaAlojamientos().getListaAlojamiento().get(alojamientoNum).getId()), BorderLayout.PAGE_START);
                    JButton okButton =new JButton("VOLVER");
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
                
                }
























				/*
				JDialog ok=new JDialog();
				ok.setTitle("Alojamiento eliminado");
				ok.setLocation(getX()+300, getY()+200);
				JPanel okpanel = new JPanel(new BorderLayout());
				okpanel.add(new JLabel("Has cancelado la reserva "+listaAlojamientos.get(alojamientoNum).getId()),BorderLayout.PAGE_START);

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
				model.getListaAlojamientos().eliminarAlojamiento(listaAlojamientos.get(alojamientoNum));	
				model.dataUpdate();		
				setVisible(false);*/

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

}