import java.util.Random;

class RandomSequence {

    final static String ERROR_MESSAGE = "Correct usage : <nbElt> <maxVal> INTEGER|REAL\n<nbElt> must be int type; <maxVal> must be int type if \"INTEGER\" or nothing is specified and must be double if \"REAL\" is specified.";
    final static Random GENERATOR = new Random();

    public static void randomInt(String nbr, String lim) {
        int nbrDeGeneration, limite;
        try {
            nbrDeGeneration = Integer.parseInt(nbr);
            limite = Integer.parseInt(lim);
            for(int i = 0; i < nbrDeGeneration; i++) {
                System.out.println(GENERATOR.nextInt(limite+1));
            }
        } catch (NumberFormatException e) {
            System.out.println(ERROR_MESSAGE);
        }
    }

    public static void randomDouble(String nbr, String lim) {
        double nbrDeGeneration, limite;
        try {
            nbrDeGeneration = Double.parseDouble(nbr);
            limite = Double.parseDouble(lim);
            for(int i = 0; i < nbrDeGeneration; i++) {
                System.out.println(GENERATOR.nextDouble(limite));
            }
        } catch (NumberFormatException e) {
            System.out.println(ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        if (args.length == 2) {
            randomInt(args[0], args[1]);
        } else if (args.length == 3) {
            if (args[2].toUpperCase().equals("INTEGER")) {
                randomInt(args[0], args[1]);
            } else if (args[2].toUpperCase().equals("REAL")) {
                randomDouble(args[0], args[1]);
            }
        } else {
            System.out.println(ERROR_MESSAGE);
        }
    }
}