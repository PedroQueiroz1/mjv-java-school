package model;

public class Contato {
    private Long telefone;
    private String celular;
    private boolean celularWhats;

    public Contato() {}

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public boolean isCelularWhats() {
        return celularWhats;
    }

    public void setCelularWhats(boolean celularWhats) {
        this.celularWhats = celularWhats;
    }

}
