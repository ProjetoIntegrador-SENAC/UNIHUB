package br.com.projetopi.redesocial.service;

import br.com.projetopi.redesocial.dao.InstituicaoDao;
import br.com.projetopi.redesocial.model.Instituicao;

import java.util.ArrayList;

public class InstituicaoService {

    InstituicaoDao instituicaoDao;

    public InstituicaoService(){
        instituicaoDao = new InstituicaoDao();
    }

    public ArrayList<Instituicao> getInstituicaoAll(int qtd_elementos, int num_inico){
        return instituicaoDao.findAllPageble(qtd_elementos, num_inico);
    }

    public ArrayList<Instituicao> getInstituicaoAll(){
        return instituicaoDao.findAll();
    }

    public Instituicao getInstituicaoById(int id){
        return instituicaoDao.findById(id);
    }

    public void update(Instituicao instituicao){
        this.instituicaoDao.update(instituicao);
    }

    public boolean remove(int id) {
        return this.instituicaoDao.remove(id);
    }

    public boolean add(String nome) {
        Instituicao instituicao = new Instituicao();
        instituicao.setNome(nome);
        return this.instituicaoDao.add(instituicao);
    }
}
