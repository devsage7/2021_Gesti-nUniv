
package Objetos;
import java.util.Scanner;


public class Persona {
    private static int fechas = 3;
    private String Nbre;
    private String NroDoc;
    private String Direccion;
    private int[] fechaNac;
    
    public Persona(){
        Nbre = "Desconocido";
        NroDoc = "Desconocido";
        Direccion = "Desconocido";
        fechaNac = new int [3];
    }
    
    public Persona(String nom,String doc,String dir,int fec[]){
        Nbre = nom;
        NroDoc = doc;
        Direccion = dir;
        fechaNac = new int [3];
        fechaNac[0] = fec[0];
        fechaNac[1] = fec[1];
        fechaNac[2] = fec[2];
    }
    
    public Persona(Persona p){
        Nbre = p.Nbre;
        NroDoc = p.NroDoc;
        Direccion = p.Direccion;
        fechaNac = new int [3];
        fechaNac[0] = p.fechaNac[0];
        fechaNac[1] = p.fechaNac[1];
        fechaNac[2] = p.fechaNac[2];
    }
    
    public String getNbre(){
        return Nbre;
    }
    
    public String getDoc(){
        return NroDoc;
    }
    
    public String getDir(){
        return Direccion;
    }
    
    public int[] getfNac(){
        return fechaNac;
    }
    
    public void setNbre(String nom){
        Nbre = nom;
    }
    
    public void setDoc(String doc){
        NroDoc = doc;
    }
    
    public void setDir(String dir){
        Direccion = dir;
    }
    
    public void setfNac(int[] fec){
        fechaNac[0] = fec[0];
        fechaNac[1] = fec[1];
        fechaNac[2] = fec[2];
    }
    
    public void register(Persona persona){
        String elem = new String();
        Scanner reader = new Scanner(System.in);
        
        
        System.out.print("Ingrese nombre: "); //NOMBRE
        elem = reader.nextLine();
        persona.setNbre(elem);
       
        
        System.out.print("Ingrese nro. de documento: "); //DOCUMENTO
        elem = reader.next();
        persona.setDoc(elem);
        
        
        System.out.print("Ingrese dirección: "); //DIRECCIÓN
        elem = reader.nextLine();
        elem = reader.nextLine();
        persona.setDir(elem);
        
        
        System.out.println("(Fecha de nacimiento)"); //FECHA DE NACIMIENTO
        int [] fecha = new int [3];
        do{
            System.out.print("Ingrese día: "); //dia
            fecha[0] = reader.nextInt();
            if (fecha[0]>31 || fecha[0]<=0)
                System.out.println("Error: Ingrese un día válido (1-31).");
        }while (fecha[0]>31 || fecha[0]<=0);
        
        do{
            reader.nextLine();
            System.out.print("Ingrese mes: "); //mes
            fecha[1] = reader.nextInt();
            if (fecha[1]>12 || fecha[1]<=0)
                System.out.println("Error: Ingrese un mes válido (1-12).");
        }while (fecha[1]>12 || fecha[1]<=0);
        
        do{
            reader.nextLine();
            System.out.print("Ingrese año: "); //año
            fecha[2] = reader.nextInt();
            if (fecha[2]<1915 || fecha[2]>=2021)
                System.out.println("Error: Ingrese un año válido (1916-2021).");
        }while (fecha[2]<1915 || fecha[2]>=2021);
        persona.setfNac(fecha);
    }
    
    /**
     *
     * @return
     */
    
    @Override
    public String toString(){
        String aux;
        aux = ""+fechaNac[0]+"/"+fechaNac[1]+"/"+fechaNac[2];
        return "\n-Nombre: " + Nbre + "\n-Nro. Documento: " + NroDoc + "\n-Direccion: " + Direccion + "\n-Fecha de nacimiento: " + aux;
    }
}
