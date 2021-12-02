package GraphicUserInterface;

import GestioneUtenti.*;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import GestioneBanca.Banca;

public class FinestraLogin extends JFrame implements ActionListener, WindowListener{
	
	private DataBaseUtenti db = new DataBaseUtenti();
	private JLabel e5;
	private JTextField t1;
	private JPasswordField t2;
	private Utenti user;
	private Banca banca = new Banca();
	
	public FinestraLogin() 
	{
		super();
		setSize(500, 350);
		setResizable(false);
		setTitle("BANCA");
		setLayout(null);
		
		JLabel e1 = new JLabel("Accesso alla Banca");
		e1.setFont(new java.awt.Font("Times New Roman", 1, 27));
		e1.setForeground(Color.red);
		e1.setBounds(15, 15, 250, 50);
		add(e1);
	
		JLabel e2 = new JLabel("Username");
		e2.setBounds(100, 100, 120, 20);
		t1 = new JTextField(30);
		t1.setToolTipText("Inserisci l'username qui");
		t1.setBounds(165, 100, 150, 20);
		add(e2);
		add(t1);
		
		
		JLabel e3 = new JLabel("Password");
		e3.setBounds(100, 130, 120, 20);
		add(e3);
		t2 = new JPasswordField(30);
		t2.setToolTipText("Inserisci la Password");
		t2.setBounds(165, 130, 150, 20);
		add(e3);
		add(t2);
		
		JButton b1 = new JButton("Accedi");
		b1.addActionListener(this);
		b1.setBounds(160, 160, 100, 20);
		add(b1);
		
		JLabel e4 = new JLabel("Non hai un account? Registrati cliccanco qui");
		e4.setBounds(50, 250, 300, 20);
		add(e4);
		
		e5 = new JLabel();
		e5.setBounds(100, 200, 300, 20);
		e5.setForeground(Color.red);
		add(e5);
		
		JButton b2 = new JButton("Registrati");
		b2.addActionListener(this);
		b2.setBounds(320, 250, 100, 20);
		add(b2);	
	}


	public void actionPerformed(ActionEvent e) 
	{
		if (e.getActionCommand().equals("Accedi")) {
			user =banca.ritornoAccesso(new Utenti(t1.getText().trim(), new String(t2.getPassword())));
			if (user != null) {
				FinestraConto f = new FinestraConto(user);
				f.setVisible(true);
				this.dispose();
			}else {
				e5.setText("Username o password errati");
				t1.setText("");
				t2.setText("");
			}
		}else if(e.getActionCommand().equals("Registrati")) {
			FinestraRegister f = new FinestraRegister();
			f.setVisible(true);
			this.dispose();
		}else {
			System.out.println("errore");
		}
	}


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosing(WindowEvent e) {
		db.scriviFile();
		System.exit(0);
		
	}


	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
