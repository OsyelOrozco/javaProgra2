package ejemplos;

public class clsPersona {
    //atributos
    String nombre;
    String apellido;
    String dpi;
    int añoNacimiento;
    
    //constructor
    clsPersona(String nombre, String apellido, String dpi, int añoNacimiento){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dpi = dpi;
        this.añoNacimiento = añoNacimiento;
    }
    
    //metodos
        //metodo mostrar
    void mostrar(){
        System.out.println("Nombre = " + nombre);
        System.out.println("Apellido = " + apellido);
        System.out.println("DPI = " + dpi);
        System.out.println("Año Nacimiento = " + añoNacimiento);
        System.out.println();
    }
    
        //metodo main
    public static void main (String args[]){
       clsPersona persona1 = new clsPersona("Luis", "Perez", "25678090989", 2005);
       clsPersona persona2 = new clsPersona("Karla", "Hernandez", "00000000001", 2008);
       persona1.mostrar();
       persona2.mostrar();
    }
}
