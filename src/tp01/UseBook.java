package tp01;

class UseBook {

    public static void main(String[] args) {
        System.out.println("E1Q5\n");
        Book livre = new Book("Edxin A. Abbott", "Flatland", 1884);
        System.out.println(livre.author + " a écrit " + livre.title + " en " + livre.year);
        System.out.println("\nE1Q6\n");
        Book[] biblio = new Book[]{
            new Book("Jules Verne", "Voyage au centre de la terre", 1864),
            new Book("Jules Verne", "20000 lieues sous les mers", 1869),
            new Book("Robert Louis Stevenson", "L'île au Trésor", 1882)
        };   
        for(int i = 0; i < biblio.length; i++) {
            System.out.println(biblio[i].author + " a écrit " + biblio[i].title + " en " + biblio[i].year);
        }
    }  
}