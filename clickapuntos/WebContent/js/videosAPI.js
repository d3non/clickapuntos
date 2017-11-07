/* SCRIPT SCROLL SLIDER */
		var cboFil=new Array();
		var tamW=screen.width;
		var tamH=screen.height;
		var idUser=0;
		var rutaImagenes='';
		function openVentana(url){
			window.location=url+"?tamW="+tamW+"&tamH="+tamH;
		}
			
	
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
		function addfilter(indice){
			$.ajax({
				type: "POST",
				dataType: "text",
		   	 	url: "getFiltro.htm",
				  	data: "tipo=2&idFiltros="+indice ,
				success: function(datos){
					fillFil(datos); 		
				}
			});
		}

	
		//SCRIPT ADD FILTERS
		function addsearch(){
			var search = document.getElementById('search');
			if(search.value != ""){
				$.ajax({
					type: "POST",
					dataType: "text",
			   	 	url: "getFiltro.htm",
	  			  	data: "tipo=3&idFiltros="+search.value ,
	    			success: function(datos){
	    				 fillFil(datos); 		
	    			}
				});
			}
		}
		
		function fillFil(datos){

			var filtroLta = eval("(" + datos + ")");
	        				var listFil = filtroLta.list;
	        				
	        				var res = "";    
	        						
    						for(i=0;i < listFil.length ;i++){
    							var concFil = 	listFil[i];    							
    							
								
								res=res+'<div class="video_filters_item">';
								res=res+'<div class="video_filters_item_content">';
								res=res+'	<div class="video_filters_item_content_titulo">';
								if(concFil.idPromoTipoMecanica == 2){
									res=res+'<a href="'+concFil.promoNombreUrl+'.htm?tamW='+tamW+'&tamH='+tamH+'">';
									res=res+'<h3>'+concFil.promoDescripcion+'</h3>';
									res=res+'</a>';
								}
								else{
									if(concFil.idMedia!=null)
										res=res+'<a href="'+concFil.promoNombreUrl+'.htm?tamW='+tamW+'&tamH='+tamH+'">';
									else
										res=res+'<a href="'+concFil.promoNombreUrl+'.htm?tamW='+tamW+'&tamH='+tamH+'">';
									res=res+'<h3>'+concFil.promoDescripcion+'</h3>';
									res=res+'</a>';
								}
								res=res+'<p>';
								res=res+concFil.promoMecanica;
								res=res+'</p>';
								res=res+'	</div>';
								res=res+'	<div class="video_filters_item_content_part">';                        		
								if(concFil.idPromoTipoMecanica == 2){
									res=res+'<a href="'+concFil.promoNombreUrl+'.htm?tamW='+tamW+'&tamH='+tamH+'"></a>';	
								}
								res=res+'</div>';
			        			
								res=res+'</div>';
								res=res+'<div class="video_filters_item_image_content" >';
								if(idUser!=0){
    								if(concFil.mediaUsuarioLike == 1){
    									res = res +'<div class="video_like_active" onclick="javascript:guardaLike('+concFil.idMedia+',3,'+idUser+');likechange(this);">';
    								}else{
    									res = res +'<div class="video_like" onclick="javascript:guardaLike('+concFil.idMedia+',3,'+idUser+');likechange(this);">';
    								}
    								res = res +'</div>';
    							}
								res=res+'<div class="video_filters_item_image">';
								if(concFil.idPromoTipoMecanica == 2){
									res=res+'<a href="'+concFil.promoNombreUrl+'.htm?tamW='+tamW+'&tamH='+tamH+'">';
								}else{
									if(concFil.idMedia!=null)
										res=res+'<a href="'+concFil.promoNombreUrl+'.htm?tamW='+tamW+'&tamH='+tamH+'">';
									else
										res=res+'<a href="'+concFil.promoNombreUrl+'.htm?tamW='+tamW+'&tamH='+tamH+'">';
								}
								res=res+'<img src="../'+rutaImagenes+concFil.promoImagenVideo+'" alt="'+concFil.promoDescripcion+'"/>';
								res=res+'</a>';
								res=res+'</div>';
								res = res +'</div>';
								res=res+'<div class="video_filters_item_content_title">';
								res=res+'<ul>';
								res=res+'<li class="video_recomienda"><div class="video_filters_recomienda"></div> Recomiendalo</li>';
								res=res+'<li><img src="images/icon_view.png" alt="View" /> '+concFil.numrep+' Reproducciones</li>';
								res=res+'<li><img src="images/icon_points.png" alt="Points" /> '+concFil.promoNumeroPuntos+' Puntos</li>';
								res=res+'</ul>';
			                       	
								res=res+'</div>';
								res=res+'</div>';
    						}    						    						
					
    						$("#video_filters_result").html(res);
							tb_init('a.thickbox, area.thickbox, input.thickbox');//pass where to apply thickbox
							imgLoader = new Image();// preload image
							imgLoader.src = tb_pathToImage;
		}

		
		function guardaLike(idMedia,tpoAcc, idUser){		
			$.ajax({
	    		   	 	url: "guardaMedia.htm",
	      			  	data: "idMedia="+idMedia+"&tipoAccion="+tpoAcc+"&idUsuario="+idUser,
	        			success: function(datos){
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
		function cambiaNextPrev(tipo){
			var next=document.getElementById("slider_next").style;
   			var prev=document.getElementById("slider_prev").style;
			if(tipo=='visible'){
	   			prev.backgroundImage='url(images/slider_prev.png)';
	   			next.backgroundImage='url(images/slider_next.png)';
			}
			else{
	   			next.backgroundImage='';
	   			prev.backgroundImage='';
			}
		}