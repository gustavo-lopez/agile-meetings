package agilemeetings.dao.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import agilemeetings.dao.PersonaDAO;
import agilemeetings.model.Persona;

@Repository
public class PersonaDAOImpl implements PersonaDAO
{
	static Logger log = Logger.getLogger(PersonaDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Persona getById(int id) 
	{
		log.trace("Estoy en PersonaDAOImpl.getById, id pedido:"+id);
		return (Persona) sessionFactory.getCurrentSession().createQuery("from Persona where id="+id).getSingleResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> listarPersonas() 
	{
		log.trace("Estoy en PersonaDAOImpl.listarPersonas");
		return (List<Persona>) sessionFactory.getCurrentSession().createQuery("from Persona").getResultList();
	}

	@Override
	@Transactional
	public void agregar(Persona persona) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(persona);
	}

	@Override
	public void grabar(Persona persona) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(persona);
	}
}
