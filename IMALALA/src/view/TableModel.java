package view;

import java.util.ArrayList;
import java.util.Iterator;


import javax.swing.table.AbstractTableModel;


import model.Reserva;


class TableModel extends AbstractTableModel{


    ArrayList<Reserva> listaReservas;
	public TableModel(ArrayList<Reserva> listaReservas) {
		
        this.listaReservas = listaReservas;
      
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
		return 2;
	}

	@Override
	public String getColumnName(int column) {

		String keys []= {"Reserva ID", "Ciudad"};


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


			return reserva.getViaje().getAlojamiento().getCiudad();

		}
		return null;
	}
	
}