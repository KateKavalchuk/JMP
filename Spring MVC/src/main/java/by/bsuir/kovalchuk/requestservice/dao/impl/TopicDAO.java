package by.bsuir.kovalchuk.requestservice.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import by.bsuir.kovalchuk.requestservice.dao.RequestServiceDAO;
import by.bsuir.kovalchuk.requestservice.model.Topic;

@Repository("topicDAO")
public class TopicDAO extends HibernateDaoSupport implements
		RequestServiceDAO<Topic> {

	@Override
	public void saveOrUpdate(Topic entity) {
		getHibernateTemplate().save(entity);
	}

	@Override
	public Topic get(int id) {
		return getHibernateTemplate().get(Topic.class, id);
	}

	@Override
	public boolean delete(int id) {
		Topic topic = getHibernateTemplate().get(Topic.class, id);
		if (topic != null) {
			getHibernateTemplate().delete(topic);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Topic> getAll() {
		return getHibernateTemplate().loadAll(Topic.class);
	}

	@Override
	public void removeAll() {
		List<Topic> topics = getHibernateTemplate().loadAll(Topic.class);
		getHibernateTemplate().deleteAll(topics);
	}
}
