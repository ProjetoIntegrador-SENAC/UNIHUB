package br.com.projetopi.redesocial.service;

import br.com.projetopi.redesocial.dao.ContaDao;
import br.com.projetopi.redesocial.dao.UsuarioDao;
import br.com.projetopi.redesocial.interfaces.Service;
import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.model.dto.ContaPerfilDto;

import java.util.ArrayList;

public class ContaService implements Service<Conta> {

    private ContaDao contaDao;
    private UsuarioDao usuarioDao;

    public ContaService(){

        this.contaDao = new ContaDao();
        this.usuarioDao = new UsuarioDao();
    }

    public boolean exists(String cpf) {
        return this.contaDao.exists(cpf);
    }

    public ArrayList<Conta> getContaAll(int qtd_elementos, int num_inico){
        return contaDao.findAllPageable(qtd_elementos, num_inico);
    }

    public Conta getContaById(int id){
        return contaDao.findById(id);
    }

    public void add(Conta conta) {
        this.contaDao.add(conta);
    }

    public boolean addFoto(int id_conta, int id_foto){
        return this.contaDao.addFoto(id_conta, id_foto);
    }

    @Override
    public boolean update(Conta object) {
        contaDao.update(object);
        return false;
    }

    @Override
    public boolean remove(int id) {
        this.contaDao.remove(id);
        return true;
    }

    @Override
    public ArrayList findAllPageable(int qtd_elementos, int num_inicio) {
        return null;
    }

    public Conta getContaByUsuarioId(int id){
        return this.contaDao.getByUsuarioId(id);
    }

    public ContaPerfilDto getContaDadosPerfilView(int conta_id){
        return this.contaDao.getContaPerfilData(conta_id);
    }

    public ArrayList<Conta> findAllPageableByTurmaId(int turma_id, int qtd_elementos, int num_inicio, int id_usuario){
        return contaDao.findAllPageableByTurmaId(turma_id, qtd_elementos, num_inicio, id_usuario);
    }

    public int getCount(){
        return this.contaDao.getCount();
    }
}
