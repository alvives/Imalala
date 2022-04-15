

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.border.*;
public class View2 extends JFrame implements Observer {
	Model model;
	
	JScrollPane jScrollPane1 = new JScrollPane();	

	JTextField jTextField1 = new JTextField();
	JTextField jTextField2 = new JTextField();
	JTextField jTextField3 = new JTextField();
	JTextField jTextField4 = new JTextField();
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JButton jButton1 = new JButton();
	

	
	
	public View2() 	{
	}
	
	public View2(Model model) 	{
	try 	{
		this.model = model;
		jbInit();
		}
		catch(Exception e) 	{
		e.printStackTrace();
		}
	}
	
	private void jbInit() throws Exception 	{
		this.getContentPane().setLayout(null);
		jScrollPane1.setBounds(new Rectangle(0, 0, 3, 3));
		
		jButton1.setBounds(new Rectangle(42, 52, 300, 27));
		jButton1.setText("Registrarse");
		jButton1.addActionListener(new java.awt.event.ActionListener() 	{
			public void actionPerformed(ActionEvent e)  {
				jButton1_actionPerformed(e);
			}
		});
		
		jLabel1.setText("Introduzca sus datos:");
		jLabel1.setBounds(new Rectangle(41, 15, 400, 23));
		
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jButton1, null);
		
	}

	void jButton1_actionPerformed(ActionEvent e) {
		
	}
		
	@Override
	public void dataUpdate(Model model) {
		// TODO Auto-generated method stub
		
	}
	

	
}