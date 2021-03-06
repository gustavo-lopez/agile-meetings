package agilemeetings.dao.hibernate;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import agilemeetings.dao.ProductBacklogDAO;
import agilemeetings.model.ProductBacklogItem;

@Repository
public class ProductBacklogDAOImpl implements ProductBacklogDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ProductBacklogItem getItemById(int id) 
	{
		ProductBacklogItem b=(ProductBacklogItem) sessionFactory.getCurrentSession().createQuery("from ProductBacklogItem where id="+id).getSingleResult();
		Hibernate.initialize(b.getProyecto());
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBacklogItem> getItems(int proyecto_id) 
	{
		return (List<ProductBacklogItem>) sessionFactory.getCurrentSession().createQuery("from ProductBacklogItem").getResultList();
	}

	@Override
	public void save(ProductBacklogItem backlogItem)
	{
		sessionFactory.getCurrentSession().save(backlogItem);
	}
	@Override
	@Transactional
	public void update(ProductBacklogItem backlogItem) 
	{
		sessionFactory.getCurrentSession().merge(backlogItem);
	}

	@Override
	public void delete(ProductBacklogItem backlogItem) 
	{
		sessionFactory.getCurrentSession().delete(backlogItem);
	}
}
