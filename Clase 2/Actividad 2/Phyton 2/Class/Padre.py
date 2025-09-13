class Padre:
    def __init__(self, nombre: str):
        self.nombre = nombre
        print(nombre)  # igual que en tu Java

    def __str__(self) -> str:
        return f"Nombre: {self.nombre}"
