package presentacion.view;

public interface LoginListener {
	boolean loggear (String usuario, String password);
	void entrarSinLog();
	boolean registrarse(String usuario, String password);
}
