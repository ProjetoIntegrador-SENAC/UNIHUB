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

    public Object getAllLike(){
        String sqlQuery = "SELECT concat(nome, ' ', sobrenome) as nome FROM curtida_postagem inner join conta on conta.id = curtida_postagem.conta_id";
        return null;
    }

}
