package ift2015_a25_tp1;

public class Stack {
	private int maxSize;
    private String[] stackArray;
    private int top;
    /**
     * Constructeur de la pile.
     * @param size taille maximale de la pile
     *
     * Initialise le tableau et positionne top à -1 (pile vide).
     */
    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new String[maxSize];
        this.top = -1; // on part d'une pile vide
    }

    /**
     * Retourne le nombre d'éléments actuellement dans la pile.
     * @return taille actuelle (top + 1)
     *
     * Petit rappel : comme les index commencent à 0, on ajoute +1.
     */
    public int size() {
        return top + 1;
    }

    /**
     * Ajoute un élément au sommet de la pile.
     * @param s la chaîne à empiler
     * Si la pile est pleine, on affiche un message d’erreur.
     * Sinon, on incrémente top et on place l’élément à cette position.
     */
    public void push(String s) {
        if (size() == maxSize) {
            System.out.println("Impossible d'empiler : la pile est déjà pleine !");
        } else {
            this.stackArray[++top] = s;
            // ok, l'élément est maintenant au sommet de la pile
        }
    }

    /**
     * Retire et retourne l’élément au sommet de la pile.
     * @return l’élément dépilé, ou null si la pile est vide
     *
     * En gros, on "pop" le dernier élément ajouté.
     */
    public String pop() {
        if (isEmpty()) {
            System.out.println("Rien à dépiler ici — la pile est vide !");
            return null;
        } else {
            String elementPopped = stackArray[top];
            stackArray[top] = null; // on nettoie la case
            top--; // on redescend le curseur
            return elementPopped;
        }
    }

    /**
     * Retourne (sans le retirer) l’élément au sommet de la pile.
     * @return la valeur actuelle du sommet, ou null si vide
     *
     * Ça permet de “jeter un coup d’œil” sans dépiler.
     */
    public String peek() {
        if (isEmpty()) {
            System.out.println("Pas d’aperçu possible — la pile est vide !");
            return null;
        } else {
            return this.stackArray[top];
        }
    }

    /**
     * Vérifie si la pile est vide.
     * @return true si la pile ne contient aucun élément
     *
     * Méthode souvent utilisée avant un pop() ou peek().
     */
    public boolean isEmpty() {
        return this.top == -1;
    }

    // Print stack elements from top to bottom
    public void print_stack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack:");
            System.out.println("---------");
            for (int i = top; i >= 0; i--) {
                System.out.println(stackArray[i]);
                System.out.println("---------");
            }
        }
    }

    
    // some tests
    public static void main(String[] args) {
        Stack stack = new Stack(5); 

        
        stack.push("A");
        stack.push("B");
        stack.print_stack();
        
        System.out.println("Top element of the stack: " + stack.peek());

        
        stack.pop();
        stack.pop();
        stack.pop(); 

        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
