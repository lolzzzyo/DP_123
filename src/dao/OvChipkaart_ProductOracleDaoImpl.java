package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.OvChipkaart;
import model.OvChipkaart_Product;
import model.Product;

public class OvChipkaart_ProductOracleDaoImpl extends OracleBaseDao implements OvChipkaart_ProductDao{
	public List<OvChipkaart_Product> findAll(){
    	List<OvChipkaart_Product> ovprList = new ArrayList<OvChipkaart_Product>();
    	try {
	    	String query = "SELECT * from OV_CHIPKAART_PRODUCT ovp, product p, ov_chipkaart ov WHERE ovp.kaartnummer = ov.kaartnummer AND ovp.productnummer = p.productnummer";
	        PreparedStatement pstmt = super.connect().prepareStatement(query);
	        
	        ResultSet rset = pstmt.executeQuery();
	        
	        OvChipkaart_Product ovp = new OvChipkaart_Product();
	
	        while(rset.next()) {
	            OvChipkaart ov = new OvChipkaart();
	            Product pr = new Product();
	            
	            ov.setKaartnummer(rset.getInt("kaartnummer"));
	            ov.setGeldigtot(rset.getDate("geldigtot"));
	            ov.setKlasse(rset.getInt("klasse"));
	            ov.setSaldo(rset.getDouble("saldo"));
	            
	            pr.setProductnummer(rset.getInt("productnummer"));
	            pr.setProductnaam(rset.getString("productnaam"));
	            pr.setBeschrijving(rset.getString("beschrijving"));
	            pr.setPrijs(rset.getDouble("prijs"));
	            
	            ovp.setOvproductid(rset.getInt("ovproductid"));
	            ovp.setReisproductstatus(rset.getString("reisproductstatus"));
	            ovp.setLastupdate(rset.getDate("lastupdate"));
	            
	            ovp.setOvchipkaart(ov);
	            ovp.setProduct(pr);
	            
	            
	            // voeg ov object toe aan lijst
	            ovprList.add(ovp);
	        }
	        pstmt.close();
	        super.closeConnection();
    	}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return ovprList;
    }

    public OvChipkaart_Product findByOvproductid(int ovpid) {
    	OvChipkaart_Product ovp = new OvChipkaart_Product();
    	try {
	    	String query = "SELECT * from OV_CHIPKAART_PRODUCT ovp, product p, ov_chipkaart ov WHERE ovp.kaartnummer = ov.kaartnummer AND ovp.productnummer = p.productnummer AND ovproductid = ?";
	        PreparedStatement pstmt = super.connect().prepareStatement(query);
	        
	        pstmt.setInt(1, ovpid);
	
	        ResultSet rset = pstmt.executeQuery();
	
	        
	
	        while(rset.next()) {
	            OvChipkaart ov = new OvChipkaart();
	            Product pr = new Product();
	            
	            ov.setKaartnummer(rset.getInt("kaartnummer"));
	            ov.setGeldigtot(rset.getDate("geldigtot"));
	            ov.setKlasse(rset.getInt("klasse"));
	            ov.setSaldo(rset.getDouble("saldo"));
	            
	            pr.setProductnummer(rset.getInt("productnummer"));
	            pr.setProductnaam(rset.getString("productnaam"));
	            pr.setBeschrijving(rset.getString("beschrijving"));
	            pr.setPrijs(rset.getDouble("prijs"));
	            
	            ovp.setOvproductid(rset.getInt("ovproductid"));
	            ovp.setReisproductstatus(rset.getString("reisproductstatus"));
	            ovp.setLastupdate(rset.getDate("lastupdate"));
	            
	            ovp.setOvchipkaart(ov);
	            ovp.setProduct(pr);
	        }
	        pstmt.close();
	        super.closeConnection();
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return ovp;

    }
    
    public void save(OvChipkaart_Product ovp) {
    	try {
	    	String query = "INSERT INTO ov_chipkaart_product (ovproductid, kaartnummer, productnummer, reisproductstatus, lastupdate) VALUES (?, ?, ?, ?, TO_DATE(?, 'DD-MM-YYYY'))";
	
	        PreparedStatement pstmt = super.connect().prepareStatement(query);
	
	        pstmt.setInt(1, ovp.getOvproductid());
	        pstmt.setInt(2, ovp.getOvchipkaart().getKaartnummer());
	        pstmt.setInt(3, ovp.getProduct().getProductnummer());
	        pstmt.setString(4, ovp.getReisproductstatus());
	        pstmt.setDate(5, ovp.getLastupdate());
	
	        pstmt.executeQuery();
	
	        pstmt.close();
	        super.closeConnection();
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void delete(int ovpid) {
    	try {

    		String query = "DELETE FROM ov_chipkaart_product WHERE ovproductid = ?";
    	
	        PreparedStatement pstmt = super.connect().prepareStatement(query);
	
	        pstmt.setInt(1, ovpid);
	
	        pstmt.executeQuery();
	
	        pstmt.close();
	        super.closeConnection();
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    public void update(OvChipkaart_Product ovp) {
    	try {
	    	String query = "UPDATE ov_chipkaart_product SET reisproductstatus = ?, lastupdate = TO_DATE(?, 'DD-MM-YYYY') where ovproductid = ?";
	    	
	        PreparedStatement pstmt = super.connect().prepareStatement(query);
	
	        pstmt.setString(1, ovp.getReisproductstatus());
	        pstmt.setDate(2, ovp.getLastupdate());
	        pstmt.setInt(3, ovp.getOvproductid());
	
	        pstmt.executeQuery();
	
	        pstmt.close();
	        super.closeConnection();
    	}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}
