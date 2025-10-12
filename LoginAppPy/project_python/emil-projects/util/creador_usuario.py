from .conector import Conector
import bcrypt

class CreadorUsuario:

    def __init__(self):
        self.db = Conector()

    def existe_usuario(self,username):
        sql = "SELECT id FROM usuarios WHERE username=%s"
        result = self.db.select(sql, (username,))
        return bool(result)

    def registrar_usuario(self,nombre,apellido,email,username,clave,rol):
        # validar usuario que no exista
        if (self.existe_usuario(username,)):
            raise Exception("El usuario ya se encuentra registrado")
        
        hashed = bcrypt.hashpw(clave.encode('utf-8'), bcrypt.gensalt())
        sql = "insert into usuarios(nombre,apellido,email,username,clave,rol) values (%s, %s, %s, %s, %s, %s)"
        values = (nombre, apellido, email, username, hashed, rol)
        return self.db.execute_query(sql, values)