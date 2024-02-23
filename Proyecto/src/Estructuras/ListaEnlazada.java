
package Estructuras;

import java.util.*;
import Objetos.*;


public class ListaEnlazada {
    private Nodo primero;
    private Nodo ultimo;
    private int tamanio;
    
    public ListaEnlazada(){
        this.primero = null;
        this.ultimo = null;
        this.tamanio = 0;
    }
    
    public boolean isEmpty(){
        return tamanio == 0;
    }
    
    public int size(){
        return tamanio;
    }
    
    public Persona get(int index){
        //si esta vacio o el indice no es correcto, devuelve null
        if (this.isEmpty() || (index < 0 || index >= size())) {
            return null;
        } else if (index == 0) {
            return getFirst(); //Tomo el primero
        } else if (index == size() - 1) {
            return getLast(); //Tomo el ultimo
        } else {
            //Uso la funcion getNode para tomar el nodo deseado
            Nodo buscado = getNode(index);
            return buscado.getDato();
        }
    }
    
    public Persona getFirst(){
        if (this.isEmpty())
            return null;
        else
            return this.primero.getDato();
    }
    
    public Persona getLast(){
        if (this.isEmpty())
            return null;
        else
            return this.ultimo.getDato();
    }
    
    private Nodo getNode(int index) {
        if (this.isEmpty() || (index < 0 || index >= size())) {
            return null;
        } else if (index == 0) {
            return this.primero; //devuelvo el primero
        } else if (index == size() - 1) {
            return this.ultimo; //devuelvo el ultimo
        } else {
            Nodo buscado = this.primero;
            //Busco el nodo deseado con un recorrido
            int contador = 0;
            while (contador < index) {
                contador++;
                buscado = buscado.getSiguiente();
            }
            //Me devuelve el buscado
            return buscado;
        }
    }
    
    public Persona addLast(Persona elemento) {
        Nodo aux;
         //Si esta vacia, hago lo mismo que si fuera añadir el primero
        if (this.isEmpty()) {
            return addFirst(elemento);
        } else {
            //Hago el intercambio
            aux = new Nodo(elemento, null);
            this.ultimo.setSiguiente(aux);
            this.ultimo = aux;
        }
        //Aumento el tamanño
        this.tamanio++;
        return this.ultimo.getDato();
    }
    
    public Persona addFirst(Persona elemento) {
        Nodo aux;
        //si esta vacia, el nodo será el primero y ultimo
        if (this.isEmpty()) {
            aux = new Nodo(elemento, null);
            this.primero = aux;
            this.ultimo = aux;
        } else {
            //Hago el intercambio
            Nodo primeroActual = primero;
            aux = new Nodo(elemento, primeroActual);
            this.primero = aux;
        }
        //Aumento el tamanño
        tamanio++;
        return primero.getDato();
    }
    
    public Persona add(Persona elemento, int index) {
        //si esta vacio o el indice no es correcto, devuelve null
        if (this.isEmpty() || index == 0) {
            return addFirst(elemento); //Añade en la primera posicion
        } else if (index == size()) {
            return addLast(elemento); //añade en la ultima posicion
        } else if ((index < 0 || index >= size())) {
            return null;
        } else {
            //tomo el anterior nodo al que estoy buscando
            Nodo buscado_anterior = getNode(index - 1);
            //tomo el nodo de la posicion indicada
            Nodo buscado_actual = getNode(index);
            //Creo el nuevo nodo, este apuntara al de la posicion actual
            Nodo aux = new Nodo(elemento, buscado_actual);
            //el nodo anterior apunta a nuestro nuevo nodo
            buscado_anterior.setSiguiente(aux);
            //Aumento el tamaño
            this.tamanio++;
            return getNode(index).getDato();
        }
    }
    
    /**
     * 
     * @return
     */
    
    @Override
    public String toString() {
        String contenido = "";
        //Si esta vacia, lo indica
        if (isEmpty()) {
            contenido = "Lista vacia";
        } else {
            Nodo aux = primero;
            //Recorre la lista, mostrando el contenido
            
            while (aux != null) {
                contenido += "------------------------------------\n";
                contenido += aux.toString()+"\n";
                contenido += "\n";
                aux = aux.getSiguiente();
            }
        }
        return contenido;
    }
    
    public boolean exists(String elemento) { //Busca por documento
        //Si esta vacio, devuelve false
        if (this.isEmpty()) {
            return false;
        } else {
            Nodo aux = this.primero;
            //Recorremos la lista
            while (aux != null) {
                if (elemento.equals((aux.getDato()).getDoc())) { //Mejor .equals que ==
                    return true; //Existe
                }
                aux = aux.getSiguiente();
            }
            //Si no lo encuentra devuelve false
            return false;
        }
    }
    
    public int indexOf(String elemento) {
        //Si esta vacio, devuelvemos -1
        if (this.isEmpty()) {
            return -1;
        } else {
            Nodo aux = this.primero;
            int posicion = 0;
            while (aux != null) {
                if (elemento.equals((aux.getDato()).getDoc())) {
                    return posicion; //Existe
                }
                posicion++;
                aux = aux.getSiguiente();
            }
            //Si no lo encuentra devuelve -1
            return -1;
        }
    }
    
    public Persona removeFirst() {
        //Si la lista esta vacia, devolvemos null
        if (this.isEmpty()) {
            return null;
        } else {
            //Guardo el elemento antes
            Persona elemento = this.primero.getDato();
            //tomo el segundo
            Nodo aux = this.primero.getSiguiente();
            this.primero = null; //Lo marco como null para el recolector
            this.primero = aux; //Este es mi nuevo primero
            //En caso de que borremos el ultimo elemento,el ultimo también null
            if (size() == 1) {
                this.ultimo = null;
            }
            this.tamanio--;
            return elemento;
        }
    }
    
    public Persona removeLast() {
        if (this.isEmpty()) {
            return null;
        } else {
            //toma el elemento antes de borrar
            Persona elemento = this.ultimo.getDato();
            //tomo el penultimo
            Nodo aux = getNode(size() - 2);
            //En caso de que sea null
            //Hay 1 o dos elementos
            if (aux == null) {
                //marco el ultimo como nulo
                this.ultimo = null;
                //Si hay dos, el primero y el ultimo seran el mismo
                //Si hay 1 elemento, significa que borramos la lista
                if (size() == 2) {
                    this.ultimo = this.primero;
                } else {
                    this.primero = null;
                }
            } else {
                //el penultimo es el nuevo ultimo 
                //y le ponemos como siguiente nulo
                this.ultimo = null;
                this.ultimo = aux;
                this.ultimo.setSiguiente(null);
            }
            this.tamanio--;
            return elemento;
        }
    }
    
    public Persona remove(int index) {
        //si esta vacio o el indice no es correcto, devuelve null
        if (this.isEmpty() || (index < 0 || index >= size())) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size() - 1) {
            return removeLast();
        } else {
            //tomo el nodo anterior al que quiero borrar
            Nodo nodo_anterior = getNode(index - 1);
            //tomo el nodo que quiero borrar
            Nodo nodo_actual = getNode(index);
            //tomo el elemento antes de borrar
            Persona elemento = nodo_actual.getDato();
            //tomo el nodo siguiente al que quiero borrar
            Nodo nodo_siguiente = nodo_actual.getSiguiente();
            //Lo marco para borrar para el recolector
            nodo_actual = null;
            //El nodo anterior apunta al nodo siguiente
            nodo_anterior.setSiguiente(nodo_siguiente);
            this.tamanio--;
            return elemento;
        }
    }
    
    public Persona modify(Persona elemento, int index) {
        //si esta vacio o el indice no es correcto, devuelve null
        if (this.isEmpty() || (index < 0 || index >= size())) {
            return null;
        } else {
            //Nodo actual
            Nodo aux = getNode(index);
            //modifico
            aux.setDato(elemento);
            return aux.getDato();
        }
    } 
}
