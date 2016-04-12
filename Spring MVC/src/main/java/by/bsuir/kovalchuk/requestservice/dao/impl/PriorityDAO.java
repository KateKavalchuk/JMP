package by.bsuir.kovalchuk.requestservice.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import by.bsuir.kovalchuk.requestservice.dao.RequestServiceDAO;
import by.bsuir.kovalchuk.requestservice.model.Priority;

@Repository("priorityDAO")
public class PriorityDAO extends HibernateDaoSupport implements
		RequestServiceDAO<Priority> {

	@Override
	public void saveOrUpdate(Priority entity) {
		getHibernateTemplate().save(entity);
	}

	@Override
	public Priority get(int id) {
		return getHibernateTemplate().get(Priority.class, id);
	}

	@Override
	public boolean delete(int id) {
		Priority priority = getHibernateTemplate().get(Priority.class, id);
		if (priority != null) {
			getHibernateTemplate().delete(priority);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Priority> getAll() {
		return getHibernateTemplate().loadAll(Priority.class);
	}

	@Override
	public void removeAll() {
		List<Priority> priorities = getHibernateTemplate().loadAll(
				Priority.class);
		getHibernateTemplate().deleteAll(priorities);
	}

}
