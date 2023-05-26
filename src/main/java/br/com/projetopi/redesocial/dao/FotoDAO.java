package br.com.projetopi.redesocial.dao;

import br.com.projetopi.redesocial.model.Foto;
import br.com.projetopi.redesocial.repository.ConnectionFactory;

import javax.servlet.http.HttpServlet;
import java.sql.*;
import java.util.Optional;

public class FotoDAO{

    Connection conexao;

    public FotoDAO() {
        conexao = ConnectionFactory.getConnectionH2();
    }

    public int toadd(Foto foto) {
        String INSERT = "insert into foto (cd_foto) values (?)";

        try (PreparedStatement statement = conexao.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, foto.getCd_foto());
            statement.execute();

            int id = 0;

            try(ResultSet rst = statement.getGeneratedKeys()){
                while(rst.next()) {
                    foto.setId(rst.getInt(1));
                    id = rst.getInt(1);
                }
            }
            return id;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public boolean remove(int id) {
        String DELETE = "DELETE FROM foto WHERE id =?";
        try (PreparedStatement stmt = conexao.prepareStatement(DELETE)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(Foto foto) {
        String update = "UPDATE foto SET cd_foto = ? WHERE id =? ";
        try (PreparedStatement stmt = conexao.prepareStatement(update)) {
            stmt.setString(1, foto.getCd_foto());
            stmt.setInt(2, foto.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Optional<Foto> findById(int id) {
        String select = "SELECT * FROM foto WHERE id =?";
        StringBuilder sb = new StringBuilder();
        ResultSet resultado;

        try (PreparedStatement stmt = conexao.prepareStatement(select)) {
            stmt.setInt(1, id);
            resultado = stmt.executeQuery();

            if (resultado.next()) {
                return Optional.of(new Foto(resultado.getInt("id"),
                        resultado.getString("cd_foto")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
        return Optional.empty();
    }

}
