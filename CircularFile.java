public class CircularFile {

    private int taille;
    private int head; // Pos of first element
    private int queue; // Pos of last element 

    private int[] fileCirculaire;


    private static String greenColor = "\u001B[32m";
    private static String redColor = "\u001B[31m";
    private static String resetColor = "\u001B[0m";
    // private static String yellowColor = "\u001B[33m";


    public CircularFile(int taille) {

        this.taille = taille;
        this.head = this.queue = -1;
        this.fileCirculaire = new int[taille];

    }

    public static void main(String[] args) {
        CircularFile f = new CircularFile(4);
        f.display();
        f.put(1);
        f.display();
        f.put(4);
        f.display();
        f.put(2);
        f.display();

        f.put(4);
        f.display();

        f.get();
        f.display();
        f.get();
        f.display();
    }

    public void put(int x) { // On va toujours ajouter dans la pos de la queue
        if (this.isFull()) {
            File.displayFailedMessage("Put operation failed... :(");
        } else {
            if (this.empty()) {
                this.head = 0; 
                this.queue = 0;
                this.fileCirculaire[queue] = x;
            }
            else if ((this.queue == this.taille - 1 ) && (this.head != 0)) {
                this.queue = 0;
                this.fileCirculaire[queue] = x;
            } else {
                this.queue++;
                this.fileCirculaire[queue] = x;
                
            }
        }
    }

    public int get() { // On supprimme depuis le head toujours
        if (this.empty()) {
            File.displayFailedMessage("Get operation failed... :(");
            return -1;
        } else {
            int res = this.fileCirculaire[this.head];
            if (this.head == this.queue) {
                this.head = -1;
                this.queue = -1;
            } else if (this.head == this.taille -1) {
                // todo
                this.head = 0;
            } else {
                this.head++;
            }
            return res;
        }
    }

    public void display() {
        if (this.empty()) {
            File.displayWarningMessage("This queue is empty... :(");
        } else {
            for(int i = this.head; i<this.queue; i++) {
                if (i == this.head) {
                    System.out.print(greenColor+"HEAD "+resetColor);
                }
                System.out.print(this.fileCirculaire[i]+" ");
            }
            System.out.print(redColor+"QUEUE"+resetColor);
        }
        System.out.println();
    }

    private boolean empty() {
        if (this.head == -1) return true;
        return false;
    }

    private boolean isFull() {
        if (this.head == 0 && this.queue == this.taille -1) {
            return true;
        }
        return false;
    }

}
