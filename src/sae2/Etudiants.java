package sae2;

class Etudiants {
    // Attributes
    String name;
    String firstName;
    double average;
    int year;

    // Constructor
    Etudiants(String name, String firstName, double average, int year) {
        this.name = name;
        this.firstName = firstName;
        this.average = average;
        this.year = year;
    }

    // Methods
    public String toString() {
        String str = "";
        if (this.name.length() < 8) {
            str += this.name + "\t\t";
        } else {
            str += this.name + "\t";
        }
        if (this.firstName.length() < 8) {
            str += this.firstName + "\t\t";
        } else {
            str += this.firstName + "\t";
        }
        str += this.average + "\t" + this.year;
        return str;
    }
}