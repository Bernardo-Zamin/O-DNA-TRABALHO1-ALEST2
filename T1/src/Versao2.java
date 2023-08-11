public class Versao2 {
    public static void main(String[] args) throws Exception {
        
        String dna = "DANNDANDANDANADNDDDAN";

        StringBuilder sb = new StringBuilder(dna);

        System.out.println("O dna antes do algoritmo: " + sb.toString());
        System.out.println();

        int index = 0; // posicao 0 da string

        while (index < sb.length() - 1) {
            char caracterAtual = sb.charAt(index);
            char proximoCaracter = sb.charAt(index + 1);
            int inicio = 0;
            int fim = 1;

            if (caracterAtual != proximoCaracter) {
                if (caracterAtual == 'D' && proximoCaracter == 'A' || caracterAtual == 'A' && proximoCaracter == 'D') {
                    sb.delete(inicio, fim);
                    inicio += 1;
                    fim += 1;
                    sb.insert(sb.length() - 1, 'N');
                }
                if (caracterAtual == 'N' && proximoCaracter == 'D' || caracterAtual == 'D' && proximoCaracter == 'N') {
                    sb.delete(inicio, fim);
                    inicio += 1;
                    fim += 1;
                    sb.insert(sb.length() - 1, 'A');
                }
                if (caracterAtual == 'N' && proximoCaracter == 'A' || caracterAtual == 'A' && proximoCaracter == 'N') {
                    sb.delete(inicio, fim);
                    inicio += 1;
                    fim += 1;
                    sb.insert(sb.length() - 1, 'D');
                }
            } else {
                index += 2;

            }

        }

        String dnaFinal = sb.toString();

        System.out.println(dnaFinal);

    }
}
