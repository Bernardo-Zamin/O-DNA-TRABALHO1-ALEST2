import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;

public class Versao1 {
    public static void main(String[] args) throws Exception {
        LinkedList<Character> lista;
        LinkedList<String> listaDna = new LinkedList<>();

        // String dna = "DANA";

        boolean achaDif;

        // for (int i = 0; i < dna.length(); i++) {
        // lista.add(dna.charAt(i));
        // }
        // System.out.println(lista);

        System.out.println("----------------------------");

        Path path = Paths.get("teste.txt");
        String aux[];

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_16)) {
            String linha = reader.readLine();
            while (linha != null) {
                aux = linha.split("\n");
                listaDna.add(linha);
                linha = reader.readLine();

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Lista de DNAS: " + listaDna);
        System.out.println();

        String[] dnas = new String[listaDna.size()];

        for (int i = 0; i < dnas.length; i++) {
            dnas[i] = listaDna.get(i);
            lista = new LinkedList<>();

            for (int j = 0; j < dnas[i].length(); j++) {
                lista.add(dnas[i].charAt(j));
            }

            System.out.println("===============================");
            System.out.println("DNA[" + i + "]: " + dnas[i]);
            System.out.println("===============================");

            do {
                achaDif = false;
                for (int l = 0; l < lista.size() - 1; l++) {
                    int k = l + 1;
                    if (precisaMudar(lista.get(l), lista.get(k))) {
                        char novo = letraNoFim(lista.get(l), lista.get(k));
                        lista.remove(l);
                        lista.remove(l);
                        lista.add(l, novo);
                        achaDif = true;
                        System.out.println(lista);
                        System.out.println("---------------");
                        break; // se precisar mudar os characteres ele volta pro inicio
                    }

                    // System.out.println(lista);
                    // System.out.println("---------------");

                }
            } while (achaDif);

            System.out.println(lista);

        }

    }

    public static char letraNoFim(char n1, char n2) {
        if (n1 != 'D' && n2 != 'D') {
            return 'D';
        }
        if (n1 != 'N' && n2 != 'N') {
            return 'N';
        }
        if (n1 != 'A' && n2 != 'A') {
            return 'A';
        }
        return ' ';
    }

    public static boolean precisaMudar(char n1, char n2) {
        if ((n1 == 'D' && n2 == 'N') || (n1 == 'N' && n2 == 'D') ||
                (n1 == 'D' && n2 == 'A') || (n1 == 'A' && n2 == 'D') ||
                (n1 == 'A' && n2 == 'N') || (n1 == 'N' && n2 == 'A')) {
            return true;
        }
        return false;
    }
}