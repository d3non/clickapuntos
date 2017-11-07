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
	<div class="modalL">
<!--  	<div class="modalL_tittle">
		<div class="modalL_tittle">
			<center><span>Registro Usuario</span></center>
		</div>
	</div>
		-->
	<div class="modalL_content">
    <center>
    <form:form method="POST" commandName="registroUser">
		<br/>
		<img  src="images/nuevoLogoClickapuntos.png">
		<br/>
		<br/>

	<table>

		<tr>
			<td colspan="2" width="310px" class="perfil_user_content_izq_form_otros_left_campo1">
      				Correo Electr&oacute;nico* <form:errors path="email" cssClass="error" />
			</td>
		
			<td colspan="2" width="310px" class="perfil_user_content_izq_form_otros_left_campo1">
      				Nickname* <form:errors path="nickname" cssClass="error" />
			</td>
		</tr>
		<tr>
			<td colspan="2" width="310px">
      				<div class="perfil_user_content_izq_form_campof">
      					<form:input path="email"/>
      				</div>
			</td>
			<td colspan="2" width="310px">
      				<div class="perfil_user_content_izq_form_campof">
      					<form:input path="nickname"/>
      				</div>
			</td>
		</tr>

	    <tr>
     		<td colspan="2" width="310px" class="perfil_user_content_izq_form_otros_left_campo1">
     				<br/>
     				Password*<form:errors path="password" cssClass="error" />
     				<br/>
			</td>
			<td colspan="2" width="310px" class="perfil_user_content_izq_form_otros_left_campo1">
     				<br/>
     				Confirma Password*<form:errors path="passwordCheck" cssClass="error" />
     				<br/>
			</td>
		</tr>
		<tr>
       		<td colspan="2" width="310px">
       			<div class="perfil_user_content_izq_form_campof">
       				<form:password path="password" />
       			</div>
       			<br>
       			<form:errors path="password" cssClass="error2" />
       		</td>
       		
       		<td colspan="2" width="310px">
       			<div class="perfil_user_content_izq_form_campof">
       				<form:password path="passwordCheck" />
       			</div>
       			<br>
       			<form:errors path="passwordCheck" cssClass="error2" />
       		</td>
		</tr>

		<tr>
			<td><br/></td>
			<td><form:errors path="condiciones" cssClass="error" /></td>
			<td><form:errors path="captcha" cssClass="error" /> </td>
		</tr>
	</table>

	<script type="text/javascript"
	    src="http://api.recaptcha.net/challenge?k=6LehcdgSAAAAAFKaIk1cCXwJsvRW4yWhUlaYnEUF">
	</script>
	<noscript>
	    <iframe src="http://api.recaptcha.net/noscript?k=6LehcdgSAAAAAFKaIk1cCXwJsvRW4yWhUlaYnEUF"
	        height="300" width="500" frameborder="0"></iframe><br>
	    <textarea name="recaptcha_challenge_field" rows="3" cols="40">
	    </textarea>
	    <input type="hidden" name="recaptcha_response_field" value="manual_challenge">
	</noscript>


    <br/>
    <br/>        
	<center class="perfil_user_content_izq_form_otros_left_campo3"><form:checkbox path="condiciones" /><a href="<c:url value="/registroUser.htm?urlShow=condiciones&keepThis=true&TB_iframe=true&height=520&width=600"/>">Términos y condiciones</a></center>
	<br>
	<center><input type="image" src="images/perfilUser/guardar2.png"/>
	<a href="" onClick="javascript:closeVentana();"><img src="images/perfilUser/cancelar2.png"/></a></center>
	</form:form>
	</center>
	</div>
	</div>
 </body>
</html>