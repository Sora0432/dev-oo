package sae2;

import fr.ulille.but.sae2_02.donnees.DonneesPourTester;

class UseEtudiant {

    public static void sortOnName(Etudiants[] etudiants, boolean ascending) {
        Etudiants temp;
        for (int idx = 0; idx < etudiants.length; idx++) {
            for (int idx2 = idx + 1; idx2 < etudiants.length; idx2++) {
                if (ascending) {
                    if (etudiants[idx].name.compareTo(etudiants[idx2].name) > 0) {
                        temp = etudiants[idx];
                        etudiants[idx] = etudiants[idx2];
                        etudiants[idx2] = temp;
                    }
                } else {
                    if (etudiants[idx].name.compareTo(etudiants[idx2].name) < 0) {
                        temp = etudiants[idx];
                        etudiants[idx] = etudiants[idx2];
                        etudiants[idx2] = temp;
                    }
                }
            }
        }
    }

    public static void sortOnFirstName(Etudiants[] etudiants, boolean ascending) {
        Etudiants temp;
        for (int idx = 0; idx < etudiants.length; idx++) {
            for (int idx2 = idx + 1; idx2 < etudiants.length; idx2++) {
                if (ascending) {
                    if (etudiants[idx].firstName.compareTo(etudiants[idx2].firstName) > 0) {
                        temp = etudiants[idx];
                        etudiants[idx] = etudiants[idx2];
                        etudiants[idx2] = temp;
                    }
                } else {
                    if (etudiants[idx].firstName.compareTo(etudiants[idx2].firstName) < 0) {
                        temp = etudiants[idx];
                        etudiants[idx] = etudiants[idx2];
                        etudiants[idx2] = temp;
                    }
                }
            }
        }
    }

    public static void sortOnAverage(Etudiants[] etudiants, boolean ascending) {
        Etudiants temp;
        for (int idx = 0; idx < etudiants.length; idx++) {
            for (int idx2 = idx + 1; idx2 < etudiants.length; idx2++) {
                if (ascending) {
                    if (etudiants[idx].average > etudiants[idx2].average) {
                        temp = etudiants[idx];
                        etudiants[idx] = etudiants[idx2];
                        etudiants[idx2] = temp;
                    }
                } else {
                    if (etudiants[idx].average < etudiants[idx2].average) {
                        temp = etudiants[idx];
                        etudiants[idx] = etudiants[idx2];
                        etudiants[idx2] = temp;
                    }
                }
            }
        }
    }

    public static void sortOnYear(Etudiants[] etudiants, boolean ascending) {
        Etudiants temp;
        for (int idx = 0; idx < etudiants.length; idx++) {
            for (int idx2 = idx + 1; idx2 < etudiants.length; idx2++) {
                if (ascending) {
                    if (etudiants[idx].year > etudiants[idx2].year) {
                        temp = etudiants[idx];
                        etudiants[idx] = etudiants[idx2];
                        etudiants[idx2] = temp;
                    }
                } else {
                    if (etudiants[idx].year < etudiants[idx2].year) {
                        temp = etudiants[idx];
                        etudiants[idx] = etudiants[idx2];
                        etudiants[idx2] = temp;
                    }
                }
            }
        }
    }

    public static boolean sortOnField(Etudiants[] etudiants, String field) {
        switch (field) {
            case "name":
                sortOnName(etudiants, true);
                return true;
            case "-name":
                sortOnName(etudiants, false);
                return true;
            case "firstName":
                sortOnFirstName(etudiants, true);
                return true;
            case "-firstName":
                sortOnFirstName(etudiants, false);
                return true;
            case "average":
                sortOnAverage(etudiants, true);
                return true;
            case "-average":
                sortOnAverage(etudiants, false);
                return true;
            case "year":
                sortOnYear(etudiants, true);
                return true;
            case "-year":
                sortOnYear(etudiants, false);
                return true;
            default:
                return false;
        }
    }

    public static boolean sortOnMultipleFields(Etudiants[] etudiants, String[] fields) {
        boolean result = true;
        for (int idx = 0; idx < fields.length; idx++) {
            result = sortOnField(etudiants, fields[idx]);
        }
        return result;
    }

    public static void main(String[] args) {
        Etudiants[] etudiants = new Etudiants[DonneesPourTester.studentData.length];
        for (int idx = 0; idx < etudiants.length; idx++) {
            etudiants[idx] = new Etudiants(DonneesPourTester.studentData[idx][0], DonneesPourTester.studentData[idx][1], Double.parseDouble(DonneesPourTester.studentData[idx][2]), Integer.parseInt(DonneesPourTester.studentData[idx][3]));
        }
        for (int idx = 0; idx < etudiants.length; idx++) {
            System.out.println(etudiants[idx]);
        }
        System.out.println("\nThere are " + etudiants.length + " students.");
        if (sortOnMultipleFields(etudiants, args)) {
            System.out.println("\nStudents sorted on " + args[0]);
            for (int idx = 0; idx < etudiants.length; idx++) {
                System.out.println(etudiants[idx]);
            }
        } else {
            System.out.println("\nStudents not sorted");
        }
    }
}
