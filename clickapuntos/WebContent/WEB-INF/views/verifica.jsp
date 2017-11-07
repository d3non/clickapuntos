<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <META http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>Upload Example</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="../css/clicka_videos.css"/>"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="../css/userPerfil.css"/>"/>
    <script >
		function closeVentana() {
			window.parent.tb_remove(true);
		} 
		function openVentana(url){
			window.parent.tb_show(null,url+'?&keepThis=true&TB_iframe=true&height=200&width=400',null);
		}
	</script>
</head>
<body>
<div class="modal">
	<div class="modal_tittle">
		<div class="modal_tittle_s">
			<center><span>Verificando...</span></center>
		</div>
	</div>
	<div class="modal_content">
		<center>
		<table>
			<tr>
				<td class="perfil_user_content_izq_form_otros_left_campo1" >
					¿Es correcto el n&uacute;mero de celular agregado en tu perfil?<br>
					(Se te enviar&aacute; un c&oacute;digo de verificacion)
				</td>
			</tr>
			<tr>
				<td>
					<center>
							<a href="javascript:openVentana('premiosVerificacion/${idPremio }.htm')">
								<img src="<c:url value="../images/perfilUser/si.png"/>"/>
							</a>
							<a href="javascript:closeVentana();">
								<img src="<c:url value="../images/perfilUser/no.png"/>"/>
							</a>
					</center>
				</td>
			</tr>
		</table>
		</center>
	</div>
	</div>
    </body>
</html>