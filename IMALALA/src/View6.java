import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.border.*;

public class View6 extends JFrame implements Observer {
	Model model;
	Usuario u;
	
	
	JScrollPane jScrollPane1 = new JScrollPane();	
	JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JButton jButton1 = new JButton();
	ArrayList<JLabel> listajLabel = new ArrayList<JLabel>();
	
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
		
        ArrayList<Viaje> listaViajes = model.listaViajes.getViajes();

		jLabel1.setText("Seleccione el viaje que quiere reservar");
		jLabel1.setBounds(new Rectangle(41, 15, 400, 23));
		
		int y=0;

		for (int z=0;z<listaViajes.size();z++) {

            if(listaViajes.get(z).getReservasDisponibles() != 0){
            listajLabel.add(new JLabel());
			listajLabel.get(z).setText("Viaje: "+ listaViajes.get(z).getId() + listaViajes.get(z).getAlojamiento() + listaViajes.get(z).getTransporteIda() + listaViajes.get(z).getTransporteVuelta()  + listaViajes.get(z).getPrecio());
			listajLabel.get(z).setBounds(new Rectangle(41, 65+y, 400, 23));

            jButton1.setBounds(new Rectangle(42, 52, 300, 27));
		    jButton1.setText("Reservar");

		    jButton1.addActionListener(new java.awt.event.ActionListener() 	{

			public void actionPerformed(ActionEvent e)  {
				
                
			}

		    });

			y+=50;
            this.getContentPane().add(listajLabel.get(z), null);

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