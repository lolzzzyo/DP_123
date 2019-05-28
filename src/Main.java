import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dao.OvChipkaartOracleDaoImpl;
import dao.OvChipkaart_ProductOracleDaoImpl;
import dao.ProductOracleDaoImpl;
import dao.ReizigerOracleDaoImpl;
import p1.ReizigerOracleDaoImplP1;
import model.OvChipkaart;
import model.OvChipkaart_Product;
import model.Product;
import model.Reiziger;
import model.ReizigerP1;

public class Main {
	public static void main(String[] arg) throws ParseException {
		//making dummy data
		String s1 = "1996-06-29";
		Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(s1);
		ReizigerP1 f1 = new ReizigerP1("Andy", d1);
		String s2 = "2004-12-02";
		Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse(s2);
		ReizigerP1 f2 = new ReizigerP1("Tony", d2);
		String s3 = "1993-12-27";
		Date d3 = new SimpleDateFormat("yyyy-MM-dd").parse(s3);
		ReizigerP1 f3 = new ReizigerP1("Cindy", d3);
		String s4 = "1996-06-29";
		Date d4 = new SimpleDateFormat("yyyy-MM-dd").parse(s4);
		ReizigerP1 f4 = new ReizigerP1("Andy", d4);
		String s5 = "1996-06-29";
		Date d5 = new SimpleDateFormat("yyyy-MM-dd").parse(s5);
		ReizigerP1 f5 = new ReizigerP1("Test", d5);
		
		//saving in the list
		ReizigerOracleDaoImplP1 rodi = new ReizigerOracleDaoImplP1();
		rodi.save(f1);
		rodi.save(f2);
		rodi.save(f3);
		rodi.save(f4);
		rodi.save(f5);
		
		//testen findAll()
		List<ReizigerP1> lijst = rodi.findAll();
		System.out.println("Alle reizigers:");
		for(ReizigerP1 r : lijst) {
			System.out.println(r.getNaam() + " " + r.getGBdatum());
		}
		
		//testen update()
		s3 = "1996-06-29";
		d3 = new SimpleDateFormat("yyyy-MM-dd").parse(s3);
		f3.setGBdatum(d3);
		ReizigerP1 update = rodi.update(f3);
		System.out.println("Reiziger updated: ");
		System.out.println(update.getNaam() + " " + update.getGBdatum());
		
		//testen delete()
		//deleted f5(naam = Test, gbDatum = 1996-06-29)
		boolean delete = rodi.delete(f5);
		System.out.println("Reiziger deleted: " + delete);
		
		//testen findByGBdatum() function
		lijst = rodi.findByGBdatum("1996-06-29");
		System.out.println("Alle reizigers met de geboortedatum 1996-06-29:");
		for(ReizigerP1 r : lijst) {
			System.out.println(r.getNaam() + " " + r.getGBdatum());
		}
		OvChipkaart_ProductOracleDaoImpl ovpDAO = new OvChipkaart_ProductOracleDaoImpl();
		ProductOracleDaoImpl prDAO = new ProductOracleDaoImpl();
		OvChipkaartOracleDaoImpl ovDAO = new OvChipkaartOracleDaoImpl();
		ReizigerOracleDaoImpl rDAO = new ReizigerOracleDaoImpl();
		
		//alle gegevens ophalen
		System.out.println(ovpDAO.findAll());
		
		//gegevens ophalen van ovproductid 3
		System.out.println(ovpDAO.findByOvproductid(3));
		
		//gegevens opslaan in koppeltabel met ovchipkaart en product
		Reiziger r1 = new Reiziger(8 ,"M","","Bosman", java.sql.Date.valueOf("1997-05-16"));
		
		Product pr1 = new Product(8, "Hele maand gratis reizen", "4 weken gratis reizen", 500.20);
		
		OvChipkaart ov1 = new OvChipkaart(12346, java.sql.Date.valueOf("2020-12-12"), 2, 120.59);
		
		OvChipkaart_Product ovp1 = new OvChipkaart_Product(10, "actief", java.sql.Date.valueOf("2018-05-11"));
		
		ov1.setReiziger(r1);
		ovp1.setOvchipkaart(ov1);
		ovp1.setProduct(pr1);
		rDAO.save(r1);
		prDAO.save(pr1);
		ovDAO.save(ov1);
		ovpDAO.save(ovp1);
		
		//delete ovchipkaart_product met id 1
		
		ovpDAO.delete(1);
		
		//ovchipkaart_product ophalen en updaten
		
		OvChipkaart_Product ovp2 = ovpDAO.findByOvproductid(4);

        ovp2.setReisproductstatus("wijzigdit1");
        ovp2.setLastupdate(java.sql.Date.valueOf("2018-05-09"));

        ovpDAO.update(ovp2);
	}
}
