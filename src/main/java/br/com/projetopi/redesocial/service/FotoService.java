package br.com.projetopi.redesocial.service;

import br.com.projetopi.redesocial.dao.FotoDAO;
import br.com.projetopi.redesocial.model.Foto;

import java.util.Optional;

public class FotoService {

    private FotoDAO fotoDAO;

    public FotoService(){
        this.fotoDAO = new FotoDAO();
    }
    public int add(Foto foto) {
        return new FotoDAO().toadd(foto);
    }
    public Optional<Boolean> update(Foto foto) {
        new FotoDAO().findById(foto.getId())
                .map(fotoExistente ->{
                    new FotoDAO().update(foto);
                    return Optional.of(true);
                }).orElseGet(()-> {
                    return Optional.of(false);
                });
        return Optional.ofNullable(null);
    }

    public Foto getFotoById(int id){
        return fotoDAO.findById(id).get();
    }
}
