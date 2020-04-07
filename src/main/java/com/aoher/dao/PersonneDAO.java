package com.aoher.dao;

import com.aoher.exception.DAOException;
import com.aoher.model.Personne;

import java.util.List;

public interface PersonneDAO {

    List<Personne> findAll();
    Personne save(Personne personne) throws DAOException;
    Personne update(Personne personne) throws DAOException;
}
