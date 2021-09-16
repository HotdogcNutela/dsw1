<!-- Página inicial:
	 Apresenta os pacotes turísticos disponíveis (não requer autenticação) 
	 e um link para a página de login. 
-->

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
	<fmt:bundle basename="message">
		<head>
			<title><fmt:message key="homepage.title"/></title>
		</head>
		<body>
			<a href="login.jsp"><fmt:message key="homepage.login"/></a>
			<!-- TODO: listar os pacotes turísticos disponíveis -->
			<h3>Olá! Aqui serão listados os pacotes turísticos disponíveis!</h3>
		</body>
	</fmt:bundle>
</html>
