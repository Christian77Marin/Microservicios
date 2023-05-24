package pruebas;

public class Coche {

	private String marca;
	private String color;
	private int caballos;
	
	public Coche(String marca_coche, String color_coche, int caballos_coche) {

		marca = marca_coche;
		color = color_coche;
		caballos = caballos_coche;
	}

	public Coche() {
	}
	
	
	public String getMarca() {
		return this.marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCaballos() {
		return caballos;
	}

	public void setCaballos(int caballos) {
		this.caballos = caballos;
	}
	
	
	public String Retaila() {
		return this.marca + " " +  this.color + " " + this.caballos + "CV";
	}
	
	public String Retaila(boolean aux) {
		
		if(this.caballos >= 100) {
			return "Vaya carro tete";
		}else {
			return "Basura de la hostia";
		}
		
		
	}
	
}
