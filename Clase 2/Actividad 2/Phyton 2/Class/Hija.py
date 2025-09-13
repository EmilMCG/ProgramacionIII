class Hija(Padre):
    def __init__(self, nombre: str, edad: int):
        super().__init__(nombre) 
        self.edad = edad

    def __str__(self) -> str:
        return f"Nombre: {self.nombre}, Edad: {self.edad}"