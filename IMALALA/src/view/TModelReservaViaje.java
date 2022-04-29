package view;

import java.util.ArrayList;
import java.util.Iterator;


import javax.swing.table.AbstractTableModel;

import control.Model;
import model.Reserva;
import model.Viaje;


class TModelReservaViaje extends AbstractTableModel{
    Model model;
    ArrayList<Viaje> listaViajes;

	public TModelReservaViaje(ArrayList<Viaje> listaViajes, Model model) {
		
        this.listaViajes = listaViajes;
      this.model = model;
	}

    @Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		if(listaViajes.size() == 0) {
			return 0;
		}


		return listaViajes.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public String getColumnName(int column) {

		String keys []= {"Viaje ID", "Alojamiento", "TransporteIda", "TransporteVuelta", "Precio", "ReservasDisponibles"};


		return keys[column];
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

		Iterator<Viaje> iter = listaViajes.iterator();
		Viaje viaje=iter.next();
		for(int i=0;i<rowIndex;i++) {

			viaje = iter.next();
		}
		if(columnIndex==0) {

			return viaje.getId(); 
		}else if(columnIndex==1) {
			return viaje.getAlojamiento().getId()+" (" + viaje.getAlojamiento().getCiudad()+ ")";
		}else if(columnIndex==2) {
			return viaje.getTransporteIda().getId()+" (" + viaje.getTransporteIda().getTipoTransporte()+ ")";
		}else if(columnIndex==3) {
			return viaje.getTransporteVuelta().getId()+" (" + viaje.getTransporteVuelta().getTipoTransporte()+ ")";
		}else if(columnIndex==4) {
			return viaje.getPrecio();
		}else if(columnIndex==5) {
			return viaje.getReservasDisponibles();
		}

		return null;
	}
	
}
