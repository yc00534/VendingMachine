package com.viktormiller;

import java.util.ArrayList;
import java.util.Iterator;

public class Kasse {

	public static ArrayList<Integer> LIST, BUFFER_LIST_OUT, BUFFER_LIST_IN;
	Iterator<Integer> iterator;
	

	private static void kasseErstellen() {

		BUFFER_LIST_IN = new ArrayList<Integer>();
		BUFFER_LIST_OUT = new ArrayList<Integer>();

		LIST = new ArrayList<Integer>();

		// Kasse mit Kleingeld füllen
		for (int i = 0; i < 1; i++) {
			for (Coin coin : Coin.values()) {
				LIST.add(coin.getWert());
			}
		}
	}

	public Kasse() {
		kasseErstellen();
	}

	// FUEr den Test
	public ArrayList<Integer> getArrayList() {
		return LIST;
	}

	public void removeCoin(int CoinWert) {

		for (int i = LIST.size(); i > 0; i--) {
			if (CoinWert == LIST.get(i - 1)) {
				LIST.remove(i - 1);
				i = 0;
			}
		}
	}

//########################################################################################
	public void addCoinsBufferEinzahlung(int CoinWert) {
		BUFFER_LIST_IN.add(CoinWert);
	}
	

	public void CoinsTransmit_IN_cancelung() {
		for (int i = BUFFER_LIST_IN.size(); i > 0; i--) {
			BUFFER_LIST_IN.remove(i - 1);
		}
	}
	

	public void CoinsTransmit_IN_FromBufferToKasse() {
		for (int i = BUFFER_LIST_IN.size(); i > 0; i--) {
			LIST.add(BUFFER_LIST_IN.get(i - 1));
			BUFFER_LIST_IN.remove(i - 1);
		}
	}
	

	// ########################################################################################

	public void addCoinsBufferAuszahlung(int CoinWert) {
		removeCoin(CoinWert);
		BUFFER_LIST_OUT.add(CoinWert);
	}
	

	public void CoinsTransmit_OUT_cancelung() {
		for (int i = BUFFER_LIST_OUT.size(); i > 0; i--) {
			LIST.add(BUFFER_LIST_OUT.get(i - 1));
			
			BUFFER_LIST_OUT.remove(i - 1);
		}
	}

	
	public void CoinsTransmit_OUT_FromBufferToUser() {
		for (int i = BUFFER_LIST_OUT.size(); i > 0; i--) {
			System.out.println("Restgeldauszahlung an Kunde: "+BUFFER_LIST_OUT.get(i-1));
			BUFFER_LIST_OUT.remove(i - 1);
		}
	}
	

//##################################################################################################

	public int getCoinAnzahl(int CoinWert) {
		int x = 0;
		iterator = LIST.iterator();
		while (iterator.hasNext()) {

			if (CoinWert == iterator.next()) {
				x++;
			}
		}
		return x;
	}
	

	public double getSummeKasse() {
		double x = 0;
		iterator = LIST.iterator();
		while (iterator.hasNext()) {
			x += iterator.next();
		}
		return x / 100;
	}
	

	public int getSummeBufferRückgeld() {
		int x = 0;
		iterator = BUFFER_LIST_OUT.iterator();
		while (iterator.hasNext()) {
			x += iterator.next();
		}
		return x;
	}

	public int getSummeBufferEinzahlun() {
		int x = 0;
		iterator = BUFFER_LIST_IN.iterator();
		while (iterator.hasNext()) {
			x += iterator.next();
		}
		return x;
	}
	
	
}
