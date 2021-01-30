package com.viktormiller;

public class BankE {
	Kasse kasse = new Kasse();
	private static boolean RUECKGELD = true;

	public boolean getRUECKGELD() {
		return RUECKGELD;
	}

	public static void setRUECKGELD(boolean rUECKGELD) {
		RUECKGELD = rUECKGELD;
	}

	public BankE() {
		
	}

	public void getChange(int rueckgabe) {
		while (rueckgabe > 0) {

			Coin coin = getNextCoin(rueckgabe);
			if (coin == null) {
				setRUECKGELD(false);
				break;
			}

			rueckgabe -= coin.getWert();
		}
	} 
 
	public Coin getNextCoin(int rueckgabe) {

		for (Coin coin : new SortedCoinsSet().getSortedCoins()) {

			if (coin.getWert() <= rueckgabe && (kasse.getCoinAnzahl(coin.getWert()) > 0)) {
				kasse.addCoinsBufferAuszahlung(coin.getWert());
				return coin;
			}
		}
		return null;
	}

}
