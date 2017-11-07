<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>videos</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/css/clicka_videos.css"/>"/>
<link type="text/css" rel="stylesheet" href="<c:url value="/css/thickbox.css"/>" />
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
        
        <!-- INIT SLIDER -->
        <div class="navi" id="navi"></div>
         <div class="slider_top"></div>
        
        <div class="slider">
          <div class="scrollable" id="chained">   
                <div class="items">              
                
                <c:forEach items="${itemsSlid}" var="slid">
                	<div class="slider_item">
                        <div class="slider_item_img">
                        <c:choose>    	
        								<c:when test="${slid.idPromoTipoMecanica == 2}">
        									<a href="<c:url value="/publicidad/${slid.nombreCliente}/${slid.promoNombreUrl}"/>">                       
                            					<img src="<c:url value="/imagenes-promos/${slid.promoImagen}"/>" alt="${slid.promoDescripcion}"/>
                            				</a>
        								</c:when>
        								<c:otherwise>
        									<a href="<c:url value="/publicidad/${slid.promoNombreUrl}"/>">                       
                            					<img src="<c:url value="/imagenes-promos/${slid.promoImagen}"/>" alt="${slid.promoDescripcion}"/>
                            				</a>
        								</c:otherwise>
        				</c:choose>				
 							
                        </div>
                        <div class="slider_item_button">
                        	<div class="slider_button_reproducir">                            
                            	<a href="promociones?vidYou=${slid.mediaUrl}&idMedia=${slid.idMedia}&keepThis=true&TB_iframe=true&height=320&width=405" class="thickbox">                            	                            		
                            	</a>
                            	<p>REPRODUCIR VÍDEO</p>
                            </div>
                            <c:choose>    	
        								<c:when test="${slid.idPromoTipoMecanica == 2}">
        									<a href="<c:url value="/publicidad/${slid.nombreCliente}/${slid.promoNombreUrl}"/>"><img src="<c:url value="/images/participa.png"/>" alt="Participa" /></a>
        								</c:when>
        					</c:choose>			
                            
                            
                        </div>
                    </div>
                </c:forEach>
                </div>
            </div>
            
            <div class="slider_title">
                <a href="#" class="slider_next next"></a>
                <a href="#" class="slider_prev prev"></a>
                <h2>Gana un viaje a Aspen con Halls</h2>
            </div>
        </div>
        <!-- END SLIDER -->
        
        <!-- INIT COLUMN LEFT -->
        <div class="column_videos_left">
           	<!-- INIT VIDEO CONTROLS -->
        	<div class="video_filters">
                <h2>Filtrar por</h2>
                <div class="video_filters_buttons">
                	<select name="video_filter" id="video_filters_select" onchange="addfilter(this)">
                		<c:forEach items="${itemsFiltro}" var="filtro">
                			<option value="${filtro.idclasificacionads}">${filtro.mpdescripcion}</option>
                		</c:forEach>    
                    </select>
                    <div class="filters_button_result" id="filter_result"></div>
                </div>
            </div>
           	<!-- END VIDEO CONTROLS -->
            	
        	<!-- INIT LIST VIDEO RESULTS -->
        	<div class="video_filters_result" id="video_filters_result">
        		<c:forEach items="${itemsPromos}" var="promos">
        			<div class="video_filters_item">    
        				<c:choose>    	                            			
        					<c:when test="${promos.mediaUsuarioLike == 1}">
        						<div class="video_like_active" onclick="javascript:guardaLike(${promos.idMedia},3,<c:out value="${user}"/>);likechange(this);">                   			                    		
                    			</div>			
        					</c:when>
        					<c:otherwise>
        						<div class="video_like" onclick="javascript:guardaLike(${promos.idMedia},3,<c:out value="${user}"/>);likechange(this);">                   			                    		
                    			</div>
        					</c:otherwise>
        				</c:choose>
                		<div class="video_filters_item_image_content" onmouseover="playVideoControl(${promos.numPromo},true)" onmouseout="playVideoControl(${promos.numPromo},false)">
                    		<div class="video_filters_item_smoth_container" id="video${promos.numPromo}">
                            	<div class="video_filters_item_smoth"></div>
                            	<div class="video_filters_item_smoth_play">                            	
                            		<c:choose>    	                            			
        								<c:when test="${promos.idMediaTipo == 1}">
        									<a href="promociones?vidYou=${promos.mediaUrl}&idMedia=${promos.idMedia}&keepThis=true&TB_iframe=true&height=320&width=405" class="thickbox">
        									   <img src="<c:url value="/images/play_cortinillas.png"/>" alt="${promos.promoDescripcion}" />
                                			</a>
        								</c:when>
        								<c:otherwise>
<!--        								se comenta codigo pero se tiene que definir estilo para poner un link-->
<!--        									<a href="${promos.promoNombreUrl}">-->
<!--                                    			<img src="<c:url value="/images/play_cortinillas.png"/>" alt="${promos.promoDescripcion}" />-->
<!--                                			</a>-->
        								</c:otherwise>
        							</c:choose>	
                            	</div>
                        	</div>
                        	<div class="video_filters_item_image">
								<img src="<c:url value="imagenes-videos/${promos.promoImagenVideo}"/>" alt="${promos.promoDescripcion}" />
    	                    </div>
                    	</div>
                    	<div class="video_filters_item_content">
                    		<div class="video_filters_item_content_title">
                        		<div class="video_filters_item_content_part">                        		
	                        				<c:choose>    	
        										<c:when test="${promos.idPromoTipoMecanica == 2}">
        											<a href="<c:url value="/publicidad/${promos.nombreCliente}/${promos.promoNombreUrl}"/>"></a>
        										</c:when>
        									</c:choose>		
                            	</div>
                            	 <c:choose>    	
        								<c:when test="${promos.idPromoTipoMecanica == 2}">
        									<a href="<c:url value="/publicidad/${promos.nombreCliente}/${promos.promoNombreUrl}"/>">                       
                            					<h3>${promos.promoDescripcion}</h3>
                            				</a>
        								</c:when>
        								<c:otherwise>
        									<a href="<c:url value="/publicidad/${promos.promoNombreUrl}"/>">                       
                            					<h3>${promos.promoDescripcion}</h3>				
                            				</a>
        								</c:otherwise>
        						</c:choose>		
                        		
                            	<ul>    
                            		<li class="video_recomienda"><div class="video_filters_recomienda"></div> Recomiendalo</li>                        	
                            		<li><img src="<c:url value="/images/icon_view.png"/>" alt="View" /> ${promos.numrep} Reproducciones</li>
                                	<li><img src="<c:url value="/images/icon_points.png"/>" alt="Points" /> ${promos.promoNumeroPuntos} Puntos</li>
                            	</ul>
                        	</div>
                        	<div class="video_filters_item_content_news">
                        		<p><c:out value="${promos.promoMecanica}" escapeXml="false"></c:out></p>
                        	</div>
                    	</div>
                	</div>
                </c:forEach>
			</div>
        	<!-- END LIST VIDEO RESULTS -->
        </div>
        <!-- END COLUMN LEFT -->

        <!-- INIT COLUMN RIGHT -->
        <div class="column_videos_right">
        	<div class="video_top_five_buttons">
            	<img src="<c:url value="/images/button_top_five.jpg"/>" alt="Top5" onclick="topfiveControl('top1')" />
            	<img src="<c:url value="/images/button_suggestions.jpg"/>" alt="Sugerencias" onclick="topfiveControl('top2')" />
            </div>
        	<div class="video_top_five" id="top1">    
        	<c:choose>    	
        		<c:when test="${itemsTop!= null}">
        			<c:forEach items="${itemsTop}" var="top">
                		<div class="video_top_five_item">
                			<c:choose>    	                            			
        						<c:when test="${top.mediaUsuarioLike == 1}">
        							<div class="video_top_five_like_active" onclick="javascript:guardaLike(${top.idMedia},3,<c:out value="${user}"/>);liketopchange(this);">                   			                    		
                    				</div>			
        						</c:when>
        						<c:otherwise>
        							<div class="video_top_five_like" onclick="javascript:guardaLike(${top.idMedia},3,<c:out value="${user}"/>);liketopchange(this);">                   			                    		
                    				</div>
        						</c:otherwise>
        					</c:choose>                		
                  		
                		<div class="video_top_five_content" onmouseover="playVideoControl('${top.topNum}',true)" onmouseout="playVideoControl('${top.topNum}',false)">
                    		<div class="video_top_five_smoth_container" id="video${top.topNum}">
                            	<div class="video_top_five_smoth"></div>
                            		<div class="video_top_five_smoth_play">
                            			<a href="promociones?vidYou=${top.url}&idMedia=${top.idMedia}&keepThis=true&TB_iframe=true&height=320&width=405" class="thickbox">
                                    		<img src="<c:url value="/images/play_cortinillas.png"/>" alt="Otro video sobre algo que va por aquí" />
                                		</a>
                            		</div>
                        	</div>
                        	<div class="video_top_five_image">
                    			<img src="imagenes-videos/${top.promoImagenVideo}" alt="${top.topNum}" />
                        	</div>
                    	</div>
                    		<div class="video_top_five_text">
                    			<c:choose>
                    				<c:when test="${top.idPromoTipoMecanica == 2}">
        								<a href="<c:url value="/publicidad/${top.nombreCliente}/${top.promoNombreUrl}"/>">                       
	                            			<h3>${top.promoDesc}</h3>
    	                        		</a>
        							</c:when>
        							<c:otherwise>
        								<a href="<c:url value="/publicidad/${top.promoNombreUrl}"/>">                       
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
            
            <div class="video_sugerencias" id="top2">
            	<div class="video_top_five_item">
                   	<div class="video_top_five_like">
                    	<a></a>
                    </div>
                	<div class="video_top_five_content" onmouseover="playVideoControl('Top1',true)" onmouseout="playVideoControl('Top1',false)">
                    	<div class="video_top_five_smoth_container" id="videoTop1">
                            <div class="video_top_five_smoth"></div>
                            <div class="video_top_five_smoth_play">
                            	<a href="http://trailers.apple.com/movies/disney/tronlegacy/tronlegacy-tsr1_r640s.mov?width=640&height=272" rel="prettyPhoto[movies]">
                                    <img src="<c:url value="/images/play_cortinillas.png"/>" alt="Otro video sobre algo que va por aquí" />
                                </a>
                            </div>
                        </div>
                        <div class="video_top_five_image">
                    		<img src="images/video1.jpg" alt="Video 1" />
                        </div>
                    </div>
                    <div class="video_top_five_text">
                        <h3>Daft punk en concierto</h3>
                        <ul>
                            <li><img src="<c:url value="/images/icon_view.png"/>" alt="View" /> 54</li>
                            <li><img src="<c:url value="/images/icon_points.png"/>" alt="Points" /> 500</li>
                        </ul>
                    </div>
                </div>
                <div class="video_top_five_item">
                   	<div class="video_top_five_like">
                    	<a></a>
                    </div>
                	<div class="video_top_five_content" onmouseover="playVideoControl('Top2',true)" onmouseout="playVideoControl('Top2',false)">
                    	<div class="video_top_five_smoth_container" id="videoTop2">
                            <div class="video_top_five_smoth"></div>
                            <div class="video_top_five_smoth_play">
                                <a href="http://trailers.apple.com/movies/disney/tronlegacy/tronlegacy-tsr1_r640s.mov?width=640&height=272" rel="prettyPhoto[movies]">
                                    <img src="<c:url value="/images/play_cortinillas.png"/>" alt="Otro video sobre algo que va por aquí" />
                                </a>
                            </div>
                        </div>
                        <div class="video_top_five_image">
                    		<img src="images/video2.jpg" alt="Video 2" />
                        </div>
                    </div>
                    <div class="video_top_five_text">
                        <h3>Festival de Arte Digital</h3>
                        <ul>
                            <li><img src="<c:url value="/images/icon_view.png"/>" alt="View" /> 28</li>
                            <li><img src="<c:url value="/images/icon_points.png"/>" alt="Points" /> 200</li>
                        </ul>
                    </div>
                </div>
                <div class="video_top_five_item">
                   	<div class="video_top_five_like">
                    	<a></a>
                    </div>
                	<div class="video_top_five_content" onmouseover="playVideoControl('Top3',true)" onmouseout="playVideoControl('Top3',false)">
                    	<div class="video_top_five_smoth_container" id="videoTop3">
                            <div class="video_top_five_smoth"></div>
                            <div class="video_top_five_smoth_play">
                                <a href="http://trailers.apple.com/movies/disney/tronlegacy/tronlegacy-tsr1_r640s.mov?width=640&height=272" rel="prettyPhoto[movies]">
                                    <img src="<c:url value="/images/play_cortinillas.png"/>" alt="Otro video sobre algo que va por aquí" />
                                </a>
                            </div>
                        </div>
                        <div class="video_top_five_image">
                    		<img src="images/video3.jpg" alt="Video 3" />
                        </div>
                    </div>
                    <div class="video_top_five_text">
                        <h3>Audi esta regalando un iPod...</h3>
                        <ul>
                            <li><img src="<c:url value="/images/icon_view.png"/>" alt="View" /> 112</li>
                            <li><img src="<c:url value="/images/icon_points.png"/>" alt="Points" /> 600</li>
                        </ul>
                    </div>
                </div>
            </div>
          <div class="video_awards">
                <div class="awards_navi" id="awards_navi"></div>
           	<h2>Premios</h2>
              <div class="video_awards_scrollable" id="awards_chained">   
                    <div class="video_awards_items">
                    	<c:forEach items="${itemsPremios}" var="premios">
                			<div class="video_awards_item">
                            	<img src="<c:url value="/imagenes-clientes/${premios.imgCliente}"/>" alt="${premios.nombreCliente}" />
                            	<p><strong>${premios.nombreCliente}</strong> regala ${premios.descPremio}</p>
                        	</div>
                		</c:forEach>
                    </div>
              </div>
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
    
	<script type="text/javascript" src='<c:url value="/js/jquery.tools.min.js"/>'></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.selectbox-0.6.1.js"/> "></script>
	<script type="text/javascript" src="<c:url value="/js/thickbox.js"/>"></script>
    <script type="text/javascript">
    
		/* SCRIPT SCROLL SLIDER */
		var cboFil=new Array();
		
		$(document).ready(function() {
			$("#chained").scrollable({circular: true, mousewheel: false}).navigator("#navi").autoscroll({
				interval: 9000
			});

			$("#awards_chained").scrollable({circular: true, mousewheel: false}).navigator("#awards_navi").autoscroll({
				interval: 9000
			});
		});		
	
		/* SCRIPT CHANGE LOOKANDFEEL SELECTBOX */
		$("#video_filters_select").selectbox().bind('change', function(){
			$('#default-usage-select')
				.appendTo('#demo-default-usage .demoTarget')
				.fadeOut(2000, function(){
				$(this).remove();				
			});
		});
	
		/* SCRIPT SHOW PLAY CONTROL */
		function playVideoControl(id,status){
			videoContainer = document.getElementById("video"+id);
			if(status == true){
				videoContainer.style.display = "block";
			}else{
				videoContainer.style.display = "none";
			}
		}
		
		/* SCRIPT SHOW TOP5 AND SUGGESTIONS */
		function topfiveControl(id){
			if(id == "top1"){
				document.getElementById("top1").style.display = "block";
				document.getElementById("top2").style.display = "none"
			}else{
				document.getElementById("top1").style.display = "none"
				document.getElementById("top2").style.display = "block";
			}
		}
		

		
		//SCRIPT ADD FILTERS
		function addfilter(combo){
			var imageObject = new Image();
			imageObject.src = '/images/button_filters.png';
			var filter_value = combo.options[combo.selectedIndex].text;
			$('#filter_result').append("<div class='filter_result_item'><img alt='" + filter_value + "' src='" + imageObject.src + "'/><p>" + filter_value + "</p></div>");			
		}
		
		//SCRIPT ADD FILTERS
		function addfilter(combo){
			
			for ( i=0; i< cboFil.length; i++ ) {
			   if(cboFil[i] == combo.options[combo.selectedIndex].value){
			   		return;
			   }
			}		
		
			var imageObject = new Image();			
			cboFil[cboFil.length]=combo.options[combo.selectedIndex].value;
			
			//alert(combo.options[combo.selectedIndex].value);	
			//alert(cboFil.length);		
			imageObject.src = 'images/button_filters.png';
			var id_value = "awards" + combo.selectedIndex;
			var filter_value = combo.options[combo.selectedIndex].text;
			$('#filter_result').append("<div class='filter_result_item' id='" + id_value + "'><div class='close_button' onclick=close_function('" + id_value + "')></div><img alt='" + filter_value + "' src='" + imageObject.src + "'/><p>" + filter_value + "</p></div>");
			
			$.ajax({
	    		   	 	url: "getFiltro",
	      			  	data: "idFiltros="+cboFil ,
	        			success: function(datos){
	        				//alert('termina ajax'+datos);
	        				 fillFil(datos); 		
	        			}
			});
		}
		
		function close_function(id){
			//alert(id);
			var numElem = id;
			var combo = document.getElementById("video_filters_select");
			var idRem = numElem.substr(6,numElem.length);
			//alert(combo[idRem].value);
								
			var cboAux=new Array();
			var j=0;
			for ( i=0; i< cboFil.length; i++ ) {				
			   if(cboFil[i] != combo[idRem].value){
			   		cboAux[j]= cboFil[i];
			   		j=j+1;			   		
			   }
			}				
			cboFil = cboAux;			
			$.ajax({
	    		   	 	url: "getFiltro",
	      			  	data: "idFiltros="+cboFil ,
	        			success: function(datos){
	        				fillFil(datos);
	        			}
			});
			
			
			
			$("#"+id).remove();
		}
		
		
		function fillFil(datos){
			var filtroLta = eval("(" + datos + ")");
	        				var listFil = filtroLta.list;			
	        				
	        				
	        				var res = "";    
	        						
    						for(i=0;i < listFil.length ;i++){
    							var concFil = 	listFil[i];    							
    							
    							res = res +'<div class=\"video_filters_item\"> ';
    							
    							if(concFil.mediaUsuarioLike == 1){
    								res = res +'<div class=\"video_like_active\" onclick=\"javascript:guardaLike('+concFil.idMedia+',3,<c:out value="${user}"/>);likechange(this);\">';
    							}else{
    								res = res +'<div class=\"video_like\" onclick=\"javascript:guardaLike('+concFil.idMedia+',3,<c:out value="${user}"/>);likechange(this);\">';
    							}
    							
    							
    							res = res +'<a></a>';
    							res = res +'</div>';
    							
    							res = res +'<div class=\"video_filters_item_image_content\" onmouseover=\"playVideoControl('+i+',true)\" onmouseout=\"playVideoControl('+i+',false)\">';
								res = res +'<div class=\"video_filters_item_smoth_container\" id=\"video'+i+'\">';
								res = res +'<div class=\"video_filters_item_smoth\"></div>';
								res = res +'<div class=\"video_filters_item_smoth_play\">';
								
								if(concFil.idMediaTipo == 1){
									res = res+'<a href=\"promociones?vidYou='+concFil.mediaUrl+'&idMedia='+concFil.idMedia+'&keepThis=true&TB_iframe=true&height=320&width=405\" class=\"thickbox\">';									
									res = res+'<img src=\"<c:url value="/images/play_cortinillas.png"/>\" alt=\"'+concFil.promoDescripcion+'\" />';
									res=res+'</a>';
								}else{
									/*res=res+'<a href=\"'+concFil.promoNombreUrl+'\">';
									res = res+'<img src=\"<c:url value="/images/play_cortinillas.png"/>\" alt=\"'+concFil.promoDescripcion+'\" />';
									res=res+'</a>';	*/								
								}
								
								res=res+'</div>';
								res=res+'</div>';
								
								res=res+'<div class=\"video_filters_item_image\">';
								res=res+'<img src=\"<c:url value="imagenes-videos/'+concFil.promoImagenVideo+'"/>\" alt=\"'+concFil.promoDescripcion+'\"/>';
								res=res+'</div>';
								
								res=res+'</div>';
								
								
								res=res+'<div class=\"video_filters_item_content\">';
								res=res+'<div class=\"video_filters_item_content_title\">';
								res=res+'<div class=\"video_filters_item_content_part\">';
								
								if(concFil.idPromoTipoMecanica == 2){
									res=res+'<a href=\"<c:url value="/publicidad/'+concFil.nombreCliente+'/'+concFil.promoNombreUrl+'"/>\"></a>';	
								}
								res=res+'</div>';					
								if(concFil.idPromoTipoMecanica == 2){
									res=res+'<a href=\"<c:url value="/publicidad/'+concFil.nombreCliente+'/'+concFil.promoNombreUrl+'"/>\">';
									res=res+'<h3>'+concFil.promoDescripcion+'</h3>';
									res=res+'</a>';
								}else{
									res=res+'<a href=\"<c:url value="/publicidad/'+concFil.promoNombreUrl+'"/>\">';
									res=res+'<h3>'+concFil.promoDescripcion+'</h3>';
									res=res+'</a>';
								}
								res=res+'<ul>';
								res=res+'<li class="video_recomienda"><div class="video_filters_recomienda"></div> Recomiendalo</li>';
								res=res+'<li><img src=\"<c:url value="/images/icon_view.png"/>\" alt=\"View\" /> '+concFil.numrep+' Reproducciones</li>';
								res=res+'<li><img src=\"<c:url value="/images/icon_points.png"/>\" alt=\"Points\" /> '+concFil.promoNumeroPuntos+' Puntos</li>';
								res=res+'</ul>';
								
								res=res+'</div>';
								res=res+'<div class=\"video_filters_item_content_news\">';
								res=res+'<p>';
								res=res+concFil.promoMecanica;
								res=res+'</p>';
								res=res+'</div>';
								res=res+'</div>';
								res=res+'</div>';
    						}    						    						
					
    						$("#video_filters_result").html(res);
							tb_init('a.thickbox, area.thickbox, input.thickbox');//pass where to apply thickbox
							imgLoader = new Image();// preload image
							imgLoader.src = tb_pathToImage;
		}
		
		function guardaLike(idMedia,tpoAcc, idUser){			
			//var idUser = '<c:out value="${user}"/>';
			//alert('Entra: '+"guardaMedia?"+"idMedia="+idMedia+"&tipoAccion="+tpoAcc+"&idUsuario="+idUser);		
			$.ajax({
	    		   	 	url: "guardaMedia",
	      			  	data: "idMedia="+idMedia+"&tipoAccion="+tpoAcc+"&idUsuario="+idUser,
	        			success: function(datos){
	        				alert('Termina guardado');
	        			}
			});
		}
		function likechange(element){
			if(element.className == "video_like"){
				element.className = "video_like_active";
			}else{
				element.className = "video_like";
			}

		}
		function liketopchange(element){
			if(element.className == "video_top_five_like"){
				element.className = "video_top_five_like_active";
			}else{
				element.className = "video_top_five_like";
			}

		}
		
		
	</script>
</body>
</html>
