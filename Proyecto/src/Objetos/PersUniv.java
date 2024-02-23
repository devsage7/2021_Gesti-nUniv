
package Objetos;

import java.util.Scanner;

public class PersUniv extends Persona {
    private String Facultad;
    private String Carrera;
    private int[] fechaIngre;
    
    public PersUniv(){
        super();
        Facultad = "Desconocido";
        Carrera = "Desconocido";
        fechaIngre = new int [3];
    }
        
    public PersUniv(String nom, String doc, String dir, int nac[], String fac, String carr, int ingre[]){
        super(nom,doc,dir,nac);
        Facultad = fac;
        Carrera = carr;
        fechaIngre = new int[3];
        fechaIngre[0] = ingre[0];
        fechaIngre[1] = ingre[1];
        fechaIngre[2] = ingre[2];
    }
    
    public PersUniv(PersUniv pU){
        super(pU);
        Facultad = pU.Facultad; /*****/
        Carrera = pU.Carrera;
        fechaIngre = new int [3];
        fechaIngre[0] = pU.fechaIngre[0];
        fechaIngre[1] = pU.fechaIngre[1];
        fechaIngre[2] = pU.fechaIngre[2];
    }
    
    public String getFac(){
        return Facultad;
    }
    
    public String getCar(){
        return Carrera;
    }
    
    public int[] getfIng(){
        return fechaIngre;
    }
    
    public void setFac(String fac){
        Facultad = fac;
    }

    public void setCar(String car){
        Carrera = car;
    }    
    
    public void setfIng(int[] ingre){   
        fechaIngre[0] = ingre[0];
        fechaIngre[1] = ingre[1];
        fechaIngre[2] = ingre[2];
    }
    
    
    public void register(PersUniv persona){
        int[] fecha = new int [3];
        String elem = new String();
        Scanner reader = new Scanner(System.in);
        
        super.register(persona);
        System.out.print("Ingrese facultad: "); //FACULTAD
        elem = reader.nextLine();
        persona.setFac(elem);
        
        
        System.out.print("Ingrese carrera: "); //CARRERA
        elem = reader.nextLine();
        persona.setCar(elem);
        
        
        System.out.println("(Fecha de ingreso)"); //FECHA DE INGRESO
        
        do{
            System.out.print("Ingrese día: "); //dia
            fecha[0] = reader.nextInt();
            if (fecha[0]>31 || fecha[0]<=0)
                System.out.println("Error: Ingrese un día válido (1-31).");
        }while (fecha[0]>31 || fecha[0]<=0);
        
        do{
            System.out.print("Ingrese mes: "); //mes
            fecha[1] = reader.nextInt();
            if (fecha[1]>12 || fecha[1]<=0)
                System.out.println("Error: Ingrese un mes válido (1-12).");
        }while (fecha[1]>12 || fecha[1]<=0);
        
        do{
            System.out.print("Ingrese año: "); //año
            fecha[2] = reader.nextInt();
            if (fecha[2]<1915 || fecha[2]>=2021)
                System.out.println("Error: Ingrese un año válido (1916-2021).");
        }while (fecha[2]<1915 || fecha[2]>=2021);
        
        persona.setfIng(fecha);
    }
    
    
    
    /**
     *
     * @return
     */
    
    @Override
    public String toString(){
        return ""+super.toString()+"\n-Facultad: "+Facultad+"\n-Carrera: "+Carrera+"\n-Ingreso: "+fechaIngre[0]+"/"+fechaIngre[1]+"/"+fechaIngre[2];
    }
}

