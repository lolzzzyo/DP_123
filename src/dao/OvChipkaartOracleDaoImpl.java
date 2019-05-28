package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.OvChipkaart;
import model.Reiziger;

public class OvChipkaartOracleDaoImpl extends OracleBaseDao implements OvChipkaartDao {
	public List<OvChipkaart> findAll() {
    	List<OvChipkaart> kaartList = new ArrayList<OvChipkaart>();
        try {
        	// join query om reiziger gegevens ook op te vragen
        	String query = "SELECT * FROM ov_chipkaart ov JOIN reiziger r ON r.reizigerid = ov.reizigerid";
	        
	        PreparedStatement pstmt = super.connect().prepareStatement(query);
	        ResultSet rset = pstmt.executeQuery();
	        
	        OvChipkaart ov = new OvChipkaart();

	        while(rset.next()) {
	            Reiziger r = new Reiziger(rset.getInt("reizigerid"),
	            		rset.getString("voorletters"), rset.getString("tussenvoegsel"), 
	            		rset.getString("achternaam"), rset.getDate("gebortedatum"));
	            
	            ov.setKaartnummer(rset.getInt("kaartnummer"));
	            ov.setGeldigtot(rset.getDate("geldigtot"));
	            ov.setKlasse(rset.getInt("klasse"));
	            ov.setSaldo(rset.getDouble("saldo"));
	            
	            // reiziger object word geset in de ov object
	            ov.setReiziger(r);
	            
	            // voeg ov object toe aan lijst
	            kaartList.add(ov);
	        }
	        pstmt.close();
	        super.closeConnection();
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return kaartList;
    }

    public OvChipkaart findByKaartnummer(int kaartnummer) {
    	OvChipkaart ov = new OvChipkaart();
    	try {
	        String query = "SELECT * FROM ov_chipkaart ov JOIN reiziger r ON r.reizigerid = ov.reizigerid WHERE ov.kaartnummer = ?";

	        PreparedStatement pstmt = super.connect().prepareStatement(query);
        
	        // vult de eerste ? in de query met de kaartnummer die je als parameter meegeeft.
	        pstmt.setInt(1, kaartnummer);

	        ResultSet rset = pstmt.executeQuery();

	        while(rset.next()) {
	        	Reiziger r = new Reiziger(rset.getInt("reizigerid"),
	            		rset.getString("voorletters"), rset.getString("tussenvoegsel"), 
	            		rset.getString("achternaam"), rset.getDate("gebortedatum"));
	            
	            ov.setKaartnummer(rset.getInt("kaartnummer"));
	            ov.setGeldigtot(rset.getDate("geldigtot"));
	            ov.setKlasse(rset.getInt("klasse"));
	            ov.setSaldo(rset.getDouble("saldo"));
	            
	            ov.setReiziger(r);
	        }
	        pstmt.close();
	        super.closeConnection();
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

        return ov;

    }
    
    public void save(OvChipkaart ov){
		try {
			String query = "INSERT INTO ov_chipkaart (kaartnummer, geldigtot, klasse, saldo, reizigerid) VALUES (?, TO_DATE(?, 'DD-MM-YYYY'), ?, ?, ?)";
	        PreparedStatement pstmt = super.connect().prepareStatement(query);
			pstmt.setInt(1, ov.getKaartnummer());
	        pstmt.setDate(2, ov.getGeldigtot());
	        pstmt.setInt(3, ov.getKlasse());
	        pstmt.setDouble(4, ov.getSaldo());
	        pstmt.setInt(5, ov.getReiziger().getID());

	        pstmt.executeQuery();

	        pstmt.close();
	        super.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    public void update(OvChipkaart ov) {
		try {
			String query = "UPDATE ov_chipkaart SET geldigtot = TO_DATE(?, 'DD-MM-YYYY'), klasse = ?, saldo = ? WHERE kaartnummer = ?";
			PreparedStatement pstmt = super.connect().prepareStatement(query);
			pstmt.setDate(1, ov.getGeldigtot());
	        pstmt.setInt(2, ov.getKlasse());
	        pstmt.setDouble(3, ov.getSaldo());
	        pstmt.setInt(4, ov.getKaartnummer());

	        pstmt.executeQuery();
	        pstmt.close();
	        super.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void delete(int knr) {
		try {
			String query = "DELETE FROM ov_chipkaart WHERE kaartnummer=?";
			PreparedStatement pstmt = super.connect().prepareStatement(query);
			pstmt.setInt(1, knr);
	
	        pstmt.executeQuery();
	
	        pstmt.close();
	        super.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
