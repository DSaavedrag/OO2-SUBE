<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<title>Sistema Sube - Carga</title>
</head>
<BODY>

	<FORM method="POST" action="/SistemaSUBEWeb/CargarSaldo">
		Carga de Saldo <BR>
		<BR>
		<TABLE border="0">
			<TR>
				<TD>idTarjeta:</TD>
				<TD><INPUT name="idTarjeta"></TD>
			</TR>
			<TR>
				<TD>idBoleteria:</TD>
				<TD><INPUT name="idBoleteria"></TD>
			</TR>
			<TR>
				<TD>monto:</TD>
				<TD><INPUT name="monto"></TD>
			</TR>
			<TR>
				<TD><INPUT type="submit" value="Ejecutar"></TD>
			</TR>
		</TABLE>
	</FORM>

	<% if(tarjeta!=null){%>
	<strong>Saldo anterior: </strong>
	<%out.println(montoAnterior);%>
	<strong>Saldo actual: </strong>
	<% out.println(montoActual);
	}%>
</BODY>
</html>