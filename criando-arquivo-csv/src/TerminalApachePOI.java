import model.Cadastro;
import utils.ApachePOI;
import utils.CadastroUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TerminalApachePOI {

    public static void main(String[] args) {

        try {
            Cadastro cadastro0 = CadastroUtil.popularCadastro0();
            Cadastro cadastro1 = CadastroUtil.popularCadastro1();

            List<Cadastro> cadastros = new ArrayList<>();

            cadastros.add(cadastro0);
            cadastros.add(cadastro1);

            ApachePOI.inserirDadosArquivoXLS(cadastros);
            ApachePOI.imprimirLeituraArquivoXLS();

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

}
