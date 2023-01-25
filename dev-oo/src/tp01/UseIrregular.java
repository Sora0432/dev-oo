class UseIrregular {

    public static void main(String[] args) {

        Irregular irregulier = new Irregular(new int[]{3, 1, 2});

        irregulier.randomFilling();
        System.out.println(irregulier.display() + "\n");


        for(int idxL = 0; idxL < irregulier.tab.length; idxL++) {
            for(int idxC = 0; idxC < irregulier.tab[idxL].length; idxC++) {
                irregulier.tab[idxL][idxC] = idxC;
            }
        }

        System.out.println(irregulier.display());
        int testCommon = 2;
        System.out.println("Is common (" + testCommon + "): " + irregulier.isCommon(testCommon));
        System.out.println("Is one common: " + irregulier.existCommon());
    
    }

}