<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Product Backlog del proyecto <c:out value="${proyecto.nombre}"/></h2>

<p>
<a href="${pageContext.request.contextPath}/backlog/${proyecto.id}/add">Nuevo Backlog Item</a>
</p>

<table>
<tr>
<th>Id</th>
<th>Fecha Creaci&oacute;n</th>
<th>Descripci&oacute;n</th>
<th>Estado</th>
<th>Acciones</th>
</tr>
<c:forEach items="${backlog_items}" var="item">
<tr>
<td><c:out value="${proyecto.id}"/></td>
<td>${item.fecha_creacion}</td>
<td>${item.descripcion}</td>
<td>${estado.estado.nombre}</td>
<td><a href="${pageContext.request.contextPath}/backlog/edit/${item.id}">Editar</a></td>
</tr>
</c:forEach>
</table>