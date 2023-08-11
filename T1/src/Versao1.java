import java.util.*;

public class Versao1 {
    public static void main(String[] args) throws Exception {
        // Create by Benjamin Mattar
        LinkedList<Character> lista = new LinkedList<>();
        String dna = "DANA";
        boolean achaDif;
        for (int i = 0; i < dna.length(); i++) {
            lista.add(dna.charAt(i));
        }
        System.out.println(lista);
        System.out.println("----------------------------");

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