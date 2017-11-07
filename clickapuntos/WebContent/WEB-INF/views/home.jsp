<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
xmlns:og="http://ogp.me/ns#"
xmlns:fb="http://www.facebook.com/2008/fbml"
xmlns:fb="http://ogp.me/ns/fb#">

<head>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<base href="<%=basePath%>"/>
<meta name="Description" content="Clickapuntos"/>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
<meta name="google-site-verification" content="+nxGUDJ4QpAZ5l9Bsjdi102tLVC21AIh5d1Nl23908vVuFHs34="/>

<title>Clickapuntos</title>

<link rel="shortcut icon" href="images/favicon.ico" >
<meta name="robots" content="noindex,nofollow"/>

<link type="text/css" rel="stylesheet" href="<c:url value="/css/clicka_videos.css"/>"/>
<link type="text/css" rel="stylesheet" href="<c:url value="/css/thickbox.css"/>" />
<script type="text/javascript">
 
  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-33389705-1']);
  _gaq.push(['_trackPageview']);
 
  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();
 
</script>
</head>
<body >

	<c:if test="${mensaje!=null }">
		<script>
			alert('${mensaje}');
		</script>
		<% HttpSession sesion=request.getSession();
			String mensaje=(String) sesion.getAttribute("mensaje");
			if(mensaje!=null){
				mensaje=null;
				sesion.setAttribute("mensaje", mensaje);
			}
		%>
	</c:if>
	<div class="container">
    	<!-- INIT HEADER -->
    	<div class="header">
            <div class="header_user_bar">
                <ul>
                    <li>
                    <div class="header_iniciaSesion"></div>
	                   	<a href="<c:url value="/logginForm.htm?urlShow=logins&keepThis=true&TB_iframe=true&height=520&width=620"/>" class="thickbox">Inicia Sesión o Regístrate</a>		
					</li>
                    <li> <span>Bienvenidos</span></li>
                </ul>
            </div>
        	<div class="header_menu">
            	<ul>
                	<li><a href="">Inicio</a></li>
                    <li><a href="<c:url value="/videos.htm"/>">Videos</a></li>
                    <li><a href='javascript:openVentana("<%=basePath %>comofunciona.htm")'>Como funciona</a></li>
                    <li><a href="mailto:contacto@clickapuntos.com?subject=Información para publicitar mi marca">Contacto</a></li>
                </ul>
            </div>
            <div class="header_logo">
            	<a href=""><img src="images/nuevoLogoClickapuntos.png"></img></a>
            </div>
        </div>
        <!-- END HEADER -->
        <div >
        	<table width="960px" border="0px" background="images/home/titulohome.png">
        		<tr >
        			<td width="760px" class="home_titulo_content" height="76px">
        				Publicidad que recompensa...
        			</td>
        			<td width="200px" valign="middle" >
        			<!--  <a href="<c:url value="/registroUser.htm?urlShow=registro&keepThis=true&TB_iframe=true&height=520&width=600"/>" class="thickbox"> <img alt="Registrate" src="images/home/registrateHome.png"/></a> -->
        				<a href="<c:url value="/logginForm.htm?urlShow=logins&keepThis=true&TB_iframe=true&height=520&width=620"/>" class="thickbox"> <img alt="Registrate" src="images/home/registrateHome.png"/></a>
        			</td>
        			<td width="80px" height="76px">
        			</td>
        		</tr>
        	</table>
        </div>
        <!-- INIT SLIDER -->
        <div class="navi" id="navi"></div>
         <div class="slider_top"></div>
        
        <div class="slider">
        
          <div class="scrollable" id="chained" >   
                <div class="items">
                     <div class="slider_itemH">
                        <div class="slider_item_content">			
 							<span>Observa publicidad de tus marcas favoritas</span><br><br>
 							<p>
 								Diviértete viendo los videos de nuestros anunciantes y
 								entérate de las mejores promociones de tus marcas favoritas
 							</p>
                        </div>
                        <div class="slider_item_image">
                        	<img src="<c:url value="/images/Videos.fw.png"/>"/>
                        </div>
                    </div>
                    <div class="slider_itemH">
                        <div class="slider_item_content">			
 							<span>Acumula puntos por cada publicidad en que participes</span><br><br>
 							<p>
 								Además obtienes puntos por cada publicidad que veas con nosotros, 
 								olvida el clásico "Gracias por participar" y acumula miles de puntos!
 							</p>
                        </div>
                        <div class="slider_item_image">
                        	<img src="<c:url value="/images/Puntos.png"/>"/>
                        </div>
                    </div>
                	<div class="slider_itemH">
                        <div class="slider_item_content" >			
 							<span>Canjea tus puntos acumulados por grandes recompensas</span><br><br>
 							<p align="justify">
								Canjea todos tus puntos acumulados por GRANDES RECOMPENSAS como recargas electrónicas para tu celular!
 								¿Qué esperas?, regístrate, da clicks y acumula puntos!, SÍ sólo aquí en Clickapuntos!
 							</p>
                        </div>
                        <div class="slider_item_image">
                        	<img src="<c:url value="/images/Regalo.png"/>"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END SLIDER -->
        <!-- INIT COLUMN LEFT -->
        <div class="column_videos_left">
        	
        </div>
        <!-- END COLUMN LEFT -->
        
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
                    <li><a href='javascript:openVentana("<%=basePath %>comofunciona.htm")'>Como funciona</a></li>
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
    <script type="text/javascript" src='<c:url value="/js/jquery.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/js/jquery.tools.min.js"/>'></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.selectbox-0.6.1.js"/> "></script>
	<script type="text/javascript" src="<c:url value="/js/thickbox.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/videosAPI.js"/>"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		$("#chained").scrollable({circular: true, mousewheel: false}).navigator("#navi").autoscroll({
			interval: 9000
		});

		$("#awards_chained").scrollable({circular: true, mousewheel: false}).navigator("#awards_navi").autoscroll({
			interval: 9000
		});
	});	
	</script>
</body>
</html>