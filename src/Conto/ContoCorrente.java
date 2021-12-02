package Conto;

import java.util.ArrayList;

public class ContoCorrente {

	private int saldo;
	private ArrayList<OperazioniConto> listaMovimenti = new ArrayList<>();
	
	public ContoCorrente() {
		this.saldo = 0;
	}
	
	public ContoCorrente(int saldo) {
		this.saldo = saldo;
	}
	
	public void deposito(int somma, String data) {
		this.saldo += somma;
		listaMovimenti.add(new OperazioniConto(somma, data, true));
	}
	
	public void prelievo(int somma, String data) {
		if (this.saldo < somma)
			throw new RuntimeException("Saldo non sufficiente!");
		this.saldo -= somma;
		listaMovimenti.add(new OperazioniConto(somma, data, false));
	}
	
	public int saldo() {
		return this.saldo;
	}
	
	public void aggiungiInteressi() {
		if (this.saldo < 100)
			return;
		if ((this.saldo >= 100) && (this.saldo < 1000))
			this.saldo = this.saldo*102/100;
		if (this.saldo >= 1000)
			this.saldo = this.saldo*104/100;
	}

	public String toString() {
		return "Il saldo è di: " + saldo+"\n"+listaMovimenti;
	}

	public int numOperazioni() {
		return listaMovimenti.size();
	}

	public OperazioniConto getOperazione(int i) {
		return listaMovimenti.get(i);
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public void InserisciOperazione(OperazioniConto movimento) {
		this.listaMovimenti.add(movimento);
	}
	
}
