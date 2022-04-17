package view;
import java.awt.Rectangle;
import java.util.ArrayList;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import control.Model;
import control.Observer;
import model.Reserva;
import model.Usuario;
import model.Viaje;

public class View6 extends JFrame implements Observer {
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
	

	
}