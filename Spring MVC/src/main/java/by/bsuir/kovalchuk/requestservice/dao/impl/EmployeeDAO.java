package by.bsuir.kovalchuk.requestservice.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import by.bsuir.kovalchuk.requestservice.dao.RequestServiceDAO;
import by.bsuir.kovalchuk.requestservice.model.Employee;

@Repository("employeeDAO")
public class EmployeeDAO extends HibernateDaoSupport implements
		RequestServiceDAO<Employee> {

	@Override
	public void saveOrUpdate(Employee entity) {
		getHibernateTemplate().save(entity);
	}

	@Override
	public Employee get(int id) {
		return getHibernateTemplate().get(Employee.class, id);
	}

	@Override
	public boolean delete(int id) {
		Employee employee = getHibernateTemplate().get(Employee.class, id);
		if (employee != null) {
			getHibernateTemplate().delete(employee);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Employee> getAll() {
		return getHibernateTemplate().loadAll(Employee.class);
	}

	@Override
	public void removeAll() {
		List<Employee> employees = getHibernateTemplate().loadAll(
				Employee.class);
		getHibernateTemplate().deleteAll(employees);
	}

	public Employee fetchByEmailAndPassword(String email, String password) {
		List<?> list = getHibernateTemplate().find(
				"from Employee where email=? and password=?", email, password);
		return list.size() > 0 ? (Employee) list.get(0) : null;
	}

}
