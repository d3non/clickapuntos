<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<!-- HTML CHUNK TO BE SECURED -->

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
xmlns:og="http://ogp.me/ns#"
xmlns:fb="http://www.facebook.com/2008/fbml"
xmlns:fb="http://ogp.me/ns/fb#">

<head>
    <base href="<%=basePath%>"/>

    <meta name="Description" content="Clickapuntos"/>

	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
	
	<meta name="google-site-verification" content="+nxGUDJ4QpAZ5l9Bsjdi102tLVC21AIh5d1Nl23908vVuFHs34="/>
	
	<title>Clickapuntos</title>
	<link rel="shortcut icon" href="images/favicon.ico" >
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

  	<script type="text/javascript">
 
	 var _gaq = _gaq || [];
	 _gaq.push(['_setAccount', 'UA-33389705-1']);
	 _gaq.push(['_trackPageview']);
	
	 (function() {
	   var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
	   ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
	   var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
	 })();
	 $(document).ready(function() {
		 if('${user}'!=""){
				if('${user.usremail}'==""){
					tb_show(null,'userRegistroEmail.htm?keepThis=true&TB_iframe=true&height=150&width=400',null);		
				}
			}
	 });
	</script>
  </head>
  
  <body>
  	<c:if test="${mensajeExito!=null }">
		<script>
			alert('${mensajeExito}');
			closeVentana();
		</script>
	</c:if>
	<div class="container">
    	<!-- INIT HEADER -->
    	<div class="header">
            <div class="header_user_bar">
                <ul>
                    <li><div class="header_salir"></div> <a href="<c:url value="/cerrarSesion.htm?url="/>">Salir</a></li>
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
                	<li><a href="">Inicio</a></li>
                    <li><a href="<c:url value="/videos.htm"/>">Videos</a></li>
                    <li><a a href='javascript:openVentana("<%=basePath %>comofunciona.htm")'>Como funciona</a></li>
                </ul>
            </div>
            <div class="header_logo">
            	<a href=""><img src="images/nuevoLogoClickapuntos.png"></img></a>
            </div>
        </div>
    	<!-- END HEADER -->
     <!-- CONTENEDOR DE PERFIL DE USUARIO -->
    <div class="perfil_user_content">
        <!-- IZQUIERDO CONTENIDO -->
        <div class="perfil_user_content_left">
        	<!-- CAMBIO DE PAGINAS -->
        	<div class="perfil_user_content_izq_page">
        			<a href="<c:url value="/perfilUser.htm"/>"><img src="<c:url value="/images/centro_c/izq_p.png"/>" /></a>
        			<img src="<c:url value="/images/centro_c/der_p.png"/>" />
        	</div>
        	<br>
        	<div class="perfil_user_content_izq_canje">
        		<div class="perfil_user_content_izq_canje_imagen"></div>
        		<div class="perfil_user_content_izq_page_sube">
        				<span>Tienes ${numTotal} puntos</span>
        		</div>
        	</div>        	
        	<br>
        	<div class="perfil_user_content_izq_tipo_canje">
				<a href="<c:url value="/centroCanje.htm?idTipo=1"/>"><img src="<c:url value="/images/recargas.png"/>" /></a>
				<a href="<c:url value="/centroCanje.htm?idTipo=2"/>"><img src="<c:url value="/images/iTunes.png"/>" /></a>					
        	</div>
        	
        	<div class="perfil_user_content_izq_premios">
        		<c:forEach items="${premios}" var="premiosAll">
        			<c:if test="${(premiosAll.idTipoPremios=='1') or (premiosAll.idTipoPremios=='2')}">
        			<div class="perfil_user_content_izq_premios_content">
        				<div class="perfil_user_content_izq_premios_content_top">
        					<div class="perfil_user_content_izq_premios_content_top_cliente">
        						<img alt="${premiosALL.imgCliente }" src="../${rutaImagenesClientes }${premiosAll.imgCliente }" 
        							width="60px" height="45px">
        					</div>
        					<div class="perfil_user_content_izq_premios_content_top_descripcion">
        						<span>${premiosAll.nombrePremio }</span>
        						<br/>
        						<br/>
        						<div class="perfil_user_content_izq_canje_imagen2"></div> 
	        						<c:choose>
	        							<c:when test="${premiosAll.puntosFaltantes!=null }">
	        								<p>Te faltan ${premiosAll.puntosFaltantes } puntos</p>
	        							</c:when>
	        							<c:otherwise>
	        								<p>${premiosAll.totalPuntos } puntos</p>
	        							</c:otherwise>
	        						</c:choose>
        					</div>
        				</div>
        				<div class="perfil_user_content_izq_premios_content_down">
        					<img alt="${premiosAll.nombrePremio }" src="../${rutaImagenesPremios }${premiosAll.imgPremio }" 
        						width="300px" height="250px">
        						<c:if test="${user.usrcelular != null }">
        							<c:if test="${ (premiosAll.puntosFaltantes == null) }">
		        							<div class="canjea_puntos">
		        								<c:choose>
			        								<c:when test="${premiopendiente!=null}">
				        								<c:if test="${premiopendiente == premiosAll.idPremio}">
				        									<a href="<c:url value="/premios/${premiosAll.idPremio }/${premiosAll.idTipoPremios }.htm?&keepThis=true&TB_iframe=true&height=300&width=400"/>" class="thickbox">
			       												<img src="<c:url value="/images/centro_c/canjear.png"/>" />
			       											</a>
			       										</c:if>
			       									</c:when>
			       									<c:otherwise>
		    											<c:if test="${user.tipoplan!='2'}">
			    											<a href="<c:url value="/premios/${premiosAll.idPremio }/${premiosAll.idTipoPremios }.htm?&keepThis=true&TB_iframe=true&height=300&width=400"/>" class="thickbox">
			    												<img src="<c:url value="/images/centro_c/canjear.png"/>" />
			    											</a>
		    											</c:if>
		    											<c:if test="${ (user.tipoplan=='2') and (premiosAll.idTipoPremios=='2') }">
			    											<a href="<c:url value="/premios/${premiosAll.idPremio }/${premiosAll.idTipoPremios }.htm?&keepThis=true&TB_iframe=true&height=300&width=400"/>" class="thickbox">
			    												<img src="<c:url value="/images/centro_c/canjear.png"/>" />
			    											</a>
		    											</c:if>		    											
			       									</c:otherwise>
			       								</c:choose>
		       								</div>
       								</c:if>
       						</c:if>
        				</div>
        			</div>
        			
        			</c:if>
        		</c:forEach>
        	</div>
        </div>
        <!-- DERECHO PUBLICIDAD-->
        <div class="perfil_user_content_rigth">
        	<br>
        </div>
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
                	<li><a href="">Inicio</a></li>
                    <li><a href="<c:url value="/videos.htm"/>">Videos</a></li>
                    <li><a a href='javascript:openVentana("<%=basePath %>comofunciona.htm")'>Como funciona</a></li>
                    <li><a href="mailto:contacto@clickapuntos.com?subject=Información para publicitar mi marca">Contacto</a></li>
                </ul>
                <ul>
					<li><a href='javascript:openVentana("<%=basePath %>registroUser.htm?urlShow=condiciones")'>Políticas de uso y privacidad</a></li>
                </ul>
                <p>&copy; 2011 clickapuntos.com Todos los derechos reservados</p>
            </div>
        	<div class="footer_right">
            	<div class="footer_right_twitter">
                    <a href="https://twitter.com/Clickapuntos" class="twitter-follow-button" data-show-count="false" data-lang="en" data-size="large" data-show-screen-name="false">Seguir a @Clickapuntos</a>
						<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src="//platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>
                	<img src="<c:url value="/images/clicka_social_media.jpg"/>" alt="Clicka Social" />
                </div>
                <script>(function(d, s, id) {
						  var js, fjs = d.getElementsByTagName(s)[0];
						  if (d.getElementById(id)) return;
						  js = d.createElement(s); js.id = id;
						  js.src = "//connect.facebook.net/en_GB/all.js#xfbml=1&appId=333050033446083";
						  fjs.parentNode.insertBefore(js, fjs);
						}(document, 'script', 'facebook-jssdk'));
                </script>
                
            	<div class="footer_right_facebook">
					<fb:like href="http://www.facebook.com/Clickapuntos" width="450" height="80" show_faces="true"/>
            	</div>
             </div>
        </div>
    </div>
    <!-- END FOOTER -->
    
</body>
</html>