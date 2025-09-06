import tkinter as tk
from tkinter import messagebox
from repositorio import RepositorioUsuarios
from Formularios.frm_reg_user import FrmRegUser

class FrmLogin(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("Login")

        tk.Label(self, text="Nickname").grid(row=0, column=0)
        tk.Label(self, text="Clave").grid(row=1, column=0)

        self.txt_nickname = tk.Entry(self)
        self.txt_clave = tk.Entry(self, show="*")

        self.txt_nickname.grid(row=0, column=1)
        self.txt_clave.grid(row=1, column=1)

        tk.Button(self, text="Ingresar", command=self.validar).grid(row=2, column=0)
        tk.Button(self, text="Registrar", command=self.abrir_registro).grid(row=2, column=1)

    def validar(self):
        nickname = self.txt_nickname.get()
        clave = self.txt_clave.get()
        usuario = RepositorioUsuarios.validarUsuario(nickname, clave)

        if usuario:
            messagebox.showinfo("Bienvenido", f"Hola {usuario.nombre} {usuario.apellidos}")
        else:
            messagebox.showerror("Error", "Usuario o clave incorrectos")

    def abrir_registro(self):
        FrmRegUser(self)
