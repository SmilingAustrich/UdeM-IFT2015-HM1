package ift2015_a25_tp1;

public class Q4 {

    public static Stack names = new Stack(10); // pile pour stocker les noms

    /**
     * Retire la personne au milieu ⌈N/2⌉ de la liste et push son nom dans la pile
     * @param head tête de la liste
     * @return nouvelle tête de la liste
     */
    public static Node rm_mid(Node head) {
        if (head == null) {
            names.push("???"); // okk si la liste est vide, push "???"
            return null;
        }

        int len = head.length_iter(); // longueur de la liste
        int midIndex = (len + 1) / 2; // ⌈N/2⌉

        if (midIndex == 1) { // okk on doit retirer la tête
            names.push(head.value);
            return head.next;
        }

        Node current = head;
        for (int i = 1; i < midIndex - 1; i++) {
            current = current.next; // on descend jusqu'au noeud avant le milieu
        }

        if (current.next != null) {
            names.push(current.next.value); // push le nom dans la pile
            current.next = current.next.next; // okk on skip le noeud
        } else {
            names.push("???");
        }

        return head;
    }

    /**
     * Retire le k-ième élément à partir de la fin (itératif)
     */
    public static Node rm_k_end_iter(Node head, int k) {
        if (head == null) {
            names.push("???");
            return null;
        }

        int len = head.length_iter();
        int target = len - k + 1; // index depuis le début

        if (target <= 0) {
            names.push("???");
            return head;
        }

        if (target == 1) { // retirer la tête
            names.push(head.value);
            return head.next;
        }

        Node current = head;
        for (int i = 1; i < target - 1; i++) {
            current = current.next;
        }

        if (current.next != null) {
            names.push(current.next.value);
            current.next = current.next.next;
        } else {
            names.push("???");
        }

        return head;
    }

    /**
     * Helper récursif pour retirer le k-ième élément depuis la fin
     * @param head tête de la liste
     * @param k position depuis la fin
     * @param count compteur utilisé pour suivre la position
     * @return nouvelle tête partielle
     */
    private static Node rm_k_end_rec_helper(Node head, int k, int[] count) {
        if (head == null) {
            count[0] = 0;
            return null;
        }

        head.next = rm_k_end_rec_helper(head.next, k, count); // okk on descend récursivement
        count[0]++; // compteur qui remonte

        if (count[0] == k) { // okk si on est à la position
            names.push(head.value);
            return head.next; // skip le noeud
        }

        return head;
    }

    /**
     * Retire le k-ième élément depuis la fin (récursif) et push dans la pile
     * @param head tête de la liste
     * @param k position depuis la fin
     * @return nouvelle tête de la liste
     */
    public static Node rm_k_end_rec(Node head, int k) {
        int[] count = new int[1];
        Node newHead = rm_k_end_rec_helper(head, k, count);

        if (count[0] < k) { // okk si k trop grand
            names.push("???");
            return head;
        }

        return newHead;
    }

    /**
     * Retire la personne après la k-ième position (depuis le début) et push dans la pile
     * @param head tête de la liste
     * @param k position après laquelle retirer
     * @return nouvelle tête de la liste
     */
    public static Node rm_after_k(Node head, int k) {
        if (head == null) {
            names.push("???");
            return null;
        }

        Node current = head;
        for (int i = 1; i < k; i++) { // on descend jusqu'au k-ième
            if (current.next != null) {
                current = current.next;
            } else {
                names.push("???");
                return head;
            }
        }

        if (current.next != null) {
            names.push(current.next.value);
            current.next = current.next.next; // skip
        } else {
            names.push("???");
        }

        return head;
    }

//some tests
public static void main(String[] args) {
        // Create a list
        Node head = new Node("Alice");
        head.add_iter("Bob");
        head.add_iter("Claude");
        head.add_iter("Duke");
        head.add_iter("Elaine");
        
        Node.print_list(head);
        System.out.println();

        // 1. Remove middle person
        System.out.println("---Remove middle person---");
        head = rm_mid(head);
        Node.print_list(head);
        names.print_stack();
        System.out.println();
        
        // 2. Remove kth from end (iterative)
        System.out.println("---Remove 4th person from end---");
        head = rm_k_end_iter(head, 4);
        Node.print_list(head);
        names.print_stack();
        System.out.println();

        // 3. Remove kth from end (recursive)
        System.out.println("---Remove 4nd person from end---");
        head = rm_k_end_rec(head, 4);
        Node.print_list(head);
        names.print_stack();
        System.out.println();

        // 4. Remove the person after k 
        System.out.println("---Remove person after the first---");
        head = rm_after_k(head, 1);
        Node.print_list(head);
        names.print_stack();
        System.out.println();


    }

}
