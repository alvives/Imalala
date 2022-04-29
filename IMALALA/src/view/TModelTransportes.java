package view;

import java.util.ArrayList;
import java.util.Iterator;


import javax.swing.table.AbstractTableModel;

import control.Model;
import model.Alojamiento;
import model.Transporte;


class TModelTransportes extends AbstractTableModel{
    Model model;
    ArrayList<Transporte> listaTransportes;
	
	public TModelTransportes (ArrayList<Transporte> listaTransportes, Model model) {
		
        this.listaTransportes = listaTransportes;
      this.model = model;
	}

    @Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		if(listaTransportes.size() == 0) {
			return 0;
		}

		return listaTransportes.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public String getColumnName(int column) {
		String keys []= {"Id transporte", "Capacidad", "tipo"};

		return keys[column];
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

		Iterator<Alojamiento> iter = listaAlojamientos.iterator();
		Alojamiento alojamiento=iter.next();
		for(int i=0;i<rowIndex;i++) {
			alojamiento = iter.next();
		}
		if(columnIndex==0) {
			return alojamiento.getId(); 
		}else if(columnIndex==1) {
			return alojamiento.getCapacidad();
		}else if(columnIndex==2) {
			return alojamiento.getDireccion();
		}else if(columnIndex==3) {
			return alojamiento.getNombreHotel();
		}else if(columnIndex==4) {
			return alojamiento.getCiudad();
		} else if(columnIndex == 5) {
			if(model.getListaViajes().contieneAlojamiento(alojamiento)){
				return "No";
			} else {
				return "Sí";
			}
		}

		return null;
	}
	
}
