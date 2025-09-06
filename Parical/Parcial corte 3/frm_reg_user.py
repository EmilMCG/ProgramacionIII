import tkinter as tk
from tkinter import messagebox
from repositorio import RepositorioUsuarios

class FrmRegUser(tk.Toplevel):
    def __init__(self, master=None):
        super().__init__(master)
        self.title("Registrar Usuario")

        tk.Label(self, text="Nombre").grid(row=0, column=0)
        tk.Label(self, text="Apellidos").grid(row=1, column=0)
        tk.Label(self, text="Email").grid(row=2, column=0)
        tk.Label(self, text="Nickname").grid(row=3, column=0)
        tk.Label(self, text="Clave").grid(row=4, column=0)

        self.txt_nombre = tk.Entry(self)
        self.txt_apellidos = tk.Entry(self)
        self.txt_email = tk.Entry(self)
        self.txt_nickname = tk.Entry(self)
        self.txt_clave = tk.Entry(self, show="*")

        self.txt_nombre.grid(row=0, column=1)
        self.txt_apellidos.grid(row=1, column=1)
        self.txt_email.grid(row=2, column=1)
        self.txt_nickname.grid(row=3, column=1)
        self.txt_clave.grid(row=4, column=1)

        tk.Button(self, text="Guardar", command=self.guardar_usuario).grid(row=5, columnspan=2)

    def guardar_usuario(self):
        nombre = self.txt_nombre.get()
        apellidos = self.txt_apellidos.get()
        email = self.txt_email.get()
        nickname = self.txt_nickname.get()
        clave = self.txt_clave.get()

        if not (nombre and apellidos and email and nickname and clave):
            messagebox.showwarning("Error", "Todos los campos son obligatorios")
            return

        RepositorioUsuarios.guardarUsuario(nombre, apellidos, email, nickname, clave)
        messagebox.showinfo("Éxito", "Usuario registrado correctamente")
        self.destroy()
