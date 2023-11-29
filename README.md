# Bacigalupi-Ignacio_Pruebatec2

# Aplicación de Gestión de Turnos - Prueba Técnica 2

Desarrollo de una Aplicación de Gestión de Turnos.
Esta aplicación Java desarrolla un sistema de gestión de turnos para una entidad gubernamental, permitiendo crear ciudadanos , el registro y manejo de turnos para diferentes trámites, asignando ciudadanos a cada uno de ellos.

# Requisitos

Asegúrate de tener instalado Java en tu máquina. La aplicación utiliza JPA para interactuar con una base de datos, así que también necesitarás configurar una fuente de datos.

# Ejecución de la Aplicación

1. Clona este repositorio: git clone https://github.com/IgnacioBacigalupi/Bacigalupi-Ignacio_Pruebatec2.git

2. Abre el proyecto en tu entorno de desarrollo Java.

3. Ejecuta la clase index.jsp para iniciar la aplicación.

# Funcionalidades principales:

1. Menú ciudadano: Permite crear un nuevo cidadano en el sistema.

2. Mostrar ciudadanos : Muestra una lista de todos los ciudadanos creados para poder solicitar un turno.

3. Solicitar Turno: Permite ingresar información sobre un nuevo turno, incluyendo fecha y descripción del trámite, junto con la asignación de un ciudadano.

4. Filtrado de Turnos: Permite filtrar los turnos por fecha o por fecha y estado devolviendo una lista con los parametros ingresados por el usuario.

# Tecnologías Utilizadas:

Java: Backend lógico del proyecto.

Servlets: Para el manejo de operaciones CRUD.

JavaServer Pages (JSP): Interfaz de usuario.

JPA: Acceso a la base de datos.

Bootstrap: Framework para estilos y diseño.

# Supuestos Considerados:

Flujo de Creación de Ciudadanos y Turnos:

Se presume que los ciudadanos se crean antes de ser asignados a los turnos.
Se espera que un ciudadano exista en la base de datos para asignarlo a un turno; por lo tanto, la creación de ciudadanos se considera previa a la solicitud de turnos.

Flujo de Estado de Turnos:

Se asume que el estado inicial de un turno es "En Espera" al ser creado y cambia a "Atendido" una vez que ha sido atendido por la entidad correspondiente.

Operaciones en la Interfaz de Usuario:

Se supone que la interfaz de usuario cuenta con validaciones para evitar la introducción de datos inválidos o nulos al crear ciudadanos.
