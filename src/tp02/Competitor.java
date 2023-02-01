package tp02;

class Competitor {
    //Attributes
    private String numberSign;
    private int time;
    private int score;

    //Constructor
    Competitor(int numberSign, int score, int min, int sec) {
        if ((numberSign >= 1 && numberSign <= 99) && (score >= 0 && score <= 50) && (min >= 0 && min <= 60) && (sec >= 0 && sec <= 60)) {
            this.numberSign = "No";
            if (numberSign < 10) {
                this.numberSign += '0';
            }
            this.numberSign += numberSign;
        }
        this.score = score;
        this.time = 60*min + sec;
    }

    //Methods
    String display() {
        if (this.numberSign != null) {
            return "[" + this.numberSign + ", " + this.score + " points, " + this.time + " s]";
        }
        return "[<invalide>, " + this.score + " points, " + this.time + " s]";
    }

    public static void main(String args[]) {
        Competitor[] inscrits = new Competitor[100];
        inscrits[0] = new Competitor(1, 45, 15, 20);
        inscrits[1] = new Competitor(2, 32, 12, 45);
        inscrits[2] = new Competitor(5, 12, 13, 59);
        inscrits[3] = new Competitor(12, 12, 15, 70);
        inscrits[4] = new Competitor(32, 75, 15, 20);

        for (Competitor competiteur : inscrits) {
            try {
                if (competiteur.numberSign != null) {
                    System.out.println(competiteur.display());
                }
            } catch (NullPointerException e) {
                break;
            }
        }
    }
    
}
