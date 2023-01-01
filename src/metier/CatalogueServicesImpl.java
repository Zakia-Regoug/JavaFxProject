package metier;

import dao.CategorieDao;
import dao.ProduitDao;
import dao.entities.Categorie;
import dao.entities.Produit;

import java.util.List;

public class CatalogueServicesImpl implements CatalogueServices {
    ProduitDao produitDao;
    private CategorieDao categorieDao;
    public CatalogueServicesImpl(ProduitDao pdao, CategorieDao categorieDao){
    this.produitDao =pdao;
    this.categorieDao=categorieDao;
    }

    @Override
    public List<Produit> getAllProducts() {
        return produitDao.findAll();
    }

    @Override
    public void addProduit(Produit p) {
    produitDao.save(p);
    }

    @Override
    public void deleteProduit(Produit p) {
    produitDao.delete(p);
    }

    @Override
    public List<Produit> getProduitsParMc(String mc) {

        return produitDao.findPrdByMc(mc);
    }


    @Override
    public List<Categorie> getAllCategories() {
        return categorieDao.findAll();
    }

    @Override
    public Categorie getCategorieById(int id) {
        return categorieDao.findOne(id);
    }

    @Override
    public void addCategorie(Categorie c) {
        categorieDao.save(c);
    }
}
