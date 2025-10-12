import mysql.connector

class Conector:

    def __init__(self):
        self.host = "localhost"
        self.user = "root"
        self.password = "root"
        self.database = "tecnar_project"

    def connect(self):
        try:
            self.connection = mysql.connector.connect(
                host=self.host,
                user=self.user,
                password=self.password,
                database=self.database
            )
            self.cursor = self.connection.cursor()
            return self.cursor
        except mysql.connector.Error as error:
            print(error)

    def close(self):
        self.cursor.close()
        self.connection.close()

    # Ejecutar consultas SQL tipo SELECT
    def select(self, sql, values=None):
        try:
            self.cursor = self.connect()
            self.cursor.execute(sql, values or ())
            result = self.cursor.fetchall()
            self.close()
            return result
        except mysql.connector.Error as error:
            print(error)
            return False
        # Ejecutar consultas INSERT, UPDATE, DELETE

    def execute_query(self, sql, values=None):
        try:
            self.cursor = self.connect()
            self.cursor.execute(sql, values or ())
            self.connection.commit()
            self.close()
            return True
        except mysql.connector.Error as error:
            print(error)
            return False