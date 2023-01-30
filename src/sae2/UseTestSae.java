package sae2;

class UseTestSae {

    public static String[][] SortString(String[][] array, boolean ascending, int column) {
        String[] tmp;
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (ascending) {
                    if (array[i][column].compareTo(array[j][column]) > 0) {
                        tmp = array[i];
                        array[i] = array[j];
                        array[j] = tmp;
                    }
                } else {
                    if (array[i][column].compareTo(array[j][column]) < 0) {
                        tmp = array[i];
                        array[i] = array[j];
                        array[j] = tmp;
                    }
                }
            }
        }
        return array;
    }

    public static String[][] SortDouble(String[][] array, boolean ascending, int column) {
        String[] tmp;
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (ascending) {
                    if (Double.parseDouble(array[i][column]) > Double.parseDouble(array[j][column])) {
                        tmp = array[i];
                        array[i] = array[j];
                        array[j] = tmp;
                    }
                } else {
                    if (Double.parseDouble(array[i][column]) < Double.parseDouble(array[j][column])) {
                        tmp = array[i];
                        array[i] = array[j];
                        array[j] = tmp;
                    }
                }
            }
        }
        return array;
    }

    public static String[][] SortInt(String[][] array, boolean ascending, int column) {
        String[] tmp;
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (ascending) {
                    if (Integer.parseInt(array[i][column]) > Integer.parseInt(array[j][column])) {
                        tmp = array[i];
                        array[i] = array[j];
                        array[j] = tmp;
                    }
                } else {
                    if (Integer.parseInt(array[i][column]) < Integer.parseInt(array[j][column])) {
                        tmp = array[i];
                        array[i] = array[j];
                        array[j] = tmp;
                    }
                }
            }
        }
        return array;
    }
    
    public static void sortOn(TestSae t, boolean ascending, int column) {
        for (int i = 0; i < t.students.length; i++) {
            for (int j = i+1; j < t.students.length; j++) {
                try {
                    SortString(t.students, ascending, column);
                } catch(Exception e) {
                    try {
                        SortDouble(t.students, ascending, column);
                    } catch(NumberFormatException e2) {
                        SortInt(t.students, ascending, column);
                    }
                }
            }
        }
    }
}
