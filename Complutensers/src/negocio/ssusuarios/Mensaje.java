package negocio.ssusuarios;
/**
 * @author Ariadna
 * @version 1.0
 */
public class Mensaje {
    private String destinatario;
    private String remitente;
    private String asunto;
    private String cuerpo;
    
    /**
     * Constructor
     * @param para
     * @param de
     * @param asunto
     * @param mensaje
     */
    public Mensaje(String para, String de, String asunto, String mensaje){
    	destinatario = para;
    	remitente = de;
    	this.asunto = asunto;
    	cuerpo = mensaje;
    }
    /**
     * Show the message
     */
    public void mostrar() {
    }

}
