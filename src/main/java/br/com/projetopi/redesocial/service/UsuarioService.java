package br.com.projetopi.redesocial.service;

import br.com.projetopi.redesocial.dao.UsuarioDao;
import br.com.projetopi.redesocial.interfaces.Service;
import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.model.Usuario;

import java.util.ArrayList;

public class UsuarioService implements Service<Usuario> {

    UsuarioDao usuarioDao;

    public UsuarioService(){
        this.usuarioDao = new UsuarioDao();
    }

    public void add(Usuario usuario){
        this.usuarioDao.add(usuario);
    }

    @Override
    public boolean update(Usuario object) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return usuarioDao.remove(id);
    }

    @Override
    public ArrayList findAllPageable(int qtd_elementos, int num_inicio) {
        return null;
    }

    public ArrayList<Usuario> getUsuarioAll(String papel, int qtd_elementos, int num_inicio){
        return usuarioDao.findAllPageableByRole(papel,qtd_elementos,num_inicio);
    }


    public int getIdByEmail(String email){
        int id = usuarioDao.getIdByEmail(email);
        return id;
    }

    public boolean exists(String email){
        return this.usuarioDao.exists(email);
    }

    public Usuario getByEmail(String email){
        return this.usuarioDao.getByEmail(email);
    }

    public int getCount(){
        return this.usuarioDao.getCount();}

}
