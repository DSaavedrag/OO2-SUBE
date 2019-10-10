<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="datos.Tarjeta"%>
<%@page import="datos.Boleto"%>
<%@page import="datos.LectorColectivo"%>
<%@page import="java.util.*"%>
<%@page import="negocio.LectorABM"%>
<%@page import="negocio.LectorColectivoABM"%>
<%@page import="negocio.LineaABM"%>
<%@page import="datos.Linea"%>
<%@page import="datos.Lector"%>
<%
	Tarjeta tarjeta = null;
	if (session.getAttribute("Tarjeta") != null)
		tarjeta = (Tarjeta) session.getAttribute("Tarjeta");
%>
<%
	Boleto boleto = null;
	if (session.getAttribute("boleto") != null)
		boleto = (Boleto) session.getAttribute("boleto");
%>

<% LectorColectivoABM lcabm =  LectorColectivoABM.getInstanciaLectorColectivoABM();
	LectorABM labm =  LectorABM.getInstanciaLectorABM();
	List<LectorColectivo> lista = lcabm.traer();
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carga de boleto subte - Carga</title>
</head>
<BODY>

	<FORM method="POST" action="/SistemaSUBEWeb/GenerarBoletoC">
		Seleccionar colectivo <BR> <BR>
		<TABLE border="0">
			<TR>
				<TD>idTarjeta:</TD>
				<TD><INPUT name="idTarjeta"></TD>
			</TR>
			<tr>
				<select name="linea">
					<%
					for (LectorColectivo lc: lista){
						Lector lectorAux = labm.traerLectorYLinea(lc.getIdLector());
						Linea lineaAux = lectorAux.getLinea();
						String valor = lineaAux.getLinea()+ " | " + lc.getInterno();
						String optionMenu = "<option value=\""+lc.getIdLector()+"\">"+valor+ "</option>";
						out.print(optionMenu);
					}
					%>
					
				</select>
			</tr>
			<tr>
				<select name="estado">
					<option value=1>Seccion 1</option>
					<option value=2>Seccion 2</option>
					<option value=3>Seccion 3</option>
					<option value=4>Seccion 4</option>
				</select>
			</tr>
			<TR>
				<TD><INPUT type="submit" value="Ejecutar"></TD>
			</TR>
		</TABLE>
	</FORM>
	<% if(tarjeta!=null){%>
	<strong>Precio boleto: </strong>
	<%out.println(boleto.getMontoConDescuentos());%>
	<strong>Saldo actual: </strong>
	<% out.println(tarjeta.getSaldo());
	}%>
	
</BODY>
</html>