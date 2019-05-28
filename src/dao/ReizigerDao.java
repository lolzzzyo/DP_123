package dao;

import java.util.List;

import model.Reiziger;


public interface ReizigerDao {
	public List<Reiziger> findAll();
	public List<Reiziger> findByGBdatum(String GBdatum);
	public void save(Reiziger reiziger);
}
