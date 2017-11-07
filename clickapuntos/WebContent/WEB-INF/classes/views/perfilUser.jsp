<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
	<link type="text/css" rel="stylesheet" href="<c:url value="/css/clicka_videos.css"/>"/>
	<link type="text/css" rel="stylesheet" href="<c:url value="/css/userPerfil.css"/>"/>
	<script type="text/javascript" src='<c:url value="/js/JQ.js"/>'></script>
	<script type="text/javascript" src="<c:url value="/js/combo.js"/> "></script>
	<script type="text/javascript" src="<c:url value="/js/comboBox.js"/>"></script>	
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
    		width: "150px" 
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
    		width: "150px" 
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
    		width: "150px" 
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
    		width: "150px" 
    	});
   }); </script>
	<div class="container">
    	<!-- INIT HEADER -->
    	<div class="header">
            <div class="header_user_bar">
                <ul>
                    <li><div class="header_salir"></div> <a href="#">Salir</a></li>
                    <li><div class="header_perfil"></div> <a href="<c:url value="/perfilUser.htm"/>">Perfil</a></li>
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
     <!-- CONTENEDOR DE PERFIL DE USUARIO -->
    <div class="perfil_user_content">
        <!-- IZQUIERDO CONTENIDO -->
        <div class="perfil_user_content_left">
        	<!-- CAMBIO DE PAGINAS -->
        	<div class="perfil_user_content_izq_page">
        			<a href="<c:url value="#"/>"><img src="<c:url value="/images/perfilUser/izq_pag1.png"/>" /></a>
        			<a href="<c:url value="#"/>"><img src="<c:url value="/images/perfilUser/izq_pag2.png"/>" /></a>
        	</div>
        	<!-- FOTOS -->
        	<div class="perfil_user_content_izq_foto">
        		<div class="perfil_user_content_izq_foto_foto">
        		</div>
        		<div class="perfil_user_content_izq_foto_upload">
        			<div class="perfil_user_content_izq_page_sube">
        				<span>Sube t&uacute; foto</span>
        			</div>
        			<div class="perfil_user_content_izq_foto_cambios">
        				<a href="<c:url value="#"/>"><img src="<c:url value="/images/perfilUser/cambiar.png"/>" /></a>
        				<a href="<c:url value="#"/>"><img src="<c:url value="/images/perfilUser/eliminar.png"/>" /></a>
        			</div>
        		</div>
        	</div>
        	<!-- FORMULARIO -->
        	<form action="#">
        	<div class="perfil_user_content_izq_form">
        		<table>
	        		<tr>
	        			<td colspan="2" width="310px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				<br/>
	        				Apellido Paterno
	        				<br/>
						</td>
						<td colspan="2" width="310px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				<br/>
	        				Apellido Materno
	        				<br/>
						</td>
					</tr>
					<tr>
	        			<td colspan="2" width="310px">
	        				<div class="perfil_user_content_izq_form_campof">
	        					<input type="text" name="apellidoPaterno">
	        				</div>
						</td>
						<td colspan="2" width="310px">
	        				<div class="perfil_user_content_izq_form_campof">
	        					<input type="text" name="apellidoMaterno">
	        				</div>
						</td>
					</tr>
					<tr>
	        			<td colspan="2" width="310px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				Nombre(s)*
						</td>
						<td colspan="2" width="310px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				Nickname*
						</td>
					</tr>
					<tr>
	        			<td colspan="2" width="310px">
	        				<div class="perfil_user_content_izq_form_campof">
	        					<input type="text" name="nombre">
	        				</div>
						</td>
						<td colspan="2" width="310px">
	        				<div class="perfil_user_content_izq_form_campof">
	        					<input type="text" name="nickname">
	        				</div>
						</td>
					</tr>
					<tr>
	        			<td colspan="2" width="310px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				Correo
						</td>
						<td colspan="2" width="310px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				Celular
						</td>
					</tr>
					<tr>
	        			<td colspan="2" width="310px">
	        				<div class="perfil_user_content_izq_form_campof">
	        					<input type="text" name="correo">
	        				</div>
						</td>
						<td colspan="2" width="310px">
	        				<div class="perfil_user_content_izq_form_campof">
	        					<input type="text" name="celular">
	        				</div>
						</td>
					</tr>
					<tr>
	        			<td  width="155px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				Sexo
						</td>
						<td width="155px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				Fecha de nacimiento
						</td>
						<td width="155px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				
						</td>
						<td width="155px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				
						</td>
					</tr>
					<tr >
	        			<td  width="155px" class="perfil_user_content_line">
			                	<select name="sexo" id="filters_select_c" >
			                		<option value="M">Masculino</option>
			                		<option value="F">Femenino</option>
			                   </select>
	        				<br/>
						</td>
						<td width="155px" class="perfil_user_content_line">
	        				<select name="Anio" id="filters_select_c2" >
			                		<%for(int i=1;i<200;i++){ %>
			                		<option value="<%=(i+1910) %>"><%=(i+1900) %></option>
			                		<%} %>
			                   </select><span style="color:#990000;font-size:11px;">(A&ntilde;o)</span>
	        				
						</td>
						<td width="155px" class="perfil_user_content_line">
	        				<select name="mes" id="filters_select_c3" >
			                		<option value="01">Enero</option>
			                		<option value="02">Febrero</option>
			                		<option value="03">Marzo</option>
			                		<option value="04">Abril</option>
			                		<option value="05">Mayo</option>
			                		<option value="06">Junio</option>
			                		<option value="07">Julio</option>
			                		<option value="08">Agosto</option>
			                		<option value="09">Septiembre</option>
			                		<option value="10">Octubre</option>
			                		<option value="11">Noviembre</option>
			                		<option value="12">Diciembre</option>
			                   </select><span style="color:#990000;font-size:11px;">(Mes)</span>
	        				
						</td>
						<td width="155px" class="perfil_user_content_line">
	        				<select name="Anio" id="filters_select_c4" >
			                		<%for(int i=1;i<31;i++){ %>
			                			<%if(i<10){ %>
			                				<option value="<%="0"+(i) %>"><%="0"+(i) %></option>
			                			<%}else {%>
			                				<option value="<%=(i) %>"><%=(i) %></option>
			                		<%}} %>
			                   </select><span style="color:#990000;font-size:11px;">(D&iacute;a)</span>
						</td>
					</tr>
					<tr>
	        			<td  width="155px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				Pa&iacute;s
						</td>
						<td width="155px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				Estado
						</td>
						<td width="155px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				Ciudad
						</td>
						<td width="155px" class="perfil_user_content_izq_form_otros_left_campo1">
	        				C&oacute;digo Postal
						</td>
					</tr>
					<tr >
	        			<td  width="155px" class="perfil_user_content_line">
	        				<div class="perfil_user_content_izq_form_otros_left_campof1">
	        					<input type="text" name="pais">
	        				</div>
	        				<br/>
						</td>
						<td width="155px" class="perfil_user_content_line">
	        				<div class="perfil_user_content_izq_form_otros_left_campof1">
	        					<input type="text" name="estado">
	        				</div>
	        				<br/>
						</td>
						<td width="155px" class="perfil_user_content_line">
	        				<div class="perfil_user_content_izq_form_otros_left_campof1">
	        					<input type="text" name="ciudad">
	        				</div>
	        				<br/>
						</td>
						<td width="155px" class="perfil_user_content_line">
	        				<div class="perfil_user_content_izq_form_otros_left_campof1">
	        					<input type="text" name="cp">
	        				</div>
	        				<br/>
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
        	</form>
        	<!-- INVITACIONES -->
        	<div class="perfil_user_content_izq_share">
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
        	</div>
        </div>
        <!-- DERECHO PUBLICIDAD-->
        <div class="perfil_user_content_rigth">
        	<br>
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