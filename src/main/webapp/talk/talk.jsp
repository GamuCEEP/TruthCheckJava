<%-- 
    Document   : loginError
    Created on : 12 feb 2022, 12:00:01
    Author     : GamuD
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%
  if(request.getAttribute("message") == null) return;
%>
<%=request.getAttribute("message").toString()%>