package utils;

import model.Sexo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CadastroBuilder {

    /*
    As variáveis salario, pretensaoMaxima e pretensaoMinima eram pra ser Double mas estou utilizando String porque
    adicionei "R$" na frente dos números
 */
    public static StringBuilder construirStringBuilderNIO(String nome, String cpf, String logradouro, String estado,
                                                       String cidade, String bairro, Integer numero, String complemento,
                                                       LocalDate dataNascimento, String email, Sexo sexo, Long telefone,
                                                       String celular, boolean celularWhats, String profissao,
                                                       String empresa, String salario, String pretensaoMinima,
                                                       String pretensaoMaxima, boolean empregoAtual,
                                                       List<String> habilidades){
        StringBuilder sb = new StringBuilder();
        DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // STRING BUILDER, representação personalizada
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("CPF: ").append(cpf).append("\n");
        sb.append("Logradouro: ").append(logradouro).append("\n");
        sb.append("Estado: ").append(estado).append("\n");
        sb.append("Cidade: ").append(cidade).append("\n");
        sb.append("Bairro: ").append(bairro).append("\n");
        sb.append("Número: ").append(numero).append("\n");
        sb.append("Complemento: ").append(complemento).append("\n");
        sb.append("Data de Nascimento: ").append(dataNascimento.format(formatarData)).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Sexo: ").append(sexo).append("\n");
        sb.append("Telefone: ").append(telefone).append("\n");
        sb.append("Celular: ").append(celular).append("\n");
        sb.append("Celular com WhatsApp: ").append(celularWhats).append("\n");
        sb.append("Profissão: ").append(profissao).append("\n");
        sb.append("Empresa: ").append(empresa).append("\n");
        sb.append("Salário: ").append(salario).append("\n");
        sb.append("Pretensão Mínima: ").append(pretensaoMinima).append("\n");
        sb.append("Pretensão Máxima: ").append(pretensaoMaxima).append("\n");
        sb.append("Emprego Atual: ").append(empregoAtual).append("\n");
        sb.append("Habilidades: ").append(habilidades).append("\n\n");

        sb.append("*********************************************");
        sb.append("\n\n");

        return sb;
    }

    public static StringBuilder construirStringBuilderPOI(String nome, String cpf, String logradouro, String estado,
                                                          String cidade, String bairro, Integer numero, String complemento,
                                                          LocalDate dataNascimento, String email, Sexo sexo, Long telefone,
                                                          String celular, boolean celularWhats, String profissao,
                                                          String empresa, Double salario, Double pretensaoMinima,
                                                          Double pretensaoMaxima, boolean empregoAtual,
                                                          List<String> habilidades){
        StringBuilder sb = new StringBuilder();
        DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        sb.append("Nome: ").append(nome).append("\n");
        sb.append("CPF: ").append(cpf).append("\n");
        sb.append("Logradouro: ").append(logradouro).append("\n");
        sb.append("Estado: ").append(estado).append("\n");
        sb.append("Cidade: ").append(cidade).append("\n");
        sb.append("Bairro: ").append(bairro).append("\n");
        sb.append("Número: ").append(numero).append("\n");
        sb.append("Complemento: ").append(complemento).append("\n");
        sb.append("Data de Nascimento: ").append(dataNascimento.format(formatarData)).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Sexo: ").append(sexo).append("\n");
        sb.append("Telefone: ").append(telefone).append("\n");
        sb.append("Celular: ").append(celular).append("\n");
        sb.append("Celular com WhatsApp: ").append(celularWhats).append("\n");
        sb.append("Profissão: ").append(profissao).append("\n");
        sb.append("Empresa: ").append(empresa).append("\n");
        sb.append("Salário: ").append(salario).append("\n");
        sb.append("Pretensão Mínima: ").append(pretensaoMinima).append("\n");
        sb.append("Pretensão Máxima: ").append(pretensaoMaxima).append("\n");
        sb.append("Emprego Atual: ").append(empregoAtual).append("\n");
        sb.append("Habilidades: ").append(habilidades).append("\n\n");

        sb.append("*********************************************");
        sb.append("\n\n");

        return sb;
    }

}
