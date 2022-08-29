package personas;

import java.util.*;


public class ClsListaPersonas {
    //atribbutos
    Vector ClsListaPersonas;
    
    //constructor
    public ClsListaPersonas(){
        ClsListaPersonas = new Vector();
    
    }
    
    //metodos
    public void añadirPersonas(ClsPeronsa P){
        ClsListaPersonas.add(P);
    }
    
    public void eliminarPeronas(int i){
       ClsListaPersonas.removeElement(i);
    }
    
    public void borraLista(){
        ClsListaPersonas.removeAllElements();
    }

    void borrarLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
