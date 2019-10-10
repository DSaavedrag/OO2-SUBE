package negocio;

import java.util.GregorianCalendar;

public class Funciones {
	
	//1 = domingo, 7 = sabado
	public static int traerNumeroDiaSemana (GregorianCalendar fecha){
		return fecha.get(GregorianCalendar.DAY_OF_WEEK);
	}
	
	
	public static String traerNombreDia (int numeroNombreDiaSemana){
		String [] vectorNombres = {"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
		return vectorNombres[numeroNombreDiaSemana-1];
	}
	
	
	//trae numero de dia del mes
	public static int traerNumeroDiaMes (GregorianCalendar fecha){
		return fecha.get(GregorianCalendar.DAY_OF_MONTH);
	}
	
	
	//Obtener numero de mes. Ejemplo: Diciembre = 12 , no 11
	public static int traerNumeroMes (GregorianCalendar fecha){
		return fecha.get(GregorianCalendar.MONTH)+1;
	}

	
	public static String traerNombreMes (int numeroMes){
		String [] vectorNombres = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio",
								"Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
		return vectorNombres[numeroMes-1];
	}
	
	
	public static int traerHoras (GregorianCalendar fecha){
		return fecha.get(GregorianCalendar.HOUR);
	}
	
	public static int traerMinutos (GregorianCalendar fecha){
		return fecha.get(GregorianCalendar.MINUTE);
	}
	
	public static int traerSegundos (GregorianCalendar fecha){
		return fecha.get(GregorianCalendar.SECOND);
	}
	
	
	public static int traerCantidadDiasMes(int mes, int anio){
		int diasMes = 0;
		
		switch (mes){
			case 1: case 3: case 5: 
			case 7: case 8: case 10:
			case 12:{
				diasMes = 31;
				break;
			}
			case 2:{
				if (esBisiesto(anio)){
					diasMes = 29;
					break;
				}else{
					diasMes = 28;
					break;
				}
			}
			case 4: case 6:
			case 9: case 11:{
				diasMes = 30;
				break;
			}
		}
		return diasMes;	
	}
	
	
	public static int traerNumeroAnio (GregorianCalendar fecha){
		return fecha.get(GregorianCalendar.YEAR);
	}
	

	public static boolean esBisiesto (int anio){
		return((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0)));
	}
	

	//fechaCorta
	public static String traerFechaCorta (GregorianCalendar fecha){
		
		int numeroDia = traerNumeroDiaMes(fecha);
		String stringNumeroDia = "";
		if (numeroDia < 10){
			stringNumeroDia = "0" + numeroDia;
		} else {
			stringNumeroDia = "" + numeroDia;
		}
		
		int numeroMes = traerNumeroMes(fecha); 
		String stringNumeroMes = "";
		if (numeroMes < 10){
			stringNumeroMes = "0" + numeroMes;
		} else {
			stringNumeroMes = "" + numeroMes;
		}
		
		int numeroAnio = traerNumeroAnio(fecha);
				
		String fechaCorta = stringNumeroDia + "/" + stringNumeroMes + "/" + numeroAnio;
		
		return fechaCorta;
	}
	
	
	public static String traerFechaCortaConHora (GregorianCalendar fecha){
		
		int numeroDia = traerNumeroDiaMes(fecha);
		String stringNumeroDia = "";
		if (numeroDia < 10){
			stringNumeroDia = "0" + numeroDia;
		} else {
			stringNumeroDia = "" + numeroDia;
		}
		
		int numeroMes = traerNumeroMes(fecha); 
		String stringNumeroMes = "";
		if (numeroMes < 10){
			stringNumeroMes = "0" + numeroMes;
		} else {
			stringNumeroMes = "" + numeroMes;
		}
		
		int numeroAnio = traerNumeroAnio(fecha);
		
		int horas = traerHoras(fecha);
		String stringHoras = "";
		if (horas < 10){
			stringHoras = "0" + horas;
		} else {
			stringHoras = "" + horas;
		}
		
		int minutos = traerMinutos(fecha);
		String stringMinutos = "";
		if (minutos < 10){
			stringMinutos = "0" + minutos;
		} else {
			stringMinutos = "" + minutos;
		}
		
		int segundos = traerSegundos(fecha);
		String stringSegundos = "";
		if (segundos < 10){
			stringSegundos = "0" + segundos;
		} else {
			stringSegundos = "" + segundos;
		}
		
				
		String fechaCorta = stringNumeroDia + "/" + stringNumeroMes + "/" + numeroAnio +
				"-" + stringHoras + ":" + stringMinutos + ":" + stringSegundos;
		
		return fechaCorta;
	}
	
		
	//fechaLarga
	public static String traerFechaLarga (GregorianCalendar fecha){
		
		int numeroDiaSemana = traerNumeroDiaSemana(fecha);
		String nombreDia = traerNombreDia(numeroDiaSemana);
		
		int numeroDia = traerNumeroDiaMes(fecha);
		
		//String nombreDia = traerNombreDia(traerNumeroDiaMes(fecha));
		
		int numeroMes = traerNumeroMes(fecha); 
		String nombreMes = traerNombreMes(numeroMes);
		
		//String nombreMes = traerNombreMes(traerNumeroMes(fecha)); 
		
		int numeroAnio = traerNumeroAnio(fecha);
		
		return nombreDia + " " + numeroDia + " de " + nombreMes + " del " + numeroAnio;
	}
	
	
/*	Recibe dos fechas
	Devuelve -1 si fecha1 esta anterior a fecha 2
	Devuelve 0 si es la misma fecha
	Devuelve 1 si fecha1 es posterior a fecha2*/
	public static int compararFechas (GregorianCalendar fecha1 , GregorianCalendar fecha2){
		int resultado;
		
		if (fecha1.before(fecha2)){
			resultado = -1;
		} else if (fecha1.after(fecha2)){
			resultado = 1;
		} else {
			resultado = 0;
		};
				
		return resultado;
	}
	
	
	public static boolean sonFechasIguales(GregorianCalendar fecha1, GregorianCalendar fecha2){
		Funciones f = new Funciones();
		return (
				(f.traerNumeroDiaMes(fecha1)==f.traerNumeroDiaMes(fecha2))&&
				(f.traerNumeroMes(fecha1)==f.traerNumeroMes(fecha2))&&
				(f.traerNumeroAnio(fecha1)==f.traerNumeroAnio(fecha2))
				);
	}
	
	public static boolean sonFechasIgualesConHoras(GregorianCalendar fecha1, GregorianCalendar fecha2){
		Funciones f = new Funciones();
		return (
				(f.traerNumeroDiaMes(fecha1)==f.traerNumeroDiaMes(fecha2))&&
				(f.traerNumeroMes(fecha1)==f.traerNumeroMes(fecha2))&&
				(f.traerNumeroAnio(fecha1)==f.traerNumeroAnio(fecha2))&&
				(f.traerHoras(fecha1)==f.traerHoras(fecha2))&&
				(f.traerMinutos(fecha1)==f.traerMinutos(fecha2))&&
				(f.traerSegundos(fecha1)==f.traerSegundos(fecha2))
				);
	}
	
	//consideramos habil de lunes a viernes. domingo = 1, sabado = 7
	public static boolean esDiaHabil(GregorianCalendar fecha){
		Funciones f = new Funciones();
		return
			(f.traerNumeroDiaSemana(fecha)==2)||
			(f.traerNumeroDiaSemana(fecha)==3)||
			(f.traerNumeroDiaSemana(fecha)==4)||
			(f.traerNumeroDiaSemana(fecha)==5)||
			(f.traerNumeroDiaSemana(fecha)==6);
	}
	
	public static boolean esFechaValida (int anio, int mes, int dia){
		boolean resultado = false;
		if (anio > 0){
			if ((mes > 0) && (mes < 13)){
				switch(mes){
					case 1: case 3: case 5: case 7: case 8: case 10: case 12:{
						if ((dia>0)&&(dia<32)){
							resultado = true;
						};
						break;
					}
					case 4: case 6: case 9: case 11:{
						if ((dia>0)&&(dia<31)){
							resultado = true;
						};
						break;
					}
					case 2:{
						if (esBisiesto(anio)){
							if ((dia>0)&&(dia<30)){
								resultado = true;
							};
						}else{
							if ((dia>0)&&(dia<29)){
								resultado = true;
							};
						}
					}
				}
			}
		}	
			
		return resultado;	
	}
	
	//0=enero, 11=diciembre
	public static GregorianCalendar traerFechaDesdeIntAGregorian(int anio, int mes, int dia){
		GregorianCalendar fecha = new GregorianCalendar (anio,mes,dia);
		return fecha;
	}
	
	//dd/mm/aaaa
	public static GregorianCalendar traerFechaDesdeStringAGregorian(String fecha){
		int intDia = 0;
		int intMes = 0;
		int intAnio = 0;
		
		String stringDia = fecha.substring(0,2);
		String stringMes = fecha.substring(3,4);
		String stringAnio = fecha.substring(5,9);
		
		intDia = Integer.parseInt(stringDia);
		intMes = Integer.parseInt(stringMes)-1;
		intAnio = Integer.parseInt(stringAnio);
		
		GregorianCalendar fechaResultado = new GregorianCalendar(intAnio,intMes,intDia);
		
		return fechaResultado;
	}
	
	
	public static String traerFechaCortaActual(){
		
		GregorianCalendar fechaActual = new GregorianCalendar();
		
		int numeroDia = traerNumeroDiaMes(fechaActual);
		String stringNumeroDia = "";
		if (numeroDia < 10){
			stringNumeroDia = "0" + numeroDia;
		} else {
			stringNumeroDia = "" + numeroDia;
		}
		
		int numeroMes = traerNumeroMes(fechaActual); 
		String stringNumeroMes = "";
		if (numeroMes < 10){
			stringNumeroMes = "0" + numeroMes;
		} else {
			stringNumeroMes = "" + numeroMes;
		}
		
		int numeroAnio = traerNumeroAnio(fechaActual);
				
		String fechaCortaActual = stringNumeroDia + "/" + stringNumeroMes + "/" + numeroAnio;
		
		return fechaCortaActual;
	}
		
 
	//si el 3° decimal es mayor o igual 5, suma 1 al 2° decimal
	public static double aproximar2Decimales(double numero){
		
		//Ejemplo: Numero = 5,123
		
		//5,123 + 0,005 = 5,128
		numero += 0.005;

		//5,128 * 100 = 512,8
		numero *= 100;

		//Parte entera de 512,8 = 512
		int parteEntera = (int)numero;

		//512/100 = 5,12
		return (double)parteEntera/100;
		//5,12
		
	}
	
	
	public static boolean esPrimo(int numero){
		boolean resultado = true;
		int i = 2;
		if (numero==1){
			resultado = false;
		}else if (numero>0){
			while ((resultado)&&(i<=(int)Math.sqrt(numero))){
				if (numero%i==0){
					resultado = false;
				}
				i++;
			}
		}
		return resultado;
	}
	
	
	public static boolean esPrimoMellizo(int primo1, int primo2){
		boolean resultado = false;
		if (esPrimo(primo1) && esPrimo(primo2)){
			if (primo1 > primo2){
				if (primo1 - primo2 == 2){
					resultado = true;
				}
			}else if (primo1 < primo2){
				if (primo2 - primo1 == 2){
					resultado = true;
				}
			}else{
				resultado = false;
			}
		}
			return resultado;
	}
	

	public static boolean esNumero(char c){
		return Character.isDigit(c);
	}
	
	
	public static boolean esCaracter(char c){
		return Character.isLetter(c);
	}
	
	
	public static boolean esCadenaNumeros(String cadena){
		if ((cadena == null)||(cadena.isEmpty())){
			return false;
		}
		
		for (int i = 0; i < cadena.length() ; i++){
			if (!esNumero(cadena.charAt(i)))
				return false;
		}
				
		return true;
	}
	
	
	public static boolean esCadenaLetras(String cadena){
		if ((cadena == null)||(cadena.isEmpty())){
			return false;
		}
		
		for (int i = 0; i < cadena.length() ; i++){
			if (!esCaracter(cadena.charAt(i)))
				return false;
		}
				
		return true;
	}
}
	
	/* CALCULAR EDAD EN STRING
	public String calcularEdad(GregorianCalendar fechaActual){
		String edad = "";
		
		Funciones f = new Funciones();
		
		int diaActual = f.traerNumeroDiaMes(fechaActual);
		int mesActual = f.traerNumeroMes(fechaActual);
		int anioActual = f.traerNumeroAnio(fechaActual);
		
		int diaNacimiento = f.traerNumeroDiaMes(getFechaNacimiento());
		int mesNacimiento = f.traerNumeroMes(getFechaNacimiento());
		int anioNacimiento = f.traerNumeroAnio(getFechaNacimiento());
	
		int dia = 0;
		int mes = 0;
		int anio = 0;
			
		if 	((f.compararFechas(fechaActual,getFechaNacimiento())==-1)){
			System.out.println("ERROR en las fechas.");
		}else{
			anio = anioActual - anioNacimiento;
			
			if((mesActual - mesNacimiento) > 0){
				mes = (mesActual - mesNacimiento);
				if((diaActual - diaNacimiento) > 0){
					dia = diaActual - diaNacimiento;
				}else if (diaActual - diaNacimiento < 0){
					dia = f.cantidadDiasMes(mesActual-1,anioActual) + (diaActual - diaNacimiento);
					mes--;
				}else{
					dia = 0;
				};
				
			}else if((mesActual - mesNacimiento) < 0){
				mes = 12 - mesNacimiento + mesActual;
				anio --;
				if((diaActual - diaNacimiento) > 0){
					dia = diaActual - diaNacimiento;
				}else if (diaActual - diaNacimiento < 0){
					dia = f.cantidadDiasMes(mesActual-1,anioActual) + (diaActual - diaNacimiento);
					mes--;
				}else{
					dia = 0;
				};
				
			//((mesActual - mesNacimiento)==0)	
			}else{
				if ((diaActual - diaNacimiento) > 0){
					mes = 11;
					dia = diaActual - diaNacimiento; 
					if ((anioActual - anioNacimiento)>0){
						anio = (anioActual - anioNacimiento - 1);
					}else if ((anioActual-anioNacimiento==0)){
						mes = 0;
					}
				}
				else if( (diaActual - diaNacimiento) < 0){
					mes = 0;
					dia = diaNacimiento - diaActual;
				}else{
					dia = 0;
				}
			};
			
			//Si el año es bisiesto, sumo un dia
			if ((mesActual > 2) && f.esBisiesto(anioActual)){
				dia++;
			};
		}		
		
		edad = anio+" anios, "+mes+" meses,"+dia+" dias.";
		return edad;		
	}
	*/
	
	
	/* CALCULAR EDAD CON INT
	public int calcularEdad (GregorianCalendar fechaActual){
		Funciones f = new Funciones();
		
		int diaActual = f.traerNumeroDiaMes(fechaActual);
		int mesActual = f.traerNumeroMes(fechaActual);
		int anioActual = f.traerNumeroAnio(fechaActual);
		
		int diaNacimiento = f.traerNumeroDiaMes(getFechaNacimiento());
		int mesNacimiento = f.traerNumeroMes(getFechaNacimiento());
		int anioNacimiento = f.traerNumeroAnio(getFechaNacimiento());
		
		int edad = anioActual - anioNacimiento;
				
		if((mesActual < mesNacimiento) || ((mesActual == mesNacimiento) && (diaActual < diaNacimiento))){
			edad = edad - 1;
		}
		
		return edad;
	}
	*/
	
	
	/* CALCULAR TIEMPO NETO
		public String calcularTiempoNeto (){
		Funciones f = new Funciones();
		
		String resultado = "";
		int horaResultado;
		int minResultado;
		int segResultado;
		
		int segLlegada = f.traerSegundos(fechaLlegada);
		int minLlegada = f.traerMinutos(fechaLlegada);
		int horaLlegada = f.traerHoras(fechaLlegada);
		
		int segSalida = f.traerSegundos(fechaSalida);
		int minSalida = f.traerMinutos(fechaSalida);
		int horaSalida = f.traerHoras(fechaSalida);
		
		if 	((f.compararFechas(fechaLlegada,getFechaSalida())==-1)){
			System.out.println("ERROR en las fechas.");
			return resultado;
		}else{
			horaResultado = horaLlegada - horaSalida;
			
			if (minLlegada >= minSalida){
				minResultado = minLlegada - minSalida;
			} else {
				minResultado = 60 + minLlegada - minSalida;
				horaResultado = horaResultado - 1;
			}
			
			if (segLlegada >= segSalida){
				segResultado = segLlegada - segSalida;
			} else {
				segResultado = 60 + segLlegada - segSalida;
				minResultado = minResultado - 1;
			}
			
			resultado = horaResultado + ":" + minResultado + ":" + segResultado;
			return resultado;
		}
	}
	*/
	
	
	
	
