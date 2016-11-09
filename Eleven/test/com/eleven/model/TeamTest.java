/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eleven.model;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USUARIO
 */
public class TeamTest {

    Player Messi;
    Player Ronaldo;
    Player Navas;
    Player Fulano;
    Team RealMadrid;
    Team Barcelona;

    public TeamTest() {
    }

    @Before
    public void setUp() {
        Messi = new Player(1l, 10, "Leonel Messi", "");
        Ronaldo = new Player(2l, 7, "Ronaldo", "");
        Navas = new Player(3l, 1, "Navas", "");
        Fulano = new Player(4l, 9, "Pele", "");

        Barcelona = new Team();
        Barcelona.setTeamPlayers(new ArrayList<Player>());
        Barcelona.getTeamPlayers().add(Messi);
        Barcelona.getTeamPlayers().add(Navas);

        RealMadrid = new Team();
        RealMadrid.setTeamPlayers(new ArrayList<Player>());
        RealMadrid.getTeamPlayers().add(Ronaldo);
        RealMadrid.getTeamPlayers().add(Fulano);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testBarcelonaMembers() {
        assertNotSame(Barcelona.getTeamPlayers(), RealMadrid.getTeamPlayers());
        assertTrue(Barcelona.getTeamPlayers().get(0).getName().contains("Messi"));
        assertTrue(Barcelona.getTeamPlayers().get(1).getName().contains("Navas"));
    }

    @Test
    public void testRealMadridMembers() {
        assertNotSame(Barcelona.getTeamPlayers(), RealMadrid.getTeamPlayers());
        assertTrue(RealMadrid.getTeamPlayers().get(0).getName().contains("Ronaldo"));
        assertTrue(RealMadrid.getTeamPlayers().get(1).getName().contains("Pele"));
    }
}
