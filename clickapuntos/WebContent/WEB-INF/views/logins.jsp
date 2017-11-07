<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
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
		function closeVentana() {
			window.parent.tb_remove(true);
		} 
		function openVentana(url){
			window.parent.location=url;
			closeVentana();
		}
		function actualizaVentana(url){
			window.parent.location=url;
			closeVentana();
		}
	</script>
</head>
<body>

	<div id="fb-root"></div>
	<script>(function(d, s, id) {
	  var js, fjs = d.getElementsByTagName(s)[0];
	  if (d.getElementById(id)) return;
	  js = d.createElement(s); js.id = id;
	  js.src = 'https://connect.facebook.net/es_LA/sdk.js#xfbml=1&version=v2.10&appId=333050033446083';
	  fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));
	</script>

<c:if test="${exito!=null }">
	<script>
		actualizaVentana('${urlAnt}');
	</script>
</c:if>
<div class="modalL">
	<div class="modalL_content">
		<center>
		<form:form method="POST" commandName="logginUser">
		
		<div class="logueo_paginas">
		
		<img  src="images/nuevoLogoClickapuntos.png">

		<br>
		<br>
        <p class="perfil_user_content_izq_form_otros_left_campo1">
			Inicia sesión ó regístrate con tu cuenta de
		</p>

		<br>
		<div class="fb-login-button" data-max-rows="1" data-size="large" data-button-type="continue_with" data-show-faces="false" 
		data-auto-logout-link="false" data-use-continue-as="false"></div>
		<!--div class="logueo_paginas">
			<a href="javascript:openVentana('${logginUser.urlFacebook }')"><img width="80px" height="80px" src="images/facebook-login.png"></a>
			<a href="javascript:openVentana('${logginUser.urlTwitter }')"><img width="80px" height="80px" src="images/twitter-login.png"></a>
		</div-->



		<br>
		<p class="perfil_user_content_izq_form_otros_left_campo1">
			O si lo prefieres inicia sesión con tu cuenta de Clickapuntos
		</p>
		<br>
		<table>
        	<tr>
        		<td class="perfil_user_content_izq_form_otros_left_campo1">Email*</td>
        		<td>
        			<div class="perfil_user_content_izq_form_campof">
        				<form:input path="userEmail"/>
        			</div>
        			<br>
        			<form:errors path="userEmail" cssClass="error2" />
        		</td>
        	</tr>
        	<tr>
        		<td class="perfil_user_content_izq_form_otros_left_campo1">Password*</td>
        		<td>
        			<div class="perfil_user_content_izq_form_campof">
        				<form:password path="userPassword" />
        			</div>
        			<br>
        			<form:errors path="userPassword" cssClass="error2" />
        		</td>
        	</tr>
        </table>
        <input type="image" src="<c:url value="/images/perfilUser/iniciaSesion.png"/>"/><br><br>
        <p class="perfil_user_content_izq_form_otros_left_campo1">
			¿Aun no estas registrado?,
			<a href="<c:url value="/registroUser.htm?urlShow=registro&keepThis=true&TB_iframe=true&height=520&width=600"/>">regístrate aqu&iacute;</a>
<!--  			<a href="javascript:window.parent.tb_show(null,'registroUser.htm?keepThis=true&TB_iframe=true&height=520&width=625',null);">
				<span>registrate aqu&iacute;</span>-->
			</a>
		</p>
		<br>
		<br>
		</div>
		
        </form:form>
		</center>
	</div>
	</div>
    </body>
</html>