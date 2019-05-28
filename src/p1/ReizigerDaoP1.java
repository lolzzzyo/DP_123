package p1;

import java.util.List;

import model.ReizigerP1;


public interface ReizigerDaoP1 {
	public List<ReizigerP1> findAll();
	public List<ReizigerP1> findByGBdatum(String GBdatum);
	public ReizigerP1 save(ReizigerP1 reiziger);
	public ReizigerP1 update(ReizigerP1 reiziger);
	public boolean delete(ReizigerP1 reiziger);
}
