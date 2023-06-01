<html>
<body>
<h2>Hello World!</h2>
<% String path = "servlet/com.yash.servlets.ProcessorServlet";%>
<%--<form method="post" action="<%=path%>?command=getEmployee">
    <button type="submit">Get User</button>
</form>--%>
<FORM method="post" action="<%=path%>">
	<input type="hidden" name="command" value="getEmployee">
	<button type="submit">Get</button>
	<br> <br>
</FORM>
<FORM method="post" action="<%=path%>">
	<input type="hidden" name="command" value="createEmployee">
	<button type="submit">Create New</button>
</FORM>
</body>
</html>
