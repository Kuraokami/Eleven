package com.eleven.model;

import com.eleven.model.EMatch;
import com.eleven.model.Player;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-07T19:10:03")
@StaticMetamodel(Team.class)
public class Team_ { 

    public static volatile ListAttribute<Team, Player> teamPlayers;
    public static volatile ListAttribute<Team, EMatch> eMatchs;
    public static volatile SingularAttribute<Team, String> name;
    public static volatile SingularAttribute<Team, Long> id;

}