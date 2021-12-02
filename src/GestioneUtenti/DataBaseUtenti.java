package GestioneUtenti;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import Conto.OperazioniConto;
import GestioneBanca.Banca;

public class DataBaseUtenti {
	
	private PrintWriter outputStream = null;
	private Scanner inputStream = null;
	private static ArrayList<Utenti> listaUtenti = new ArrayList<>();
	private File f = new File("UtentiData.txt");

	public DataBaseUtenti() {}

	public void scriviFile() {
		
		try {
			outputStream = new PrintWriter(new FileWriter(f));
		} catch (FileNotFoundException e) {
			System.out.println("File non trovato");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("Errore file");
			System.exit(0);
		}
		for (Utenti u: listaUtenti) {
			
			outputStream.print(u.getUsername()+",");
			outputStream.print(u.getPwd()+",");
			outputStream.print(u.conto().saldo()+",");
			outputStream.print(u.conto().numOperazioni()+",");
			for (int i=0; i<u.conto().numOperazioni(); i++) {
				outputStream.print(u.conto().getOperazione(i).getImporto()+",");
				outputStream.print(u.conto().getOperazione(i).getData()+",");
				outputStream.print(u.conto().getOperazione(i).getTipoOperazione()+",");
			}
			outputStream.println();
		}
		
		outputStream.close();

	}

	public void leggiFile() {
		if (!f.exists())
			scriviFile();
		else {
			try {
				inputStream = new Scanner(f);
			} catch (FileNotFoundException e) {
				System.out.println("File non trovato");
				System.exit(0);
			}
			while (inputStream.hasNextLine()) {
				String riga = inputStream.nextLine();
				String[] a = riga.split(",");
				Utenti u = new Utenti(a[0], a[1]);
				u.conto().setSaldo(Integer.parseInt(a[2]));
				int contatore = Integer.parseInt(a[3]);
				for (int i=1; contatore > 0; contatore--) 
					u.conto().InserisciOperazione(new OperazioniConto(Integer.parseInt(a[3+i++]),a[3+i++], Boolean.parseBoolean(a[3+i++])));	
				listaUtenti.add(u);
			}
			inputStream.close();
		}

	}

	public static ArrayList<Utenti> getListaUtenti() {
		return listaUtenti;
	}

	public static void setListaUtenti(ArrayList<Utenti> listaUtenti) {
		DataBaseUtenti.listaUtenti = listaUtenti;
	}

	@Override
	public String toString() {
		return "DataBaseUtenti "+ listaUtenti;
	}
	
	
}
