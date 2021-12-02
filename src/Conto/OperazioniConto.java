package Conto;

public class OperazioniConto {
	private String data;
	private int importo;
	private boolean tipoOperazione; 
	
	public OperazioniConto() {
		this(0,"", false);
	}
	
	public OperazioniConto( int importo, String data, boolean operazione) {
		this.data = data;
		this.importo = importo;
		this.tipoOperazione = operazione; //deposito se operazione è true o un prelievo se operazione e false
	}

	public String toString() {
		return tipoOperazione+" in data "+data+" ammonta a "+ importo + " euro";
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getImporto() {
		return importo;
	}

	public void setImporto(int importo) {
		this.importo = importo;
	}

	public String getTipoOperazione() {
		return (tipoOperazione) ? "Deposito" : "Prelievo";
	}

	public void setTipoOperazione(boolean tipoOperazione) {
		this.tipoOperazione = tipoOperazione;
	}
	
	
}
