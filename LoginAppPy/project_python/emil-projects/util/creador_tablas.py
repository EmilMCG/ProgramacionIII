from .conector import Conector

class CrearTablas:
    def __init__(self):
        self.conector = Conector()

    def crear_tabla_usuarios(self):
        sql = """
        CREATE TABLE IF NOT EXISTS usuarios (
            id INT AUTO_INCREMENT PRIMARY KEY,
            nombre VARCHAR(100) NOT NULL,
            apellido VARCHAR(100) NOT NULL,
            email VARCHAR(150) NOT NULL,
            username VARCHAR(100) NOT NULL UNIQUE,
            clave VARCHAR(255) NOT NULL,
            rol VARCHAR(50) NOT NULL
        )
        """
        if self.conector.execute_query(sql):
            print("Tabla 'usuarios' verificada/creada con éxito")
        else:
            print("Error al crear la tabla 'usuarios'")