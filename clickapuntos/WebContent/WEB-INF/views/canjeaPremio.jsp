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
				<center><span>Canjea tu premio</span></center>
			</div>
		</div>
		<div class="modal_content">
			<form:form method="POST" commandName="ru" onsubmit="return Validate();" name="formulario">
			<center>
			<br/>
			<img  src="images/nuevoLogoClickapuntos.png">
			<br/>
			<br/>
			</center>

			<div class="content_premio_imagen">
				<img alt="${nombrePremio }" src="../${rutaImagenesPremios }${urlImagen }"
				 width="300px" height="240px">
			</div>
			<div class="content_premio_contenido">
				<p>Felicidades <span>${nombreUsuario }</span>,estas a unos pasos de canjear: ${nombrePremio }</p><br>
					<a href="">Terminos y condiciones</a>
			</div>
			<div class="content_premio_aceptar">
				<div class="content_premio_aceptar_izq">
					<form:checkbox path="condiciones"/> <span>Acepto</span>
				</div>
				<div class="content_premio_aceptar_der">
					<input type="image" src="<%=basePath %>/images/centro_c/canjear.png"/>
					<a href="javascript:closeVentana();">
						<img src="<%=basePath %>/images/perfilUser/cancelar.png"/>
					</a>
				</div>
			</div>
			</form:form>
		</div>
	</div>
</body>
</html>