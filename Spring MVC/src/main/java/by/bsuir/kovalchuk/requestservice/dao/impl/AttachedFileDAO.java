package by.bsuir.kovalchuk.requestservice.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import by.bsuir.kovalchuk.requestservice.dao.RequestServiceDAO;
import by.bsuir.kovalchuk.requestservice.model.AttachedFile;

@Repository("attachedFileDAO")
public class AttachedFileDAO extends HibernateDaoSupport implements
		RequestServiceDAO<AttachedFile> {

	@Override
	public void saveOrUpdate(AttachedFile entity) {
		getHibernateTemplate().save(entity);
	}

	@Override
	public AttachedFile get(int id) {
		return getHibernateTemplate().get(AttachedFile.class, id);
	}

	@Override
	public boolean delete(int id) {
		AttachedFile attachedFile = getHibernateTemplate().get(
				AttachedFile.class, id);
		if (attachedFile != null) {
			getHibernateTemplate().delete(attachedFile);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<AttachedFile> getAll() {
		return getHibernateTemplate().loadAll(AttachedFile.class);
	}

	@Override
	public void removeAll() {
		List<AttachedFile> attachedFiles = getHibernateTemplate().loadAll(
				AttachedFile.class);
		getHibernateTemplate().deleteAll(attachedFiles);
	}
}
