package com.viktormiller;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedCoinsSet {

	private final static Comparator<Coin> COINCOMPARATOR = new Comparator<Coin>() {

		@Override
		public int compare(Coin o1, Coin o2) {

			if (o1.getWert() > o2.getWert()) { 
				return -1; 
			} else if (o1.getWert() < o2.getWert()) {
				return 1;
			} else
				return 0;
		}
	};

	private SortedSet<Coin> sortedCoins = new TreeSet<>(COINCOMPARATOR);

	public SortedCoinsSet() {
		for (Coin coin : Coin.values()) {
			sortedCoins.add(coin);
		}
	}

	public SortedSet<Coin> getSortedCoins() {
		
		return sortedCoins;
	}
	
}
