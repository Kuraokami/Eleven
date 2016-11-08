package eleven._.com.eleven.controller;

import eleven._.com.eleven.model.Team;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/*** added by dTeamFacade
 */
@Stateless
public class TeamFacade extends AbstractFacade<Team> {
	@PersistenceContext(unitName = "ElevenPU")
	private EntityManager em;
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	public TeamFacade() {
		super(Team.class);
	}
}