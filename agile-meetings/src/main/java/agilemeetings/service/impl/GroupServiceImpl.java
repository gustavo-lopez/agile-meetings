package agilemeetings.service.impl;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agilemeetings.dao.GroupDAO;
import agilemeetings.exceptions.GrupoExistenteException;
import agilemeetings.model.Group;
import agilemeetings.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService
{
	@Autowired
	private GroupDAO groupDAO;
	@Override
	public Group getById(long id) 
	{
		return groupDAO.findById(id);
	}
	@Override
	public void save(Group group) throws GrupoExistenteException
	{
        try
        {
        	groupDAO.save(group);
        }
        catch(ConstraintViolationException e)
        {
        	// Si se arroja esta excepcion, es porque el usuario ya existe.
        	// Convertirla en la excepcion UsuarioExistente
        	throw new GrupoExistenteException();
        }
	}
	@Override
	public List<Group> listGroups() 
	{
		return groupDAO.listAll();
	}
}
