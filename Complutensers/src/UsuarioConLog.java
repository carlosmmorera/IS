import java.util.ArrayList;
import java.util.List;

public abstract class UsuarioConLog implements Usuario {
    private String Nombre;

    private String Password;

    private boolean Logged;

    public List<Actividad> actividadesPendientes = new ArrayList<Actividad> ();

    public List<Actividad> actividadesRealizadas = new ArrayList<Actividad> ();

    public List<Mensaje> mensaje = new ArrayList<Mensaje> ();

    public void AccederBuzon() {
    }

    public void logIn() {
    }

    public void logOut() {
    }

}
