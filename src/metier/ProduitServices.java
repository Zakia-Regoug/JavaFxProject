package metier;

import dao.entities.Produit;

import java.util.List;

public interface ProduitServices {
    List<Produit> getAllProducts();
    void addProduit(Produit p);
    void deleteProduit(Produit p);
    List<Produit> getProduitsParMc(String mc);
}
