import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Character> lista = new ArrayList<>();
        Characters chars = new Characters();
        LeituraArquivo leArq = new LeituraArquivo("caso100k.txt");

        String str = leArq.carregaDados();

        for (int i = 0; i < str.length(); i++) {
            lista.add(str.charAt(i));
        }

        System.out.println("\n=========================================================");
        System.out.println("            TAMANHO INICIAL: " + lista.size() + "               ");
        System.out.println("=========================================================\n");

        int i;
        int j;
        char novo;

        long inicio = System.currentTimeMillis();

        for (i = 0; i < lista.size() - 1; i++) {

            j = i + 1;

            if (chars.precisaMudar(lista.get(i), lista.get(j))) {

                novo = chars.letraNoFim(lista.get(i), lista.get(j));
                lista.remove(i);
                lista.remove(i);
                lista.add(novo);

                i =-1;
                j = 0;

            }

        }

        long fim = System.currentTimeMillis();
        long segundos = (fim - inicio) / 1000;
        System.out.println("TAMANHO FINAL: " + lista.size() + "\n" + segundos + " SEGUNDOS");
        System.out.println(lista);

    }

}
