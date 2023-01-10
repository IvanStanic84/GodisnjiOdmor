/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stanic.controller;

import stanic.model.Entitet;
import stanic.util.HibernateUtil;
import stanic.util.GodisnjiException;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Korisnik
 */
public abstract class Obrada<T extends Entitet> {

    protected T entitet;
    protected Session session;

    public abstract List<T> read();

    protected abstract void kontrolaCreate() throws GodisnjiException;

    protected abstract void kontrolaUpdate() throws GodisnjiException;

    protected abstract void kontrolaDelete() throws GodisnjiException;

    protected abstract String getNazivEntiteta();

    public Obrada() {
        this.session = HibernateUtil.getSession();
    }

    public void create() throws GodisnjiException {
        if (entitet == null) {
            throw new GodisnjiException(getNazivEntiteta() + " nije konstruiran");
        }
        kontrolaCreate();
        persist();
    }

    public void update() throws GodisnjiException {
        kontrolaUpdate();
        persist();
    }

    public void delete() throws GodisnjiException {
        kontrolaDelete();
        session.beginTransaction();
        session.remove(entitet);
        session.getTransaction().commit();
    }

    private void persist() {
        session.beginTransaction();
        session.persist(this.entitet);
        session.getTransaction().commit();
    }

    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }

    public void refresh() {

        session.refresh(entitet);
    }

}
