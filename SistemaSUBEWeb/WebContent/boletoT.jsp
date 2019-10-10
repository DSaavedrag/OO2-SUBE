<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="datos.Tarjeta"%>
<%@page import="datos.Boleto"%>
<%@page import="datos.Estacion"%>
<%@page import="datos.LectorTren"%>
<%@page import="datos.Lector"%>
<%@page import="java.util.*"%>
<%@page import="negocio.LectorTrenABM"%>
<%@page import="negocio.LectorABM"%>
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

<% 	LectorTrenABM labm =  LectorTrenABM.getInstanciaLectorTrenABM();
	List<LectorTren> lista = labm.traer();
 
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carga de boleto subte - Carga</title>
</head>
<BODY>

	<FORM method="POST" action="/SistemaSUBEWeb/GenerarBoletoT">
		Seleccionar estacion <BR> <BR>
		<TABLE border="0">
			<TR>
				<TD>idTarjeta:</TD>
				<TD><INPUT name="idTarjeta"></TD>
			</TR>
			<tr>
				<select name="estacion">
					<%
					for (LectorTren s: lista){
						LectorTren lectorAux = labm.traerLectorYEstacion(s.getIdLector());
						String es = "Entrada";
						if(s.isSalida()){
							es = "Salida";
						}
						String estacionAux = lectorAux.getEstacion().getEstacion()+" | "+es;
						String optionMenu = "<option value=\""+s.getIdLector()+"\">"+estacionAux+"</option>";
						out.print(optionMenu);
					}
					%>
					
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