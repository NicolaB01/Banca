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

public class FinestraRegister extends JFrame implements ActionListener, WindowListener{

	private String username;
	private String pwd;
	private String controllo;
	private JPasswordField t2, t3;
	private JLabel l;
	private Utenti user = null;
	private Banca banca = new Banca();
	private JTextField t1;

	public FinestraRegister() 
	{
		super();
		setSize(500, 350);
		setResizable(false);
		setTitle("BANCA");
		addWindowListener(this);
		setLayout(null);



		JLabel e1 = new JLabel("Registro nuovo utente");
		e1.setFont(new java.awt.Font("Times New Roman", 1, 27));
		e1.setBounds(15, 15, 350, 50);
		e1.setForeground(Color.red);
		add(e1);

		JLabel e2 = new JLabel("Username");
		e2.setBounds(100, 100, 120, 20);
		add(e2);
		t1 = new JTextField(30);
		t1.setBounds(165, 100, 150, 20);
		add(t1);

		JLabel e3 = new JLabel("Password");
		e3.setBounds(100, 130, 120, 20);
		add(e3);
		t2 = new JPasswordField(30);
		t2.setBounds(165, 130, 150, 20);
		add(t2);

		JLabel e4 = new JLabel("Conferma password");
		e4.setBounds(40, 160, 120, 20);
		add(e4);
		t3 = new JPasswordField(30);
		t3.setBounds(165, 160, 150, 20);
		add(t3);

		JButton b1 = new JButton("Registrati");
		b1.addActionListener(this);
		b1.setBounds(210, 190, 100, 20);
		add(b1);

		l = new JLabel();
		l.setBounds(40, 230, 400, 20);
		l.setForeground(Color.red);
		add(l);
	}


	public void actionPerformed(ActionEvent e) {

		username = t1.getText().trim();		
		pwd = new String(t2.getPassword());
		controllo =  new String(t3.getPassword());

		if (pwd.equals(controllo) && !pwd.equals("") && pwd.length() >= 6)
		{
			user = new Utenti(username, pwd);
			if (username.length() >= 4) 
			{
				if (banca.registraUser(user))
				{
					FinestraLogin f = new FinestraLogin();
					f.setVisible(true);
					this.dispose();
				}
				l.setText("L'utente è gia presente nel registro della banca prova ad accedere");
				pulisciMenu();
			}
			else {
				if (pwd.equals("")) {
					l.setText("Campo obbligatiorio non completato");
					pulisciMenu();

				}else {
					l.setText("Il nome utente è troppo corto(minimo 4 caratteri)");
					pulisciMenu();
				}
			}
		}
		else {
			if (pwd.length() < 6)
				l.setText("La password è troppo corta(minimo 6 caratteri)");
			else
				l.setText("Le password non corrispondono");
			
			pulisciMenu();
		}

	}


	private void pulisciMenu() {
		t1.setText("");
		t2.setText("");
		t3.setText("");
	}


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println(DataBaseUtenti.getListaUtenti());
		FinestraLogin f = new FinestraLogin();
		f.setVisible(true);
		this.dispose();
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
