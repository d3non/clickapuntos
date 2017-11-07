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
		function Validate()
		  {
			if(document.formulario.condiciones.checked) {
				return true;
			}
			else{
				alert('No has aceptado las condiciones');
				return false;
			}
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
	<div class="modal2">
		<div class="modal_tittle">
			<div class="modal2_tittle_s">
				<center><span>${titulo }</span></center>
			</div>
		</div>
		<form action="" method="POST">
		<div class="modal_content_monetarios">
			
				<table>
					<c:forEach items="${premios}" var="premiosAll">
						<c:if test="${premiosAll.idTipoPremios==idTipoPremios and premiosAll.puntosFaltantes==null }">
							<tr>
								<td class="perfil_user_content_izq_form_otros_left_campo1">
									<c:choose>
										<c:when test="${checked==null }">
											<input type="radio" name="opcion" value="${premiosAll.idPremio }" checked>$ ${premiosAll.cantidad }
											<c:set var="checked" value="true" />
										</c:when>
										<c:otherwise>
											<input type="radio" name="opcion" value="${premiosAll.idPremio }" >$ ${premiosAll.cantidad }
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</c:if>
					</c:forEach>
				</table>
		</div>
		<center>
			<c:if test="${checked!=null }">
				<input type="image" src="<c:url value="/images/centro_c/cangear.png"/>" />
			</c:if>
			<a href="javascript:closeVentana()"><img src="<c:url value="/images/perfilUser/cancelar.png"/>" /></a>
		</center>
		</form>
	</div>
</body>
</html>