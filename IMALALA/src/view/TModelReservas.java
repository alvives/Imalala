package view;

import java.util.ArrayList;
import java.util.Iterator;


import javax.swing.table.AbstractTableModel;

import control.Model;
import model.Reserva;
import model.Viaje;


class TModelReservas extends AbstractTableModel{
    Model model;
    ArrayList<Reserva> listaReservas;

	public TModelReservas(ArrayList<Reserva> listaReservas, Model model) {
		
        this.listaReservas = listaReservas;
      this.model = model;
	}

    @Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		if(listaReservas.size() == 0) {
			return 0;
		}


		return listaReservas.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public String getColumnName(int column) {

		String keys []= {"Reserva ID", "Usuario", "viaje", "alojamiento", "transporte ida", "transporte vuelta"};


		return keys[column];
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

		Iterator<Reserva> iter = listaReservas.iterator();
		Reserva reserva=iter.next();
		for(int i=0;i<rowIndex;i++) {
			reserva = iter.next();
		}

		if(columnIndex==0) {
			return reserva.getId(); 
		}else if(columnIndex==1) {
			return reserva.getUsuario().getId();
		}else if(columnIndex==2) {
			return reserva.getViaje().getId();
		}else if(columnIndex==3) {
			return reserva.getViaje().getAlojamiento().getNombreHotel() + " (" + reserva.getViaje().getAlojamiento().getCiudad() + ")";
		}else if(columnIndex==4) {
			return reserva.getViaje().getTransporteIda().getId() + " (" + reserva.getViaje().getTransporteIda().getTipoTransporte() + ")";
		}else if(columnIndex==5) {
			return reserva.getViaje().getTransporteVuelta().getId() + " (" + reserva.getViaje().getTransporteVuelta().getTipoTransporte() + ")";
		}
		
		return null;
	}
	
}
