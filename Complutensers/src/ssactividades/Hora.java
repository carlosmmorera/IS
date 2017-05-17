package ssactividades;

public class Hora {
    private int hora;
    private int minuto;
    
    public Hora(){
    	this.setHora(0);
    	this.setMinuto(0);
    }
    
    public Hora (int h, int m){
    	this.setHora(h);
    	this.setMinuto(m);
    }
    public Hora(String hor){
    	String[] hs=hor.split(":");
    	hora=Integer.parseInt(hs[0]);
    	minuto=Integer.parseInt(hs[1]);
    }
    public String toString() {
    	String resultado=hora+":";
    	if (minuto<10)resultado+="0";
    	return resultado+minuto;
    }

    public void Modificar(int h, int m) {
    	setHora(h);
    	setMinuto(m);
    }

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

}
