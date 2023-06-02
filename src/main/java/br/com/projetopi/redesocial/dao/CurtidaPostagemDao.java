package br.com.projetopi.redesocial.dao;

import br.com.projetopi.redesocial.repository.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurtidaPostagemDao {

    private Connection connection;

    public CurtidaPostagemDao() {
        this.connection = ConnectionFactory.getConnectionH2();
    }
    public int getQtdLikes(){
        String sqlQuery = "SELECT count(*) FROM curtida_postagem";
        try(PreparedStatement statement = connection.prepareStatement(sqlQuery)){
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt(1);
            }else{
                return 0;
            }
        }
        catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }

    public Object getAllLike(int postagem_id){
        String sqlQuery = "SELECT concat(nome, ' ', sobrenome) as nome FROM curtida_postagem inner join conta on conta.id = curtida_postagem.conta_id where postagem_id = ?";
        return null;
    }

    public boolean add(int postagem_id, int conta_id){

        String sqlQuery1 = "select * from curtida_postagem where postagem_id = ? and conta_id = ?";
        try(PreparedStatement ps = connection.prepareStatement(sqlQuery1)) {
            ps.setInt(1, postagem_id);
            ps.setInt(2, conta_id);

            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                String sqlQuery2 = "delete  from curtida_postagem where postagem_id = ? and conta_id = ?";
                try(PreparedStatement ps2 = connection.prepareStatement(sqlQuery2)){
                    ps2.setInt(1, postagem_id);
                    ps2.setInt(2, conta_id);
                    ps2.execute();
                    return true;
                }
            }}
            catch (SQLException e){
            System.out.println(e);
            return false;
        }

        String sqlQuery = "insert into curtida_postagem (postagem_id, conta_id) values (?,?) ";
        try(PreparedStatement ps = connection.prepareStatement(sqlQuery)) {
            ps.setInt(1, postagem_id);
            ps.setInt(2, conta_id);
            ps.execute();
            return true;
        }catch (SQLException e){
            System.out.println(e);
            return false;
        }

    }

}
