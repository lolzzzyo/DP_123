package model;

import java.sql.Date;

public class OvChipkaart {
	private int kaartnummer;
	private Date geldigtot;
	private int klasse;
	private double saldo;
	private Reiziger reiziger;
	
	public OvChipkaart(){		
	
	}
	
	public OvChipkaart(int kaartnummer, Date geldigtot, int klasse, double saldo){
		this.kaartnummer = kaartnummer;
		this.geldigtot = geldigtot;
		this.klasse = klasse;
		this.saldo = saldo;
	}

	public int getKaartnummer() {
		return kaartnummer;
	}

	public void setKaartnummer(int kaartnummer) {
		this.kaartnummer = kaartnummer;
	}

	public Date getGeldigtot() {
		return geldigtot;
	}

	public void setGeldigtot(Date geldigtot) {
		this.geldigtot = geldigtot;
	}

	public int getKlasse() {
		return klasse;
	}

	public void setKlasse(int klasse) {
		this.klasse = klasse;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Reiziger getReiziger() {
		return reiziger;
	}

	public void setReiziger(Reiziger reiziger) {
		this.reiziger = reiziger;
	}
	
	// nodig om de gegevens uit te printen
	public String toString() {
		return "Reiziger Id: " + reiziger.getID() + "\nNaam: " + reiziger.getVletters() + " " + reiziger.getTussenvoegsel() + " " + reiziger.getAchternaam() + "\nGeboortedatum: " + reiziger.getGBdatum() + "\nKaartnummer: " + kaartnummer + "\nGeldig tot: " + geldigtot + "\nKlasse: " + klasse + "\nSaldo: " + saldo + " \n";
	}	
}
