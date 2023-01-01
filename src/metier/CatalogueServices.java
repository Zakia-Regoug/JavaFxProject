package metier;

import dao.entities.Categorie;
import dao.entities.Produit;

import java.util.List;

public interface CatalogueServices {
    List<Produit> getAllProducts();
    void addProduit(Produit p);
    void deleteProduit(Produit p);
    List<Produit> getProduitsParMc(String mc);
    List<Categorie> getAllCategories();
    Categorie getCategorieById(int id);
    void addCategorie(Categorie c);
}
