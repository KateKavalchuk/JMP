package by.bsuir.kovalchuk.requestservice.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import by.bsuir.kovalchuk.requestservice.dao.RequestServiceDAO;
import by.bsuir.kovalchuk.requestservice.model.Status;

@Repository("statusDAO")
public class StatusDAO extends HibernateDaoSupport implements
		RequestServiceDAO<Status> {

	@Override
	public void saveOrUpdate(Status entity) {
		getHibernateTemplate().save(entity);
	}

	@Override
	public Status get(int id) {
		return getHibernateTemplate().get(Status.class, id);
	}

	@Override
	public boolean delete(int id) {
		Status status = getHibernateTemplate().get(Status.class, id);
		if (status != null) {
			getHibernateTemplate().delete(status);
			return true;
		}
		return false;
	}

	@Override
	public List<Status> getAll() {
		return getHibernateTemplate().loadAll(Status.class);
	}

	@Override
	public void removeAll() {
		List<Status> status = getHibernateTemplate().loadAll(Status.class);
		getHibernateTemplate().deleteAll(status);
	}
}
