/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stanic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import java.util.Date;

/**
 *
 * @author Korisnik
 */
@Entity
public class ZaposlenikGodisnji extends Entitet {

    @OneToOne
    private Zaposlenik zaposlenik;
    private Date pocetak;
    private Date zavrsetak;
    private int dana;
    private int preostaloDana;

    public Zaposlenik getZaposlenik() {
        return zaposlenik;
    }

    public void setZaposlenik(Zaposlenik zaposlenik) {
        this.zaposlenik = zaposlenik;
    }

    public Date getPocetak() {
        return pocetak;
    }

    public void setPocetak(Date pocetak) {
        this.pocetak = pocetak;
    }

    public Date getZavrsetak() {
        return zavrsetak;
    }

    public void setZavrsetak(Date zavrsetak) {
        this.zavrsetak = zavrsetak;
    }

    public int getDana() {
        return dana;
    }

    public void setDana(int dana) {
        this.dana = dana;
    }

    public int getPreostaloDana() {
        return preostaloDana;
    }

    public void setPreostaloDana(int preostaloDana) {
        this.preostaloDana = preostaloDana;
    }

    public ZaposlenikGodisnji(Zaposlenik zaposlenik, Date pocetak, Date zavrsetak, int dana, int preostaloDana) {
        this.zaposlenik = zaposlenik;
        this.pocetak = pocetak;
        this.zavrsetak = zavrsetak;
        this.dana = dana;
        this.preostaloDana = preostaloDana;
    }

    public ZaposlenikGodisnji(Zaposlenik zaposlenik, Date pocetak, Date zavrsetak, int dana, int preostaloDana, Integer sifra) {
        super(sifra);
        this.zaposlenik = zaposlenik;
        this.pocetak = pocetak;
        this.zavrsetak = zavrsetak;
        this.dana = dana;
        this.preostaloDana = preostaloDana;
    }

    public ZaposlenikGodisnji() {
    }

    public ZaposlenikGodisnji(Integer sifra) {
        super(sifra);
    }

    @Override
    public String toString() {
        var po = pocetak == null ? "" : pocetak + "          ";
        var za = zavrsetak == null ? "" : "     " + zavrsetak;
        String d = dana == 0 ? "" : "     " + dana;

        return po.substring(0, 10) + " " + za.substring(0, 10) + " " + d.substring(d.length() - 5);
    }

}
