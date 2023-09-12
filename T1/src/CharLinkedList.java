class Node {
    char data;
    Node next;

    public Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class CharLinkedList {
    private Node head;
    private int size;

    public CharLinkedList() {
        head = null;
        size = 0;
    }

    public void add(char data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public char get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fora dos limites da lista.");
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void removeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fora dos limites da lista.");
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node previous = head;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.next;
            }
            previous.next = previous.next.next;
        }

        size--;
    }


    public boolean areAllElementsEqual() {
        if (size <= 1) {
            return true;
        }

        char firstElement = head.data;

        for (Node current = head.next; current != null; current = current.next) {
            if (current.data != firstElement) {
                return false; // Se encontrar um elemento diferente, retorna falso
            }
        }

        return true; // Todos os elementos são iguais
    }

    public int size() {
        return size;
    }

}
