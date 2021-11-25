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
    private int head;
    private int queue;
    private int taille;
    private int[] file;
    
    public int getHead() {
        return head;
    }
    public int getTaille() {
        return taille;
    }
    public void setTaille(int taille) {
        this.taille = taille;
    }
    public int getQueue() {
        return queue;
    }
    public void setQueue(int queue) {
        this.queue = queue;
    }
    public void setHead(int head) {
        this.head = head;
    }
}