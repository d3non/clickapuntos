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
		window.parent.tb_show(null,'${urlAccion}',null);
	</script>
</head>
<body>
</body>
</html>