package GestioneBanca;


import java.util.ArrayList;

import GestioneUtenti.DataBaseUtenti;
import GestioneUtenti.Utenti;

public class Banca {
	
	private String nomeBanca;
	
	public Banca() {
		this("");
	}
	
	public Banca(String nomeBanca) {
		this.nomeBanca = nomeBanca;
	}

	/**
	 * @param user un utente da controllare se presente già nella banca
	 * @return se l'utente è presente o no nella banca
	 */
	
	public boolean controlloAccesso(Utenti user) 
	{
		for (Utenti u: DataBaseUtenti.getListaUtenti()) {
			if (u.equals(user)) {
				return true;
			}
		}

		return false;
	}
	
	public Utenti ritornoAccesso(Utenti user) 
	{
		for (Utenti u: DataBaseUtenti.getListaUtenti()) {
			if (u.equals(user)) {
				return u;
			}
		}

		return null;
	}
	

	/**
	 * @param user un utente da inserire se non presente nella lista utenti
	 * @return se la registrazione è avvenuta con successo
	 */
	public boolean registraUser(Utenti user) 
	{
		if (!controlloAccesso(user)) 
		{
			inserisciUser(user);
			return true;
		}
		return false;
	}
	
	/**
	 * @param user un utente da inserire
	 */
	public void inserisciUser(Utenti user) 
	{
		DataBaseUtenti.getListaUtenti().add(user);
	}

	
	public String toString() {
		return "La banca "+ nomeBanca +" ha nel suo database questi utenti "+ DataBaseUtenti.getListaUtenti();
	}

	public static ArrayList<Utenti> getListaUser() {
		return DataBaseUtenti.getListaUtenti();
	}
}