package br.com.projetopi.redesocial.dao;

import br.com.projetopi.redesocial.model.Curso;
import br.com.projetopi.redesocial.model.Instituicao;
import br.com.projetopi.redesocial.model.dto.AreaCursoChat;
import br.com.projetopi.redesocial.repository.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDao {

    private Connection connection;

    public CursoDao() {
        this.connection = ConnectionFactory.getConnectionH2();
    }
    public boolean createCurso(Curso curso)  {
            String sql = "insert into curso(nome, tipo, area, instituicao_id) values (?, ?, ?, ?)";
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, curso.getNome());
                statement.setString(2, curso.getTipo());
                statement.setString(3, curso.getArea());
                statement.setInt(4,curso.getInstituicao_id());
                statement.execute();
                return true;
            }catch (SQLException e){
              e.printStackTrace();
              return false;}
    }

    public boolean update(Curso curso) {
        String sql = "UPDATE curso SET nome = ?, tipo = ?, area = ? WHERE id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, curso.getNome());
            statement.setString(2, curso.getTipo());
            statement.setString(3, curso.getArea());
            statement.setInt(4, curso.getId());
            statement.execute();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public List<Curso> findAll() throws SQLException {
        String sql = "SELECT * FROM curso";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        try(ResultSet rst = statement.getResultSet()){
            List<Curso> cursos = new ArrayList<>();
            while(rst.next()){
                cursos.add(new Curso(rst.getInt(1), rst.getString(2), rst.getNString(3), rst.getString(4), null, rst.getInt(5)));
            }
            return cursos;
        }
    }

    public Curso findById(int id)  {
        String sql =  "SELECT * FROM curso WHERE id = " + id;

        try( PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.execute();
            try(ResultSet set = statement.getResultSet()) {
                while (set.next()) {
                    Instituicao instituicao = new Instituicao();
                    instituicao.setId(set.getInt(5));
                    Curso curso = new Curso(set.getInt(1), set.getString(2), set.getString(3),
                            set.getString(4), instituicao, instituicao.getId());
                    return curso;
                }
            }catch (SQLException e){
                System.out.printf(e.getMessage());
            }
        }catch (SQLException e){
            System.out.println(e);
        }

        return null;
    }

    public boolean delete(int id) {
        String sql = "update curso set ic_ativo = 0 where id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);
            statement.execute();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Curso> getCursosByInstituicaoId(int instituicaoId) {
        String sqlQuery = "select * from curso where instituicao_id = ? and ic_ativo = 1";
        ArrayList<Curso> cursos = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement(sqlQuery)){
            ps.setInt(1, instituicaoId);
            ResultSet result = ps.executeQuery();
            while(result.next()){

                Curso curso = new Curso();
                curso.setTipo(result.getString("tipo"));
                curso.setNome(result.getString("nome"));
                curso.setArea(result.getString("area"));
                curso.setId(result.getInt("id"));

                cursos.add(curso);

            }
            return cursos;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return cursos;
    }

    public int getCount(){
        String sqlQuery = "select count(*) from curso";
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)){
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt(1);
            }else{
                return 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<AreaCursoChat> getAreaQtd(){
        String sqlQuery = "select area, count(*) qtd from curso group by area";
        ArrayList<AreaCursoChat> items = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement(sqlQuery)){
            ResultSet result = ps.executeQuery();
            while(result.next()){
                AreaCursoChat areaCursoChat = new AreaCursoChat(result.getString("area"), result.getInt("qtd"));
                items.add(areaCursoChat);
            }
            return items;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}
