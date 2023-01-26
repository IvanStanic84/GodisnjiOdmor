/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stanic.controller;

import java.util.List;
import stanic.model.Godisnji;

import stanic.model.Zaposlenik;
import stanic.controller.Obrada;
import stanic.util.GodisnjiException;
import stanic.util.Pomocno;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Korisnik
 */
public class ObradaGodisnji extends Obrada<Godisnji> {
    @Override

    public List<Godisnji> read() {
        return session.createQuery("from Godisnji", Godisnji.class).list();

    }

    public Godisnji readOne(Integer sifraGodisnji) {
        return session.get(Godisnji.class, sifraGodisnji);
    }

    @Override
    protected void kontrolaCreate() throws GodisnjiException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void kontrolaUpdate() throws GodisnjiException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void kontrolaDelete() throws GodisnjiException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String getNazivEntiteta() {
return "Godisnji";    }
}
