package com.company;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Cursus cursus = new Cursus("Java", 70, 3);
        Cursist Karen = new Cursist("Karen", LocalDate.of(1974, Month.OCTOBER, 28));
        Cursist Joske = new Cursist("Joske", LocalDate.of(2000, Month.OCTOBER, 30));
        Cursist Kristel = new Cursist("Kristel", LocalDate.of(1975, Month.DECEMBER, 8));

        cursus.schrijfCursistIn(Joske);
        cursus.schrijfCursistIn(Karen);
        cursus.schrijfCursistIn(Kristel);

        toonCursisten(cursus);

        cursus.schrijfCursistUit(Joske);
        toonCursisten(cursus);

    }

    private static void toonCursisten(Cursus cursus) {
        System.out.println("De ingeschreven cursisten zijn: ");
        int teller = 1;
        for(Cursist c: cursus){
            System.out.printf("%d. %s%n", teller, c.getNaam());
            teller ++;
        }
    }
}

class Cursus implements Iterable<Cursist>{
    private String cursusNaam;
    private Integer duurtijd;
    private Integer aantalPlaatsen;
    private List<Cursist> cursisten =  new ArrayList<>();

    public Cursus(String cursusNaam, Integer duurtijd, Integer aantalPlaatsen) {
        this.cursusNaam = cursusNaam;
        this.duurtijd = duurtijd;
        this.aantalPlaatsen = aantalPlaatsen;
    }

    public void schrijfCursistIn(Cursist cursist){
        cursisten.add(cursist);
        System.out.printf("Cursist %s is ingeschreven.%n", cursist.getNaam());

    }

    public void schrijfCursistUit(Cursist cursist){
        cursisten.remove(cursist);
        System.out.printf("Cursist %s is uitgeschreven.%n", cursist.getNaam());
    }


    public String getNaam() {
        return cursusNaam;
    }

    public Integer getAantalDagen() {
        return duurtijd;
    }

    public Integer getMaxdeelnemers() {
        return aantalPlaatsen;
    }

    public Integer getAantalCursisten(){
        return cursisten.size();
    }

    @Override
    public Iterator<Cursist> iterator() {
        return cursisten.iterator();
    }
}

class Cursist {
    private String naam;
    private LocalDate geboortedatum;

    public Cursist(String naam, LocalDate geboortedatum) {
        this.naam = naam;
        this.geboortedatum = geboortedatum;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(LocalDate geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public int getLeeftijd(){
        Period periode = Period.between(geboortedatum,LocalDate.now());
        return periode.getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cursist cursist = (Cursist) o;
        return Objects.equals(naam, cursist.naam) &&
                Objects.equals(geboortedatum, cursist.geboortedatum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam, geboortedatum);
    }
}