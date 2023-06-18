package model;

import java.time.LocalDate;

// ainda nao foi falado sobre o id
// Endereco endereco = composição
// extends ____ = herança
// Sexo é um ENUM
public class Cadastro {

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private Sexo sexo;
    private String email;
    private Endereco endereco;
    private Contato contato;
    private AtividadeProfissional atividadeProfissional;

    public Cadastro() {}

    //Construtor utilizado para fazer a leitura do arquivo csv
    public Cadastro(String nome, String cpf, LocalDate dataNascimento, Sexo sexo, String email, Endereco endereco, Contato contato, AtividadeProfissional atividadeProfissional) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.email = email;
        this.endereco = endereco;
        this.contato = contato;
        this.atividadeProfissional = atividadeProfissional;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public AtividadeProfissional getAtividadeProfissional() {
        return atividadeProfissional;
    }

    public void setAtividadeProfissional(AtividadeProfissional profissao) {
        this.atividadeProfissional = profissao;
    }

}
