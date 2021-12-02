package MainTerminale;

import GestioneUtenti.DataBaseUtenti;
import GraphicUserInterface.*;


public class MainDemo {
	public static void main(String[] args) {
		DataBaseUtenti db = new DataBaseUtenti();
		db.leggiFile();
		FinestraLogin f = new FinestraLogin();
		f.setVisible(true);
		
		
		
		
		/*
		 * senza interfacce grafiche
		 * 
		Banca b = new Banca("Impresa san paolo");
		Scanner in = new Scanner(System.in);
		Utenti user;

		byte scelta = 0, scelta2 = 0;
		do {
			System.out.println("""
					MENU
					0) esci
					1) per accedere alla banca
					2) per registrare un utente nella banca
					3) stampa lista user
					""");
			scelta = in.nextByte();
			in.nextLine();

			switch(scelta) {
			case 0:
				System.exit(0);
				break;
			case 1:
				System.out.println("inserisci l'username e la pwd");
				user = new Utenti(in.next(), in.next());
				if (b.controlloAccesso(user))
				{
					System.out.println("Benvenuto "+ user.getUsername());
					do {
						System.out.println("""
								0) ucire
								1)saldo
								2)preleva
								3)deposita
								4)controlla movimenti
								""");
						scelta2 = in.nextByte();
						in.nextLine();

						switch(scelta2) {
						case 0:
							break;
						case 1:
							System.out.println("Il saldo è:"+ user.conto().saldo());
							break;
						case 2:
							System.out.println("Inserisci l'importo del prelievo e la data");
							try {
							user.conto().prelievo(in.nextInt(), in.next());
							}catch(RuntimeException e) {
								System.out.println(e);
							}
							break;
						case 3:
							System.out.println("Inserisci l'importo del deposito e la data");
							user.conto().deposito(in.nextInt(), in.next());
							break;
						case 4:
							System.out.println(user.conto());
						}
					}while (scelta2 != 0);
				}
				else {
					System.out.println("Utente non presente");
				}
				break;
			case 2:
				System.out.println("inserisci l'username e la pwd");
				if (b.registraUser(new Utenti(in.next(), in.next()))){
					System.out.println("User registrato");
				}else {
					System.out.println("user gia presente ");
				}
				break;
			case 3:
				System.out.println(b);
			}
		}while (scelta != 0);
		*/
	}

}
