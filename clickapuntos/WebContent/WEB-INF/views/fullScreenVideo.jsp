<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Full Screen Video</title>
<link type="text/css" rel="stylesheet" href="css/clicka_videos.css"/>
<script type="text/javascript" src='js/swfobject.js'></script>
<script type="text/javascript" src='js/youtubeAPI.js'></script>
<script type="text/javascript" src='js/jquery.tools.min.js'></script>
<script type="text/javascript" src="js/jquery.selectbox-0.6.1.js"></script>
<script>
    	function closeVentana(){
    		window.parent.ytplayer.seekTo(ytplayer.getCurrentTime(),true);
    		window.parent.play();
    		window.parent.tb_remove(true);
    	}
    	function onPlayerStateChange(newState) {
    		if(newState==1){
    			play();
    		}  
    		if(newState==2){
    			pause();
    		}  
    		if(newState==0){
    			  	guardaPuntos();
    		  }
    		}
   		function guardaPuntos(){
   			$.ajax({
   		   	 	type: "POST",
   		   	 	url: "guardaPuntosUsr.htm",
   				  	data: "idUser=${idUser}&idPromo=${idPromo}",
   				success: function(datos){
   					var puntos=window.parent.document.getElementById("puntos");
   					if(datos!="")
   						puntos.innerHTML=datos;
   				}
   		});
   		}
   		function init(){
   			window.parent.pause();
   			var cf=document.getElementById("contenido_full").style;
   			var re=document.getElementById("reproductor").style;
   			var pp=document.getElementById("playpause").style;
   			var fs=document.getElementById("fullscreen").style;
   			var alto=screen.height-188;
   			var ancho=screen.width-72;
   			cf.height=alto+'px';
   			cf.overflow='hidden';
   			re.width=ancho+'px';
   			re.height=(alto/14)+'px';
   			pp.height=(alto/14)+'px';
   			pp.width=(ancho/17)+'px';
   			fs.width=(ancho/30)+'px';
   			fs.height=(ancho/30)+'px';
   			re.backgroundImage='url(images/reproductor/barraReproductor.png)';
   			
   		}
   		function cargarVideo(){
   			var numTiempo=window.parent.ytplayer.getCurrentTime();
   			if(numTiempo>0)
   				loadPlayer('${urlVideo}','${anchoPantalla}','${altoPantalla}','play',numTiempo);
   			else
   				loadPlayer('${urlVideo}','${anchoPantalla}','${altoPantalla}','play',0);
   		}
    </script>
</head>
<body onload="init();">
	<div id="contenido_full">
		<div id="videoDiv">
	    </div>
	     <script>
	     	cargarVideo();
	     </script>
	     <div id="reproductor">
	     	<a href="javascript:play();" id="playpauselink" >
	     	<img src="images/reproductor/playReproductorHover.png" alt="Play" id="playpause" 
	     			onMouseOver="cambiaImagen(this,'<%=basePath%>')" 
	     			onmouseOut="cambiaImagen(this,'<%=basePath%>')">
	     	
	     	</a>
	     	<a href="javascript:closeVentana();">
				<img src="images/reproductor/Normalscreen.png" id="fullscreen">
			</a>
	     </div>
     </div>
</body>
</html>
