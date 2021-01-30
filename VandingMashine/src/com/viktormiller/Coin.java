package com.viktormiller;

public enum Coin {

	Muenze_1_Cent(1), 
	Muenze_2_Cent(2), 
	Muenze_5_Cent(5),  
	Muenze_10_Cent(10), 
	Muenze_20_Cent(20), 
	Muenze_50_Cent(50),
	Muenze_100_Cent(100),
	Muenze_200_Cent(200);

	private int Wert;

	Coin(int wert) {
		
		Wert = wert;
	}


	public int getWert() {
		return Wert;
	}

} 
