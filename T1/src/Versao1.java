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
        LinkedList<Character> lista = new LinkedList<>();
        LinkedList<String> listaStrg = new LinkedList<>();
        // String dna = "DANA";
        boolean achaDif;
        // for (int i = 0; i < dna.length(); i++) {
        // lista.add(dna.charAt(i));
        // }
        // System.out.println(lista);
        System.out.println("----------------------------");

        Path path = Paths.get("teste.txt");
        String aux[];

        try (BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                listaStrg.add(linha);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String[] linesArray = listaStrg.toArray(new String[0]);
       
        char[] charArray = new char[linesArray.length];
        
        for (int i = 0; i < linesArray.length; i++) {
            charArray[i] = linesArray[0].charAt(2);
        }
        
        for (int i = 0; i < charArray.length; i++) {
            lista.add(charArray[i]);
        }


        do {
            achaDif = false;
            for (int i = 0; i < lista.size() - 1; i++) {
                int j = i + 1;
                if (precisaMudar(lista.get(i), lista.get(j))) {
                    char novo = letraNoFim(lista.get(i), lista.get(j));
                    lista.remove(i);
                    lista.remove(i);
                    lista.add(i, novo);
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