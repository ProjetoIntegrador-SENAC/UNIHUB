package br.com.projetopi.redesocial.util;

import br.com.projetopi.redesocial.model.Foto;
import br.com.projetopi.redesocial.model.Postagem;
import br.com.projetopi.redesocial.model.dto.ContaPerfilDto;
import br.com.projetopi.redesocial.service.*;

public class ContaUtils {

    private ContaService contaService;
    private PostagemService postagemService;
    private UsuarioService usuarioService;
    private FotoService fotoService;
    private InstituicaoService instituicaoService;

    public ContaUtils(){
        fotoService = new FotoService();
    }

    public ContaPerfilDto idContaToPerfilObject (int conta_id){
        return null;
    }

    public Foto getFotoById(int foto_id){
        return fotoService.getFotoById(foto_id);
    }

}
