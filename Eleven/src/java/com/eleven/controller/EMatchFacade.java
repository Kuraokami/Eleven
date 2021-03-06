/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eleven.controller;

import com.eleven.model.EMatch;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author USUARIO
 */
@Stateless
public class EMatchFacade extends AbstractFacade<EMatch> {

    @PersistenceContext(unitName = "ElevenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EMatchFacade() {
        super(EMatch.class);
    }
    
}
