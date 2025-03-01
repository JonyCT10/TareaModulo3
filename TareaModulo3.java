
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Libro {
    
    public String titulo,autor,genero;
    public int anio_publi;
    public boolean disponi;
    
    public Libro(String titulo,String autor,int anio_publi,String genero,boolean disponi){
        this.titulo=titulo;
        this.autor=autor;
        this.anio_publi=anio_publi;
        this.genero=genero;
        this.disponi=disponi;
    }
    
    public static void main(String[] args) {
        
        Biblioteca biblioteca=new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        boolean ejecutar=true;
        
        while (ejecutar){
        
        System.out.println("Seleccione una opcion");
            System.out.println("1. Agregar libro");
            System.out.println("2. Mostrar libros");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion){
            
                    case 1:
                    // Agregar libro
                    System.out.print("Ingrese el título: ");
                    String titulo = scanner.nextLine();
                    
                    System.out.print("Ingrese el autor: ");
                    String autor = scanner.nextLine();
                    
                    System.out.print("Ingrese el año de publicación: ");
                    int anio_publi = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Ingrese el género: ");
                    String genero = scanner.nextLine();

                    biblioteca.agregar(titulo, autor, anio_publi, genero, true);
                    break;
                    
                case 2:
                    biblioteca.mostrar_libros();
                    break;
                    
                case 3:
                    System.out.print("Ingrese el título del libro a prestar: ");
                    String tituloPrestar = scanner.nextLine();
                    biblioteca.prestar_libro(tituloPrestar);
                    break;
                    
                case 4:
                    
                    System.out.print("Ingrese el título del libro a devolver: ");
                    String tituloDevolver = scanner.nextLine();
                    biblioteca.devolver_libro(tituloDevolver);
                    break;
                    
                case 5:
         
                    System.out.println("Saliendo");
                    ejecutar = false;
                    break;
                    
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
    }
    }
}

class Biblioteca{
    
    private List<Libro> libros= new ArrayList<>();
    
    public void agregar(String titulo,String autor,int anio_publi,String genero,boolean disponi){
        Libro lib= new Libro(titulo,autor,anio_publi,genero,disponi);
        libros.add(lib);
        System.out.println("Libro agregado: " + titulo );
    }
    
    public boolean prestar_libro(String titulo){
        for(Libro libro:libros){
             if(libro.titulo.equalsIgnoreCase(titulo)){
                 if(libro.disponi){
                libro.disponi=false;
                System.out.println("Libro prestado "+libro.titulo);
                return true;
                 }else {
                System.out.println("El libro no esta disponible");
                return false;
                 }
             }
        }
        System.out.println("El libro no fue encontrado");
        return false;
    }
    
    
    public boolean devolver_libro(String titulo) {
    for (Libro libro : libros) {
        if (libro.titulo.equalsIgnoreCase(titulo)) {
            if (libro.disponi==false){
                libro.disponi = true;
                System.out.println("Libro devuelto: " + libro.titulo);
                return true;
            } else {
                System.out.println("El libro ya estaba disponible.");
                return false;
            }
        }
    }
    System.out.println("El libro no fue encontrado.");
    return false;
}
    
    
    public void mostrar_libros() {
    if (libros.isEmpty()) {
        System.out.println("No hay libros en la biblioteca.");
        return;
    }
    System.out.println("Lista de libros:");
    for (Libro libro : libros) {
        System.out.println(libro.titulo + ", " + libro.autor + ", " + 
                           libro.anio_publi + ", " + libro.genero);
    }
}
    
}
