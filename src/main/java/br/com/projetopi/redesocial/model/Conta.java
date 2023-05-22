package br.com.projetopi.redesocial.model;

import br.com.projetopi.redesocial.util.ContaUtils;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;


public class Conta {
    private int id;
    private String cpf;
    private String nome;
    private String sobrenome;
    private String genero;
    private Date data_nascimento;
    private String sobre;

    private boolean ic_ativo;
    private int usuario_id;
    private int instituiacao_id;
    private int curso_id;
    private int foto_id;
    private int turma_id;

    private String foto;


    public Conta(){
        this.ic_ativo = true;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public boolean isIc_ativo() {
        return ic_ativo;
    }

    public void setIc_ativo(boolean ic_ativo) {
        this.ic_ativo = ic_ativo;
    }

    public Conta(String cpf, String nome, Date data_nascimento, String sobre, int usuario_id, int instituiacao_id, int curso_id, int foto_id, int turma_id, String genero) {
        this.cpf = cpf;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.sobre = sobre;
        this.usuario_id = usuario_id;
        this.instituiacao_id = instituiacao_id;
        this.curso_id = curso_id;
        this.foto_id = foto_id;
        this.turma_id = turma_id;
        this.genero = genero;
        this.ic_ativo = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return id == conta.id && ic_ativo == conta.ic_ativo && usuario_id == conta.usuario_id && instituiacao_id == conta.instituiacao_id && curso_id == conta.curso_id && foto_id == conta.foto_id && turma_id == conta.turma_id && Objects.equals(cpf, conta.cpf) && Objects.equals(nome, conta.nome) && Objects.equals(sobrenome, conta.sobrenome) && Objects.equals(genero, conta.genero) && Objects.equals(data_nascimento, conta.data_nascimento) && Objects.equals(sobre, conta.sobre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf, nome, sobrenome, genero, data_nascimento, sobre, ic_ativo, usuario_id, instituiacao_id, curso_id, foto_id, turma_id);
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getInstituiacao_id() {
        return instituiacao_id;
    }

    public void setInstituiacao_id(int instituiacao_id) {
        this.instituiacao_id = instituiacao_id;
    }

    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }

    public int getFoto_id() {
        return foto_id;
    }

    public void setFoto_id(int foto_id) {
        this.foto_id = foto_id;

        ContaUtils contaUtils = new ContaUtils();

        if(foto_id != 0){
            Foto foto = contaUtils.getFotoById(foto_id);

            setFoto(foto.getCd_foto());

        }
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFoto() {
        return foto;
    }

    public int getTurma_id() {
        return turma_id;
    }

    public void setTurma_id(int turma_id) {
        this.turma_id = turma_id;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", data_nascimento=" + data_nascimento +
                ", sobre='" + sobre + '\'' +
                ", usuario_id=" + usuario_id +
                ", instituiacao_id=" + instituiacao_id +
                ", curso_id=" + curso_id +
                ", foto_id=" + foto_id +
                ", turma_id=" + turma_id +
                '}';
    }
}
