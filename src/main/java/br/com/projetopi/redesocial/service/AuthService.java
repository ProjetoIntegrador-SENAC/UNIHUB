package br.com.projetopi.redesocial.service;

import br.com.projetopi.redesocial.model.Usuario;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class AuthService {

    private static List<String> passwords = new ArrayList<>();
    public String hashPassword(String password){
        passwords.add(password);
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    public boolean checkPassword(String password, String hashed){
        return BCrypt.checkpw(password, hashed);
    }

    public String getPassword(String hashed){
        for(String password : passwords){
            if(BCrypt.checkpw(password, hashed)){
                return password;
            }
        }
        return null;
    }

    public boolean userSessionIsActive(HttpServletRequest req){
        HttpSession session = req.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null){
            return false;
        }
        return true;
    }

    public Usuario getLoggedUser(HttpServletRequest req){
        HttpSession session = req.getSession();
        return (Usuario) session.getAttribute("usuarioLogado");
    }
}
