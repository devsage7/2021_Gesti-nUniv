

package Objetos;

import java.util.Scanner;

public class AlumnoPostGrado extends Alumno{
    
    private String CarreraPostG;
    
    public AlumnoPostGrado(){
        super();
        CarreraPostG = "Desconocido";
    }
    
    public AlumnoPostGrado(String nom, String doc, String dir, int nac[], String fac, String carr, int ingre[], String reg, String carrPG){
        super(nom,doc,dir,nac,fac,carr,ingre,reg);
        CarreraPostG = carrPG;
    } 
    
    public AlumnoPostGrado(AlumnoPostGrado apg){
        super(apg);
    }
    
    public String getcarPos(){
        return CarreraPostG;
    }
    
    public void setcarPos(String carrPG){
        CarreraPostG = carrPG;
    }
    
    public void register(AlumnoPostGrado persona){
        String elem = new String();
        Scanner reader = new Scanner(System.in);
        
        super.register(persona);
        System.out.print("Ingrese carrera de post grado: ");
        elem = reader.nextLine();
        persona.setcarPos(elem);
    }
    
    @Override
    public String toString(){
        return ""+super.toString()+"\n-Carrera Post-Grado: "+CarreraPostG;
    }
}
