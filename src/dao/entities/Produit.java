package dao.entities;

import java.io.Serializable;

//classe persistante
public class Produit implements Serializable {
    private int id;
    private String nom;
    private String description;
    private float prix;
    private int quantite;
    private Categorie categorie;

    public Produit() {
    }

    public Produit( String nom, String description, float prix, int quantite, Categorie categorie) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
        this.categorie=categorie;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                ", quantite=" + quantite +
                '}';
    }
}
