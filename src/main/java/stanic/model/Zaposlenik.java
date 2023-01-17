/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stanic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author Korisnik
 */
@Entity
public class Zaposlenik extends Entitet {

    private String ime;
    private String prezime;
    private String oib;
    private int ukupniBrojDana;

   

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public int getUkupniBrojDana() {
        return ukupniBrojDana;
    }

    public void setUkupniBrojDana(int ukupniBrojDana) {
        this.ukupniBrojDana = ukupniBrojDana;
    }

  

    public Zaposlenik() {
    }

    public Zaposlenik(String ime, String prezime, String oib, int ukupniBrojDana) {
        this.ime = ime;
        this.prezime = prezime;
        this.oib = oib;
        this.ukupniBrojDana = ukupniBrojDana;
       
    }

    public Zaposlenik(String ime, String prezime, String oib, int ukupniBrojDana, Integer sifra) {
        super(sifra);
        this.ime = ime;
        this.prezime = prezime;
        this.oib = oib;
        this.ukupniBrojDana = ukupniBrojDana;
      
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

}
