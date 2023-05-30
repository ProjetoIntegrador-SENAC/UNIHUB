package br.com.projetopi.redesocial.dao;

import br.com.projetopi.redesocial.model.Mensagem;
import br.com.projetopi.redesocial.model.Postagem;
import br.com.projetopi.redesocial.repository.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public ArrayList<Mensagem> getMessages(int id_origem,int id_destino){
        String sqlQuery = "select * from mensagem where ((conta_remente_id = 1 or  conta_destinatario_id = 1) and (conta_remente_id = 2 or  conta_destinatario_id = 2)) order by data_mensagem asc";

        ArrayList<Mensagem> mensagens = new ArrayList<>();

        try(PreparedStatement ps = con.prepareStatement(sqlQuery)){
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()){
                Mensagem mensagem = new Mensagem();

                mensagem.setConteudo(resultSet.getString("conteudo"));
                mensagem.setData_mensagem(resultSet.getDate("data_mensagem"));
                mensagem.setConta_remente_id(resultSet.getInt("conta_remente_id"));
                mensagem.setConta_destinatario_id(resultSet.getInt("conta_destinatario_id"));

                mensagens.add(mensagem);

            }
            return mensagens;
        }catch (SQLException e){
            System.out.println(e);
            return null;
        }


    }

}
