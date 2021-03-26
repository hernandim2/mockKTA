# language: es
Característica: [CCB-003] Administrar ordenes para facturación de trabajo a clientes

  Escenario: Registramos una nueva orden

    Cuando recibimos la siguiente orden:
      | TIPO_ACCION | NRO_ORDEN_SAP | TEXTO_ASOCIADO                          | CENTRO_COSTO_SAP | ACTIVIDAD_SAP |
      |     A       | 930000006141  | SUMINISTRO HERRAMIENTA MANUAL-LUMINITEC | 0000000438       |     933       |

    Entonces verificar que el resultado de la llamada sea la siguiente:
      | CODIGO_RETORNO | MSG_ERROR                                             |
      | 0.000000000    | LOS DATOS RECIBIDOS HAN SIDO PROCESADOS CORRECTAMENTE |
      
      Y validamos que la operación sea un INSERT

	# ----------------------------------------------------------------------------

  Escenario: Actualizar una orden
  
  	Dado que existe previamente el registro:
      | TIPO_ACCION | NRO_ORDEN_SAP | TEXTO_ASOCIADO                          | CENTRO_COSTO_SAP | ACTIVIDAD_SAP |
      |     A       | 930000006141  | SUMINISTRO HERRAMIENTA MANUAL-LUMINITEC | 0000000438       |     933       |
      
    Cuando recibimos la siguiente orden:
      | TIPO_ACCION | NRO_ORDEN_SAP | TEXTO_ASOCIADO                          | CENTRO_COSTO_SAP | ACTIVIDAD_SAP |
      |     B       | 930000006141  | SUMINISTRO MODIFICADO                   | 0000000999       |     999       |

    Entonces verificar que el resultado de la llamada sea la siguiente:
      | CODIGO_RETORNO | MSG_ERROR                                             |
      | 0.000000000    | LOS DATOS RECIBIDOS HAN SIDO PROCESADOS CORRECTAMENTE |
      
      Y validamos que la operación sea un UPDATE

	# ----------------------------------------------------------------------------

  Escenario: Verificamos cantidad (y tiempo) reintentos por falta de conexión a la base de datos
  
  	Dado que se perdió la conexión con la base de datos
      
    Cuando recibimos la siguiente orden:
      | TIPO_ACCION | NRO_ORDEN_SAP | TEXTO_ASOCIADO                          | CENTRO_COSTO_SAP | ACTIVIDAD_SAP |
      |     A       | 930000006141  | SUMINISTRO HERRAMIENTA MANUAL-LUMINITEC | 0000000438       |     933       |

    Entonces verificar que el resultado de la llamada sea la siguiente:
      | CODIGO_RETORNO | MSG_ERROR                                             |
      | 0.000000000    | LOS DATOS RECIBIDOS HAN SIDO PROCESADOS CORRECTAMENTE |
      
      Y verificar que la cantidad total de reintentos sean 6 en un lapso no menor a 30 segundos, es decir 1 cada 5 segundos
      
      Y finalmente verificar que exista 1 mensaje en la cola "ActiveMQ.DLQ"
      
	# ----------------------------------------------------------------------------
	
	#validar el tipo de exception, para las prueba se trabajo en 'java.net.ConnectException' poro no estoy seguro si es así.
  Escenario: Error por falta de conexión a cola de mensajería
  
  	Dado que se perdió la conexión con la cola de mensajería
      
    Cuando recibimos la siguiente orden:
      | TIPO_ACCION | NRO_ORDEN_SAP | TEXTO_ASOCIADO                          | CENTRO_COSTO_SAP | ACTIVIDAD_SAP |
      |     A       | 930000006141  | SUMINISTRO HERRAMIENTA MANUAL-LUMINITEC | 0000000438       |     933       |

    Entonces verificar que el resultado de la llamada sea la siguiente:
      | CODIGO_RETORNO | MSG_ERROR                               |
      |                | Error intentar conectarse al broker JMS |
      
	# ----------------------------------------------------------------------------

  Escenario: Error por falta de un único campo de entrada: TIPO_ACCION
  
    Cuando recibimos la siguiente orden:
      | TIPO_ACCION | NRO_ORDEN_SAP | TEXTO_ASOCIADO                          | CENTRO_COSTO_SAP | ACTIVIDAD_SAP |
      |             | 930000006141  | SUMINISTRO HERRAMIENTA MANUAL-LUMINITEC | 0000000438       |     933       |

    Entonces verificar que el resultado de la llamada sea la siguiente:
      | CODIGO_RETORNO | MSG_ERROR                                                                 |
      |                | Error en los datos de entrada -> [Campo Tipo Acción no puede estar vacío] |
      
	# ----------------------------------------------------------------------------

  Escenario: Error por falta de multiplos campos de entrada: TIPO_ACCION, NRO_ORDEN_SAP y ACTIVIDAD_SAP
  
    Cuando recibimos la siguiente orden:
      | TIPO_ACCION | NRO_ORDEN_SAP | TEXTO_ASOCIADO                          | CENTRO_COSTO_SAP | ACTIVIDAD_SAP |
      |             |               | SUMINISTRO HERRAMIENTA MANUAL-LUMINITEC | 0000000438       |               |

    Entonces verificar que el resultado de la llamada sea la siguiente:
      | CODIGO_RETORNO | MSG_ERROR                                                                                                                                                           |
      |                | Error en los datos de entrada -> [Campo Actividad SAP no puede estar vacío, Campo Número de Orden SAP no puede estar vacío, Campo Tipo Acción no puede estar vacío] |