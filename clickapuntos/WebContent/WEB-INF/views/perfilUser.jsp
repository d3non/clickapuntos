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
	
	</script>
  </head>
  
  <body>
  <script type="text/javascript">
  $(function(){
    	$('#filters_select_c').combobox( { 
    		comboboxContainerClass: "comboboxContainer", 
    		comboboxValueContainerClass: "comboboxValueContainer", 
    		comboboxValueContentClass: "comboboxValueContent", 
    		comboboxDropDownClass: "comboboxDropDownContainer", 
    		comboboxDropDownButtonClass: "comboboxDropDownButton", 
    		comboboxDropDownItemClass: "comboboxItem", 
    		comboboxDropDownItemHoverClass: "comboboxItemHover", 
    		comboboxDropDownGroupItemHeaderClass: "comboboxGroupItemHeader", 
    		comboboxDropDownGroupItemContainerClass: "comboboxGroupItemContainer", 
    		animationType: "slide",
    		width: "140px" 
    	});
    	$('#filters_select_c2').combobox( { 
    		comboboxContainerClass: "comboboxContainer", 
    		comboboxValueContainerClass: "comboboxValueContainer", 
    		comboboxValueContentClass: "comboboxValueContent", 
    		comboboxDropDownClass: "comboboxDropDownContainer2", 
    		comboboxDropDownButtonClass: "comboboxDropDownButton", 
    		comboboxDropDownItemClass: "comboboxItem", 
    		comboboxDropDownItemHoverClass: "comboboxItemHover", 
    		comboboxDropDownGroupItemHeaderClass: "comboboxGroupItemHeader", 
    		comboboxDropDownGroupItemContainerClass: "comboboxGroupItemContainer", 
    		animationType: "slide",
    		width: "140px" 
    	});
    	$('#filters_select_c3').combobox( { 
    		comboboxContainerClass: "comboboxContainer", 
    		comboboxValueContainerClass: "comboboxValueContainer", 
    		comboboxValueContentClass: "comboboxValueContent", 
    		comboboxDropDownClass: "comboboxDropDownContainer2", 
    		comboboxDropDownButtonClass: "comboboxDropDownButton", 
    		comboboxDropDownItemClass: "comboboxItem", 
    		comboboxDropDownItemHoverClass: "comboboxItemHover", 
    		comboboxDropDownGroupItemHeaderClass: "comboboxGroupItemHeader", 
    		comboboxDropDownGroupItemContainerClass: "comboboxGroupItemContainer", 
    		animationType: "slide",
    		width: "140px" 
    	});
    	$('#filters_select_c4').combobox( { 
    		comboboxContainerClass: "comboboxContainer", 
    		comboboxValueContainerClass: "comboboxValueContainer", 
    		comboboxValueContentClass: "comboboxValueContent", 
    		comboboxDropDownClass: "comboboxDropDownContainer2", 
    		comboboxDropDownButtonClass: "comboboxDropDownButton", 
    		comboboxDropDownItemClass: "comboboxItem", 
    		comboboxDropDownItemHoverClass: "comboboxItemHover", 
    		comboboxDropDownGroupItemHeaderClass: "comboboxGroupItemHeader", 
    		comboboxDropDownGroupItemContainerClass: "comboboxGroupItemContainer", 
    		animationType: "slide",
    		width: "140px" 
    	});
    	$('#filters_select_cel').combobox( { 
    		comboboxContainerClass: "comboboxContainer2", 
    		comboboxValueContainerClass: "comboboxValueContainer2", 
    		comboboxValueContentClass: "comboboxValueContent2", 
    		comboboxDropDownClass: "comboboxDropDownContainer22", 
    		comboboxDropDownButtonClass: "comboboxDropDownButton2", 
    		comboboxDropDownItemClass: "comboboxItem2", 
    		comboboxDropDownItemHoverClass: "comboboxItemHover2", 
    		comboboxDropDownGroupItemHeaderClass: "comboboxGroupItemHeader2", 
    		comboboxDropDownGroupItemContainerClass: "comboboxGroupItemContainer2", 
    		animationType: "slide",
    		width: "300px" 
    	});
    	$('#filters_select_cel_2').combobox( { 
    		comboboxContainerClass: "comboboxContainer2", 
    		comboboxValueContainerClass: "comboboxValueContainer2", 
    		comboboxValueContentClass: "comboboxValueContent2", 
    		comboboxDropDownClass: "comboboxDropDownContainer22", 
    		comboboxDropDownButtonClass: "comboboxDropDownButton2", 
    		comboboxDropDownItemClass: "comboboxItem2", 
    		comboboxDropDownItemHoverClass: "comboboxItemHover2", 
    		comboboxDropDownGroupItemHeaderClass: "comboboxGroupItemHeader2", 
    		comboboxDropDownGroupItemContainerClass: "comboboxGroupItemContainer2", 
    		animationType: "slide",
    		width: "300px" 
    	});

    	if('${user}'!=""){
    		if('${user.usremail}'==""){
    			tb_show(null,'userRegistroEmail.htm?keepThis=true&TB_iframe=true&height=150&width=400',null);		
    		}
    	}
   }); 
  function actualizaDatos(){
	  location.reload();
  }
  </script>
	<div class="container">
    	<!-- INIT HEADER -->
    	<div class="header">
            <div class="header_user_bar">
                <ul>
                    <li><div class="header_salir"></div> 
                    <a href="<c:url value="/cerrarSesion.htm?url="/>">Salir</a></li>
                    <li><div class="header_perfil"></div>
						<c:choose>
                    		<c:when test="${user != null }">
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
                    <li><a href='javascript:openVentana("<%=basePath %>comofunciona.htm")'>Como funciona</a></li>
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
        			<a href="<c:url value=""/>"><img src="<c:url value="/images/perfilUser/izq_pag1.png"/>" /></a>
        			<c:choose>
	        			<c:when test="${user!=null }">
	        				<c:choose>
	        					<c:when test="${ user.tipoplan=='2' }">
		        					<a href="<c:url value="/centroCanje.htm?idTipo=2"/>"><img src="<c:url value="/images/perfilUser/izq_pag2.png"/>" /></a>
								</c:when>
		        				<c:otherwise>
		        					<a href="<c:url value="/centroCanje.htm?idTipo=1"/>"><img src="<c:url value="/images/perfilUser/izq_pag2.png"/>" /></a>
		        				</c:otherwise>
		        			</c:choose>
	        			</c:when>
	        			<c:otherwise>
	        				<a href="<c:url value=""/>"><img src="<c:url value="/images/perfilUser/izq_pag2.png"/>" /></a>
	        			</c:otherwise>
        			</c:choose>
        	</div>
        	<!-- FOTOS -->
        	<div class="perfil_user_content_izq_foto">
        		<div class="perfil_user_content_izq_foto_foto">
        			<c:if test="${user!=null }">
        				<c:if test="${user.usrfoto!=null }">
        					<img src="${user.usrfoto }" class="perfil_user_content_izq_foto_foto"/>
        				</c:if>
        			</c:if>
        		</div>
        		<div class="perfil_user_content_izq_foto_upload">
        			<div class="perfil_user_content_izq_page_sube">
        				<span>Sube tu foto</span>
        			</div>
        			<div class="perfil_user_content_izq_foto_cambios">
        				<c:choose>
        					<c:when test="${user!=null }">
        						<a href="<c:url value="userFoto.htm?keepThis=true&TB_iframe=true&height=140&width=500" />"  class="thickbox"><img src="<c:url value="/images/perfilUser/cambiar.png"/>" /></a>
        						<a href="<c:url value="eliminarFoto.htm"/>"><img src="<c:url value="/images/perfilUser/eliminar.png"/>" /></a>
        					</c:when>
        					<c:otherwise>
        						<a href="<c:url value="#" />" ><img src="<c:url value="/images/perfilUser/cambiar.png"/>" /></a>
        						<a href="<c:url value="#"/>"><img src="<c:url value="/images/perfilUser/eliminar.png"/>" /></a>
        					</c:otherwise>	
        				</c:choose>
        			</div>
        		</div>
        	</div>
        	<!-- FORMULARIO -->
        	<form:form method="POST" commandName="userBean">
        	<div class="perfil_user_content_izq_form">
        		<table>
	        		<tr>
	        			<td colspan="2" width="310px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				<br/>
	        				Apellido Paterno*<form:errors path="apellidoPaterno" cssClass="error" />
	        				<br/>
						</td>
						<td colspan="2" width="310px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				<br/>
	        				Apellido Materno*<form:errors path="apellidoMaterno" cssClass="error" />
	        				<br/>
						</td>
					</tr>
					<tr>
	        			<td colspan="2" width="310px">
	        				<div class="perfil_user_content_izq_form_campofotro">
	        					<form:input path="apellidoPaterno"/>
	        				</div>
						</td>
						<td colspan="2" width="310px">
	        				<div class="perfil_user_content_izq_form_campofotro">
	        					<form:input path="apellidoMaterno"/>
	        				</div>
						</td>
					</tr>

        			<tr>
	        			<td colspan="2" width="310px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				Nombre(s)* <form:errors path="nombre" cssClass="error" />
						</td>
						<td colspan="2" width="310px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				Nickname* <form:errors path="nickname" cssClass="error" />
						</td>
					</tr>
					<tr>
						<td colspan="2" width="310px">
	        				<div class="perfil_user_content_izq_form_campofotro">
	        					<form:input path="nombre" id="name"/>
	        				</div>
						</td>
						<td colspan="2" width="310px">
	        				<div class="perfil_user_content_izq_form_campof">
	        					<form:input path="nickname"/>
	        				</div>
						</td>
					</tr>

	        	
	        		<tr>
	        			<td width="155px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				Sexo*
						</td>
						<td width="155px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				Fecha de nacimiento*
						</td>
						<td width="155px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				
						</td>
						<td width="155px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				
						</td>
					</tr>
					<tr >
	        			<td  width="155px" class="perfil_user_content_line">
			                	<form:select path="sexo" id="filters_select_c">
			                		<form:option value="M">Masculino</form:option>
			                		<form:option value="F">Femenino</form:option>
			                   </form:select>
	        				<br/>
						</td>
						<td width="155px" class="perfil_user_content_line">
	        				<form:select path="dia" id="filters_select_c4" >
			                		<%for(int i=1;i<=31;i++){ %>
			                			<%if(i<10){ %>
			                				<option value="<%="0"+(i) %>">
														<%="0"+(i)%>
											</option>
			                			<%}else {%>
			                				<form:option value="<%=(i) %>"><%=(i) %></form:option>
			                		<%}} %>
			                   </form:select><span style="color:#990000;font-size:11px;">(D&iacute;a)</span>
						</td>
						<td width="155px" class="perfil_user_content_line">
	        				<form:select path="mes" id="filters_select_c3" >
			                		<form:option value="01">Enero</form:option>
			                		<form:option value="02">Febrero</form:option>
			                		<form:option value="03">Marzo</form:option>
			                		<form:option value="04">Abril</form:option>
			                		<form:option value="05">Mayo</form:option>
			                		<form:option value="06">Junio</form:option>
			                		<form:option value="07">Julio</form:option>
			                		<form:option value="08">Agosto</form:option>
			                		<form:option value="09">Septiembre</form:option>
			                		<form:option value="10">Octubre</form:option>
			                		<form:option value="11">Noviembre</form:option>
			                		<form:option value="12">Diciembre</form:option>
			                   </form:select><span style="color:#990000;font-size:11px;">(Mes)</span>
						</td>
						<td width="155px" class="perfil_user_content_line">
	        				<form:select path="anio" id="filters_select_c2" >
			                		<%for(int i=1;i<150;i++){ %>
			                		<form:option value="<%=(i+1950) %>"><%=(i+1950) %></form:option>
			                		<%} %>
			                   </form:select><span style="color:#990000;font-size:11px;">(A&ntilde;o)</span>
	        				
						</td>
					</tr>
					<tr>
						<td colspan="2" width="310px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				Correo Electr&oacute;nico* <form:errors path="correo" cssClass="error" />
						</td>

						<td colspan="2" width="310px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				C&oacute;digo Postal* <form:errors path="cp" cssClass="error" />
						</td>
					</tr>
					<tr>
						<td colspan="2" width="310px">
	        				<div class="perfil_user_content_izq_form_campof">
	        					<form:input path="correo"/>
	        				</div>
						</td>

						<td colspan="2" width="310px">
	        				<div class="perfil_user_content_izq_form_campof">
	        					<form:input path="cp"/>
	        				</div>
						</td>
					</tr>
					<tr>
						<td colspan="2" width="310px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				N&uacute;mero de celular* <form:errors path="celular" cssClass="error" />
						</td>
						<td colspan="2" width="310px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				Confirma celular* <form:errors path="celularcheck" cssClass="error" />
						</td>
					</tr>
					<tr>
						<td colspan="2" width="310px">
	        				<div class="perfil_user_content_izq_form_campof">
	        					<c:choose>
	        						<c:when test="${userBean.bloqueoCelular!='blockeo' }">
	        							<form:input path="celular" maxlength="10" onKeypress="if (event.keyCode < 48 || event.keyCode > 57) event.returnValue = false;"/>
	        						</c:when>
	        						<c:otherwise>
	        							<span>${userBean.celular }</span>
	        						</c:otherwise>
	        					</c:choose>
	        				</div>
						</td>

						<c:if test="${userBean.bloqueoCelular!='blockeo' }">
	        				<td colspan="2" width="310px">
	        					<div class="perfil_user_content_izq_form_campof">
	        						<input type="text" maxlength="10" name="celularcheck"  onPaste="alert('No puedes pegar');return false" />
	        					</div>
							</td>
						</c:if>
						
						<c:if test="${userBean.bloqueoCelular=='blockeo' }">
	        				<td colspan="2" width="310px">

							</td>
						</c:if>
					</tr>
					<tr>
	        			<td colspan="2" width="310px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				Compa&ntilde;&iacute;a telef&oacute;nica*
						</td>
	        			<td colspan="2" width="310px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				Plan de línea telefónica
						</td>
					</tr>
					<tr>
						<td colspan="2" width="310px" class="perfil_user_content_line">
	        				<form:select path="compania" id="filters_select_cel">
			                		<form:options items="${userBean.companias }" itemLabel="descripcion" itemValue="id"/>
			                </form:select>
						</td>
					
	        			<td colspan="2" width="310px" class="perfil_user_content_line">
			                	<form:select path="tipoplan" id="filters_select_cel_2">
			                		<form:option value="1">Prepago</form:option>
			                		<form:option value="2">Renta Mensual</form:option>
			                		<form:option value="3">Mixto</form:option>
			                   </form:select>
						</td>
					</tr>

        		</table>
        		
        	</div>
        	<div class="perfil_user_content_izq_botones">
        		<br/>
        		<input type="image" src="<c:url value="/images/perfilUser/guardar.png"/>"/>
				<a href="<c:url value="#"/>"><img src="<c:url value="/images/perfilUser/cancelar.png"/>" /></a>
				<br/>
				<br/>
        	</div>
        	</form:form>
        	<!-- INVITACIONES -->
        	<!--  <div class="perfil_user_content_izq_share">
        		<div class="perfil_user_content_izq_share_n1">
        		
        		</div>
        		<div class="perfil_user_content_izq_share_n2">
        			<div class="perfil_user_content_izq_share_h">
        				<center><a href="<c:url value="#"/>"><img src="<c:url value="/images/perfilUser/invitar_h.png"/>" /></a></center>
        			</div>
        			<div class="perfil_user_content_izq_share_y">
        				<a href="<c:url value="#"/>"><img src="<c:url value="/images/perfilUser/invitar_y.png"/>" /></a>
        			</div>
        		</div>
        		<div class="perfil_user_content_izq_share_n2">
        			<div class="perfil_user_content_izq_share_h">
        				<center><a href="<c:url value="#"/>"><img src="<c:url value="/images/perfilUser/invitar_g.png"/>" /></a></center>
        			</div>
        		</div>
        	</div>-->
        	
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
    
</body>
</html>