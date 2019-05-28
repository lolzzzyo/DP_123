package dao;

import java.util.List;

import model.OvChipkaart;

public interface OvChipkaartDao {
	public List<OvChipkaart> findAll();
	public OvChipkaart findByKaartnummer(int kaartnummer);
	public void save(OvChipkaart ov);
	public void update(OvChipkaart ov);
	public void delete(int kaartnummer);
}
