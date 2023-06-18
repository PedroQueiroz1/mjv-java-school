package utils;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CadastroUtil {

    private static Cadastro criarCadastro(String nome, String cpf, LocalDate dataNascimento, Sexo sexo, String email,
                                          String logradouro, Integer numero, String bairro, String complemento,
                                          String cidade, String estado, String profissao, String empresa,
                                          Double salario, boolean empregoAtual, Double pretensaoMinima,
                                          Double pretensaoMaxima, List<String> habilidades, Long telefone,
                                          String celular, boolean celularWhats){

        String habilidadesFormatada = String.join(" ", habilidades);

        Endereco endereco = new Endereco();
        endereco.setLogradouro(logradouro);
        endereco.setNumero(numero);
        endereco.setBairro(bairro);
        endereco.setComplemento(complemento);
        endereco.setCidade(cidade);
        endereco.setEstado(estado);

        AtividadeProfissional aP = new AtividadeProfissional();
        aP.setProfissao(profissao);
        aP.setEmpresa(empresa);
        aP.setSalario(salario);
        aP.setEmpregoAtual(empregoAtual);
        aP.setPretensaoMinima(pretensaoMinima);
        aP.setPretensaoMaxima(pretensaoMaxima);
        aP.setHabilidades(Collections.singletonList(habilidadesFormatada));

        Contato contato = new Contato();
        contato.setTelefone(telefone);
        contato.setCelular(celular);
        contato.setCelularWhats(celularWhats);

        Cadastro cadastro = new Cadastro();
        cadastro.setNome(nome);
        cadastro.setCpf(cpf);
        cadastro.setDataNascimento(dataNascimento);
        cadastro.setSexo(sexo);
        cadastro.setEmail(email);
        cadastro.setEndereco(endereco);
        cadastro.setContato(contato);
        cadastro.setAtividadeProfissional(aP);

        return cadastro;
    }

    public static Cadastro criarCadastro2(){

        List<String> habilidades2 = new ArrayList<>();
        habilidades2.add("Pacote Office");
        habilidades2.add("Grafico");

        String habilidadesString = String.join(" ", habilidades2);

        Endereco endereco2 = getEndereco("Rua Exemplo2",11,"Bairro Teste2",
                "Complemento 2","Cidade C","Estado E");

        AtividadeProfissional aP2 = getAtividadeProfissional(Collections.singletonList(habilidadesString),
                1600.33,2000.00,false,1603.55,
                "Empresa 2","Cientista de dados");

        Contato contato2 = getContato(333333999L, "999999999", false);

        Cadastro cadastro2 = getCadastro(
                endereco2, "Esther", "444.334.114-31", LocalDate.parse("1997-11-04"),
                Sexo.FEMININO, "esther@gmail.com", contato2, aP2);

        return cadastro2;
    }

    // INSTANCIANDO CADASTRO 2 E ENDEREÇO 2 E ATIVIDADE PROFISSIONAL 2
    private static Cadastro getCadastro(Endereco endereco2, String nome, String cpf, LocalDate dataNascimento,
                                        Sexo sexo, String email, Contato contato2, AtividadeProfissional aP) {

        Cadastro cadastro2 = new Cadastro();
        cadastro2.setNome(nome);
        cadastro2.setCpf(cpf);
        cadastro2.setDataNascimento(dataNascimento);
        cadastro2.setSexo(sexo);
        cadastro2.setEmail(email);
        cadastro2.setEndereco(endereco2);
        cadastro2.setContato(contato2);
        cadastro2.setAtividadeProfissional(aP);

        return cadastro2;
    }


    private static AtividadeProfissional getAtividadeProfissional(List<String> habilidades, Double pretensaoMinima,
                                                                  Double pretensaoMaxima, boolean empregoAtual,
                                                                  Double salario, String empresa, String profissao) {

        AtividadeProfissional aP2 = new AtividadeProfissional();
        aP2.setHabilidades(habilidades);
        aP2.setPretensaoMinima(pretensaoMinima);
        aP2.setPretensaoMaxima(pretensaoMaxima);
        aP2.setEmpregoAtual(empregoAtual);
        aP2.setSalario(salario);
        aP2.setEmpresa(empresa);
        aP2.setProfissao(profissao);

        return aP2;
    }

    private static Contato getContato(Long telefone, String celular, boolean celularWhats) {

        Contato contato2 = new Contato();
        contato2.setTelefone(telefone);
        contato2.setCelular(celular);
        contato2.setCelularWhats(celularWhats);

        return contato2;
    }

    private static Endereco getEndereco(String logradouro, Integer numero, String bairro, String complemento,
                                        String cidade, String estado) {

        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro(logradouro);
        endereco2.setNumero(numero);
        endereco2.setBairro(bairro);
        endereco2.setComplemento(complemento);
        endereco2.setCidade(cidade);
        endereco2.setEstado(estado);
        return endereco2;
    }

    public static Cadastro popularCadastro0() {

        Cadastro cadastro0 = criarCadastro("Pedro", "444.444.444-31", LocalDate.parse("1998-11-04"),
                Sexo.MASCULINO, "pedro@gmail.com", "Rua Exemplo", 123, "Bairro Teste",
                "Complemento 1", "Cidade A", "Estado B", "Programador Java + Angular",
                "MJV", 1803.15, true, 1800.324, 2200.00,
                Arrays.asList("Java", "SpringBoot", "PostgreSQL"), 9911999999999L, "9911993399944",
                true);

        return cadastro0;
    }

    public static Cadastro popularCadastro1() {

        Cadastro cadastro1 = criarCadastro("Teste", "111.444.444-31", LocalDate.parse("1988-11-04"),
                Sexo.OUTRO, "aqui@gmail.com", "Rua Exemploss", 11, "Bairro aqui Teste",
                "Complemento teste1", "Cidade teste", "Estado teste", "Testador",
                "Empresa teste", 1000.100, false, 500.00, 1000.50,
                Arrays.asList("teste1", "Teste2"), 9111111111L, "(55) 99 999999999",
                true);

        return cadastro1;
    }
}
