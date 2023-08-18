import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class LeituraArquivo {

    private LinkedList<String> dnas;
    private String nArq;

    public LeituraArquivo(String nomeArquivo) {
        dnas = new LinkedList<>();
        this.nArq = nomeArquivo;

    }

    // Método base foi fornecido por Bernardo Copstein para realizar trabalho de
    // Fundamentos de Desenvolvimento de Software:
    // https://github.com/TP-BCopsteinAssignments/ExercicioPrimeirosPadroes/blob/main/src/Consultas.java
    // O método foi adaptado para uma classe de leitura de arquivo:
    // https://github.com/Bernardo-Zamin/T1-Fundamentos-de-D.-de-Software/blob/main/src/LeArquivo.java
    // Método também adaptado para classe e projeto atual
    // Ajuda na organização do código

    public LinkedList<String> carregaDados() {
        String currDir = Paths.get("").toAbsolutePath().toString();
        // Monta o nome do arquivo
        String nomeCompleto = currDir + "/" + nArq;
        System.out.println(nomeCompleto);
        // Cria acesso ao "diretorio" da mídia (disco)
        Path path = Paths.get(nomeCompleto);

        String linha = "";
        String[] aux;

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_16)) {
            linha = reader.readLine();
            while (linha != null) {
                aux = linha.split("\n");
                dnas.add(linha);
                linha = reader.readLine();

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dnas;
    }
}