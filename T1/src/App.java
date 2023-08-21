import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<Character> lista;
        LinkedList<String> listaDna = new LinkedList<>();
        Characters chars = new Characters();
        LeituraArquivo leArq = new LeituraArquivo("teste.txt");

        boolean achaDif;

        System.out.println("----------------------------\n");

        listaDna = leArq.carregaDados();

        System.out.println("Lista de DNAS: " + listaDna);
        System.out.println();

        String[] dnas = new String[listaDna.size()];

        for (int i = 0; i < dnas.length; i++) {
            dnas[i] = listaDna.get(i);
            lista = new LinkedList<>();

            for (int j = 0; j < dnas[i].length(); j++) {
                lista.add(dnas[i].charAt(j));
            }

            System.out.println("\n=========================================================");
            System.out.println("            DNA[" + i + "]: " + dnas[i]);
            System.out.println("            TAMANHO INICIAL: "+ lista.size()+"               ");
            System.out.println("=========================================================\n");

            do {
                achaDif = false;
                for (int l = 0; l < lista.size() - 1; l++) {
                    int k = l + 1;
                    if (chars.precisaMudar(lista.get(l), lista.get(k))) {
                        char novo = chars.letraNoFim(lista.get(l), lista.get(k));
                        lista.remove(l);
                        lista.remove(l);
                        lista.addLast(novo);

                        achaDif = true;
                        System.out.println(lista);
                        System.out.println("---------------");
                        break; // se precisar mudar os characteres ele volta pro inicio
                    }

                }
            } while (achaDif);
            System.out.println("TAMANHO FINAL: "+ lista.size());
        }

    }

}
