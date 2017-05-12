package ssactividades;

public class Fecha {
    private int dia;

    private int mes;

    private int anyo;

    public Hora hora;

    public Fecha(int dia, int mes, int anyo, Hora hora){
    	this.dia=dia;
    	this.mes=mes;
    	this.anyo=anyo;
    	this.hora=hora;
    }
    public String toString() {
    	String resultado="";
    	if (dia<10)resultado+="0";
    	resultado+=dia+"/";
    	if (mes<10)resultado+="0";
    	resultado+=mes+"/";
    	return resultado+anyo+"a las "+hora;
    	}

    public void modificar(int dia, int mes, int anyo, Hora hora) {
    	this.dia=dia;
    	this.mes=mes;
    	this.anyo=anyo;
    	this.hora=hora;
    }

}
