package com.viktormiller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kommunikation2 {

	public static void main(String[] args) {

		new Kommunikation2();
	}

	public Kommunikation2() {
		textBildschirm();
	}

	public Kommunikation2(int JUNITTEST) {

	}

	private static int TEILMENGE = 0;

	public static int getTEILMENGE() {
		return TEILMENGE;
	}

	public static void setTEILMENGE(int tEILMENGE) {
		TEILMENGE = tEILMENGE;
	}

	Artikel2 art1 = new Artikel2("CocaCola", 100, 2, 10, 2);
	Artikel2 art2 = new Artikel2("Fanta", 100, 2, 10, 10);
	Artikel2 art3 = new Artikel2("Kaffee", 60, 2, 10, 7);
	Artikel2 art4 = new Artikel2("Tee", 45, 2, 10, 8);
	Artikel2 art5 = new Artikel2("Saft", 80, 1, 10, 9);
	
	int userEin;
	int auswahl ;
	String Name;
	Coin coin;
	Kasse kasse = new Kasse();
	BankE bank = new BankE();

	public void ausgabeAnnonsieren(Artikel2 Artik) {

		if (bank.getRUECKGELD() == true && (kasse.getSummeBufferR�ckgeld()==((userEin + getTEILMENGE()) - Artik.getPreis()))) {
			Artik.setAktuellesBestand(Artik.getAktuellesBestand() - 1);

			System.out.println("Artikelausgabe: " + Artik.getName());

			kasse.CoinsTransmit_IN_FromBufferToKasse();
			kasse.CoinsTransmit_OUT_FromBufferToUser();
			setTEILMENGE(0);
			textBildschirm();
		} else { 
			System.out.println("Changegeld nicht vorhanden.");
			kasse.CoinsTransmit_IN_cancelung();
			kasse.CoinsTransmit_OUT_cancelung();
			bank.setRUECKGELD(true);
			textBildschirm();
		}

	}

	public void textBildschirm() {
		System.out.println(" ");
		System.out.println(" + + + + + ");
		System.out.println(kasse.getSummeKasse());
		System.out.println("W�hlen Sie eine 1 f�r " + art1.getName() + "\t\tPreis: " + art1.getPreis()
				+ " Cent. Es sind noch " + art1.getAktuellesBestand() + " Artikel vorhanden.");
		System.out.println("W�hlen Sie eine 2 f�r " + art2.getName() + "\t\tPreis: " + art2.getPreis()
				+ " Cent. Es sind noch " + art2.getAktuellesBestand() + " Artikel vorhanden.");
		System.out.println("W�hlen Sie eine 3 f�r " + art3.getName() + "\t\tPreis: " + art3.getPreis()
				+ " Cent. Es sind noch " + art3.getAktuellesBestand() + " Artikel vorhanden.");
		System.out.println("W�hlen Sie eine 4 f�r " + art4.getName() + "\t\tPreis: " + art4.getPreis()
				+ " Cent. Es sind noch " + art4.getAktuellesBestand() + " Artikel vorhanden.");
		System.out.println("W�hlen Sie eine 5 f�r " + art5.getName() + "\t\tPreis: " + art5.getPreis()
				+ " Cent. Es sind noch " + art5.getAktuellesBestand() + " Artikel vorhanden.");
		userEin=0;
		userEingabe();
	}

	public void userEingabe() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			auswahl = Integer.parseInt(br.readLine());
			if (auswahl > 5 || auswahl < 1) {
				System.out.println("Artikel nicht vorhanden.");
				textBildschirm();
				return;
			}
		} catch (NumberFormatException e) {
			System.out.println("Falsche Eingabe!");
			textBildschirm();
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}

		switch (auswahl) {
		case 1:
			if (art1.getAktuellesBestand() == 0) {
				System.out.println("Kein Bestand. W�hlen Sie ein anderes Artikel");
				userEingabe();
				return;
			}
			System.out.println("Sie haben " + art1.getName() + " f�r " + art1.getPreis()
					+ " Cent gew�hlt. Werfen Sie bitte das Geld ein. Centbetr�ge als M�nze werden erwartet:");
			userEinwurf(art1);
			break;
		case 2:
			if (art2.getAktuellesBestand() == 0) {
				System.out.println("Kein Bestand. W�hlen Sie ein anderes Artikel");
				userEingabe();
				return;
			}
			System.out.println("Sie haben " + art2.getName() + " f�r " + art2.getPreis()
					+ " Cent gew�hlt. Werfen Sie bitte das Geld ein. Centbetr�ge als M�nze werden erwartet:");
			userEinwurf(art2);
			break;
		case 3:
			if (art3.getAktuellesBestand() == 0) {
				System.out.println("Kein Bestand. W�hlen Sie ein anderes Artikel");
				userEingabe();
				return;
			}
			System.out.println("Sie haben " + art3.getName() + " f�r " + art3.getPreis()
					+ " Cent gew�hlt. Werfen Sie bitte das Geld ein. Centbetr�ge als M�nze werden erwartet:");
			userEinwurf(art3);
			break;
		case 4:
			if (art4.getAktuellesBestand() == 0) {
				System.out.println("Kein Bestand. W�hlen Sie ein anderes Artikel");
				userEingabe();
				return;
			}
			System.out.println("Sie haben " + art4.getName() + " f�r " + art4.getPreis()
					+ " Cent gew�hlt. Werfen Sie bitte das Geld ein. Centbetr�ge als M�nze werden erwartet:");
			userEinwurf(art4);
			break;
		case 5:
			if (art5.getAktuellesBestand() == 0) {
				System.out.println("Kein Bestand. W�hlen Sie ein anderes Artikel");
				userEingabe();
				return;
			}
			System.out.println("Sie haben " + art5.getName() + " f�r " + art5.getPreis()
					+ " Cent gew�hlt. Werfen Sie bitte das Geld ein. Centbetr�ge als M�nze werden erwartet:");
			userEinwurf(art5);
			break;
		default:
			System.out.println("Irgendwas ist schief gegangen.");
		}
	}

	public boolean checkObM�nzeExistiert(int x) {

		for (Coin coin : Coin.values()) {
			if (coin.getWert() == (x))
				return true;
		}
		return false;
	}

	public void userEinwurf(Artikel2 Artik) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			userEin = Integer.parseInt(br.readLine());

			if (checkObM�nzeExistiert(userEin) == false) {
				System.out.println("Falsche M�nze. Probiere es nochmal");
				userEinwurf(Artik);
				return;
			}

			for (Coin coin : Coin.values()) {

				if (coin.getWert() == userEin && (userEin + getTEILMENGE()) == Artik.getPreis()) {
					kasse.addCoinsBufferEinzahlung(coin.getWert());
					System.out.println("+UFF: "+((userEin + getTEILMENGE()) - Artik.getPreis()));
					System.out.println("+ KASSE PUFFER "+kasse.getSummeBufferR�ckgeld());
					ausgabeAnnonsieren(Artik); 
					setTEILMENGE(0);

				} else if (coin.getWert() == userEin && (coin.getWert() + getTEILMENGE()) >= Artik.getPreis()) {
					// kasse.addCoin(coin.getWert());
					kasse.addCoinsBufferEinzahlung(coin.getWert());
					bank.getChange(((userEin + getTEILMENGE()) - Artik.getPreis()));
					ausgabeAnnonsieren(Artik);
					setTEILMENGE(0);

				} else if (coin.getWert() == userEin && (coin.getWert() + getTEILMENGE()) < Artik.getPreis()) {
					System.out.println(
							"bitte noch " + (Artik.getPreis() - getTEILMENGE() - coin.getWert()) + " einwerfen");
					kasse.addCoinsBufferEinzahlung(coin.getWert());
					setTEILMENGE(getTEILMENGE() + coin.getWert());
					userEinwurf(Artik);
				}
			}

		} catch (NumberFormatException e) {
			System.err.println("Falsche Eingabe! Bitte das M�nzenwert in Cent eingeben.");
			userEinwurf(Artik);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}