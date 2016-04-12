package by.bsuir.kovalchuk.requestservice.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import by.bsuir.kovalchuk.requestservice.dao.RequestServiceDAO;
import by.bsuir.kovalchuk.requestservice.model.Department;

@Repository("departmentDAO")
public class DepartmentDAO extends HibernateDaoSupport implements
		RequestServiceDAO<Department> {
	@Override
	public void saveOrUpdate(Department entity) {
		getHibernateTemplate().save(entity);
	}

	@Override
	public Department get(int id) {
		return getHibernateTemplate().get(Department.class, id);
	}

	@Override
	public boolean delete(int id) {
		Department department = getHibernateTemplate()
				.get(Department.class, id);
		if (department != null) {
			getHibernateTemplate().delete(department);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Department> getAll() {
		return getHibernateTemplate().loadAll(Department.class);
	}

	@Override
	public void removeAll() {
		List<Department> departments = getHibernateTemplate().loadAll(
				Department.class);
		getHibernateTemplate().deleteAll(departments);
	}
}
