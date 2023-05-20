package br.com.projetopi.redesocial.model.dto;

import java.util.Date;

public class ContaPerfilDto {

    private int id;
    private String cpf;
    private String nome_conta;
    private Date data_nascimento;
    private String sobre;
    private String genero;
    private int usuario_id;
    private int instituicao_id;
    private int foto_id;
    private int turma_id;
    private String sobrenome;
    private int curso_id;
    private String curso_nome;
    private String curso_tipo;
    private String curso_area;
    private byte[] cd_foto;
    private Date data_inicio;
    private String turno;
    private String semestre;
    private String letra;
    private String nome_instituicao;

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCurso_nome() {
        return curso_nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome_conta() {
        return nome_conta;
    }

    public void setNome_conta(String nome_conta) {
        this.nome_conta = nome_conta;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getInstituicao_id() {
        return instituicao_id;
    }

    public void setInstituicao_id(int instituicao_id) {
        this.instituicao_id = instituicao_id;
    }

    public int getFoto_id() {
        return foto_id;
    }

    public void setFoto_id(int foto_id) {
        this.foto_id = foto_id;
    }

    public int getTurma_id() {
        return turma_id;
    }

    public void setTurma_id(int turma_id) {
        this.turma_id = turma_id;
    }

    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }

    public String getCurso_nome(String dataInicio) {
        return curso_nome;
    }

    public void setCurso_nome(String curso_nome) {
        this.curso_nome = curso_nome;
    }

    public String getCurso_tipo() {
        return curso_tipo;
    }

    public void setCurso_tipo(String curso_tipo) {
        this.curso_tipo = curso_tipo;
    }

    public String getCurso_area() {
        return curso_area;
    }

    public void setCurso_area(String curso_area) {
        this.curso_area = curso_area;
    }

    public byte[] getCd_foto() {
        return cd_foto;
    }

    public void setCd_foto(byte[] cd_foto) {
        this.cd_foto = cd_foto;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getNome_instituicao() {
        return nome_instituicao;
    }

    public void setNome_instituicao(String nome_instituicao) {
        this.nome_instituicao = nome_instituicao;
    }
}
