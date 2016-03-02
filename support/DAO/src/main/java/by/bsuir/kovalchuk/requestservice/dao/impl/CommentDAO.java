package by.bsuir.kovalchuk.requestservice.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import by.bsuir.kovalchuk.requestservice.dao.RequestServiceDAO;
import by.bsuir.kovalchuk.requestservice.model.Comment;

@Repository("commentDAO")
public class CommentDAO extends HibernateDaoSupport implements
		RequestServiceDAO<Comment> {

	@Override
	public void saveOrUpdate(Comment entity) {
		getHibernateTemplate().save(entity);
	}

	@Override
	public Comment get(int id) {
		return getHibernateTemplate().get(Comment.class, id);
	}

	@Override
	public boolean delete(int id) {
		Comment comment = getHibernateTemplate().get(Comment.class, id);
		if (comment != null) {
			getHibernateTemplate().delete(comment);
			return true;
		}
		return false;
	}

	@Override
	public List<Comment> getAll() {
		return getHibernateTemplate().loadAll(Comment.class);
	}

	@Override
	public void removeAll() {
		List<Comment> commentyees = getHibernateTemplate().loadAll(
				Comment.class);
		getHibernateTemplate().deleteAll(commentyees);
	}
}
