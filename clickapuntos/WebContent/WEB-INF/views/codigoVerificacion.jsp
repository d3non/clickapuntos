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
        <title>Upload Example</title>
  	<link type="text/css" rel="stylesheet" href="<%=basePath %>/css/clicka_videos.css"/>
    <link type="text/css" rel="stylesheet" href="<%=basePath %>/css/userPerfil.css"/>
    <script >
		function closeVentana() {
			window.parent.tb_remove(true);
		} 
		function openVentana(url){
			window.parent.location=url;
			closeVentana();
		}
	</script>
</head>
<body>
	<c:if test="${mensajeExito!=null }">
		<script>
			alert('${mensajeExito}');
			window.parent.location.reload(); 
			closeVentana();
		</script>
	</c:if>

<div class="modal">
	<div class="modal_tittle">
		<div class="modal_tittle_s">
			<center><span>Verificando código SMS...</span></center>
		</div>
	</div>
	<div class="modal_content">
		<form:form method="POST" commandName="verificaMensaje">
		<center>
		<br/>
		<img  src="<%=basePath %>/images/nuevoLogoClickapuntos.png">
		<br/>
		<br/>
		
		<table>
			<tr>
				<td class="perfil_user_content_izq_form_otros_left_campo1">
					Por favor ingresa el c&oacute;digo de verificación enviado<br>por SMS a tu celular...
				</td>
			</tr>
			<tr>
				<td>
					<center>
					<div  class="perfil_user_content_izq_form_campof">
						<form:input path="mensaje"/>
					</div>
					</center>
				</td>
			</tr>
			<tr>
				<td>
					<center>
						<form:errors path="mensaje" cssClass="error2"/>
					</center>
				</td>
			</tr>
		</table>
		<c:if test="${verificaMensaje.contador<2 }">
			<a href="../reenviarMensaje.htm?idMensaje=${verificaMensaje.idMensaje }&idPremio=${idPremio}" 
				class="reeenviar_mensaje_canje">¿No recibiste tu código SMS?, ¡haz click aquí para enviártelo nuevamente!</a><br><br>
		</c:if>
			<input type="image" src="<%=basePath %>/images/perfilUser/aceptar.png"/>
			<a href="javascript:closeVentana();">
				<img src="<%=basePath %>/images/perfilUser/cancelar2.png"/>
			</a>
		</center>
		</form:form>
	</div>
	</div>
    </body>
</html>