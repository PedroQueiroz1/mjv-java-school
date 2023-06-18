package utils;

import model.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ApachePOI {

    public static void  imprimirLeituraArquivoXLS() throws IOException {

        FileInputStream entrada = new FileInputStream(new File(
                "C:\\Users\\pedro\\Desktop\\ProjetosJava\\MJV\\mjvschool\\mjv-java-school\\criando-arquivo-csv\\aula-java-apachePOI"
                        + ExtensaoArquivo.XLS));

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); // prepara a entrada do arquivo excel para ler
        HSSFSheet planilha = hssfWorkbook.getSheetAt(0); // pega a primeira planilha do arquivo excel

        DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Iterator<Row> linhaIterator = planilha.iterator();

        List<Cadastro> cadastros = new ArrayList<>();

        while (linhaIterator.hasNext()) { // Enquanto tiver linha no excel
            Row linha = linhaIterator.next();

            Iterator<Cell> celula = linha.iterator();

            Cadastro cadastro = new Cadastro();
            Endereco endereco = new Endereco();
            AtividadeProfissional aP = new AtividadeProfissional();
            Contato contato = new Contato();

            while(celula.hasNext()) {
                Cell cell = celula.next();

                switch (cell.getColumnIndex()) {

                    case 0:
                        cadastro.setNome(cell.getStringCellValue());
                        break;

                    case 1:
                        cadastro.setCpf(cell.getStringCellValue());
                        break;

                    case 2:
                        cadastro.setDataNascimento(LocalDate.parse(cell.getStringCellValue(), formatarData));
                        break;

                    case 3:
                        cadastro.setSexo(Sexo.valueOf(cell.getStringCellValue()));
                        break;

                    case 4:
                        cadastro.setEmail(cell.getStringCellValue());
                        break;

                    case 5:
                        endereco.setLogradouro(cell.getStringCellValue());
                        break;

                    case 6:
                        endereco.setNumero(((int) cell.getNumericCellValue()));
                        break;

                    case 7:
                        endereco.setBairro(cell.getStringCellValue());
                        break;

                    case 8:
                        endereco.setComplemento(cell.getStringCellValue());
                        break;

                    case 9:
                        endereco.setCidade(cell.getStringCellValue());
                        break;

                    case 10:
                        endereco.setEstado(cell.getStringCellValue());
                        break;

                    case 11:
                        contato.setTelefone((long) cell.getNumericCellValue());
                        break;

                    case 12:
                        contato.setCelular(cell.getStringCellValue());
                        break;

                    case 13:
                        contato.setCelularWhats(Boolean.parseBoolean(cell.getStringCellValue()));
                        break;

                    case 14:
                        aP.setProfissao(cell.getStringCellValue());
                        break;

                    case 15:
                        aP.setEmpresa(cell.getStringCellValue());
                        break;

                    case 16:
                        Double salario = Double.parseDouble(String.valueOf(cell.getStringCellValue()
                                .replace(",", ".")));
                        aP.setSalario(Double.valueOf(salario));
                        break;

                    case 17:
                        aP.setEmpregoAtual(Boolean.parseBoolean(cell.getStringCellValue()));
                        break;

                    case 18:
                        Double pretensaoMinima = Double.parseDouble(String.valueOf(cell.getStringCellValue())
                                .replace(",", "."));
                        aP.setPretensaoMinima(Double.valueOf(pretensaoMinima));
                        break;

                    case 19:
                        Double pretensaoMaxima = Double.parseDouble(String.valueOf(cell.getStringCellValue())
                                .replace(",","."));
                        aP.setPretensaoMaxima(Double.valueOf(pretensaoMaxima));
                        break;

                    case 20:
                        List<String> habilidades = new ArrayList<>();
                        String habilidadesCell = cell.getStringCellValue();
                        if (!habilidadesCell.isEmpty()) {
                            String[] habilidadesArray = habilidadesCell.split(",");
                            habilidades.addAll(Arrays.asList(habilidadesArray));
                        }
                        aP.setHabilidades(habilidades);
                        break;

                } // Fim das celulas da linha

            }

            cadastro.setAtividadeProfissional(aP);
            cadastro.setContato(contato);
            cadastro.setEndereco(endereco);

            cadastros.add(cadastro);
        }

        entrada.close(); // Terminou de ler o arquivo excel

        for (Cadastro c : cadastros) {
            StringBuilder sb = CadastroBuilder.construirStringBuilderPOI(
                    c.getNome(), c.getCpf(), c.getEndereco().getLogradouro(), c.getEndereco().getEstado(),
                    c.getEndereco().getCidade(), c.getEndereco().getBairro(), c.getEndereco().getNumero(),
                    c.getEndereco().getComplemento(), c.getDataNascimento(), c.getEmail(), c.getSexo(),
                    c.getContato().getTelefone(), c.getContato().getCelular(), c.getContato().isCelularWhats(),
                    c.getAtividadeProfissional().getProfissao(), c.getAtividadeProfissional().getEmpresa(),
                    c.getAtividadeProfissional().getSalario(), c.getAtividadeProfissional().getPretensaoMinima(),
                    c.getAtividadeProfissional().getPretensaoMaxima(), c.getAtividadeProfissional().isEmpregoAtual(),
                    c.getAtividadeProfissional().getHabilidades());

            System.out.println(sb.toString());
        }

    }

    public static void inserirDadosArquivoXLS(List<Cadastro> cadastros) throws IOException {

        DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        HSSFWorkbook hWB = new HSSFWorkbook();

        HSSFSheet linhasCadastro = hWB.createSheet("Planilha Apache POI - MJV");

        int numeroLinha = 0;
        for (Cadastro c : cadastros) {
            Row linha = linhasCadastro.createRow(numeroLinha ++); // Criando a linha na planilha

            int celula = 0;

            Cell celNome = linha.createCell(celula ++); // Celula 0
            celNome.setCellValue(c.getNome());

            Cell celCpf = linha.createCell(celula ++); // Celula 1
            celCpf.setCellValue(c.getCpf());

            Cell celDataNascimento = linha.createCell(celula++); // Celula 2
            celDataNascimento.setCellValue(c.getDataNascimento().format(formatarData));

            Cell celSexo = linha.createCell(celula++); // Celula 3
            celSexo.setCellValue(c.getSexo().toString());

            Cell celEmail = linha.createCell(celula++); // Celula 4
            celEmail.setCellValue(c.getEmail());

            // Preenchendo as células com os atributos do objeto Endereco
            Endereco endereco = c.getEndereco();

            Cell celLogradouro = linha.createCell(celula++); // Celula 5
            celLogradouro.setCellValue(endereco.getLogradouro());

            Cell celNumero = linha.createCell(celula++); // Celula 6
            celNumero.setCellValue(endereco.getNumero());

            Cell celBairro = linha.createCell(celula++); // Celula 7
            celBairro.setCellValue(endereco.getBairro());

            Cell celComplemento = linha.createCell(celula++); // Celula 8
            celComplemento.setCellValue(endereco.getComplemento());

            Cell celCidade = linha.createCell(celula++); // Celula 9
            celCidade.setCellValue(endereco.getCidade());

            Cell celEstado = linha.createCell(celula++); // Celula 10
            celEstado.setCellValue(endereco.getEstado());

            // Preenchendo as células com os atributos do objeto Contato
            Contato contato = c.getContato();

            Cell celTelefone = linha.createCell(celula++); // Celula 11
            celTelefone.setCellValue(contato.getTelefone());

            Cell celCelular = linha.createCell(celula++); // Celula 12
            celCelular.setCellValue(contato.getCelular());

            Cell celCelularWhats = linha.createCell(celula++); // Celula 13
            celCelularWhats.setCellValue(String.valueOf(contato.isCelularWhats()));

            // Preenchendo as células com os atributos do objeto AtividadeProfissional
            AtividadeProfissional atividadeProfissional = c.getAtividadeProfissional();

            Cell celProfissao = linha.createCell(celula++); // Celula 14
            celProfissao.setCellValue(atividadeProfissional.getProfissao());

            Cell celEmpresa = linha.createCell(celula++); // Celula 15
            celEmpresa.setCellValue(atividadeProfissional.getEmpresa());

            Cell celSalario = linha.createCell(celula++); // Celula 16
            celSalario.setCellValue(decimalFormat.format(atividadeProfissional.getSalario()));

            Cell celEmpregoAtual = linha.createCell(celula++); // Celula 17
            celEmpregoAtual.setCellValue(String.valueOf(atividadeProfissional.isEmpregoAtual()));

            Cell celPretensaoMinima = linha.createCell(celula++); // Celula 18
            celPretensaoMinima.setCellValue(decimalFormat.format(atividadeProfissional.getPretensaoMinima()));

            Cell celPretensaoMaxima = linha.createCell(celula++); // Celula 19
            celPretensaoMaxima.setCellValue(decimalFormat.format(atividadeProfissional.getPretensaoMaxima()));

            Cell celHabilidades = linha.createCell(celula++); // Celula 20
            celHabilidades.setCellValue(String.join(", ", atividadeProfissional.getHabilidades()));

        } // Termina de montar a planilha

        criarArquivoXLS(hWB);

    }

    public static void criarArquivoXLS(HSSFWorkbook hWB) throws IOException {

        File file = new File(
                "C:\\Users\\pedro\\Desktop\\ProjetosJava\\MJV\\mjvschool\\mjv-java-school\\criando-arquivo-csv\\aula-java-apachePOI"
                        + ExtensaoArquivo.XLS);

        if (!file.exists()) {
            file.createNewFile();
        }

        System.out.println("Planilha criada! \n");

        FileOutputStream saida = new FileOutputStream(file);
        hWB.write(saida); // Escreve a planilha em arquivo

        saida.flush();
        saida.close();
    }

    // Se der tempo eu termino esse método abaixo, é só um extra/teste
    public static void escreverLayoutDelimitado() throws IOException {
        File arquivo = new File(
                "C:\\Users\\pedro\\Desktop\\ProjetosJava\\MJV\\mjvschool\\mjv-java-school\\criando-arquivo-csv\\aula-java-apachePOI"
                        + ExtensaoArquivo.XLS);

        if(!arquivo.exists()) {
            arquivo.createNewFile();
        }

        FileWriter escreverNoArquivo = new FileWriter(arquivo);

        Endereco e = new Endereco();
        Contato contato = new Contato();
        AtividadeProfissional aP = new AtividadeProfissional();

        Cadastro cadastro0 = CadastroUtil.popularCadastro0();
        Cadastro cadastro1 = CadastroUtil.popularCadastro1();

        List<Cadastro> cadastros = new ArrayList<>();

        cadastros.add(cadastro0);
        cadastros.add(cadastro1);

        for(Cadastro c : cadastros) {
            escreverNoArquivo.write(c.getNome() + ";" + c.getCpf() + ";" + c.getDataNascimento() + ";"
            + c.getSexo() + ";" + c.getEmail() + ";" + e.getLogradouro() + ";" + e.getNumero() + ";" + e.getBairro()
            + e.getComplemento() + ";" + e.getCidade() + ";" + e.getEstado() + ";" + contato.getTelefone() + ";"
            + contato.getCelular() + ";" + contato.isCelularWhats() + ";" + aP.getProfissao() + ";"
            + aP.getEmpresa() + ";" + aP.getSalario() + ";" + aP.isEmpregoAtual() + ";" + aP.getPretensaoMinima()
            + ";" + aP.getPretensaoMaxima() + ";" + aP.getHabilidades());
        }

        escreverNoArquivo.flush();
        escreverNoArquivo.close();
    }
}
