package dao;

import dao.entities.Categorie;
import dao.entities.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategorieDaoImpl implements CategorieDao{
    @Override
    public List<Categorie> findAll() {
        Connection connection = SingletonConnectionDB.getConnection();
        List<Categorie> categories = new ArrayList<>();
        try {
            PreparedStatement stm = connection.prepareStatement("select * from CATEGORIES");
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Categorie c = new Categorie();
                c.setId(rs.getInt("ID"));
                c.setNom(rs.getString("NOM"));

                categories.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Categorie findOne(int id) {
        Connection connection=SingletonConnectionDB.getConnection();
        Categorie c=new Categorie();
        try{
            PreparedStatement stm=connection.prepareStatement("select * from CATEGORIES where ID like ?");
            stm.setInt(1,id);
            ResultSet rs=stm.executeQuery();

            if(rs.next()){
                c.setId(rs.getInt("ID"));
                c.setNom(rs.getString("NOM"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public Categorie save(Categorie o) {
        Connection connection=SingletonConnectionDB.getConnection();
        try {
            PreparedStatement pstm=connection.prepareStatement("insert into CATEGORIES(NOM) values(?)");
            pstm.setString(1,o.getNom());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public boolean delete(Categorie o) {
        try{
            Connection connection=SingletonConnectionDB.getConnection();
            PreparedStatement pstm=connection.prepareStatement("delete from CATEGORIES where ID=?");
            pstm.setInt(1,o.getId());
            pstm.executeUpdate();
        }catch (SQLException e){
            return false;
        }

        return true;
    }

    @Override
    public Categorie update(Categorie o) {
        Connection connection=SingletonConnectionDB.getConnection();
        try{
            PreparedStatement pstm=connection.prepareStatement("update CATEGORIES set NOM=? where ID=?");
            pstm.setString(1,o.getNom());
            pstm.setInt(2,o.getId());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return o;
    }
}
