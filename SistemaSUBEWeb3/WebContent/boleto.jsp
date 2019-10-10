<%@page import="datos.Tarjeta"%>
<%@page import="datos.Boleteria"%>
<% Tarjeta tarjeta=null;
    if(session.getAttribute("Tarjeta")!=null) tarjeta=(Tarjeta)session.getAttribute("Tarjeta"); %>
<% Boleteria boleteria=null;
    if(session.getAttribute("Boleteria")!=null) boleteria=(Boleteria)session.getAttribute("Boleteria");
    double montoAnterior = 0, montoActual = 0;%>
<% if(session.getAttribute("montoAnterior")!=null) montoAnterior=(double)session.getAttribute("montoAnterior");%>
<% if(session.getAttribute("montoActual")!=null) montoActual=(double)session.getAttribute("montoActual");%>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carga de boleto</title>
</head>
<body>
	<FORM method="POST" action="/SistemaSUBEWeb/boletoS.jsp">
		<TR>
			<TABLE border="2">
				<TD><INPUT type="submit" value="Generar boleto de Subte"></TD>
				</TR>
			</TABLE>
			<BR>
	</FORM>

	<FORM method="POST" action=" /SistemaSUBEWeb/boletoC.jsp ">
			<TR>
				<TABLE border="2">
				<TD><INPUT type="submit" value="Generar boleto de Colectivo"></TD>
			</TR>
		</TABLE>
		<BR>
	</FORM>

	<FORM method="POST" action=" /SistemaSUBEWeb/boletoT.jsp ">
			<TR>
			<TABLE border="2">
				<TD><INPUT type="submit" value="Generar boleto de Tren"></TD>
			</TR>
		</TABLE>
		<BR><BR>
	</FORM>
</body>
</html>