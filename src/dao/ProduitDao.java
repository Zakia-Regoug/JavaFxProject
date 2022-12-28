package dao;

import dao.entities.Produit;

import java.sql.SQLException;
import java.util.List;

public interface ProduitDao extends Dao<Produit> {
    List<Produit> findPrdByMc(String Mc) ;
}
