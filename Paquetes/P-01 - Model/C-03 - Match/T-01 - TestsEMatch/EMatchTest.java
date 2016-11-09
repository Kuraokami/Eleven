/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eleven.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USUARIO
 */
public class EMatchTest {

    Team RealMadrid = new Team();
    Team Barcelona = new Team();
    EMatch ChampionsFinal = new EMatch();

    public EMatchTest() {
    }

    @Before
    public void setUp() {
        RealMadrid = new Team();
        RealMadrid.setId(1l);
        RealMadrid.setName("Real Madrid");

        Barcelona.setId(2l);
        Barcelona.setName("Barcelona");

        ChampionsFinal.setTeam1(RealMadrid);
        ChampionsFinal.setTeam2(Barcelona);

        ChampionsFinal.setWinnerTeam(RealMadrid.getId());

        ChampionsFinal.setPointsTeam1(3);
        ChampionsFinal.setPointsTeam2(2);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testLoserTeam() {
        assertFalse(ChampionsFinal.getWinnerTeam() == Barcelona.getId());
    }

    @Test
    public void testWinnerTeam() {

        assertTrue(ChampionsFinal.getWinnerTeam() == RealMadrid.getId());

    }

    @Test
    public void testGameAvailability() {
        assertTrue(ChampionsFinal.isGameAvailable());
    }

}
