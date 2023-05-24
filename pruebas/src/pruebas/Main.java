package pruebas;

import pruebas.Coche;

public class Main {

	public static void main(String[] args) {
	    System.out.println(sumar(2, 3,4));
	    
	    Coche twinie = new Coche();
	    
	    twinie.setCaballos(99);
	    twinie.setColor("Blanco");
	    twinie.setMarca("Peugeot 208");
	    
	    System.out.println(twinie.Retaila());
	    System.out.println(twinie.Retaila(true));
	}

	//Sobrecarga de Metodos
	public static int sumar(int a, int b) {
	    return a + b;
	}
	//Sobrecarga de Metodos
	public static int sumar(int a, int b, int c) {
	    return a + b + c;
	}


}
