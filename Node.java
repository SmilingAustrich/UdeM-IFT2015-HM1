package ift2015_a25_tp1;

public class Node {
	String value; // data of the node
	Node next; // pointer to the next node

	/**
	 * Constructeur : crée un noeud avec une valeur, next = null.
	 * Okk ici on crée juste un nouveau nœud de base, sans le relier à rien pour l’instant.
	 * @param s la valeur à stocker dans le noeud
	 */
	public Node(String s) {
		this.value = s;
		this.next = null;
	}

	/**
	 * Second constructeur : crée un noeud avec une valeur et un lien vers le noeud suivant.
	 * @param s la valeur à stocker
	 * @param next le nœud suivant dans la liste
	 */
	public Node(String s, Node next) {
		this.value = s;
		this.next = next;
	}

	/**
	 * Ajoute un élément à la fin de la liste de manière itérative.
	 * ici on parcourt la liste avec un while jusqu’à trouver le dernier noeud (celui dont next == null),
	 * pis on ajoute le nouveau noeud à la fin.
	 * @param s la valeur du nouveau nœud à ajouter
	 */
	public void add_iter(String s) {
		Node current = this;
		while (current.next != null) { // tant qu’il y a un prochain
			current = current.next;
		}
		current.next = new Node(s); // et là on ajoute à la fin
	}

	/**
	 * Ajoute un élément à la fin de la liste de manière récursive.
	 * Ici pas de boucle, on laisse la récursion descendre jusqu’au dernier nœud.
	 * Si le noeud actuel n’a pas de next, on ajoute directement. Sinon on rappelle la méthode sur le suivant.
	 * @param s la valeur du nouveau nœud à ajouter
	 */
	public void add_rec(String s) {
		if (this.next == null) {
			this.next = new Node(s);
		} else {
			this.next.add_rec(s);
		}
	}

	/**
	 * Rtourne la longueur de la liste de manière itérative.
	 * Okk on compte chaque noeud un par un avec une boucle while.
	 * @return la longueur totale de la liste
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
	 * Retourne la longueur de la liste de manière récursive.
	 * C’est le même principe, mais sans boucle : chaque appel ajoute +1 jusqu’à atteindre la fin.
	 * @return la longueur totale de la liste
	 */
	public int length_rec() {
		if (this.next == null) {
			return 1; // okk si on est rendu au dernier noeud
		}
		return 1 + this.next.length_rec();
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
