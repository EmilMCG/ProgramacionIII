import tkinter as tk
from formularios.form import Login
from util.creador_tablas import CrearTablas
from util.creador_usuario import CreadorUsuario

if __name__ == "__main__":
    creador = CrearTablas()
    try:
        creador.crear_tabla_usuarios()
    except Exception as e:
        print('Error creando tablas: ', e)

    #Crear usuario para poder acceder al login
    creador_user = CreadorUsuario()
    if not creador_user.existe_usuario('admin'):
        creador_user.registrar_usuario('Administrador','Administrador apellido','admin@email.com','admin' ,'1234','admin')
    root = tk.Tk()
    app = Login(root)
    root.mainloop()