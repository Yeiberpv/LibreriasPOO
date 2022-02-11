import java.util.Collections;
import java.util.Scanner;

public class Main1 {


	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Boolean control =true ;
		Inventario inventario=new Inventario();
		do {
			System.out.println("");
			System.out.println("<1> Ingresar libro");
			System.out.println("<2> Buscar libro por el isnb");
			System.out.println("<3> venta de libro");
			System.out.println("<4> Mostrar los tres libros mas caros");
			System.out.println("<5> Mostrar todos los libros");
			System.out.println("<0> Salir del programa");
			System.out.println(" ");
			System.out.println("Ingrese opción: ");

		
			int numero = entrada.nextInt(); 
			
			if (numero == 1) {
				
				System.out.println("Ingrese el isbn: ");
				String isbn = entrada.next();
				
				System.out.println("Ingrese el titulo del libro: ");
				String titulo = entrada.next();
				
				System.out.println("Ingrese el precio: ");
				Double precio = entrada.nextDouble();
				
				System.out.println("Ingrese la cantidad: ");
				int cantidad = entrada.nextInt();
				
				inventario.almacenar(new Libro(isbn, titulo, precio, cantidad));
			}
			else if (numero == 2) {
				System.out.println("Introduce el isnb para buscar:");
				String isbn_buscado1 = entrada.next();
				if (inventario.getLibrobyIsbn(isbn_buscado1)==null) {
					System.out.println("Libro no encontrado");
				}
				else{
					System.out.println(inventario.getLibrobyIsbn(isbn_buscado1).toString());
				}
			}
			else if (numero == 3) {
				System.out.print("Que libro quieres: ");
				String isbn_buscado = entrada.next();
				if (inventario.getLibrobyIsbn(isbn_buscado)==null) {
					System.out.println("Libro no encontrado");
				}
				else {
					inventario.getLibrobyIsbn(isbn_buscado).setCantidad(inventario.getLibrobyIsbn(isbn_buscado).getCantidad()-1);
					System.out.println("Gracias a su compra nos quedan: " + inventario.getLibrobyIsbn(isbn_buscado).getCantidad() + " libros");
				}
				
			}
			else if (numero == 4) {
				Collections.sort(inventario.getLibros());
				
			}
			else if (numero == 5) {
				for(Libro l: inventario.getLibros()) {
					System.out.println(l.toString());
				}
			}
			else if (numero == 6) {
				System.out.println("Se termino el programa");
				control=false;
			}
			else {
				System.out.println("No se introdujo un valor correcto intente otra vez");
			}
		}
		while (control);

		
	}
}