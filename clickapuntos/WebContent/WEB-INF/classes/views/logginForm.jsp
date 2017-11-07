<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<link type="text/css" rel="stylesheet" href="<c:url value="/css/clicka_videos.css"/>"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>My JSP 'kia.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<!--
<link rel="stylesheet" type="text/css" href="styles.css">
-->
  </head>
  
  <body>
	<div class="container">
    	<!-- INIT HEADER -->
    	<div class="header">
            <div class="header_user_bar">
                <ul>
                    <li><div class="header_salir"></div> <a href="#">Salir</a></li>
                    <li><div class="header_perfil"></div> <a href="#">Perfil</a></li>
                    <li><div class="header_puntos"></div> <a href="#">5,421</a></li>
                </ul>
            </div>
        	<div class="header_menu">
            	<ul>
                	<li><a href="#">INICIO</a></li>
                    <li><a href="#">CONCURSOS</a></li>
                    <li><a href="#">COMO FUNCIONA</a></li>
                    <li><a href="#">ACERCA DE</a></li>
                    <li><a href="#">CONTACTO</a></li>
                </ul>
            </div>
            <div class="header_logo">
            	<a href="#"></a>
            </div>
        </div>
    	<!-- END HEADER -->
        
    <div class="column_detalle_left">
        	
        <!-- END COLUMN RIGHT -->
        <form:form method="POST" commandName="logginUser">
        <table>
        	
        	<tr>
        		<td>Email*</td>
        		<td><form:input path="userEmail"/></td>
        		<td><form:errors path="userEmail" cssClass="error" /></td>
        	</tr>
        	<tr>
        		<td>Password*</td>
        		<td><form:password path="userPassword" /></td>
				<td><form:errors path="userPassword" cssClass="error" /></td>
        	</tr>
        	<tr>
				<td colspan="3"><input type="submit" value="Iniciar Sesion"></td>
			</tr>
        </table>
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
                	<li><a href="#">INICIO</a></li>
                	<li><a href="#">CONCURSOS</a></li>
                	<li><a href="#">COMO FUNCIONA</a></li>
                	<li><a href="#">ACERCA DE</a></li>
                	<li><a href="#">CONTACTO</a></li>
                </ul>
                <ul>
                	<li><a href="#">Empresa</a></li>
                	<li><a href="#">Términos y condiciones</a></li>
                	<li><a href="#">Privacidad</a></li>
                </ul>
                <p>©2011 ClickaPuntos.com.mx Todos los derechos reservados</p>
            </div>
        	<div class="s">
            	<div class="footer_right_twitter">
                    <div class="footer_right_twitter_content">
                    	<a href="#"><img src="images/clicka_twitter.png" alt="Twitter" /></a>
                    </div>
                    <div class="footer_clicka_social_logo"></div>
                </div>
            	<div class="footer_right_facebook">
                    <a href="#"><img src="images/clicka_facebook.png" alt="Facebook" /></a>
                	Click a Puntos
                </div>
                <div class="footer_right_social_media">
                	<img src="images/clicka_person_1.jpg" alt="Media" />
                	<img src="images/clicka_person_2.jpg" alt="Media" />
                	<img src="images/clicka_person_3.jpg" alt="Media" />
                	<img src="images/clicka_person_4.jpg" alt="Media" />
                	<img src="images/clicka_person_5.jpg" alt="Media" />
                	<img src="images/clicka_person_6.jpg" alt="Media" />
                	<img src="images/clicka_person_7.jpg" alt="Media" />
                </div>
            </div>
        </div>
    </div>
    <!-- END FOOTER -->
</body>
</html>