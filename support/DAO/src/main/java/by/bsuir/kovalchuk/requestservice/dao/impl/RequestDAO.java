package by.bsuir.kovalchuk.requestservice.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import by.bsuir.kovalchuk.requestservice.dao.RequestServiceDAO;
import by.bsuir.kovalchuk.requestservice.model.Request;

@Repository("requestDAO")
public class RequestDAO extends HibernateDaoSupport implements
		RequestServiceDAO<Request> {

	@Override
	public void saveOrUpdate(Request entity) {
		getHibernateTemplate().save(entity);
	}

	@Override
	public Request get(int id) {
		return getHibernateTemplate().get(Request.class, id);
	}

	@Override
	public boolean delete(int id) {
		Request request = getHibernateTemplate().get(Request.class, id);
		if (request != null) {
			getHibernateTemplate().delete(request);
			return true;
		}
		return false;
	}

	@Override
	public List<Request> getAll() {
		return getHibernateTemplate().loadAll(Request.class);
	}

	@Override
	public void removeAll() {
		List<Request> requests = getHibernateTemplate().loadAll(Request.class);
		getHibernateTemplate().deleteAll(requests);

	}

	public List<?> fetchByDepartment(int idDepartment) {
		List<?> list = getHibernateTemplate().find(
				"from Request where idDepartment=?", idDepartment);
		return list;
	}

	public List<?> fetchByUserId(int userId) {
		List<?> list = getHibernateTemplate().find(
				"from Request where idUser=?", userId);
		return list;
	}
}
