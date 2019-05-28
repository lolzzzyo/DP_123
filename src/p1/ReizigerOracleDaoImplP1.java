package p1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.ReizigerP1;

public class ReizigerOracleDaoImplP1 implements ReizigerDaoP1 {
	private List<ReizigerP1> reizigerLijst = new ArrayList<ReizigerP1>();
	
	@Override
	public List<ReizigerP1> findAll() {
		return reizigerLijst;
	}

	@Override
	public List<ReizigerP1> findByGBdatum(String GBdatum) {
		List<ReizigerP1> newLijst = new ArrayList<ReizigerP1>();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for(ReizigerP1 r : reizigerLijst) {
			if(GBdatum.equals(dateFormat.format(r.getGBdatum()))){
				newLijst.add(r);
			}
		}
		return newLijst;
	}

	@Override
	public ReizigerP1 save(ReizigerP1 reiziger) {
		if(!reizigerLijst.contains(reiziger)) {
			reizigerLijst.add(reiziger);
		}
		return reizigerLijst.get(reizigerLijst.size()-1);
	}

	@Override
	public ReizigerP1 update(ReizigerP1 reiziger) {
		int iter = -1;
		if(reizigerLijst.contains(reiziger)) {
			for(int i = 0; i < reizigerLijst.size(); i ++) {
				if(reizigerLijst.get(i).getNaam().equals(reiziger.getNaam())) {
					reizigerLijst.get(i).setGBdatum(reiziger.getGBdatum());
					iter = i;
					break;
				}
			}
		}
		return reizigerLijst.get(iter);
	}

	@Override
	public boolean delete(ReizigerP1 reiziger) {
		int iter = -1;
		if(reizigerLijst.contains(reiziger)) {
			for(int i = 0; i < reizigerLijst.size(); i ++) {
				if(reizigerLijst.get(i).equals(reiziger)) {
					reizigerLijst.remove(i);
					iter = i;
					break;
				}
			}
		}
		return (iter >= 0);
	}

}
