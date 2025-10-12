import tkinter as tk
from tkinter import messagebox
from PIL import Image, ImageTk
from clases.usuario import Usuario
import os
from .form_bienvenido import PanelAdministrativo

class Login:
    def __init__(self, master):
        self.master = master
        self.master.title("INGRESO AL SISTEMA")
        self.master.geometry("700x400")
        self.master.config(bg="#f0f0f0")

        self.logo_img = None
        self.user_img = None

        titulo = tk.Label(self.master, text="INGRESO AL SISTEMA", 
                        font=("Arial", 16, "bold"), bg="#f0f0f0")
        titulo.place(x=400, y=30)

        try:
            logo_path = os.path.join("imagenes", "logo.jpg")
            logo = Image.open(logo_path)
            logo = logo.resize((150, 150))
            self.logo_img = ImageTk.PhotoImage(logo)
            lbl_logo = tk.Label(self.master, image=self.logo_img, bg="#f0f0f0")
            lbl_logo.place(x=50, y=100)
        except Exception as e:
            print("No se pudo cargar logo.png:", e)

        try:
            avatar_path = os.path.join("imagenes", "avatar.png")
            avatar_img = Image.open(avatar_path)
            avatar_img = avatar_img.resize((60, 60))
            self.user_img = ImageTk.PhotoImage(avatar_img)
            lbl_user_icon = tk.Label(self.master, image=self.user_img, bg="#f0f0f0")
            lbl_user_icon.place(x=500, y=80)
        except Exception as e:
            print("No se pudo cargar user.png:", e)

        lbl_usuario = tk.Label(self.master, text="Usuario:", font=("Arial", 12), bg="#f0f0f0")
        lbl_usuario.place(x=400, y=160)
        self.entry_usuario = tk.Entry(self.master, width=25)
        self.entry_usuario.place(x=480, y=160)

        lbl_clave = tk.Label(self.master, text="Clave:", font=("Arial", 12), bg="#f0f0f0")
        lbl_clave.place(x=400, y=200)
        self.entry_clave = tk.Entry(self.master, width=25, show="*")
        self.entry_clave.place(x=480, y=200)

        btn_login = tk.Button(self.master, text="Iniciar sesión", width=20, command=self.login)
        btn_login.place(x=450, y=250)

    def login(self):
        usuario_input = self.entry_usuario.get()
        clave_input = self.entry_clave.get()

        print(usuario_input, clave_input)

        usuario = Usuario()
        usuario = usuario.validar_usuario(usuario_input,clave_input)
        print(usuario)

        if usuario:
            messagebox.showinfo("Ingreso", "Bienvenido al sistema")
            self.master.destroy() 
            root_panel = tk.Tk()
            app = PanelAdministrativo(root_panel,usuario)
            root_panel.mainloop()
        else:
            messagebox.showerror("Error", "Usuario o clave incorrectos")
