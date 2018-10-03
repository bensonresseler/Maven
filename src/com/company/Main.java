package com.company;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class Main {

    public static void main(String[] args) {
        Cursist joske = new Cursist("Joske", LocalDate.of(2000, Month.OCTOBER, 30));
        System.out.printf("%s is geboren op %s en is %d jaar oud.%n", joske.getNaam(), joske.getGeboortedatum(), joske.getLeeftijd());
    }
}

class Cursist{
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

    public Integer getLeeftijd() {
        LocalDate vandaag = LocalDate.now();
        Period periode = Period.between(geboortedatum,vandaag);
        Integer leeftijd = periode.getYears();
        return leeftijd;
    }
}