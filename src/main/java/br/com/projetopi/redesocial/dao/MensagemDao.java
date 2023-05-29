package br.com.projetopi.redesocial.dao;

import br.com.projetopi.redesocial.model.Mensagem;
import br.com.projetopi.redesocial.repository.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MensagemDao {
    private Connection con;

    public MensagemDao(){
        this.con = ConnectionFactory.getConnectionH2();
    }

    public boolean addMensagem(Mensagem mensagem){
        String sqlQuery = "insert into mensagem (conteudo, data_mensagem, conta_remente_id, conta_destinatario_id) values (?,?,?,?)";

        try(PreparedStatement ps = con.prepareStatement(sqlQuery)){
            ps.setString(1, mensagem.getConteudo());
            ps.setDate(2, mensagem.getData_mensagem());
            ps.setInt(3, mensagem.getConta_remente_id());
            ps.setInt(4, mensagem.getConta_destinatario_id());
            ps.execute();
            return true;
        }catch (SQLException e){
            System.out.println(e);
            return false;
        }

    }

}
