
package Objetos;

import java.util.Scanner;


public class Alumno extends PersUniv{
    
    private String Registro;
    
    public Alumno(){
        super();
        Registro = "Desconocido";
    }
    
    public Alumno(String nom, String doc, String dir, int nac[], String fac, String carr, int ingre[], String reg){
        super(nom,doc,dir,nac,fac,carr,ingre);
        Registro = reg;
    }
    
    public Alumno(Alumno a){
        super(a);
        Registro = a.Registro;
    }
    
    public String getReg(){
        return Registro;
    }
    
    public void setReg(String reg){
        Registro = reg;
    }
    
    public void register(Alumno persona){
        String elem = new String();
        Scanner reader = new Scanner(System.in);
        
        super.register(persona);
        System.out.print("Ingrese nro. de registro: ");
        elem = reader.next();
        persona.setReg(elem); 
    }
    
    /**
     *
     * @return
     */
    
    @Override
    public String toString(){
        return ""+super.toString()+"\n-Numero de Registro: "+Registro;
    }
    

    
}
