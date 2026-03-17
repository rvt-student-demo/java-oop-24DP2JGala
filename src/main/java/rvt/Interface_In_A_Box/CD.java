package rvt.Interface_In_A_Box;

public class CD implements Packable {

    private String artist;
    private String name;
    private int publicationYear;
    private final double weight = 0.1;

    public CD(String artist, String name, int publicationYear) {
        this.artist = artist;
        this.name = name;
        this.publicationYear = publicationYear;

    }

    public double weight() {
        return this.weight;

    }

    public String toString() {
        return this.artist + ": " + this.name + " (" + this.publicationYear + ")";

    }

}