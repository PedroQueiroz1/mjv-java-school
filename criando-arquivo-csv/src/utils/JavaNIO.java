package utils;

import model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/*
    Cria arquivo CSV
    Utiliza java nio
    Possui método de ler e o método de escrever, no arquivo csv.
 */
public class JavaNIO {

    public static void criarArquivoCSV() throws IOException {

        Path path = Paths.get(
                "C:\\Users\\pedro\\Desktop\\ProjetosJava\\MJV\\mjvschool\\mjv-java-school\\criando-arquivo-csv\\aula-java-nio"
                        + ExtensaoArquivo.CSV);

        path.toFile().createNewFile();

        // ?
        // Lendo o path e convertendo todos os caracteres (bytes) de uma só vez
        byte[] bytesArquivo = Files.readAllBytes(path);

        String conteudo = new String(bytesArquivo);
        System.out.println(conteudo);

        Path pathTo = Paths.get(
                "C:\\Users\\pedro\\Desktop\\ProjetosJava\\MJV\\mjvschool\\mjv-java-school\\criando-arquivo-csv\\aula-java-nio-copy"
                        + ExtensaoArquivo.CSV);
        Files.write(pathTo, bytesArquivo);

        System.out.println("Planilha criada! \n");
    }

    public static StringBuilder escreverCabecalho(){

        StringBuilder cabecalho = new StringBuilder();

        cabecalho.append("Nome;");
        cabecalho.append("CPF;");
        cabecalho.append("Logradouro;");
        cabecalho.append("Estado;");
        cabecalho.append("Cidade;");
        cabecalho.append("Bairro;");
        cabecalho.append("Número;");
        cabecalho.append("Complemento;");
        cabecalho.append("Data de Nascimento;");
        cabecalho.append("E-mail;");
        cabecalho.append("Sexo;");
        cabecalho.append("Telefone;");
        cabecalho.append("Celular;");
        cabecalho.append("Celular com WhatsApp;");
        cabecalho.append("Profissão;");
        cabecalho.append("Empresa;");
        cabecalho.append("Salário;");
        cabecalho.append("Pretensão Mínima;");
        cabecalho.append("Pretensão Máxima;");
        cabecalho.append("Emprego Atual;");
        cabecalho.append("Habilidades;");
        cabecalho.append(System.lineSeparator());

        return cabecalho;
    }

    public static void inserirDadosArquivoCSV(List<Cadastro> cadastros) {

        try {
            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            StringBuilder conteudo = new StringBuilder();

            for (Cadastro cadastro : cadastros) {
                conteudo.append(cadastro.getNome() + ";");
                conteudo.append(cadastro.getCpf() + ";");
                conteudo.append(cadastro.getEndereco().getLogradouro() + ";");
                conteudo.append(cadastro.getEndereco().getEstado() + ";");
                conteudo.append(cadastro.getEndereco().getCidade() + ";");
                conteudo.append(cadastro.getEndereco().getBairro() + ";");
                conteudo.append(cadastro.getEndereco().getNumero() + ";");
                conteudo.append(cadastro.getEndereco().getComplemento() + ";");
                conteudo.append(cadastro.getDataNascimento().format(formatarData) + ";");
                conteudo.append(cadastro.getEmail() + ";");
                conteudo.append(cadastro.getSexo() + ";");
                conteudo.append(cadastro.getContato().getTelefone() + ";");
                conteudo.append(cadastro.getContato().getCelular() + ";");
                conteudo.append(cadastro.getContato().isCelularWhats() + ";");
                conteudo.append(cadastro.getAtividadeProfissional().getProfissao() + ";");
                conteudo.append(cadastro.getAtividadeProfissional().getEmpresa() + ";");

                conteudo.append("R$").append(decimalFormat.format(cadastro
                        .getAtividadeProfissional().getSalario())
                        .replace(",", ".")).append(";");
                conteudo.append("R$").append(decimalFormat.format(cadastro
                        .getAtividadeProfissional().getPretensaoMinima())
                        .replace(",", ".")).append(";");
                conteudo.append("R$").append(decimalFormat.format(cadastro
                        .getAtividadeProfissional().getPretensaoMaxima())
                        .replace(",", ".")).append(";");

                conteudo.append(cadastro.getAtividadeProfissional().isEmpregoAtual() + ";");
                conteudo.append(cadastro.getAtividadeProfissional().getHabilidades() + ";");
                conteudo.append(System.lineSeparator());
            }

            StringBuilder cabecalhoConteudo = new StringBuilder();
            cabecalhoConteudo.append(escreverCabecalho().toString());
            cabecalhoConteudo.append(conteudo.toString());

            Path arquivoDestino = Paths.get(
                    "C:\\Users\\pedro\\Desktop\\ProjetosJava\\MJV\\mjvschool\\mjv-java-school\\criando-arquivo-csv\\aula-java-nio"
                            + ExtensaoArquivo.CSV);

            Files.write(arquivoDestino, cabecalhoConteudo.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static String imprimirLeituraArquivoCSV() {

        StringBuilder sb = new StringBuilder();

        try {
            Path arquivoOrigem = Paths.get(
                    "C:\\Users\\pedro\\Desktop\\ProjetosJava\\MJV\\mjvschool\\mjv-java-school\\criando-arquivo-csv\\aula-java-nio"
                            + ExtensaoArquivo.CSV);

            List<String> linhas = Files.readAllLines(arquivoOrigem);

            DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DecimalFormat decimalFormat = new DecimalFormat("#0.00");

            for (int i = 1; i < linhas.size(); i++) {

                String linha = linhas.get(i);
                String[] colunas = linha.split("\\;");

                String nome = colunas[0];
                String cpf = colunas[1];
                String logradouro = colunas[2];
                String estado = colunas[3];
                String cidade = colunas[4];
                String bairro = colunas[5];
                Integer numero = Integer.valueOf(colunas[6]);
                String complemento = colunas[7];
                LocalDate dataNascimento = LocalDate.parse(colunas[8], formatarData);
                String email = colunas[9];
                Sexo sexo = Sexo.valueOf(colunas[10]);
                Long telefone = Long.valueOf(colunas[11]);
                String celular = colunas[12];
                boolean celularWhats = Boolean.valueOf(colunas[13]);
                String profissao = colunas[14];
                String empresa = colunas[15];

                Double salario = Double.valueOf(colunas[16].replace("R$", "").replace(",", "."));
                Double pretensaoMinima = Double.valueOf(colunas[17].replace("R$", "").replace(",", "."));
                Double pretensaoMaxima = Double.valueOf(colunas[18].replace("R$", "").replace(",", "."));

                boolean empregoAtual = Boolean.valueOf(colunas[19]);
                List<String> habilidades = Arrays.asList(colunas[20]);

                String salarioFormatado = decimalFormat.format(salario);
                String pretensaoMinimaFormatada = decimalFormat.format(pretensaoMinima);
                String pretensaoMaximaFormatada = decimalFormat.format(pretensaoMaxima);

                System.out.println(
                CadastroBuilder.construirStringBuilderNIO(nome, cpf, logradouro, estado, cidade, bairro, numero, complemento,
                        dataNascimento, email, sexo, telefone, celular, celularWhats, profissao, empresa,
                        salarioFormatado, pretensaoMinimaFormatada, pretensaoMaximaFormatada, empregoAtual, habilidades));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}

