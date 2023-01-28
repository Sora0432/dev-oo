package sae2;

class TestSae {
    // Attributes
    String[][] students;

    // Constructor
    TestSae(String[][] array) {
        this.students = array;
    }


    public static void main(String[] args) {
        TestSae test = new TestSae(new String[0][0]);
        for (int i = 0; i < test.students.length; i++) {
            for (int j = 0; j < test.students[i].length; j++) {
                System.out.println(test.students[i][j]);
            }
        }
    }
}