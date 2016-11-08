package eleven._.com.eleven.controller;

import eleven._.com.eleven.model.Player;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/*** added by dPlayerFacade
 */
@Stateless
public class PlayerFacade extends AbstractFacade<Player> {
	@PersistenceContext(unitName = "ElevenPU")
	private EntityManager em;
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	public PlayerFacade() {
		super(Player.class);
	}
}