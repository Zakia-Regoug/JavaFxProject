package metier;

import dao.ProduitDao;
import dao.entities.Produit;

import java.util.List;

public class ProduitServicesImpl implements ProduitServices{
    ProduitDao pdao;
    public ProduitServicesImpl(ProduitDao pdao){
    this.pdao=pdao;
    }

    @Override
    public List<Produit> getAllProducts() {
        return pdao.findAll();
    }

    @Override
    public void addProduit(Produit p) {
    pdao.save(p);
    }

    @Override
    public void deleteProduit(Produit p) {
    pdao.delete(p);
    }

    @Override
    public List<Produit> getProduitsParMc(String mc) {

        return pdao.findPrdByMc(mc);
    }
}
