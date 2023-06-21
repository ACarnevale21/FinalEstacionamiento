# FinalEstacionamiento
Trabajo Final realizado para la materia Lenguages Orientados a Objetos. 

TRABAJO DE APROBACIÓN DE LENGUAJE ORIENTADO A OBJETOS 2022 – UCEL

La actividad se basará en un sistema de escritorio basado en JFrame con almacenamiento temporal en
arrays.

Deberá permitir la operación de dos usuarios:
  
  	a. Operador (solo realiza el ingreso/salida del vehículo – cobro de estacionamiento)
  
  	b. Supervisor (Habilita al operador, realiza consultas sobre el movimiento del estacionamiento)

Reglas del negocio
  
  	a. La playa permanece abierta de 7.00 a 2400 hs
 
  	b. Un vehículo puede ingresar y salir varias veces en el día
  
  	c. Un vehículo no puede ingresarse dos veces si no salió
  
  	d. Los vehículos pueden ser moto/auto/pick up
  
  	e. Los valores del estacionamiento varían de acuerdo con el tipo de vehículo de acuerdo a la tabla
  		adjunta.

Fracción 15 minutos (sin tolerancia – fracción menor se toma 15 minutos)
			
   		moto $ 30.00 	    Estadía $1300.00
		Auto $ 50.00 	    Estadía $3000.00
		Pick up $ 80.00     Estadía $4500.00
--------------------------------------------------------------------------------------		 
		
  	f. Al ingresar el vehículo debe tomarse la patente del mismo, la hora y fecha se toma del sistema

	g. Al salir solo se debe ingresar la patente del mismo, el sistema devolverá la hora de ingreso, la
		hora de salida, tiempo estacionado e importe.

	h. El administrador podrá ingresar nuevos operadores, habilitándolos o no para su trabajo.

	i. El administrador podrá solicitar al sistema:

		a. Total cobrado por estacionamiento

		b. Cantidad de vehículos estacionados

		c. Listado de ingresos y salidas de vehículos
