
package ejemplos;

public class clsPlaneta {
    
// atributos
    String nombre = null;
    int cantidadSatelites = 0;
    double masa = 0;
    double volumen = 0;
    int diametro = 0;
    int distanciaSol = 0;
    enum tipoPlaneta {Gaseoso, Terrestre, Enano}
    tipoPlaneta tipo;
    boolean esObservable = false;
    
// constructor
    clsPlaneta(String nombre, int cantidadSatelites, double masa, double volumen, int diametro, int distanciaSol, tipoPlaneta tipo, boolean esObservable){
        this.nombre = nombre;
        this.cantidadSatelites = cantidadSatelites;
        this.masa = masa;
        this.volumen = volumen;
        this.diametro = diametro;
        this.distanciaSol = distanciaSol;
        this.tipo = tipo;
        this.esObservable = esObservable;
    }

// metodos
    //imprime los datos
    void imprimir (){
        System.out.println("Nombre del Planeta: " + nombre);
        System.out.println("Cantidad de satélites: " + cantidadSatelites);
        System.out.println("Masa del Planeta: " + masa);
        System.out.println("Volumen del Planeta: " + volumen);
        System.out.println("Diametro del Planeta: " + diametro);
        System.out.println("Distancia al Sol: " + distanciaSol);
        System.out.println("Tipo Planeta: " + tipo);
        System.out.println("Es Observable: " + esObservable);
    }
    
    //calculos
    double calculaDensidad(){
        return masa/volumen;
    }
    
    //planeta exterior
    boolean esPlanetaExterior(){
        float limite = (float)(149597870 * 3.4);
            if(distanciaSol > limite){
                return true;
            }else{
                return false;
            }
    }
    
    //metodo main
    public static void main (String arg[]){
        clsPlaneta P1 = new clsPlaneta ("Tierra", 1, 5.9736E24, 1.08321E12, 12742, 150000000, tipoPlaneta.Terrestre, true);
        P1.imprimir();
            System.out.println("Densidad del Planeta: " + P1.calculaDensidad());
            System.out.println("Es planeta exterior: " + P1.esPlanetaExterior());
            System.out.println();
    }
}
