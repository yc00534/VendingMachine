package com.viktormiller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class JUnit_Test {

	Coin coin;

	@Test
	void test() {

		Artikel2 a2;

		BankE be;

		Coin coin = Coin.Muenze_100_Cent;
		assertEquals(100, coin.getWert());
		a2 = new Artikel2();
		a2 = new Artikel2("Test", 10, 1, 2, 2);
		assertEquals(2, a2.getAktuellesBestand());
		assertEquals(2, a2.getMaxBestand());
		assertEquals(1, a2.getMinBestand());
		assertEquals("Test", a2.getName());
		assertEquals(10, a2.getPreis());
		a2.setMinBestand(5);
		assertEquals(5, a2.getMinBestand());
		a2.setPreis(111);
		assertEquals(111, a2.getPreis());
		a2.setMaxBestand(5);
		assertEquals(5, a2.getMaxBestand());
		a2.setAktuellesBestand(5);
		assertEquals(5, a2.getAktuellesBestand());

		be = new BankE();
		// assertEquals(3780, be.gibMirSummeAllerMoneten());
		assertEquals(true, be.getRUECKGELD());
		be.setRUECKGELD(false);
		assertEquals(false, be.getRUECKGELD());
		be.setRUECKGELD(true);
		assertEquals(true, be.getRUECKGELD());
		// be.getChange(10);
		// be.gibMirGrößteMoneteDieRückgabeEntspricht(88998, 1);

	}

	@Test
	void test_Kasse() {
		Kasse k = new Kasse();
		assertEquals(8, k.getArrayList().size());
		assertEquals(1, k.getCoinAnzahl(1));
		assertEquals(1, k.getCoinAnzahl(10));
		assertEquals(1, k.getCoinAnzahl(10));
		assertEquals(8, k.getArrayList().size());
		k.addCoinsBufferAuszahlung(100);
		k.addCoinsBufferEinzahlung(100);
		assertEquals(7, k.getArrayList().size());
		assertEquals(0, k.getCoinAnzahl(100));
		assertEquals(1, k.getCoinAnzahl(200));

		k.CoinsTransmit_IN_FromBufferToKasse();
		k.CoinsTransmit_OUT_FromBufferToUser();
	}

	@Test
	void test_methode_addCoinsBufferEinzahlungAndCancelung() {
		Kasse k = new Kasse();
		assertEquals(0, k.BUFFER_LIST_IN.size());

		for (int i = 0; i < 30; i++) {
			k.addCoinsBufferEinzahlung(50);
		}
		assertEquals(30, k.BUFFER_LIST_IN.size());
		k.CoinsTransmit_IN_cancelung();
		assertEquals(0, k.BUFFER_LIST_IN.size());
		
		for (int i = 0; i < 30; i++) {
			k.addCoinsBufferEinzahlung(50);
		}
		
		assertEquals(1500, k.getSummeBufferEinzahlun());
		

	}

	@Test
	void test_methode_CoinsTransmit_IN_FromBufferToKasse() {
		Kasse k = new Kasse();
		assertEquals(8, k.LIST.size());
		for (int i = 0; i < 30; i++) {
			k.addCoinsBufferEinzahlung(50);
		}
		assertEquals(30, k.BUFFER_LIST_IN.size());
		k.CoinsTransmit_IN_FromBufferToKasse();
		assertEquals(38, k.LIST.size());
	}

	@Test
	void test_methode_addCoinsBufferAuszahlungAndCancelung() {
		Kasse k = new Kasse();
		assertEquals(0, k.BUFFER_LIST_OUT.size());
		for (int i = 0; i < 30; i++) {
			k.addCoinsBufferAuszahlung(100);
		}
		assertEquals(30, k.BUFFER_LIST_OUT.size());
		k.CoinsTransmit_OUT_cancelung();
		assertEquals(0, k.BUFFER_LIST_OUT.size());
	}
	
	@Test
	void test_methode_CoinsTransmit_OUT_FromKasseToUser() {
		
		Kasse k = new Kasse();
		System.out.println(k.LIST.size());
		for (int i = 0; i < 50; i++) {
			k.LIST.add(100);  //add(50);
		}
		for (int i = 0; i < 30; i++) {
			k.addCoinsBufferAuszahlung(100);
		}
		assertEquals(28, k.LIST.size());
		k.CoinsTransmit_OUT_FromBufferToUser();
		assertEquals(28, k.LIST.size()); 
		}
}
