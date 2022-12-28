package presentation.controllers;

import dao.ProduitDaoImpl;
import dao.entities.Produit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TextField;
import metier.ProduitServices;
import metier.ProduitServicesImpl;

import javax.xml.soap.Text;
import java.net.URL;
import java.util.ResourceBundle;

public class ProduitController implements Initializable {
    @FXML
    private TextField textnom;
    @FXML
    private ListView<Produit> listView;
    private ObservableList<Produit> observableList= FXCollections.observableArrayList();
    private ProduitServices produitServices;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        produitServices=new ProduitServicesImpl(new ProduitDaoImpl());
        listView.setItems(observableList);
        loadProducts();
    }
    @FXML
    private void addProduit(){
        String nom=textnom.getText();
        if(nom.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez saisir un nom !!!");
            alert.show();
        }else{
            //observableList.add(nom);
            textnom.clear();
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
    private void loadProducts(){
        observableList.clear();
        observableList.addAll(produitServices.getAllProducts());
    }
}
