from util.conector import Conector
import bcrypt

class Usuario:
    def __init__(self, nombre=None, apellido=None, email=None, username=None, rol=None):
        self.__nombre = nombre
        self.__apellido = apellido
        self.__email = email
        self.__username = username
        self.__rol = rol
        self.db = Conector()

    @property
    def nombre(self):
        return self.__nombre

    @property
    def apellido(self):
        return self.__apellido

    @property
    def email(self):
        return self.__email

    @property
    def username(self):
        return self.__username

    @property
    def rol(self):
        return self.__rol


    def validar_usuario(self, username, clave):
        sql = "select nombre,apellido,email,username,clave,rol from usuarios where username =%s"
        print('es aqui')
        values = (username,)
        result = self.db.select(sql, values)

        if result:
            user_data = result[0]
            stored_hash = user_data[4]
            print(stored_hash)
            if bcrypt.checkpw(clave.encode('utf-8'), stored_hash.encode('utf-8')):
                return Usuario(
                    nombre=user_data[0],
                    apellido=user_data[1],
                    email=user_data[2],
                    username=user_data[3],
                    rol=user_data[5]
                )
        return None
