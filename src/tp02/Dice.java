package tp02;
import java.util.Random;

class Dice {
    //Attributes
    int numberSides;
    Random rand;
    int value;

    //Constructors
    Dice(int numberSides) {
        if (numberSides < 0) {
            this.numberSides = 1;
        } else {
            this.numberSides = numberSides;
        }
        this.rand = new Random();
        this.roll();
    }

    //Methods 
    void roll() {
        this.value = rand.nextInt(this.numberSides-1) + 1;
    }

    public String toString() {
        return "Valeur du dé (" + this.numberSides + " face.s) : " + this.value;
    }
}
