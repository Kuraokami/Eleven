package eleven.m_complete.com.eleven.controller;

import java.util.List;
import javax.persistence.EntityManager;
/*** added by dAdd* modified by dModify* modified by dDelete* modified by
dFind* modified by dGeneral* modified by dGeneral* modified by dGeneral
 */
public abstract class AbstractFacade<T> {
	private Class<T> entityClass;
	public AbstractFacade(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	protected abstract EntityManager getEntityManager();
	public void create(T entity) {
		getEntityManager().persist(entity);
	}
	/*** added by dModify
	 */
	public void edit(T entity) {
		getEntityManager().merge(entity);
	}
	/*** added by dDelete
	 */
	public void remove(T entity) {
		getEntityManager().remove(getEntityManager().merge(entity));
	}
	/*** added by dFind
	 */
	public T find(Object id) {
		return getEntityManager().find(entityClass, id);
	}
	/*** added by dGeneral
	 */
	public List<T> findAll() {
		javax.persistence.criteria.CriteriaQuery cq =
		getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return getEntityManager().createQuery(cq).getResultList();
	}
	/*** added by dGeneral
	 */
	public List<T> findRange(int [] range) {
		javax.persistence.criteria.CriteriaQuery cq =
		getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		javax.persistence.Query q = getEntityManager().createQuery(cq);
		q.setMaxResults(range[1] - range[0] + 1);
		q.setFirstResult(range[0]);
		return q.getResultList();
	}
	/*** added by dGeneral
	 */
	public int count() {
		javax.persistence.criteria.CriteriaQuery cq =
		getEntityManager().getCriteriaBuilder().createQuery();
		javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
		cq.select(getEntityManager().getCriteriaBuilder().count(rt));
		javax.persistence.Query q = getEntityManager().createQuery(cq);
		return(( Long ) q.getSingleResult()).intValue();
	}
}