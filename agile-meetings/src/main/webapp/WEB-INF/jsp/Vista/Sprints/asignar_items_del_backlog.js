$(document).ready(function()
{
	cargar_items_backlog("${sprint.proyecto.id}");
});
/**
 * Consulta con el sistema que items hay en el product backlog de este proyecto.
 * @param proyecto_id
 * @returns
 */
function cargar_items_backlog(proyecto_id)
{
	var prefijoPath="${pageContext.request.contextPath}";
	var url=prefijoPath+"/backlog/listar_ajax/"+proyecto_id;
	// Para cada uno, pido un json
	$.getJSON(url,
	{
	},
	function(items)
	{
		var pick = $("#pickList").pickList(
				{
					data: items,
					leftTitle: "Product Backlog",
					rightTitle: "Este Sprint"
				});

		$("#asignarItems").click(function () 
		{
			console.log(pick.getValues());
		});
	});
}