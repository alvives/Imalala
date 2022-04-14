import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class Controller extends JFrame {
	
	Model model = new Model();
	
	JScrollPane jScrollPane1 = new JScrollPane();
	JButton jButton1 = new JButton();
	JButton jButton2 = new JButton();
	JTextField jTextField1 = new JTextField();
	JTextField jTextField2 = new JTextField();
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	
	public Controller() {
		try {
			jbInit();
		}
		catch(Exception e)	{
			e.printStackTrace();
		}
	
	}
	
	private void jbInit() throws Exception 	{
		model.anadirUsuario(new Usuario());
			
		this.getContentPane().setLayout(null);
		jScrollPane1.setBounds(new Rectangle(0, 0, 3, 3));
		jButton1.setBounds(new Rectangle(300, 100, 150, 27));
		jButton1.setText("Iniciar sesion");
		jButton1.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton1_actionPerformed(e);
			}
		});
		jButton2.setBounds(new Rectangle(80, 240, 150, 27));
		jButton2.setText("Registrarse");
		jButton2.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton2_actionPerformed(e);
			}
		});
		jTextField1.setText("");
		jTextField1.setBounds(new Rectangle(150, 55, 100, 31));
		jTextField2.setText("");
		jTextField2.setBounds(new Rectangle(150, 100, 100, 31));
		jLabel1.setText("Introduzca sus datos para iniciar sesion:");
		jLabel1.setBounds(new Rectangle(41, 15, 300, 23));
		jLabel2.setText("Id:");
		jLabel2.setBounds(new Rectangle(42, 52, 35, 33));
		jLabel3.setText("Contrasena:");
		jLabel3.setBounds(new Rectangle(42, 100, 80, 31));
		jLabel4.setText("Pulse el siguiente botón si quiere registrarse:");
		jLabel4.setBounds(new Rectangle(42, 200, 300, 27));
		this.getContentPane().add(jScrollPane1, null);
		this.getContentPane().add(jTextField2, null);
		this.getContentPane().add(jTextField1, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(jLabel3, null);
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jLabel4, null);
		this.getContentPane().add(jButton1, null);
		this.getContentPane().add(jButton2, null);
	}
	
	// Presione el botón Actualizar para notificar al Modelo que los datos han cambiado.
	void jButton1_actionPerformed(ActionEvent e) {
		String id = jTextField1.getText();
		System.out.println(id);
		String contrasena = jTextField2.getText();
		System.out.println(contrasena);
		if(this.model.buscarUsuarioContrasena(id, contrasena)) {
			System.out.println("Usuario encontrado");
		} else {
			System.out.println("Usuario no encontrado");			
		}
	}
	void jButton2_actionPerformed(ActionEvent e) {
		
	}
	public static void main(String[] args){
		Controller c = new Controller();
		c.setSize(475,410);
		c.setVisible(true);
		
	}
}