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

    public static void main(String[] args) {
        TestSae t = new TestSae();
        System.out.println(t);
        TestSae t2 = new TestSae();
        System.out.println("Sort on first name ascending:");
        sortOn(t2, true, 0);
        System.out.println(t2);
        TestSae t3 = new TestSae();
        System.out.println("Sort on first name descending:");
        sortOn(t3, false, 0);
        System.out.println(t3);
        TestSae t4 = new TestSae();
        System.out.println("Sort on last name ascending:");
        sortOn(t4, true, 1);
        System.out.println(t4);
        TestSae t5 = new TestSae();
        System.out.println("Sort on last name descending:");
        sortOn(t5, false, 1);
        System.out.println(t5);
        TestSae t6 = new TestSae();
        System.out.println("Sort on grade ascending:");
        sortOn(t6, true, 2);
        System.out.println(t6);
        TestSae t7 = new TestSae();
        System.out.println("Sort on grade descending:");
        sortOn(t7, false, 2);
        System.out.println(t7);
        TestSae t8 = new TestSae();
        System.out.println("Sort on year ascending:");
        sortOn(t8, true, 3);
        System.out.println(t8);
        TestSae t9 = new TestSae();
        System.out.println("Sort on year descending:");
        sortOn(t9, false, 3);
        System.out.println(t9);
        TestSae t10 = new TestSae();
        System.out.println("Sort on year descending, grade descending and first name ascending:");
        sortOn(t10, false, 3);
        sortOn(t10, false, 2);
        sortOn(t10, true, 0);
        System.out.println(t10);

    }

}
