
package Estructuras;

import Objetos.*;

public class Nodo {
    private Persona info;
    private Nodo siguiente;
    
    public Nodo(){
        this.siguiente = null;
    }
    
    public Nodo(Persona p){
        this.info = p;
        this.siguiente = null;
    }
    
    public Nodo(Persona p, Nodo sig){
        this.siguiente = sig;
        this.info = p;
    }
    
    public Persona getDato() {
        return this.info;
    }
 
    public void setDato(Persona p) {
        this.info = p;
    }
 
    public Nodo getSiguiente() {
        return siguiente;
    }
 
    public void setSiguiente(Nodo sig) {
        this.siguiente = sig;
    }
    
    @Override
    public String toString() {
        String contenido;
        contenido = this.info.toString();
        return contenido;
    }
    
}


