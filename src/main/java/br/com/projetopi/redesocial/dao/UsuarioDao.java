package br.com.projetopi.redesocial.dao;

import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.model.Usuario;
import br.com.projetopi.redesocial.repository.ConnectionFactory;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDao {
    Connection conexao;
    public UsuarioDao(){
        try {
            this.conexao = ConnectionFactory.getConnectionH2();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getIdByEmail(String email) {
        String sqlQuery = "select * from usuario where email = ?";
        try(PreparedStatement ps = conexao.prepareStatement(sqlQuery)){
            ps.setString(1, email);
            ResultSet result = ps.executeQuery();
            Usuario usuario = new Usuario();
            while(result.next()){
                usuario.setEmail(result.getString("email"));
                usuario.setPapel(result.getString("papel"));
                usuario.setSenha(result.getString("senha"));
                usuario.setId(result.getInt("id"));
            }
            return usuario.getId();
        }catch (Exception e){
            System.out.println("Erro " + e.getMessage());
            return 0;
        }
    }

    public void add(Usuario usuario){
        String sqlQuery = "insert into usuario " +
                "(email, senha, papel)" +
                "values (?,?,?,?)";
        try(PreparedStatement ps = conexao.prepareStatement(sqlQuery)) {
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getPapel());
            ps.execute();
        }catch (SQLException e){
            System.out.printf("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    public void remove(Usuario usuario) {
        String sqlQuery = "DELETE FROM usuario WHERE id =?";
        try {PreparedStatement ps = conexao.prepareStatement(sqlQuery);
            ps.setInt(1,usuario.getId());
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();

        }
    }

    public boolean update( Usuario usuario ) {
        String sqlQuery = """
        update usuario
        set 
         email = ?,
         senha = ?,
         papel = ?,
         where id = ? 
               """;

        try { PreparedStatement ps = conexao.prepareStatement(sqlQuery); {
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getSenha());
            ps.setString(3,usuario.getPapel());
            ps.setInt(4,usuario.getId());
        }

        }catch (SQLException e){
            System.out.println("Ocorreu erro " + e );
        }

        return true;
    }

    public ArrayList<Usuario> findAllPageable(int qtd_elementos, int num_inicio, String email, String senha, String papel) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sqlQuery = "SELECT * FROM usuario WHERE email = ? AND senha = ? AND papel = ? LIMIT ? OFFSET ?;";
        try (PreparedStatement ps = conexao.prepareStatement(sqlQuery)) {
            ps.setString(1, email);
            ps.setString(2, senha);
            ps.setString(3, papel);
            ps.setInt(4, qtd_elementos);
            ps.setInt(5, num_inicio);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setSenha(rs.getString("senha"));
                    usuario.setPapel(rs.getString("papel"));
                    usuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public Usuario findById(int id) {
        String sqlQuery = "select * from usuario where id = ?";
        ResultSet result;
        Usuario usuario = new Usuario();
        try {
            PreparedStatement ps = conexao.prepareStatement(sqlQuery);
            ps.setInt(1, id);
            result = ps.executeQuery();

            while (result.next()) {
                usuario.setEmail(result.getString("email"));
                usuario.setSenha(result.getString("senha"));
                usuario.setPapel(result.getString("papel"));
                usuario.setId(result.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return usuario;


    }

    public boolean exists(String email){
        String sqlQuery = "select * from usuario where email = ?";
        ResultSet result;
        try(PreparedStatement ps = conexao.prepareStatement(sqlQuery)){
            ps.setString(1, email);
            result = ps.executeQuery();

            while(result.next()){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public Usuario getByEmail(String email) {
        String sqlQuery = "select * from usuario where email = ?";
        try(PreparedStatement ps = conexao.prepareStatement(sqlQuery)){
            ps.setString(1, email);
            ResultSet result = ps.executeQuery();
            Usuario usuario = new Usuario();
            while(result.next()){
                usuario.setEmail(result.getString("email"));
                usuario.setPapel(result.getString("papel"));
                usuario.setSenha(result.getString("senha"));
                usuario.setId(result.getInt("id"));
            }
            return usuario;
        }catch (Exception e){
            System.out.println("Erro " + e.getMessage());
            return null;
        }
    }


    public ArrayList<Usuario> findAllPageableByRole(String papel, int qtd_elementos, int num_inicio) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sqlQuery = "SELECT * FROM usuario WHERE papel = ? LIMIT ? OFFSET ?";

        try (PreparedStatement ps = conexao.prepareStatement(sqlQuery)) {
            ps.setString(1, papel);
            ps.setInt(2, qtd_elementos);
            ps.setInt(3, num_inicio);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                Usuario usuario = new Usuario();
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }



}
