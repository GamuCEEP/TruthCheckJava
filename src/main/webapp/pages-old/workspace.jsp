<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : workspace
    Created on : 14 feb 2022, 10:31:03
    Author     : Alumno Mañana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bienvenida - TruthCheck</title>
    <link rel="icon" href="<%= request.getContextPath()%>/images/logo.png"/>

    <link rel="stylesheet" href="<%= request.getContextPath()%>/pages/css/root.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/pages/css/workspace.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/pages/css/modal.css">
    <link rel="stylesheet" href="<%= request.getContextPath()%>/pages/css/mapInput.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Milonga&display=swap" rel="stylesheet">

    <script src="<%= request.getContextPath()%>/pages/js/root.js"></script>
    <script src="<%= request.getContextPath()%>/pages/js/mapInput.js"></script>
  </head>

  <body>
    <header>
      <div id="logo">
        <a href="/TruthCheckJava/home">
          <img src="/TruthCheckJava/images/logo.png" alt="~TC~" width="80">
        </a>
      </div>
      <div id="userIcon">
        <div id="userIcon">
        <c:if test="${sessionScope.userName == null}">
          <a href="/TruthCheck/welcome">Entrar / Registrarse</a>
        </c:if>
        <c:if test="${sessionScope.userName != null}">
          <p>${sessionScope.userName}</p>
          <img src="/TruthCheckJava/images/profilePicture.png" width="80px"/>
        </c:if>
      </div>
    </header>
    <main>
      <div>
        <form action="action" >
          <c:forEach var="type" items="${ResourceTypes}">
            <button formaction="/TruthCheckJava/gallery" name="${type.toString()}">
              ${type.getWebText()}
            </button>
          </c:forEach>
        </form>
      </div>
      <div>

        <c:choose>
          <c:when test="${ResourceType == 'actor'}">
            <%@include file="../WEB-INF/jspf/actorModal.jspf"%>
          </c:when>
          <c:when test="${ResourceType == 'item'}">
            <%@include file="../WEB-INF/jspf/itemModal.jspf"%>
          </c:when>
          <c:when test="${ResourceType == 'stage'}">
            <%@include file="../WEB-INF/jspf/stageModal.jspf"%>
          </c:when>
          <c:when test="${ResourceType == 'map'}">
            <%@include file="../WEB-INF/jspf/mapModal.jspf"%>
          </c:when>
          <c:when test="${ResourceType == 'effect'}">
            <%@include file="../WEB-INF/jspf/effectModal.jspf"%>
          </c:when>
          <c:when test="${ResourceType == 'interaction'}">
            <%@include file="../WEB-INF/jspf/interactionModal.jspf"%>
          </c:when>
          <c:when test="${ResourceType == 'relation'}">
            <%@include file="../WEB-INF/jspf/relationModal.jspf"%>
          </c:when>
          <c:when test="${ResourceType == 'event'}">
            <%@include file="../WEB-INF/jspf/eventModal.jspf"%>
          </c:when>
          <c:otherwise>
            <%@include file="../WEB-INF/jspf/actorModal.jspf"%>
          </c:otherwise>
        </c:choose>        

      </div>
    </main>



  </body>

</html>
