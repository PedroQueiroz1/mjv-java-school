package model;

import java.util.List;

public class AtividadeProfissional {
    private String profissao;
    private String empresa;
    private Double salario;
    private boolean empregoAtual;
    private Double pretensaoMinima;
    private Double pretensaoMaxima;
    private List<String> habilidades;

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public boolean isEmpregoAtual() {
        return empregoAtual;
    }

    public void setEmpregoAtual(boolean empregoAtual) {
        this.empregoAtual = empregoAtual;
    }

    public Double getPretensaoMinima() {
        return pretensaoMinima;
    }

    public void setPretensaoMinima(Double pretensaoMinima) {
        this.pretensaoMinima = pretensaoMinima;
    }

    public Double getPretensaoMaxima() {
        return pretensaoMaxima;
    }

    public void setPretensaoMaxima(Double pretensaoMaxima) {
        this.pretensaoMaxima = pretensaoMaxima;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

}
