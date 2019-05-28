package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Product;

public class ProductOracleDaoImpl extends OracleBaseDao implements ProductDao{
	public void save(Product pr) {
    	try {
		 	String query = "INSERT INTO product (productnummer, productnaam, beschrijving, prijs) VALUES (?, ?, ?, ?)";
	
		 	PreparedStatement pstmt = super.connect().prepareStatement(query);
	
		 	pstmt.setInt(1, pr.getProductnummer());
		 	pstmt.setString(2, pr.getProductnaam());
		 	pstmt.setString(3, pr.getBeschrijving());
		 	pstmt.setDouble(4, pr.getPrijs());
	
		 	pstmt.executeQuery();
	
		 	pstmt.close();
		 	super.closeConnection();
    	}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	 }
}
