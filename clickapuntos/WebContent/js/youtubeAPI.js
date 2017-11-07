// This function is called when an error is thrown by the player
    var videoID="";  
    var param="";
    var numTiempo=0;
	function onPlayerError(errorCode) {
        alert("An error occured of type:" + errorCode);
      }
      
      // This function is automatically called by the player once it loads
      function onYouTubePlayerReady(playerId) {
        ytplayer = document.getElementById("ytPlayer");
        ytplayer.addEventListener("onStateChange", "onPlayerStateChange");
        ytplayer.addEventListener("onError", "onPlayerError");
        if(numTiempo>0)
        	ytplayer.cueVideoById(videoID,numTiempo);
        else
        	ytplayer.cueVideoById(videoID);
        
        if(param!="") play();
      }
      function completa(){
    	  ytplayer.doFullScreen();
      }
      
      // The "main method" of this sample. Called when someone clicks "Run".
      function loadPlayer(url,ancho,alto,param1,numT) {
        // The video to load
    	  videoID = url;
    	  param=param1;
    	  numTiempo=numT;
        // Lets Flash from another domain call JavaScript
    	  var params = { allowScriptAccess: "always", allowFullScreen: "true"};
        // The element id of the Flash embed
        var atts = { id: "ytPlayer" };
        swfobject.embedSWF("https://www.youtube.com/apiplayer?" +
                           "version=3&enablejsapi=1&playerapiid=player1&fs=1",
                           "videoDiv", ancho, alto, "8", null, null, params, atts);
      }
      function pause(){
    	  if (ytplayer) {
    		  ytplayer.pauseVideo();
    		  var imagen=document.getElementById("playpause");
  		      imagen.src="images/reproductor/playReproductor.png";
  		      var playpause=document.getElementById("playpauselink");
  		      playpause.href='javascript:play();';
  		      imagen.alt="Play";
    	  }
      }
      function play(){
    	  if (ytplayer) {
    		    ytplayer.playVideo();
    		    var imagen=document.getElementById("playpause");
    		    imagen.src="images/reproductor/pauseReproductor.png";
    		    var playpause=document.getElementById("playpauselink");
    		    playpause.href='javascript:pause();';
    		    imagen.alt="Pause";
    	  }
      }
      function cambiaImagen(imagen,basePath){
    	var playHover=basePath+"images/reproductor/playReproductorHover.png";
    	var playNormal=basePath+"images/reproductor/playReproductor.png";
    	var pauseNormal=basePath+"images/reproductor/pauseReproductor.png";
    	var pauseHover=basePath+"images/reproductor/pauseReproductorHover.png";
    	if(imagen.src==playHover){
    		imagen.src=basePath+"images/reproductor/playReproductor.png";
    	}
    	else{
    		if(imagen.src==playNormal){
    			imagen.src=basePath+"images/reproductor/playReproductorHover.png";
    		}
    	}
    	if(imagen.src==pauseHover){
    		imagen.src=basePath+"images/reproductor/pauseReproductor.png";
    	}
    	else{
    		if(imagen.src==pauseNormal){
    			imagen.src=basePath+"images/reproductor/pauseReproductorHover.png";
    		}
    	}
    	
      }