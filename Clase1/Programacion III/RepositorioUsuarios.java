/*Programa creado por Duban Santiago Vasquez y Emil Mateo Castro*/

import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuarios {
    private static List<Usuarios> listaUsuarios = new ArrayList<>();

    public static void guardarUsuario(Usuarios usuario) {
        listaUsuarios.add(usuario);
    }

    public static Usuarios validarUsuario(String nickname, String clave) {
        for (Usuarios u : listaUsuarios) {
            if (u.getNickname().equals(nickname) && u.getClave().equals(clave)) {
                return u;
            }
        }
        return null;
    }
}