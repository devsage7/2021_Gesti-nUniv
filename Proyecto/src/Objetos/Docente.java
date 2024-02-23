

package Objetos;
import java.util.ArrayList;       
import java.util.Scanner;


public class Docente extends PersUniv{
    
    private String Cargo;
    private ArrayList <String> Materias;
    
    public Docente(){
        super();
        Cargo = "Desconocido";
        Materias = new ArrayList<String>();
    }
    
    public Docente(String nom, String doc, String dir, int nac[], String fac, String carr, int ingre[], String carg, ArrayList<String> mate){
        super(nom,doc,dir,nac,fac,carr,ingre);
        Cargo = carg;
        Materias = new ArrayList<String>();
        Materias = mate;
    }
    
    public Docente(Docente d){
        super(d);
        Cargo = d.Cargo;
        Materias = d.Materias;
    }
    
    public String getCargo(){
        return Cargo;
    }
    
    public ArrayList<String> getMat(){
        return Materias;
    }
    
    public void setCargo(String carg){
        Cargo = carg;
    }
    
    public void addMat(int index, String materia){
        Materias.add(index,materia);
    }
    
    public void addMatFirst(String materia){
        Materias.add(0, materia);
    }
    
    public void delMat(String materia){
        int contador = 0;
        while (!Materias.isEmpty()){
            if (materia.equals(Materias.get(contador))){
                Materias.remove(contador);
                contador++;
            }
        }
    }
    
    public void delMat(int index){
        if (Materias.size()==index-1)
                Materias.remove(index);
    }
    
    public void showMats(){
        for(String m : Materias){
            System.out.println("-"+m+"\n");
        }
    }
    
    
    /**
     *
     * @return
     */
    
    @Override
    public String toString(){
        return ""+super.toString()+"\n-Cargo: "+Cargo+"\n-Materias que dicta: "+Materias.toString();
    }
    
    
}
    
    

