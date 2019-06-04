package model;

import java.sql.Date;
import java.util.ArrayList;

public class Reiziger {
	private int reiziger_id;
	private String voorletters;
	private String tussenvoegsel;private                    
	private String achternaam;
	private Date gbdatum;
	private ArrayList<OVChipkaart> kaarten;
	
	public Reiziger(){
		
	}
	
	public Reiziger(int reiziger_id, String voorletters, String tussenvoegsel, String achternaam, Date gbdatum){
		this.reiziger_id = reiziger_id;
		this.voorletters = voorletters;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.gbdatum = gbdatum;
		this.kaarten = new ArrayList<OVChipkaart>();
	}
	
	public int getReizigerId(){
		return reiziger_id;
	}
	
	public void setReizigerId(int reiziger_id){
		this.reiziger_id = reiziger_id;
	}

	public Date getGbdatum() {
		return gbdatum;
	}

	public void setGbdatum(Date gbdatum) {
		this.gbdatum = gbdatum;
	}
	
	public String toString(){
		return voorletters + " " + tussenvoegsel + " " + achternaam + " " + gbdatum;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public String getVoorletters() {
		return voorletters;
	}

	public void setVoorletters(String voorletters) {
		this.voorletters = voorletters;
	}

	public String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}
	public Collection<OVChipkaart> getKaarten() {
	    return kaarten;
	}

	public void addKaart(OVChipkaart kaart) {
        if (!getKaarten().contains(kaart)) {
            getKaarten().add(kaart);
            
            kaart.setReiziger(this);
        }
    }
}
