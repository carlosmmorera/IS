package ssactividades;

public class Fecha {
    private int dia;

    private int mes;

    private int anyo;

    public Hora hora;

    public String toString() {
    	String resultado="";
    	if (dia<10)resultado+="0";
    	resultado+=dia+"/";
    	if (mes<10)resultado+="0";
    	resultado+=mes+"/";
    	return resultado+anyo+"a las "+hora;
    	}

    public void Modificar() {
    }

}
