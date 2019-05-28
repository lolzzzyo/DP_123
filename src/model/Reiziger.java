package model;


import java.sql.Date;

public class Reiziger {
	private int id;
	private String vletters;
	private String tussenvoegsel;
	private String achternaam;
	private Date gbdatum;
	
	public Reiziger(int id, String vletters, String tussenvoegsel, String achternaam, Date gbdatum) {
		this.id = id;
		this.vletters = vletters;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.gbdatum = gbdatum;
	}
	
	public int getID() {
		return id;
	}
	public String getVletters() {
		return vletters;
	}
	public void setVletters(String vletters) {
		this.vletters = vletters;
	}
	public String getTussenvoegsel() {
		return tussenvoegsel;
	}
	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}
	public String getAchternaam() {
		return achternaam;
	}
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}
	public Date getGBdatum() {
		return gbdatum;
	}
	public void setGBdatum(Date gbdatum) {
		this.gbdatum = gbdatum;
	}
}
