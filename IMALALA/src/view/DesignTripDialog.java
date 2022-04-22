package view;

import java.awt.*;

import javax.swing.*;

import java.util.List;

public class DesignTripDialog extends JDialog{
    private JComboBox <String> transpIda;
    private JComboBox <String> transpVuelta;
    private JComboBox <String> alojamiento;
    private DefaultComboBoxModel <String> _transpIdaModel;
    private DefaultComboBoxModel <String> _transpVueltaModel;
    private DefaultComboBoxModel <String> _alojamientoModel;
    private int _status=0;
    private JSpinner reservasDisp;
    private JTextField priceField;
    private JTextField idField;

    public DesignTripDialog(JFrame Parent){
        super(Parent, true);
        init();
    }

    private void init() {
        setTitle("Diseña un viaje");
		JPanel mainPanel= new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); 
		setContentPane(mainPanel);
		
        JLabel helpMsg = new JLabel("<html><p>Diseñe un viaje rellenando los datos siguientes </p></html>");
		helpMsg.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(helpMsg);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		
		JPanel viewsPanel = new JPanel();
        viewsPanel.setLayout(new GridLayout(0,2));
		viewsPanel.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(viewsPanel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		
        JPanel buttonsPanel = new JPanel();
		buttonsPanel.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(buttonsPanel);
		
		viewsPanel.add( new JLabel("Id del viaje: "));
        idField=new JTextField();
        idField.setText("");
		idField.setBounds(new Rectangle(150, 50, 100, 31));
        viewsPanel.add(idField);

        viewsPanel.add( new JLabel("Id de Alojamientos: "));
		_alojamientoModel =  new DefaultComboBoxModel<>(); 
		alojamiento = new JComboBox<>(_alojamientoModel);
		viewsPanel.add(alojamiento);

        viewsPanel.add( new JLabel("Transporte de ida: "));
		_transpIdaModel =  new DefaultComboBoxModel<>(); 
		transpIda = new JComboBox<>(_transpIdaModel);
		viewsPanel.add(transpIda);

        viewsPanel.add( new JLabel("Transporte de vuelta: "));
		_transpVueltaModel =  new DefaultComboBoxModel<>(); 
		transpVuelta = new JComboBox<>(_transpVueltaModel);
		viewsPanel.add(transpVuelta);

        reservasDisp= new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1)); 
		viewsPanel.add( new JLabel("Reservas Disponibles: "));
		viewsPanel.add(reservasDisp);

        viewsPanel.add( new JLabel("Precio: "));
        priceField=new JTextField();
        priceField.setText("");
		priceField.setBounds(new Rectangle(150, 50, 100, 31));
        viewsPanel.add(priceField);

        JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(e-> { 
            _status=0; 
            DesignTripDialog.this.setVisible(false);
        });
		buttonsPanel.add(cancelButton);

		JButton okButton = new JButton("Crear Viaje");
		okButton.addActionListener(e-> {
			if(priceField.getText()!=null && idField.getText()!=null 
            && (int)reservasDisp.getValue()!=0){
                try{
                    Double.parseDouble(priceField.getText());
                    _status=1; 
                    DesignTripDialog.this.setVisible(false);
                }catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null, "El formato del precio esta mal, separe los digitos con un punto");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Te faltan datos por rellenar!! Asegure que ha puesto al menos 1 reserva");
            }

        });
		buttonsPanel.add(okButton);
           
        setSize(600, 400);
		setResizable(true);
		setVisible(false);
		
    }


    public int open(List<String> listTransp,List<String> listAloj){
        _status=0;
        _transpIdaModel.removeAllElements();
        _transpVueltaModel.removeAllElements();
        for(String id: listTransp){
            _transpIdaModel.addElement(id);
            _transpVueltaModel.addElement(id);
        }

        _alojamientoModel.removeAllElements();
        for(String id: listAloj){
            _alojamientoModel.addElement(id);
        }
        this.setLocationRelativeTo(null);
		setVisible(true);
	
		return _status;
    }

    public String getIdViaje() {
		return idField.getText();
	}
    public String getTranspIda() {
		return (String) _transpIdaModel.getSelectedItem();
	}
    public String getTranspVuelta() {
		return (String) _transpVueltaModel.getSelectedItem();
	}

    public String getAlojamiento() {
		return (String) _alojamientoModel.getSelectedItem();
	}
    public int getReservas() {
		return (int) reservasDisp.getValue();
	}

    public double getPrecio(){
        return Double.parseDouble(priceField.getText());
    }
    
}
