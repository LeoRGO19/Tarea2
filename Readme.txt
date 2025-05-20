Integrantes
Francisco Ignacio Fuentealba Rubilar
Leonardo Rafael Guerrero Ortega

Cambios UML:
Notar que la creación de excepciones no las mencionaré porque en teoría no forman parte de un diagrama de clases y estos cambios son únicamente los que afectaron al UML

clase Reunion:

Se creó el constructor de la clase (que no se veía en el uml pero como a todas se les creó, omitiré mencionarlo en las siguientes)

variable Date fecha: fue eliminada porque al ser de tipo Date se nos dificultaba la conversión
las variables horaPrevista, duracionPrevista fueron cambiadas a LocalDateTime para facilitar las cosas al separar la fecha y la hora (y para recibir una fecha en String)

las listas ArrayList<Invitacion> invitaciones, ArrayList<Invitable>  invitados, ArrayList<Invitable> ausentes,
ArrayList<Asistencia> asistentes;  
fueron creados para los métodos obtenerAsistencias() -que en nuestro código se llama obtenerAsistentes()- para guardar las asistencias, obtenerAusencias() donde se guardan todos antes de ser agregados a la reunión, obtenerRetrasos() -que usa el polimorfismo de Asistencia-, obtenerPorcentajeAsistencia() donde se compara entre el total de invitados y el total de los asistentes, y obtenerTotalAsistencia() que devuelve directamente el contenido de asistencias
invitaciones no tiene mucha funcionalidad pero se creó para guardar el registro de las invitaciones de manera que no se perdieran y se pueda acceder a ellas

Y para los métodos anteriores también se creo agregarInvitado() y agregarAsistente() para llenar las listas de asistentes y invitados

también la lista ArrayList<Nota> notas para guardar las notas de la reunión y poder mostrarlas luego, y en función de eso se añade el método addNota() para poder llenar la lista

Se creó un getter y un setter de la fecha, además de un getter de los invitados
En obtenerTiempoReal se modificó de modo que reciba dos argumentos para poder hacer las respectivas pruebas y medir tiempos distintos 

Se crean las propiedades de tipo boolean iniciada y finalizada que aunque por ahora no reflejan mucho en la funcionalidad, si fuese una reunión con tiempo real si se harían notar

Se creo el método toString pedido

Se añade la propiedad Empleado organizador como se establece en el enunciado para que haya alguien que la organice (aunque por lo menos en este proyecto no tiene mucha importancia, únicamente lo mostramos en el toString)

Se añaden también las propiedades int tipo, String sala_o_enlace para el manejo de algunas excepciones y errores

Se creó el método devolverN() para que las clases hijas le hagan overriding y completen la información del toString

Se creó el método generarInforme para añadir la nueva funcionalidad de la posibilidad de crear un informe de la reunión


interfaz Invitable:

se creó un método getNombre para hacerle overridig a las clases que lo implementen y poder conocer el nombre del que se invita


clase Empleado:

se añadió la propiedad departamento para que un empleado tenga la información de a qué departamento pertenece
se crearon los getters y setter de las propiedades
se creó el toString pedido y el invitar() que hace overriding con la interfaz invitable


clase PersonaExterna:
se añade la clase a org.example
con propiedades de tipo String; nombre, apellidos, y correo y sus respectivos métodos getters y setters
con el método invitar() y el toString pedido


clase Departamento:

se añadió la lista ArrayList<Empleado> empleados, el gettter, setter para el nombre del departamento, y el método añadir empleado para llenar la lista de empleados
se creó el método toString como se pedía y método un envitar() con un loop para invitar a todos los empleados del departamento


clase Asistencia:

se crea la propiedad Invitable inv, para que la asistencia tenga información del que asiste claramente, además de sus métodos getter y setter
se creó el toString


clase Invitación:

se añade las propiedades LocalTime horalocal, Invitable persona, para la conversión a un mejor formato y para que la invitación guarde a quién a la persona invitada, respectivamente. Además se crean los métodos getters y setters
Se crea el toString


clase Retraso:

se crea las propiedades Instant hora y LocalTime horalocal -para tener información de a que hora fue el retraso-, y solo un getter y setter dato que la variable hora está más que todo para la conversión por eso tenemos LocalTime para el getter (Instant lo tenemos porque es más fácil hacer diferencias de horas y moverse en el tiempo y LocalTime porque lo podemos a un formato más entendible) pero a pesar de esto el setter si se recibe en Instant
se creó el toString


Clase ReunionPresencial y Clase ReunionVirtual:

se añade la propiedad entera tipoInt para poder manejar el tipo de reunión que se recibe en el constructor
se añade el método devolverN() para complementar el de Reunión -es por esto que no tiene toString, dado que usará el de la clase padre- 


Clase Nota: 

se crearon los getters y setters de contenido
se creó la propiedad de tipo LocalDateTime tiempo para saber a qué hora se creó la nota
se creó el toString

Enum TipoReunion:

se añade el método obtenerTipo() para manejar el tipo de reunión desde ReunionPresencial o ReunionVirtual




