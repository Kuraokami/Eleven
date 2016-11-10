/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eleven.model;

public class Stat {
     
  
    private Team team;
    private int wins;
    private int loses;
    private int draws;
    
    public Stat(Team team) {
        
        this.team = team;
        wins = 0;
        loses = 0;
        draws = 0;
        
    }

    public Team getTeam() {
        
        return team;
        
    }
    
    public int getWins() {
        
        return wins;
        
    }
    
    public int getLoses() {
        
        return loses;
        
    }
    
    public int getDraws() {
        
        return draws;
        
    }
    
    public void addWin() {
        
        wins++;
        
    }

    public void addLose() {
        
        loses++;
        
    }
    
    public void addDraw() {
        
        draws++;
    
    }

}
