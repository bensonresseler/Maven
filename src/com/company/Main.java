package com.company;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Cursist joske = new Cursist("Joske", LocalDate.of(2000, Month.OCTOBER, 30));
        Cursus cursus = new Cursus("Java", 70, 3);
        System.out.printf("De cursus %s duurt %d dagen. Er is plaats voor %d deelnemers%n", cursus.getNaam(), cursus.getAantalDagen(), cursus.getMaxdeelnemers());
        cursus.schrijfCursistIn(joske);

        if(cursus.getAantalCursisten() == 1){
            System.out.printf("Na het inschrijven van %s is er %d deelnemer.%n", joske.getNaam(), cursus.getAantalCursisten());

        } else{
            System.out.printf("Na het inschrijven van %s zijn er %d deelnemers%n", joske.getNaam(), cursus.getAantalCursisten());

        }
    }
}

class Cursus{
    private String cursusNaam;
    private Integer duurtijd;
    private Integer aantalPlaatsen;
    private ArrayList<Cursist> cursisten =  new ArrayList<>();

    public Cursus(String cursusNaam, Integer duurtijd, Integer aantalPlaatsen) {
        this.cursusNaam = cursusNaam;
        this.duurtijd = duurtijd;
        this.aantalPlaatsen = aantalPlaatsen;
    }

    public void schrijfCursistIn(Cursist cursist){
        cursisten.add(cursist);
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
}