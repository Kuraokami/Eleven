package com.eleven.model;

import com.eleven.model.Team;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-07T19:10:03")
@StaticMetamodel(EMatch.class)
public class EMatch_ { 

    public static volatile SingularAttribute<EMatch, Boolean> gameAvailable;
    public static volatile SingularAttribute<EMatch, Team> team1;
    public static volatile SingularAttribute<EMatch, Long> winnerTeam;
    public static volatile SingularAttribute<EMatch, Team> team2;
    public static volatile SingularAttribute<EMatch, Integer> pointsTeam1;
    public static volatile SingularAttribute<EMatch, Integer> pointsTeam2;
    public static volatile SingularAttribute<EMatch, Long> id;

}