package tp01;

import java.util.Random;

class Irregular {
    //Attributes
    int[][] tableau;
    final Random GENERATOR = new Random();
    final int ORIGIN = -10;
    final int LIMIT = 10;

    //Constructor
    Irregular(int[] lineSize) {
        this.tableau = new int[lineSize.length][];
        for(int idxL = 0; idxL < lineSize.length; idxL++) {
            this.tableau[idxL] = new int[lineSize[idxL]];
        }
    }

    //Methods
    void randomFilling() {
        for(int idxL = 0; idxL < this.tableau.length; idxL++) {
            for(int idxC = 0; idxC < this.tableau[idxL].length; idxC++) {
                this.tableau[idxL][idxC] = this.GENERATOR.nextInt(ORIGIN, LIMIT);
            }
        }
    }

    String display() {
        String str = "";
        for(int idxL = 0; idxL < this.tableau.length; idxL++) {
            for(int idxC = 0; idxC < this.tableau[idxL].length; idxC++) {
                str += this.tableau[idxL][idxC] + " ";
            }
            if (!(idxL == this.tableau.length-1)) {
                str += "\n";
            }
        }
        return str;
    }

    boolean isCommon(int element) {
        int idxL = 0, idxC;
        boolean isCommon = true;
        while(idxL < this.tableau.length && isCommon) {
            idxC = 0;
            isCommon = false;
            while(idxC < this.tableau[idxL].length && !isCommon) {
                isCommon = (element == this.tableau[idxL][idxC]);
                idxC++;
            }
            idxL++;
        }
        return isCommon;
    }

    boolean existCommon() {
        int idxL = 0, idxC;
        boolean existCommon = false;
        while(idxL < this.tableau.length && !existCommon) {
            idxC = 0;
            while(idxC < this.tableau[idxL].length && !existCommon) {
                existCommon = isCommon(this.tableau[idxL][idxC]);
                idxC++;
            }
            idxL++;
        }
        return existCommon;
    }

}