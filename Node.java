package ift2015_a25_tp1;

public class Node {
	String value; // data of the node
	Node next; // pointer to the next node

	/**
	 * Constructeur : crée un noeud avec une valeur, next = null
	 */
	public Node(String s) {
		this.value = s;
		this.next = null;
	}

	/**
	 * Constructeur : crée un noeud avec une valeur et un lien vers le noeud suivant
	 */
	public Node(String s, Node next) {
		this.value = s;
		this.next = next;
	}

	/**
	 * Ajoute un élément à la fin de la liste de manière itérative
	 */
	public void add_iter(String s) {
		Node current = this;
		// Parcours jusqu'au dernier noeud
		while (current.next != null) {
			current = current.next;
		}
		// Ajout du nouveau noeud à la fin
		current.next = new Node(s);
	}

	/**
	 * Ajoute un élément à la fin de la liste de manière récursive
	 */
	public void add_rec(String s) {
		if (this.next == null) {
			this.next = new Node(s); // si c'est le dernier, on ajoute
		} else {
			this.next.add_rec(s); // sinon on continue récursivement
		}
	}

	/**
	 * Retourne la longueur de la liste de manière itérative
	 */
	public int length_iter() {
		int count = 0;
		Node current = this;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	/**
	 * Retourne la longueur de la liste de manière récursive
	 */
	public int length_rec() {
		if (this == null) {
			return 0; // sécurité, mais normalement jamais utilisé sur null
		}
		if (this.next == null) {
			return 1; // dernier noeud
		}
		return 1 + this.next.length_rec(); // 1 + longueur du reste
	}

	// Print entire list
    public static void print_list(Node n) {
        System.out.print("List: ");
        while (n != null) {
            System.out.print(n.value + "->");
            n = n.next;
        }
        System.out.println();
    }
    
	// some tests
	public static void main(String[] args) {
        // Create the head node
        Node head = new Node("A");
        
        // Add elements using iterative method
        head.add_iter("B");
        
        // Add elements using recursive method
        head.add_rec("C");
        
        // Print list elements
        print_list(head);
        
        // Test length methods
        System.out.println("Length (iterative): " + head.length_iter());
        System.out.println("Length (recursive): " + head.length_rec());
    }
}
