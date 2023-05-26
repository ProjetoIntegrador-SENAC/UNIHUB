package br.com.projetopi.redesocial.controller.conta.action;

import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.model.Foto;
import br.com.projetopi.redesocial.model.Postagem;
import br.com.projetopi.redesocial.service.ContaService;
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
@WebServlet("/fotoperfil")
public class FotoDePerfil  extends HttpServlet {

    private ContaService contaService;
    private FotoService fotoService;

    public FotoDePerfil(){
        this.contaService = new ContaService();
        this.fotoService = new FotoService();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Pega o conteúdo e o arquivo da postagem
        Map<String, String> parameters = uploadImage(request);

        String postImagePath = parameters.get("image");

        //Cria foto
        Foto foto = new Foto(postImagePath);

        fotoService = new FotoService();

        int fotoId = fotoService.add(foto);

        //Pega o usuário logado
        var session = request.getSession();
        Conta conta = (Conta) session.getAttribute("contaLogado");

        // Adiciona foto no usuário logado
        contaService.addFoto(conta.getId(), fotoId);

        response.sendRedirect("/conta?acao=ExibirPerfil");

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
                requestParameters.put("image", "img/fotos/user.png");
            }
        }

        return requestParameters;
    }

    private void checkFieldType(FileItem fileItem, Map<String, String> requestParameters) throws Exception {

        if (fileItem.isFormField()) {

            requestParameters.put(fileItem.getFieldName(), fileItem.getString());
        } else {

            String fileName = processUploadedFile(fileItem);
            requestParameters.put("image", "img/fotos/".concat(fileName));

        }
    }

    private String processUploadedFile(FileItem fileItem) throws Exception {
        Long currentTime = new Date().getTime();
        String fileName = currentTime.toString().concat("-").concat(fileItem.getName().replace(" ", ""));
        String filePath = this.getServletContext().getRealPath("img/fotos").concat(File.separator).concat(fileName);
        fileItem.write(new File(filePath));
        return fileName;
    }
}
