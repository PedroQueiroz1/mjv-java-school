import model.*;
import utils.CadastroUtil;
import utils.JavaNIO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TerminalNIO {

    public static void main(String[] args){

        Cadastro cadastro0 = CadastroUtil.popularCadastro0();
        Cadastro cadastro1 = CadastroUtil.popularCadastro1();
        Cadastro cadastro2 = CadastroUtil.criarCadastro2();

        List<Cadastro> cadastroLista = new ArrayList<>();

        cadastroLista.add(cadastro0);
        cadastroLista.add(cadastro1);
        cadastroLista.add(cadastro2);

        try {
            JavaNIO.criarArquivoCSV();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JavaNIO.inserirDadosArquivoCSV(cadastroLista);
        System.out.println(JavaNIO.imprimirLeituraArquivoCSV());

    }

}