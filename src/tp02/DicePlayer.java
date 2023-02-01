package tp02;

class DicePlayer {
    //Attributes 
    String name;
    int totalValue = 0;
    int nbDiceRolls = 0;

    //Constructors
    DicePlayer(String name) {
        if (name.length() == 0) {
            this.name = "???";
        } else {
            this.name = name;
        }
    }

    //Methods
    void play(Dice dice6) {
        dice6.roll();
        this.totalValue += dice6.value;
        this.nbDiceRolls += 1;
    }

    int compareNbDiceRolls(DicePlayer other) {
        return this.nbDiceRolls - other.nbDiceRolls;
    }

    int compareTotalValue(DicePlayer other) {
        return this.totalValue - other.totalValue;
    }

    public String toString() {
        return this.name + ": " + this.totalValue + " points en " + this.nbDiceRolls + " coups.";
    }
}
