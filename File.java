/* 
1) Dans la file, l'insertion et la suppression se
produisent aux extrémités opposées.

2) Créez un tableau arr de taille n et prenez deux variables avant et arrière qui
seront toutes deux initialisées à 0 ce qui signifie que la file d'attente est actuellement vide.

3) L'élément arrière est 
l'index jusqu'auquel les éléments sont stockés dans le tableau et front est l'index 
du premier élément du tableau.

*/

class File {
    private int head; // pos du premier element dans la file
    private int queue; // pos du dernier element dans la file 
    private int taille; // taile max de la file
    private int[] file; // la file en forme de tableau

    private static String greenColor = "\u001B[32m";
    private static String redColor = "\u001B[31m";
    private static String resetColor = "\u001B[0m";
    private static String yellowColor = "\u001B[33m";

    public File(int taille) {
        this.taille = taille;
        this.head = this.queue = 0;
        this.file = new int[taille];
    }

    public static void main(String[] args) {
        File f = new File(4);
        f.put(1);
        f.display();
        f.put(4);
        f.display();
        f.put(2);
        f.display();
    }

    public void put(int x) {
       /*
        1. Est-ce que la file est rempli?
        2. Sinon, ajouter x dans la queue.
       */
       if (!this.isFull()) {
           setNewQueue(x);
       } else {
           displayFailedMessage("Put operation failed... :(");
       }
    }

    public boolean empty() {
        return (this.head == this.queue) ? true : false;
    }

    public void display() {
        if (this.empty()) {
            displayWarningMessage("This queue is empty... :(");
        } else {
            for(int i = this.head; i<this.queue; i++) {
                if (i == this.head) {
                    System.out.print(greenColor+"HEAD "+resetColor);
                }
                System.out.print(this.file[i]+" ");
            }
            System.out.print(redColor+"QUEUE"+resetColor);
        }
        System.out.println();
    }

    private void displayWarningMessage(String string) {
        System.out.println(yellowColor+string+resetColor);
    }

    private void displayFailedMessage(String string) {
        System.out.println(redColor+"[LOG]: "+string+resetColor);
    }

    public void setNewQueue(int x) {
        this.file[this.queue] = x;
        this.queue++;
    }

    public boolean isFull() {
        return (this.queue == this.taille) ? true : false; // Bug:  == capacity -1? 
    }
}