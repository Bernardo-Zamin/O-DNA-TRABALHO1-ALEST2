public class Characters {
    //organizando codigo
    public Characters() {

    }

    public char letraNoFim(char n1, char n2) {
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

    public boolean precisaMudar(char n1, char n2) {
        if ((n1 == 'D' && n2 == 'N') || (n1 == 'N' && n2 == 'D') ||
                (n1 == 'D' && n2 == 'A') || (n1 == 'A' && n2 == 'D') ||
                (n1 == 'A' && n2 == 'N') || (n1 == 'N' && n2 == 'A')) {
            return true;
        }
        return false;
    }

}