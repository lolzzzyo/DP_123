package model;

import java.util.Date;

public class ReizigerP1 {
	private String naam;
	private Date gbdatum;
	
	public ReizigerP1(String naam, Date gbdatum) {
		this.naam = naam;
		this.gbdatum = gbdatum;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public Date getGBdatum() {
		return gbdatum;
	}
	public void setGBdatum(Date gbdatum) {
		this.gbdatum = gbdatum;
	}
	@Override
	public boolean equals(Object o) {
		boolean check = false;
		if(o instanceof ReizigerP1) {
			ReizigerP1 r = (ReizigerP1) o;
			if(this.naam.equals(r.naam) &&
				this.gbdatum.equals(r.gbdatum)){
				check = true;
			}
			
		}
		return check;
	}
}
