<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="row no-gutter-col no-gutter-row">
<div class="col-2 no-gutter-row no-gutter-col container">
    <nav class="navbar navbar-expand-lg bg-dark side-nav d-flex align-items-start">
        <div class="d-flex flex-column w-100 h-100">
            <div class="d-flex w-100 bg-danger justify-content-center">
                <a class="navbar-brand" href="#">UNIHUB</a>
            </div>
            <div class="menu" id="navbarNav">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0 d-flex flex-column w-100">
                    <li class="nav-item menu-item d-flex justify-content-center">
                        <a class="nav-link" aria-current="page" href="admin?acao=ExibirPainel">
                            <div class="d-flex">
                           <span class="material-icons">
                              home
                           </span>
                           Home
                            </div>
                        </a>
                    </li>
                    <li class="nav-item menu-item d-flex justify-content-center">
                        <a class="nav-link " href="admin?acao=ExibirTelaConta">
                           <div class="d-flex flex-row">
                               <span class="material-icons d-flex">
                                       manage_accounts
                               </span>
                               Contas
                            </div>
                        </a>
                    </li>
                    <li class="nav-item menu-item d-flex justify-content-center">
                        <a class="nav-link" href="admin?acao=ExibirTelaCurso">
                           <div class="d-flex">
                           <span class="material-icons">
                                   add
                           </span>
                           Cursos
                            </div>
                        </a>
                    </li>
                    <li class="nav-item menu-item d-flex justify-content-center">
                        <a class="nav-link" href="admin?acao=ExibirTelaInstituicao">
                            <div class="d-flex">
                           <span class="material-icons">
                                   school
                           </span>
                            Instituicoes
                            </div>
                        </a>
                    </li>
                    <li class="nav-item menu-item d-flex justify-content-center">
                        <a class="nav-link" href="admin?acao=ExibirTelaTurma">
                            Turma
                        </a>
                    </li>
                    <li class="nav-item menu-item d-flex justify-content-center">
                        <a class="nav-link" href="admin?acao=ExibirTelaUsuario">
                            Usuario
                        </a>
                    </li>

                </ul>
            </div>
            <div class="h-100">
                <a href="login?acao=Deslogar" class="text-decoration-none">
                <span class="material-icons text-danger d-flex justify-content-center">
                       exit_to_app
               </span>
               </a>
            </div>
        </div>
    </nav>
</div>
