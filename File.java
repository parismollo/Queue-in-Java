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

    public File(int taille) {
        this.taille = taille;
        this.head = this.queue = 0;
        this.file = new int[taille];
    }

    public static void main(String[] args) {
        File f = new File(1);
        f.put(1);
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

    private void displayFailedMessage(String string) {
        String colorRed = "\u001B[31m";
        String resetColor = "\u001B[0m";
        System.out.println(colorRed+"[LOG]: "+string+resetColor);
    }

    public void setNewQueue(int x) {
        this.file[this.queue] = x;
        this.queue++;
    }

    public boolean isFull() {
        return (this.queue == this.taille) ? true : false; // Bug:  == capacity -1? 
    }
}