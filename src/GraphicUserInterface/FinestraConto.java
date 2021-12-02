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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Conto.OperazioneException;
import Conto.OperazioniConto;

public class FinestraConto extends JFrame implements ActionListener, WindowListener{

	private JTextField t1;
	private DefaultListModel<OperazioniConto> oC = new DefaultListModel<>();
	private Utenti user;
	private OperazioniConto operazione;
	private DataBaseUtenti db = new DataBaseUtenti();
	
	public FinestraConto() {
		
	}
	
	public FinestraConto(Utenti u) 
	{
		super();
		setSize(500, 350);
		setResizable(false);
		setTitle("BANCA");
		setLayout(null);
		addWindowListener(this);
		this.user = u;
		
		
		JLabel e1 = new JLabel("Benvenuto " + u.getUsername());
		e1.setBounds(15, 10, 300, 20);
		e1.setFont(new java.awt.Font("Times New Roman", 1, 20));
		e1.setForeground(Color.red);
		add(e1);

		for(int i =0; i<user.conto().numOperazioni(); i++) {
			oC.addElement(user.conto().getOperazione(i));
		}
		
		JList<OperazioniConto> lista = new JList<>(oC);
		lista.setBounds(15, 40, 290, 500);
		add(lista);
		
		JButton b1 = new JButton("Preleva");
		b1.addActionListener(this);
		b1.setBounds(320, 70, 150, 25);
		add(b1);
		
		JButton b2 = new JButton("Deposita");
		b2.addActionListener(this);
		b2.setBounds(320, 40, 150, 25);
		add(b2);
		
		JButton b3 = new JButton("Matura Interessi");
		b3.addActionListener(this);
		b3.setBounds(320, 100, 150, 25);
		add(b3);
		
		JLabel e2 = new JLabel("Il tuo saldo ammonta ha:");
		e2.setBounds(320, 140, 150, 25);
		add(e2);
		
		t1 = new JTextField(Integer.toString(u.conto().saldo()));
		t1.setBounds(320, 170, 150, 25);
		t1.setEditable(false);
		add(t1);
		
		JButton b4 = new JButton("Esci");
		b4.setForeground(Color.red);
		b4.addActionListener(this);
		b4.setBounds(320, 280, 150, 25);
		add(b4);
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Preleva")) {
			try {
				String importo = JOptionPane.showInputDialog(null, "Immetti l'importo", "Prelievo");
				if (importo == null)
					throw new OperazioneException("Prelievo annullato");
				
				String data = JOptionPane.showInputDialog(null, "Immetti la data dell'importo", "data", JOptionPane.OK_OPTION);
				
				if (data == null)
					throw new OperazioneException("Prelievo annullato");
				
				user.conto().prelievo(Integer.parseInt(importo), data);
				t1.setText(Integer.toString(user.conto().saldo()));
				oC.addElement(new OperazioniConto(Integer.parseInt(importo), data, false));
				
			}catch(RuntimeException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(),"Allert", JOptionPane.WARNING_MESSAGE);
			}catch(OperazioneException e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage(),"Allert", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(e.getActionCommand().equals("Deposita")) {
			try {
				String importo = JOptionPane.showInputDialog(null, "Immetti l'importo", "Deposito");
				if (importo == null)
					throw new OperazioneException("Deposito annullato");
				
				String data = JOptionPane.showInputDialog(null, "Immetti la data dell'importo", "data", JOptionPane.OK_OPTION);
				
				if (data == null)
					throw new OperazioneException("Deposito annullato");
				
				user.conto().deposito(Integer.parseInt(importo), data);
				t1.setText(Integer.toString(user.conto().saldo()));
				oC.addElement(new OperazioniConto(Integer.parseInt(importo), data, true));
				
			}catch(OperazioneException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(),"Allert", JOptionPane.WARNING_MESSAGE);
			}
		}else if(e.getActionCommand().equals("Esci")) {
			db.scriviFile();
			FinestraLogin f = new FinestraLogin();
			f.setVisible(true);
			this.dispose();
		}else if(e.getActionCommand().equals("Matura Interessi")) {
			user.conto().aggiungiInteressi();
			t1.setText(Integer.toString(user.conto().saldo()));
		}

	}

	public DefaultListModel<OperazioniConto> getoC() {
		return oC;
	}

	public OperazioniConto getOperazione() {
		return operazione;
	}

	public void setOperazione(OperazioniConto operazione) {
		this.operazione = operazione;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		db.scriviFile();
		FinestraLogin f = new FinestraLogin();
		f.setVisible(true);
		
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
