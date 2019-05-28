package model;

public class Product {
	private int productnummer;
	private String productnaam;
	private String beschrijving;
	private double prijs;
	
	public Product(){

	}
	
	public Product(int productnummer, String productnaam, String beschrijving, double prijs){
		this.productnummer = productnummer;
		this.productnaam = productnaam;
		this.beschrijving = beschrijving;
		this.prijs = prijs;
	}

	public int getProductnummer() {
		return productnummer;
	}

	public void setProductnummer(int productnummer) {
		this.productnummer = productnummer;
	}

	public String getProductnaam() {
		return productnaam;
	}

	public void setProductnaam(String productnaam) {
		this.productnaam = productnaam;
	}

	public String getBeschrijving() {
		return beschrijving;
	}

	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}

	public double getPrijs() {
		return prijs;
	}

	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}
}
