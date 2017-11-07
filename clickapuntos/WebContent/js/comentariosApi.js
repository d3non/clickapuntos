function crearDivs(listFil){	
	var res="<h2>"+listFil.length+" Comentarios</h2>";
	for(i=0;i < listFil.length ;i++){
		var concFil = 	listFil[i];
		res=res+'<div class="detalle_comentarios_item">';
		res=res+'<div class="detalle_datos_usuario">';
		res=res+'<div class="detalle_comentarios_image"><img src="'+concFil.usrfoto+'" alt="Detalle" />';
		res=res+'<div class="detalle_like"><a href="#"></a></div>';
		res=res+'</div>';
		res=res+'<div class="detalle_comentarios_usuario">';
		res=res+'<span>'+concFil.username+'</span> ';
		res=res+concFil.fechacomentario;
		res=res+'<ul>';
		res=res+'<li>';
		res=res+'<div class="detalle_globo"></div>';
		res=res+'Responder</li>';
		res=res+'<li>';
		res=res+'<div class="detalle_denunciar"></div>';
		res=res+'Denunciar</li>';
		res=res+'<li>';
		res=res+'<div class="detalle_megusta"></div>';
		res=res+concFil.comentariotono+'</li>';
		res=res+'</ul>';
		res=res+'</div>';
		res=res+'</div>';
		res=res+'<div class="detalle_datos_comentarios">';
		res=res+'<table><tr><td width="50px"></td><td>'
		res=res+'<p>'+concFil.comentariostexto+'</p></td></tr></table>';
		res=res+'</div>';
		res=res+'</div>';
	}
	return res;
}
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
function cambiaPuntos(numPuntos){
	var puntos=document.getElementById("puntos");
	if(numPuntos!="")
		puntos.innerHTML = numPuntos;
}

function actualizaComentarios(datos){
	var datosC = eval("(" + datos + ")");
	var listFil = datosC.list;
	var res=crearDivs(listFil);
	$("#detalle_comentarios").html(res);
}

function inicia(idPromo){
	guardaComentario('',idPromo,'','guardaComentario.htm');
}


function cargarVideo(url,anp,alp){
if(window.parent.frames[0]!=null){
	var numTiempo=window.parent.frames[0].ytplayer.getCurrentTime();
	if(numTiempo!=null){
		if(numTiempo>0)
			loadPlayer(url,anp,alp,'',numTiempo);
	}
}
else loadPlayer(url,anp,alp,'');
}

function compartir(urldir,redirect,imagepath,prdescripcion,prmecanica,prmecanicalargo){
	window.open('https://www.facebook.com/dialog/feed?app_id=333050033446083&link='+urldir+'&picture='+imagepath+'&name='+prdescripcion+'&caption='+prmecanica+'&description='+prmecanicalargo+'&display=popup&redirect_uri='+redirect,'FeedWindow', 'toolbar=0, status=0, width=450, height=250');
}

