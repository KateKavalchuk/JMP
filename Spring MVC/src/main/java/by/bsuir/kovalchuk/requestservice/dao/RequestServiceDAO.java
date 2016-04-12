package by.bsuir.kovalchuk.requestservice.dao;

import java.util.List;

public interface RequestServiceDAO<T> {

	void saveOrUpdate(T entity);

	T get(int id);

	boolean delete(int id);

	List<T> getAll();

	void removeAll();

}
