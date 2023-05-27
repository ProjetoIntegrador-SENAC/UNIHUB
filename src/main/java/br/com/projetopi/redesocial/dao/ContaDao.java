package br.com.projetopi.redesocial.dao;

import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.model.dto.ContaPerfilDto;
import br.com.projetopi.redesocial.repository.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;

public class ContaDao {

    Connection conexao;
    public ContaDao(){
        try {
            this.conexao = ConnectionFactory.getConnectionH2();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void add(Conta conta){
        String sqlQuery = "insert into conta " +
                "(cpf, nome, data_nascimento, sobre, usuario_id, instituicao_id, curso_id, turma_id, genero, sobrenome, foto_id)" +
                "values (?,?,?,?,?,?,?,?,?,?,?)";

        try(PreparedStatement ps = conexao.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, conta.getCpf().replace(".", "").replace(",", "").replace("-", ""));
            ps.setString(2, conta.getNome());
            ps.setDate(3, conta.getData_nascimento());
            ps.setString(4, conta.getSobre());
            ps.setInt(5, conta.getUsuario_id());
            ps.setInt(6, conta.getInstituiacao_id());
            ps.setInt(7, conta.getCurso_id());
            ps.setInt(8, conta.getTurma_id());
            ps.setString(9, conta.getGenero());
            ps.setString(10, conta.getSobrenome());
            ps.setInt(11, conta.getFoto_id());
            ps.execute();

            try(ResultSet set = ps.getGeneratedKeys()){
              conta.setId(set.getInt(1));
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean addFoto(int id_conta, int foto_id){
        String SQL = "UPDATE CONTA SET FOTO_ID = ? WHERE ID = ?";

        try(PreparedStatement statement = conexao.prepareStatement(SQL)){

            statement.setInt(1, foto_id);
            statement.setInt(2, id_conta);

            statement.execute();

            return true;
        } catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }
    public boolean update(Conta conta){
        String sqlQuery = """
            update conta 
            set 
                cpf = ?,
                nome = ?,
                data_nascimento = ?,
                sobre = ?,
                usuario_id = ?,
                instituiacao_id = ?,
                curso_id = ?,
                foto_id = ?,
                turma_id = ?
            where id  = ?
        """;
        try(PreparedStatement ps = conexao.prepareStatement(sqlQuery)) {
            ps.setString(1, conta.getCpf());
            ps.setString(2, conta.getNome());
            ps.setDate(3, conta.getData_nascimento());
            ps.setString(4, conta.getSobre());
            ps.setInt(5, conta.getUsuario_id());
            ps.setInt(6, conta.getInstituiacao_id());
            ps.setInt(7, conta.getCurso_id());
            ps.setInt(8, conta.getFoto_id());
            ps.setInt(9, conta.getTurma_id());
            ps.setInt(10, conta.getId());
        }catch (SQLException e){
            System.out.println("Ocorreu o erro " + e);;
            return false;
        }
        return true;
    }
    public boolean remove(int id){
        String sqlQuery = "update conta set ic_ativo = ? where id = ?";
        try(PreparedStatement ps = conexao.prepareStatement(sqlQuery)){
            ps.setInt(1, 0);
            ps.setInt(2, id);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public ArrayList<Conta> findAllPageable(int qtd_elementos, int num_inicio){

        ArrayList<Conta> contas = new ArrayList<>();

        String sqlQuery = "SELECT * FROM conta where ic_ativo = ?  LIMIT ? OFFSET ?;"; //TODO
        try(PreparedStatement ps = conexao.prepareStatement(sqlQuery)) {
            ps.setInt(1, 1);
            ps.setInt(2, qtd_elementos);
            ps.setInt(3, num_inicio);

            ResultSet result = ps.executeQuery();

            while(result.next()){
                Conta conta = new Conta();
                conta.setCpf(result.getString("cpf"));
                conta.setNome(result.getString("nome"));
                conta.setData_nascimento(result.getDate("data_nascimento"));
                conta.setGenero(result.getString("genero"));
                conta.setSobre(result.getString("sobre"));
                conta.setUsuario_id(result.getInt("usuario_id"));
                conta.setInstituiacao_id(result.getInt("instituicao_id"));
                conta.setCurso_id(result.getInt("curso_id"));
                conta.setFoto_id(result.getInt("foto_id"));
                conta.setTurma_id(result.getInt("turma_id"));
                conta.setId(result.getInt("id"));
                contas.add(conta);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return contas;
    }

    public ArrayList<Conta> findAllPageableByTurmaId(int turma_id, int qtd_elementos, int num_inicio, int usuario_id){
        ArrayList<Conta> contas = new ArrayList<>();
        String sqlQuery = "select * from conta where turma_id = ? and usuario_id != ? LIMIT ? OFFSET ?;";
        try(PreparedStatement ps = conexao.prepareStatement(sqlQuery)) {
            ps.setInt(1, turma_id);
            ps.setInt(2, usuario_id);
            ps.setInt(3, qtd_elementos);
            ps.setInt(4, num_inicio);

            ps.execute();

            try(ResultSet result = ps.getResultSet()){
                while(result.next()){
                    Conta conta = new Conta();
                    conta.setCpf(result.getString("cpf"));
                    conta.setNome(result.getString("nome"));
                    conta.setData_nascimento(result.getDate("data_nascimento"));
                    conta.setGenero(result.getString("genero"));
                    conta.setSobre(result.getString("sobre"));
                    conta.setUsuario_id(result.getInt("usuario_id"));
                    conta.setInstituiacao_id(result.getInt("instituicao_id"));
                    conta.setCurso_id(result.getInt("curso_id"));
                    conta.setFoto_id(result.getInt("foto_id"));
                    conta.setTurma_id(result.getInt("turma_id"));
                    conta.setId(result.getInt("id"));

                    contas.add(conta);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return contas;
    }


    public Conta findById(int id){

        String sqlQuery = "select * from conta where id = ?";
        ResultSet result;
        Conta conta = new Conta();

        try(PreparedStatement ps = conexao.prepareStatement(sqlQuery)){
            ps.setInt(1, id);
            result = ps.executeQuery();

            while(result.next()){
                conta.setCpf(result.getString("cpf"));
                conta.setNome(result.getString("nome"));
                conta.setData_nascimento(result.getDate("data_nascimento"));
                conta.setGenero(result.getString("genero"));
                conta.setSobre(result.getString("sobre"));
                conta.setUsuario_id(result.getInt("usuario_id"));
                conta.setInstituiacao_id(result.getInt("instituicao_id"));
                conta.setCurso_id(result.getInt("curso_id"));
                conta.setFoto_id(result.getInt("foto_id"));
                conta.setTurma_id(result.getInt("turma_id"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conta;

    }

    public boolean exists(String cpf){
        String sqlQuery = "select * from conta where cpf = ?";
        ResultSet result;
        try(PreparedStatement ps = conexao.prepareStatement(sqlQuery)){
            ps.setString(1, cpf);
            result = ps.executeQuery();

            while(result.next()){
               return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public Conta getByUsuarioId(int id) {
        String sqlQuery = "select * from conta where usuario_id = ?";
        ResultSet result;
        Conta conta = new Conta();

        try(PreparedStatement ps = conexao.prepareStatement(sqlQuery)){
            ps.setInt(1, id);
            result = ps.executeQuery();

            while(result.next()){
                conta.setSobrenome(result.getString("sobrenome"));
                conta.setId(result.getInt("id"));
                conta.setCpf(result.getString("cpf"));
                conta.setNome(result.getString("nome"));
                conta.setData_nascimento(result.getDate("data_nascimento"));
                conta.setGenero(result.getString("genero"));
                conta.setSobre(result.getString("sobre"));
                conta.setUsuario_id(result.getInt("usuario_id"));
                conta.setInstituiacao_id(result.getInt("instituicao_id"));
                conta.setCurso_id(result.getInt("curso_id"));
                conta.setFoto_id(result.getInt("foto_id"));
                conta.setTurma_id(result.getInt("turma_id"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conta;
    }

    public ContaPerfilDto getContaPerfilData(int conta_id){
        String sqlQuery =
            """
            select\s
            co.id, co.cpf, co.nome nome_conta, co.data_nascimento, co.sobre, co.genero, co.sobrenome, co.usuario_id, co.instituicao_id, co.foto_id, co.turma_id, co.curso_id,
            cu.nome curso_nome, cu.tipo curso_tipo, cu.area curso_area,
            foto.cd_foto,\s
            t.data_inicio, t.turno, t.semestre, t.letra,\s
            i.nome nome_instituicao
            from conta co\s
            left join curso cu\s
            on co.curso_id = cu.id
            left join foto\s
            on foto.id = co.foto_id
            left join turma t
            on t.id = co.turma_id
            left join instituicao i
            on i.id = co.instituicao_id
            where co.id = ?
            """;

        ResultSet result;
        ContaPerfilDto conta = new ContaPerfilDto();

        try(PreparedStatement ps = conexao.prepareStatement(sqlQuery)){
            ps.setInt(1, conta_id);
            result = ps.executeQuery();

            while(result.next()){
                conta.setCpf(result.getString("cpf"));
                conta.setData_nascimento(result.getDate("data_nascimento"));
                conta.setGenero(result.getString("genero"));
                conta.setSobre(result.getString("sobre"));
                conta.setUsuario_id(result.getInt("usuario_id"));
                conta.setCurso_id(result.getInt("curso_id"));
                conta.setFoto_id(result.getInt("foto_id"));
                conta.setTurma_id(result.getInt("turma_id"));
                conta.setNome_conta(result.getString("nome_conta"));
                conta.setData_inicio(result.getDate("data_inicio"));
                conta.setNome_instituicao(result.getString("nome_instituicao"));
                conta.setCurso_nome(result.getString("curso_nome"));
                conta.setSobrenome(result.getString("sobrenome"));

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conta;

    }

    private void fillResultSet(ArrayList<Conta> contas, ResultSet result) throws SQLException {
        while(result.next()){
            Conta conta = new Conta();
            conta.setSobrenome(result.getString("sobrenome"));
            conta.setId(result.getInt("id"));
            conta.setCpf(result.getString("cpf"));
            conta.setNome(result.getString("nome"));
            conta.setData_nascimento(result.getDate("data_nascimento"));
            conta.setGenero(result.getString("genero"));
            conta.setSobre(result.getString("sobre"));
            conta.setUsuario_id(result.getInt("usuario_id"));
            conta.setInstituiacao_id(result.getInt("instituicao_id"));
            conta.setCurso_id(result.getInt("curso_id"));
            conta.setFoto_id(result.getInt("foto_id"));
            conta.setTurma_id(result.getInt("turma_id"));
            contas.add(conta);
        }
    }

    public void removePost(int id) {
        String SQL = "DELETE FROM POSTAGEM WHERE ID = (?)";

        try (PreparedStatement statement = conexao.prepareStatement(SQL)){
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getCount(){
        String sqlQuery = "select count(*) from conta";
        try (PreparedStatement statement = conexao.prepareStatement(sqlQuery)){
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

}
