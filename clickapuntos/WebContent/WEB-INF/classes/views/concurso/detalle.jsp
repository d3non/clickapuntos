<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


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
<script type="text/javascript" src='<c:url value="/js/swfobject.js"/>'></script>
<script type="text/javascript" src='<c:url value="/js/youtubeAPI.js"/>'></script>
<script type="text/javascript" src='<c:url value="/js/jquery.tools.min.js"/>'></script>
<script type="text/javascript" src="<c:url value="/js/jquery.selectbox-0.6.1.js"/> "></script>
<script type="text/javascript" src="<c:url value="/js/thickbox.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/comentariosApi.js"/>"></script>
<script src="//connect.facebook.net/en_US/all.js"></script>

<script>
function guardaComentario(idMedia,idPromo,idUsuario,urlI){
	$.ajax({
	    		   	 	type: "POST",
	    		   	 	url: urlI,
	      			  	data: "idMedia="+idMedia+"&idPromo="+idPromo+"&idUsuario="+idUsuario+"&comentarioTexto="+document.comentarios.comentarioT.value+"&comentarioStatus=1&comentarioReporte=0&comentarioTono=0&url=" +urlI,
	        			success: function(datos){
	        				actualizaComentarios(datos);
	        			}
			});
}
function actualizaComentarios(datos){
	var datosC = eval("(" + datos + ")");
	var listFil = datosC.list;
	var res=crearDivs(listFil);
	$("#detalle_comentarios").html(res);
}
function inicia(){
	guardaComentario('','${idPromo }','','guardaComentario.htm');
}
// This function is called when the player changes state
function onPlayerStateChange(newState) {
  if(newState==0){
       alert("Termino ver video");
  }
}
</script>
  </head>
  <body onload="setInterval('inicia()',25000)">
	<div class="container">
    	<!-- INIT HEADER -->
    	    <form action="#" name="comentarios" method="post" id="comentarios"> 
    	<div class="header">
            <div class="header_user_bar">
            	<c:forEach items="${itemsPromos}" var="promos">
                    <c:if test="${promos.idPromo == idPromo}">
	                    <c:set var="url" value="/publicidad/${promos.promoNombreUrl}/${promos.idPromo}/${promos.nombreCliente}/${promos.idMedia}.htm"></c:set>
		                <ul>
		                    <li><div class="header_salir"></div> <a href="<c:url value="/cerrarSesion.htm?url=${url}"/>">Salir</a></li>
		                    <li><div class="header_perfil"></div> <a href="<c:url value="/perfilUser.htm"/>">Perfil</a></li>
		                    <li><div class="header_puntos"></div> <a href="#">5,421</a></li>
		                </ul>
                </c:if>
                </c:forEach>
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
        
        <!-- INIT BILLBOARD PLAYER -->
		<div class="detalle_billboard">
        	<div class="detalle_player" >
        	 <c:forEach items="${mediaAll}" var="mediaAlls">
               <c:choose>
        		   <c:when test="${mediaAlls.idmedia == idMedia}">
                      <div id="videoDiv">
                      
                      </div>
                      <script>
                      loadPlayer('${mediaAlls.mediaurl}');
                      </script>
                      
           	      </c:when>
              </c:choose>	
            </c:forEach>
            </div>

            <div class="detalle_player_content">

            <c:forEach items="${itemsPromos}" var="promos">
                     <c:if test="${promos.idPromo == idPromo}">
            	        <h1>${promos.promoDescripcion}</h1>
                     </c:if>
            </c:forEach>
            
                <div class="detalle_player_points">
                	<ul>
                        <li class="video_recomienda"><div class="video_filters_recomienda"></div> Recomiendalo</li>
                        <li><div class="video_filters_play"></div> 2,696</li>
                        <li><div class="video_filters_points"></div>
                        <c:forEach items="${promosAll}" var="promosAlls">
                            <c:if test="${promosAlls.idpromo == idPromo}">
            	             <h1>${promosAlls.promonumeropuntos}</h1>
                         </c:if>
                       </c:forEach>
                       </li>
                    </ul>
                </div>               
           <p>
            <c:forEach items="${promosAll}" var="promosAlls">
                     <c:if test="${promosAlls.idpromo == idPromo}">
            	        <h1>${promosAlls.promomecanicalargo}</h1>
                     </c:if>
            </c:forEach>
          </p>    
               <div class="detalle_redes_sociales">
                	<img src="images/clicka_facebook.png" alt="Facebook" />
                    <img src="images/clicka_twitter.png" alt="Twitter" />
                </div>
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
							<div class="detalle_comentarios_image"><img src="${usuarios.usrfoto}" alt="Detalle" />
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
									</c:if>
								</c:forEach>
							</div>
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
            	 
                    	<a href="#" id="login_twitter"></a>
                    	<a href="${urlFacebook }" id="login_facebook"></a>
                    	<a href="<c:url value="/logginForm.htm?url=${url}"/>" id="login_clicka"></a>
                </div>
                <div class="detalle_comentarios_seccion">
                	<h2>Que se escuche tu voz</h2>
                    <div class="detalle_comentario_seccion_usuario">
                    <c:choose>
                    <c:when test="${user!=null}">
                        <a href="<c:url value="/cerrarSesion.htm?url=${url}"/>">Salir</a>
                        <div id="login_clicka"></div>
                    	<p>Sesión iniciada como
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
                        <img src="images/detalle_comenta_1.jpg" alt="Detalle" />
                    </div>
                    <div class="detalle_comentar_texto">
                    	<textarea name="comentarioT" id="comentarioT">Escribe aquí tu comentario</textarea>
                    </div>
                    <div class="detalle_comentar_nota">
                    	<p>297 caracteres</p>
                    </div>
                    <div class="detalle_comentar_botones">
                    	<a href="#">x Cancelar</a>
                        o
                        <c:choose>
                   			<c:when test="${user!=null}">
	                   			<c:forEach items="${itemsPromos}" var="promos">
                     				<c:if test="${promos.idPromo == idPromo}">
                              			<a href="javascript:guardaComentario(${promos.idMedia },${promos.idPromo },${user.idusuarios},'guardaComentario.htm?url=${url }' )" id="publicar_comentario"></a>
                              		</c:if>
                              	</c:forEach>
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
            	
                 <c:forEach items="${itemsPromos}" var="promos">
                     <c:if test="${promos.idPromo == idPromo}">
            	        <h1>${promos.promoMecanica}</h1>
                     </c:if>                             
                </c:forEach>

            </div>
        </div>
        <!-- END COLUMN RIGHT -->
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
                	<li><a href="#">T&eacute;rminos y condiciones</a></li>
                	<li><a href="#">Privacidad</a></li>
                </ul>
                <p>ï¿½2011 ClickaPuntos.com.mx Todos los derechos reservados</p>
            </div>
        	<div class="footer_right">
            	<div class="footer_right_twitter">
                    <div class="footer_right_twitter_content">
                    	<a href="#"><img src="<c:url value="/images/clicka_twitter.png"/>" alt="Twitter" /></a>
                    </div>
                	<img src="<c:url value="/images/clicka_social_media.jpg"/>" alt="Clicka Social" />
                </div>
            	<div class="footer_right_facebook">
                    <a href="#"><img src="images/clicka_facebook.png" alt="Facebook" /></a>
                	Click a Puntos
                </div>
                <div class="footer_right_social_media">
                	<img src="<c:url value="/images/clicka_person_1.jpg"/>" alt="Media" />
                	<img src="<c:url value="/images/clicka_person_2.jpg"/>" alt="Media" />
                	<img src="<c:url value="/images/clicka_person_3.jpg"/>" alt="Media" />
                	<img src="<c:url value="/images/clicka_person_4.jpg"/>" alt="Media" />
                	<img src="<c:url value="/images/clicka_person_5.jpg"/>" alt="Media" />
                	<img src="<c:url value="/images/clicka_person_6.jpg"/>" alt="Media" />
                	<img src="<c:url value="/images/clicka_person_7.jpg"/>" alt="Media" />
                </div>
            </div>
        </div>
    </div>
    <!-- END FOOTER -->
</body>
</html>
