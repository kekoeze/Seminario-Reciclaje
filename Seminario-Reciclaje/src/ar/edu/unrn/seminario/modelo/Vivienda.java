package ar.edu.unrn.seminario.modelo;

import java.time.LocalDateTime;


public class Vivienda {

    private Propietario propietario;
   
    private Direccion direccion;

    public Vivienda(Propietario propietario, Direccion direccion){
        //agregar excepciones
        this.propietario=propietario;
        
        this.direccion=direccion;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    //to string? equals?
}
