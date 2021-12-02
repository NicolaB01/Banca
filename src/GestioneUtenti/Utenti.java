package GestioneUtenti;

import Conto.ContoCorrente;

public class Utenti {
	private String username;
	private String pwd;
	private ContoCorrente cc = new ContoCorrente();
	
	public Utenti() 
	{
		this("", "");
	}
	
	public Utenti(String username, String pwd) 
	{
		this.username = username;
		this.pwd = pwd;
	}

	public String toString() {
		return "username=" + username + ", pwd=" + pwd;
	}

	public String getUsername() {
		return username;
	}

	public String getPwd() {
		return pwd;
	}	
	
	public boolean equals(Object o) {
		if (o != null && (o instanceof Utenti))
		{
			Utenti a = (Utenti)o;
			return this.getUsername().equals(a.getUsername()) && this.getPwd().equals(a.getPwd());
		}
		return false;
	}
	
	public ContoCorrente conto() {
		return cc;
	}
}
