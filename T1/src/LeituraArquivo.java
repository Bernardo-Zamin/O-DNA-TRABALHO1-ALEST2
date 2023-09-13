import java.io.BufferedReader;
import java.io.FileReader;

public class LeituraArquivo {
    private String nArq;

    public LeituraArquivo(String nomeArquivo) {
        this.nArq = nomeArquivo;

    }

    public String carregaDados() {

        String linha = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(nArq))) {

            linha = reader.readLine();

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        return linha;
    }
}