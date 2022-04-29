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


//USUARIO: RESERVAR VIAJE
public class View6 extends JFrame implements Observer {
	Model model;
	Usuario u;
	JPanel panel;
	JPanel panel1;
	JTable table;
	TModelReservaViaje tableModel;
	//ArrayList<Reserva> listaReservas;
    ArrayList<Viaje> listaViajes;
	int viajeMun;
	
	/*JScrollPane jScrollPane1 = new JScrollPane();	
	JLabel jLabel1 = new JLabel();

	ArrayList<JLabel> listajLabel = new ArrayList<JLabel>();
	ArrayList<JButton> listajButton = new ArrayList<JButton>();*/
	
	
	public View6(Model model, Usuario u) { 

		try{
			this.model = model;
			this.u = u;
			//listaReservas = model.getListaReservas();//.getReservasUsuario(u);
            listaViajes = model.getListaViajes().getViajes();
			setTitle("Reserva Viajes");
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
		tableModel = new TModelReservaViaje(listaViajes, model); 
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
		CPanel.add(new JLabel("  Selecciona el viaje que quieres reservar "));
		CPanel.add(viajeList);
		panel1.add(CPanel,BorderLayout.PAGE_START);
	}

	private void addBotton() {
		// TODO Auto-generated method stub
		JPanel BPanel=new JPanel();					
		JButton cancelB=new JButton("Reservar viaje");
		JButton atrasB=new JButton("Atras");		



		cancelB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(model.getListaViajes().getViajes().get(viajeMun).getReservasDisponibles() > 0){
                    JDialog ok=new JDialog();
                    ok.setTitle("Viaje reservado");
                    ok.setLocation(getX()+300, getY()+200);
                    JPanel okpanel = new JPanel(new BorderLayout());
                    okpanel.add(new JLabel("Has reservado el viaje "+listaViajes.get(viajeMun).getId()),BorderLayout.PAGE_START);

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

					//añadir una nueva Reserva
					model.getListaReservas().anadeReserva(new Reserva("reserva" + (model.getListaReservas().getReservasUsuario(u).size() + 1), u, model.getListaViajes().getViajes().get(viajeMun), true));

					//disminuir disponibles de viajes
                    model.getListaViajes().getViajes().get(viajeMun).anadirReserva();

					//observer
					model.dataUpdate();

                    setVisible(false);
                }
                else{
                    JDialog ok=new JDialog();
                    ok.setTitle("Error: No se puede reservar el viaje");
                    ok.setLocation(getX()+300, getY()+200);
                    JPanel okpanel = new JPanel(new BorderLayout());
                    okpanel.add(new JLabel("No se puede reservar el viaje " + model.getListaViajes().getViajes().get(viajeMun).getId()), BorderLayout.PAGE_START);
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

	@Override
	public void dataUpdate(Model model) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	Model model;
	Usuario u;
	int x=0;
	
	
	JScrollPane jScrollPane1 = new JScrollPane();	
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	ArrayList<JLabel> listajLabel = new ArrayList<JLabel>();
	ArrayList<JButton> listajButton = new ArrayList<JButton>();
	
	public View6() 	{
	}
	
	public View6(Model model, Usuario u) 	{
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
		this.getContentPane().setLayout(null);
		jScrollPane1.setBounds(new Rectangle(0, 0, 3, 3));
		
        ArrayList<Viaje> listaViajes = model.getListaViajes().getViajes();

		jLabel1.setText("Seleccione el viaje que quiere reservar");
		jLabel1.setBounds(new Rectangle(41, 15, 400, 23));
		
		int y=0;

	
		for (int z=0;z<listaViajes.size();z++) {
			
			x = z;
			
            if(listaViajes.get(z).getReservasDisponibles() != 0){

            listajLabel.add(new JLabel());
			listajLabel.get(z).setText("Viaje: "+ listaViajes.get(z).getAlojamiento().getCiudad() + " " + listaViajes.get(z).getTransporteIda().getTipoTransporte()+ " " 
            + listaViajes.get(z).getTransporteVuelta().getTipoTransporte() + " " + listaViajes.get(z).getPrecio());

			listajLabel.get(z).setBounds(new Rectangle(41, 65+y, 400, 23));

            listajButton.add(new JButton());
            listajButton.get(z).setBounds(new Rectangle(300, 65+y, 100, 27));
		    listajButton.get(z).setText("Reservar");

		    listajButton.get(z).addActionListener(new java.awt.event.ActionListener() 	{

			public void actionPerformed(ActionEvent e)  {
				
				int num = model.getListaReservas().getListaReservas().size()+1;
				
				model.getListaReservas().anadeReserva(new Reserva("reserva"+ num, u, listaViajes.get(x),false));
				model.dataUpdate();		

			}

		    });

			y+=50;

            this.getContentPane().add(listajLabel.get(z), null);
            this.getContentPane().add(listajButton.get(z), null);
            }
		}

		if(listaViajes.size() == 0){

            jLabel2.setText("No hay viajes disponibles en este momento");
		    jLabel2.setBounds(new Rectangle(41, 15, 400, 23));

        }
		
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jLabel2, null);
	}

    void jButton1_actionPerformed(ActionEvent e) {


		
	}
	
	
	@Override
	public void dataUpdate(Model model) {
		// TODO Auto-generated method stub
		
	}
	*/

	
}