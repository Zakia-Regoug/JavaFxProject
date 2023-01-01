package presentation.controllers;

import dao.CategorieDaoImpl;
import dao.ProduitDaoImpl;
import dao.entities.Produit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import metier.CatalogueServices;
import metier.CatalogueServicesImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class ProduitController implements Initializable {
    @FXML
    private TextField textNom;
    @FXML
    private TextField textQuantite;
    @FXML
    private TextField textPrix;
    @FXML
    private TextArea textDescription;

    @FXML
    private ListView<Produit> listView;
    private ObservableList<Produit> observableList= FXCollections.observableArrayList();
    private CatalogueServices produitServices;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        produitServices=new CatalogueServicesImpl(new ProduitDaoImpl(), new CategorieDaoImpl());
        listView.setItems(observableList);
        loadProducts();
    }
    @FXML
    private void addProduit(){
        String nom=textNom.getText();
        String description=textDescription.getText();
        float prix=Float.parseFloat(textPrix.getText());
        int quantite=Integer.parseInt(textQuantite.getText());
        if(nom.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez saisir un nom !!!");
            alert.show();
        }else{
            Produit p=new Produit();
            p.setNom(nom);
            p.setDescription(description);
            p.setPrix(prix);
            p.setQuantite(quantite);
            produitServices.addProduit(p);
            loadProducts();
        }
    }
    @FXML
    private void delProduit(){
        MultipleSelectionModel<Produit> mp=listView.getSelectionModel();
        if(mp!=null){
            produitServices.deleteProduit(mp.getSelectedItem());
            observableList.remove(mp.getSelectedIndex());
        }else {
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez selectionner un element !!!");
            alert.show();
        }
    }
    @FXML
    private void updateProduit(){
        MultipleSelectionModel<Produit> mp=listView.getSelectionModel();
        if(mp!=null){
            produitServices.deleteProduit(mp.getSelectedItem());
            observableList.remove(mp.getSelectedIndex());
        }else {
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez selectionner un element !!!");
            alert.show();
        }
    }
    @FXML
    private void videProduit(){
        MultipleSelectionModel<Produit> mp=listView.getSelectionModel();
        if(mp!=null){
            produitServices.deleteProduit(mp.getSelectedItem());
            observableList.remove(mp.getSelectedIndex());
        }else {
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez selectionner un element !!!");
            alert.show();
        }
    }
    private void loadProducts(){
        observableList.clear();
        observableList.addAll(produitServices.getAllProducts());
    }
}
