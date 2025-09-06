from usuarios import Usuario

class RepositorioUsuarios:
    lista_usuarios = []

    @classmethod
    def guardarUsuario(cls, nombre, apellidos, email, nickname, clave):
        usuario = Usuario(nombre, apellidos, email, nickname, clave)
        cls.lista_usuarios.append(usuario)

    @classmethod
    def validarUsuario(cls, nickname, clave):
        for usuario in cls.lista_usuarios:
            if usuario.nickname == nickname and usuario.clave == clave:
                return usuario
        return None
