package carrent;

public class CuotaArriendo {
	private int numCuota;
	private int valorCuota;
	private boolean pagada;
	
	public CuotaArriendo() {
		
	}
	
	public CuotaArriendo(int numCuota, int valorCuota) {
		this.numCuota=numCuota;
		this.valorCuota=valorCuota;
		this.pagada=false;
	}
	
	public int getNumCuota() {
		return numCuota;
	}
	
	public int getValorCuota() {
		return valorCuota;
	}
	
	public boolean isPagada() {
		return pagada;
	}
	
	public void setNumCuota(int cuota) {
		this.numCuota=cuota;
	}
	
	public void setValorCuota(int cuota) {
		this.valorCuota=cuota;
	}
	
	public void setPagada(boolean pagada) {
		this.pagada=pagada;
	}
	
	public boolean pagarCuota() {
	    if (this.pagada) {
	        return false;
	    }

	    this.pagada = true;
	    return true;
	}

	@Override
	public String toString() {
		return "Numero de cuota: " + numCuota + " valor de cuota: "
				+ valorCuota + " ¿Esta pagada? " + pagada;
	}
	
}
