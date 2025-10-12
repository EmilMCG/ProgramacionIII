import tkinter as tk
from tkinter import Menu, PhotoImage
import os

class PanelAdministrativo:
    def __init__(self, root, user):
        self.root = root
        self.user = user
        self.root.title("Panel Administrativo")
        self.root.geometry("800x400")
        self.root.configure(bg="#f0f0f0")

        self.crear_menu()
        self.crear_titulo()
        self.crear_perfil()

    def crear_menu(self):
        menubar = Menu(self.root)

        menu_usuarios = Menu(menubar, tearoff=0)
        menu_usuarios.add_command(label="Administración de Usuarios")
        menubar.add_cascade(label="Usuarios", menu=menu_usuarios)

        menu_clientes = Menu(menubar, tearoff=0)
        menubar.add_cascade(label="Clientes", menu=menu_clientes)

        menu_categorias = Menu(menubar, tearoff=0)
        menubar.add_cascade(label="Categorías", menu=menu_categorias)

        menu_productos = Menu(menubar, tearoff=0)
        menubar.add_cascade(label="Productos", menu=menu_productos)

        menu_ventas = Menu(menubar, tearoff=0)
        menubar.add_cascade(label="Ventas", menu=menu_ventas)

        self.root.config(menu=menubar)

    def crear_titulo(self):
        titulo_frame = tk.Frame(self.root, bg="#f0f0f0")
        titulo_frame.pack(fill="x", pady=10, padx=10)

        titulo_izq = tk.Label(titulo_frame, text="PANEL ADMINISTRATIVO",
                            font=("Arial", 16, "bold"), bg="#f0f0f0")
        titulo_izq.pack(side="left")

        titulo_der = tk.Label(titulo_frame, text="BIENVENIDO AL SISTEMA",
                            font=("Arial", 16, "bold"), bg="#f0f0f0")
        titulo_der.pack(side="right")

    def crear_perfil(self):
        perfil_frame = tk.Frame(self.root, bg="#f0f0f0")
        perfil_frame.pack(pady=20)

        avatar_path = os.path.join("imagenes", "avatar.png")

        try:
            avatar_img = PhotoImage(file=avatar_path).subsample(4, 4)
        except Exception as e:
            print(f"No se pudo cargar {avatar_path}: {e}")
            avatar_img = None

        avatar_label = tk.Label(perfil_frame, image=avatar_img, bg="#f0f0f0")
        avatar_label.image = avatar_img 
        avatar_label.pack()

        tk.Label(perfil_frame, text=self.user.nombre + " " + self.user.apellido, font=("Arial", 12), bg="#f0f0f0").pack()
        tk.Label(perfil_frame, text=self.user.email, font=("Arial", 10), bg="#f0f0f0").pack()
        tk.Label(perfil_frame, text=self.user.rol, font=("Arial", 10, "italic"), bg="#f0f0f0").pack()

        botones_frame = tk.Frame(perfil_frame, bg="#f0f0f0")
        botones_frame.pack(pady=10)

        tk.Button(botones_frame, text="F").pack(side="left", padx=5)
        tk.Button(botones_frame, text="In").pack(side="left", padx=5)
        tk.Button(botones_frame, text="PC").pack(side="left", padx=5)
        tk.Button(botones_frame, text="→").pack(side="left", padx=5)