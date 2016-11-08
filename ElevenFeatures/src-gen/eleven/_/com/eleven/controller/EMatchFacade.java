package eleven._.com.eleven.controller;

import eleven._.com.eleven.model.EMatch;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/*** added by dEMatchFacade
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