package Objetos;

public class Pista {
	private Integer NumPista;
	private Boolean usado;
	private String pista;
	
	public Pista(Integer numPista, Boolean usado, String pista) {
		super();
		NumPista = numPista;
		this.usado = usado;
		this.pista = pista;
	}

	public Integer getNumPista() {
		return NumPista;
	}

	public void setNumPista(Integer numPista) {
		NumPista = numPista;
	}

	public Boolean getUsado() {
		return usado;
	}

	public void setUsado(Boolean usado) {
		this.usado = usado;
	}

	public String getPista() {
		return pista;
	}

	public void setPista(String pista) {
		this.pista = pista;
	}
	
	

}
