<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<form:form method="post" action="edit" commandName="proyecto">
	<form:input id="ProyectoId" class="form-control" path="id"/>
	<tiles:insertAttribute name="form_proyecto"/>
	<input type="submit" name="editar_proyecto" value="Editar Proyecto">
</form:form>