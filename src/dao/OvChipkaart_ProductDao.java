package dao;

import java.util.List;

import model.OvChipkaart_Product;

public interface OvChipkaart_ProductDao {
	public List<OvChipkaart_Product> findAll();
	public OvChipkaart_Product findByOvproductid(int ovpid);
	public void save(OvChipkaart_Product ovp);
	public void delete(int ovpid);
	public void update(OvChipkaart_Product ovp);
}
