<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="datos.Tarjeta"%>
<%@page import="negocio.TarjetaABM"%>
<%@page import="datos.Boleto"%>
<%@page import="datos.Carga"%>
<%@page import="java.util.*"%>
<% Tarjeta tarjeta=null;
    if(session.getAttribute("Tarjeta")!=null) tarjeta=(Tarjeta)session.getAttribute("Tarjeta"); 
    TarjetaABM tabm = TarjetaABM.getInstanciaTarjetaABM();%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema Sube - su tarjeta</title>
</head>
<BODY>

	<FORM method="POST" action="/SistemaSUBEWeb/MostrarTarjeta">
		Búsqueda de Tarjetas <BR>
		<BR>
		<TABLE border="0">
			<TR>
				<TD>IdTarjeta:</TD>
				<TD><INPUT name="IdTarjeta"></TD>
				<BR>
			</TR>
			
			<TR>
				<TD><INPUT type="submit" value="Consultar"></TD>
			</TR>
		</TABLE>
	</FORM>

	<% if(tarjeta!=null){%>
	<strong>Su saldo es: </strong>
	<%
	List<Boleto> boletos = tabm.traerBoletosDeTarjeta(tarjeta.getIdTarjeta());
	List<Carga> cargas = tabm.traerCargasDeTarjeta(tarjeta.getIdTarjeta());
	
	
	
	out.println(tarjeta.getSaldo());%>
	<BR>
	<%out.println(tarjeta.getUsuario());%>
	<BR>
	<%out.println(boletos);%>
	<BR>
	<%out.println(cargas);
	}%>
</BODY>
</html>