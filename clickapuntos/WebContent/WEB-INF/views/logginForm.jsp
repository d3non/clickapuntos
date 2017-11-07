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
      <base href="<%=basePath%>"/>
	<meta name="Description" content="Clickapuntos"/>
	
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
	
	<meta name="google-site-verification" content="+nxGUDJ4QpAZ5l9Bsjdi102tLVC21AIh5d1Nl23908vVuFHs34="/>
	
	<title>Clickapuntos</title>
	
	<meta name="robots" content="noindex,nofollow"/>
	
<!--
<link rel="stylesheet" type="text/css" href="styles.css">
-->
	<link type="text/css" rel="stylesheet" href="<c:url value="/css/clicka_videos.css"/>"/>
	<link type="text/css" rel="stylesheet" href="<c:url value="/css/userPerfil.css"/>"/>
	<link type="text/css" rel="stylesheet" href="<c:url value="/css/thickbox.css"/>" />
	<script type="text/javascript" src='<c:url value="/js/jquery.js"/>'></script>
	<script type="text/javascript" src="<c:url value="/js/combo.js"/> "></script>
	<script type="text/javascript" src="<c:url value="/js/comboBox.js"/>"></script>	
	<script type="text/javascript" src="<c:url value="/js/thickbox.js"/>"></script>
  </head>
  
  <body>
  
	<div class="container">
    	<!-- INIT HEADER -->
    	<div class="header">
            <div class="header_user_bar">
                <ul>
                    <li><div class="header_salir"></div> <a href="">Salir</a></li>
                    <li><div class="header_perfil"></div> 
						<c:choose>
	                   		<c:when test="${user!=null }">
	                   			<a href="<c:url value="/perfilUser.htm"/>">${user.usrusername }</a>
	                   		</c:when>
	                   		<c:otherwise>
	                   			<a href="<c:url value="/logginForm.htm?urlShow=logins&keepThis=true&TB_iframe=true&height=380&width=400"/>" class="thickbox">Login</a>
	                   		</c:otherwise>
	                   	</c:choose>
					</li>
                     <c:if test="${user!=null }">
                    	<li><div class="header_puntos"></div> <span> ${numTotal }</span></li>
                    </c:if>
                </ul>
            </div>
        	<div class="header_menu">
            	<ul>
                	<li><a href="#">Inicio</a></li>
                    <li><a href="#">Concursos</a></li>
                    <li><a href="#">Como funciona</a></li>
                    <li><a href="#">Acerca de</a></li>
                    <li><a href="#">Contacto</a></li>
                </ul>
            </div>
            <div class="header_logo">
            	<a href=""><img src="images/nuevoLogoClickapuntos.png"></img></a>
            </div>
        </div>
    	<!-- END HEADER -->
        
    <div class="column_detalle_left">
        	
        <!-- END COLUMN RIGHT -->
        <form:form method="POST" commandName="logginUser">
        <table>
        	
        	<tr>
        		<td class="perfil_user_content_izq_form_otros_left_campo1">Email*</td>
        		<td>
        			<div class="perfil_user_content_izq_form_campof">
        				<form:input path="userEmail"/>
        			</div>
        		</td>
        		<td><form:errors path="userEmail" cssClass="error" /></td>
        	</tr>
        	<tr>
        		<td class="perfil_user_content_izq_form_otros_left_campo1">Password*</td>
        		<td>
        			<div class="perfil_user_content_izq_form_campof">
        				<form:password path="userPassword"/>
        			</div>
        		</td>
				<td><form:errors path="userPassword" cssClass="error" /></td>
        	</tr>
        	<tr>
				<td ><input type="image" src="<c:url value="/images/perfilUser/iniciaSesion.png"/>"/><br><br></td>
				
			</tr>
        </table>
        <center>
        <p class="perfil_user_content_izq_form_otros_left_campo1">
			¿Aun no estas registrado?
			<a href="javascript:window.parent.tb_show(null,'registroUser.htm?keepThis=true&TB_iframe=true&height=400&width=700',null);">
				<span>registrate aqu&iacute;</span>
			</a>
		</p>
		</center>
        </form:form>
    </div>
	</div>
    <!-- INIT FOOTER -->
    <div class="footer">
    	<div class="footer_container">
        	<div class="footer_left">
	        	<div class="footer_logo">
		            	<a href="#"></a>
	             </div>	
                <ul>
                	<li><a href="#">Inicio</a></li>
                    <li><a href="#">Concursos</a></li>
                    <li><a href="#">Como funciona</a></li>
                    <li><a href="#">Acerca de</a></li>
                    <li><a href="#">Contacto</a></li>
                </ul>
                <ul>
                	<li><a href="#">Empresa</a></li>
                	<li><a href="#">T&eacute;rminos y condiciones</a></li>
                	<li><a href="#">Privacidad</a></li>
                </ul>
                <p>&copy; 2011 clickapuntos.com Todos los derechos reservados</p>
            </div>
        	<div class="footer_right">
            	
            	<div class="footer_right_twitter">
                    <a href="https://twitter.com/Clickapuntos" class="twitter-follow-button" data-show-count="false" data-lang="es" data-size="large" data-show-screen-name="false">Seguir a @Clickapuntos</a>
						<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src="//platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>
                	<img src="<c:url value="/images/clicka_social_media.jpg"/>" alt="Clicka Social" />
                </div>
            	
            	<div class="fb-login-button" data-max-rows="1" data-size="large" data-button-type="continue_with" data-show-faces="false" data-auto-logout-link="false" data-use-continue-as="false"></div>

            	<div class="footer_right_facebook">
                    <div class="footer_right_facebook">
					<script>
					 	var urldir= location.protocol + "//" + location.host + location.pathname ;
						document.write('<div class="fb-like" data-href="'+urldir+'" data-send="false" data-width="292" data-show-faces="true"></div>');
					</script>
                </div>

                </div>
            </div>
        </div>
    </div>
    <!-- END FOOTER -->
</body>
</html>