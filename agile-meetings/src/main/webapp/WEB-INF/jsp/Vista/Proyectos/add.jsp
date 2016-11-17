<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<script type="text/javascript">
<%@include file="/WEB-INF/jsp/Vista/Proyectos/buscar_miembros_roles.js" %>
</script>

<h1>Nuevo Proyecto</h1>

<form:form method="post" action="add" commandName="proyecto">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<tiles:insertAttribute name="form_proyecto"/>
	<input type="submit" name="agregar_proyecto" value="Agregar Proyecto">
</form:form>