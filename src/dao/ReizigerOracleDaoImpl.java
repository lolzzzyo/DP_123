package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

import model.Reiziger;

public class ReizigerOracleDaoImpl extends OracleBaseDao implements ReizigerDao {
	
	
	@Override
	public List<Reiziger> findAll() {
		List<Reiziger> reizigerLijst = new ArrayList<Reiziger>();
		try {
			String query = "SELECT * FROM REIZIGER";
			PreparedStatement pstmt = super.connect().prepareStatement(query);
			ResultSet rset = pstmt.executeQuery();
			while(rset.next()){
				int id = rset.getInt("REIZIGERID");
				String vletters = rset.getString("VOORLETTERS");
				String tussenvoegsel = rset.getString("TUSSENVOEGSEL");
				String achternaam = rset.getString("ACHTERNAAM");
	
				Date gbdatum = rset.getDate("GEBORTEDATUM");
				Reiziger r = new Reiziger(id, vletters, tussenvoegsel, achternaam, gbdatum);
				reizigerLijst.add(r);
			}
			super.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reizigerLijst;
	}

	@Override
	public List<Reiziger> findByGBdatum(String GBdatum) {
		List<Reiziger> reizigerLijst = new ArrayList<Reiziger>();
		try {
			String query = "SELECT * FROM REIZIGER WHERE GEBORTEDATUM = ?";
			PreparedStatement pstmt = super.connect().prepareStatement(query);
			Date gb = Date.valueOf(GBdatum);
			pstmt.setDate(1, gb);
			ResultSet rset = pstmt.executeQuery();
			while(rset.next()){
				int id = rset.getInt("REIZIGERID");
				String vletters = rset.getString("VOORLETTERS");
				String tussenvoegsel = rset.getString("TUSSENVOEGSEL");
				String achternaam = rset.getString("ACHTERNAAM");
	
				Date gbdatum = rset.getDate("GEBORTEDATUM");
				Reiziger r = new Reiziger(id, vletters, tussenvoegsel, achternaam, gbdatum);
				reizigerLijst.add(r);
			}
			super.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reizigerLijst;
	}

	@Override
	public void save(Reiziger reiziger) {
		try {

			String query = "INSERT INTO reiziger (VOORLETTERS, TUSSENVOEGSEL, ACHTERNAAM, GEBORTEDATUM) values (?,?,?,?)";
			PreparedStatement pstmt = super.connect().prepareStatement(query);
			pstmt.setString(1, reiziger.getVletters());
			pstmt.setString(2, reiziger.getTussenvoegsel());
			pstmt.setString(3, reiziger.getAchternaam());
			pstmt.setDate(4, reiziger.getGBdatum());
			pstmt.execute();
			super.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
