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
    <link type="text/css" rel="stylesheet" href="css/clicka_videos.css"/>
    <link type="text/css" rel="stylesheet" href="css/userPerfil.css"/>
    <script >
				function Validate()
				  {
					 var image =document.getElementById("image").value;
					 if(image!=''){
						  var checkimg = image.toLowerCase();
						  if (!checkimg.match(/(\.jpg|\.png|\.JPG|\.PNG|\.jpeg|\.JPEG)$/)){
							  alert("Favor de introducir archivos con las siguientes extenciones: .jpg,.png,.jpeg");
							  document.getElementById("image").focus();
							  return false;
						    }
						 }
					 return true;
				 }
				function closeVentana() {
					window.parent.tb_remove(true);
				} 
</script>
</head>
<body>
<c:if test="${mensajeExito!=null }">
	<script>
		alert('${mensajeExito}');
		window.parent.location.reload(); 
		window.parent.actualizaDatos();
		closeVentana();
	</script>
</c:if>
<div class="modalF">
	<div class="modalF_tittle">
		<div class="modalF_tittle_s">
			<center><span>Foto Usuario</span></center>
		</div>
	</div>
	<div class="modalF_content">
		<form:form method="POST" commandName="uploadItem" enctype=
		"multipart/form-data" onsubmit="return Validate();">
			<table>
				<tr>
					<td class="perfil_user_content_izq_form_otros_left_campo1">
						Nueva foto
					</td>
					<td>
						<div class="perfil_user_content_izq_form_campof3">
							<input name="fileData" id="image" type="file" />
						</div>
					</td>
				</tr>
				<tr>
					<td><br/></td>
					<td><form:errors path="fileData" cssClass="error"/></td>
				</tr>
			</table>
			<center>
				<input type="image" src="images/perfilUser/guardar2.png"/>
				<a href="" onClick="javascript:closeVentana();">
					<img src="images/perfilUser/cancelar2.png"/>
				</a>
			</center>
		</form:form>
		</div>
	</div>
    </body>
</html>