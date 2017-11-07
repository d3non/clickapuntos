<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.println("Ruta BAse: " + basePath);
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns:og="http://ogp.me/ns#"
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

<script type="text/javascript" src='<c:url value="/js/jquery.tools.min.js"/>'></script>
<script type="text/javascript" src="<c:url value="/js/jquery.selectbox-0.6.1.js"/> "></script>
<script type="text/javascript" src="<c:url value="/js/thickbox.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/comentariosApi.js"/>"></script>
<script type="text/javascript" src='<c:url value="/js/jquery.js"/>'></script>
<script src="//connect.facebook.net/en_US/all.js"></script>

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

     <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
     <script src="http://a.vimeocdn.com/js/froogaloop2.min.js"></script>
     <script src="http://connect.facebook.net/en_US/all.js"></script>
     
     <script type="text/javascript">
 	 var banPromo='0'; 
     jQuery(document).ready(function() {
      	
      	// Enable the API on each Vimeo video
         jQuery('iframe.vimeo').each(function(){
             Froogaloop(this).addEvent('ready', ready);
         });
         
         function ready(playerID){
             // Add event listerns
             //Froogaloop(playerID).addEvent('seek', seek);
             Froogaloop(playerID).addEvent('finish', finish);
             }
         
         function finish(){
             if('${user.idusuarios}'!=""){ 
         	  	guardaPuntos('${user.idusuarios}','${idPromo}');
               	banPromo='0';
               }
               else{
             	guardaPuntos('0','${idPromo}');
             	alert('Para acumular tus puntos es necesario que inicies sesión, si aún no estás registrado házlo en la página principal, ¡Gracias!');
             	banPromo='1';
               }

         }
         
     });
       
        function guardaPuntos(idUsuarios,idPromo){
        	$.ajax({
           	 	type: "POST",
           	 	dataType: "text",
           	 	url: "guardaPuntosUsr.htm",
        		data: "idUser="+idUsuarios+"&idPromo="+idPromo,
        		success: function(datos){
        			cambiaPuntos(datos);
        		}
        });
        }
        
        function openVentana(url){
        	if(banPromo=='0'){
        		window.location=url;
        	}
        	else{
        		if (confirm("¿Deseas abandonar esta pagina?, (Se perderán los puntos)")) {
        			window.location=url;
        		}
        	}
        	
        }
        

        $(document).ready(function() {
            if ('${background}'!=""){
	        	var newimgsrc = '${rutaImagenesVideos}${background}';
	            $('#bckground').css("background-image", "url(../"+newimgsrc+")");
	            $('#bckground').css("background-size", "1366px 670px");
	            $('#bckground').css("background-repeat", "no-repeat");
	            $('#bckground').css("background-attachment", "fixed");
	            $('#bckground').css("background-position", "left top");
            }else{
	            $('#bckground').css("background-image", "url(images/bg_logo.png)");
	            $('#bckground').css("background-size", "1010px 730px");
	            $('#bckground').css("background-position", "right bottom");
	            $('#bckground').css("background-repeat", "no-repeat");
            }
        });
        
        FB.init({
            appId: '333050033446083', 
            status: true, 
            cookie: true,
            xfbml: true
        });

        function feed()
        {
			var urldir= location.protocol + "//" + location.host + location.pathname ;
			//urldir="http://www.clickapuntos.com"+location.pathname;
			var imagepath = location.protocol + "//" + location.host + "/"+'${rutaImagenesVideos}${imagenshare}';
			var redirect = location.protocol + "//" + location.host + "/"+'concurso/selfclose.htm';
			var prdescripcion = '${prdescripcion}';
			var prmecanica = '${prmecanica}';
			var prmecanicalargo = '${prmecanicalargo}';

	        var obj = {
	                method: 'feed',
	                //display: 'popup',
	                redirect_uri: redirect,
	                link: urldir,
	                picture: imagepath,
	                name: prdescripcion,
	                caption: prmecanica,
	                description: prmecanicalargo
	              };

	              function callback(response) {
	                document.getElementById('msg').innerHTML = "Post ID: " + response['post_id'];
	              }

	              FB.ui(obj, callback);
         }
        
</script>


  </head>
  <body onload="setInterval('inicia(${idPromo })',25000)">
  
  	<c:choose>
        <c:when test="${mensaje!=null}" >
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
  		</c:when>
  	</c:choose>


	<div id="bckground">
		<div class="container_d">
    	<!-- INIT HEADER -->
    	    <form action="" name="comentarios" method="post" id="comentarios"> 
    	<div class="header">
            <div class="header_user_bar">
		                <ul>
		                    <li><div class="header_salir"></div> 
		                    	<a href="<c:url value="/cerrarSesion.htm?url=${urlAnt}"/>">Salir</a>
		                    </li>
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
		                    	<li><div class="header_puntos"></div> <span id="puntos"> ${numTotal }</span></li>
		                    </c:if>
		                </ul>
            </div>
        	<div class="header_menu">
            	<ul>
                	<li><a href="javascript:openVentana('<%=basePath %>')">Inicio</a></li>
                    <li><a href="javascript:openVentana('<%=basePath %>videos.htm')">Videos</a></li>
                    <li><a href='javascript:openVentana("<%=basePath %>comofunciona.htm")'>Como funciona</a></li>
                </ul>
            </div>
            <div class="header_logo">
            	<a href=""><img src="images/nuevoLogoClickapuntos.png"></img></a>
            </div>
        </div>
    	<!-- END HEADER -->
        
        <!-- INIT BILLBOARD PLAYER -->
		<div class="detalle_billboard">
        	<div class="detalle_player" >
        		<c:choose>
        			<c:when test="${imagenPromo==null}">
		        	 <c:forEach items="${mediaAll}" var="mediaAlls">
		               <c:choose>
		        		  <c:when test="${mediaAlls.idmedia == idMedia}">
		                      	<iframe class="vimeo" id="player1" src="http://player.vimeo.com/video/${mediaAlls.mediaurl}?api=1&player_id=player1" width="640" height="320" frameborder="0" webkitAllowFullScreen mozallowfullscreen allowFullScreen></iframe>
	           	    	  </c:when>
		            	  </c:choose>
		            </c:forEach>
            		</c:when>
            		<c:otherwise>
            			 <c:forEach items="${promosAll}" var="promosAlls">
                            <c:if test="${promosAlls.idpromo == idPromo}">
            	            	 <img src="../${rutaImagenesVideos }${promosAlls.promoimagenvideo }" width="640px" height="330px"/>
                        	</c:if>
                       	</c:forEach>
            			
            		</c:otherwise>
            	</c:choose>
            </div>

            <div class="detalle_player_content">
			<table>
				<tr>
					<td>
						<c:forEach items="${itemsPromos}" var="promos">
		                    <c:if test="${promos.idPromo == idPromo}">
		           	    	    <h1>${promos.promoDescripcion}</h1>
		                    </c:if>
		           		</c:forEach>
					</td>
				</tr>
				<tr>
					<td>
						 <div class="detalle_player_points">
		                	<ul>
		                        <li class="video_recomienda"><div class="video_filters_recomienda"></div> Recomiendalo</li>
		                        <li><div class="video_filters_play"></div> ${numReproducciones }</li>
		                        <li><div class="video_filters_points"></div>
		                        <c:forEach items="${promosAll}" var="promosAlls">
		                            <c:if test="${promosAlls.idpromo == idPromo}">
		            	             ${promosAlls.maxPuntos}
		                         </c:if>
		                       </c:forEach>
		                       </li>
		                    </ul>
		                </div>	
					</td>
				</tr>
				<tr>
					<td>
						<div class="detalle_player_mecanica">
			            	<c:forEach items="${promosAll}" var="promosAlls">
			                     <c:if test="${promosAlls.idpromo == idPromo}">
			            	        <br><h1>${promosAlls.promomecanica}</h1>
			                     </c:if>
			            	</c:forEach>
		            	</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="detalle_redes_sociales">
						<center>
						    <a href='javascript:feed();' id="msg"> <img style="border: 1px solid #cccccc" src="images/facebook_icon.png" width="27px" height="27"></a>
						<script>
							var urldir= location.protocol + "//" + location.host + location.pathname ;
							urldir="http://www.clickapuntos.com"+location.pathname;
							var imagepath = location.protocol + "//" + location.host + "/"+'${rutaImagenesVideos}${imagenshare}';
							var redirect = "http://www.clickapuntos.com";
							var prdescripcion = '${prdescripcion}';
							var prmecanica = '${prmecanica}';
							var prmecanicalargo = '${prmecanicalargo}';
							!function(d,s,id){
								var js,fjs=d.getElementsByTagName(s)[0];
								if(!d.getElementById(id)){
									js=d.createElement(s);js.id=id;
									js.src="//platform.twitter.com/widgets.js";
									fjs.parentNode.insertBefore(js,fjs);
									}
							}
							(document,"script","twitter-wjs");
							//document.write('<a href="javascript:compartir(\''+urldir+'\',\''+titulo+'\');"><img style="border: 1px solid #cccccc" src="images/facebook_icon.png" width="27px" height="27"></a>');
						    //document.write('<a href="javascript:compartir(\''+urldir+'\',\''+redirect+'\',\''+imagepath+'\',\''+prdescripcion+'\',\''+prmecanica+'\',\''+prmecanicalargo+'\');"><img style="border: 1px solid #cccccc" src="images/facebook_icon.png" width="27px" height="27"></a>');
						    //document.write('<a href="javascript:postToFeed(); return false;" id="msg"> <img style="border: 1px solid #cccccc" src="images/facebook_icon.png" width="27px" height="27"></a>');
							document.write('<a href="https://twitter.com/share" class="twitter-share-button" data-url="'+urldir+'" data-lang="en" data-size="large">Tweet</a>');
						</script>
						</center>		
			            </div>			           
					</td>
				</tr>
			</table>
        </div>
        </div>
        <!-- END BILLBOARD PLAYER -->
        
        <!-- INIT COLUMN LEFT -->
        <div class="column_detalle_left">
        	<!-- INIT COMENTARIOS -->
        	<div class="detalle_comentarios" id="detalle_comentarios">
				<h2>${totalComentarios} Comentarios</h2>
				
				<c:forEach items="${detalle}" var="detalles">
					<div class="detalle_comentarios_item">
						<div class="detalle_datos_usuario">
							<c:forEach items="${usuarios}" var="usuarios">
									<c:if test="${detalles.id.usuariosIdUsuario==usuarios.idusuarios}">
										<div class="detalle_comentarios_image">
											<c:choose>
												<c:when test="">
													<img src="${usuarios.usrfoto!=null }" alt="Detalle" />
												</c:when>
												<c:otherwise>
													<img src="images/perfilUser/userfoto.png" alt="Detalle" />
												</c:otherwise>
											</c:choose>
											<div class="detalle_like"><a href="#"></a></div>
										</div>
										<div class="detalle_comentarios_usuario">
												<div class="${usuarios.provider}"></div>
												<span>${usuarios.usrusername}</span>
													${detalles.fechacomentario}
												<ul>
													<li>
													<div class="detalle_globo"></div>
													Responder</li>
													<li>
													<div class="detalle_denunciar"></div>
													Denunciar</li>
													<li>
													<div class="detalle_megusta"></div>
													${detalles.comentariotono}</li>
												</ul>
										</div>
									</c:if>
								</c:forEach>
							</div>
							<div class="detalle_datos_comentarios">
								<table>
									<tr>
										<td width="50px"></td>
										<td><p>${detalles.comentariostexto}</p></td>
									</tr>
								</table>
							</div>
						</div>
				</c:forEach>
			</div>
            <!-- END COMENTARIOS -->
            <!-- INIT COMENTARIOS LOGIN -->
            <div class="detalle_comentarios_login">
            	<div class="detalle_comentarios_login_section">
            	 
                    	<a href="${urlTwitter }" id="login_twitter"></a>
                    	<a href="${urlFacebook }" id="login_facebook"></a>
                    	<a href="<c:url value="/logginForm.htm?urlShow=logginForm&url=${url}"/>" id="login_clicka"></a>
                </div>
                <div class="detalle_comentarios_seccion">
                	<h2>Que se escuche tu voz</h2>
                    <div class="detalle_comentario_seccion_usuario">
                    <c:choose>
                    <c:when test="${user!=null}">
                        <a href="<c:url value="/cerrarSesion.htm?url=${urlAnt}"/>">Salir</a>
                        <div id="login_clicka"></div>
                    	<p>Sesi&oacute;n iniciada como
                    	${user.usrusername } </p>
                    </c:when>
                    <c:otherwise>
                    	<p>No has iniciado Sesi&oacute;n</p>
                    </c:otherwise>
                    </c:choose>
                    </div>
                </div>
                <div class="detalle_comentar">
                    <div class="detalle_comentarios_image">
                    	<c:choose>
                   			<c:when test="${user==null}">
                   				<img src="images/detalle_comenta_1.jpg" alt="Detalle" />
                             </c:when>
                             <c:otherwise>
				<c:choose>
					<c:when test="">
						<img src="${user.usrfoto!=null }" alt="Detalle" />
					</c:when>
					<c:otherwise>
						<img src="images/perfilUser/userfoto.png" alt="Detalle" />
					</c:otherwise>
				</c:choose>
		                    </c:otherwise>
						</c:choose> 
                    </div>
                    <div class="detalle_comentar_texto">
                    	<textarea name="comentarioT" id="comentarioT">Escribe aqui tu comentario</textarea>
                    </div>
                    <div class="detalle_comentar_nota">
                    	<p>297 caracteres</p>
                    </div>
                    <div class="detalle_comentar_botones">
                        <c:choose>
                   			<c:when test="${user!=null}">
	                   			<c:forEach items="${itemsPromos}" var="promos">
                     				<c:if test="${promos.idPromo == idPromo}">
                     					<c:choose>
                     						<c:when test="${promos.idMedia!=null }">
                              					<a href="javascript:guardaComentario(${promos.idMedia },${promos.idPromo },${user.idusuarios},'guardaComentario.htm?url=${url }' )" id="publicar_comentario"></a>
                              				</c:when>
                              				<c:otherwise>
                              					<a href="javascript:guardaComentario(0,${promos.idPromo },${user.idusuarios},'guardaComentario.htm?url=${url }' )" id="publicar_comentario"></a>
                              				</c:otherwise>
                              			</c:choose>
                              		</c:if>
                              	</c:forEach>
                              	<a href=""><img src="<c:url value="/images/perfilUser/cancelar.png"/>" /></a>
                             </c:when>
                             <c:otherwise>
		                    	<p>Inicia sesi&oacute;n para publicar comentarios</p>
		                    </c:otherwise>
						</c:choose>
                    </div>
                </div>
            </div>
            <!-- END COMENTARIOS LOGIN -->
              
        </div>
        </form>
        <!-- END COLUMN LEFT -->
        
        <!-- INIT COLUMN RIGHT -->
        <div class="column_detalle_right">
        	<div class="detalle_mecanica">
            	<h2>Mecanica</h2>
            	
                <c:forEach items="${promosAll}" var="promosAlls">
                     <c:if test="${promosAlls.idpromo == idPromo}">
            	        <br>${promosAlls.promomecanicalargo}
                     </c:if>
            	</c:forEach>

            </div>
        </div>
        <!-- END COLUMN RIGHT -->
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
                    <li><a href="">¿Cómo funciona?</a></li>
                    <li><a href="mailto:contacto@clickapuntos.com?subject=Información para publicitar mi marca">Contacto</a></li>
                </ul>
                <ul>
					<li><a href="">Políticas de uso y privacidad</a></li>                
				</ul>
                <p>&copy; 2011 ClickaPuntos.com Todos los derechos reservados</p>
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
