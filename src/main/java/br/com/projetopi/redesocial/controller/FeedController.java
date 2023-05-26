package br.com.projetopi.redesocial.controller;

import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.model.Foto;
import br.com.projetopi.redesocial.model.Postagem;
import br.com.projetopi.redesocial.service.FotoService;
import br.com.projetopi.redesocial.service.PostagemService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.fileupload.servlet.ServletFileUpload.isMultipartContent;


@WebServlet("/foto")
public class FeedController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Pega o conteúdo e o arquivo da postagem
        Map<String, String> parameters = uploadImage(req);

        String postImagePath = parameters.get("image");
        String legenda = parameters.get("legenda");

        //Cria foto
        Foto foto = new Foto(postImagePath);

        FotoService fotoService = new FotoService();

        fotoService.add(foto);

        //Pega o usuário logado
        var session = req.getSession();
        Conta conta = (Conta) session.getAttribute("contaLogado");

        //Cria postagem
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        Postagem postagem = new Postagem(legenda, foto.getId(), postImagePath, conta.getId(), date);

        PostagemService postagemService =  new PostagemService();

        postagemService.add(postagem);

        resp.sendRedirect("/conta?acao=ExibirFeed");

    }

    private Map<String, String> uploadImage(HttpServletRequest httpServletRequest) {
        Map<String, String> requestParameters = new HashMap<>();

        if(isMultipartContent(httpServletRequest)) {
            try {

                DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

                List<FileItem> fileItems = new ServletFileUpload(diskFileItemFactory).parseRequest(httpServletRequest);

                for (FileItem fileItem : fileItems){
                    checkFieldType(fileItem, requestParameters);
                }
            } catch (Exception e){
                requestParameters.put("image", "img/post/default-image.png");
            }
        }

        return requestParameters;
    }

    private void checkFieldType(FileItem fileItem, Map<String, String> requestParameters) throws Exception {

        if (fileItem.isFormField()) {

            requestParameters.put(fileItem.getFieldName(), fileItem.getString());
        } else {

            String fileName = processUploadedFile(fileItem);
            requestParameters.put("image", "img/post/".concat(fileName));

        }
    }

    private String processUploadedFile(FileItem fileItem) throws Exception {
        Long currentTime = new Date().getTime();
        String fileName = currentTime.toString().concat("-").concat(fileItem.getName().replace(" ", ""));
        String filePath = this.getServletContext().getRealPath("img/post").concat(File.separator).concat(fileName);
        fileItem.write(new File(filePath));
        return fileName;
    }


}
