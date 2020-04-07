package com.aoher.dao.impl;

import com.aoher.dao.PersonneDAO;
import com.aoher.exception.DAOException;
import com.aoher.model.Personne;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PersonneJPADAO implements PersonneDAO {

    @PersistenceContext
    private EntityManager entityManager;

    private Logger log = Logger.getLogger(PersonneJPADAO.class);

    @Override
    public List<Personne> findAll() {
        TypedQuery<Personne> query = entityManager.createQuery(
                "select p from Personne p", Personne.class);
        return query.getResultList();
    }

    @Override
    public Personne save(Personne personne) throws DAOException {
        try {
            entityManager.persist(personne);
        } catch (PersistenceException e) {
            log.error("PersistenceException while saving" + personne.getNom());
            throw new DAOException("Erreur creation de personne", e);
        }
        return personne;
    }

    @Override
    public Personne update(Personne personne) throws DAOException {
        try {
            entityManager.persist(personne);
        } catch (PersistenceException e) {
            log.error("PersistenceException while updating" + personne.getNom());
            throw new DAOException("Erreur creation de personne", e);
        }
        return personne;
    }
}
