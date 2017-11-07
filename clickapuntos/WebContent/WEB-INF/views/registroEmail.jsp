<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <META http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>Registro Usuario</title>
    <link type="text/css" rel="stylesheet" href="css/clicka_videos.css"/>
    <link type="text/css" rel="stylesheet" href="css/userPerfil.css"/>
    <script>
    	function closeVentana(){
    		window.parent.tb_remove(true);
    	}
    </script>
    </head>
<body>
<c:if test="${mensajeExito!=null }">
	<script>
		alert('${mensajeExito}');
		closeVentana();
	</script>
</c:if>
	<div class="modal">
	<div class="modal_tittle">
		<div class="modal_tittle_s">
			<center><span>Confirma tu email</span></center>
		</div>
	</div>
	<div class="modal_content">
    <form:form method="POST" commandName="registroUser">
	<table>
		<tr>
			<td class="perfil_user_content_izq_form_otros_left_campo1">
				Email*
			</td>
			<td>
				<div class="perfil_user_content_izq_form_campof">
					<form:input path="email"/>
				</div>	
			</td>
		</tr>
		<tr>
			<td><br/></td>
			<td><form:errors path="email" cssClass="error" /></td>
		</tr>
	</table>
	<center><input type="image" src="images/perfilUser/guardar2.png"/>
	<a href="" onClick="javascript:closeVentana();"><img src="images/perfilUser/cancelar2.png"/></a></center>
	</form:form>
	</div>
	</div>
 </body>
</html>