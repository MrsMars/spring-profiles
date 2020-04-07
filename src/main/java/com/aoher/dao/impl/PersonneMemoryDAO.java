package com.aoher.dao.impl;

import com.aoher.dao.PersonneDAO;
import com.aoher.model.Personne;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonneMemoryDAO implements PersonneDAO {

    List<Personne> personnes = new ArrayList<>();

    @Override
    public Personne save(Personne personne) {
        personnes.add(personne);
        return null;
    }

    @Override
    public List<Personne> findAll() {
        return personnes;
    }

    @Override
    public Personne update(Personne personne) {
        return null;
    }
}
