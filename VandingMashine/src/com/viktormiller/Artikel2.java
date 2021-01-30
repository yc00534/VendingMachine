package com.viktormiller;

public class Artikel2 {

	private String name;
	private int preis;
	private int minBestand;
	private int maxBestand;
	private int AktuellesBestand;

	public Artikel2(String name, int preis, int minBestand, int maxBestand, int aktuellesBestand) {
		super();
		this.name = name;
		this.preis = preis;
		this.minBestand = minBestand;
		this.maxBestand = maxBestand;
		AktuellesBestand = aktuellesBestand;
	}

	public Artikel2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public int getPreis() {
		return preis;
	}

	public void setPreis(int preis) {
		this.preis = preis;
	}

	public int getMinBestand() {
		return minBestand;
	}

	public void setMinBestand(int minBestand) {
		this.minBestand = minBestand;
	}

	public int getMaxBestand() {
		return maxBestand;
	}

	public void setMaxBestand(int maxBestand) {
		this.maxBestand = maxBestand;
	}

	public int getAktuellesBestand() {
		return AktuellesBestand;
	}

	public void setAktuellesBestand(int aktuellesBestand) {
		AktuellesBestand = aktuellesBestand;
	}

}