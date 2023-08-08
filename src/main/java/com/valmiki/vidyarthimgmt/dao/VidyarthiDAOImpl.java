package com.valmiki.vidyarthimgmt.dao;

import com.valmiki.vidyarthimgmt.entity.Vidyarthi;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VidyarthiDAOImpl implements VidyarthiDAO {

    //define fields for entitymanager
    private EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public VidyarthiDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;

    }

    @Override
    public List<Vidyarthi> findAll() {

        //create query
        TypedQuery<Vidyarthi> theQuery = entityManager.createQuery("from Vidyarthi", Vidyarthi.class);
        //execute query
        List<Vidyarthi> vidyarthi = theQuery.getResultList();
        //return results
        return vidyarthi;
    }

    @Override
    public Vidyarthi findById(int theId) {
        Vidyarthi theVidyarthi = entityManager.find(Vidyarthi.class, theId);
        return theVidyarthi;
    }

    @Override
    public Vidyarthi save(Vidyarthi theVidyarthi) {
        Vidyarthi dbVidyarthi = entityManager.merge(theVidyarthi);
        return dbVidyarthi;
    }

    @Override
    public void deleteById(int theId) {

        Vidyarthi theEmployee = entityManager.find(Vidyarthi.class, theId);
        entityManager.remove(theEmployee);
    }
}
