<%@ page contentType="text/html; charset=GBK"%>
<html>
<head><title></title></head>
<body>
<%
  String panelClassName = request.getParameter("className");
  if(panelClassName == null || "".equals(panelClassName.trim())){
%>
    <b>�˵����ô���û����ӡ�className��������<b/>
<%} else {%>
    <%@include file="/jsp/SF/Applet.jsp"%>
<%    
  }
%>
</body>
</html>