import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Character> lista = new ArrayList<>();
        Characters chars = new Characters();
        LeituraArquivo leArq = new LeituraArquivo("caso10k.txt");



        String listaDna = leArq.carregaDados();

        for (int j = 0; j < listaDna.length(); j++) {
            lista.add(listaDna.charAt(j));
        }

        System.out.println("\n=========================================================");
        System.out.println("            TAMANHO INICIAL: " + lista.size() + "               ");
        System.out.println("=========================================================\n");

        int l = 0;
        int k = l + 1;
        char novo;
        
        

        for (l = 0; l < lista.size() - 1; l++) {
            k = l + 1;
            if (chars.precisaMudar(lista.get(l), lista.get(k))) {
                novo = chars.letraNoFim(lista.get(l), lista.get(k));
                lista.remove(l);
                lista.remove(l);
                lista.add(novo);

                l = -1;
                k = 0;

            }

        }

        System.out.println("TAMANHO FINAL: " + lista.size());
        System.out.println(lista);

    }

}
