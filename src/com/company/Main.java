package com.company;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cursist Karen = new Cursist("Karen", LocalDate.of(1974, Month.OCTOBER, 28));
        Cursus cursus = new Cursus("Java", 70, 3);
        cursus.schrijfCursistIn(Karen);
        for (Cursist c:cursus) {
            System.out.printf("%s (%d jaar) is ingeschreven.%n", c.getNaam(), c.getLeeftijd());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Geef naam nieuwe cursist: ");
        String naam = scanner.nextLine();
        System.out.print("Geef geboortejaar nieuwe cursist: ");
        int geboortejaar = Integer.parseInt(scanner.nextLine());
        System.out.print("Geef geboortemaand nieuwe cursist: ");
        int geboortemaand = Integer.parseInt(scanner.nextLine());
        System.out.print("Geef geboortedag nieuwe cursist: ");
        int geboortedag = Integer.parseInt(scanner.nextLine());
        LocalDate geboortedatum = LocalDate.of(geboortejaar, geboortemaand, geboortedag);
        Cursist curs = new Cursist(naam, geboortedatum);
        cursus.schrijfCursistIn(curs);
        System.out.printf("%s (%d jaar) is ingeschreven.%n", curs.getNaam(), curs.getLeeftijd());


    }
}

class Cursus implements Iterable<Cursist>{
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
}