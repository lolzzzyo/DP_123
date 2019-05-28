package model;

import java.sql.Date;

public class OvChipkaart_Product {
	private int ovproductid;
	private OvChipkaart ovchipkaart;
	private Product product;
	private String reisproductstatus;
	private Date lastupdate;
	
	public OvChipkaart_Product(){
	}
	
	public OvChipkaart_Product(int ovproductid, String reisproductstatus, Date lastupdate){
		this.ovproductid = ovproductid;
		this.reisproductstatus = reisproductstatus;
		this.lastupdate = lastupdate;
	}

	public int getOvproductid() {
		return ovproductid;
	}

	public void setOvproductid(int ovproductid) {
		this.ovproductid = ovproductid;
	}

	public OvChipkaart getOvchipkaart() {
		return ovchipkaart;
	}

	public void setOvchipkaart(OvChipkaart ovchipkaart) {
		this.ovchipkaart = ovchipkaart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getReisproductstatus() {
		return reisproductstatus;
	}

	public void setReisproductstatus(String reisproductstatus) {
		this.reisproductstatus = reisproductstatus;
	}

	public Date getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}
	
	public String toString(){
		return "OvProductId: " + getOvproductid() + "\nKaartnummer: " + getOvchipkaart().getKaartnummer() + "\nProductnummer: " + getProduct().getProductnummer() + "\nReisProductStatus : " + getReisproductstatus() + " \nLastUpdate: " + getLastupdate() + "\nProductnaam: " + getProduct().getProductnaam() + "\nBeschrijving: " + getProduct().getBeschrijving() + "\nPrijs: " + getProduct().getPrijs() + "\nKaartnummer: " + getOvchipkaart().getKaartnummer() + "\nGeldigTot: " + getOvchipkaart().getGeldigtot() + "\nKlasse: " + getOvchipkaart().getKlasse() + "\nSaldo: " + getOvchipkaart().getSaldo() + "\n";
	}
}
