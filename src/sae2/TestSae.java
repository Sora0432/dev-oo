package sae2;

import fr.ulille.but.sae2_02.donnees.DonneesPourTester;

class TestSae {
    // Attributes
    String[][] students;

    // Constructor
    TestSae() {
        this.students = DonneesPourTester.studentData;
    }

    // Methods
    public String toString() {
        String str = "";
        for (int i = 0; i < this.students.length; i++) {
            for (int j = 0; j < this.students[i].length; j++) {
                str += this.students[i][j] + " ";
            }
            str += "\n";
        }
        return str;
    }


}