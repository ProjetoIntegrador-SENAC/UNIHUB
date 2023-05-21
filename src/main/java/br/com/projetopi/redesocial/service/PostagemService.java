package br.com.projetopi.redesocial.service;

import br.com.projetopi.redesocial.dao.PostagemDao;
import br.com.projetopi.redesocial.interfaces.Service;
import br.com.projetopi.redesocial.model.Postagem;

import java.util.ArrayList;

public class PostagemService implements Service<Postagem> {

    private PostagemDao postagemDao;

    public PostagemService(){
        this.postagemDao = new PostagemDao();
    }

    @Override
    public void add(Postagem postagem) {
        this.postagemDao.add(postagem);
    }

    @Override
    public boolean update(Postagem postagem) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        this.postagemDao.remove(id);
        return true;
    }

    @Override
    public ArrayList findAllPageable(int qtd_elementos, int num_inicio) {
        return null;
    }

    public ArrayList<Postagem> findAllPageable() {
        return this.postagemDao.findAllPostagem();
    }
    @Override
    public ArrayList findAllPageable(int instituicao_id, int qtd_elementos, int num_inicio) {
        ArrayList<Postagem> postagens =  this.postagemDao.findAllPageableByInstituicao(instituicao_id, qtd_elementos, num_inicio);
        return postagens;
    }

    public ArrayList<Postagem> findByAccountId(int conta_id,int  qtd_elementos, int num_inicio){
        return this.postagemDao.findByAccountPageable(conta_id, qtd_elementos, num_inicio);
    }

    public int getCount(){
        return this.postagemDao.getCount();
    }

}
