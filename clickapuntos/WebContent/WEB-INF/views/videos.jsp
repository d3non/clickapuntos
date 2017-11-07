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
		if('${user}'!=""){
			idUser='${user.idusuarios}';
			if('${user.usremail}'==""){
				tb_show(null,'userRegistroEmail.htm?keepThis=true&TB_iframe=true&height=150&width=400',null);		
			}
		}
		rutaImagenes='${rutaImagenesVideos}';
		addfilter('');
	});
	</script>

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
                    <li><div class="header_salir"></div> <a href="<c:url value="/cerrarSesion.htm?url=videos.htm"/>">Salir</a></li>
                    <li><div class="header_perfil"></div> 
                    	<c:choose>
                    		<c:when test="${user!=null }">
                    			<a href="<c:url value="/perfilUser.htm"/>">${user.usrusername }</a>
                    		</c:when>
                    		<c:otherwise>
                    			<a href="<c:url value="/logginForm.htm?urlShow=logins&keepThis=true&TB_iframe=true&height=520&width=620"/>" class="thickbox">Login</a>
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
                    <li><a href='javascript:openVentana("<%=basePath %>comofunciona.htm")'>Cómo funciona</a></li>
                </ul>
            </div>
            <div class="header_logo">
            	<a href=""><img src="images/nuevoLogoClickapuntos.png"></img></a>
            </div>
        </div>
        <!-- END HEADER -->
        
        <!-- INIT SLIDER -->
        <div class="navi" id="navi"></div>
         <div class="slider_top"></div>
        
        <div class="slider" onmouseover="javascript:cambiaNextPrev('visible')" onmouseout="javascript:cambiaNextPrev('invisible')">
        
          <div class="scrollable" id="chained" >   
                <div class="items">              
                
                <c:forEach items="${itemsSlid}" var="slid">
                	<div class="slider_item">
                        <div class="slider_item_img">
                        <c:choose> 
        								<c:when test="${slid.idPromoTipoMecanica == 2}">
        									<a href='javascript:openVentana("<%=basePath %>${slid.promoNombreUrl}.htm")'>                       
 												<img src="../${rutaImagenesPromos }${slid.promoImagen}" alt="${slid.promoDescripcion}"/>
                            				</a>
        								</c:when>
        								<c:otherwise>
        									<a href='javascript:openVentana("<%=basePath %>${slid.promoNombreUrl}.htm")'>                       
                            					<img src="../${rutaImagenesVideos }${slid.promoImagenVideo}" alt="${slid.promoDescripcion}"/>
                            				</a>
        								</c:otherwise>
        				</c:choose>				
 							
                        </div>
                        <div class="slider_item_button">
                            <c:choose>    	
        								<c:when test="${slid.idPromoTipoMecanica == 2}">
        									<a href='javascript:openVentana("<%=basePath %>${slid.promoNombreUrl}.htm")'><img src="<c:url value="/images/participa.png"/>" alt="Participa" /></a>
        								</c:when>
        					</c:choose>
                        </div>
                    </div>
                </c:forEach>
                </div>
            </div>
            
            <div class="slider_title">
                <a href="javascript:void();" class="slider_next next" id="slider_next"> </a>
                <a href="javascript:void();" class="slider_prev prev" id="slider_prev"></a>
            </div>
        </div>
        <!-- END SLIDER -->
        <!-- INIT COLUMN LEFT -->
        
        <div class="column_videos_left">
        	<table>
           	<!-- INIT VIDEO CONTROLS -->
           	<tr>
           	<td valign="top">
        	<div class="video_filters">
        		<div class="video_filters_filtro">
        			<div class="video_filters_filtro_i">
        			</div>
        			<div class="video_filters_filtro_c">	
        				<span>Filtrar por</span>
        			</div>
        		</div>
                <c:forEach items="${itemsFiltro}" var="filtro">
	                <div class="video_filters_buttons" onclick="javascript:addfilter(${filtro[0]})">
	                	<div class="video_filters_buttons_i"></div>
	                	<div class="video_filters_buttons_c">		
                			<span>${filtro[1]}</span>
                		</div>
	                </div>
                </c:forEach>
                <div class="video_filters_buttons" onclick="javascript:addfilter('')">
                	<div class="video_filters_filtro_i">
        			</div>
        			<div class="video_filters_filtro_c">	
        				<span>Ver todos</span>
        			</div>
                </div>

   	 			<div class="video_filters_buttons_s">
	   	 			<input id="search" type="text" value="">
	   	 			<button type="submit" onclick="javascript:addsearch()">
	   	 				<img src="<c:url value="/images/search_button.png"/>" width="15" height="10"></img>
	   	 			</button>
                </div>
            </div>
           	<!-- END VIDEO CONTROLS -->
            	</td>
            	<td valign="top">
		        	<!-- INIT LIST VIDEO RESULTS -->
		        	<div class="video_filters_result" id="video_filters_result">
		        		
					</div>
			</td>
			<td valign="top">
				<!-- INIT COLUMN RIGHT -->
        <div class="column_videos_right">
        	<div class="video_top_five_buttons">
            	<img src="<c:url value="/images/button_top_five.jpg"/>" alt="Top5" onclick="topfiveControl('top1')" />
            </div>
        	<div class="video_top_five" id="top1">    
        	<c:choose>    	
        		<c:when test="${itemsTop!= null}">
        			<c:forEach items="${itemsTop}" var="top">
                		<div class="video_top_five_item">
                			<c:if test="${user!=null }">
	                			<c:choose>    	                            			
	        						<c:when test="${top.mediaUsuarioLike == 1}">
	        							<div class="video_top_five_like_active" onclick="javascript:guardaLike(${top.idMedia},3,${user.idusuarios});liketopchange(this);">                   			                    		
	                    				</div>			
	        						</c:when>
	        						<c:otherwise>
	        							<div class="video_top_five_like" onclick="javascript:guardaLike(${top.idMedia},3,${user.idusuarios});liketopchange(this);">                   			                    		
	                    				</div>
	        						</c:otherwise>
	        					</c:choose>                		
                  			</c:if>
                		<div class="video_top_five_content" >
                    		<div class="video_top_five_smoth_container" id="video${top.topNum}">
                            	<div class="video_top_five_smoth"></div>
                            		<div class="video_top_five_smoth_play">
                            		</div>
                        	</div>
                        	<div class="video_top_five_image">
                    			<img src="../${rutaImagenesVideos }${top.promoImagenVideo}" alt="${top.topNum}" />
                        	</div>
                    	</div>
                    		<div class="video_top_five_text">
                    			<c:choose>
                    				<c:when test="${top.idPromoTipoMecanica == 2}">
        								<a href='javascript:openVentana("<%=basePath %>${top.promoNombreUrl}/.htm")'>                       
	                            			<h3>${top.promoDesc}</h3>
    	                        		</a>
        							</c:when>
        							<c:otherwise>
        								<a href='javascript:openVentana("<%=basePath %>${top.promoNombreUrl}.htm")'>
                    	        			<h3>${top.promoDesc}</h3>				
                        	    		</a>
        							</c:otherwise>
                    			</c:choose>	
                        		<ul>
                        		${top.mediaUsuarioLike} likes
                            		<li><img src="<c:url value="/images/icon_view.png"/>" alt="View" /> ${top.numRep}</li>
                            		<li><img src="<c:url value="/images/icon_points.png"/>" alt="Points" /> ${top.puntos}</li>
                        		</ul>
                    		</div>
                		</div>
                	</c:forEach>
        		</c:when>
        	</c:choose>        	
            </div>
            
            
         <div class="video_awards">
           		<a href=""><img src="images/sixflagsnavidad.png"></img></a>
         </div>

              <!--          	
							<div class="awards_navi" id="awards_navi"></div>
           			<h2>Especial</h2>
              		<div class="video_awards_scrollable" id="awards_chained">   
                    	<div class="video_awards_items">
   		            		<c:forEach items="${itemsPremios}" var="premios">
                        	<div class="video_awards_item">
                            	<img src="<c:url value="../${rutaImagenesClientes }${premios.imgCliente}"/>" alt="${premios.nombreCliente}" />
                            	<p><strong>${premios.nombreCliente}</strong> regala ${premios.descPremio}</p>
                        	</div>
                			</c:forEach>
                 </div>
              </div>
							-->
            

        </div>
			</td>
			</tr>
			
			</table>
        	<!-- END LIST VIDEO RESULTS -->
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
                <script>
                		(function(d, s, id) {
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
