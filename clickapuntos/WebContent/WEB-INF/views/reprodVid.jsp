<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<script type="text/javascript" src='<c:url value="/js/jquery.tools.min.js"/>'></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.selectbox-0.6.1.js"/> "></script>
  <head>
    
    
    <title>My JSP 'reprodVid.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <!-- 1. The <div> tag will contain the <iframe> (and video player) -->
    <div id="player"></div>

    <script>
      // 2. This code loads the IFrame Player API code asynchronously.
      var tag = document.createElement('script');
      tag.src = "http://www.youtube.com/player_api";
      var firstScriptTag = document.getElementsByTagName('script')[0];
      firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

      // 3. This function creates an <iframe> (and YouTube player)
      //    after the API code downloads.
      var player;
      function onYouTubePlayerAPIReady() {
        player = new YT.Player('player', {
          height: '400',
          width: '400',
          videoId: '${itemVideo}',
          events: {
            'onReady': onPlayerReady,
            'onStateChange': onPlayerStateChange
          }
        });
      }

      // 4. The API will call this function when the video player is ready.
      function onPlayerReady(event) {      	
        event.target.playVideo();                
      }

      // 5. The API calls this function when the player's state changes.
      //    The function indicates that when playing a video (state=1),
      //    the player should play for six seconds and then stop.
      var done = false;
      function onPlayerStateChange(event) {      	
        if (player.getPlayerState() == 0) {
        //Se tiene que cambiar despues por el usuario que esta en sesion o cookie
          alert(${idMedia});
          guardaLike(${idMedia},1, 1);
        }
      }
      function stopVideo() {                
      } 
      
      function guardaLike(idMedia,tpoAcc, idUser){
			$.ajax({
	    		   	 	url: "guardaMedia",
	      			  	data: "idMedia="+idMedia+"&tipoAccion="+tpoAcc+"&idUsuario="+idUser,
	        			success: function(datos){
	        				alert('Termina guardado');
	        			}
			});
		}
      
    </script>
  </body>
</html>
