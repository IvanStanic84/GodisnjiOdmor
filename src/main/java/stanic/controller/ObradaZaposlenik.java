/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stanic.controller;

import java.util.List;
import stanic.model.Zaposlenik;
import stanic.util.GodisnjiException;
import stanic.util.Pomocno;

/**
 *
 * @author Korisnik
 */
public class ObradaZaposlenik extends Obrada<Zaposlenik> {

    @Override
    public List<Zaposlenik> read() {
        return session.createQuery("from Zaposlenik", Zaposlenik.class).list();
    }

    @Override
    protected void kontrolaCreate() throws GodisnjiException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaOib();

    }

    @Override
    protected void kontrolaUpdate() throws GodisnjiException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaOib();

    }

    @Override
    protected void kontrolaDelete() throws GodisnjiException {
        Integer i = session.createNativeQuery(
                "select count(*) from godisnji where zaposlenik_sifra=:p",
                Integer.class).setParameter("p", entitet.getSifra()).getSingleResult();
        if (i > 0) {
            throw new GodisnjiException("Zaposlenik ima unesene godišnje odmore pa se ne može obrisati");
        }

    }

    @Override
    protected String getNazivEntiteta() {
        return "Zaposlenik";
    }

    private void kontrolaIme() throws GodisnjiException {
        kontrolaImeMoraBitiUneseno();
    }

    private void kontrolaPrezime() throws GodisnjiException {
        kontrolaPrezimeMoraBitiUneseno();
    }

    private void kontrolaImeMoraBitiUneseno() throws GodisnjiException {
        if (entitet.getIme() == null || entitet.getIme().trim().isEmpty()) {
            throw new GodisnjiException("Ime zaposlenika mora biti unešeno");
        }
    }

    private void kontrolaPrezimeMoraBitiUneseno() throws GodisnjiException {
        if (entitet.getPrezime() == null || entitet.getPrezime().trim().isEmpty()) {
            throw new GodisnjiException("Prezime zaposlenika mora biti unešeno");
        }
    }

    private void kontrolaOib() throws GodisnjiException {
        if (!Pomocno.kontrolaOib(entitet.getOib())) {
            throw new GodisnjiException("OIB nije ispravan");
        }
    }

}
