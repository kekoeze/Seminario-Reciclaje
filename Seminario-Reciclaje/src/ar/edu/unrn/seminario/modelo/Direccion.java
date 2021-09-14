package ar.edu.unrn.seminario.modelo;

import ModeloException.NotNullException;

public class Direccion {

    private String calle;
    private String numero;
    private String barrio;
	

    //latitud y longitud?

    public Direccion(String calle, String numero, String barrio) throws NotNullException{
    	
    	if(esDatoNulo(calle)) {
    		throw new NotNullException("la calle es dato nulo");
    	}
    	if(esDatoNulo(numero)) {
    		throw new NotNullException("el numero es dato nulo");
    	}
    	if(esDatoNulo(barrio)) {
    		throw new NotNullException("el barrio es dato nulo");
    	}
        this.calle=calle;
        this.numero=numero;
        this.barrio=barrio;
    }

    public String getCalle() {
        return calle;
    }

    public String getNumero() {
        return numero;
    }

    public String getBarrio() {
        return barrio;
    }
    private boolean esDatoNulo(String dato) {
 		return dato == null | dato.isEmpty();
 	}
    //to string? equals?
}
