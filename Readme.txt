Integrantes
Francisco Ignacio Fuentealba Rubilar
Leonardo Rafael Guerrero Ortega

Cambios en reunión:
variable Date fecha: fue eliminada porque al ser de tipo Date se nos dificultaba la conversión
las variables LocalDateTime horaPrevista, LocalDateTime duracionPrevista; fueron cambiadas a LocalDateTime para facilitar las cosas al separar la fecha y la hora (y para recibir una fecha en String)

las listas ArrayList<Invitacion> invitaciones, ArrayList<Invitable>  invitados, ArrayList<Invitable> ausentes,
ArrayList<Asistencia> asistentes;  
fueron creados para los métodos obtenerAsistencias() -que en nuestro código se llama obtenerAsistentes()- para guardar las asistencias, obtenerAusencias() donde se guardan todos antes de ser agregados a la reunión, obtenerRetrasos() -que usa el polimorfismo de Asistencia-, obtenerPorcentajeAsistencia() donde se compara con los invitados y obtenerTotalAsistencia() que devuelve directamente el contenido de asistencias

Y para los métodos anteriores 