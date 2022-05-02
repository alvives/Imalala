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


public class View8 extends JFrame {/*cancelar viajes, funciÃ³n del gestor: hay que comprabar que no hay ninguna 
                                                        reserva para el viaje seleccionado(soluciÃ³n: poner el numero de reservas y 
                                                        para los viajes con reservas, poner a lado un "no se puede cancelar")(pendiente), 
                                                        si elige uno con reservas saldrÃ¡ un cuadro de error(pendiente)*/
	Model model;
	Gestor g;
	JPanel panel;
	JPanel panel1;
	JTable table;
	TModelViaje tableModel;
	//ArrayList<Reserva> listaReservas;
    ArrayList<Viaje> listaViajes;
	int viajeMun;
	
	/*JScrollPane jScrollPane1 = new JScrollPane();	
	JLabel jLabel1 = new JLabel();

	ArrayList<JLabel> listajLabel = new ArrayList<JLabel>();
	ArrayList<JButton> listajButton = new ArrayList<JButton>();*/
	
	
	
	public View8(Model model, Gestor g) { 

		try{
			this.model = model;
			this.g = g;
			//listaReservas = model.getListaReservas();//.getReservasUsuario(u);
            listaViajes = model.getListaViajes().getViajes();
			setTitle("Cancelar Viajes");
			panel = new JPanel(new BorderLayout());	
			panel1 = new JPanel(new BorderLayout());	
			jbInit();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jbInit() throws Exception 	{

		panel.add(new JLabel( "Gestor: "+ this.g.getNombre()),BorderLayout.PAGE_START);
		addJtable();
		addCombobox();
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
		tableModel = new TModelViaje(listaViajes, model); 
		table.setModel(tableModel);
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(true);
		table.setBorder(BorderFactory.createLineBorder(Color.blue));
		table.setShowGrid(false);		
		
		JScrollPane scb = new JScrollPane(table);
		panel.add(scb,BorderLayout.CENTER);
	}

	private void addCombobox() {//lista deplegable para elegir viajes

		Vector<String> valores = new Vector<String>();

		for(int i=0;i<listaViajes.size();i++) {

			valores.add(listaViajes.get(i).getId());
            
		}

		JComboBox<String> viajeList = new JComboBox<String>(valores);
		viajeList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				viajeMun = viajeList.getSelectedIndex();														
				
			}
		});
		JPanel CPanel =new JPanel();
		CPanel.add(new JLabel("  Selecciona el viaje que quieres cancelar "));
		CPanel.add(viajeList);
		panel1.add(CPanel,BorderLayout.PAGE_START);
	}

	private void addBotton() {
		// TODO Auto-generated method stub
		JPanel BPanel=new JPanel();					
		JButton cancelB=new JButton("Eliminar viaje");
		JButton atrasB=new JButton("Atras");		



		cancelB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(model.getListaReservas().getReservasRealizadas(listaViajes.get(viajeMun)) == 0){
                    JDialog ok=new JDialog();
                    ok.setTitle("Viaje eliminado");
                    ok.setLocation(getX()+300, getY()+200);
                    JPanel okpanel = new JPanel(new BorderLayout());
                    okpanel.add(new JLabel("Has eliminado el viaje "+listaViajes.get(viajeMun).getId()),BorderLayout.PAGE_START);

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

                    model.eliminarViaje(listaViajes.get(viajeMun));

                    setVisible(false);
                }
                else{
                    JDialog ok=new JDialog();
                    ok.setTitle("Error: No se puede eliminar el viaje");
                    ok.setLocation(getX()+300, getY()+200);
                    JPanel okpanel = new JPanel(new BorderLayout());
                    okpanel.add(new JLabel("No se puede eliminar el viaje " + model.getListaReservas().getReservasRealizadas(listaViajes.get(viajeMun))), BorderLayout.PAGE_START);
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
